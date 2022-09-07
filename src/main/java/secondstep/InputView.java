package secondstep;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String PRINT_BUY_COUNT = "개를 구매 했습니다.";

    public List<List<Integer>> lottoGameStart(int amount) {
        LottoMaker lottoMaker = new LottoMaker();
        BuyAmount buyAmount = new BuyAmount();

        int totalBuyQuantity = buyAmount.getTotalBuyQuantity(amount);
        printTotalBuyQuantity(totalBuyQuantity);
        printLottoNumbers();
        return lottoMaker.lottoNumberGeneration(totalBuyQuantity);
    }

    public void printTotalBuyQuantity(int totalBuyQuantity) {
        System.out.println(totalBuyQuantity + PRINT_BUY_COUNT);
    }

    private void printLottoNumbers() {
        for (List<Integer> printLottoNumbers : LottoMaker.lottoMaker) {
            System.out.println(printLottoNumbers);
        }
    }

}
