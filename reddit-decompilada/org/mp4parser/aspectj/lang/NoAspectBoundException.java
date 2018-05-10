package org.mp4parser.aspectj.lang;

public class NoAspectBoundException extends RuntimeException {
    Throwable f27180a;

    public NoAspectBoundException(String str, Throwable th) {
        if (th != null) {
            StringBuffer stringBuffer = new StringBuffer("Exception while initializing ");
            stringBuffer.append(str);
            stringBuffer.append(": ");
            stringBuffer.append(th);
            str = stringBuffer.toString();
        }
        super(str);
        this.f27180a = th;
    }

    public Throwable getCause() {
        return this.f27180a;
    }
}
