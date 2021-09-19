package cft.shift.grinyaevm.commandLineParser;

import cft.shift.grinyaevm.settings.dataType.DataSort;
import cft.shift.grinyaevm.settings.dataType.DataType;
import cft.shift.grinyaevm.settings.SortOrder;
import cft.shift.grinyaevm.settings.Settings;
import cft.shift.grinyaevm.settings.SettingsImp;

import java.util.ArrayList;

public class CommandLineParserImp implements CommandLineParser {
    @Override
    public Settings parseCommandLine(String[] commandLine) {
        SortOrder sortOrder = SortOrder.ASCENDING;
        DataType dataType = DataType.NOT_INSTALLED;
        DataSort dataSort = DataSort.SORT;
        ArrayList<String> filesList = new ArrayList<>();

        String[] commandLineChecked = CommandLineChecker.check(commandLine);

        try {
            for (String arg : commandLineChecked) {
                switch (arg) {
                    case ("-i"):
                        dataType = DataType.INTEGER;
                        break;
                    case ("-s"):
                        dataType = DataType.STRING;
                        break;
                    case ("-d"):
                        sortOrder = SortOrder.DESCENDING;
                        break;
                    case ("-a"):
                        sortOrder = SortOrder.ASCENDING;
                        break;
                    case("-unsort"):
                        dataSort = DataSort.UNSORT;
                        break;
                    default:
                      if(arg.matches(".+\\.(txt)")) {
                          filesList.add(arg);
                    }
                        break;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            Helper.getHelpCommand();

            System.exit(0);
        }

        return new SettingsImp(sortOrder, dataType, filesList, dataSort);
    }
}