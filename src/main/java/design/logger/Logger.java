package design.logger;

import java.util.HashMap;

public class Logger {

    private static final Logger INSTANCE = new Logger();

    private HashMap<LogLevel,MessageHandler> handlers = new HashMap<LogLevel,MessageHandler>();

    private Logger(){
        LoggerCongfiguration.setHandlers(handlers);
    }

    public static Logger getInstance(){
        return INSTANCE;
    }

    public void info(String message){
        handlers.get(LogLevel.INFO).write(message);
    }

    public void debug(String message){
        handlers.get(LogLevel.DEBUG).write(message);
    }

    public void error(String message){
        handlers.get(LogLevel.ERROR).write(message);
    }

}
