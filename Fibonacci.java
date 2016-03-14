/**
 * Author: Keon Hee Park
 * Topic: Fibonacci sequence
 * Description: Java program prompts user for last index of the fibonacci sequence, 
 * 		then program calculates each fibonacci number of every index 
 * 		to the last index and its fibonacci number.
 * Created: March 13, 2016
 */

/* 
 * Fibonacci formula = (n-1) + (n-2)
 * Index:      1 2 3 4 5 6 7 8  9
 * Sequence:   0 1 1 2 3 5 8 13 21
 */

// Import a scanner
import java.util.Scanner;

// Fibonacci class
public class Fibonacci {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Prompt user for fibonacci sequence's index
		System.out.print("Give the nth index number of fibonacci sequence: ");
		int fibonacciIndex = sc.nextInt();

		/*
		 * Prints out index and its fibonacci sequence. 
		 * This for-loop calls fibonacciMethod for its sequence.
		 */
		for (int i = 0; i <= fibonacciIndex; i++) {
			System.out.println(i + ": " + fibonacciMethod(i));
		}
	}

	// fibonacciMethod method
	public static int fibonacciMethod(int fiboIndex) {
		int firstIndex = 0;	/*
					 * 'firstIndex' value is initialized for the first
					 * value of fibonacci sequence.
					 */
		int secondIndex = 1;    /*
					 * 'secondIndex' value is initialized for the
					 * second value of fibonacci sequence.
					 */
		int fibonacci = 1;	// 'fibonacci' initial value is 1 as placeholder.

		/*
		 * If the index of fibonacci sequence is less than 2, then it just
		 * prints out that number.
		 */
		if (fiboIndex < 2) {
			return fiboIndex;
		}

		/*
		 * Fibonacci algorithm using for-loop. 
		 * The sequence starts from the second index to the prompted index. 
		 * First, 'fibonacci' stores 'firstIndex' and 'secondIndex' sum. 
		 * Then, 'firstIndex' stores 'secondIndex' value. 
		 * Finally, 'secondIndex' stores 'fibonacci' value.
		 */
		for (int i = 2; i <= fiboIndex; i++) {
			fibonacci = firstIndex + secondIndex;
			firstIndex = secondIndex;
			secondIndex = fibonacci;
		}
		return fibonacci;
	} // end fibonacciMethod method
} // end class
