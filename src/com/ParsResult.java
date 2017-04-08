package com;

/**
 * Created by Миша on 26.02.2017.
 */
public class ParsResult {

    String login;
    String pass;
    String res;
    String role;
    String dateStart;
    String dateEnd;
    String volume;

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

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public boolean isAuthentication() {
        if (this.getLogin()!=null && this.getPass()!=null
                && this.getRes()==null && this.getRole()==null && this.getVolume()==null
                && this.getDateStart()==null && this.getDateEnd()==null) {
            return true;
        }
        return false;
    }

    public boolean isAuthorization() {
        if (this.getLogin()!=null && this.getPass()!=null && this.getRes()!=null && this.getRole()!=null
                && this.getVolume()==null && this.getDateStart()==null && this.getDateEnd()==null) {
            return true;
        }
        return false;
    }

    public boolean isAccounting() {
        if (this.getLogin()!=null && this.getPass()!=null && this.getRes()!=null && this.getRole()!=null
                && this.getVolume()!=null && this.getDateStart()!=null && this.getDateEnd()!=null) {
            return true;
        }
        return false;
    }
}