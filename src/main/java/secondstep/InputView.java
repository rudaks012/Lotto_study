package secondstep;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String PRINT_BUY_COUNT = "개를 구매 했습니다.";

    public static final int LOTTO_ONE_PRICE_AMOUNT = 1000;

    public List<List<Integer>> lottoGameStart(int amount) {
        LottoMaker lottoMaker = new LottoMaker();
        int totalBuyQuantity = getTotalBuyQuantity(amount);
        printTotalBuyQuantity(totalBuyQuantity);

        return lottoMaker.lottoNumberGeneration(totalBuyQuantity);
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
