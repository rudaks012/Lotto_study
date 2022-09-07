package secondstep;

public class LottoNumberException extends Exception {

    public static final String LOTTO_BONUS_NUMBER_IS_ONE_BETWEEN_FORTY_FIVE = "입력값: %d 번호는 1에서 45 사이의 숫자가 아닙니다";
    public static final String LAST_WEEK_WINNER_NUMBER_VALIDATION_MESSAGE = "지난 주 당첨 번호는 6개 입니다.";

    public LottoNumberException() {
        super(String.format(LAST_WEEK_WINNER_NUMBER_VALIDATION_MESSAGE));
    }

    public LottoNumberException(int bounsLottoNumber) {
        super(String.format(LOTTO_BONUS_NUMBER_IS_ONE_BETWEEN_FORTY_FIVE, bounsLottoNumber));
    }
}
