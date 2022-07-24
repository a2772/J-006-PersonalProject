package com.test.main.classes;

public class Padre {
    private int c = 1;
    protected int d = 1;
    public Padre(int a, int b){
        System.out.println("Padre constructor a,b" + a + "," + b);
    }
    public void nothing(){
        System.out.println("eds: " + this.d);
    }
    public void nothing(int a){
        System.out.println("edfg: " + this.d);
    }
    public void nothing(double a){
        System.out.println("asdfwebgrter: " + this.d);
    }
}
