package com.colinlcrawford.huffman;

class HuffmanTreeNode implements Comparable<HuffmanTreeNode> {
    private HuffmanTreeNode left;
    private HuffmanTreeNode right;
    private final Character val;
    private final Long count;

    HuffmanTreeNode(Character c, Long count) {
        this.val = c;
        this.count = count;
    }

    HuffmanTreeNode(HuffmanTreeNode left, HuffmanTreeNode right) {
        this.val = null;
        this.count = left.count + right.count;
        this.left = left.count >= right.count ? left : right;
        this.right = right.count <= left.count ? right : left;
    }

    @Override
    public int compareTo(HuffmanTreeNode o) {
        return (int) (count - o.getCount());
    }

    public HuffmanTreeNode getLeft() {
        return this.left;
    }

    public HuffmanTreeNode getRight() {
        return this.right;
    }

    public Character getVal() {
        return this.val;
    }

    public Long getCount() {
        return this.count;
    }

    public Boolean hasValue() {
        return this.val != null;
    }
}