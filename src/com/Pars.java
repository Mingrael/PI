package com;

import org.apache.commons.cli.*;

public class Pars {
    public Options options = new Options();

    public Pars() {
        options.addOption(new Option("login", "login", true, "login"))
                .addOption(new Option("pass", "password", true, "password"))
                .addOption(new Option("res", "ress", true, "resurce"))
                .addOption(new Option("role", "role", true, "role"))
                .addOption(new Option("ds", "date-start", true, "date start (YYYY-MM-DD)"))
                .addOption(new Option("de", "date-end", true, "date end (YYYY-MM-DD)"))
                .addOption(new Option("vol", "volume", true, "volume"))
                .addOption(new Option("h", "help", false, "help")); //добавляем опции для последующего парсинга
    }

    ParsResult parsing(String[] args) throws ParseException { //ParsResult - возвращаемое значение

        CommandLineParser cmdLineParser = new DefaultParser();
        //CommandLineParser - тип данных, DefaultParser - тип парсера. задаём парсер
        CommandLine cmdLine = cmdLineParser.parse(options, args);
        //Комнадлайн - тип данных, парс - функция (массив опций, строка аргументов), цмдлайн - разбитая строка. получаем результаты парсинга
        ParsResult pr = new ParsResult (); //собираем результаты парсинга в класс и возвращает это значение

        if (cmdLine.hasOption("login")) {//хэзопшн- проверяет наличие опции. Получаем значение по ключу
            pr.setLogin(cmdLine.getOptionValue("login")); //помещаем в класс значение опции, соответствующей ключу -l
        }
        if (cmdLine.hasOption("pass")) {//,bool
            pr.setPass(cmdLine.getOptionValue("pass"));
        }
        if (cmdLine.hasOption("res")) {
            pr.setRes(cmdLine.getOptionValue("res"));
        }
        if (cmdLine.hasOption("role")) {
            pr.setRole(cmdLine.getOptionValue("role"));
        }
        if (cmdLine.hasOption("ds")) {
            pr.setDateStart(cmdLine.getOptionValue("ds"));
        }
        if (cmdLine.hasOption("de")) {
            pr.setDateEnd(cmdLine.getOptionValue("de"));
        }
        if (cmdLine.hasOption("vol")) {
            pr.setVolume(cmdLine.getOptionValue("vol"));
        }


        return pr;
    }


}
