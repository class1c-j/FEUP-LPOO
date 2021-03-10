package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;

public class ListAggregatorTest {

    private List<Integer> setupHelper(Integer[] numbers) {
        return Arrays.asList(numbers);
    }

    @Test
    public void sum() {
        List<Integer> list = setupHelper(new Integer[]{1, 2, 4, 2, 5});

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        List<Integer> list = setupHelper(new Integer[]{1, 2, 4, 2, 5});

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        List<Integer> list = setupHelper(new Integer[]{1, 2, 4, 2, 5});

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        List<Integer> list = setupHelper(new Integer[]{1, 2, 4, 2, 5});

        ListAggregator aggregator = new ListAggregator();

        class StubListDeduplicator implements GenericListDeduplicator {
            public List<Integer> deduplicate(List<Integer> list, GenericListSorter listSorter) {
                return Arrays.asList(1, 2, 4, 5);
            }
        }

        GenericListDeduplicator deduplicator = new StubListDeduplicator();
        int distinct = aggregator.distinct(list, deduplicator);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void max_bug_7263() {
        List<Integer> list = setupHelper(new Integer[]{-1, -4, -5});

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void distinct_bug_8726() {
        List<Integer> list = setupHelper(new Integer[]{1, 2, 4, 2});

        ListAggregator aggregator = new ListAggregator();

        class StubListDeduplicator implements GenericListDeduplicator {
            public List<Integer> deduplicate(List<Integer> list, GenericListSorter listSorter) {
                return Arrays.asList(1, 2, 4);
            }
        }

        GenericListDeduplicator deduplicator = new StubListDeduplicator();
        int distinct = aggregator.distinct(list, deduplicator);

        Assertions.assertEquals(3, distinct);

    }

    @Test
    public void distinct_bug_8726_mockito() {

        List<Integer> list = setupHelper(new Integer[]{1, 2, 4, 2});

        ListAggregator aggregator = new ListAggregator();

        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(anyList(), any(GenericListSorter.class))).thenReturn(Arrays.asList(1, 2, 4));

        int distinct = aggregator.distinct(list, deduplicator);

        Assertions.assertEquals(3, distinct);

    }


}
