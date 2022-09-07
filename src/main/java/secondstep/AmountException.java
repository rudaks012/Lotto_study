package secondstep;

public class AmountException extends RuntimeException {
    public static final String EXCEPTION_MONEY_IS_LESS_THOUSAND = "입력값 %d원은 천원 보다 작습니다.";
    public static final String EXCEPTION_THOUSAND_INSERT = "천원 단위로 입력 해야 합니다.";

    public AmountException() {
        super(String.format(EXCEPTION_THOUSAND_INSERT));
    }
    public AmountException(int amount) {
        super(String.format(EXCEPTION_MONEY_IS_LESS_THOUSAND, amount));
    }
}
