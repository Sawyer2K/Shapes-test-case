package IOSystem;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter implements Writer {

    private static final Logger logger = Logger.getLogger(FileWriter.class);

    String pathToOutputFile;
    String outputData;

    public FileWriter(String pathToOutputFile, String outputData) {
        this.pathToOutputFile = pathToOutputFile;
        this.outputData = outputData;
    }

    @Override
    public void writeData() throws FileNotFoundException {
        logger.debug("Start writing data to a file");

        try (PrintWriter writer = new PrintWriter(pathToOutputFile)) {
            writer.write(outputData);
        } catch (FileNotFoundException e) {
            logger.fatal("Program crash, the output file could not be reached");
            throw e;
        }

        logger.debug("Successful completion of writing data to a file");
    }
}
