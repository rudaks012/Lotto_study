package secondstep;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String PRINT_BUY_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final String PRINT_BUY_COUNT = "개를 구매 했습니다.";
    public static final String EXCEPTION_MONEY_IS_LESS_THOUSAND = "돈이 천원 보다 작습니다.";
    public static final String EXCEPTION_THOUSAND_INSERT = "천원 단위로 입력 해야 합니다.";
    public static final int LOTTO_ONE_PRICE_AMOUNT = 1000;
    public static final int ZERO = 0;
    public static final int REMAINDER_VALUE = 1000;
    public static final Scanner SCANNER = new Scanner(System.in);

    public List<List<Integer>> lottoGameStart(int amount) {
        LottoMaker lottoMaker = new LottoMaker();
        int totalBuyQuantity = getTotalBuyQuantity(amount);
        printTotalBuyQuantity(totalBuyQuantity);

        return lottoMaker.lottoNumberGeneration(totalBuyQuantity);
    }

    public int getAmount() {
        int amount = printBuyMessage();
        amountExceptionValidation(amount);
        amountExceptionMustThousand(amount);
        return amount;
    }

    public int printBuyMessage() {
        System.out.println(PRINT_BUY_MESSAGE);
        return SCANNER.nextInt();
    }

    public void amountExceptionValidation(int amount) {
        if (amount < LOTTO_ONE_PRICE_AMOUNT) {
            throw new IllegalArgumentException(EXCEPTION_MONEY_IS_LESS_THOUSAND);
        }
    }

    public void amountExceptionMustThousand(int amount) {
        if (amount % REMAINDER_VALUE != ZERO) {
            throw new IllegalArgumentException(EXCEPTION_THOUSAND_INSERT);
        }
    }

    public void printTotalBuyQuantity(int totalBuyQuantity) {
        System.out.println(totalBuyQuantity + PRINT_BUY_COUNT);
    }

    public int getTotalBuyQuantity(int amount) {
        return amountToQuantity(amount);
    }

    public int amountToQuantity(int amount) {
        return amount / LOTTO_ONE_PRICE_AMOUNT;
    }

}
