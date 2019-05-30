package com.mir.c04.dao;

public class UserFactory {

    private static UserDao userDao = new UserDao();

    public static UserDao getUserDao() {
        return userDao;
    }
}
