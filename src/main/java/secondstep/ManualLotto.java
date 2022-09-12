//package secondstep;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//public class ManualLotto {
//
//    private final List<Integer> manualNumbers;
//
//    public ManualLotto(List<Integer> manualNumbers) {
//        this.manualNumbers = manualNumbers;
//    }
//
//    public ManualLotto getManualNumbers() {
//        int[] getStringManualNumber = getChangeIntegerNumbers();
//
//        return (ManualLotto) Arrays.stream(getStringManualNumber)
//                .boxed()
//                .collect(Collectors.toList());
//    }
//
//    private int[] getChangeIntegerNumbers() {
//        InputView inputView = new InputView();
//
//        return Arrays.stream(inputView.getManualLotto())
//                .mapToInt(Integer::parseInt)
//                .toArray();
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ManualLotto that = (ManualLotto) o;
//        return Objects.equals(manualNumbers, that.manualNumbers);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(manualNumbers);
//    }
//}
