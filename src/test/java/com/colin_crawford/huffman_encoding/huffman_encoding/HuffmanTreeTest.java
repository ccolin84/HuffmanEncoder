package com.colin_crawford.huffman_encoding.huffman_encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class HuffmanTreeTest {

	@Test
	void constructor_GivenANullMessage_ThrowsAnException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new HuffmanTree(null);
		});
	}

	@Test
	void constructor_GivenNoValues_TreeRootIsNull() {
		String message = "";
		HuffmanTree huffmanTree = new HuffmanTree(message);

		HuffmanNode root = huffmanTree.getRoot();

		assertEquals(null, root);
	}

	@Test
	void constructor_GivenStringWithOneChar_TreeRootContainsThatChar() {
		String message = "cc";
		HuffmanTree huffmanTree = new HuffmanTree(message);

		HuffmanNode root = huffmanTree.getRoot();

		assertEquals(2, root.getFrequency());
		assertEquals('c', ((HuffmanValueNode) root).getValue());
	}

	@Test
	void constructor_GivenAStringWithTwoChars_TreeRootCombinesThoseCharsIntoANode() {
		String message = "ccaaaaa";
		HuffmanTree huffmanTree = new HuffmanTree(message);

		HuffmanNode root = huffmanTree.getRoot();

		assertEquals(7, root.getFrequency());
	}

	@Test
	void constructor_GivenAStringWithThreeChars_TreeRootCombinesThoseCharsIntoANode() {
		String message = "abbcccccc";
		HuffmanTree huffmanTree = new HuffmanTree(message);

		HuffmanCombinedNode root = (HuffmanCombinedNode) huffmanTree.getRoot();

		assertEquals(9, root.getFrequency());
		assertEquals(6, root.getLeft().getFrequency());
		assertEquals(3, root.getRight().getFrequency());
	}
}
