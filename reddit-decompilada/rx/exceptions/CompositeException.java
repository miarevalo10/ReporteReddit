package rx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public final class CompositeException extends RuntimeException {
    public final List<Throwable> f41309a;
    private final String f41310b;
    private Throwable f41311c;

    static final class CompositeExceptionCausalChain extends RuntimeException {
        public final String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }

        CompositeExceptionCausalChain() {
        }
    }

    static abstract class PrintStreamOrWriter {
        abstract Object mo7896a();

        abstract void mo7897a(Object obj);

        PrintStreamOrWriter() {
        }
    }

    static final class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream f41667a;

        WrappedPrintStream(PrintStream printStream) {
            this.f41667a = printStream;
        }

        final Object mo7896a() {
            return this.f41667a;
        }

        final void mo7897a(Object obj) {
            this.f41667a.println(obj);
        }
    }

    static final class WrappedPrintWriter extends PrintStreamOrWriter {
        private final PrintWriter f41668a;

        WrappedPrintWriter(PrintWriter printWriter) {
            this.f41668a = printWriter;
        }

        final Object mo7896a() {
            return this.f41668a;
        }

        final void mo7897a(Object obj) {
            this.f41668a.println(obj);
        }
    }

    @Deprecated
    private CompositeException(Collection<? extends Throwable> collection) {
        Collection linkedHashSet = new LinkedHashSet();
        List arrayList = new ArrayList();
        if (collection != null) {
            for (Throwable th : collection) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).f41309a);
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        this.f41309a = Collections.unmodifiableList(arrayList);
        collection = new StringBuilder();
        collection.append(this.f41309a.size());
        collection.append(" exceptions occurred. ");
        this.f41310b = collection.toString();
    }

    public CompositeException(Collection<? extends Throwable> collection, byte b) {
        this((Collection) collection);
    }

    public CompositeException(Throwable... thArr) {
        Collection linkedHashSet = new LinkedHashSet();
        List arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            Object obj = thArr[i];
            if (obj instanceof CompositeException) {
                linkedHashSet.addAll(((CompositeException) obj).f41309a);
            } else if (obj != null) {
                linkedHashSet.add(obj);
            } else {
                linkedHashSet.add(new NullPointerException());
            }
        }
        arrayList.addAll(linkedHashSet);
        this.f41309a = Collections.unmodifiableList(arrayList);
        thArr = new StringBuilder();
        thArr.append(this.f41309a.size());
        thArr.append(" exceptions occurred. ");
        this.f41310b = thArr.toString();
    }

    public final String getMessage() {
        return this.f41310b;
    }

    public final synchronized java.lang.Throwable getCause() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r8.f41311c;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x005b;	 Catch:{ all -> 0x005f }
    L_0x0005:
        r0 = new rx.exceptions.CompositeException$CompositeExceptionCausalChain;	 Catch:{ all -> 0x005f }
        r0.<init>();	 Catch:{ all -> 0x005f }
        r1 = new java.util.HashSet;	 Catch:{ all -> 0x005f }
        r1.<init>();	 Catch:{ all -> 0x005f }
        r2 = r8.f41309a;	 Catch:{ all -> 0x005f }
        r2 = r2.iterator();	 Catch:{ all -> 0x005f }
        r3 = r0;	 Catch:{ all -> 0x005f }
    L_0x0016:
        r4 = r2.hasNext();	 Catch:{ all -> 0x005f }
        if (r4 == 0) goto L_0x0059;	 Catch:{ all -> 0x005f }
    L_0x001c:
        r4 = r2.next();	 Catch:{ all -> 0x005f }
        r4 = (java.lang.Throwable) r4;	 Catch:{ all -> 0x005f }
        r5 = r1.contains(r4);	 Catch:{ all -> 0x005f }
        if (r5 != 0) goto L_0x0016;	 Catch:{ all -> 0x005f }
    L_0x0028:
        r1.add(r4);	 Catch:{ all -> 0x005f }
        r5 = m43426a(r4);	 Catch:{ all -> 0x005f }
        r5 = r5.iterator();	 Catch:{ all -> 0x005f }
    L_0x0033:
        r6 = r5.hasNext();	 Catch:{ all -> 0x005f }
        if (r6 == 0) goto L_0x0051;	 Catch:{ all -> 0x005f }
    L_0x0039:
        r6 = r5.next();	 Catch:{ all -> 0x005f }
        r6 = (java.lang.Throwable) r6;	 Catch:{ all -> 0x005f }
        r7 = r1.contains(r6);	 Catch:{ all -> 0x005f }
        if (r7 == 0) goto L_0x004d;	 Catch:{ all -> 0x005f }
    L_0x0045:
        r4 = new java.lang.RuntimeException;	 Catch:{ all -> 0x005f }
        r6 = "Duplicate found in causal chain so cropping to prevent loop ...";	 Catch:{ all -> 0x005f }
        r4.<init>(r6);	 Catch:{ all -> 0x005f }
        goto L_0x0033;	 Catch:{ all -> 0x005f }
    L_0x004d:
        r1.add(r6);	 Catch:{ all -> 0x005f }
        goto L_0x0033;
    L_0x0051:
        r3.initCause(r4);	 Catch:{ Throwable -> 0x0054 }
    L_0x0054:
        r3 = m43429b(r3);	 Catch:{ all -> 0x005f }
        goto L_0x0016;	 Catch:{ all -> 0x005f }
    L_0x0059:
        r8.f41311c = r0;	 Catch:{ all -> 0x005f }
    L_0x005b:
        r0 = r8.f41311c;	 Catch:{ all -> 0x005f }
        monitor-exit(r8);
        return r0;
    L_0x005f:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.exceptions.CompositeException.getCause():java.lang.Throwable");
    }

    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    public final void printStackTrace(PrintStream printStream) {
        m43428a(new WrappedPrintStream(printStream));
    }

    public final void printStackTrace(PrintWriter printWriter) {
        m43428a(new WrappedPrintWriter(printWriter));
    }

    private void m43428a(PrintStreamOrWriter printStreamOrWriter) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(this);
        stringBuilder.append('\n');
        for (Object obj : getStackTrace()) {
            stringBuilder.append("\tat ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
        int i = 1;
        for (Throwable th : this.f41309a) {
            stringBuilder.append("  ComposedException ");
            stringBuilder.append(i);
            stringBuilder.append(" :\n");
            m43427a(stringBuilder, th, "\t");
            i++;
        }
        synchronized (printStreamOrWriter.mo7896a()) {
            printStreamOrWriter.mo7897a(stringBuilder.toString());
        }
    }

    private static void m43427a(StringBuilder stringBuilder, Throwable th, String str) {
        while (true) {
            stringBuilder.append(str);
            stringBuilder.append(th);
            stringBuilder.append('\n');
            for (Object obj : th.getStackTrace()) {
                stringBuilder.append("\t\tat ");
                stringBuilder.append(obj);
                stringBuilder.append('\n');
            }
            if (th.getCause() != null) {
                stringBuilder.append("\tCaused by: ");
                th = th.getCause();
                str = "";
            } else {
                return;
            }
        }
    }

    private static List<Throwable> m43426a(Throwable th) {
        List<Throwable> arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null) {
            if (cause != th) {
                while (true) {
                    arrayList.add(cause);
                    th = cause.getCause();
                    if (th == null) {
                        break;
                    } else if (th == cause) {
                        break;
                    } else {
                        cause = cause.getCause();
                    }
                }
                return arrayList;
            }
        }
        return arrayList;
    }

    private static Throwable m43429b(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            if (cause != th) {
                while (true) {
                    th = cause.getCause();
                    if (th == null) {
                        break;
                    } else if (th == cause) {
                        break;
                    } else {
                        cause = cause.getCause();
                    }
                }
                return cause;
            }
        }
        return th;
    }
}
