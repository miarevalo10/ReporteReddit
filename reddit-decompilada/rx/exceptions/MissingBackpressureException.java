package rx.exceptions;

public class MissingBackpressureException extends Exception {
    public MissingBackpressureException(String str) {
        super(str);
    }
}
