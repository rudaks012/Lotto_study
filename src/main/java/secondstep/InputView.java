package secondstep;

import java.util.Random;
import java.util.Scanner;

public class InputView {

    public static final String PRINT_BUY_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final Scanner SCANNER = new Scanner(System.in);

    public static final Random RANDOM = new Random();
    public static final int LOTTO_ONE_PRICE_AMOUNT = 1000;
    public static final String PRINT_BUY_COUNT = "개를 구매 했습니다.";
    public static final int LOTTO_MAX_COUNT = 6;
    public static final int ZERO = 0;
    public static final int REMAINDER_VALUE = 10;


    public static int printBuyMessage() {
        System.out.println(PRINT_BUY_MESSAGE);
        return SCANNER.nextInt();
    }

    public void lottoBuyAmount() {
        int amount = printBuyMessage();
        amountExceptionValidition(amount);
        int totalBuyQuantity = getTotalBuyQuantity(amount);
        System.out.println(totalBuyQuantity + PRINT_BUY_COUNT);
    }

    private static void amountExceptionValidition(int amount) {
        if (amount < LOTTO_ONE_PRICE_AMOUNT) {
            throw new IllegalArgumentException("돈이 천원 보다 작습니다.");
        }
        if (amount % REMAINDER_VALUE != ZERO) {
            throw new IllegalArgumentException("천원 단위로 입력 해야 합니다.");
        }
    }

    private int getTotalBuyQuantity(int amount) {
        return amountToQuantity(amount);
    }

    private int amountToQuantity(int amount) {
        return amount / LOTTO_ONE_PRICE_AMOUNT;
    }

    public void lottoNumberGeneration() {
        int[] lottoNumber = new int [LOTTO_MAX_COUNT];

        for (int i = 0; i < LOTTO_MAX_COUNT; i++) {
            lottoNumber[i] = (int)(Math.random() * 45) + 1;

        }
    }
}
