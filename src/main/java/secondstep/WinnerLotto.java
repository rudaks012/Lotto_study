package secondstep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerLotto {
    public static final int LOTTO_NUMBER_THREE_MATCH = 3;
    public static final int LOTTO_NUMBER_FOUR_MATCH = 4;
    public static final int LOTTO_NUMBER_FIVE_MATCH = 5;
    public static final int LOTTO_NUMBER_SIX_MATCH = 6;
    private int threeMatch = 0;
    private int fourMatch = 0;
    private int fiveMatch = 0;
    private int sixMatch = 0;

    public Map<String, Integer> winnerLottoGame() {
        InputView inputView = new InputView();

        List<List<Integer>> userLottoNumbers = inputView.lottoGameStart();

        ResultView resultView = new ResultView();
        int[] winnerLottoNumbers = resultView.resultViewStart();


        for (List<Integer> userLottoNumber : userLottoNumbers) {
            int count = 0;
            count = getCount(winnerLottoNumbers, userLottoNumber, count);
            prizeStatistics(count);
        }
        Map<String, Integer> matchStatistics = getMatchStatistics();
        return matchStatistics;
    }
    private Map<String, Integer> getMatchStatistics() {
        Map<String,Integer> matchStatistics = new HashMap<>();
        matchStatistics.put("threeMatch",threeMatch);
        matchStatistics.put("fourMatch",fourMatch);
        matchStatistics.put("fiveMatch",fiveMatch);
        matchStatistics.put("sixMatch",sixMatch);
        return matchStatistics;
    }

    private static int getCount(int[] winnerLottoNumbers, List<Integer> userLottoNumber, int count) {
        for (int j = 0; j < 6; j++) {
            if (userLottoNumber.contains(winnerLottoNumbers[j])) {
                count++;
            }
        }
        return count;
    }

    private void prizeStatistics(int count) {
        if (count == LOTTO_NUMBER_THREE_MATCH) {
            threeMatch++;
        } else if (count == LOTTO_NUMBER_FOUR_MATCH) {
            fourMatch++;
        } else if (count == LOTTO_NUMBER_FIVE_MATCH) {
            fiveMatch++;
        } else if (count == LOTTO_NUMBER_SIX_MATCH) {
            sixMatch++;
        }

    }


}
