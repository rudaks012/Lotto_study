package thirdstep;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String PRINT_BUY_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final String PRINT_BUY_COUNT = "개를 구매 했습니다.";
    public static final String LAST_WEEK_WINNER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private InputView() {
        throw new AssertionError();
    }

    public static int printBuyMessage() {
        println(PRINT_BUY_MESSAGE);
        return SCANNER.nextInt();
    }

    public static void printTotalBuyQuantity(int totalBuyQuantity) {
        println(totalBuyQuantity + PRINT_BUY_COUNT);
    }

    public static String[] printLastWeekWinningNumber() {
        println(LAST_WEEK_WINNER_MESSAGE);
        return SCANNER.nextLine().split(",");
    }

    public static int bonusBallNumber() {
        println(BONUS_BALL_NUMBER_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
