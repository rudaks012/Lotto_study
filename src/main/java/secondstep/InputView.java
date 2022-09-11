package secondstep;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String PRINT_BUY_COUNT = "수동으로 %d장, 자동으로 %d개를 구매 했습니다.";
    public static final String LAST_WEEK_WINNER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String MANUAL_BUY_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MANUAL_BUY_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    public static final Scanner SCANNER = new Scanner(System.in);

    public List<List<Integer>> lottoGameStart(int amount) {
        LottoMaker lottoMaker = new LottoMaker();
        BuyAmount buyAmount = new BuyAmount();

        int totalBuyQuantity = buyAmount.getTotalBuyQuantity(amount);
        int manualBuyLottoCount = manualLottoCount();

        printTotalBuyQuantity(totalBuyQuantity, manualBuyLottoCount);
        printLottoNumbers();
        return lottoMaker.lottoNumberGeneration(totalBuyQuantity);
    }

    public void printTotalBuyQuantity(int totalBuyQuantity, int manualBuyLottoCount) {
        System.out.println("수동으로" + manualBuyLottoCount + "장, " + "자동으로 " + (totalBuyQuantity - manualBuyLottoCount) + "개를 구매 했습니다.");
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

    public int manualLottoCount() {
        System.out.println(MANUAL_BUY_LOTTO_COUNT);
        return SCANNER.nextInt();
    }

    public String manualBUyLottoNumber() {
        System.out.println(MANUAL_BUY_LOTTO_NUMBER);
        return SCANNER.nextLine();
    }
}
