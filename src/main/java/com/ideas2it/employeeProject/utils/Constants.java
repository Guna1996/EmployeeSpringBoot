package com.ideas2it.employeeProject.utils;

/**
 * The {@code Constants} has final values which are frequently used in various tasks.
 *
 * @author Gunaseelan K
 * since 1.0
 * jls Advanced logics+
 */
public class Constants {
    public static final int FAILED = 0;
    public static final String ADD = "add";
    public static final String ACTIVE = "active";
    public static final String INACTIVE = "inactive";
    public static final String DATABASE_URL = "jdbc:mysql://localhost/employee?verifyServerCertificate=false&useSSL=true";
    public static final String DATABASE_USER_NAME = "root";
    public static final String DATABASE_PASSWORD = "Guna@1996";
    public static final String SECRET = "SECRET_KEY";
    public static final long EXPIRATION_TIME = 900_000; // 15 mins
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/services/controller/user";
}