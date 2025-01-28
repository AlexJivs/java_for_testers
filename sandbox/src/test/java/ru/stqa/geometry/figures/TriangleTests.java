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
}
