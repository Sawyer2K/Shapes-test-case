import engine.ApplicationDispatcher;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        logger.info("Application started");

        ApplicationDispatcher dispatcher = new ApplicationDispatcher();

        dispatcher.applicationParamsInit(args);
        dispatcher.processShape();
        dispatcher.outputResults();

        logger.info("Application completed successfully");
    }
}
