package com.colin_crawford.huffman_encoding.huffman_encoding;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter<E> {
	private Map<E, Integer> frequencies = new HashMap<>();

	FrequencyCounter(Iterable<E> values) {
		values.forEach(value -> {
			Integer previousValue = frequencies.getOrDefault(value, 0);
			frequencies.put(value, previousValue + 1);
		});
	}

	public Map<E, Integer> getFrequencies() {
		return frequencies;
	}
}
