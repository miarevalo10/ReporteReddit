package io.reactivex.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public final class CompositeException extends RuntimeException {
    private final List<Throwable> f25004a;
    private final String f25005b;
    private Throwable f25006c;

    static final class CompositeExceptionCausalChain extends RuntimeException {
        public final String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }

        CompositeExceptionCausalChain() {
        }
    }

    static abstract class PrintStreamOrWriter {
        abstract void mo5634a(Object obj);

        PrintStreamOrWriter() {
        }
    }

    static final class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream f31093a;

        WrappedPrintStream(PrintStream printStream) {
            this.f31093a = printStream;
        }

        final void mo5634a(Object obj) {
            this.f31093a.println(obj);
        }
    }

    static final class WrappedPrintWriter extends PrintStreamOrWriter {
        private final PrintWriter f31094a;

        WrappedPrintWriter(PrintWriter printWriter) {
            this.f31094a = printWriter;
        }

        final void mo5634a(Object obj) {
            this.f31094a.println(obj);
        }
    }

    public CompositeException(Throwable... thArr) {
        this(Arrays.asList(thArr));
    }

    public CompositeException(Iterable<? extends Throwable> iterable) {
        Collection linkedHashSet = new LinkedHashSet();
        List arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).f25004a);
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty() != null) {
            throw new IllegalArgumentException("errors is empty");
        }
        arrayList.addAll(linkedHashSet);
        this.f25004a = Collections.unmodifiableList(arrayList);
        iterable = new StringBuilder();
        iterable.append(this.f25004a.size());
        iterable.append(" exceptions occurred. ");
        this.f25005b = iterable.toString();
    }

    public final String getMessage() {
        return this.f25005b;
    }

    public final synchronized java.lang.Throwable getCause() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r8.f25006c;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x005b;	 Catch:{ all -> 0x005f }
    L_0x0005:
        r0 = new io.reactivex.exceptions.CompositeException$CompositeExceptionCausalChain;	 Catch:{ all -> 0x005f }
        r0.<init>();	 Catch:{ all -> 0x005f }
        r1 = new java.util.HashSet;	 Catch:{ all -> 0x005f }
        r1.<init>();	 Catch:{ all -> 0x005f }
        r2 = r8.f25004a;	 Catch:{ all -> 0x005f }
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
        r5 = m26516a(r4);	 Catch:{ all -> 0x005f }
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
        r3 = r8.m26519b(r3);	 Catch:{ all -> 0x005f }
        goto L_0x0016;	 Catch:{ all -> 0x005f }
    L_0x0059:
        r8.f25006c = r0;	 Catch:{ all -> 0x005f }
    L_0x005b:
        r0 = r8.f25006c;	 Catch:{ all -> 0x005f }
        monitor-exit(r8);
        return r0;
    L_0x005f:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.exceptions.CompositeException.getCause():java.lang.Throwable");
    }

    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    public final void printStackTrace(PrintStream printStream) {
        m26517a(new WrappedPrintStream(printStream));
    }

    public final void printStackTrace(PrintWriter printWriter) {
        m26517a(new WrappedPrintWriter(printWriter));
    }

    private void m26517a(PrintStreamOrWriter printStreamOrWriter) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(this);
        stringBuilder.append('\n');
        for (Object obj : getStackTrace()) {
            stringBuilder.append("\tat ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
        int i = 1;
        for (Throwable th : this.f25004a) {
            stringBuilder.append("  ComposedException ");
            stringBuilder.append(i);
            stringBuilder.append(" :\n");
            m26518a(stringBuilder, th, "\t");
            i++;
        }
        printStreamOrWriter.mo5634a(stringBuilder.toString());
    }

    private static void m26518a(StringBuilder stringBuilder, Throwable th, String str) {
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

    private static List<Throwable> m26516a(Throwable th) {
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
                        cause = th;
                    }
                }
                return arrayList;
            }
        }
        return arrayList;
    }

    private Throwable m26519b(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            if (this.f25006c != cause) {
                while (true) {
                    th = cause.getCause();
                    if (th == null) {
                        break;
                    } else if (th == cause) {
                        break;
                    } else {
                        cause = th;
                    }
                }
                return cause;
            }
        }
        return th;
    }
}
