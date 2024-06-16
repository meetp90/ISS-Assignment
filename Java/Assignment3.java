import java.util.Random;
import java.util.Scanner;

public class Assignment3 {

	public static void main(String[] args) {
		// Looping Examples:
		
		// 1. for loop: Print numbers from 1 to 10
		int total = 0;
		for (int i = 1; i <= 10; i++) {
			total += i;
		}

		// 2. while loop: Read user input until they enter "exit"
		Scanner scanner = new Scanner(System.in);
		String input = "";
		while (!input.equalsIgnoreCase("exit")) {
			System.out.println("Enter something (or 'exit' to quit): ");
			input = scanner.nextLine();
		}

		// 3. do-while loop: Simulate a dice roll (1-6) until a 6 is rolled
		Random random = new Random();
		int diceRoll;
		int outcomeDiceRoll;
		do {
			diceRoll = random.nextInt(6) + 1; // Generate random number between 1 and 6
			outcomeDiceRoll = diceRoll;
		} while (diceRoll != 6); // Repeat until a 6 is rolled

		// Branching Examples:

		// 1. if-else statement: Check if a number is positive, negative, or zero
		int number = -5;
		String outcome = "";
		if (number > 0) {
			outcome = number + " is positive";
		} else if (number < 0) {
			outcome = number + " is negative";
		} else {
			outcome = number + " is zero";
		}

		// 2. switch statement: Print the month name based on a number (1-12)
		int month = 8;
		String outcomeMonth = "";
		switch (month) {
		case 1:
			outcomeMonth = "January";
			break;
		case 2:
			outcomeMonth = "February";			
			break;
		case 3:
			outcomeMonth = "March";
		
			break;
		case 4:
			outcomeMonth = "April";
			
			break;
		case 5:
			outcomeMonth = "May";
			
			break;
		case 6:
			outcomeMonth = "June";
			
			break;
		case 7:
			outcomeMonth = "July";
			
			break;
		case 8:
			outcomeMonth = "August";
			
			break;
		case 9:
			outcomeMonth = "September";
			
			break;
		case 10:
			outcomeMonth = "October";
			
			break;
		case 11:
			outcomeMonth = "November";
		
			break;
		case 12:
			outcomeMonth = "December";
		
			break;
		default:
			outcomeMonth = "Invalid month number.";
		}

		scanner.close(); // Close Scanner to avoid resource leaks
	}
}
