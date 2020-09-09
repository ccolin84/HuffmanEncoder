package com.colinlcrawford.huffman;

import java.util.List;

public class HuffmanEncoder {
    private final String text;
    private final HuffmanTree tree;

    HuffmanEncoder(String text) {
        this.text = text == null ? "" : text;
        this.tree = new HuffmanTree(this.text);
    }

    public List<Integer> encode() {
        return this.tree.getEncoded();
    }

    public String decode(List<Integer> data) {
        return this.tree.decode(data);
    }

    public String getText() {
        return this.text;
    }
}
