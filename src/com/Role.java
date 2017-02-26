package com;

/**
 * Created by Миша on 26.02.2017.
 */
public class Role {

    int id;
    String role, path, user_login;

    public Role(int id, String role, String path, String user_login)
    {
        this.id = id;
        this.role = role;
        this.path = path;
        this.user_login = user_login;
    }

}
