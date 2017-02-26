package com;

import java.util.ArrayList;

/**
 * Created by Миша on 26.02.2017.
 */
public class Check   {

    public static void checkAuthentication(ArrayList<User> users, ArrayList<Role> roles, ParsResult pare) throws Throwable
    {
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
    }
}
