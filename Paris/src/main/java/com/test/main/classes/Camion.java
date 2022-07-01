/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.main.classes;

import com.test.main.interfaces.Vehiculo;

public class Camion extends VehiculoCarga {

    public void ingresaCarga() {
        System.out.println("Ingresando carga Camion");
    }

    @Override
    public void encenderMotor() {
        System.out.println("C enciende motor Camión");
    }

    @Override
    public void moverse() {
        System.out.println("C mueve Camion");
    }
}
