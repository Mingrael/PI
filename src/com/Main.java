package com;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

import java.util.ArrayList;

/**
 * Created by Миша on 26.02.2017.
 */
public class Main {

    private static boolean authentication = false;
    private static boolean authorization = false;
    private static boolean accounting = false;

    public static void main(String[] args) throws ParseException {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "John Doe", "jdoe", "sup3rpaZZ"));
        users.add(new User(2, "Jane Row", "jrow", "Qweqrty12"));

        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Role(1, "READ", "a", "jdoe"));
        roles.add(new Role(2, "WRITE", "a.b", "jdoe"));
        roles.add(new Role(3, "EXECUTE", "a.b.c", "jrow"));
        roles.add(new Role(4, "EXECUTE", "a.bc", "jdoe"));


        ParsResult pare = new Pars().parsing(args); // pare - pars result
        if (pare.isAuthentication()){
            authentication = true;
        }
        else
        if (pare.isAuthorization()) {
            authentication = true;
            authorization = true;
        }
        else
        if (pare.isAccounting()){
            authentication = true;
            authorization = true;
            accounting = true;
        }

        if (getAuthentication()) {
            Check.checkAuthentication(users, roles, pare);
        }
        else help();

    }

    public static void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("AAA protocol", new Pars().options);
        System.exit(0);
    }

    public static boolean getAuthentication() {
        return authentication;
    }

    public static boolean getAuthorization() {
        return authorization;
    }

    public static boolean getAccounting() {
        return accounting;
    }
    }
}
