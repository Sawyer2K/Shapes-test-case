package engine;

import model.Shape;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ShapeFactoryTest {

    @Test
    @DisplayName("The test checks that the method throws an IllegalArgumentException if invalid shape's type is passed")
    public void createShapeTestCaseOne() {
        List<String> listOfInputData = new ArrayList<>();
        listOfInputData.add("RHOMBUS");
        listOfInputData.add("5");

        assertThrows(IllegalArgumentException.class,
                () -> {
                    Shape shape = ShapeFactory.createShape(listOfInputData);
                }, "An IllegalArgumentException was expected but it was not thrown");
    }

    @Test
    @DisplayName("The test checks that the method throws an IllegalArgumentException if zero was passed as a parameter")
    public void createShapeTestCaseTwo() {
        List<String> listOfInputData = new ArrayList<>();
        listOfInputData.add("RECTANGLE");
        listOfInputData.add("0");
        listOfInputData.add("4");

        assertThrows(IllegalArgumentException.class,
                () -> {
                    Shape shape = ShapeFactory.createShape(listOfInputData);
                }, "An IllegalArgumentException was expected but it was not thrown");
    }

    @Test
    @DisplayName("The test checks that the method throws an IllegalArgumentException if one of the parameters is a " +
            "negative number")
    public void createShapeTestCaseThree() {
        List<String> listOfInputData = new ArrayList<>();
        listOfInputData.add("TRIANGLE");
        listOfInputData.add("-1");
        listOfInputData.add("4");
        listOfInputData.add("5");

        assertThrows(IllegalArgumentException.class,
                () -> {
                    Shape shape = ShapeFactory.createShape(listOfInputData);
                }, "An IllegalArgumentException was expected but it was not thrown");
    }

    @Test
    @DisplayName("The test checks that the method throws an IllegalArgumentException if too many parameters are " +
            "passed for this shape")
    public void createShapeTestCaseFour() {
        List<String> listOfInputData = new ArrayList<>();
        listOfInputData.add("CIRCLE");
        listOfInputData.add("2");
        listOfInputData.add("4");
        listOfInputData.add("5");

        assertThrows(IllegalArgumentException.class,
                () -> {
                    Shape shape = ShapeFactory.createShape(listOfInputData);
                }, "An IllegalArgumentException was expected but it was not thrown");
    }

    @Test
    @DisplayName("The test checks that the method throws an IllegalArgumentException if not enough parameters " +
            "are passed for this shape")
    public void createShapeTestCaseFive() {
        List<String> listOfInputData = new ArrayList<>();
        listOfInputData.add("RECTANGLE");
        listOfInputData.add("4");

        assertThrows(IllegalArgumentException.class,
                () -> {
                    Shape shape = ShapeFactory.createShape(listOfInputData);
                }, "An IllegalArgumentException was expected but it was not thrown");
    }

    @Test
    @DisplayName("The test checks that the method throws an IllegalArgumentException if an empty parameter's " +
            "List is passed")
    public void createShapeTestCaseSix() {
        List<String> listOfInputData = new ArrayList<>();
        listOfInputData.add("TRIANGLE");

        assertThrows(IllegalArgumentException.class,
                () -> {
                    Shape shape = ShapeFactory.createShape(listOfInputData);
                }, "An IllegalArgumentException was expected but it was not thrown");
    }
}
