package persistence;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
public class writer {
    private static PrintWriter printWriter;
    // EFFECTS: constructs a writer that will write data to file
    public Writer(File file) throws FileNotFoundException, UnsupportedEncodingException {
        printWriter = new PrintWriter(file, "UTF-8");
    }
    // MODIFIES: this
    // EFFECTS: writes saveable to file
    public static void write(Saveable saveable) {
        saveable.save(printWriter);
    }
    // MODIFIES: this
    // EFFECTS: close print writer
    public static void close() {
        printWriter.close();
    }
}
