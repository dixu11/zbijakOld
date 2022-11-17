package com.zbijak;

import java.util.Random;
import java.util.Scanner;

public class Gracz {

    private char symbol;
    private int y;
    private int x; // pozycja gracza przechowywana w graczu i nigdzie więcj bo powtarzam kod

    private boolean zbity = false;

    public Gracz(char symbol, int y, int x) {
        this.symbol = symbol;
        this.y = y;
        this.x = x;
    }

    public void ruszRecznie() { // w s a d
        Scanner scanner = new Scanner(System.in);
        System.out.println("Twój pionek to \"o\".wykonaj ruch (w/s/a/d)");
        String litera = scanner.nextLine();

        if ((litera.equals("w")) && (x != 0)) {
            y = y - 1;
        }
        if ((litera.equals("s")) && (x != 5)) {
            y = y + 1;
        }
        if ((litera.equals("a")) && (y != 0)) {
            x = x - 1;
        }
        if ((litera.equals("d")) && y != 5) {
            x = x + 1;
        }
    }

    public void ruszAutomatycznie() {
        int ruch1 = y - 1;
        int ruch2 = y + 1;
        int ruch3 = x - 1;
        int ruch4 = x + 1;

        int[] ruchyY = {ruch1, ruch2};
        int[] ruchyX = {ruch3, ruch4};

        Random random = new Random();
        y = random.nextInt(ruchyY.length);
        x = random.nextInt(ruchyX.length);

    }

    public boolean isZbity() {
        return zbity;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setZbity(boolean zbity) {
        this.zbity = zbity;
    }

    @Override
    public String toString() {
        return "Gracz{" +
                "symbol=" + symbol +
                ", y=" + y +
                ", x=" + x +
                '}';
    }
}
