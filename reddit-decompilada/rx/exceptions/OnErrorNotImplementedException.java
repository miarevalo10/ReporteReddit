package rx.exceptions;

public class OnErrorNotImplementedException extends RuntimeException {
    public OnErrorNotImplementedException(String str, Throwable th) {
        super(str, th);
    }

    public OnErrorNotImplementedException(Throwable th) {
        String message = th != null ? th.getMessage() : null;
        if (th == null) {
            th = new NullPointerException();
        }
        super(message, th);
    }
}
