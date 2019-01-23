package com.colin_crawford.huffman_encoding.huffman_encoding;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HuffmanTree {

	private HuffmanNode root;

	HuffmanTree(HuffmanNode[] values) {
		PriorityQueue<HuffmanNode> sortedValues = new PriorityQueue<HuffmanNode>();
		Arrays.stream(values).forEach(sortedValues::add);
		this.root = this.buildTree(sortedValues);
	}

	HuffmanNode getRoot() {
		return this.root;
	}

	private HuffmanNode buildTree(PriorityQueue<HuffmanNode> sortedValues) {
		while (sortedValues.size() > 1) {
			HuffmanNode first = sortedValues.poll();
			HuffmanNode second = sortedValues.poll();
			HuffmanCombinedNode combined = new HuffmanCombinedNode(first, second);
			sortedValues.add(combined);
		}
		return sortedValues.poll();
	}
}
