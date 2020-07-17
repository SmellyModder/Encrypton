package main.java.encrypton.core.encryptions;

import main.java.encrypton.api.Encryption;
import main.java.encrypton.core.encryptions.configs.IntegerConfig;

/**
 * @author Luke Tonon
 * 
 * @param <IC> - The generic {@link IntegerConfig}
 */
public class ShiftnacciEncryption<IC extends IntegerConfig> extends Encryption<IC> {
	
	@Override
	public String encrypt(String message, IC config) {
		char[] charsInString = message.toCharArray();
	        
		for(int i = 0; i < charsInString.length; i++) {
			char charAt = charsInString[i];
			if(charAt != ' ') {
				charsInString[i] = (char) (charAt << (getFibonacciValue(i) % config.value));
			}
		}
		return new String(charsInString);
	}

	@Override
	public String decrypt(String message, IC config) {
		char[] charsInString = message.toCharArray();
        
		for(int i = 0; i < charsInString.length; i++) {
			char charAt = charsInString[i];
			if(charAt != ' ') {
				charsInString[i] = (char) (charAt >> (getFibonacciValue(i) % config.value));
			}
		}
		return new String(charsInString);
	}
    
	private static int getFibonacciValue(int index) {
		if(index <= 1) return index; 
		return getFibonacciValue(index - 1) + getFibonacciValue(index - 2);
	}

}