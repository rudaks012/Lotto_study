package secondstep;

import secondstep.view.InputView;

public class BuyAmount {

    public static final int ZERO = 0;
    public static final int REMAINDER_VALUE = 1000;
    public static final int LOTTO_ONE_PRICE_AMOUNT = 1000;

    public int getAmount() {
        InputView inputView = new InputView();
        int amount = inputView.printBuyMessage();
        amountExceptionValidation(amount);
        amountExceptionMustThousand(amount);
        return amount;
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
        return amount / LOTTO_ONE_PRICE_AMOUNT;
    }
}
