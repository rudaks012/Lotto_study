package weblotto;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public LottoManager() {
        startLotto();
    }

    private void startLotto() {
        LottoTicketMaker lottoTicketMaker = new LottoTicketMaker();
        List<LottoTicket> tickets = new ArrayList<>();

        inputView.askAmount();
        tickets = lottoTicketMaker.buyAvailableLottoTickets(lottoTicketMaker.calculateAvailableCount(inputView.getAmount()));
        resultView.showLottoTickets(tickets);

        drawLotto(tickets);
    }

    private void drawLotto(List<LottoTicket> tickets) {
        WinningTicketSelector winningTicketSelector = new WinningTicketSelector(inputView.askWinningNumbers());

        resultView.showStatistics(winningTicketSelector.ca);
    }
}
