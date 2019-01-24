package com.colin_crawford.huffman_encoding.huffman_encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CharacterIterableTest {

	@Test
	void toString_GivenEmptyIterable_ReturnsEmptyString() {
		Iterable<Character> chars = new ArrayList<>();

		String str = CharacterIterable.toString(chars);

		assertEquals(0, str.length());
	}

	@Test
	void toString_GivenNonEmptyIterable_ReturnsAStringWithItsChars() {
		Iterable<Character> chars = List.of('a', 'b', 'c', 'd');

		String str = CharacterIterable.toString(chars);

		assertEquals("abcd", str);
	}

	@Test
	void of_GivenEmptyString_ReturnsEmptyIterable() {
		String message = "";

		Iterable<Character> chars = CharacterIterable.of(message);

		assertEquals("", CharacterIterable.toString(chars));
	}

	@Test
	void of_GivenNonEmptyString_ReturnsAnIterableOfTheStringsChars() {
		String message = "abcd";

		Iterable<Character> chars = CharacterIterable.of(message);

		assertEquals("abcd", CharacterIterable.toString(chars));
	}
}
