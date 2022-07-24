package com.paris.modelo.database.dao;

import com.paris.modelo.database.Conexion;
import com.paris.settings.globals.Global;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccessObject {
    protected static final String DRIVER = Conexion.getDriver();
    protected static final String URL = Conexion.getUrl();
    protected static final String USER = Conexion.getUser();
    protected static final String PASSWORD = Conexion.getPassword();
    protected Connection connection = null;
    
    /**
     * Abre la conexión
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public DataAccessObject() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        if(Global.getDEBUK()){
            System.out.println("CONEXIÓN ABIERTA");
        }
    }
    
    /**
     * Crea Statement
     * @return
     * @throws SQLException
     * @throws DAOInitializationException 
     */
    public Statement createStatement() throws SQLException, DAOInitializationException {
        if (connection == null || connection.isClosed()) {
            throw new DAOInitializationException("ERROR. El DAO fue cerrado previamente.");
        } else {
            return connection.createStatement();
        }
    }
    
    /**
     * Prepared Statement
     * @param sql
     * @return
     * @throws SQLException
     * @throws DAOInitializationException 
     */
    public PreparedStatement prepareStatement(String sql) throws SQLException, DAOInitializationException {
        if (connection == null || connection.isClosed()) {
            throw new DAOInitializationException("ERROR. El DAO fue cerrado previamente.");
        } else {
            return connection.prepareStatement(sql);
        }
    }
    
    public void closeConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                throw new DAOInitializationException("ERROR. El DAO fue cerrado previamente.");
            } else {
                connection.close();
            }
        } catch (DAOInitializationException | SQLException ex) {
            
        }
    }
    
    public Connection getConnection() throws SQLException, ClassNotFoundException, DAOInitializationException {
        if (connection == null || connection.isClosed()) {
            throw new DAOInitializationException("ERROR. El DAO fue cerrado previamente.");
        }
        return connection;
    }

    public void closeStatement(Statement stmt) throws SQLException, DAOInitializationException {
        if (connection == null || connection.isClosed()) {
            throw new DAOInitializationException("ERROR. El DAO fue cerrado previamente.");
        }

        if (stmt != null && !stmt.isClosed()) {
            stmt.close();
        }
    }
    
    public void closeResultSet(ResultSet rs) throws SQLException, DAOInitializationException {
        if (connection == null || connection.isClosed()) {
            throw new DAOInitializationException("ERROR. El DAO fue cerrado previamente.");
        }

        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }
}
