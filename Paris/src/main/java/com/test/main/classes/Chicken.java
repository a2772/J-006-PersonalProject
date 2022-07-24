/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.main.classes;

public class Chicken {

    private Integer eggs = 2;
    {
        eggs = 3;
    }

    public Chicken(int eggs) {
        this.eggs = eggs;
    }

    public static void main(String[] r) {
        var c1 = new Chicken(1);
        var c2 = new Chicken(2);
        var c3 = new Chicken(3);
        c1.eggs = c2.eggs;
        c2 = c1;
        c3.eggs = null;
    }
}
