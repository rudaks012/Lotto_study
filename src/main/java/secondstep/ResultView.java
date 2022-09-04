package secondstep;

import java.util.Arrays;
import java.util.Scanner;

public class ResultView {
    public static final String LAST_WEEK_WINNER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String LAST_WEEK_WINNER_NUMBER_VALIDATION_MESSAGE = "지난 주 당첨 번호는 6개 입니다.";

    public int[] resultViewStart() {
        String[] winnerNumbers = printLastWeekWinningNumber();
        lastWeekWinnerNumberValidation(winnerNumbers);
        return getLastWeekWinnerNumbers(winnerNumbers);
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
