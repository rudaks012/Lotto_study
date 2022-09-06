package secondstep;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {

    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_FIRST_NUMBER = 0;
    public static final int SIX_NUMBER_PER_SHEET_LOTTO = 6;
    public static final List<List<Integer>> lottoMaker = new ArrayList<>();

    public List<List<Integer>> lottoNumberGeneration(int totalBuyQuantity) {
        for (int i = 1; i <= totalBuyQuantity; i++) {
            List<Integer> lottoNumberList = getLottoNumberList();
            Collections.shuffle(lottoNumberList);
            lottoMaker.add(lottoNumberList.subList(LOTTO_FIRST_NUMBER, SIX_NUMBER_PER_SHEET_LOTTO));
        }
        printLottoNumbers();
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

    private void printLottoNumbers() {
        for (List<Integer> printLottoNumbers : LottoMaker.lottoMaker) {
            System.out.println(printLottoNumbers);
        }
    }

}
