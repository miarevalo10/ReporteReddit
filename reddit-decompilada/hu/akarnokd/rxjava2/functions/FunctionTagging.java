package hu.akarnokd.rxjava2.functions;

public final class FunctionTagging {

    public static final class FunctionTaggingException extends RuntimeException {
        public final synchronized Throwable fillInStackTrace() {
            return this;
        }
    }
}
