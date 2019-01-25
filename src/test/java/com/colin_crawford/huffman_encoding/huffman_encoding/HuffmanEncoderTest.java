package com.colin_crawford.huffman_encoding.huffman_encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

class HuffmanEncoderTest {

	@Test
	void constructor_GivenAnEmptyString_ItShouldntEncodeAnyChars() {
		String message = "";
		HuffmanEncoder encoder = new HuffmanEncoder(message);

		Map<Character, String> codes = encoder.getCharEncodings();

		assertEquals(0, codes.size());
	}

	@Test
	void constructor_GivenASingleCharString_ItShouldEncodeThatChar() {
		String message = "a";
		HuffmanEncoder encoder = new HuffmanEncoder(message);

		Map<Character, String> codes = encoder.getCharEncodings();

		assertEquals(1, codes.size());
		assertTrue(codes.containsKey('a'));
		assertTrue(codes.containsValue(""));
	}

	@Test
	void constructor_GivenATwoCharString_ItShouldEncodeThoseChars() {
		String message = "abb";
		HuffmanEncoder encoder = new HuffmanEncoder(message);

		Map<Character, String> codes = encoder.getCharEncodings();

		assertEquals(2, codes.size());
		assertTrue(codes.containsKey('a'));
		assertTrue(codes.containsKey('b'));
		assertEquals("0", codes.get('b'));
		assertEquals("1", codes.get('a'));
	}

	@Test
	void constructor_GivenAThreeCharString_ItShouldEncodeThoseChars() {
		String message = "acbcbc";
		HuffmanEncoder encoder = new HuffmanEncoder(message);

		Map<Character, String> codes = encoder.getCharEncodings();

		assertEquals(3, codes.size());
		assertTrue(codes.containsKey('a'));
		assertTrue(codes.containsKey('b'));
		assertTrue(codes.containsKey('c'));
		assertEquals("1", codes.get('c'));
		assertEquals("00", codes.get('b'));
		assertEquals("01", codes.get('a'));
	}

	@Test
	void constructor_GivenAFourCharString_ItShouldEncodeThoseChars() {
		String message = "abbccccddddd";
		HuffmanEncoder encoder = new HuffmanEncoder(message);

		Map<Character, String> codes = encoder.getCharEncodings();

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

	@Test
	void constructor_GivenAnEmptyString_ItShouldProduceAnEmptyEncodedMessage() {
		String message = "";
		HuffmanEncoder encoder = new HuffmanEncoder(message);

		String encodedMessage = encoder.getEncodedMessage();

		assertEquals("", encodedMessage);
	}

	@Test
	void constructor_GivenASingleCharString_ItShouldProduceAnEmptyEncodedMessage() {
		String message = "aaaa";
		HuffmanEncoder encoder = new HuffmanEncoder(message);

		String encodedMessage = encoder.getEncodedMessage();

		assertEquals("", encodedMessage);
	}

	@Test
	void constructor_GivenANonEmptyString_ItShouldProduceAnEncodedMessage() {
		String message = "abababa";
		HuffmanEncoder encoder = new HuffmanEncoder(message);

		Map<Character, String> codes = encoder.getCharEncodings();
		String encodedMessage = encoder.getEncodedMessage();
		StringBuilder sb = new StringBuilder();
		CharacterIterable.of(message).forEach(c -> sb.append(codes.get(c)));
		String expectedMessage = sb.toString();

		assertEquals(expectedMessage, encodedMessage);
	}
}
