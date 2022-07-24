/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.main.classes;

/**
 *
 * @author paris
 */
public class Canine {

    public String woof(int bark) {
        return "1" + bark;
    }

    public String woof(Integer bark) {
        return "2" + bark.toString();
    }

    public String woof(Object bark) {
        return "3" + bark.toString();
    }

    public static void main(String[] a) {
        Canine canine = new Canine();
        Object numero = 5;
        System.out.println(canine.woof(numero));
    }

}
