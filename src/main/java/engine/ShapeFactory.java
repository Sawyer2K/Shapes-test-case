package engine;

import model.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ShapeFactory {

    public static final Logger logger = Logger.getLogger(ShapeFactory.class);

    public static Shape createShape(List<String> listOfInputData) {
        logger.debug("Starting to create shape");

        Shape shape;
        var shapeType = String.valueOf(listOfInputData.get(0));
        ArrayList<Double> paramsList = new ArrayList<>();

        logger.debug("Checking that the List of input data for initializing shapes is not empty");
        if (listOfInputData.isEmpty()) {
            logger.fatal("Program crash, the List of input data for initialization shape is empty");
            throw new ArrayStoreException("The List of input data received from the FileReader is empty");
        }

        logger.debug("Converting list of input parameters from String to Double type");
        for (int i = 1; i < listOfInputData.size(); i++) {
            paramsList.add(Double.valueOf(listOfInputData.get(i)));
        }

        switch (shapeType) {
            case "CIRCLE":
                shape = createCircle(paramsList);
                break;
            case "RECTANGLE":
                shape = createRectangle(paramsList);
                break;
            case "TRIANGLE":
                shape = createTriangle(paramsList);
                break;
            default:
                logger.fatal("Program crash, an unexpected type of a shape was passed to the switch statement");
                throw new IllegalArgumentException("Unsupported argument: " + shapeType);
        }

        logger.info("The creation of the shape has been completed successfully");

        return shape;
    }

    private static Shape createCircle(ArrayList<Double> paramsList) {
        if (paramsList.size() != 1) {
            logger.fatal("Invalid list of parameters was passed");
            throw new IllegalArgumentException("The parameter List does not match the expected size");
        } else if (paramsList.get(0) < 1) {
            logger.fatal("Invalid parameter was passed into the circle");
            throw new IllegalArgumentException("Parameters passed to the shape are invalid");
        }

        var shapeName = "Круг";
        var radius = paramsList.get(0);

        return new Circle(shapeName, radius);
    }

    private static Shape createRectangle(ArrayList<Double> paramsList) {
        if (paramsList.size() != 2) {
            logger.fatal("Invalid list of parameters was passed");
            throw new IllegalArgumentException("The parameter's List does not match the expected size");
        }

        for (double param : paramsList) {
            if (param < 1) {
                logger.fatal("Invalid parameters were passed into the rectangle");
                throw new IllegalArgumentException("Parameters passed to the shape are invalid");
            }
        }

        var shapeName = "Прямоугольник";
        var length = paramsList.get(0);
        var width = paramsList.get(1);

        return new Rectangle(shapeName, length, width);
    }

    private static Shape createTriangle(ArrayList<Double> paramsList) {
        if (paramsList.size() != 3) {
            logger.fatal("Invalid list of parameters was passed");
            throw new IllegalArgumentException("The parameter List does not match the expected size");
        }

        for (double param : paramsList) {
            if (param < 1) {
                logger.fatal("Invalid parameters were passed into the triangle");
                throw new IllegalArgumentException("Parameters passed to the shape are invalid");
            }
        }

        var shapeName = "Треугольник";
        var sideA = paramsList.get(0);
        var sideB = paramsList.get(1);
        var sideC = paramsList.get(2);

        return new Triangle(shapeName, sideA, sideB, sideC);
    }
}
