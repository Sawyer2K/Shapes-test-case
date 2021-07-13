package IOSystem;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader implements Reader {

    private static final Logger logger = Logger.getLogger(FileReader.class);

    final String pathToInputFile;

    public FileReader(String pathToInputFile) {
        this.pathToInputFile = pathToInputFile;
    }

    @Override
    public ArrayList<String> readInput() throws FileNotFoundException {
        logger.debug("Start reading data from input file");

        ArrayList<String> inputData = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(pathToInputFile))) {
            while (scanner.hasNext()) {
                inputData.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            logger.fatal("The program crashes, the input file is not found", e);
            throw e;
        }

        logger.debug("Successful completion of data reading from input file");

        return inputData;
    }
}
