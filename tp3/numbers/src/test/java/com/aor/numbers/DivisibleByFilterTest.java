package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisibleByFilterTest {

    @Test
    void accept() {
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(3);

        Assertions.assertTrue(divisibleByFilter.accept(9));
        Assertions.assertFalse(divisibleByFilter.accept(7));
    }
}