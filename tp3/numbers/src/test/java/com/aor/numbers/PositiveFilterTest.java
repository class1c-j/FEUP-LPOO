package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositiveFilterTest {

    @Test
    void accept() {
        PositiveFilter positiveFilter = new PositiveFilter();

        Assertions.assertTrue(positiveFilter.accept(3));
        Assertions.assertFalse(positiveFilter.accept(-3));
    }
}