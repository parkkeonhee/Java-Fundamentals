/**
 * Author: Keon Hee Park
 * Topic: Distance Formula
 * 
 * This project is from http://grid.cs.gsu.edu/~csc2010/f13/assignments/h3/
 * 
 * This Java program focuses on encapsulation of object-oriented programming
 * and uses of parameterized constructors.
 * 
 * Description: The objective of this program reads in X-Coordinates and Y-Coordinates of three points,
 * A, B, and C and computes and prints these values:
 * 1) Pairwise distances between points A, B, and C
 * 2) Maximum value of these distances
 * 3) Sum of the two non-maximum distances
 *  
 * Started and completed: July 31, 2016
 */

import java.util.Scanner;

public class DistanceFormulaTwoPairs {
	double xFirstCoordinate = 0;
	double yFirstCoordinate = 0;
	double xSecondCoordinate = 0;
	double ySecondCoordinate = 0;

	private DistanceFormulaTwoPairs(double x_1, double y_1, double x_2, double y_2) {
		xFirstCoordinate = x_1;
		yFirstCoordinate = y_1;
		xSecondCoordinate = x_2;
		ySecondCoordinate = y_2;
	}

	private double calcDistance() {
		double distanceCoordinate = Math.sqrt(Math.pow((xFirstCoordinate - xSecondCoordinate), 2)
				+ Math.pow((yFirstCoordinate - ySecondCoordinate), 2));
		return distanceCoordinate;
	}

	private static double calcMaxDistance(double distance1, double distance2, double distance3) {
		double maximumDistance = Math.max(Math.max(distance1, distance2), distance3);
		return maximumDistance;
	}

	private static double sumTwoOtherDistances(double distance1, double distance2, double distance3) {
		double maximumDistance = Math.max(Math.max(distance1, distance2), distance3);
		double sumOfTwoDistances = (distance1 + distance2 + distance3) - maximumDistance;
		return sumOfTwoDistances;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter X-Coordinate of Point A: ");
		double xA = sc.nextDouble();
		System.out.print("Enter Y-Coordinate of Point A: ");
		double yA = sc.nextDouble();

		System.out.print("Enter X-Coordinate of Point B: ");
		double xB = sc.nextDouble();
		System.out.print("Enter Y-Coordinate of Point B: ");
		double yB = sc.nextDouble();

		System.out.print("Enter X-Coordinate of Point C: ");
		double xC = sc.nextDouble();
		System.out.print("Enter Y-Coordinate of Point C: ");
		double yC = sc.nextDouble();

		sc.close();

		DistanceFormulaTwoPairs pointAtoB = new DistanceFormulaTwoPairs(xA, yA, xB, yB);
		DistanceFormulaTwoPairs pointAtoC = new DistanceFormulaTwoPairs(xA, yA, xC, yC);
		DistanceFormulaTwoPairs pointBtoC = new DistanceFormulaTwoPairs(xB, yB, xC, yC);

		double distanceAtoB = pointAtoB.calcDistance();
		double distanceAtoC = pointAtoC.calcDistance();
		double distanceBtoC = pointBtoC.calcDistance();
		double maximumDistance = calcMaxDistance(distanceAtoB, distanceAtoC, distanceBtoC);
		double sumOfOtherTwoDistances = sumTwoOtherDistances(distanceAtoB, distanceAtoC, distanceBtoC);

		System.out.println("Distance between Point A(" + xA + ", " + yA + ") and Point B(" + xB + ", " + yB + ") is "
				+ distanceAtoB);
		System.out.println("Distance between Point A(" + xB + ", " + yB + ") and Point C(" + xC + ", " + yC + ") is "
				+ distanceAtoC);
		System.out.println("Distance between Point B(" + xB + ", " + yB + ") and Point C(" + xC + ", " + yC + ") is "
				+ distanceBtoC);

		System.out.println("The maximum distance is " + maximumDistance);
		System.out.println("The sum of the other two distances is " + sumOfOtherTwoDistances);
	}
}