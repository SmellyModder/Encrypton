package smelly.encryption.api;

/**
 * @author Luke Tonon
 */
public abstract class Encryption<C extends EncryptionConfig> {
	public abstract String encrypt(String message, C config);
	
	public abstract String decrypt(String message, C config);
	
	public ConfiguredEncryption<C, ? extends Encryption<C>> withConfiguration(C config) {
		return new ConfiguredEncryption<>(this, config);
	}
}