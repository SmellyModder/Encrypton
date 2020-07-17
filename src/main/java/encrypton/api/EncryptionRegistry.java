package main.java.encrypton.api;

import main.java.encrypton.core.EncryptonCore;

/**
 * @author Luke Tonon
 */
public class EncryptionRegistry {
	private final String id;
	
	public EncryptionRegistry(String id) {
		this.id = id;
	}
	
	public <C extends EncryptionConfig<?>> Encryption<C> registerEncryption(String registryName, Encryption<C> encryption) {
		EncryptonCore.ENCRYPTIONS.put(this.id + ":" + registryName, encryption);
		return encryption;
	}
	
	public String getId() {
		return this.id;
	}
}