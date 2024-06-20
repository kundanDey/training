package design.logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LoggerFactory {

    private static ConcurrentMap<String,Logger> factory = new ConcurrentHashMap<String,Logger>();

    private LoggerFactory(){

    }
}
