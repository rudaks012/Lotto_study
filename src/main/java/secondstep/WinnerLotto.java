package secondstep;

import java.util.Arrays;
import java.util.List;

public class WinnerLotto {
    public void winnerLottoGame() {
        InputView inputView = new InputView();
        List<List<Integer>> userLottoNumbers =  inputView.lottoGameStart();
        System.out.println("userLottoNumbers 123123123= " + userLottoNumbers);

        ResultView resultView = new ResultView();
        List<int[]> winnerLottoNumbers = resultView.resultViewStart();


    }
}
