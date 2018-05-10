package rx.exceptions;

public class OnErrorFailedException extends RuntimeException {
    public OnErrorFailedException(String str, Throwable th) {
        super(str, th);
    }

    public OnErrorFailedException(Throwable th) {
        super(th.getMessage(), th);
    }
}
