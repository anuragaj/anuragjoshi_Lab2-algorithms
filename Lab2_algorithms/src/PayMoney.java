import java.util.Scanner;

// I am not able to figure out what the issue is when I want to another transaction in the loop.
// After first transaction I get an error at line 15.

public class PayMoney {

	public static void main(String[] args) {
		boolean status = true;
		Scanner s = new Scanner(System.in);
		while (status) {
			System.out.println("Enter N for new transaction");
			System.out.println("Enter Q to quit");
			var input = s.nextLine();
			switch (input) {
			case "N":
			case "n":
				ProcessNewTransaction();
				break;
			case "Q":
			case "q":
				status = false;
				s.close();
				break;
			default:
				System.out.println("Enter correct value");
			}
		}

	}

	public static void ProcessNewTransaction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of transaction array");
		var sizeOfTransactionArray = sc.nextInt();
		Integer[] transactionArray = new Integer[sizeOfTransactionArray];

		System.out.println("Enter the values of array");
		for (int i = 0; i < sizeOfTransactionArray; i++) {
			transactionArray[i] = sc.nextInt();
		}

		System.out.println("Enter the total no of targets that needs to be achieved");
		var numberOfTragetsNeedsToBeAchived = sc.nextInt();

		System.out.println("Enter the value of target");
		var target = sc.nextInt();

		int currentTotal = 0;
		var targetAchived = false;
		for (int i = 0; i < sizeOfTransactionArray; i++) {
			currentTotal += transactionArray[i];
			if (currentTotal >= target && i <= numberOfTragetsNeedsToBeAchived) {
				System.out.println("Target achieved after " + (i + 1) + " transactions.");
				targetAchived = true;
				break;
			}
		}
		if (!targetAchived) {
			System.out.println("Given target is not achieved");
		}
		sc.close();
	}

}
