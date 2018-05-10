package rx.exceptions;

public final class OnCompletedFailedException extends RuntimeException {
    public OnCompletedFailedException(String str, Throwable th) {
        super(str, th);
    }
}
