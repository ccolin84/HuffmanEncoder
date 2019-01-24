package com.colin_crawford.huffman_encoding.huffman_encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

class HuffmanEncoderTest {

	@Test
	void testEncodeEmptyMessage() {
		String message = "";
		HuffmanEncoder encoder = new HuffmanEncoder();

		Map<Character, String> codes = encoder.encode(message);

		assertEquals(0, codes.size());
	}

	@Test
	void testEncodeOneCharacterMessage() {
		String message = "a";
		HuffmanEncoder encoder = new HuffmanEncoder();

		Map<Character, String> codes = encoder.encode(message);

		assertEquals(1, codes.size());
		assertTrue(codes.containsKey('a'));
		assertTrue(codes.containsValue(""));
	}

	@Test
	void testEncodeTwoCharacterMessage() {
		String message = "abb";
		HuffmanEncoder encoder = new HuffmanEncoder();

		Map<Character, String> codes = encoder.encode(message);

		assertEquals(2, codes.size());
		assertTrue(codes.containsKey('a'));
		assertTrue(codes.containsKey('b'));
		assertEquals("0", codes.get('b'));
		assertEquals("1", codes.get('a'));
	}

	@Test
	void testEncodeThreeCharacterMessage() {
		String message = "acbcbc";
		HuffmanEncoder encoder = new HuffmanEncoder();

		Map<Character, String> codes = encoder.encode(message);

		assertEquals(3, codes.size());
		assertTrue(codes.containsKey('a'));
		assertTrue(codes.containsKey('b'));
		assertTrue(codes.containsKey('c'));
		assertEquals("1", codes.get('c'));
		assertEquals("00", codes.get('b'));
		assertEquals("01", codes.get('a'));
	}

	@Test
	void testEncodeFourCharacterMessage() {
		String message = "abbccccddddd";
		HuffmanEncoder encoder = new HuffmanEncoder();

		Map<Character, String> codes = encoder.encode(message);

		assertEquals(4, codes.size());
		assertTrue(codes.containsKey('a'));
		assertTrue(codes.containsKey('b'));
		assertTrue(codes.containsKey('c'));
		assertTrue(codes.containsKey('d'));
		assertEquals("1", codes.get('d'));
		assertEquals("00", codes.get('c'));
		assertEquals("010", codes.get('b'));
		assertEquals("011", codes.get('a'));
	}
}
