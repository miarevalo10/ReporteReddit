package rx.exceptions;

public final class AssemblyStackTraceException extends RuntimeException {
    public final synchronized Throwable fillInStackTrace() {
        return this;
    }
}
