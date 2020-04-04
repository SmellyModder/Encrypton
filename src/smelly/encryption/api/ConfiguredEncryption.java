package smelly.encryption.api;

/**
 * @author Luke Tonon
 */
public class ConfiguredEncryption<C extends EncryptionConfig, E extends Encryption<C>> {
	private final E encryption;
	private final C config;
	
	public ConfiguredEncryption(E encryption, C config) {
		this.encryption = encryption;
		this.config = config;
	}
	
	public String encrypt(String message) {
		return this.encryption.encrypt(message, this.config);
	}
	
	public String decrypt(String message) {
		return this.encryption.decrypt(message, this.config);
	}
}