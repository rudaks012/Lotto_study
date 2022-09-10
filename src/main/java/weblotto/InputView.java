package weblotto;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private int amount;
    private String winningNumbers;

    public void askAmount() {
        System.out.println(Constant.AMOUNT_MESSAGE_QUESTION);
        amount = Integer.parseInt(scanner.nextLine());
    }

    public int getAmount() {
        return amount;
    }

    public void askWinningNumbers() {
        System.out.println(Constant.WINNING_NUMBERS_QUESTION);
        winningNumbers = scanner.nextLine();
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }
}
