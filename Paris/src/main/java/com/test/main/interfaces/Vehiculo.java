package com.test.main.interfaces;

public interface Vehiculo {
    public void encenderMotor();
    public default void moverse(){
        
    }
    default double viscosidad(){
        return 2.0;
    }
}
