package engine;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ApplicationDispatcherTest {

    @Test
    @DisplayName("Test checks correct parameters initialization if was entered only the path to the input file")
    public void applicationParamsInitTestCaseOne() {
        String[] commandLineArgs = new String[]{"-file", "./src/test/resources/CircleExample.txt"};
        ApplicationDispatcher dispatcher = new ApplicationDispatcher();
        dispatcher.applicationParamsInit(commandLineArgs);

        String expectedPathToInput = "./src/test/resources/CircleExample.txt";

        assertAll(
                () -> assertEquals(expectedPathToInput, dispatcher.getPathToInputFile(),
                        "The initialized path to the input file does not match the data entered in the console."),
                () -> assertNull(dispatcher.getPathToOutputFile(),
                        "Path to output files variable must be NULL, but it's not."),
                () -> assertFalse(dispatcher.isOutputFileExists(),
                        "Output file must not be exists."));
    }

    @Test
    @DisplayName("Test checks correct parameters initialization if was entered both path to the input and output files")
    public void applicationParamsInitTestCaseTwo() {
        String[] commandLineArgs = new String[]{"-file", "./src/test/resources/CircleExample.txt",
                "-out", "./src/test/resources/CircleExampleResult.txt"};
        ApplicationDispatcher dispatcher1 = new ApplicationDispatcher();
        dispatcher1.applicationParamsInit(commandLineArgs);

        String expectedPathToInput = "./src/test/resources/CircleExample.txt";
        String expectedPathToOutput = "./src/test/resources/CircleExampleResult.txt";

        assertAll(
                () -> assertEquals(expectedPathToInput, dispatcher1.getPathToInputFile(),
                        "The initialized path to the input file does not match the data entered in the console."),
                () -> assertEquals(expectedPathToOutput, dispatcher1.getPathToOutputFile(),
                        "The initialized path to the output file does not match the data entered in the console."),
                () -> assertTrue(dispatcher1.isOutputFileExists(), "Output file must be exist"));
    }

    @Test
    @DisplayName("The test checks that when receiving valid data, the method returns a non-null list")
    public void defineInputDataTestCaseOne() throws FileNotFoundException {
        String[] inputFromCLI = new String[]{"-file", "./src/test/resources/CircleExample.txt"};
        ApplicationDispatcher dispatcher = new ApplicationDispatcher();
        dispatcher.applicationParamsInit(inputFromCLI);
        List<String> inputData = dispatcher.defineInputData();

        assertNotNull(inputData);
    }

    @Test
    @DisplayName("The test checks that when receiving valid data, the method returns a non-null list")
    public void defineInputDataTestCaseTwo() throws FileNotFoundException {
        assertThrows(FileNotFoundException.class, () -> {
            String[] inputFromCLI = new String[]{"-file", "./src/test/resources/Wrong.txt"};
            ApplicationDispatcher dispatcher = new ApplicationDispatcher();
            dispatcher.applicationParamsInit(inputFromCLI);
            List<String> inputData = dispatcher.defineInputData();
        });
    }
}
