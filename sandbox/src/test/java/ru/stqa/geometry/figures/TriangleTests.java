package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateArea() {
        var s = new Triangle(3.0, 3.0, 2.0);
        double result = s.triangleArea();
        Assertions.assertEquals(2.8284271247461903, result); //Triangle.triangleArea(3.0, 3.0, 2.0));
    }

    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(9.0, new Triangle(3.0, 3.0, 3.0).trianglePerimeter());
    }

    @Test
    void cannotCreateNegativeSide(){
        try {
            new Triangle(-5.0,5.0,5.0);
            Assertions.fail("fail: тест упал т.к. он проверяет отрицательные значения, а у вас положительные.");
        } catch (IllegalArgumentException exception) {
            System.out.println("Длины сторон треугольника должны быть положительными числами");

        }

    }

    @Test
    void cannotCreateTriangleInequality(){
        try{
            new Triangle(8.0,8.0,4.0);
            Assertions.fail("fail: тест упал т.к. он проверяет, что сумма двух любых сторон должна быть не меньше третьей стороны, а у нас сумма двух сторон больше третьей.");
        } catch (IllegalArgumentException exception) {
            System.out.println("Нарушено равенство треугольника: сумма двух сторон должна быть не меньше третьей стороны.");
        }
    }
}
