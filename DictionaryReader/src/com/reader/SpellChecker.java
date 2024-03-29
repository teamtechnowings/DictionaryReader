package com.reader;

import java.util.HashMap;

public class SpellChecker {

	public static void main(String[] args) {

		String path = "src/words.txt";
		HashMap dictionary = new HashMap<>();
		DictionaryReader ob = new DictionaryReader();
		dictionary = ob.readFileByBytes(path);
		
	}
		public static int computeDistance(String s1, String s2) {
		/**
		 * Returns the edit distance needed to convert string s1 to s2 If
		 * returns 0, the strings are same If returns 1, that means either a
		 * character is added, removed or replaced
		 */
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		int[] costs = new int[s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			int lastValue = i;
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0)
					costs[j] = j;
				else {
					if (j > 0) {
						int newValue = costs[j - 1];
						if (s1.charAt(i - 1) != s2.charAt(j - 1))
							newValue = Math.min(Math.min(newValue, lastValue),
									costs[j]) + 1;
						costs[j - 1] = lastValue;
						lastValue = newValue;
					}
				}
			}
			if (i > 0)
				costs[s2.length()] = lastValue;
		}
		return costs[s2.length()];
	}

}
