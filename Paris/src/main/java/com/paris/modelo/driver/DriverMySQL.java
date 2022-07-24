/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paris.modelo.driver;

/**
 *
 * @author paris
 */
public class DriverMySQL {
    // <editor-fold defaultstate="collapsed" desc="Variables">
    private String formatDateTime = "yyyy-MM-dd HH:mm:ss";
    private String formatDate = "yyyy-MM-dd";
    private String formatTime = "HH:mm:ss";
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Encapsulated Fields">
    /**
     * @return the formatDateTime
     */
    public String getFormatDateTime() {
        return formatDateTime;
    }

    /**
     * @param formatDateTime the formatDateTime to set
     */
    public void setFormatDateTime(String formatDateTime) {
        this.formatDateTime = formatDateTime;
    }

    /**
     * @return the formatDate
     */
    public String getFormatDate() {
        return formatDate;
    }

    /**
     * @param formatDate the formatDate to set
     */
    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }

    /**
     * @return the formatTime
     */
    public String getFormatTime() {
        return formatTime;
    }

    /**
     * @param formatTime the formatTime to set
     */
    public void setFormatTime(String formatTime) {
        this.formatTime = formatTime;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methods">
    /**
     * Escapa una cadena para MySQL
     * @param string
     * @return 
     */
    public static String escapeString(String string){
        return escapeStringForMySQL(escapeWildcardsForMySQL(string));
    }
    /**
     * Escapa una cadena para MySQL
     * @param s
     * @return 
     */
    public static String escapeStringForMySQL(String s) {
        return s.replaceAll("\b","\\b")
                .replaceAll("\n","\\n")
                .replaceAll("\r", "\\r")
                .replaceAll("\t", "\\t")
                .replaceAll("\\x1A", "\\Z")
                .replaceAll("\\x00", "\\0")
                .replaceAll("'", "\\'")
                .replaceAll("\"", "\\\"");
    }
    /**
     * Escapa caracteres especiales para MySQL
     * @param s
     * @return 
     */
    public static String escapeWildcardsForMySQL(String s) {
        return escapeStringForMySQL(s)
                .replaceAll("%", "\\%")
                .replaceAll("_","\\_");
    }
    // </editor-fold>
}
