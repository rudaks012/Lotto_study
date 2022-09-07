package secondstep;

import java.util.Scanner;

public class BuyAmount {

    public static final int ZERO = 0;
    public static final int REMAINDER_VALUE = 1000;
    public static final int LOTTO_ONE_PRICE_AMOUNT = 1000;
    public static final String PRINT_BUY_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final Scanner SCANNER = new Scanner(System.in);

    public int getAmount() {
        int amount = printBuyMessage();
        amountExceptionValidation(amount);
        amountExceptionMustThousand(amount);
        return amount;
    }

    private int printBuyMessage() {
        System.out.println(PRINT_BUY_MESSAGE);
        return SCANNER.nextInt();
    }

    public void amountExceptionValidation(int amount) {
        if (amount < LOTTO_ONE_PRICE_AMOUNT) {
            throw new AmountException(amount);
        }
    }

    public void amountExceptionMustThousand(int amount) {
        if (amount % REMAINDER_VALUE != ZERO) {
            throw new AmountException();
        }
    }

    public int getTotalBuyQuantity(int amount) {
        return amountToQuantity(amount);
    }

    public int amountToQuantity(int amount) {
        return amount / LOTTO_ONE_PRICE_AMOUNT;
    }
}
