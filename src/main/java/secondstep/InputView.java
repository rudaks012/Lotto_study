package secondstep;

import java.util.Random;
import java.util.Scanner;

public class InputView {

    public static final String PRINT_BUY_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final String LAST_WEEK_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final Scanner SCANNER = new Scanner(System.in);

    public static final Random RANDOM = new Random();
    public static final int LOTTO_ONE_PRICE_AMOUNT = 1000;
    public static final String PRINT_BUY_COUNT = "개를 구매 했습니다.";


    public static int printBuyMessage() {
        System.out.println(PRINT_BUY_MESSAGE);
        return SCANNER.nextInt();
    }

    public int  lottoBuyAmount() {
        int amount = printBuyMessage();
        int totalBuyQuantity = amountToQuantity(amount);
        System.out.println(totalBuyQuantity + PRINT_BUY_COUNT);
        return totalBuyQuantity;
    }

    private int amountToQuantity(int amount) {
        return amount / LOTTO_ONE_PRICE_AMOUNT;
    }


    public static String[] printLastWeekWinningNumber() {
        System.out.println(LAST_WEEK_MESSAGE);
        return SCANNER.nextLine().split(",");
    }

}
