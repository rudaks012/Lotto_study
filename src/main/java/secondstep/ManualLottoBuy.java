package secondstep;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ManualLottoBuy {
    public static final String MANUAL_BUY_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MANUAL_BUY_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    public int manualLottoCount() {
        System.out.println(MANUAL_BUY_LOTTO_COUNT);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void manualBuyLottoNumber() {
        System.out.println(MANUAL_BUY_LOTTO_NUMBER);
    }


    public List<String> getManualNumbers(int manualBuyLottoCount) {

        return IntStream.range(0, manualBuyLottoCount)
                .mapToObj(i -> getManualLotto())
                .collect(Collectors.toList());

    }

    private static String getManualLotto() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
