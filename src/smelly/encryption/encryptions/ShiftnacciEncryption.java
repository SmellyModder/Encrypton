package smelly.encryption.encryptions;

import smelly.encryption.api.Encryption;
import smelly.encryption.encryptions.configs.ModuloConfig;

/**
 * @author Luke Tonon
 */
public class ShiftnacciEncryption<M extends ModuloConfig> extends Encryption<M> {
	
	@Override
	public String encrypt(String message, M config) {
		char[] charsInString = message.toCharArray();
	        
		for(int i = 0; i < charsInString.length; i++) {
			char charAt = charsInString[i];
			if(charAt != ' ') {
				charsInString[i] = (char) (charAt << (getFibonacciValue(i) % config.modulo));
			}
		}
		return new String(charsInString);
	}

	@Override
	public String decrypt(String message, M config) {
		char[] charsInString = message.toCharArray();
        
		for(int i = 0; i < charsInString.length; i++) {
			char charAt = charsInString[i];
			if(charAt != ' ') {
				charsInString[i] = (char) (charAt >> (getFibonacciValue(i) % config.modulo));
			}
		}
		return new String(charsInString);
	}
    
	private static int getFibonacciValue(int index) {
		if(index <= 1) return index; 
		return getFibonacciValue(index - 1) + getFibonacciValue(index - 2);
	}

}