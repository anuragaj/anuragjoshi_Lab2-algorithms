import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CurrencyDenomination {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of currency denominations");
		var sizeOfCurrencyDenomination = s.nextInt();
		var denominations = new Integer[sizeOfCurrencyDenomination];
		System.out.println("Enter the currency denominations value");
		for(int i = 0; i < sizeOfCurrencyDenomination; i++) {
			denominations[i] = s.nextInt();
		}
		System.out.println("Enter the amount you want to pay");
		var amountToPay = s.nextInt();
		ProcessDenominationsToBePaid(denominations, amountToPay);
	}

	private static void ProcessDenominationsToBePaid(Integer[] denominations, int amountToPay) {
		Arrays.sort(denominations, Collections.reverseOrder());
		String output = "";
		for(int i = 0; i< denominations.length; i++) {
			var currentDenomination = 0;
			var currentNumberOfDenominations = 0;
			while(amountToPay >= denominations[i]) {
				currentDenomination = denominations[i];
				amountToPay = amountToPay % currentDenomination;
				currentNumberOfDenominations++;
			}
			if(currentNumberOfDenominations != 0) {
				output += currentDenomination + ":" + currentNumberOfDenominations + "\n";
			}
			if(amountToPay == 0) {
				break;
			}
		}
		System.out.println(output);
	}

}
