package firststep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlusCalculator {
    private static final String SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR = "//(.)\\n(.*)";

    public int calculator(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] strings = separatorSplit(input);
        int sum = 0;
        int toNumber = 0;
        for (String string : strings) {
            toNumber= Integer.parseInt(string);
            numberValidation(toNumber);
            sum += toNumber;
        }

        return sum;

    }

    private static void numberValidation(int toNumber) {
        if (toNumber < 0) {
            throw new RuntimeException("음수를 허용하지 않습니다.");
        }
    }

    private String[] separatorSplit(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_SEPARATOR);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find()) {
            return input.split(SEPARATOR);
        }
        String separator = matcher.group(1);
        return matcher.group(2).split(separator);
    }
}
