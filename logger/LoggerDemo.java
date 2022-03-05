package platform.kata.academy.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerDemo {
    private final static Logger LOGGER = Logger.getLogger(LoggerDemo.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Hello");
        Logger log = Logger.getGlobal();
        Logger log1 = Logger.getLogger(LoggerDemo.class.getName());
    }

    public static void logging() {
        Logger log = Logger.getLogger("com.javamentor.logging.Test");
        log.log(Level.INFO, "Все хорошо");
        log.log(Level.WARNING, "Произошла ошибка");
    }
}
