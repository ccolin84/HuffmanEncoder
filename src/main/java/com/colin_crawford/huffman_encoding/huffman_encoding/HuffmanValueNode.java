package com.colin_crawford.huffman_encoding.huffman_encoding;

public class HuffmanValueNode extends HuffmanNode {
	private final char value;

	HuffmanValueNode(int frequency, char value) {
		super(frequency);
		this.value = value;
	}

	public char getValue() {
		return value;
	}

}
