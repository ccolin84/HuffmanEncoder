package com.colin_crawford.huffman_encoding.huffman_encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HuffmanNodeTest {

	@Test
	void testCompareTo() {
		int biggerNumber = 10;
		int smallerNumber = 5;
		HuffmanNode biggerNode = new HuffmanNode(biggerNumber);
		HuffmanNode smallerNode = new HuffmanNode(smallerNumber);

		int comparisonBigger = biggerNode.compareTo(smallerNode);
		int comparisonSmaller = smallerNode.compareTo(biggerNode);
		int comparisonEqual = biggerNode.compareTo(biggerNode);

		assertTrue(comparisonBigger > 0);
		assertTrue(comparisonSmaller < 0);
		assertEquals(comparisonEqual, 0);
	}

}
