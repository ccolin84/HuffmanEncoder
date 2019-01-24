package com.colin_crawford.huffman_encoding.huffman_encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HuffmanCombinedNodeTest {

	@Test
	void testConstructor() {
		HuffmanNode first = new HuffmanValueNode(5, 'c');
		HuffmanNode second = new HuffmanValueNode(20, 'b');

		HuffmanCombinedNode combined = new HuffmanCombinedNode(first, second);

		assertEquals(25, combined.getFrequency());
	}

}
