package ru.stqa.calcTriangle;

public class PerimeterTriangle {
    static void printPerimeterTriangle(double side1, double side2, double side3) {

        System.out.println("периметр треугольника со сторонами " + side1 + side2 + side3 + " = " + perimeterTriangle(side1, side2, side3));
    }

    public static double perimeterTriangle(double a, double b, double c) {
        return a + b + c;
    }
}
