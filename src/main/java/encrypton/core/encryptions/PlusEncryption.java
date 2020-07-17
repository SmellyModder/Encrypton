package main.java.encrypton.core.encryptions;

import main.java.encrypton.api.Encryption;
import main.java.encrypton.core.encryptions.configs.IntegerConfig;

/**
 * @author Luke Tonon
 *
 * @param <IC> - The generic {@link IntegerConfig}
 */
public class PlusEncryption<IC extends IntegerConfig> extends Encryption<IC> {

	@Override
	public String encrypt(String message, IC config) {
		char[] charsInString = message.toCharArray();
		
		for (int i = 0; i < charsInString.length; i++) {
			charsInString[i] = (char) (charsInString[i] + config.value);
		}
		return new String(charsInString);
	}

	@Override
	public String decrypt(String message, IC config) {
		char[] charsInString = message.toCharArray();
		
		for (int i = 0; i < charsInString.length; i++) {
			charsInString[i] = (char) (charsInString[i] - config.value);
		}
		return new String(charsInString);
	}

}