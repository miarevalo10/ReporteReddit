package hu.akarnokd.rxjava2.debug;

public final class RxJavaAssemblyException extends RuntimeException {
    final String f24436a = m26065a();

    private static String m26065a() {
        StringBuilder stringBuilder = new StringBuilder();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        stringBuilder.append("RxJavaAssemblyException: assembled\r\n");
        for (StackTraceElement stackTraceElement : stackTrace) {
            Object obj = 1;
            if (stackTraceElement.getLineNumber() != 1) {
                String className = stackTraceElement.getClassName();
                if (!className.contains("java.lang.Thread")) {
                    if (!(className.contains("junit.runner") || className.contains("org.junit.internal"))) {
                        if (!className.contains("junit4.runner")) {
                            if (!className.contains("java.lang.reflect")) {
                                if (!className.contains("sun.reflect")) {
                                    if (!className.contains(".RxJavaAssemblyException")) {
                                        if (!(className.contains("OnAssembly") || className.contains("RxJavaAssemblyTracking"))) {
                                            if (className.contains("RxJavaPlugins")) {
                                            }
                                            if (obj != null) {
                                                stringBuilder.append("at ");
                                                stringBuilder.append(stackTraceElement);
                                                stringBuilder.append("\r\n");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            obj = null;
            if (obj != null) {
                stringBuilder.append("at ");
                stringBuilder.append(stackTraceElement);
                stringBuilder.append("\r\n");
            }
        }
        return stringBuilder.toString();
    }

    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
