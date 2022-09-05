package firststep;

import java.util.Arrays;

public class StringPlusCalculator {

    public static final String DELIMITER = "[,|:]";

//    public static final Pattern PATTERN = Pattern.compile("//(.)\\n(.*)");
//    public static final int FIRST_INDEX = 1;
//    public static final int SECOND_INDEX = 2;
    public static final int ZERO = 0;
//    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";ß

    public int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return ZERO;
        }
        String[] splitStrings = splitString(input);

        return sum(splitStrings);
    }

    private String[] splitString(String input) {

        if (input.startsWith("//")) {
            String[] separatedStrings = new String[0];
            for (int i = 0; i < input.length(); i++) {
                String customDelimiter = input.substring(2, 3);
                String substringInput = input.substring(4);
                separatedStrings = substringInput.split(customDelimiter);
            }
            return separatedStrings;
        }
        return input.split(DELIMITER);
//        Matcher matcher = PATTERN.matcher(input);
//        if (!matcher.find()) {
//            return input.split(DELIMITER);
//        }
//
//        String delimiter = matcher.group(FIRST_INDEX);
//        return matcher.group(SECOND_INDEX).split(delimiter);
    }

    private static int sum(String[] splitStrings) {
        return Arrays.stream(splitStrings)
                .mapToInt(StringPlusCalculator::StringChangeNumber)
                .sum();
    }

    private static int StringChangeNumber(String input) {
        int StringToNumber = Integer.parseInt(input);
        int StringToNu1mber = Integer.parseInt(input);

        negativeNumberFormula(StringToNumber);

        return StringToNumber;
    }

    private static void negativeNumberFormula(int targetNumber) {
        if (targetNumber < ZERO) {
            throw new RuntimeException("음수가 발생하면 안됩니다");
        }
    }
}
