/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paris.bd.personas;

import com.paris.clases.personas.Persona;
import com.paris.modelo.database.MySQL;
import com.paris.settings.globals.Global;
import java.sql.SQLException;

/**
 *
 * @author paris
 */
public class PersonaBd {
    public static final Persona buscaPersonaEnBd(String id, String email){
        Persona persona = new Persona();
        StringBuilder query = new StringBuilder();
        
        query.append("CALL obten_persona(");
        query.append(id != null && !id.equals("null") ? id : "null");
        query.append(email != null && !email.equals("null") ? "'" + email + "'" : "null");
        query.append(");");
        
        try{
            MySQL mySQL = new MySQL(query.toString());
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.print(Global.getDEBUK() ? ex.getStackTrace() : "");
        }
        
        return persona;
    }
    
}
