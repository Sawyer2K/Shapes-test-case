package model;

import org.junit.jupiter.api.*;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class RectangleTest {
    @Test
    @DisplayName("Test checks the correctness of creating a shape")
    public void rectangleInitTest() {
        String type = "Прямоугольник";
        int length = 8;
        int width = 6;
        Rectangle rectangle = new Rectangle(type, length, width);
        DecimalFormat dF = new DecimalFormat("#.##");

        String expectedType = "Прямоугольник";
        String expectedArea = "48";
        String expectedPerimeter = "28";
        String expectedDiagonal = "10";
        String expectedLength = "8";
        String expectedWidth = "6";

        assertAll(
                () -> assertEquals(expectedType, rectangle.getType(),
                        "The type was initialized incorrectly"),
                () -> assertEquals(expectedArea, dF.format(rectangle.getArea()),
                        "The area was calculated incorrectly"),
                () -> assertEquals(expectedPerimeter, dF.format(rectangle.getPerimeter()),
                        "The perimeter was calculated incorrectly"),
                () -> assertEquals(expectedDiagonal, dF.format(rectangle.getDiagonal()),
                        "The diagonal was calculated incorrectly"),
                () -> assertEquals(expectedLength, dF.format(rectangle.getLength()),
                        "The length was defined incorrectly"),
                () -> assertEquals(expectedWidth, dF.format(rectangle.getWidth()),
                        "The width was defined incorrectly")
        );
    }

    @Test
    @DisplayName("The test checks the correctness of the output of all the necessary parameters of the shape")
    public void getTextInfoTest() {
        String type = "Прямоугольник";
        int length = 8;
        int width = 6;
        Shape rectangle = new Rectangle(type, length, width);
        String actualMessage = rectangle.getTextInfo();

        String expectedMessage = "Тип фигуры: Прямоугольник\n" +
                "Площадь: 48 кв. мм\n" +
                "Периметр: 28 мм\n" +
                "Длина диагонали: 10 мм\n" +
                "Длина: 8 мм\n" +
                "Ширина: 6 мм\n";

        assertEquals(expectedMessage, actualMessage,
                "The output text pattern does not match the expected result");
    }
}
