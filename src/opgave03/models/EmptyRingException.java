package opgave03.models;
public class EmptyRingException extends RuntimeException {
    public EmptyRingException() {
        super();
    }
    public EmptyRingException(String message) {
        super(message);
    }
}