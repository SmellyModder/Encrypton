package main.java.encrypton.api;

import java.util.Random;

import main.java.encrypton.core.encryptions.configs.EmptyConfig;

/**
 * @author Luke Tonon
 */
public interface EncryptionConfig<T> {
	public static final EmptyConfig EMPTY = new EmptyConfig();
	
	public T random(Random rand, ConfigRandomizer<T> randomizer);
}