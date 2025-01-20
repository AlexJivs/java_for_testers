package ru.stqa.geometry.figures;

public class Rectangle {
    public static void printRectangleArea(double a, double b) {
        System.out.println("Площадь прямоугольника со стронами " + a + " и " + b + " = " + RectangleArea(a, b));
    }

    private static double RectangleArea(double a, double b) {
        return a * b;
    }
}
