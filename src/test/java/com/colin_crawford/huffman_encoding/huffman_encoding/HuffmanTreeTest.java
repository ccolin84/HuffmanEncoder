package com.colin_crawford.huffman_encoding.huffman_encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HuffmanTreeTest {

	@Test
	void testConstructorNoValues() {
		HuffmanNode[] values = {};
		HuffmanTree huffmanTree = new HuffmanTree(values);

		assertEquals(null, huffmanTree.getRoot());
	}

	@Test
	void testConstructorOneValue() {
		HuffmanValueNode value = new HuffmanValueNode(2, 'c');
		HuffmanNode[] values = { value };
		HuffmanTree huffmanTree = new HuffmanTree(values);

		assertEquals(value, huffmanTree.getRoot());
	}

	@Test
	void testConstructorTwoValues() {
		HuffmanValueNode value1 = new HuffmanValueNode(2, 'c');
		HuffmanValueNode value2 = new HuffmanValueNode(5, 'a');
		HuffmanNode[] values = { value1, value2 };
		HuffmanTree huffmanTree = new HuffmanTree(values);

		assertEquals(7, huffmanTree.getRoot().getFrequency());
	}

	@Test
	void testConstructorThreeValues() {
		HuffmanNode value1 = new HuffmanValueNode(1, 'a');
		HuffmanNode value2 = new HuffmanValueNode(2, 'b');
		HuffmanNode value3 = new HuffmanValueNode(6, 'c');
		HuffmanNode[] values = { value1, value2, value3 };

		HuffmanTree huffmanTree = new HuffmanTree(values);
		HuffmanCombinedNode root = (HuffmanCombinedNode) huffmanTree.getRoot();

		assertEquals(9, root.getFrequency());
		assertEquals(6, root.getLeft().getFrequency());
		assertEquals(3, root.getRight().getFrequency());
	}
}
