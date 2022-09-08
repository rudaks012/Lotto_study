package thirdstep;

import java.util.Objects;

public class LottoNumber {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    private final int number;

    public LottoNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 넘버는 1과 45사이 입니다");
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
