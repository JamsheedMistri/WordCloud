package WorldCloud;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import apcs.Window;

public class WordCloud {

	public static void main(String[] args) {
		Window.size(1300, 700);

		File f = new File("test.txt");

		try {
			if (f.createNewFile()) {
				System.out.println("created new file");
			}
			else {
				System.out.println("file already exists");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] words = { "hello", "world", "goodbye", "world" };

		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

		printWords(words);
		printWords(wordMap);

	}

	private static void printWords(HashMap<String, Integer> wordMap) {
		Scanner scan;
		try {
			scan = new Scanner(new File("test.txt"));
			while (scan.hasNext()) {
				String[] s = scan.nextLine().split(" ");
				for (String str : s) {
					if (wordMap.containsKey(str)) {
						wordMap.put(str, wordMap.get(str) + 1);
					}
					else {
						wordMap.put(str, 1);
					}
				}
				//				String str = scan.nextLine();
				//				if (wordMap.containsKey(str)) {
				//					wordMap.put(str, wordMap.get(str) + 1);
				//				}
				//				else {
				//					wordMap.put(str, 1);
				//				}
			}
			scan.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (String s : wordMap.keySet()) {
			if (wordMap.containsKey(s)) {
				wordMap.put(s, wordMap.get(s) + 1); 
			}
 			else {
				wordMap.put(s, 1);
			}
			Window.out.randomColor();
			Window.out.font("monospaced", 10 + wordMap.get(s));
			Window.out.print(s, Window.rollDice(Window.width()), Window.rollDice(Window.height()));
		}
	}

	private static void printWords(String[] words) {
		for (String s : words) {
			Window.out.randomColor();
			Window.out.font("monospaced", 30);
			Window.out.print(s, Window.rollDice(Window.width()), Window.rollDice(Window.height()));
		}
	}


}
