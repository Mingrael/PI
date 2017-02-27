package com;

import org.apache.commons.cli.*;

/**
 * Created by Миша on 26.02.2017.
 */
public class Pars {
    public Options options = new Options();

    public Pars() {
        options.addOption(new Option("l", "login", true, "login"))
                .addOption(new Option("p", "password", true, "password"))
                .addOption(new Option("pt", "path", true, "path"))
                .addOption(new Option("rol", "role", true, "role"))
                .addOption(new Option("ds", "date-start", true, "date start (YYYY-MM-DD)"))
                .addOption(new Option("de", "date-end", true, "date end (YYYY-MM-DD)"))
                .addOption(new Option("v", "volume", true, "volume"))
                .addOption(new Option("h", "help", false, "help")); //добавляем опции для последующего парсинга
    }

    ParsResult parsing(String[] args) throws ParseException {
        String login = null;
        String pass = null;
        String res = null;
        String role = null;
        String date_start = null;
        String date_end = null;
        String volume = null;

        CommandLineParser cmdLineParser = new DefaultParser();
        //CommandLineParser - тип данных, DefaultParser - тип парсера. задаём парсер
        CommandLine cmdLine = cmdLineParser.parse(options, args);
        //Комнадлайн - тип данных, парс - функция (массив опций, строка аргументов), цмдлайн - разбитая строка. получаем результаты парсинга

        if (cmdLine.hasOption("l")) {//хэзопшн- проверяет наличие опции. Получаем значение по ключу
            login = cmdLine.getOptionValue("l"); //помещаем в класс значение опции, соответствующей ключу -l
        }
        if (cmdLine.hasOption("p")) {
            pass = cmdLine.getOptionValue("p");
        }
        if (cmdLine.hasOption("pt")) {
            res = cmdLine.getOptionValue("pt");
        }
        if (cmdLine.hasOption("rol")) {
            role = cmdLine.getOptionValue("rol");
        }
        if (cmdLine.hasOption("ds")) {
            date_start = cmdLine.getOptionValue("ds");
        }
        if (cmdLine.hasOption("de")) {
            date_end = cmdLine.getOptionValue("de");
        }
        if (cmdLine.hasOption("v")) {
            volume = cmdLine.getOptionValue("v");
        }
        ParsResult pr = new ParsResult (login, pass, res, role, date_start, date_end, volume); //собираем результаты парсинга в класс и возвращает это значение

        return pr;
    }


}
