package com.mycompany.turnbasedstack;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class TurnBasedStack {

    // Helper method to check if a number is even (returns true if even)
    static boolean isOddOrEven(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        Stack<Integer> lastHP = new Stack<>();

        int GameTimer = 1;
        Scanner myObj = new Scanner(System.in);
        Random random = new Random();

        int playerHP = 100;
        int botHP = 100;
        int playerMaxDmg = 10;
        int playerMinDmg = 5;
        int botDmg = 5;

        if (!isOddOrEven(GameTimer)) {
            System.out.println("You encountered an enemy!");
            System.out.println("Player HP: " + playerHP);
            System.out.println("Monster HP: " + botHP);
            System.out.println("What would you like to do?");
            System.out.println(">>Attack");
            System.out.println(">>Stun");
            System.out.println(">>Skip Turn");
            String in = myObj.nextLine();

            if (in.equalsIgnoreCase("attack")) {
                int playerDmg = playerMinDmg + random.nextInt(playerMaxDmg - playerMinDmg + 1);
                System.out.println("You dealt " + playerDmg + " damage to the enemy.");
                botHP = botHP - playerDmg;
                lastHP.push(botHP);
                System.out.println("The enemy has " + botHP + " HP remaining.");
            } else if (in.equalsIgnoreCase("stun")) {
                System.out.println("The player stunned the monster for 2 turns.");
            } else {
                System.out.println("You did nothing and skipped a turn.");
            }
            ++GameTimer;
        }
        else{
            int botDmg = botMaxDmg - random.nextInt(botMinDmg);
            System.out.println("It is the Monster's turn now");
            System.out.println("He smashes his club, dealing " + botDmg + "Damage");
            System.out.println("");
        }
    }
}