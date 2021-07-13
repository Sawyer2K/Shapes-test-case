package IOSystem;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class FileReaderTest {

    @Test
    @DisplayName("Test checks that FileNotFoundException has been throws when the wrong path to input file was specified")
    public void readInputTestFirstCase() {
        assertThrows(FileNotFoundException.class, () -> {
            String inputFromCLI = "./src/test/resources/WrongFileName.txt";
            FileReader fileReader = new FileReader(inputFromCLI);
            fileReader.readInput();
        }, "FileNotFoundException should have been thrown but it wasn't");
    }

    @Test
    @DisplayName("Test checks that the method does not return an empty List if the path to the input file is correct")
    public void readInputTestSecondCase() throws FileNotFoundException {
        String inputFromCLI = "./src/test/resources/TriangleExample.txt";
        FileReader fileReader = new FileReader(inputFromCLI);
        List<String> list = fileReader.readInput();

        assertFalse(list.isEmpty(), "The returned list must noy be empty");
    }
}
