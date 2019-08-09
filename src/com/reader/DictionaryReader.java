package com.reader;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DictionaryReader {

	int brLength = 0;

	public HashMap readFileByBytes(String path) {
		long startTime = System.nanoTime();
		byte[] a = null;
		FileInputStream in = null;
		try {
			in = new FileInputStream(path);
			int br = 0;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			String lastSub = "";
			while (true) {

				byte[] b = new byte[1024*1024*1];
				int len = in.read(b);
				if (len == -1) {
					break;
				}
				baos.write(b, 0, len);

			}
			a = baos.toByteArray();
			in.close();

			baos.close();
		} catch (IOException e) {

		}

		HashMap map3 = new HashMap<>();
		String s = new String(a);
	
		map3 = addToArrayList(map3, s, "");

//		System.out.println("Dictionary File : " + map3);
		System.out.println("MapSize: " + map3.size());
		System.out.println();

		long endTime = System.nanoTime();

		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in milliseconds : " + timeElapsed
				/ 1000000);

		return map3;
	}

	public HashMap readFileByLine(String path) {
		long startTime = System.nanoTime();
		HashMap map = new HashMap();
		BufferedReader br;
		String line = "";
		try {
			br = new BufferedReader(new FileReader(new File(path)));
			int num1 = 1;
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				map.put(line.toLowerCase(), num1);
				// System.out.println(num1 + " " + line);
				num1++;
			}
			// System.err.println("Number of rows " + num1);
			// System.out.println("MapSize: " + map.size());
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("MapByLine: " + map);
		System.out.println("MapSize: " + map.size());
		System.out.println();

		long endTime = System.nanoTime();

		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in milliseconds : " + timeElapsed
				/ 1000000);

		return map;
	}

	public HashMap addToArrayList(HashMap dictionary, String dataString,
			String lastSub) {
		String[] tokens = dataString.split("\\r?\\n");
		if (lastSub.length() > 0) {
			tokens[0] = lastSub + tokens[0];
			System.out.println(tokens[0] + "  " + lastSub);
		}
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].trim().length() > 0) {
				dictionary.put(tokens[i].toLowerCase().trim(), 1);
			}

		}

		return dictionary;

	}

}
