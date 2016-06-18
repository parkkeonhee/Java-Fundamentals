/**
 * Author: Keon Hee Park
 * Topic: Salary Calculator
 * Description: Java program prompts user for their work pay, hours, and weeks. 
 * 		Then program calculates the user's annual salary, and 
 * 		shows if the user's salary is higher or lower 
 * 		than the average recent computer science graduates.
 *
 * Created: June 18, 2016
 */

import java.util.Scanner;

public class SalaryCalculator {
	private static final int weeksInYear = 52;
	// Average Salary as of 2016.
	private static final int averageSalary = 69000;
	
	// Precondition: Method that takes in 2 arguments: double hourPay and int weekHours.
	// Postcondition: Returns calculated annual salary.
	private static double setAnnualSalary(double hourPay, int weekHours){
		double salary = hourPay * weekHours * weeksInYear;
		return salary;
	}
	
	// Precondition: Method that takes in 3 arguments: double hourPay, int weekHours, int weeksWorked
	// Postcondition: Returns calculated salary earned so far.
	private static double earnedMoney(double hourPay, int weekHours, int weeksWorked){
		double earnedSoFar = hourPay * weekHours * weeksWorked;
		return earnedSoFar;
	}
	
	// Precondition: Method that takes in 3 arguments: double hourPay, int weekHours, int weeksWorked
	// Postcondition: Returns calculated salary unearned so far.
	private static double unearnedMoney(double hourPay, int weekHours, int weeksWorked){
		double unearnedSoFar = hourPay * weekHours * weeksWorked;
		return unearnedSoFar;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double hourPay, moneyEarned, moneyUnearned = 0;
		double currentSalary, upperSalaryDifference, lowerSalaryDifference = 0; 
		int weekHours, weeksWorked, weeksLeft = 0;
		
		System.out.println("Welcome to Salary Calculator for Computer Science graduates!\n");
		System.out.println("How much do you get paid per hour?");
		hourPay = sc.nextDouble();
		
		System.out.println("How many hours do you work per week?");
		weekHours = sc.nextInt();
		
		System.out.println("How many weeks have you been working so far?");
		weeksWorked = sc.nextInt();
		
		System.out.println("\n-------------------------------------------");
		currentSalary = setAnnualSalary(hourPay, weekHours);
		System.out.println("Your annual salary is $" + currentSalary + ".");
		
		weeksLeft = weeksInYear - weeksWorked;
		System.out.println("You have remaining weeks left: " + weeksLeft + ".");
		
		moneyEarned = earnedMoney(hourPay, weekHours, weeksWorked);
		System.out.println("So far, you have earned $" + moneyEarned + ".");
		
		moneyUnearned = unearnedMoney(hourPay, weekHours, weeksLeft);
		System.out.println("Salary left to earn for this year is $" + moneyUnearned + ".");
		
		upperSalaryDifference = currentSalary - averageSalary;
		lowerSalaryDifference = averageSalary - currentSalary;
		
		System.out.println("The average salary for recent computer science graduates is $" + averageSalary);
		if (currentSalary > averageSalary){
			System.out.println("You earn $" + upperSalaryDifference + " more than the average recent CS graduates.");
		}
		if (currentSalary < averageSalary){
			System.out.println("You earn $" + lowerSalaryDifference + " less than the average recent CS graduates.");
		}
		
		System.out.println("-------------------------------------------");
		System.out.println("The Salary Calculator program has finished.");
	}
}
