package IOSystem;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface Reader {

    ArrayList<String> readInput() throws FileNotFoundException;
}
