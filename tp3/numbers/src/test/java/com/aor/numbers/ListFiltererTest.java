package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;

class ListFiltererTest {

    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = Arrays.asList(1, -1, 3, 5, 2, 8, -3, 10);
    }

    @Test
    void filter() {
        GenericListFilter positiveFilter = Mockito.mock(GenericListFilter.class);
        Mockito.when(positiveFilter.accept(anyInt())).thenAnswer(i -> (int) i.getArguments()[0] > 0);

        ListFilterer filterer = new ListFilterer(positiveFilter);
        List<Integer> expected = Arrays.asList(1, 3, 5, 2, 8, 10);

        this.list = filterer.filter(this.list);

        Assertions.assertEquals(expected, this.list);

    }
}