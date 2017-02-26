package com;

import java.util.ArrayList;

/**
 * Created by Миша on 26.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "John Doe", "jdoe", "sup3rpaZZ"));
        users.add(new User(2, "Jane Row", "jrow", "Qweqrty12"));

        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Role(1, "READ", "a", "jdoe"));
        roles.add(new Role(2, "WRITE", "a.b", "jdoe"));
        roles.add(new Role(3, "EXECUTE", "a.b.c", "jrow"));
        roles.add(new Role(4, "EXECUTE", "a.bc", "jdoe"));

    }
}
