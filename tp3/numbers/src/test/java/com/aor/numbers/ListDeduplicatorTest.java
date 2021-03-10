package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.code.Stub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    private List<Integer> list;

    @BeforeEach
    public void setup() {
        this.list = new ArrayList<>();
        this.list.add(1);
        this.list.add(2);
        this.list.add(4);
        this.list.add(2);
    }

    @Test
    public void deduplicate() {

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        class StubSorter implements IListSorter {
            public List<Integer> sort() {
                Integer[] numbers = {1, 2, 2, 4};
                return Arrays.asList(numbers);
            }
        }

        StubSorter stubSorter = new StubSorter();
        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(stubSorter);

        Assertions.assertEquals(expected, distinct);
    }


}
