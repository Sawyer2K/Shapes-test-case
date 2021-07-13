package IOSystem;

import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class FileWriterTest {

    @Test
    @DisplayName("Test checks the correctness of the information output to the file")
    public void writeDataTestCaseOne() throws IOException {
        String pathToOutputFile = "./src/test/resources/TestExampleOut.txt";
        String expected = "This text\n" +
                "must match";
        FileWriter fileWriter = new FileWriter(pathToOutputFile, expected);
        fileWriter.writeData();

        StringBuilder fileData = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(pathToOutputFile));
        char[] buf = new char[1024];
        int numRead;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        String actual = fileData.toString();

        assertEquals(expected, actual, "The information written to the file does not match the expected one");
    }

    @Test
    @DisplayName("The test checks for throwing an exception if the path to the output file is not defined")
    public void writeDataTestCaseTwo() {
        assertThrows(FileNotFoundException.class, () -> {
            String pathToOutputFile = "";
            String outputData = "Data for output";
            FileWriter writer = new FileWriter(pathToOutputFile,outputData);
            writer.writeData();
        }, "FileNotFoundException should have been thrown but it wasn't");
    }
}
