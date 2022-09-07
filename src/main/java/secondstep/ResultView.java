package secondstep;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class ResultView {

    public static final int BONUS_LOTTO_NUMBER_MIN = 1;
    public static final int BONUS_LOTTO_NUMBER_MAX = 45;
    public static final int WINNER_LOTTO_NUMBERS_LIMIT = 6;
    private static final int FIRST_REWARD = 2_000_000_000;
    private static final int SECOND_REWARD = 3_000_000_0;
    private static final int THIRD_REWARD = 1_500_000;
    private static final int FORTH_REWARD = 50_000;
    private static final int FIVE_REWARD = 5_000;
    public static final String LAST_WEEK_WINNER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String LAST_WEEK_WINNER_NUMBER_VALIDATION_MESSAGE = "지난 주 당첨 번호는 6개 입니다.";
    public static final String BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String LOTTO_BONUS_NUMBER_IS_ONE_BETWEEN_FORTY_FIVE = "로또의 보너스 넘버는 1에서 45 사이의 숫자입니다";

    public static final Scanner SCANNER = new Scanner(System.in);

    private int bounsLottoNumber;

    public int[] resultViewStart() {
        String[] winnerNumbers = printLastWeekWinningNumber();
        bounsLottoNumber = bonusBallNumber();
        verifyLottoNumbers(winnerNumbers);
        return getLastWeekWinnerNumbers(winnerNumbers);
    }

    private int bonusBallNumber() {
        System.out.println(BONUS_BALL_NUMBER_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

    private void verifyLottoNumbers(String[] winnerNumbers) {
        bonusLottoNumberValidation(bounsLottoNumber);
        lastWeekWinnerNumberValidation(winnerNumbers);
    }

    public void bonusLottoNumberValidation(int bounsLottoNumber) {
        if (bounsLottoNumber < BONUS_LOTTO_NUMBER_MIN || bounsLottoNumber > BONUS_LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(LOTTO_BONUS_NUMBER_IS_ONE_BETWEEN_FORTY_FIVE);
        }
    }

    public void lastWeekWinnerNumberValidation(String[] winnerNumbers) {
        if (winnerNumbers.length < WINNER_LOTTO_NUMBERS_LIMIT) {
            throw new IllegalArgumentException(LAST_WEEK_WINNER_NUMBER_VALIDATION_MESSAGE);
        }
    }

    public String[] printLastWeekWinningNumber() {
        System.out.println(LAST_WEEK_WINNER_MESSAGE);
        return SCANNER.nextLine().split(",");
    }

    public int[] getLastWeekWinnerNumbers(String[] winnerNumbers) {
        return Arrays.stream(winnerNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int getBounsLottoNumber() {
        return bounsLottoNumber;
    }

    public void printLotto(int amount) {
        Map<String, Integer> printWinner = WinnerLotto.printLottoStatistics();

        System.out.println("당첨 통계");
        System.out.println("------");
        System.out.println("3개 일치 (5000원)-" + printWinner.get("fiveRank") + "개");
        System.out.println("4개 일치 (50000원)-" + printWinner.get("fourRank") + "개");
        System.out.println("5개 일치 (1500000원)-" + printWinner.get("thirdRank") + "개");
        System.out.println("5개 일치, 보너스볼 일치 (3000000원)-" + printWinner.get("secondRank") + "개");
        System.out.println("6개 일치 (200000000원)-" + printWinner.get("oneRank") + "개");
        double result = getResult(printWinner, amount);
        System.out.println("총 수익률은 : " + result + "입니다.");
    }

    public double getResult(Map<String, Integer> printWinner, int amount) {
        return ((printWinner.get("oneRank") * FIRST_REWARD) + (printWinner.get("secondRank") * SECOND_REWARD) +
                (printWinner.get("thirdRank") * THIRD_REWARD) + (printWinner.get("fourRank") * FORTH_REWARD)
                + printWinner.get("fiveRank") * FIVE_REWARD) / amount;
    }
}


