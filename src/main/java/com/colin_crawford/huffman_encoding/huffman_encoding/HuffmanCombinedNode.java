package com.colin_crawford.huffman_encoding.huffman_encoding;

public class HuffmanCombinedNode extends HuffmanNode {
	private final HuffmanNode left;
	private final HuffmanNode right;

	HuffmanCombinedNode(HuffmanNode left, HuffmanNode right) {
		super(left.getFrequency() + right.getFrequency());
		this.left = left;
		this.right = right;
	}

	public HuffmanNode getLeft() {
		return left;
	}

	public HuffmanNode getRight() {
		return right;
	}

}
