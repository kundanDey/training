package design.logger;

public class ErrorMessageHandler implements MessageHandler {

    MessageHandler handler;
    private Sink sink = null;

    @Override
    public void write(String message) {
        if (sink != null) {
            try {
                sink.write(message);
            } catch (Exception e) {
            }

        }
        handler.write(message);
    }

    @Override
    public void setSink(Sink sink) {
        this.sink = sink;
    }

    public void setNextHandler(MessageHandler handler){
        this.handler = handler;
    }
}