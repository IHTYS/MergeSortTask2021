package cft.shift.grinyaevm.commandLineParser;

import java.util.Scanner;

public class CommandLineChecker {
    public static String[] check(String[] commandLine) {
    Scanner in = new Scanner(System.in);

        while(commandLine.length < 3) {
        System.out.println("Данные заполнены не полностью. Введите все данные или завершите программу -exit.");
        String userCommand =  in.nextLine();
            if (userCommand.matches("-exit")) {
                Helper.getHelpCommand();
                System.exit(0);
            }
        commandLine = userCommand.split(" ");
    };

        while (!commandLine[0].matches("-i|-s")) {
        System.out.println(commandLine[0] + " - неправильное значение типа данных. Необходимо задать тип данных: \"-i\" для чисел или \"-s\" для строк или завершите программу -exit.");
        commandLine[0] = in.nextLine();
            if (commandLine[0].matches("-exit")) {
                Helper.getHelpCommand();
                System.exit(0);
            }
    }

        while (!commandLine[1].matches("-a|-d|.+\\.(txt)")) {
        System.out.println(commandLine[1] + " - неправильное значение типа сортировки. Необходимо задать тип сортировки: \"-a\" для сортировки по возрастанию или \"-d\" для сортировки по убыванию или завершите программу -exit.");
        commandLine[1] = in.nextLine();
            if (commandLine[1].matches("-exit")) {
                Helper.getHelpCommand();
                System.exit(0);
            }
    }
        for (int k = 2; k < commandLine.length; k++) {
        while (!commandLine[k].matches(".+\\.(txt)|-unsort")) {
            System.out.println(commandLine[k] + "- неправильное значение. Введите правильный формат(*.txt) или завершите программу -exit.");
            commandLine[k] = in.nextLine();
            if (commandLine[k].matches("-exit")) {
                Helper.getHelpCommand();
                System.exit(0);
            }
        }
    }
        in.close();

        return commandLine;
    }}
