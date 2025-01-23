public class Triangle {
    public static void main(String[] args) {
        printPerimeterTriangle(3.0, 4.0, 5.0);

        printAreaTriangle(3.0, 3.0, 3.0);
    }


    private static void printAreaTriangle(double side1, double side2, double side3) {

        System.out.println("площадь треугольника со сторонами " + side1 + side2 + side3 + " = " + areaTriangle(side1, side2, side3));
    }

    private static double areaTriangle(double side1, double side2, double side3) {
        return Math.sqrt(((side1 + side2 + side3) / 2) * ((side1 + side2 + side3) / 2 - side1) * ((side1 + side2 + side3) / 2 - side2) * ((side1 + side2 + side3) / 2 - side3));
    }






    static void printPerimeterTriangle(double side1, double side2, double side3) {

        System.out.println("периметр треугольника со сторонами " + side1 + side2 + side3 + " = " + perimeterTriangle(side1, side2, side3));
    }



    private static double perimeterTriangle(double a, double b, double c) {
        return a + b + c;
    }
}
