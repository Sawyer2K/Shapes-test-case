package model;

import org.junit.jupiter.api.*;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TriangleTest {

    @Test
    @DisplayName("Test checks the correctness of creating a shape")
    public void triangleInitTest() {
        String type = "Треугольник";
        int sideA = 3;
        int sideB = 4;
        int sideC = 5;
        Triangle triangle = new Triangle(type, sideA, sideB, sideC);
        DecimalFormat dF = new DecimalFormat("#.##");

        String expectedType = "Треугольник";
        String expectedArea = "6";
        String expectedPerimeter = "12";
        String expectedSideA = "3";
        String expectedSideB = "4";
        String expectedSideC = "5";
        String expectedAngleA = "36,87";
        String expectedAngleB = "53,13";
        String expectedAngleC = "90";

        assertAll(
                () -> assertEquals(expectedType, triangle.getType(),
                        "The type was initialized incorrectly"),
                () -> assertEquals(expectedArea, dF.format(triangle.getArea()),
                        "The area was calculated incorrectly"),
                () -> assertEquals(expectedPerimeter, dF.format(triangle.getPerimeter()),
                        "The perimeter was calculated incorrectly"),
                () -> assertEquals(expectedSideA, dF.format(triangle.getSideA()),
                        "The side A was initialized incorrectly"),
                () -> assertEquals(expectedSideB, dF.format(triangle.getSideB()),
                        "The side B was initialized incorrectly"),
                () -> assertEquals(expectedSideC, dF.format(triangle.getSideC()),
                        "The side C was initialized incorrectly"),
                () -> assertEquals(expectedAngleA, dF.format(triangle.getAngleA()),
                        "The angle opposite to side A was calculated incorrectly"),
                () -> assertEquals(expectedAngleB, dF.format(triangle.getAngleB()),
                        "The angle opposite to side B was calculated incorrectly"),
                () -> assertEquals(expectedAngleC, dF.format(triangle.getAngleC()),
                        "The angle opposite to side C was calculated incorrectly")

        );
    }

    @Test
    @DisplayName("The test checks the correctness of the output of all the necessary parameters of the shape")
    public void getTextInfoTest() {
        String type = "Треугольник";
        int sideA = 3;
        int sideB = 4;
        int sideC = 5;
        Shape triangle = new Triangle(type, sideA, sideB, sideC);
        String actualMessage = triangle.getTextInfo();

        String expectedMessage = "Тип фигуры: Треугольник\n" +
                "Площадь: 6 кв. мм\n" +
                "Периметр: 12 мм\n" +
                "Сторона A: 3 мм, противолежащий угол: 36,87 градусов\n" +
                "Сторона B: 4 мм, противолежащий угол: 53,13 градусов\n" +
                "Сторона C: 5 мм, противолежащий угол: 90 градусов\n";

        assertEquals(expectedMessage, actualMessage,
                "The output text pattern does not match the expected result");
    }
}
