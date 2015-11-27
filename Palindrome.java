/**
 * Topic: Palindrome
 * Description: Java program that prompts the user for a phrase, and 
 *	it checks if the user's phrase (string) is a palindrome or not.
 *	A palindrome is any phrase that reads the same as backwards or forwards.
 *	For example: madam is the same as backwards of the word. 
 * Author: Keon Hee Park
 * Created: November 26, 2015
 */

// Import a scanner
import java.util.Scanner;

// Palindrome class
public class Palindrome {
	// Main
	public static void main(String[] args) {
		
		// 'palindrome' defined as an empty string.
		String palindrome = "";

		// sc defined as a scanner
		Scanner sc = new Scanner(System.in);

		// Prompt user for a phrase.
		System.out
				.print("Type a phrase that will be checked if it is a palindrome or not");

		// Store the user's prompt into 'userPhrase'
		// and make the phrase all lower-case.
		String userPhrase = sc.nextLine().toLowerCase();

		// Store the length of the user's phrase as a number on
		// 'userPhraseLength'.
		int userPhraseLength = userPhrase.length();

		/*
		 * example: M a d a m -> m a d a m 
		 * 	    0 1 2 3 4 
		 * inputLength = 5 int i = inputLength minus 1, 
		 * because the characters are from 0 - 4. 
		 * So 5 - 1 = 4
		 */

		// for-loop that stores the palindrome of the userPhrase each character
		// per loop until the userPhraseLength's last index.
		for (int i = userPhraseLength - 1; i >= 0; i--) {
			palindrome = palindrome + userPhrase.charAt(i);
		} // end for-loop

		// Print out the palindrome of the user's phrase.
		// This is useful to check if the program
		// outputs an unexpected result.
		System.out.println("palindrome: " + palindrome);

		// if-else statement
		if (palindrome.equals(userPhrase)) {
			// if the strings are equal to each other,
			// then print this statement.
			System.out.println("The phrase is a palindrome.");
		} else {
			// if the strings are not equal to each other,
			// then print this statement
			System.out.println("The phrase is not a palindrome.");
		} // end else
	} // end main
} // end class
