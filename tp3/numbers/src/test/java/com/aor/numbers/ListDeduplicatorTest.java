package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;

public class ListDeduplicatorTest {

    private List<Integer> setupHelper(Integer[] numbers) {
        return Arrays.asList(numbers);
    }

    @Test
    public void deduplicate() {
        List<Integer> list = setupHelper(new Integer[]{1,2,4,2,5});
        List<Integer> expected = Arrays.asList(1,2,4,5);

        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list, new ListSorter());

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate_bug_8726() {
        List<Integer> list = setupHelper(new Integer[]{1, 2, 4, 2});
        List<Integer> expected = Arrays.asList(1, 2, 4);

        class StubListSorter implements GenericListSorter {
            public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1, 2, 2, 4);
            }
        }

        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list, new StubListSorter());

        Assertions.assertEquals(expected, distinct);

    }

    @Test
    public void deduplicate_bug_8726_mockito() {
        List<Integer> list = setupHelper(new Integer[]{1, 2, 4, 2});
        List<Integer> expected = Arrays.asList(1, 2, 4);

        GenericListSorter sorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorter.sort(anyList())).thenReturn(Arrays.asList(1, 2, 2, 4));

        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list, sorter);

        Assertions.assertEquals(expected, distinct);

    }

}
