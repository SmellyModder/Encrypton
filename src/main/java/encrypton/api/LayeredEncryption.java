package main.java.encrypton.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Luke Tonon
 */
public final class LayeredEncryption {
	private final List<ConfiguredEncryption<?, ?>> encryptions;
	private final Random random;
	
	public LayeredEncryption(int maxSize) {
		this(new Random(), maxSize);
	}
	
	public LayeredEncryption(Random rand, int maxSize) {
		this.encryptions = new ArrayList<>(maxSize);
		this.random = rand;
	}
	
	public <C extends EncryptionConfig<?>> LayeredEncryption layer(Collection<ConfiguredEncryption<C, ? extends Encryption<C>>> encryptions) {
		this.encryptions.addAll(encryptions);
		return this;
	}
	
	public <C extends EncryptionConfig<?>> LayeredEncryption layer(ConfiguredEncryption<C, ? extends Encryption<C>> encryption) {
		this.encryptions.add(encryption);
		return this;
	}
	
	public <C extends EncryptionConfig<?>> LayeredEncryption layerRandomly(Collection<Pair<Encryption<C>, ConfigRandomizer<C>>> randomizePairs) {
		randomizePairs.forEach(pair -> {
			this.encryptions.add(new ConfiguredEncryption<>(pair.getLeft(), pair.getRight().randomize(this.random)));
		});
		return this;
	}
	
	public <C extends EncryptionConfig<?>> LayeredEncryption layerRandomly(Encryption<C> encryption, ConfigRandomizer<C> randomizer) {
		this.encryptions.add(new ConfiguredEncryption<>(encryption, randomizer.randomize(this.random)));
		return this;
	}
	
	public String encrypt(String string) {
		for (ConfiguredEncryption<?, ?> encryption : this.encryptions) {
			string = encryption.encrypt(string);
		}
		return string;
	}
	
	public String decrypt(String string) {
		List<ConfiguredEncryption<?, ?>> copy = this.encryptions;
		Collections.reverse(copy);
		for (ConfiguredEncryption<?, ?> encryption : copy) {
			string = encryption.decrypt(string);
		}
		return string;
	}
}