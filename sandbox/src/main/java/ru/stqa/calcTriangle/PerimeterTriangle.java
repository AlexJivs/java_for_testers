package ru.stqa.calcTriangle;

public class PerimeterTriangle {
    private double side1;
    private double side2;
    private double side3;

    public PerimeterTriangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public static void printPerimeterTriangle(PerimeterTriangle s)  {

        System.out.println("периметр треугольника со сторонами " + s.side1 + s.side2 + s.side3 + " = " + s.perimeterTriangle());
    }

    public double perimeterTriangle () {
        return this.side1 + this.side2 + this.side3;
    }

}
