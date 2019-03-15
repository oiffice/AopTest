package york.test.aoptest.exception;

public class InvalidateCityNameException extends Exception {

    public InvalidateCityNameException() {
        super();
    }

    public InvalidateCityNameException(Throwable t) {
        super(t.getMessage());
    }
}
