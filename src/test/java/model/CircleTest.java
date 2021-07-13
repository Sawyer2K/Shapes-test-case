package model;

import org.junit.jupiter.api.*;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class CircleTest {

    @Test
    @DisplayName("Test checks the correctness of creating a shape")
    public void circleInitTest() {
        String type = "Круг";
        int radius = 5;
        Circle circle = new Circle(type, radius);
        DecimalFormat dF = new DecimalFormat("#.##");

        String expectedType = "Круг";
        String expectedArea = "78,54";
        String expectedPerimeter = "31,42";
        String expectedRadius = "5";
        String expectedDiameter = "10";

        assertAll(
                () -> assertEquals(expectedType, circle.getType(),
                        "The type was initialized incorrectly"),
                () -> assertEquals(expectedArea, dF.format(circle.getArea()),
                        "The area was calculated incorrectly"),
                () -> assertEquals(expectedPerimeter, dF.format(circle.getPerimeter()),
                        "The perimeter was calculated incorrectly"),
                () -> assertEquals(expectedRadius, dF.format(circle.getRadius()),
                        "The radius was initialized incorrectly"),
                () -> assertEquals(expectedDiameter, dF.format(circle.getDiameter()),
                        "The diameter was calculated incorrectly")
        );
    }

    @Test
    @DisplayName("The test checks the correctness of the output of all the necessary parameters of the shape")
    public void getTextInfoTest() {
        String type = "Круг";
        int radius = 5;
        Shape circle = new Circle(type, radius);
        String actualMessage = circle.getTextInfo();

        String expectedMessage = "Тип фигуры: Круг\n" +
                "Площадь: 78,54 кв. мм\n" +
                "Периметр: 31,42 мм\n" +
                "Радиус: 5 мм\n" +
                "Диаметр: 10 мм\n";

        assertEquals(expectedMessage, actualMessage,
                "The output text pattern does not match the expected result");
    }
}
