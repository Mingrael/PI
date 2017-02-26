package com;

/**
 * Created by Миша on 26.02.2017.
 */
public class ParsResult {

    String login;
    String pass;
    String res;
    String role;
    String date_start;
    String date_end;
    String volume;

    public ParsResult(String login, String pass, String res, String role, String date_start, String date_end, String volume) {
        this.login = login;
        this.pass = pass;
        this.res = res;
        this.role = role;
        this.date_start = date_start;
        this.date_end = date_end;
        this.volume = volume;
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

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public boolean isAuthentication(){
        if (this.getLogin()!=null && this.getPass()!=null
                && this.getRes()==null && this.getRole()==null && this.getVolume()==null
                && this.getDate_start()==null && this.getDate_end()==null){
            return true;
        }
        return false;
    }

    public boolean isAuthorization (){
        if (this.getLogin()!=null && this.getPass()!=null && this.getRes()!=null && this.getRole()!=null
                && this.getVolume()==null && this.getDate_start()==null && this.getDate_end()==null){
            return true;
        }
        return false;
    }

    public boolean isAccounting (){
        if (this.getLogin()!=null && this.getPass()!=null && this.getRes()!=null && this.getRole()!=null
                && this.getVolume()!=null && this.getDate_start()!=null && this.getDate_end()!=null){
            return true;
        }
        return false;
    }
}