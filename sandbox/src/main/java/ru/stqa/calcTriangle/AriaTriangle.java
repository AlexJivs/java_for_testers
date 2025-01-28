package ru.stqa.calcTriangle;

public class AriaTriangle {
    private double side1;
    private double side2;
    private double side3;

    public AriaTriangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

    }

    public static void printAreaTriangle(AriaTriangle s) {

        System.out.println("площадь треугольника со сторонами " + s.side1 + s.side2 + s.side3 + " = " + s.areaTriangle());
    }

    //public static double areaTriangle(double side1, double side2, double side3) {
        //return Math.sqrt(((side1 + side2 + side3) / 2) * ((side1 + side2 + side3) / 2 - side1) * ((side1 + side2 + side3) / 2 - side2) * ((side1 + side2 + side3) / 2 - side3));
        // }

    public double areaTriangle() {
        return Math.sqrt(((this.side1 + this.side2 + this.side3) / 2) * ((this.side1 + this.side2 + this.side3) / 2 - this.side1) * ((this.side1 + this.side2 + this.side3) / 2 - this.side2) * ((this.side1 + this.side2 + this.side3) / 2 - this.side3));
    }
}
