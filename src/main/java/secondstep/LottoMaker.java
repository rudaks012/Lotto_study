package secondstep;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {

    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_FIRST_NUMBER = 0;
    public static final int LOTTO_LAST_NUMBER = 6;

    public List<List<Integer>> lottoNumberGeneration(int totalBuyQuantity) {
        List<List<Integer>> lottoMaker = new ArrayList<>();
        for (int i = 1; i <= totalBuyQuantity; i++) {
            List<Integer> lottoNumberList = getLottoNumberList();
            Collections.shuffle(lottoNumberList);
            lottoMaker.add(lottoNumberList.subList(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER));
        }
        printLottoNumbers(lottoMaker);
        return lottoMaker;
    }

    private List<Integer> getLottoNumberList() {
        List<Integer> lottoNumberList = new ArrayList<>();
        addLottoNumber(lottoNumberList);
        return lottoNumberList;
    }

    private void addLottoNumber(List<Integer> lottoNumberList) {
        for (int j = 1; j <= LOTTO_MAX_NUMBER; j++) {
            lottoNumberList.add(j);
        }
    }

    private void printLottoNumbers(List<List<Integer>> lottoMaker) {
        for (List<Integer> printLottoNumbers : lottoMaker) {
            System.out.println(printLottoNumbers);
        }
    }

}
