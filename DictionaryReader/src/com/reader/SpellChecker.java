package com.reader;

import java.util.HashMap;

public class SpellChecker {

	public static void main(String[] args) {

		String path = "src/words.txt";
		HashMap dictionary = new HashMap<>();
		DictionaryReader ob = new DictionaryReader();
		dictionary = ob.readFileByBytes(path);
		
	}

}
