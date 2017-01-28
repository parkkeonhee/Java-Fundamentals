
/**
 * Author: Keon Hee Park
 * Assignment: http://grid.cs.gsu.edu/~csc2010/f13/assignments/h9/
 * Completed: January 27, 2017
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Histogram {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int[] letterCounts = new int[26];
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		System.out.print("Enter data file name: ");
		String fileName = sc.nextLine();
		sc.close();

		File file = new File(fileName);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		System.out.println();
		String line = null;
		while ((line = reader.readLine()) != null) {
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				c = Character.toUpperCase(c);
				for (int j = 0; j < letters.length; j++) {
					if (c == letters[j]) {
						letterCounts[j]++;
					}
				}
			}
		}

		int letterCounter = letterCounts[0];
		int max = letterCounts[0];
		int location = 0;
		for (int i = 1; i < letterCounts.length; i++) {
			if (max <= letterCounts[i]) {
				max = letterCounts[i];
				location = i;
			}
			letterCounter += letterCounts[i];
		}

		System.out.println("Number of letters in " + fileName + " is " + letterCounter + ".");
		System.out.println(
				"The highest frequency of alphabetic letter is " + letters[location] + " with " + max + " counts.");
		System.out.println();
		reader.close();
		for (int i = 0; i < letters.length; i++) {
			System.out.println("Frequency for letter " + letters[i] + ": " + letterCounts[i] + ".");
		}
	}
}