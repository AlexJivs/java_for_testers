package ru.stqa.geometry.figures;

public class Triangle {

    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }


    public static void main(String[] args) {
        printTriangleArea (new Triangle(3.0, 3.0, 3.0));
        printTrianglePerimeter(new Triangle(2.0, 2.0, 2.0));
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
        return Math.sqrt(((this.side1 + this.side2 + this.side3) / 2) * ((this.side1 + this.side2 + this.side3) / 2 - this.side1) * ((this.side1 + this.side2 + this.side3) / 2 - this.side2) * ((this.side1 + this.side2 + this.side3) / 2 - this.side3));
    }



}
