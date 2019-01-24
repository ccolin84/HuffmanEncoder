package com.colin_crawford.huffman_encoding.huffman_encoding;

import java.util.Collection;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class HuffmanTree {

	private HuffmanNode root;

	HuffmanTree(String message) {
		Collection<HuffmanNode> values = this.getFrequencyValueNodes(message);
		PriorityQueue<HuffmanNode> sortedValues = new PriorityQueue<HuffmanNode>(values);
		this.root = this.buildTree(sortedValues);
	}

	HuffmanNode getRoot() {
		return this.root;
	}

	private HuffmanNode buildTree(PriorityQueue<HuffmanNode> sortedValues) {
		while (sortedValues.size() > 1) {
			HuffmanNode lowerFrequency = sortedValues.poll();
			HuffmanNode higherFrequency = sortedValues.poll();
			HuffmanCombinedNode combined = new HuffmanCombinedNode(higherFrequency, lowerFrequency);
			sortedValues.add(combined);
		}
		return sortedValues.poll();
	}

	private Collection<HuffmanNode> getFrequencyValueNodes(String message) {
		Iterable<Character> messageChars = CharacterIterable.of(message);
		Map<Character, Integer> frequencies = new FrequencyCounter<Character>(messageChars).getFrequencies();
		return frequencies.entrySet().stream().map(entry -> new HuffmanValueNode(entry.getValue(), entry.getKey()))
				.collect(Collectors.toList());
	}
}
