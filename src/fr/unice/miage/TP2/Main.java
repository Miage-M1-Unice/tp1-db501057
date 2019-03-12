package fr.unice.miage.TP2;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3);
        pol.getBounds();
        System.out.println(new GeneriqueToString().toString(pol, 2));
    }

}
