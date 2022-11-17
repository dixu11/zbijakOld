package com.zbijak;

import java.util.ArrayList;
import java.util.List;

public class Zbijak {

    private Gracz gracz1 = new Gracz('o', 3, 2);
    private Gracz gracz2 = new Gracz('+', 1, 1);
    private Gracz gracz3 = new Gracz('x', 1, 2);

    public List<Gracz> gracze = new ArrayList<>();

    public void graj() {
        dodajGraczy();
        drukujPlansze();

        while ((!gracz1.isZbity()) && (gracze.size() >= 2)) {
            gracz1.ruszRecznie();
            sprCzyZbija(gracz1);
            drukujPlansze();

            gracz1.ruszRecznie();
            sprCzyZbija(gracz1);
            drukujPlansze();

            if (!gracz2.isZbity()) {
                gracz2.ruszAutomatycznie();
                sprCzyZbija(gracz2);
                drukujPlansze();
            }
            if (!gracz3.isZbity()) {
                gracz3.ruszAutomatycznie();
                sprCzyZbija(gracz3);
                drukujPlansze();
            }
            if (!gracz1.isZbity()) {
                System.out.println("Przegrałeś. Koniec gry");
                break;
            }
        }
    }

    public void dodajGraczy() {
        gracze.add(gracz1);
        gracze.add(gracz2);
        gracze.add(gracz3);
    }

    public void drukujPlansze() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                System.out.print(coNaPolu(y, x) + " ");
            }
            System.out.println();
        }
        System.out.println(gracze);
    }


    public void sprCzyZbija(Gracz graczBijacy) {
        if ((graczBijacy.getX() == gracz1.getX()) && (graczBijacy.getY() == gracz1.getY())) {
            gracz1.setZbity(true);
            System.out.println("Gracz " + gracz1 + " zbity");
            gracze.remove(gracz1);
        }

        if ((graczBijacy.getX() == gracz2.getX()) && (graczBijacy.getY() == gracz2.getY())) {
            gracz2.setZbity(true);
            System.out.println("Gracz " + gracz2 + " zbity");
            gracze.remove(gracz2);
        }
        if ((graczBijacy.getX() == gracz3.getX()) && (graczBijacy.getY() == gracz3.getY())) {
            gracz3.setZbity(true);
            System.out.println("Gracz " + gracz3 + " zbity");
            gracze.remove(gracz3);
        }
    }

    public char coNaPolu(int y, int x) {
        for (Gracz gracz : gracze) {
            if ((!gracz.isZbity()) && ((gracz.getX() == x) && (gracz.getY() == y))) {
                return gracz.getSymbol();
            }
        }
        return '-';
    }
}