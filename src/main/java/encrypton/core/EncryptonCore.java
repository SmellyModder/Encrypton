package main.java.encrypton.core;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import main.java.encrypton.api.Encryption;
import main.java.encrypton.api.LayeredEncryption;
import main.java.encrypton.core.encryptions.Encryptions;
import main.java.encrypton.core.encryptions.configs.IntegerConfig;

/**
 * @author Luke Tonon 
 */
public final class EncryptonCore {
	public static final Map<String, Encryption<?>> ENCRYPTIONS = new HashMap<>();
	public static final Logger LOGGER = Logger.getLogger(EncryptonCore.class.getName());
	private static boolean ENABLED = false;
	
	public static void main(String[] args) {
		if (!ENABLED) return;
		String message = "Hello world!";
		for (int i = 0; i < 100; i++) {
			LayeredEncryption layeredEncryption = new LayeredEncryption(2).layerRandomly(Encryptions.PLUS, new IntegerConfig.IntegerConfigRandomizer(0, 10)).layerRandomly(Encryptions.PLUS, new IntegerConfig.IntegerConfigRandomizer(0, 20)).layerRandomly(Encryptions.SHIFTNACCI, new IntegerConfig.IntegerConfigRandomizer(1, 5));
			String encryptedMessage = layeredEncryption.encrypt(message);
			String decryptedMessage = layeredEncryption.decrypt(encryptedMessage);
			System.out.println("Encrypted: " + encryptedMessage);
			System.out.println("Decryped: " + decryptedMessage);
		}
	}
}