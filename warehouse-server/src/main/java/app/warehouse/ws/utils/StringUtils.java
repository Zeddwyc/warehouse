package app.warehouse.ws.utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class StringUtils {

	private final Random RANDOM = new SecureRandom();

	public String generate(int length, RandomType type) {
		if (length <= 0 || length >= 50) {
			length = 30;
		}
		return generateRandomString(length, type);
	}

	private String generateRandomString(int length, RandomType type) {
		StringBuilder builder = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			builder.append(type.getChars().charAt(RANDOM.nextInt(type.getChars().length())));
		}

		return new String(builder);
	}
	
	public String generateUUIDString() {
		return UUID.randomUUID().toString();
	}
}
