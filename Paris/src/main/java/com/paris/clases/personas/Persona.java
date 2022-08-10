/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paris.clases.personas;

import com.paris.clases.direccion.Direccion;
import com.paris.clases.direccion.EntidadFederativa;
import com.paris.clases.perfil.TipoCuenta;
import com.paris.interfaces.Generate;
import com.paris.modelo.database.MySQL;
import com.paris.settings.globals.Dictionary;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author paris
 */
public class Persona implements Generate{
    private int id;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private LocalDate fechaNac;
    private String sexo;
    private String curp;
    private TipoCuenta tipoCuenta;
    private Direccion direccion;
    private Cuenta cuenta;
    
    /**
     * Llena a Persona con los datos de un registro. Generar con SP obten_persona
     * @param registro 
     */
    @Override
    public void generaObjeto(ArrayList<Object> registro){
        try{
            this.id = Integer.parseInt(registro.get(0).toString());
            this.nombre = registro.get(1).toString();
            this.apPaterno = registro.get(2).toString();
            this.apMaterno = registro.get(3) == null ? "" : registro.get(3).toString();
            this.fechaNac = LocalDate.parse(registro.get(4).toString(),MySQL.FORMATO_FECHA);
            this.sexo = registro.get(5).toString();
            this.curp = registro.get(6) == null ? "" : registro.get(6).toString();
            TipoCuenta tipoCuentaTmp = new TipoCuenta();
            tipoCuentaTmp.setId(Integer.parseInt(registro.get(7).toString()));
            tipoCuentaTmp.setCuenta(registro.get(8).toString());
            this.tipoCuenta = tipoCuentaTmp;
            Direccion direccionTmp = new Direccion();
            direccionTmp.setId(Integer.parseInt(registro.get(9).toString()));
            direccionTmp.setAlcaldia(registro.get(10).toString());
            direccionTmp.setColonia(registro.get(11).toString());
            direccionTmp.setCalle(registro.get(12).toString());
            direccionTmp.setNumExt(registro.get(13).toString());
            direccionTmp.setNumInt(registro.get(14) == null ? "" : 
                    registro.get(14).toString());
            direccionTmp.setCp(registro.get(15).toString());
            EntidadFederativa entidadFederativaTmp = new EntidadFederativa();
            entidadFederativaTmp.setId(Integer.parseInt(registro.get(16).toString()));
            entidadFederativaTmp.setEntidad(registro.get(17).toString());
            entidadFederativaTmp.setClave(registro.get(18).toString());
            direccionTmp.setEntidadFederativa(entidadFederativaTmp);
            this.direccion = direccionTmp;
            Cuenta cuentaTmp = new Cuenta();
            cuentaTmp.setEmail(registro.get(19) == null ? "" : 
                    registro.get(19).toString());
            this.cuenta = cuentaTmp;
        }catch(NumberFormatException | IndexOutOfBoundsException | NullPointerException ex){
            this.id = Dictionary.ID_NOT_FOUND;//marcamos que hubo error
        }
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apPaterno
     */
    public String getApPaterno() {
        return apPaterno;
    }

    /**
     * @param apPaterno the apPaterno to set
     */
    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    /**
     * @return the apMaterno
     */
    public String getApMaterno() {
        return apMaterno;
    }

    /**
     * @param apMaterno the apMaterno to set
     */
    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    /**
     * @return the fechaNac
     */
    public LocalDate getFechaNac() {
        return fechaNac;
    }

    /**
     * @param fechaNac the fechaNac to set
     */
    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the curp
     */
    public String getCurp() {
        return curp;
    }

    /**
     * @param curp the curp to set
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * @return the tipoCuenta
     */
    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * @param tipoCuenta the tipoCuenta to set
     */
    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    /**
     * @return the direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the cuenta
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
}
