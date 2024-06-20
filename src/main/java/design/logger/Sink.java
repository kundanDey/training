package design.logger;

import java.io.IOException;

public interface Sink{

    public void write(String message) throws IOException;
}
