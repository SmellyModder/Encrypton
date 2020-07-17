package main.java.encrypton.core.encryptions.configs;

import java.util.Random;

import main.java.encrypton.api.ConfigRandomizer;
import main.java.encrypton.api.EncryptionConfig;

/**
 * @author Luke Tonon
 */
public class IntegerConfig implements EncryptionConfig<IntegerConfig> {
	public final int value;
	
	public IntegerConfig(int value) {
		this.value = value;
	}

	@Override
	public IntegerConfig random(Random rand, ConfigRandomizer<IntegerConfig> randomizer) {
		return randomizer.randomize(rand);
	}
	
	public static class IntegerConfigRandomizer extends ConfigRandomizer<IntegerConfig> {
		private final int min, max;
		
		public IntegerConfigRandomizer(int min, int max) {
			this.min = min;
			this.max = max;
		}
		
		public static IntegerConfig randomize(Random rand, int min, int max) {
			return new IntegerConfigRandomizer(min, max).randomize(rand);
		}

		@Override
		public IntegerConfig randomize(Random rand) {
			return new IntegerConfig(rand.nextInt(this.max - this.min) + this.min);
		}
	}
}