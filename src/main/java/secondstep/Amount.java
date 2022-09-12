package secondstep;

import java.util.Scanner;

public class Amount {

    public static final int ZERO = 0;
    public static final int REMAINDER_VALUE = 1000;
    public static final int LOTTO_ONE_PRICE_AMOUNT = 1000;
    public static final String PRINT_BUY_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final Scanner SCANNER = new Scanner(System.in);

    private final int amount;

    public Amount(int amount) {
        validate(amount);
        this.amount = printBuyMessage();
    }

    private void validate(int amount) {
        amountExceptionValidation(amount);
        amountExceptionMustThousand(amount);
    }

    private void amountExceptionValidation(int amount) {
        if (amount < LOTTO_ONE_PRICE_AMOUNT) {
            throw new AmountException(amount);
        }
    }

    private void amountExceptionMustThousand(int amount) {
        if (amount % REMAINDER_VALUE != ZERO) {
            throw new AmountException();
        }
    }

    public int getTotalBuyQuantity(int amount) {
        return amount / LOTTO_ONE_PRICE_AMOUNT;
    }

    public int getAmount() {
        return amount;
    }

    private int printBuyMessage() {
        System.out.println(PRINT_BUY_MESSAGE);
        return SCANNER.nextInt();
    }
}
