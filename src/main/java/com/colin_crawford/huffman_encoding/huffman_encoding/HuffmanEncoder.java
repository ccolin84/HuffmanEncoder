package com.colin_crawford.huffman_encoding.huffman_encoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanEncoder {
	public Map<Character, String> encode(String message) {
		HuffmanNode[] frequencies = this.getFrequencyValueNodes(message);
		HuffmanTree huffmanTree = new HuffmanTree(frequencies);
		return this.getCodesFromTree(huffmanTree);
	}

	private Map<Character, String> getCodesFromTree(HuffmanTree tree) {
		Map<Character, String> codes = new HashMap<>();
		HuffmanNode root = tree.getRoot();
		this.getCodesFromHuffmanNode(codes, "", root);
		return codes;
	}

	private HuffmanNode[] getFrequencyValueNodes(String message) {
		Iterable<Character> messageChars = this.getCharsFromMessage(message);
		Map<Character, Integer> frequencies = new FrequencyCounter<Character>(messageChars).getFrequencies();
		return frequencies.entrySet().stream().map(entry -> new HuffmanValueNode(entry.getValue(), entry.getKey()))
				.toArray(HuffmanNode[]::new);
	}

	private void getCodesFromHuffmanNode(Map<Character, String> codes, String branchPath, HuffmanNode node) {
		if (node instanceof HuffmanValueNode) {
			codes.put(((HuffmanValueNode) node).getValue(), branchPath);
		} else if (node instanceof HuffmanCombinedNode) {
			this.getCodesFromHuffmanNode(codes, branchPath + "0", ((HuffmanCombinedNode) node).getLeft());
			this.getCodesFromHuffmanNode(codes, branchPath + "1", ((HuffmanCombinedNode) node).getRight());
		}
	}

	private Iterable<Character> getCharsFromMessage(String message) {
		List<Character> chars = new ArrayList<>(message.length());
		for (Character c : message.toCharArray()) {
			chars.add(c);
		}
		return chars;
	}
}
