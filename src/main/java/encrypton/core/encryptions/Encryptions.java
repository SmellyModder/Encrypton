package main.java.encrypton.core.encryptions;

import main.java.encrypton.api.Encryption;
import main.java.encrypton.api.EncryptionRegistry;
import main.java.encrypton.core.encryptions.configs.*;

/**
 * @author Luke Tonon
 */
public class Encryptions {
	private static final EncryptionRegistry REGISTRY = new EncryptionRegistry("encrypton");
	
	public static final Encryption<IntegerConfig> SHIFTNACCI = REGISTRY.registerEncryption("shiftnacci", new ShiftnacciEncryption<>());
	public static final Encryption<IntegerConfig> PLUS = REGISTRY.registerEncryption("plus", new PlusEncryption<>());
}