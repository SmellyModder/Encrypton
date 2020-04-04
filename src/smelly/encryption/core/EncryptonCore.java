package smelly.encryption.core;

import smelly.encryption.encryptions.configs.ModuloConfig;

/**
 * This class will be used for other things later, for now it's just for test prints
 */
public class EncryptonCore {

	public static void main(String[] args) {
		String message = "Smelly is here";
		ModuloConfig config = new ModuloConfig(8);
		String encryptedMessage = Encryptions.SHIFTNACCI.withConfiguration(config).encrypt(message);
		String decryptedMessage = Encryptions.SHIFTNACCI.withConfiguration(config).decrypt(encryptedMessage);
		System.out.println(encryptedMessage);
		System.out.println(decryptedMessage);
	}
	
}