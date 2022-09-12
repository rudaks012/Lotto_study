package secondstep;

import secondstep.view.InputView;

import java.util.*;
import java.util.stream.Collectors;

public class ManualLottoBuy {

    public List<Integer> getManualNumbers() {
        int[] getStringManualNumber = getChangeIntegerNumbers();

        return Arrays.stream(getStringManualNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    private int[] getChangeIntegerNumbers() {
        InputView inputView = new InputView();
        if (inputView.getManualLotto().length < 1) {

        }
        return Arrays.stream(inputView.getManualLotto())
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
