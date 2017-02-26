package com;

/**
 * Created by Миша on 26.02.2017.
 */
public class User {

    int id;
    String name, login, pass;

    public User(int id, String name, String login, String pass) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.pass = pass;
    }

    public User(User u) {
        this.id = u.id;
        this.name = u.name;
        this.login = u.login;
        this.pass = u.pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
