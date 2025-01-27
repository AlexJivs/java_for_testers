package ru.stqa.calcTriangle;

public class AriaTriangle {
    static void printAreaTriangle(double side1, double side2, double side3) {

        System.out.println("площадь треугольника со сторонами " + side1 + side2 + side3 + " = " + areaTriangle(side1, side2, side3));
    }

    public static double areaTriangle(double side1, double side2, double side3) {
        return Math.sqrt(((side1 + side2 + side3) / 2) * ((side1 + side2 + side3) / 2 - side1) * ((side1 + side2 + side3) / 2 - side2) * ((side1 + side2 + side3) / 2 - side3));
    }
}
