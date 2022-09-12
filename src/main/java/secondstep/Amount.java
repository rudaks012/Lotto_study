package secondstep;

public class Amount {

    public static final int ZERO = 0;
    public static final int REMAINDER_VALUE = 1000;
    public static final int LOTTO_ONE_PRICE_AMOUNT = 1000;

    private final int amount;

    public Amount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        amountExceptionValidation(this.amount);
        amountExceptionMustThousand(this.amount);
    }

    public static void amountExceptionValidation(int amount) {
        if (amount < LOTTO_ONE_PRICE_AMOUNT) {
            throw new AmountException(amount);
        }
    }

    public static void amountExceptionMustThousand(int amount) {
        if (amount % REMAINDER_VALUE != ZERO) {
            throw new AmountException();
        }
    }

    public static int getTotalBuyQuantity(int amount) {
        return amount / LOTTO_ONE_PRICE_AMOUNT;
    }

//    public static int getAmount() {
//        InputView inputView = new InputView();
//        return inputView.printBuyMessage();
//    }
}
