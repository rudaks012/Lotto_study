package firststep;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlusCalculator {

    public static final String DELIMITER = "[,|:]";
    public static final Pattern PATTERN = Pattern.compile("//(.)\\n(.*)");
    public static final int FIRST_INDEX = 1;
    public static final int SECOUND_INDEX = 2;

    public int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] splitStrings = splitString(input);

        return Arrays.stream(splitStrings)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String[] splitString(String input) {
        Matcher matcher = PATTERN.matcher(input);

        if (!matcher.find()) {
            return input.split(DELIMITER);
        }

        String delimiter = matcher.group(FIRST_INDEX);
        return matcher.group(SECOUND_INDEX).split(delimiter);
    }
}
