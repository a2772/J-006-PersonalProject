/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.main.classes;

public class Bottle {
    
    public static class Ship {

        private enum Sail { // w1
            TALL {
                protected int getHeight() {
                    return 100;
                }
            },
            SHORT {
                protected int getHeight() {
                    return 2;
                }
            };

            protected abstract int getHeight();
        }

        public Sail getSail() {
            return Sail.TALL;
        }
    }

    public static void main(String[] stars) {
        var bottle = new Bottle();
        //Ship q = bottle.new Ship(); // w2
        //System.out.print(q.getSail());
    }
}
