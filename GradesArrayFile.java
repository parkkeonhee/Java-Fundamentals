
/**
 * Author: Keon Hee Park
 * Topic: Grades in an Array and a File
 * Description: http://programmingbydoing.com/a/grades-in-an-array-and-a-file.html
 * Prompt the user for a first and last name, and the name for a file. 
 * Randomly choose five grades for that person from 1 to 100 
 * and store them in an array that can hold five integers. 
 * Then output the first and last name and those five grades to the specified file.
 * 
 * Completed: June 23, 2016
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

public class GradesArrayFile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random randy = new Random();
		String name, fileName;

		System.out.print("Name (first last): ");
		name = sc.nextLine();

		System.out.print("Filename: ");
		fileName = sc.nextLine();

		int array[] = new int[5];

		System.out.println("\nHere are your randomly-selected grades (hope you pass):");
		for (int i = 0; i < array.length; i++) {
			array[i] = randy.nextInt((100 - 1) + 1) + 1;
			System.out.println("Grade " + (i + 1) + ": " + array[i]);
		}
		try {
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println(name);
			for (int i = 0; i < array.length; i++) {
				writer.print(array[i] + " ");
			}
			writer.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nData saved in \"" + fileName + "\".");

	}

}