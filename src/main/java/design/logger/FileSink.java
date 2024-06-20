package design.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSink implements Sink{

    File file;
    BufferedWriter bw;
    @Override
    public void write(String message) throws IOException {
        rotateFile();
        bw.write(message);
    }

    private void rotateFile() throws IOException {
        bw = new BufferedWriter(new FileWriter(file));
    }
}
