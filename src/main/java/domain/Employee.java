package domain;

import java.math.BigDecimal;

public class Employee {
    private static final int TENTH_BASE = 10 / 100;
    private static final int THERTINTH_BASE = 13 / 100;

    private BigDecimal sallary;

    public BigDecimal getSallary() {
        return sallary;
    }

    void calculateSallary(double baseSallary) {
        double tenth = baseSallary * TENTH_BASE;
        double thertinth = baseSallary * THERTINTH_BASE;
        sallary = BigDecimal.valueOf(baseSallary + thertinth + tenth);
    }
}
