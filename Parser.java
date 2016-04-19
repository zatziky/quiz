import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class is thread safe.
 * <p>
 * TODO - Better documentation for the class
 */
public class Parser {

    private File file;

    public synchronized void setFile(File file) {
        this.file = file;
    }

    // TODO document public method
    public synchronized File getFile() {
        return this.file;
    }

    // TODO document public method
    public String getContent() throws IOException {
        FileInputStream inputStream = new FileInputStream(this.file);
        String output = "";
        int data;
        while ((data = inputStream.read()) > 0) {
            output += (char) data;
        }
        return output;
    }

    // TODO document public method
    public String getContentWithoutUnicode() throws IOException {
        FileInputStream inputStream = new FileInputStream(this.file);
        String output = "";
        int data;
        while ((data = inputStream.read()) > 0) {
            if (data < 0x80) {
                output += (char) data;
            }
        }
        return output;
    }

    // TODO document public method
    public void saveContent(String content) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(this.file);
        for (int i = 0; i < content.length(); i += 1) {
            outputStream.write(content.charAt(i));
        }
    }
}
