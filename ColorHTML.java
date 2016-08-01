/**
 *	Author: Keon Hee Park
 *	Topic: Print Colors to HTML
 * 
 *	This project is from http://grid.cs.gsu.edu/~csc2010/f13/assignments/h4/
 * 
 *	This Java program focuses on encapsulation of object-oriented programming, write to file, basic abstract window toolkit, and HTML.
 * 
 *	Description: The objective of this program reads three integer representations of colors and performs the following computations:
 *		1) Converts them into the RGB notation.
 *		2) Converts them into the Hexadecimal notation.
 *		3) Produces a new color by using the R-value of the first color, the G-value of the second color and the B-value of the third color.
 *		4) Converts the new color into integer and hexadecimal notations.
 *		5) Produces an output containing HTML code that contains the color values in the different formats.
 *
 *	The output will create a file called Colors.html, which can be viewed on a Web browser and the colors.
 *  
 *	Started and completed: July 31, 2016
 */

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ColorHTML {
	static PrintWriter write = null;
	static PrintWriter writes = null;
	static int firstInteger = 0;
	static int secondInteger = 0;
	static int thirdInteger = 0;
	static int combinedInteger = 0;
	static int first_Red = 0;
	static int first_Green = 0;
	static int first_Blue = 0;
	static int second_Red = 0;
	static int second_Green = 0;
	static int second_Blue = 0;
	static int third_Red = 0;
	static int third_Green = 0;
	static int third_Blue = 0;
	static String first_Hexadecimal;
	static String second_Hexadecimal;
	static String third_Hexadecimal;
	static String combined_Hexadecimal;

	private static void setOfInstructions() {
		askUserForInt();
		integerToRGB();
		rgbToHexadecimal();
		writeToHTML();
	}

	private static void askUserForInt() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter integer representation of first color (1 to 16777215): ");
		firstInteger = sc.nextInt();
		System.out.print("Enter integer representation of second color (1 to 16777215): ");
		secondInteger = sc.nextInt();
		System.out.print("Enter integer representation of third color (1 to 16777215): ");
		thirdInteger = sc.nextInt();
		sc.close();
	}

	private static void integerToRGB() {
		Color firstColor = new Color(firstInteger);
		first_Red = firstColor.getRed();
		first_Green = firstColor.getGreen();
		first_Blue = firstColor.getBlue();

		Color secondColor = new Color(secondInteger);
		second_Red = secondColor.getRed();
		second_Green = secondColor.getGreen();
		second_Blue = secondColor.getBlue();

		Color thirdColor = new Color(thirdInteger);
		third_Red = thirdColor.getRed();
		third_Green = thirdColor.getGreen();
		third_Blue = thirdColor.getBlue();

		combinedInteger = 256 * 256 * first_Red + 256 * first_Green + first_Blue;
	}

	private static void rgbToHexadecimal() {
		first_Hexadecimal = String.format("#%02X%02X%02X", first_Red, first_Green, first_Blue);
		second_Hexadecimal = String.format("#%02X%02X%02X", second_Red, second_Green, second_Blue);
		third_Hexadecimal = String.format("#%02X%02X%02X", third_Red, third_Green, third_Blue);
		combined_Hexadecimal = String.format("#%02X%02X%02X", first_Red, second_Green, third_Blue);
	}

	private static PrintWriter writeToHTML() {
		try {
			write = new PrintWriter("Colors.html", "UTF-8");
			write.println("<!doctype html>");
			write.println("<html>");
			write.println("First Color: integer code = " + firstInteger + "  rgb(" + first_Red + ", " + first_Green
					+ ", " + first_Blue + ")");
			write.println(
					"<div style=\"background-color:" + first_Hexadecimal + ";width:500px;height:100px;border:1px\">");
			write.println("</div>");
			write.println("Second Color: integer code = " + secondInteger + "  rgb(" + second_Red + ", " + second_Green
					+ ", " + third_Blue + ")");
			write.println(
					"<div style=\"background-color:" + second_Hexadecimal + ";width:500px;height:100px;border:1px\">");
			write.println("</div>");
			write.println("Third Color: integer code = " + thirdInteger + "  rgb(" + third_Red + ", " + third_Green
					+ ", " + third_Blue + ")");
			write.println(
					"<div style=\"background-color:" + third_Hexadecimal + ";width:500px;height:100px;border:1px\">");
			write.println("</div>");
			write.println(
					"Combination Color (uses R-value from first, G-value from second, and B-value from third):<br />");
			write.println("integer code = " + combinedInteger + "  rgb(" + first_Red + ", " + second_Green + ", "
					+ third_Blue + ")");
			write.println("<div style=\"background-color:" + combined_Hexadecimal
					+ ";width:500px;height:100px;border:1px\">");
			write.println("</div>");
			write.println("</body>");
			write.println("</html>");
			write.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return write;
	}

	public static void main(String[] args) {
		setOfInstructions();
	}
}