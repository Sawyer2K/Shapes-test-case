package IOSystem;

public class ConsoleWriter implements Writer {

    String outputData;

    public ConsoleWriter(String outputData) {
        this.outputData = outputData;
    }

    @Override
    public void writeData() {
        System.out.println(outputData);
    }
}
