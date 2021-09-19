package cft.shift.grinyaevm.filesSorter;

import cft.shift.grinyaevm.commandLineParser.Helper;
import cft.shift.grinyaevm.settings.Settings;
import cft.shift.grinyaevm.settings.dataType.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSplitter {
    private Settings settings;

    public FileSplitter(Settings settings) {
        this.settings = settings;
    }

    public ArrayList<File> splitFiles() throws IOException {
        ArrayList<File> files = new ArrayList<>();

        for (String fileName : settings.getFilesNameList()) {
            files.addAll(splitFile(fileName));
        }
        return files;
    }

    private ArrayList<File> splitFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        String[] resultArray;
        ArrayList<File> tempFiles = new ArrayList<>();

        Scanner sc = new Scanner(new File(fileName));;
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(fileName + "- файл не найден");
        }

        while (sc.hasNextLine()){
            lines.add(sc.nextLine());
        }
        resultArray = lines.toArray(new String[0]);
        tempFiles.add(createTempFile(resultArray));
        return tempFiles;
    }

    private File createTempFile(String[] resultArray) throws IOException {

        File newFile = File.createTempFile("-sort-temp-file", null);
        try (FileWriter fileWriter = new FileWriter(newFile);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            String[] correctArray = DataValidator.deleteNull(resultArray);

            if (settings.getDataType() == DataType.INTEGER) {
                Integer[] data = DataWrapper.getIntegerData(correctArray);

                if (settings.getDataSort() == DataSort.UNSORT){
                settings.getSorter().sort(data, settings.getSortComparator());}

                for (Integer s : data) {
                    printWriter.println(s);
                }
            } else {
                String[] data = DataWrapper.getStringData(correctArray);

                if (settings.getDataSort() == DataSort.UNSORT){
                settings.getSorter().sort(data, settings.getSortComparator());}

                for (String s : data) {
                    printWriter.println(s);
                }
            }
        }

        return newFile;
    }
}
