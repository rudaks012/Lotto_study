package secondsteptest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import secondstep.AmountException;
import secondstep.BuyAmount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyAmountTest {

    private BuyAmount buyAmount = new BuyAmount();

    @ParameterizedTest(name = "로또 구매비용이 천원보다 작으면 예외가 발생한다. : [{index}] : [arguments]")
    @DisplayName("로또 구매비용이 천원보다 작으면 예외가 발생한다.")
    @ValueSource(ints = {
            700,
            800,
            900
    })
    void throw_exception_lotto_buy_cost_less_thousand(int lottoBuyMoney) {

        assertThatThrownBy(() -> buyAmount.amountExceptionValidation(lottoBuyMoney))
                .isInstanceOf(AmountException.class)
                .hasMessage("입력값 "+ lottoBuyMoney+"원은 천원 보다 작습니다.");
    }

    @ParameterizedTest(name = "로또 구매비용은 천원 단위로 입력 해야 합니다. : [{index}] : [{arguments}]")
    @DisplayName("로또 구매비용은 천원 단위로 입력 해야 합니다.")
    @ValueSource(ints = {
            1300,
            2300,
            4400
    })
    void you_must_enter_in_thousands_of_won(int lottoBuyMoney) {
        assertThatThrownBy(() -> buyAmount.amountExceptionMustThousand(lottoBuyMoney))
                .isInstanceOf(AmountException.class)
                .hasMessageContaining("천원 단위로 ");
    }

    @ParameterizedTest(name = "로또는 한장당 천원이다 : [{index}] : [{arguments}]")
    @DisplayName("로또는 한장당 천원이다")
    @CsvSource(value = {
            "3000, 3",
            "4000, 4",
            "2000, 2",
    })
    void lotto_ticket_is_thousands_won(int lottoBuyMoney, int excepted) {
        int actual = buyAmount.amountToQuantity(lottoBuyMoney);

        assertThat(actual).isEqualTo(excepted);
    }
}
