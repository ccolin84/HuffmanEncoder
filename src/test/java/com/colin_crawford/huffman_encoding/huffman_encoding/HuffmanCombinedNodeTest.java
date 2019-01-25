package com.colin_crawford.huffman_encoding.huffman_encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class HuffmanCombinedNodeTest {

	@Test
	void constructor_GivenANullLeftNode_ThrowsAnException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new HuffmanCombinedNode(null, new HuffmanValueNode(5, 'c'));
		});
	}

	@Test
	void constructor_GivenANullRightNode_ThrowsAnException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new HuffmanCombinedNode(new HuffmanValueNode(5, 'c'), null);
		});
	}

	@Test
	void constructor_GivenTwoHuffmanNodes_ReturnsACombinedNodeWithAFrequencyEqualToTheirSum() {
		HuffmanNode first = new HuffmanValueNode(5, 'c');
		HuffmanNode second = new HuffmanValueNode(20, 'b');

		HuffmanCombinedNode combined = new HuffmanCombinedNode(first, second);

		assertEquals(25, combined.getFrequency());
	}

}
