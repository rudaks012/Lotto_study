package secondstep;

import java.util.Arrays;
import java.util.Scanner;

public class ResultView {
    public static final String LAST_WEEK_WINNER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String LAST_WEEK_WINNER_NUMBER_VALIDATION_MESSAGE = "지난 주 당첨 번호는 6개 입니다.";
    public static final String BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final Scanner SCANNER = new Scanner(System.in);

    public int[] resultViewStart() {
        String[] winnerNumbers = printLastWeekWinningNumber();
        int bonusBall = bonusBallNumber();
        lastWeekWinnerNumberValidation(winnerNumbers);
        return getLastWeekWinnerNumbers(winnerNumbers);
    }

    private static int bonusBallNumber() {
        System.out.println(BONUS_BALL_NUMBER_MESSAGE);

        return Integer.parseInt(SCANNER.nextLine());
    }

    public void lastWeekWinnerNumberValidation(String[] winnerNumbers) {
        if (winnerNumbers.length < 7) {
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
}
