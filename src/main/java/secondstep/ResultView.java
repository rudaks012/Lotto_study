package secondstep;

import java.util.Scanner;

public class ResultView {
    public static final String LAST_WEEK_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String[] printLastWeekWinningNumber() {
        System.out.println(LAST_WEEK_MESSAGE);
        return SCANNER.nextLine().split(",");
    }
}
