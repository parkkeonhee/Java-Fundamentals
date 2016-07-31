
/**
 * Author: Keon Hee Park
 * Topic: Grass Mowing Calculator
 * 
 * This project is from http://grid.cs.gsu.edu/~csc2010/f13/assignments/h3/
 * 
 * This Java program focuses on encapsulation of object-oriented programming,
 * and uses of parameterized constructors.
 * 
 * Description: The objective of this program reads in 
 * the length (in yards) and width (in yards) of a rectangle
 * and the length (in yards) and width (in yards) of a rectangular house situated in the yard.
 * This program computes the time required (in minutes rounded off to second decimal place)
 * to cut the grass at the rate of 2.3 square meters per second.
 *  
 * Started and completed: July 30, 2016
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Mowing {
	private final double YARD_TO_METERS = 0.9144;
	private final double CUT_GRASS_RATE = 2.3;

	double lengthYard = 0;
	double widthYard = 0;
	double lengthHouse = 0;
	double widthHouse = 0;
	double yardToMow = 0;
	double metersToMow = 0;
	double cutGrassTimeRequired = 0;

	private Mowing(double yardL, double yardW, double houseL, double houseW) {
		lengthYard = yardL;
		widthYard = yardW;
		lengthHouse = houseL;
		widthHouse = houseW;
	}

	private double calculateMowingTime() {
		calculateYardMow();
		convertToMeters();
		return calculateCutGrass();
	}

	private double calculateYardMow() {
		yardToMow = (lengthYard * widthYard) - (lengthHouse * widthHouse);
		return yardToMow;
	}

	private double convertToMeters() {
		metersToMow = yardToMow * YARD_TO_METERS;
		return metersToMow;
	}

	private double calculateCutGrass() {
		cutGrassTimeRequired = (metersToMow / CUT_GRASS_RATE) / 60;
		return cutGrassTimeRequired;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter length of yard (in yards): ");
		double yardL = sc.nextDouble();

		System.out.print("Enter width of yard (in yards): ");
		double yardW = sc.nextDouble();

		System.out.print("Enter length of house (in yards): ");
		double houseL = sc.nextDouble();

		System.out.print("Enter width of house (in yards): ");
		double houseW = sc.nextDouble();

		sc.close();
		Mowing myHouse = new Mowing(yardL, yardW, houseL, houseW);

		DecimalFormat df = new DecimalFormat("#.00");
		double mowingTime = Double.parseDouble(df.format(myHouse.calculateMowingTime()));

		System.out.println("Time required to cut the grass is: " + mowingTime + " minutes.");
	}
}