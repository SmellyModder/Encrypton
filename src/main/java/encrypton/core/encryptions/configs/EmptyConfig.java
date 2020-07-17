package main.java.encrypton.core.encryptions.configs;

import java.util.Random;

import main.java.encrypton.api.ConfigRandomizer;
import main.java.encrypton.api.EncryptionConfig;

/**
 * @author Luke Tonon
 */
public class EmptyConfig implements EncryptionConfig<EmptyConfig> {

	@Override
	public EmptyConfig random(Random rand, ConfigRandomizer<EmptyConfig> randomizer) {
		return EncryptionConfig.EMPTY;
	}
	
}