package platform.kata.academy.task4;

public class RobotConnectionException extends RuntimeException{
    public RobotConnectionException(String message) {
        super(message);

    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
