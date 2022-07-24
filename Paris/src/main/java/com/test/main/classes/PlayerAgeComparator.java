/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.main.classes;

import java.util.Comparator;

/**
 *
 * @author paris
 */
public class PlayerAgeComparator implements Comparator<Player>{
    @Override
    public int compare(Player firstPlayer, Player secondPlayer) {
       return Integer.compare(firstPlayer.getAge(), secondPlayer.getAge());
    }
}
