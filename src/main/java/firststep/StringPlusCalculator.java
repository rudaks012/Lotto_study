package firststep;

import java.util.Arrays;

public class StringPlusCalculator {

    public static final String DELIMITER = "[,|:]";

    public int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] splitStrings = input.split(DELIMITER);

        return Arrays.stream(splitStrings)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
