package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Миша on 26.02.2017.
 */
public class Check {

    public static void checkAuthentication(ArrayList<User> users, ArrayList<Role> roles, ParsResult pare) throws Throwable {
        String login = pare.getLogin();
        String pass = pare.getPass();

        User curUser = null;

        for (User u : users) {
            if (u.getLogin().equals(login)) {
                curUser = new User(u);
                break;
            }
        }

        if (curUser == null) {
            System.out.printf("User not found");
            System.exit(1);
        }

        if (!curUser.getPass().equals(pass)) {
            System.out.printf("Wrong password");
            System.exit(2);
        }

        if (Main.getAuthorization()) {
            ArrayList<Role> currentRoles = new ArrayList<>(); //все роли для пользователя

            for (Role r : roles)
                if (r.getUser_login().equals(curUser.getLogin())) {
                    currentRoles.add(r);
                }

            Check.checkAuthorization(currentRoles, pare);
        } else {
            System.out.println("Authentication complete");
            System.exit(0);
        }
    }

    public static void checkAuthorization(ArrayList<Role> currentRoles, ParsResult pare) throws ParseException {
        //выделяем реусрс и роль
        String role = pare.getRole();
        String resource = pare.getRes();
        Role trueRole = new Role(999, currentRoles.get(0).getUser_login(), null, null);


        if (!role.equals("READ") && !role.equals("WRITE") && !role.equals("EXECUTE")) {
            System.out.println("Invalid role");
            System.exit(3);
        }

        for (Role r : currentRoles) {
            //проверка ресурсов
            if (new Check().checkResource(resource, r.getPath())) {
                trueRole.setPath(resource);
                if (r.getRole().equals(role)) {
                    trueRole.setRole(role);
                    break;
                }
            }
        }
        if ((trueRole.getPath() == null) || (trueRole.getRole() == null)) {
            System.out.println("Wrong resource");
            System.exit(4);
        }
        if (Main.getAccounting()) {
            Check.checkAccounting(pare);
        } else {
            System.out.println("Authorization complete");
            System.exit(0);
        }

    }

    public static void checkAccounting(ParsResult pare) {

        String ds = pare.getDate_start();
        String de = pare.getDate_end();
        int vol = 0;
        try {
            vol = Integer.parseInt(pare.getVolume());
        } catch (NumberFormatException e) {
            System.out.println("Failed to parse volume.");
            System.exit(5);
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            Date date = format.parse(ds);
            Calendar date_start = Calendar.getInstance();
            date_start.setTime(date);

            date = format.parse(de);
            Calendar date_end = Calendar.getInstance();
            date_end.setTime(date);
        } catch (ParseException e) {
            System.out.println("Invalid date or wrong format");
            System.exit(5);
        }

        //Проверка объема
        if (vol < 0) {
            System.out.printf("Wrong volume");
            System.exit(5);
        }

        System.out.println("Accounting complete");
        System.exit(0);

    }

    public boolean checkResource(String res1, String res2) {
        if ((res1.indexOf(res2) == 0)
                && ((res1.length() == res2.length())
                || (res1.charAt(res2.length()) == '.')
                && (res1.length() != res2.length()))) {
            return true;
        } else return false;
    }
}
