package com;

import java.util.Date;

/**
 * Created by Миша on 26.02.2017.
 */
public class Accounting {
    private int volume;
    private Role role;
    private Date date_start;
    private Date date_end;


    public Accounting(int volume, Role role, Date date_start, Date date_end) {
        this.volume = volume;
        this.role = role;
        this.date_start = date_start;
        this.date_end = date_end;
    }
}

