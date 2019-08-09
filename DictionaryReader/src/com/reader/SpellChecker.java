package com.reader;

import java.util.HashMap;

public class SpellChecker {

	public static void main(String[] args) {

		String path = "src/words.txt";
		HashMap dictionary = new HashMap<>();
		DictionaryReader ob = new DictionaryReader();
		dictionary = ob.readFileByBytes(path);
		String s="hello how are you ?";
		String[] tokens=s.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			System.out.println(tokens[i]+" "+dictionary.get(tokens[i]));
		}
	}

}
