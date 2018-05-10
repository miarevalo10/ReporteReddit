package rx.exceptions;

public final class UnsubscribeFailedException extends RuntimeException {
    public UnsubscribeFailedException(String str, Throwable th) {
        super(str, th);
    }
}
