package com;

import org.apache.commons.cli.HelpFormatter;

import java.util.ArrayList;


public class Main {

    public static boolean isAuthentification = false;
    public static boolean isAuthorization = false;
    public static boolean isAccounting = false;

    public static void main(String[] args) throws Throwable {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "John Doe", "jdoe", "sup3rpaZZ"));
        users.add(new User(2, "Jane Row", "jrow", "Qweqrty12"));

        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Role(1, "READ", "a", "jdoe"));
        roles.add(new Role(2, "WRITE", "a.b", "jdoe"));
        roles.add(new Role(3, "EXECUTE", "a.b.c", "jrow"));
        roles.add(new Role(4, "EXECUTE", "a.bc", "jdoe"));


        ParsResult pare = new Pars().parsing(args); // pare - pars result запуск парсинга

        if (pare.isAuthentication()) {
            isAuthentification = true;
        } else if (pare.isAuthorization()) {
            isAuthentification = true;
            isAuthorization = true;
        } else if (pare.isAccounting()) {
            isAuthentification = true;
            isAuthorization = true;
            isAccounting = true;
        }

        if (isAuthentification) {
            Check.checkAuthentication(users, roles, pare);
        } else help();

    }

    public static void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("AAA protocol", new Pars().options);
        System.exit(0);
    }
}
