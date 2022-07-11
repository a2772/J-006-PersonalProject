package com.paris.settings.globals;

public class Global {
    //Modificar al gusto
    private static final boolean DEBUK = true; //Al estar en true nos muestra los mensajes (modo desarollador)
    private static final TipoConexion TIPO_CONEXION = TipoConexion.SRP; // Sirve para alternar entre conexiones para distintos desarrolladores
    
    //Encapsulamiento
    public static final boolean getDEBUK(){
        return DEBUK;
    }
    public static final TipoConexion getTIPO_CONEXION(){
        return TIPO_CONEXION;
    }
    
    //Contenido
    public enum TipoConexion {
        SRP,
        ELEYTE
    }
}
