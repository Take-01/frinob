package xyz.frinob.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

public class SaftyPassword {

	private static final String ALGORITHM = "SHA-256";
	private static final int STRETCH_COUNT = 1000;

	public String getPasswordHash(String password, String salt) {

		byte[] hashedSalt = DigestUtils.sha256(salt);
		byte[] hashedPassword = DigestUtils.sha256(password);

		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		messageDigest.update(hashedSalt);
		byte[] digest = messageDigest.digest(hashedPassword);
		for(int i = 0;i < STRETCH_COUNT;i++) {
			digest = messageDigest.digest(digest);
		}

		String hash = DigestUtils.sha256Hex(digest);

		return hash;
	}

}
