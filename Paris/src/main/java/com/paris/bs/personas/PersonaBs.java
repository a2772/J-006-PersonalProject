/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paris.bs.personas;

import com.paris.bd.personas.PersonaBd;
import com.paris.clases.personas.Persona;

/**
 *
 * @author paris
 */
public class PersonaBs {
    /**
     * Busca una persona por id
     * @param id
     * @return 
     */
    public static final Persona obtenPersona(int id){
        Persona persona = new Persona();
        PersonaBd.buscaPersonaEnBd(String.valueOf(id), null);
        return persona;
    }
}
