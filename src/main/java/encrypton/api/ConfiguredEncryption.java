package main.java.encrypton.api;

/**
 * @author Luke Tonon
 */
public final class ConfiguredEncryption<C extends EncryptionConfig<?>, E extends Encryption<C>> {
	private final E encryption;
	private final C config;
	
	public ConfiguredEncryption(E encryption, C config) {
		this.encryption = encryption;
		this.config = config;
	}
	
	public String encrypt(String string) {
		return this.encryption.encrypt(string, this.config);
	}
	
	public String decrypt(String string) {
		return this.encryption.decrypt(string, this.config);
	}
}