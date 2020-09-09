package com.colinlcrawford.huffman;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class HuffmanEncoderTest {
    private final String text = "some body of text that we want to encode. It could be anything!";

    @Test
    public void encode_text_encodedText() {
        HuffmanEncoder he = new HuffmanEncoder(text);

        List<Integer> encoded = he.encode();

        Assert.assertEquals(text, he.decode(encoded));
    }

    @Test
    public void encode_emptyText_emptyText() {
        HuffmanEncoder he = new HuffmanEncoder(text);

        List<Integer> encoded = he.encode();

        Assert.assertEquals(text, he.decode(encoded));
    }

    @Test
    public void encode_null_emptyText() {
        HuffmanEncoder he = new HuffmanEncoder(null);

        List<Integer> encoded = he.encode();

        Assert.assertEquals("", he.decode(encoded));
    }
}