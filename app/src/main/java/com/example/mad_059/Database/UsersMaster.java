package com.example.mad_059.Database;

import android.provider.BaseColumns;

public final class UsersMaster {

    private UsersMaster() { }

    public static class  Users implements BaseColumns{

        public static final String TABLE_NAME = "users";
        public static  final  String COLUMN_NAME_REGISTRATION_NO = "regNO";
        public static  final  String COLUMN_NAME_PWD = "pwd";
        public static  final  String COLUMN_NAME_NAME = "name";
        public static  final  String COLUMN_NAME_PHONE_NO = "phone";
        public static  final  String COLUMN_NAME_EMAIL = "email";
        public static  final  String COLUMN_NAME_DATE = "date";

    }
}
