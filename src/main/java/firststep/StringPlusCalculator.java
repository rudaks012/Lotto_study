package firststep;

public class StringPlusCalculator {
    public int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] strings = input.split(",");
        int sum = 0;
        for (String string : strings) {
            int parseInt = Integer.parseInt(string);
            sum += parseInt;
        }
        return sum;
    }
}
