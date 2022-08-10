package com.paris.settings.globals;

public class Global {
    // <editor-fold defaultstate="collapsed" desc="Configurar">
    private static final Grado DEPTH = Grado.LIGHTEST;
    private static final boolean DEBUK = true; //Al estar en true nos muestra los mensajes (modo desarollador)
    private static final TipoConexion TIPO_CONEXION = TipoConexion.SRP; //Sirve para alternar entre conexiones para distintos desarrolladores
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Funcionamiento">
    //Modificar al gusto
    public enum Grado { LIGHTEST(0), LIGHTER(1), LIGHT(2), MEDIUM(3), HEAVY(4), HEAVIER(5), HEAVIEST(6);
        private final int value;
        private Grado(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
    //Contenido
    public enum TipoConexion { SRP, ELEYTE }
    
    //Encapsulamiento
    public static final boolean getDEBUK(){
        return DEBUK;
    }
    public static final TipoConexion getTIPO_CONEXION(){
        return TIPO_CONEXION;
    }
    
    /**
     * Devuelve la profundidad del debugeado
     * @return the DEPTH
     */
    public static final Grado getDEPTH() {
        return DEPTH;
    }
    // </editor-fold>
}
