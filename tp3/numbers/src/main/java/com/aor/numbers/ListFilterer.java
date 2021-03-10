package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    private final GenericListFilter filter;

    public ListFilterer(GenericListFilter filter) {
        this.filter = filter;
    }

    public List<Integer> filter(List<Integer> list) {
        List<Integer> filteredList = new ArrayList<>();
        for (Integer i : list) {
            if (this.filter.accept(i)) {
                filteredList.add(i);
            }
        }
        return filteredList;
    }
}
