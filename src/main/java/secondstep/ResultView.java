package secondstep;

import java.util.Arrays;
import java.util.Scanner;

public class ResultView {
    public static final String LAST_WEEK_WINNER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final Scanner SCANNER = new Scanner(System.in);

    public int[] resultViewStart() {
        String[] winnerNumbers = printLastWeekWinningNumber();
        return getLastWeekWinnerNumbers(winnerNumbers);
    }

    public String[] printLastWeekWinningNumber() {
        System.out.println(LAST_WEEK_WINNER_MESSAGE);
        return SCANNER.nextLine().split(",");
    }

    private static int[] getLastWeekWinnerNumbers(String[] winnerNumbers) {
        return Arrays.stream(winnerNumbers).mapToInt(Integer::parseInt).toArray();
    }
}
