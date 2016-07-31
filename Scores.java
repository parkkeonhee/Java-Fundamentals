/**
 * Author: Keon Hee Park
 * Exam Scores Calculator
 *
 * This project is from http://tinman.cs.gsu.edu/~raj/2310/sp99/prog4.html
 *
 * This Java program focuses on encapsulation of object-oriented programming.
 *
 * Description: Write a Java program which reads a collection of exam scores ranging from 1 to 100 
 *  and counts and prints the number of `A' scores, `B' scores, `C' scores, `D' scores and `F' scores
 *  based on the following grading scale: A: 90 to 100; B: 80 to 89, C: 70 to 79, D: 60 to 69 and F: 1 to 59.
 *  The program should also print the number of scores, the average score, the maximum score, and the minimum score.
 *
 *  Started: July 16, 2016
 *  Completed: July 17, 2016
 */

import java.util.Scanner;

public class Scores {
	private static int A = 0, B = 0, C = 0, D = 0, F = 0, totalLetters = 0;
	private static double prevScore = 0, totalScore = 0, maximumScore = 0, minimumScore = 0;
	private static double gradeScore = 0, averageScore = 0;
	private static boolean grade0 = true;
	
	private static void setOfInstructions(Scanner sc) {
		askUserOnce(sc);
		whileLoopCalc(sc);
		averageScoreCalc();
		totalLettersCalc();
		avgMaxMinCalc();
	}
	
	private static void askUserOnce(Scanner sc) {
		System.out.println("Enter exam scores one per line (enter 0 to quit):");
		gradeScore = sc.nextDouble();
		if (gradeScore != 0) {
			caseCalc();
		}
		whileLoopCalc(sc);
	}
	
	private static void whileLoopCalc(Scanner sc) {
		while (grade0) {
			if (gradeScore == 0) {
				grade0 = false;
			} else {
				totalScore += gradeScore;
				prevScore = gradeScore;
				askTheUser(sc);
				if (gradeScore == 0) {
					grade0 = false;
				} else if (prevScore > gradeScore) {
					minimumScore = gradeScore;
					maximumScore = prevScore;
				} else if (gradeScore > prevScore) {
					minimumScore = prevScore;
					maximumScore = gradeScore;
				}
				totalGradeLetterCalc();
			}
		}
	}
	
	private static void askTheUser(Scanner sc) {
		gradeScore = sc.nextInt();
		if (gradeScore != 0) {
			caseCalc();
		}
	}

	private static void averageScoreCalc() {
		averageScore = totalScore / totalLetters;
	}

	private static void totalGradeLetterCalc() {
		totalLetters = A + B + C + D + F;
	}

	private static void totalLettersCalc() {
		System.out.println();
		System.out.println("Number of \"A\" scores = " + A);
		System.out.println("Number of \"B\" scores = " + B);
		System.out.println("Number of \"C\" scores = " + C);
		System.out.println("Number of \"D\" scores = " + D);
		System.out.println("Number of \"F\" scores = " + F);
		System.out.println("------------------------");
		System.out.println("Total Scores        = " + totalLetters);
		System.out.println();
	}

	private static void avgMaxMinCalc() {
		System.out.println("Average Score = " + averageScore);
		System.out.println("Maximum Score = " + maximumScore);
		System.out.println("Minimum Score = " + minimumScore);
	}

	private static void caseCalc() {
		switch ((int) gradeScore / 10) {
		case 10:
		case 9:
			A++;
			break;
		case 8:
			B++;
			break;
		case 7:
			C++;
			break;
		case 6:
			D++;
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
			F++;
			break;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		setOfInstructions(sc);
		sc.close();
	}
}
