package com.colin_crawford.huffman_encoding.huffman_encoding;

import java.util.HashMap;
import java.util.Map;

public class HuffmanEncoder {
	private final HuffmanTree huffmanTree;
	private final Map<Character, String> charEncodings;
	private final String encodedMessage;

	HuffmanEncoder(String message) {
		this(message, new HuffmanTree(message));
	}

	HuffmanEncoder(String message, HuffmanTree huffmanTree) {
		this.huffmanTree = huffmanTree;
		this.charEncodings = this.getCodesFromTree(huffmanTree);
		this.encodedMessage = this.encodeMessage(message);
	}

	public Map<Character, String> getCharEncodings() {
		return this.charEncodings;
	}

	public String getEncodedMessage() {
		return this.encodedMessage;
	}

	public HuffmanTree getHuffmanTree() {
		return this.huffmanTree;
	}

	private String encodeMessage(String message) {
		StringBuilder sb = new StringBuilder();
		CharacterIterable.of(message).forEach(c -> sb.append(this.charEncodings.get(c)));
		return sb.toString();
	}

	private Map<Character, String> getCodesFromTree(HuffmanTree tree) {
		Map<Character, String> codes = new HashMap<>();
		HuffmanNode root = tree.getRoot();
		this.getCodesFromHuffmanNode(codes, "", root);
		return codes;
	}

	private void getCodesFromHuffmanNode(Map<Character, String> codes, String branchPath, HuffmanNode node) {
		if (node instanceof HuffmanValueNode) {
			codes.put(((HuffmanValueNode) node).getValue(), branchPath);
		} else if (node instanceof HuffmanCombinedNode) {
			this.getCodesFromHuffmanNode(codes, branchPath + "0", ((HuffmanCombinedNode) node).getLeft());
			this.getCodesFromHuffmanNode(codes, branchPath + "1", ((HuffmanCombinedNode) node).getRight());
		}
	}
}
