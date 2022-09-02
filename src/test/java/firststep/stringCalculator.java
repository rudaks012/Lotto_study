package firststep;

import java.util.Scanner;

public class stringCalculator {
    public static void main(String[] args) {
        StringPlusCalculator calculator = new StringPlusCalculator();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println("input = " + calculator.calculator(input));
    }
}
