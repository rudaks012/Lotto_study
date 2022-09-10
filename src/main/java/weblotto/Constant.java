package weblotto;

public class Constant {

    public static final String AMOUNT_MESSAGE_QUESTION = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBERS_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BOUGHT_LOTTO_TICKETS = "개를 구매했습니다.";
    public static final String WINNING_NUMBER_SEPERATOR = ",";
    public static final String WINNING_STATISTICS = "당첨 통계";
    public static final String WINNING_STATISTICS_DIVISION = "---------";
    public static final String PROFIT_RATIO = "총 수익률 : ";
    public static final String SAME = "일치";
    public static final String UNIT_COUNT = "개";
    public static final String UNIT_PRIZE = "원";
    public static final String BLANK = " ";
    public static final String DASH = "-";

    public static final String PRIZE_WRAPPER(String prize) {
        return "(" + prize + ")";
    }

    public static final int ZERO = 0;
    public static final int COUNT_ONE = 1;
    public static final int COUNT_THREE = 3;
    public static final int COUNT_FOUR = 4;
    public static final int COUNT_FIVE = 5;
    public static final int COUNT_SIX = 6;
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    public static final int LOTTO_PICK_COUNT = 6;
    public static final int LOTTO_PRIZE_FIRST = 2000000000;
    public static final int LOTTO_PRIZE_SECOND = 1500000;
    public static final int LOTTO_PRIZE_THIRD = 50000;
    public static final int LOTTO_PRIZE_FOURTH = 5000;
}
