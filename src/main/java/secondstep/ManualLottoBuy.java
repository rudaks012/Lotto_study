package secondstep;

import java.util.*;
import java.util.stream.Collectors;

public class ManualLottoBuy {


    public List<Integer> getManualNumbers() {
        int[] getStringManualNumber = getStringsNumbers();

        return Arrays.stream(getStringManualNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    private int[] getStringsNumbers() {
        InputView inputView = new InputView();
        return Arrays.stream(inputView.getManualLotto())
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
