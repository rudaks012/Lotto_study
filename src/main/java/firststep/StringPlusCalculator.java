package firststep;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlusCalculator {

    public static final String DELIMITER = "[,|:]";
    public static final Pattern PATTERN = Pattern.compile("//(.)\\n(.*)");
    public static final int FIRST_INDEX = 1;
    public static final int SECOND_INDEX = 2;
    public static final int ZERO = 0;

    public int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return ZERO;
        }
        String[] splitStrings = splitString(input);

        return getSum(splitStrings);
    }

    private String[] splitString(String input) {
        Matcher matcher = PATTERN.matcher(input);

        if (!matcher.find()) {
            return input.split(DELIMITER);
        }

        String delimiter = matcher.group(FIRST_INDEX);
        return matcher.group(SECOND_INDEX).split(delimiter);
    }

    private static int getSum(String[] splitStrings) {
        return Arrays.stream(splitStrings)
                .mapToInt(StringPlusCalculator::StringChangeNumber)
                .sum();
    }

    private static int StringChangeNumber(String input) {
        int StringToNumber = Integer.parseInt(input);

        negativeVerification(StringToNumber);

        return StringToNumber;
    }

    private static void negativeVerification(int number) {
        if (number < 0) {
            throw new RuntimeException("음수가 발생하면 안됩니다");
        }
    }


}
