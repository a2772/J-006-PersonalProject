package com.test.main.classes;

import com.test.main.interfaces.Vehiculo;

public class VehiculoCarga implements Vehiculo {
        public void ingresaCarga(){
            System.out.println("Ingresando carga VehiculoCarga");
        }
        @Override
        public void encenderMotor()
        {
            System.out.println("C enciende motor VehiculoCarga");
        }
        @Override
        public void moverse()
        {
            System.out.println("C mueve VehiculoCarga");
        }
    }
