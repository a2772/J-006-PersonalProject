package com.test.main.classes;

public class Pintura extends Color{
    private Color color;
    private String nombre;
    private String espesor;
    
    public Pintura(short r, short g, short b){
        super((short)r,(short)g,(short)b);
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the espesor
     */
    public String getEspesor() {
        return espesor;
    }

    /**
     * @param espesor the espesor to set
     */
    public void setEspesor(String espesor) {
        this.espesor = espesor;
    }
    
}
