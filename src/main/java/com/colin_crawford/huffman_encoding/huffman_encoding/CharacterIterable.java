package com.colin_crawford.huffman_encoding.huffman_encoding;

import java.util.ArrayList;
import java.util.List;

public class CharacterIterable {
	public static Iterable<Character> of(String str) {
		if (str == null) {
			throw new IllegalArgumentException("chars cannot be null");
		}

		List<Character> chars = new ArrayList<>(str.length());
		for (Character c : str.toCharArray()) {
			chars.add(c);
		}
		return chars;
	}

	public static String toString(Iterable<Character> chars) {
		if (chars == null) {
			throw new IllegalArgumentException("chars cannot be null");
		}

		StringBuilder sb = new StringBuilder();
		chars.forEach(sb::append);
		return sb.toString();
	}
}
