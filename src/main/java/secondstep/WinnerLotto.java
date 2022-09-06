package secondstep;

import java.util.List;

public class WinnerLotto {
    public static final int LOTTO_NUMBER_THREE_MATCH = 3;
    public static final int LOTTO_NUMBER_FOUR_MATCH = 4;
    public static final int LOTTO_NUMBER_FIVE_MATCH = 5;
    public static final int LOTTO_NUMBER_SIX_MATCH = 6;

    private static final int FIRST_REWARD = 2_000_000_000;
    private static final int SECOND_REWARD = 1_500_000;
    private static final int THIRD_REWARD = 50_000;
    private static final int FORTH_REWARD = 5_000;
    private int fiveRank;
    private int fourRank;
    private int thirdRank;
    private int secondRank;
    private int oneRank;
    private int amount;

    public void winnerLottoGame() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        amount = inputView.getAmount();
        List<List<Integer>> userLottoNumbers = inputView.lottoGameStart(amount);
        int[] winnerLottoNumbers = resultView.resultViewStart();
        int bonusLottoNumber = resultView.getBounsLottoNumber();
        lottoWinnerCount(userLottoNumbers, winnerLottoNumbers, bonusLottoNumber);
        printLottoStatistics();
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

    private void prizeStatistics(int count, boolean bonusMathch) {
        if (count == LOTTO_NUMBER_THREE_MATCH && !bonusMathch) {
            fiveRank++;
        } else if (count == LOTTO_NUMBER_FOUR_MATCH && !bonusMathch) {
            fourRank++;
        } else if (count == LOTTO_NUMBER_FIVE_MATCH && !bonusMathch) {
            thirdRank++;
        } else if (count == LOTTO_NUMBER_FIVE_MATCH) {
            secondRank++;
        } else if (count == LOTTO_NUMBER_SIX_MATCH && !bonusMathch) {
            oneRank++;
        }
    }

    public void printLottoStatistics() {
        System.out.println("당첨 통계");
        System.out.println("------");
        System.out.println("3개 일치 (5000원)-" + fiveRank + "개");
        System.out.println("4개 일치 (50000원)-" + fourRank + "개");
        System.out.println("5개 일치 (1500000원)-" + thirdRank + "개");
        System.out.println("5개 일치, 보너스볼 일치 (3000000원)-" + secondRank + "개");
        System.out.println("6개 일치 (200000000원)-" + oneRank + "개");
        double result = getResult();
        System.out.println("총 수익률은 : " + result + "입니다.");
    }

    public double getResult() {
        return ((oneRank * FIRST_REWARD) + (secondRank * SECOND_REWARD) + (fourRank * THIRD_REWARD) + (fiveRank * FORTH_REWARD)) / amount;
    }
}
