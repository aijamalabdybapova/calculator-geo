package org.example;

import java.util.Scanner;
import java.lang.Math;

public class DistCal {

    // Радиус земли в километрах, final-значение не может быть изменено
    public static final double EARTH_RADIUS = 6371;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите широту первой точки (в градусах):");
        double shir1 = scanner.nextDouble();
        System.out.println("Введите долготу первой точки (в градусах):");
        double dol1 = scanner.nextDouble();

        System.out.println("Введите широту второй точки (в градусах):");
        double shir2 = scanner.nextDouble();
        System.out.println("Введите долготу второй точки (в градусах):");
        double dol2 = scanner.nextDouble();

        double rasstoyanie = caldis(shir1, dol1, shir2, dol2);
        System.out.println("Расстояние между двумя точками: " + rasstoyanie + " км");
    }
    public static double caldis(double shir1, double dol1, double shir2, double dol2) {
        double dshir = Math.toRadians(shir2 - shir1);
        double ddol = Math.toRadians(dol2 - dol1);
        double a = Math.sin(dshir / 2) * Math.sin(dshir / 2) +
                Math.cos(Math.toRadians(shir1)) * Math.cos(Math.toRadians(shir2)) * Math.sin(ddol / 2) * Math.sin(ddol / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double rasstoyanie = EARTH_RADIUS * c;
        return rasstoyanie;
    }
}

