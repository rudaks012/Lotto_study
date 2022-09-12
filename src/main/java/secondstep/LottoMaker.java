package secondstep;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {

    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_MIN_NUMBER = 0;
    public static final int SIX_NUMBER_PER_SHEET_LOTTO = 6;
    public static final List<List<Integer>> lottoMaker = new ArrayList<>();

    public List<List<Integer>> lottoNumberGeneration(int autoLottoCount, int manualBuyLottoCount) {
        InputView inputView = new InputView();
        createNotDuplicationLottoNumber(autoLottoCount, manualBuyLottoCount);
        inputView.printLottoNumbers();
        return lottoMaker;
    }

    private void createNotDuplicationLottoNumber(int autoLottoCount, int manualBuyLottoCount) {
        ManualLottoBuy manualLottoBuy = new ManualLottoBuy();

        for (int i = 0; i <manualBuyLottoCount ; i++) {
            lottoMaker.add(manualLottoBuy.getManualNumbers());
        }
        for (int i = 1; i <= autoLottoCount; i++) {
            List<Integer> lottoNumberList = getLottoNumberList();
            Collections.shuffle(lottoNumberList);
            lottoMaker.add(lottoNumberList.subList(LOTTO_MIN_NUMBER, SIX_NUMBER_PER_SHEET_LOTTO));
        }
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
}
