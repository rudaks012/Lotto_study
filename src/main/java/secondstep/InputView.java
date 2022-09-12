package secondstep;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String LAST_WEEK_WINNER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    public List<List<Integer>> lottoGameStart(int amount) {
        LottoMaker lottoMaker = new LottoMaker();
        BuyAmount buyAmount = new BuyAmount();
        ManualLottoBuy manualLottoBuy = new ManualLottoBuy();

        int manualBuyLottoCount = manualLottoBuy.manualLottoCount();
        int autoLottoCount = (buyAmount.getTotalBuyQuantity(amount) - manualBuyLottoCount);

        printTotalBuyQuantity(autoLottoCount, manualBuyLottoCount);
        manualLottoBuy.manualBuyLottoNumber();
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
}
