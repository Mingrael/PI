package com;

public class Role {

    int id;
    String role, res, userLogin;

    public Role(int id, String role, String res, String userLogin) {
        this.id = id;
        this.role = role;
        this.res = res;
        this.userLogin = userLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res ) {
        this.res = res;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
}
