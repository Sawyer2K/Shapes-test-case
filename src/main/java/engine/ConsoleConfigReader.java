package engine;

import org.apache.log4j.Logger;

public class ConsoleConfigReader {

    private static final Logger logger = Logger.getLogger(ConsoleConfigReader.class);

    String[] commandLineArgs;

    public ConsoleConfigReader(String[] commandLineArgs) {
        this.commandLineArgs = commandLineArgs;
    }

    public ApplicationConfigStorage readInput() {
        logger.debug("Start reading console arguments");

        var configStorage = new ApplicationConfigStorage();

        if (commandLineArgs.length % 2 != 0) {
            logger.fatal("Program crash, count of the command line arguments must be even");
            throw new ArrayStoreException("The List must contain an even number of arguments");
        }

        for (int i = 0; i <= commandLineArgs.length - 2; i += 2) {
            switch (commandLineArgs[i]) {
                case "-file":
                    configStorage.setPathToInputFile(commandLineArgs[i + 1]);
                    break;
                case "-out":
                    configStorage.setPathToOutputFile(commandLineArgs[i + 1]);
                    break;
                default:
                    logger.fatal("Program crash, unexpected flag as argument defined");
                    throw new IllegalArgumentException("Wrong flag");
            }
        }

        return configStorage;
    }
}
