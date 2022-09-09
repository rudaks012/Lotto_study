package thirdstep;

import java.util.Objects;

public class BuyAmount {
    public static final int ZERO = 0;
    public static final int REMAINDER_VALUE = 1000;
    public static final int LOTTO_ONE_PRICE_AMOUNT = 1000;
    private final int amount;

    public BuyAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private static void validate(int amount) {
        validatePriceTicket(amount);
        validateUnderThousand(amount);
    }

    private static void validateUnderThousand(int amount) {
        if (amount % REMAINDER_VALUE != ZERO) {
            throw new AmountException();
        }
    }

    private static void validatePriceTicket(int amount) {
        if (amount < LOTTO_ONE_PRICE_AMOUNT) {
            throw new AmountException(amount);
        }
    }

    public int getTotalBuyQuantity(int amount) {
        return amount / LOTTO_ONE_PRICE_AMOUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyAmount buyAmount = (BuyAmount) o;
        return amount == buyAmount.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
