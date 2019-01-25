package com.colin_crawford.huffman_encoding.huffman_encoding;

public class HuffmanCombinedNode extends HuffmanNode {
	private final HuffmanNode left;
	private final HuffmanNode right;

	HuffmanCombinedNode(HuffmanNode left, HuffmanNode right) {
		// prevents the null pointer exception
		// prefer to throw illegalArgumentException
		super((left != null ? left.getFrequency() : 0) + (right != null ? right.getFrequency() : 0));

		if (left == null) {
			throw new IllegalArgumentException("left node cannot be null");
		}

		if (right == null) {
			throw new IllegalArgumentException("left node cannot be null");
		}

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
