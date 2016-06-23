
/**
 * Author: Keon Hee Park
 * Topic: Copying Arrays
 * Description: Solution to programmingbydoing.com/a/copying-arrays.html
 * Write a program that creates an array of ten integers.
 * It should put ten random numbers from 1 to 100 in the array.
 * It should copy all the elements of that array into another array of the same size.
 * Then display the contents of both arrays. 
 * 
 * Requirements:
 * Create an array of ten integers
 * Fill the array with ten random numbers (1-100)
 * Copy the array into another array of the same capacity
 * Change the last value in the first array to a -7
 * Display the contents of both arrays
 *
 * Completed: June 22, 2016
 */

import java.util.Random;

public class CopyingArrays {
	public static void main(String[] args) {
		Random randy = new Random();
		int array[] = new int[10];
		int array2[] = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = randy.nextInt((100 - 1) + 1) + 1;
			array2[i] = array[i];
		}
		array[array.length - 1] = -7;
		System.out.print("Array 1: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print("\nArray 2: ");
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + " ");
		}
	}
}