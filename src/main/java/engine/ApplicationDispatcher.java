package engine;

import IOSystem.*;
import model.Shape;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.List;

public class ApplicationDispatcher {

    private static final Logger logger = Logger.getLogger(ApplicationDispatcher.class);

    private String pathToInputFile;
    private String pathToOutputFile;
    private boolean outputFileExists = false;
    private Shape shape;

    public String getPathToInputFile() {
        return pathToInputFile;
    }

    public String getPathToOutputFile() {
        return pathToOutputFile;
    }

    public boolean isOutputFileExists() {
        return outputFileExists;
    }

    public void applicationParamsInit(String[] args) {
        logger.debug("Start of application parameters initialization");

        var consoleConfigReader = new ConsoleConfigReader(args);
        var applicationConfigStorage = consoleConfigReader.readInput();

        pathToInputFile = applicationConfigStorage.getPathToInputFile();

        if (applicationConfigStorage.getPathToOutputFile() != null) {
            pathToOutputFile = applicationConfigStorage.getPathToOutputFile();
            outputFileExists = true;
        }

        logger.debug("Successful completion of application parameters initialization");
    }

    public List<String> defineInputData() throws FileNotFoundException {
        logger.debug("Start reading the input parameters");

        var fileReader = new FileReader(pathToInputFile);

        return fileReader.readInput();
    }

    public void processShape() throws FileNotFoundException {
        logger.debug("Starting to create a shape");

        shape = ShapeFactory.createShape(defineInputData());

        logger.debug("Successful completion of the shape creation");
    }

    public void outputResults() {
        logger.debug("Start of information output");

        Writer writer;
        var outputData = shape.getTextInfo();

        if (outputFileExists) {
            writer = new FileWriter(pathToOutputFile, outputData);
        } else {
            writer = new ConsoleWriter(outputData);
        }

        try {
            writer.writeData();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        logger.debug("Successful completion of information output");
    }
}
