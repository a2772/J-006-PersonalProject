package com.test.main.classes;

public class Color {
    private short r;
    private short g;
    private short b;
    public Color(short r, short g, short b){
        this.r = r;
        this.g = g;
        this.b = b;
        System.out.println("Constructor color");
    }

    /**
     * @return the r
     */
    public short getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(short r) {
        this.r = r;
    }

    /**
     * @return the g
     */
    public short getG() {
        return g;
    }

    /**
     * @param g the g to set
     */
    public void setG(short g) {
        this.g = g;
    }

    /**
     * @return the b
     */
    public short getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(short b) {
        this.b = b;
    }
    
}