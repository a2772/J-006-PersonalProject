package com.paris.modelo.database;

import com.paris.modelo.database.dao.DAOInitializationException;
import com.paris.modelo.database.dao.DataAccessObject;
import com.paris.settings.globals.Global;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Heredamos del Data Access Object
public class MySQL extends DataAccessObject{    
    private StringBuilder sentence;
    /**
     * Realiza una consulta, ya sea select, call, insert, etc.
     * @param sentence Procedimiento almacenado o sentencia.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public MySQL(String sentence)throws ClassNotFoundException, SQLException {
        this.sentence = new StringBuilder(sentence);
    }
    /**
     * Obtiene la sentencia del objeto o el SP (Stored Procedure)
     * @return 
     */
    public StringBuilder getSentence() {
        return sentence;
    }
    
    /**
     * Cambia el procedimiento almacenado a ejecutar/llamar
     * @param sentence 
     */
    public void setSentence(StringBuilder sentence) {
        this.sentence = sentence;
    }

    /**
     * Devuelve una matriz obtenida por un select, normalmente un procedimiento
     * almacenado
     * @return Matriz en forma de lista anidada en otra lista
     */
    public ArrayList<ArrayList<Object>> leeMatriz() {
        ArrayList<ArrayList<Object>> matriz = new ArrayList<ArrayList<Object>>();
        ArrayList<Object> registro;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            //Ejecutamos el StoredProcedure
            stmt = prepareStatement(this.sentence.toString());
            stmt.execute();
            rs = stmt.getResultSet();
            //Por cada fila
            while(rs.next()){
                registro = new ArrayList<Object>();//Generamos instancia
                //Almacenamos los valores de las columnas
                for(short columna=1;columna<=rs.getMetaData().getColumnCount();columna++){
                    System.out.print(Global.getDEBUK() ? "\nColumna: " + columna : "");
                    registro.add(rs.getObject(columna));
                }
                //Guardamos la fila en la matriz
                matriz.add(registro);
            }
            //Cerramos el result set y el statement
            closeResultSet(rs);
            closeStatement(stmt);
        } catch (DAOInitializationException | SQLException e) {
            matriz = null;
            System.out.print(Global.getDEBUK() ? "\nClass Exception: " + e.getMessage() : "");
        }
        return matriz;//Devolvemos la matriz leída
    }
    
    /**
     * Lee un registro (fila) de la BD, llamando al SP que contenga el objeto consulta
     * @return
     */
    public ArrayList<Object> leeRegistro() {
        ArrayList<Object> registro = new ArrayList<Object>();//Generamos instancia;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            //Ejecutamos el StoredProcedure
            stmt = prepareStatement(this.sentence.toString());
            stmt.execute();
            rs = stmt.getResultSet();
            //Por cada fila
            if(rs.next()){
                //Almacenamos los valores de las columnas
                for(short columna=1;columna<=rs.getMetaData().getColumnCount();columna++){
                    System.out.print(Global.getDEBUK() ? "\nColumna: " + columna : "");
                    registro.add(rs.getObject(columna));
                }
            }//Cerramos el result set y el statement
            closeResultSet(rs);
            closeStatement(stmt);
        } catch (DAOInitializationException | SQLException e) {
            registro = null;
            if(Global.getDEBUK()){
                System.out.println("Class Exception: " + e.getMessage());
            }
        }
        return registro;//Devolvemos el registro leído, si hay más de 1 se lee solo el primero
    }
}