package smelly.encryption.core;

import java.util.HashMap;
import java.util.Map;

import smelly.encryption.api.Encryption;
import smelly.encryption.api.EncryptionConfig;
import smelly.encryption.encryptions.ShiftnacciEncryption;
import smelly.encryption.encryptions.configs.ModuloConfig;

/**
 * @author Luke Tonon
 */
public class Encryptions {
	private static final Map<String, Encryption<?>> ENCRYPTIONS = new HashMap<String, Encryption<?>>();
	
	public static final Encryption<ModuloConfig> SHIFTNACCI = registerEncryption("shiftnacci", new ShiftnacciEncryption<ModuloConfig>());

	private static <C extends EncryptionConfig> Encryption<C> registerEncryption(String name, Encryption<C> encryption) {
		ENCRYPTIONS.put(name, encryption);
		return encryption;
	}
}