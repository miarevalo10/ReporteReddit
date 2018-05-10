package org.mp4parser.aspectj.lang;

import java.io.PrintStream;
import java.io.PrintWriter;

public class SoftException extends RuntimeException {
    private static final boolean f27181b;
    Throwable f27182a;

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "java.nio.Buffer";	 Catch:{ Throwable -> 0x0007 }
        java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0007 }
        r0 = 1;
        goto L_0x0008;
    L_0x0007:
        r0 = 0;
    L_0x0008:
        f27181b = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mp4parser.aspectj.lang.SoftException.<clinit>():void");
    }

    public Throwable getCause() {
        return this.f27182a;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        Throwable th = this.f27182a;
        if (!f27181b && th != null) {
            printStream.print("Caused by: ");
            th.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        Throwable th = this.f27182a;
        if (!f27181b && th != null) {
            printWriter.print("Caused by: ");
            th.printStackTrace(printWriter);
        }
    }
}
