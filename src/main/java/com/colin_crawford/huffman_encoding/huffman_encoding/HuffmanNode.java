package com.colin_crawford.huffman_encoding.huffman_encoding;

public class HuffmanNode implements Comparable<HuffmanNode> {
	private final int frequency;

	public HuffmanNode(int frequency) {
		this.frequency = frequency;
	}

	public int getFrequency() {
		return frequency;
	}

	public int compareTo(HuffmanNode other) {
		return this.getFrequency() - other.getFrequency();
	}
}
