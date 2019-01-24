package com.colin_crawford.huffman_encoding.huffman_encoding;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class FrequencyCounterTest {

	FrequencyCounter<Character> fcounter;

	@Test
	void testGetFrequencyWithEmptyIterable() {
		List<Character> values = new ArrayList<>();
		fcounter = new FrequencyCounter<Character>(values);

		Map<Character, Integer> frequencies = fcounter.getFrequencies();

		assertEquals(0, frequencies.size());
	}

	@Test
	void testGetFrequencyWithSingleValue() {
		List<Character> values = new ArrayList<>();
		values.add('a');
		fcounter = new FrequencyCounter<Character>(values);

		Map<Character, Integer> frequencies = fcounter.getFrequencies();

		assertEquals(1, frequencies.size());
		assertEquals(Integer.valueOf(1), frequencies.get('a'));
	}

	@Test
	void testGetFrequencyWithManyValues() {
		List<Character> values = new ArrayList<>();
		values.add('a');
		values.add('a');
		values.add('b');
		fcounter = new FrequencyCounter<Character>(values);

		Map<Character, Integer> frequencies = fcounter.getFrequencies();

		assertEquals(2, frequencies.size());
		assertEquals(Integer.valueOf(2), frequencies.get('a'));
		assertEquals(Integer.valueOf(1), frequencies.get('b'));
	}
}
