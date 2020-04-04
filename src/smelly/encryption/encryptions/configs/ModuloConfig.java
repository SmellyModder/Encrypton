package smelly.encryption.encryptions.configs;

import smelly.encryption.api.EncryptionConfig;

/**
 * @author Luke Tonon
 */
public class ModuloConfig implements EncryptionConfig {
	public final int modulo;
	
	public ModuloConfig(int modulo) {
		this.modulo = modulo;
	}
}