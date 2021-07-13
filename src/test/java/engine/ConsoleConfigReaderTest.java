package engine;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ConsoleConfigReaderTest {

    @Test
    @DisplayName("Test checks correct reading of the parameters specified out of order and their correct initialization")
    public void readInputTestFirstCase() {
        ApplicationConfigStorage configStorage = new ApplicationConfigStorage();
        configStorage.setPathToOutputFile("path/to/input/file");
        String[] inputFromCLI = new String[]{"-out", "path/to/output/file", "-file", "path/to/input/file"};
        ConsoleConfigReader configReader = new ConsoleConfigReader(inputFromCLI);
        configReader.readInput();

        String expectedIn = "path/to/input/file";
        String expectedOut = "path/to/output/file";

        assertAll(
                () -> assertEquals(expectedIn, configStorage.getPathToInputFile(),
                        "The initialized path to input file does not match the expected one"),
                () -> assertEquals(expectedOut, configStorage.getPathToOutputFile(),
                "The initialized path to input file does not match the expected one"));

    }

    @Test
    @DisplayName("Test checks work of the method if an invalid command line arguments are passed")
    public void readInputTestSecondCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            ApplicationConfigStorage configStorage = new ApplicationConfigStorage();
            configStorage.setPathToOutputFile("/path/to/input/file2");

            String[] inputFromCLI = new String[]{"out", "path/to/output/file2", "-inputFile", "path/to/input/file"};

            ConsoleConfigReader configReader = new ConsoleConfigReader(inputFromCLI);
            configReader.readInput();
        }, "Invalid arguments were passed, an IllegalArgumentException is expected");
    }
}
