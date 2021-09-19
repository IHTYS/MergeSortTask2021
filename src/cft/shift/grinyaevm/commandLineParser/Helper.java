package cft.shift.grinyaevm.commandLineParser;

public class Helper {
    public static void help() {
        System.out.printf("Параметры программы задаются при запуске через аргументы командной строки, по порядку:%n" +
                "1. тип данных (-s или -i), обязательный;%n" +
                "2. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;%n" +
                "3. отсортированы ли файлы (-unsort - если не отсортированы), для предварительной сортировки неотсортированных файлов, необязательный параметр;%n" +
                "4. имя выходного файла, обязательное;%n" +
                "5. имена входных файлов, не менее одного;%n" +
                "Примеры запуска из командной строки:%n" +
                "java -jar MergeSortFiles.jar -i -a out.txt int1.txt (для целых чисел по возрастанию)%n" +
                "java -jar MergeSortFiles.jar -s out.txt string1.txt string2.txt string3.txt -unsort (для строк по возрастанию, для неотсортированных файлов)%n" +
                "java -jar MergeSortFiles.jar -d -s out.txt string1.txt string2.txt (для строк по убыванию)%n");
    }

    public static void getHelpCommand() {
        System.out.printf("Пример запуска справки из командной строки:%n" +
                "java -jar FilesExternalMergeSort.jar -help");
    }
}