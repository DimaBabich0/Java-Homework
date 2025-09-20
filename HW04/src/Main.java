import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
        List<BankAccount> accounts = Arrays.asList(
        		new BankAccount("Test_01", 5800.25f),
                new BankAccount("Test_02", 550.40f),
                new BankAccount("Test_03", 2590.61f),
                new BankAccount("Test_04", 5800.90f),
                new BankAccount("Test_05", 2999.99f)
        );
		
        //Total sum
        double totalSum = accounts.parallelStream()
                .mapToDouble(BankAccount::getBalance)
                .sum();
        System.out.printf("Total sum of all elements: %.2f\n", totalSum);

        //Max balance
        double maxBalance = accounts.parallelStream()
                .mapToDouble(BankAccount::getBalance)
                .max()
                .orElse(0);
        System.out.printf("Max balance: %.2f\n", maxBalance);

        //Elements, where balance is more then 3000
        List<BankAccount> richAccounts = accounts.parallelStream()
                .filter(acc -> acc.getBalance() > 3000)
                .collect(Collectors.toList());
        System.out.println("Elements with more then 3000:");
        richAccounts.forEach(acc -> System.out.println(acc));	
	}
}
