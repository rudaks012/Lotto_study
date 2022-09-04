package secondstep;

<<<<<<< HEAD
import java.util.HashMap;
=======
>>>>>>> b581ead1f0b3ceb67afd88ad1a4cc7b650f36e77
import java.util.List;
import java.util.Map;

public class WinnerLotto {
    public static final int LOTTO_NUMBER_THREE_MATCH = 3;
    public static final int LOTTO_NUMBER_FOUR_MATCH = 4;
    public static final int LOTTO_NUMBER_FIVE_MATCH = 5;
    public static final int LOTTO_NUMBER_SIX_MATCH = 6;
<<<<<<< HEAD
    private int threeMatch = 0;
    private int fourMatch = 0;
    private int fiveMatch = 0;
    private int sixMatch = 0;

    public Map<String, Integer> winnerLottoGame() {
        InputView inputView = new InputView();

=======
    private int three = 0;
    private int four = 0;
    private int five = 0;
    private int six = 0;

    public void winnerLottoGame() {
        InputView inputView = new InputView();
>>>>>>> b581ead1f0b3ceb67afd88ad1a4cc7b650f36e77
        List<List<Integer>> userLottoNumbers = inputView.lottoGameStart();

        ResultView resultView = new ResultView();
        int[] winnerLottoNumbers = resultView.resultViewStart();


<<<<<<< HEAD
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
=======
        for (int i = 0; i < userLottoNumbers.size(); i++) {
            List<Integer> userLottoNumber = userLottoNumbers.get(i);
            int count = 0;
            count = getCount(winnerLottoNumbers, userLottoNumber, count);

            prizeStatistics(count);
        }
    }

    private static int getCount(int[] winnerLottoNumbers, List<Integer> userLottoNumber, int count) {
        for (int j = 0; j < 6; j++) {
            if (userLottoNumber.contains(winnerLottoNumbers[j])) {
                count++;
            }
        }
        return count;
    }
>>>>>>> b581ead1f0b3ceb67afd88ad1a4cc7b650f36e77

    private void prizeStatistics(int count) {
        if (count == LOTTO_NUMBER_THREE_MATCH) {
            three++;
        } else if (count == LOTTO_NUMBER_FOUR_MATCH) {
            four++;
        } else if (count == LOTTO_NUMBER_FIVE_MATCH) {
            five++;
        } else if (count == LOTTO_NUMBER_SIX_MATCH) {
            six++;
        }
    }


}
