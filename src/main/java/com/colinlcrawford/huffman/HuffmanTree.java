package com.colinlcrawford.huffman;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


class HuffmanTree implements Serializable {
    private final String text;
    private final HuffmanTreeNode root;
    private List<Integer> encoded;
    private final Map<Character, List<Integer>> encodings;
    private final Map<Character, Long> charFrequencies;

    public HuffmanTree(String text) {
        this.text = text;
        charFrequencies = getCharFrequencies(text);
        root = buildTree(charFrequencies);
        encodings = new HashMap<>();
        if (root != null) {
            getCharEncodings(root, new LinkedList<>());
        }
    }

    public List<Integer> getEncoded() {
        if (encoded != null) return encoded;

        List<Integer> encoded = new ArrayList<>();
        for (Character c : text.toCharArray()) {
            encoded.addAll(this.encodings.get(c));
        }
        this.encoded = encoded;
        return encoded;
    }

    public String decode(Iterable<Integer> digits) {
        if (this.root == null) return "";

        StringBuilder sb = new StringBuilder();
        HuffmanTreeNode current = root;

        for (Integer i : digits) {
            current = i == 0 ? current.getLeft() : current.getRight();
            if (current == null) throw new RuntimeException("Invalid path");
            if (current.hasValue()) {
                sb.append(current.getVal());
                current = root;
            }
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----<HuffmanTree>----");
        encodings.forEach((key, value) -> sb.append(key).append(" (").append(charFrequencies.get(key)).append(") -> ").append(value).append("\n"));
        sb.append("----------------------");
        return sb.toString();
    }

    /**
     * Get each character's encoding
     * @param node The node to continue searching under
     * @param path The path so far
     */
    private void getCharEncodings(HuffmanTreeNode node, Queue<Integer> path) {
        if (node.hasValue()) {
            this.encodings.put(node.getVal(), new ArrayList<>(path));
            return;
        }

        if (node.getLeft() != null) {
            Queue<Integer> leftPath = new LinkedList<>(path);
            leftPath.add(0);
            getCharEncodings(node.getLeft(), leftPath);
        }

        if (node.getRight() != null) {
            Queue<Integer> rightPath = new LinkedList<>(path);
            rightPath.add(1);
            getCharEncodings(node.getRight(), rightPath);
        }
    }

    /**
     * Get the frequency of each char in the body of text
     * @param text The body of text to encode
     * @return A mapping of chars to their frequency in the text
     */
    private Map<Character, Long> getCharFrequencies(String text) {
        return text.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Build the Huffman Tree using the char frequencies
     * @param charFrequencies The number of occurrences for each char in the text
     * @return The Huffman tree
     */
    private HuffmanTreeNode buildTree(Map<Character, Long> charFrequencies) {
        PriorityQueue<HuffmanTreeNode> pq = new PriorityQueue<>();
        charFrequencies.forEach((key, value) -> pq.add(new HuffmanTreeNode(key, value)));

        while (pq.size() > 1) {
            pq.add(new HuffmanTreeNode(pq.poll(), pq.poll()));
        }

        return pq.poll();
    }
}
