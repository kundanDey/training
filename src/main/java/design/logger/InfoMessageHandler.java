//package design.logger;
//
//public class InfoMessageHandler implements MessageHandler{
//
//    private MessageHandler messageHandler = new DebugMessageHandler();
//    private Sink sink = null;
//    @Override
//    public void write(String message) {
//        if(sink != null){
//            try{
//                sink.write(message);
//            }catch (Exception e){}
//
//        }
//        messageHandler.write(message);
//    }
//
//    @Override
//    public void setSink(Sink sink) {
//        this.sink = sink;
//    }
//}
