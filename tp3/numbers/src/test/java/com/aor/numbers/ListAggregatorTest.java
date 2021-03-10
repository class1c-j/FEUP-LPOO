package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    private List<Integer> list;

    @BeforeEach
    public void setup() {
        this.list = new ArrayList<>();
        this.list.add(1);
        this.list.add(2);
        this.list.add(4);
        this.list.add(2);
        this.list.add(5);
    }

    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator(this.list);

        int sum = aggregator.sum();

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator(this.list);

        int max = aggregator.max();

        Assertions.assertEquals(5, max);
    }

    @Test
    public void max_bug_7263() {
        Integer[] numbers = {-1, -4, -5};
        List<Integer> bugList = Arrays.asList(numbers);

        ListAggregator aggregator = new ListAggregator(bugList);

        int max = aggregator.max();

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator(this.list);

        int min = aggregator.min();

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {

        class ListDeduplicatorStub implements IListDeduplicator {

            @Override
            public List<Integer> deduplicate(IListSorter listSorter) {
                Integer[] stubNumbers = {1, 2, 4};
                return Arrays.asList(stubNumbers);
            }

        }

        Integer[] numbers = {1, 2, 4, 2};
        List<Integer> numberList = Arrays.asList(numbers);

        ListDeduplicatorStub stub = new ListDeduplicatorStub();
        ListAggregator aggregator = new ListAggregator(numberList);

        int distinct = aggregator.distinct(stub);

        Assertions.assertEquals(3, distinct);
    }
}
