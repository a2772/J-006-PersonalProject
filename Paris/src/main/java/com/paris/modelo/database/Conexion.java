package com.paris.modelo.database;

import com.paris.settings.globals.Global;

public class Conexion {
    private static final String DRIVER = Global.getTIPO_CONEXION().equals(Global.TipoConexion.SRP) ? "com.mysql.jdbc.Driver"
            : "";
    private static final String URL = Global.getTIPO_CONEXION().equals(Global.TipoConexion.SRP) ? "jdbc:mysql://localhost:3306/srp?serverTimezone=UTC"
            : "";
    private static final String USER = Global.getTIPO_CONEXION().equals(Global.TipoConexion.SRP) ? "root"
            : "";
    private static final String PASSWORD = Global.getTIPO_CONEXION().equals(Global.TipoConexion.SRP) ? "EmEElOyd?!27$r00t"
            : "";
    
    //Encapsulamiento
    public static String getDriver() {
        return DRIVER;
    }

    public static String getUrl() {
        return URL;
    }

    public static String getUser() {
        return USER;
    }

    public static String getPassword() {
        return PASSWORD;
    }
}
