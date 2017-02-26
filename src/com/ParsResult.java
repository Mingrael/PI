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
}