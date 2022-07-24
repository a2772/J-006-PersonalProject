/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.main.classes;

import java.util.Arrays;


interface Prueba1 {

    String NUMEROS = "Diving!"; // k1

    abstract int breath();

    private void stroke() {
        if (breath() == 1) { // k2
            System.out.print("Go!");
        } else {
            System.out.print(dive()); // k3
        }
    }

    static String dive() {
        return ""; // k4
    }
}

@FunctionalInterface
interface Pump {

    void pump(double psi);
}

@FunctionalInterface
interface Bend extends Pump {

    default void bend(double tensileStrength) {
    }
}

public class Robot {

    public static final void apply(Pump instruction, double input) {
        instruction.pump(input);
    }

    public static void main(String... future) {
        final Robot r = new Robot();
        r.apply(f -> System.out.print(f + " bent!" + f), 5);
    }

    double ageMonths = 5, ageDays = 2;
    static String weight = "A lot";
    static boolean success = true;
    protected String retries2 = "Robot Tries";

    public void doSomething() {
        final String retries = "1";
        System.out.println(this.success);
        System.out.println(retries);
        this.retries2 = retries;
    }
}
