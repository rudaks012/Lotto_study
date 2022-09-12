package secondstep;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String LAST_WEEK_WINNER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String MANUAL_BUY_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String MANUAL_BUY_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";


    public List<List<Integer>> lottoGameStart(int amount) {
        LottoMaker lottoMaker = new LottoMaker();
        BuyAmount buyAmount = new BuyAmount();

        int manualBuyLottoCount = manualLottoCount();
        int autoLottoCount = (buyAmount.getTotalBuyQuantity(amount) - manualBuyLottoCount);

        printTotalBuyQuantity(autoLottoCount, manualBuyLottoCount);
        manualBuyLottoNumber();
        printLottoNumbers();
        return lottoMaker.lottoNumberGeneration(autoLottoCount, manualBuyLottoCount);
    }

    public void printTotalBuyQuantity(int autoLottoCount, int manualBuyLottoCount) {
        System.out.println("수동으로" + manualBuyLottoCount + "장, " + "자동으로 " + (autoLottoCount) + "개를 구매 했습니다.");
    }

    public void printLottoNumbers() {
        for (List<Integer> printLottoNumbers : LottoMaker.lottoMaker) {
            System.out.println(printLottoNumbers);
        }
    }

    public String[] printLastWeekWinningNumber() {
        System.out.println(LAST_WEEK_WINNER_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(",");
    }

    public int bonusBallNumber() {
        System.out.println(BONUS_BALL_NUMBER_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void manualBuyLottoNumber() {
        System.out.println(MANUAL_BUY_LOTTO_NUMBER);
    }

    public String[] getManualLotto() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(",");
    }


    public int manualLottoCount() {
        System.out.println(MANUAL_BUY_LOTTO_COUNT);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
