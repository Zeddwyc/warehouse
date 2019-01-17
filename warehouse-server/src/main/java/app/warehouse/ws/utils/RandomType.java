package app.warehouse.ws.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RandomType {
	NUMERIC("0123456789"), 
	ALPHA_NUMERIC("0123456789ABCDEFGHIJKLMNOPQRSTUVWYZabcdefghijklmnopqrstuvwyz"), 
	ALPHA_NUMERIC_LOWER("0123456789abcdefghijklmnopqrstuvwyz"), 
	ALPHA_NUMERIC_UPPER("0123456789ABCDEFGHIJKLMNOPQRSTUVWYZ"), 
	ALPHA("ABCDEFGHIJKLMNOPQRSTUVWYZabcdefghijklmnopqrstuvwyz"),
	ALPHA_LOWER("abcdefghijklmnopqrstuvwyz"),
	ALPHA_UPPER("ABCDEFGHIJKLMNOPQRSTUVWYZ");

	private String chars;
}