package design.logger;

public interface MessageHandler {

    public void write(String message);
    public void setSink(Sink sink);
}
