package cft.shift.grinyaevm.settings;

import cft.shift.grinyaevm.settings.dataType.DataSort;
import cft.shift.grinyaevm.settings.dataType.DataType;
import cft.shift.grinyaevm.commandLineParser.Helper;
import cft.shift.grinyaevm.sorter.comparators.AscendingSortComparator;
import cft.shift.grinyaevm.sorter.comparators.DescendingSortComparator;
import cft.shift.grinyaevm.sorter.comparators.SortComparator;
import cft.shift.grinyaevm.sorter.sorters.MergeSortGeneric;
import cft.shift.grinyaevm.sorter.sorters.Sorter;

import java.util.List;

public class SettingsImp implements Settings {
    private DataType dataType;
    private SortComparator sortComparator;
    private Sorter sorter;
    private String outputFileName;
    private List<String> sortableFilesNameList;
    private DataSort dataSort;

    public SettingsImp(SortOrder sortOrder, DataType dataType, List<String> filesList, DataSort dataSort) {
        SettingsImp.validateSettings(dataType, filesList);

        this.dataType = dataType;
        this.sortComparator = sortOrder.equals(SortOrder.ASCENDING) ? new AscendingSortComparator() : new DescendingSortComparator();
        this.sorter = new MergeSortGeneric();
        this.outputFileName = filesList.get(0);
        this.sortableFilesNameList = filesList.subList(1, filesList.size());
        this.dataSort = dataSort;
    }

    public static void validateSettings(DataType dataType, List<String> filesList) {
        try {
            if (dataType.equals(DataType.NOT_INSTALLED)) {
                throw new IllegalArgumentException("Необходимо задать тип данных: \"-i\" для чисел или \"-s\" для строк (или воспользуйтесь \"-help\")");
            }

            if (filesList.size() < 1) {
                throw new IllegalArgumentException("Необходимо задать название выходного файла (или воспользуйтесь \"-help\")");
            }

            if (filesList.size() < 2) {
                throw new IllegalArgumentException("Необходимо задать название файла для сортировки (или воспользуйтесь \"-help\")");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            Helper.getHelpCommand();

            System.exit(0);
        }
    }

    @Override
    public DataType getDataType() {
        return dataType;
    }

    @Override
    public SortComparator getSortComparator() {
        return sortComparator;
    }

    @Override
    public Sorter getSorter() {
        return sorter;
    }

    @Override
    public String getOutputFileName() {
        return outputFileName;
    }

    @Override
    public List<String> getFilesNameList() {
        return sortableFilesNameList;
    }

    @Override
    public DataSort getDataSort() { return dataSort; }
}