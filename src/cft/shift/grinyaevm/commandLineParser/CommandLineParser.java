package cft.shift.grinyaevm.commandLineParser;

import cft.shift.grinyaevm.settings.Settings;

public interface CommandLineParser {
    Settings parseCommandLine(String[] commandLine);
}