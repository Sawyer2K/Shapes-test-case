package IOSystem;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ConsoleWriterTest {

    @Test
    @DisplayName("Test checks the correctness of the information output to the console")
    public void writeData() {
        String expectedMessage = "This message\n";
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        ConsoleWriter consoleWriter = new ConsoleWriter("This message");
        consoleWriter.writeData();
        String actualMessage = output.toString();

        assertEquals(expectedMessage, actualMessage,
                "The message displayed in the console is incorrect");
    }
}
