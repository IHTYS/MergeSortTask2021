package cft.shift.grinyaevm.settings;

import cft.shift.grinyaevm.settings.dataType.DataSort;
import cft.shift.grinyaevm.settings.dataType.DataType;
import cft.shift.grinyaevm.sorter.comparators.SortComparator;
import cft.shift.grinyaevm.sorter.sorters.Sorter;

import java.util.List;

public interface Settings {
    DataType getDataType();

    SortComparator getSortComparator();

    Sorter getSorter();

    String getOutputFileName();

    List<String> getFilesNameList();

    DataSort getDataSort();
}