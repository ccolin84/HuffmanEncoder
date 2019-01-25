package com.colin_crawford.huffman_encoding.huffman_encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HuffmanNodeTest {

	@Test
	void compareTo_GivenAnEqualFrequencyNode_ReturnsZero() {
		HuffmanNode node = new HuffmanNode(5);

		int comparisonEqual = node.compareTo(node);

		assertEquals(comparisonEqual, 0);
	}

	@Test
	void compareTo_GivenALargerFrequencyNode_ReturnsANumberGreaterThanZero() {
		int biggerNumber = 10;
		int smallerNumber = 5;
		HuffmanNode biggerNode = new HuffmanNode(biggerNumber);
		HuffmanNode smallerNode = new HuffmanNode(smallerNumber);

		int comparisonSmaller = smallerNode.compareTo(biggerNode);

		assertTrue(comparisonSmaller < 0);
	}

	@Test
	void compareTo_GivenASmallerlFrequencyNode_ReturnsANumberLessThanZero() {
		int biggerNumber = 10;
		int smallerNumber = 5;
		HuffmanNode biggerNode = new HuffmanNode(biggerNumber);
		HuffmanNode smallerNode = new HuffmanNode(smallerNumber);

		int comparisonBigger = biggerNode.compareTo(smallerNode);

		assertTrue(comparisonBigger > 0);
	}
}
