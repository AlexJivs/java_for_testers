package ru.stqa.calcTriangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateArea() {
        Assertions.assertEquals(3.897114317029974, AriaTriangle.areaTriangle(3.0, 3.0, 3.0));
    }

    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(12.0, PerimeterTriangle.perimeterTriangle(3.0, 4.0, 5.0));

    }
}
