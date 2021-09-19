package cft.shift.grinyaevm.sorter.sorters;

import cft.shift.grinyaevm.sorter.comparators.SortComparator;

public interface Sorter {
    <T extends Comparable<T>> void sort(T[] array, SortComparator sortComparator);
}