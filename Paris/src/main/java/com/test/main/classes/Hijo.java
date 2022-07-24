package com.test.main.classes;

public class Hijo extends Padre{
    private int c = 3;
    protected int d = 3;
    public Hijo(int f, int g, int w){
        super(f,g);
        System.out.println("Hijo constructor f,g,w" + f + "," + g + "," + w);
    }
    @Override
    public void nothing(){
        System.out.println("Hijo: " + this.d);
        System.out.println("Padre: " + super.d);
    }
    public void random(){
        
    }
}

