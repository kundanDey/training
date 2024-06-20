package design.logger;

import java.util.HashMap;

public class LoggerCongfiguration {

    private static LogLevel logLevel = LogLevel.DEBUG;

    public static void setHandlers(HashMap<LogLevel, MessageHandler> handlers) {
        //todo add handlers in map
    }
}
