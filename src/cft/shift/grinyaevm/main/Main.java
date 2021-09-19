package cft.shift.grinyaevm.main;

import cft.shift.grinyaevm.commandLineParser.CommandLineParser;
import cft.shift.grinyaevm.commandLineParser.CommandLineParserImp;
import cft.shift.grinyaevm.filesSorter.FilesSorter;
import cft.shift.grinyaevm.settings.Settings;

public class Main {
    public static void main(String[] args) {
        CommandLineParser commandLineParser = new CommandLineParserImp();
        Settings settings = commandLineParser.parseCommandLine(args);
        FilesSorter filesSorter = new FilesSorter(settings);

        filesSorter.mergeSortFiles();
    }
}
