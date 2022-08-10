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
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public DataAccessObject() throws ClassNotFoundException, SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.print(Global.getDEBUK() && Global.getDEPTH().getValue() >= Global.Grado.LIGHTER.getValue()
                ? "\nCONEXIÓN ABIERTA" : "");
    }

    /**
     * Crea Statement
     *
     * @return Statement
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
     * Regresa un PreparedStatement
     *
     * @param sql
     * @return Prepared Statement
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
    
    /**
     * Cierra la conexión
     * @throws DAOInitializationException
     * @throws SQLException 
     */
    public void closeConnection() throws DAOInitializationException, SQLException {
        if (connection == null || connection.isClosed()) {
            throw new DAOInitializationException("ERROR. El DAO fue cerrado previamente.");
        } else {
            connection.close();
            System.out.print(Global.getDEBUK() && Global.getDEPTH().getValue() >= Global.Grado.LIGHTER.getValue()
                    ? "\nCONEXIÓN CERRADA" : "");
        }
    }

    /**
     * Regresa la conexión actual
     *
     * @return Connection
     * @throws SQLException
     * @throws DAOInitializationException
     */
    public Connection getConnection() throws SQLException, DAOInitializationException {
        if (connection == null || connection.isClosed()) {
            throw new DAOInitializationException("ERROR. El DAO fue cerrado previamente.");
        }
        return this.connection;
    }

    /**
     * Cierra el Statement
     *
     * @param stmt
     * @throws SQLException
     * @throws DAOInitializationException
     */
    public void closeStatement(Statement stmt) throws SQLException, DAOInitializationException {
        if (connection == null || connection.isClosed()) {
            throw new DAOInitializationException("ERROR. El DAO fue cerrado previamente.");
        } else {
            stmt.close();
        }
    }

    /**
     * Cierra el ResultSet
     *
     * @param rs
     * @throws SQLException
     * @throws DAOInitializationException
     */
    public void closeResultSet(ResultSet rs) throws SQLException, DAOInitializationException {
        if (connection == null || connection.isClosed()) {
            throw new DAOInitializationException("ERROR. El DAO fue cerrado previamente.");
        } else {
            rs.close();
        }
    }
}
