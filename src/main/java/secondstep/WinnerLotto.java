package secondstep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerLotto {
    public static final int LOTTO_NUMBER_THREE_MATCH = 3;
    public static final int LOTTO_NUMBER_FOUR_MATCH = 4;
    public static final int LOTTO_NUMBER_FIVE_MATCH = 5;
    public static final int LOTTO_NUMBER_SIX_MATCH = 6;

    private static int oneRank;
    private static int secondRank;
    private static int thirdRank;
    private static int fourRank;
    private static int fiveRank;

    public void winnerLottoGame() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int amount = BuyAmount.getAmount();

        List<List<Integer>> userLottoNumbers = inputView.lottoGameStart(amount);
        int[] winnerLottoNumbers = resultView.resultViewStart();

        int bonusLottoNumber = resultView.getBounsLottoNumber();
        lottoWinnerCount(userLottoNumbers, winnerLottoNumbers, bonusLottoNumber);
        resultView.printLotto(amount);
    }

    public void lottoWinnerCount(List<List<Integer>> userLottoNumbers, int[] winnerLottoNumbers, int bounsLottoNumber) {
        for (List<Integer> userLottoNumber : userLottoNumbers) {
            boolean matchBounsLottoNumber = userLottoNumber.contains(bounsLottoNumber);
            int count = 0;
            count = getCount(winnerLottoNumbers, userLottoNumber, count);
            prizeStatistics(count, matchBounsLottoNumber);
        }
    }

    public int getCount(int[] winnerLottoNumbers, List<Integer> userLottoNumber, int count) {
        for (int i = 0; i < 6; i++) {
            if (userLottoNumber.contains(winnerLottoNumbers[i])) {
                count++;
            }
        }
        return count;
    }

    private void prizeStatistics(int count, boolean bonusMatch) {
        if (count == LOTTO_NUMBER_THREE_MATCH && !bonusMatch) {
            fiveRank++;
        } else if (count == LOTTO_NUMBER_FOUR_MATCH && !bonusMatch) {
            fourRank++;
        } else if (count == LOTTO_NUMBER_FIVE_MATCH && !bonusMatch) {
            thirdRank++;
        } else if (count == LOTTO_NUMBER_FIVE_MATCH) {
            secondRank++;
        } else if (count == LOTTO_NUMBER_SIX_MATCH && !bonusMatch) {
            oneRank++;
        }
    }

    public static Map<String, Integer> printLottoStatistics() {
        Map<String, Integer> lottoStatistics = new HashMap<>();
        lottoStatistics.put("fiveRank", fiveRank);
        lottoStatistics.put("fourRank", fourRank);
        lottoStatistics.put("thirdRank", thirdRank);
        lottoStatistics.put("secondRank", secondRank);
        lottoStatistics.put("oneRank", oneRank);
        return lottoStatistics;
    }

//    public void lottoWinnerCount2(List<LottoNumber> userLottoNumbers, int[] winnerLottoNumbers, int bounsLottoNumber) {
//        for (LottoNumber userLottoNumber : userLottoNumbers) {
//            boolean matchBounsLottoNumber = userLottoNumber.contains(bounsLottoNumber);
//            int count = 0;
//            count = getCount2(winnerLottoNumbers, userLottoNumber, count);
//            prizeStatistics(count, matchBounsLottoNumber);
//        }
//    }
//
//    public int getCount2(int[] winnerLottoNumbers, LottoNumber userLottoNumber, int count) {
//        for (int i = 0; i < 6; i++) {
//            if (userLottoNumber.contains(winnerLottoNumbers[i])) {
//                count++;
//            }
//        }
//        return count;
//    }
}
