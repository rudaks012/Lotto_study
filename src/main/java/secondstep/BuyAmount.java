package secondstep;

import java.util.Scanner;

public class BuyAmount {
    public static final int ZERO = 0;
    public static final int REMAINDER_VALUE = 1000;
    public static final int LOTTO_ONE_PRICE_AMOUNT = 1000;
    public static final String PRINT_BUY_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final String EXCEPTION_MONEY_IS_LESS_THOUSAND = "돈이 천원 보다 작습니다.";
    public static final String EXCEPTION_THOUSAND_INSERT = "천원 단위로 입력 해야 합니다.";
    public static final Scanner SCANNER = new Scanner(System.in);

    public static int getAmount() {
        int amount = printBuyMessage();
        amountExceptionValidation(amount);
        amountExceptionMustThousand(amount);
        return amount;
    }

    public static int printBuyMessage() {
        System.out.println(PRINT_BUY_MESSAGE);
        return SCANNER.nextInt();
    }

    public static void amountExceptionValidation(int amount) {
        if (amount < LOTTO_ONE_PRICE_AMOUNT) {
            throw new IllegalArgumentException(EXCEPTION_MONEY_IS_LESS_THOUSAND);
        }
    }

    public static void amountExceptionMustThousand(int amount) {
        if (amount % REMAINDER_VALUE != ZERO) {
            throw new IllegalArgumentException(EXCEPTION_THOUSAND_INSERT);
        }
    }
}
