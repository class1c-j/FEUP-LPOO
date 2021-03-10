package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter {
    private final Integer number;

    public DivisibleByFilter(Integer number) {
        this.number = number;
    }

    public boolean accept(Integer number) {
        return number % this.number == 0;
    }

}
