package com.test.main;

import com.test.main.classes.Airplane;
import com.test.main.classes.Player;
import com.test.main.classes.PlayerAgeComparator;
import com.test.main.classes.PlayerRankingComparator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PseudoMain {

    public static void main(String[] args) {

    }

    public static class Prueba {

        public static void brujeria001() {
            var plan = 1;
            plan = plan++ + --plan;
            plan = 1;
            plan = --plan + plan++;
            plan = 1;
            plan = --plan + --plan;
            plan = 1;
            plan = --plan + --plan + plan++;
            plan = 1;
            plan = --plan + plan;

            if (plan == 1) {
                System.out.println("Plan A");
            } else {
                if (plan == 2) {
                    System.out.println("Plan B");
                }
            }
        }

        public static void isInteger(Object variable) {
            int m = 0, n = 0;
            while (m < 5) {
                n++;
                if (m == 3) {
                    continue;
                }

                switch (m) {
                    case 0:
                    case 1:
                        n++;
                    default:
                        n++;
                }
                m++;
            }
            System.out.println(m + " " + n);
            System.out.println(variable instanceof Integer);
        }

        public static void test006() {
            var happy = " :) - (: ";
            var really = happy.trim();
            var question = happy.substring(0, 1);
            System.out.println(really.equals(question));
            System.out.println("012345".substring(0, 2));
        }

        public static void test005() {
            var list = new ArrayList<Integer>();
            list.add(10);
            list.add(9);
            list.add(8);

            var num = 9;
            list.removeIf(x -> {
                int keep = num;
                return x
                        != keep;
            });
            System.out.println(list);

            list.removeIf(x -> {
                int keep = num;
                return x
                        == keep;
            });
            System.out.println(list);
        }

        public static void secret(StringBuilder mystery) {
            char ch = mystery.charAt(3);
            mystery = mystery.insert(0, "more");
            int num = mystery.length();
        }

        public static void test004() {
            List<Player> footballTeam = new ArrayList<>();
            Player player1 = new Player(59, "John", 20);
            Player player2 = new Player(67, "Roger", 22);
            Player player3 = new Player(45, "Steven", 24);
            footballTeam.add(player1);
            footballTeam.add(player2);
            footballTeam.add(player3);

            PlayerRankingComparator playerRankingComparator = new PlayerRankingComparator();
            Collections.sort(footballTeam, playerRankingComparator);

            PlayerAgeComparator playerAgeComparator = new PlayerAgeComparator();
            Collections.sort(footballTeam, playerAgeComparator);

            //Comparator byRanking = (Player player1a, Player player2a) -> Integer.compare(player1a.getRanking(), player2a.getRanking());
            System.out.println("Before Sorting : " + footballTeam);
            Collections.sort(footballTeam);
            System.out.println("After Sorting : " + footballTeam);

        }

        public static void test003() {
            Comparator<String> c2 = (String j, String k)
                    -> 0;
            //Comparator<String> c3 = (var j, String k) -> 0;
            //Comparator<String> c4 = (var j, k) -> 0;
            Comparator<String> c5 = (var j, var k) -> 0;
        }

        public static void test002() {
            var line = new String("-");
            var anotherLine = line.concat("-");
            System.out.print(line == anotherLine);
            System.out.print(" ");
            System.out.print(line.length());
        }

        public static void test001() {
            var line = new StringBuilder("-");
            var anotherLine = line.append("-");
            System.out.print(line == anotherLine);
            System.out.print(" ");
            System.out.print(line.length());
        }

        public static void tests() {
            StringBuilder b = new StringBuilder("Gomitas");
            for (int i = 0; i < 99999; i++) {
                b.append(i);
            }
            System.out.println(b.toString());

        }

        public static void testRegion() {
            //Ponemos una región de México y vemos que imprime
            Locale.setDefault(new Locale("es", "MX"));
            System.out.println("Fecha 1: " + LocalDateTime.now());
            Locale.setDefault(new Locale("en", "US"));
            System.out.println("Fecha 2: " + LocalDateTime.now());
        }
    }
}
