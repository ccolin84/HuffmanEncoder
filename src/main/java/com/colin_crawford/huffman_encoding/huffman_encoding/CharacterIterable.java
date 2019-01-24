package com.colin_crawford.huffman_encoding.huffman_encoding;

import java.util.ArrayList;
import java.util.List;

public class CharacterIterable {
	public static Iterable<Character> of(String str) {
		List<Character> chars = new ArrayList<>(str.length());
		for (Character c : str.toCharArray()) {
			chars.add(c);
		}
		return chars;
	}

	public static String toString(Iterable<Character> chars) {
		StringBuilder sb = new StringBuilder();
		chars.forEach(sb::append);
		return sb.toString();
	}
}
