package secondstep;

import java.util.List;

public class WinnerLotto {
    public static final int LOTTO_NUMBER_THREE_MATCH = 3;
    public static final int LOTTO_NUMBER_FOUR_MATCH = 4;
    public static final int LOTTO_NUMBER_FIVE_MATCH = 5;
    public static final int LOTTO_NUMBER_SIX_MATCH = 6;
    private int three = 0;
    private int four = 0;
    private int five = 0;
    private int six = 0;

    public void winnerLottoGame() {
        InputView inputView = new InputView();
        List<List<Integer>> userLottoNumbers = inputView.lottoGameStart();

        ResultView resultView = new ResultView();
        int[] winnerLottoNumbers = resultView.resultViewStart();


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
