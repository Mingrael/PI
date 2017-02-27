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
        String login = pare.getLogin();//присваевается значение распарсинового логина
        String pass = pare.getPass();

        User curUser = null; //курюзер - пользователь, для которого производится аутентификация

        for (User u : users) {//для каждого юзера из списка юзерс
            if (u.getLogin().equals(login)) {//если логин пользователя из списка совпадает с распарсенным
                curUser = new User(u);//то работаем с этим пользователем
                break;
            }
        }

        if (curUser == null) {
            System.out.printf("User not found");
            System.exit(1);
        }

        pass = Hash.hash(Hash.hash(pass) + curUser.getSalt());//запаковываем распарсенный пароль с солью текщего пользователя
        if (!curUser.getPass().equals(pass)) {//
            System.out.printf("Wrong password");
            System.exit(2);
        }

        if (Main.authorization) {
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
        String role = pare.getRole();//забираем роль с распарсиной
        String resource = pare.getRes();
        Role trueRole = new Role(999, null, null, currentRoles.get(0).getUser_login());//труроль- роль, с которой будем работать. Создаём новую роль


        if (!role.equals("READ") && !role.equals("WRITE") && !role.equals("EXECUTE")) {
            System.out.println("Invalid role");
            System.exit(3);
        }

        for (Role r : currentRoles) {
            //проверка ресурсов
            if (new Check().checkResource(resource, r.getPath())) {//если путь совпадает с распарсенным или входит в него
                trueRole.setPath(resource);//записываем путь
                if (r.getRole().equals(role)) {//если роли равны
                    trueRole.setRole(role);//записываем
                    break;
                }
            }
        }
        if ((trueRole.getPath() == null) || (trueRole.getRole() == null)) {
            System.out.println("Wrong path");
            System.exit(4);
        }
        if (Main.accounting) {//если всё успешно, то прошёл аккаунтинг
            Check.checkAccounting(pare);
        } else {
            System.out.println("Authorization complete");
            System.exit(0);
        }

    }

    public static void checkAccounting(ParsResult pare) {

        String ds = pare.getDate_start();
        String de = pare.getDate_end();
        int vol = 0;//объём
        try {
            vol = Integer.parseInt(pare.getVolume());//из стринга делаем инт
        } catch (NumberFormatException e) {
            System.out.println("Failed to parse volume.");
            System.exit(5);
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {//из стринг в дата
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

    public boolean checkResource(String res1, String res2) { //проверка на родительство
        if ((res1.indexOf(res2) == 0)
                && ((res1.length() == res2.length())
                || (res1.charAt(res2.length()) == '.')
                && (res1.length() != res2.length()))) {
            return true;
        } else return false;
    }
}
