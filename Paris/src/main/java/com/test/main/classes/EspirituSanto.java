package com.test.main.classes;

public class EspirituSanto extends Hijo{
    private int c = 5;
    protected int d = 5;
    public EspirituSanto(int x, int z, int q){
        super(x,z,q);
        System.out.println("EspirituConstructor constructor x,z,q" + x + "," + z + "," + q);
    }
    /*@Override
    public void nothing(){
        System.out.println("Espíritu Santo: " + this.d);
        super.nothing();
    }*/
    public void something(){
        System.out.println("Estamos aqui");
    }
}
