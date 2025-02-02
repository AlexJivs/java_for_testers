package ru.stqa.geometry.figures;

import java.security.PublicKey;

public class Triangle {

    private double side1;
    private double side2;
    private double side3;

        // Проверка наличия отрицательных сторон
    public Triangle (double side1, double side2, double side3) {
        if (side1 < 0 || side2 < 0 || side3 < 0) {
            throw new IllegalArgumentException("Сторона треугольника не должна иметь отрицательное значание.");
        }
        //Проверка на неравенство треугольника
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalArgumentException("Нарушается неравенство треугольника: сумма двух любых сторон должна быть не меньше третьей стороны.");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }


    public static void main(String[] args) {
        try {
            printTriangleArea (new Triangle(1.0, 1.0, 3.0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            printTrianglePerimeter(new Triangle(-3.0, 2.0, 2.0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }



    private static void printTrianglePerimeter(Triangle w) {
        System.out.println("периметр треугольника со сторонами " +  w.side1 + " и " +  w.side2 + " и "  +  w.side3  + " = " + w.trianglePerimeter());
    }
    public double trianglePerimeter() {
        return side1 + side2 + side3;
    }




    public static void printTriangleArea(Triangle s) {
        System.out.println("площадь треугольника со сторонами " +  s.side1 + " и " +  s.side2 + " и " +  s.side3  + " = " + s.triangleArea());
    }
    public double triangleArea() {
        double p = trianglePerimeter()/2; // полупериметр
        return Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));
    }

}
