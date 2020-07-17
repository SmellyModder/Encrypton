package main.java.encrypton.api;

import java.util.Random;

/**
 * @author Luke Tonon
 */
public abstract class ConfigRandomizer<T> {
	public abstract T randomize(Random rand);
}