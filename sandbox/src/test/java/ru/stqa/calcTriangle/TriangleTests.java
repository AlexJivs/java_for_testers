package ru.stqa.calcTriangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateArea() {
        var s = new AriaTriangle(3.0, 3.0, 3.0);
        double result = s.areaTriangle();
        Assertions.assertEquals(3.897114317029974, result);
    }

    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(12.0, new PerimeterTriangle(3.0, 4.0, 5.0).perimeterTriangle());

    }
}
