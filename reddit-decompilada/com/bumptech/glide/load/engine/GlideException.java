package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GlideException extends Exception {
    private static final StackTraceElement[] f3428a = new StackTraceElement[0];
    private final List<Throwable> f3429b;
    private Key f3430c;
    private DataSource f3431d;
    private Class<?> f3432e;
    private String f3433f;

    private static final class IndentedAppendable implements Appendable {
        private final Appendable f3426a;
        private boolean f3427b = true;

        private static CharSequence m2918a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        IndentedAppendable(Appendable appendable) {
            this.f3426a = appendable;
        }

        public final Appendable append(char c) throws IOException {
            boolean z = false;
            if (this.f3427b) {
                this.f3427b = false;
                this.f3426a.append("  ");
            }
            if (c == '\n') {
                z = true;
            }
            this.f3427b = z;
            this.f3426a.append(c);
            return this;
        }

        public final Appendable append(CharSequence charSequence) throws IOException {
            charSequence = m2918a(charSequence);
            return append(charSequence, 0, charSequence.length());
        }

        public final Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
            charSequence = m2918a(charSequence);
            boolean z = false;
            if (this.f3427b) {
                this.f3427b = false;
                this.f3426a.append("  ");
            }
            if (charSequence.length() > 0 && charSequence.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.f3427b = z;
            this.f3426a.append(charSequence, i, i2);
            return this;
        }
    }

    public final Throwable fillInStackTrace() {
        return this;
    }

    public GlideException(String str) {
        this(str, Collections.emptyList());
    }

    public GlideException(String str, Throwable th) {
        this(str, Collections.singletonList(th));
    }

    public GlideException(String str, List<Throwable> list) {
        this.f3433f = str;
        setStackTrace(f3428a);
        this.f3429b = list;
    }

    final void m2923a(Key key, DataSource dataSource, Class<?> cls) {
        this.f3430c = key;
        this.f3431d = dataSource;
        this.f3432e = cls;
    }

    private List<Throwable> m2919a() {
        List arrayList = new ArrayList();
        m2922a((Throwable) this, arrayList);
        return arrayList;
    }

    public final void m2924a(String str) {
        List a = m2919a();
        int size = a.size();
        int i = 0;
        while (i < size) {
            StringBuilder stringBuilder = new StringBuilder("Root cause (");
            int i2 = i + 1;
            stringBuilder.append(i2);
            stringBuilder.append(" of ");
            stringBuilder.append(size);
            stringBuilder.append(")");
            Log.i(str, stringBuilder.toString(), (Throwable) a.get(i));
            i = i2;
        }
    }

    private void m2922a(Throwable th, List<Throwable> list) {
        if (th instanceof GlideException) {
            for (Throwable a : ((GlideException) th).f3429b) {
                m2922a(a, (List) list);
            }
            return;
        }
        list.add(th);
    }

    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    public final void printStackTrace(PrintStream printStream) {
        m2920a((Appendable) printStream);
    }

    public final void printStackTrace(PrintWriter printWriter) {
        m2920a((Appendable) printWriter);
    }

    private void m2920a(Appendable appendable) {
        m2921a((Throwable) this, appendable);
        List list = this.f3429b;
        Appendable indentedAppendable = new IndentedAppendable(appendable);
        try {
            appendable = list.size();
            int i = 0;
            while (i < appendable) {
                int i2 = i + 1;
                indentedAppendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(appendable)).append("): ");
                Throwable th = (Throwable) list.get(i);
                if (th instanceof GlideException) {
                    ((GlideException) th).m2920a(indentedAppendable);
                } else {
                    m2921a(th, indentedAppendable);
                }
                i = i2;
            }
        } catch (Appendable appendable2) {
            throw new RuntimeException(appendable2);
        }
    }

    public final String getMessage() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder(71);
        stringBuilder2.append(this.f3433f);
        if (this.f3432e != null) {
            StringBuilder stringBuilder3 = new StringBuilder(", ");
            stringBuilder3.append(this.f3432e);
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        if (this.f3431d != null) {
            stringBuilder3 = new StringBuilder(", ");
            stringBuilder3.append(this.f3431d);
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        if (this.f3430c != null) {
            stringBuilder3 = new StringBuilder(", ");
            stringBuilder3.append(this.f3430c);
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        List<Throwable> a = m2919a();
        if (a.isEmpty()) {
            return stringBuilder2.toString();
        }
        if (a.size() == 1) {
            stringBuilder2.append("\nThere was 1 cause:");
        } else {
            stringBuilder2.append("\nThere were ");
            stringBuilder2.append(a.size());
            stringBuilder2.append(" causes:");
        }
        for (Throwable th : a) {
            stringBuilder2.append('\n');
            stringBuilder2.append(th.getClass().getName());
            stringBuilder2.append('(');
            stringBuilder2.append(th.getMessage());
            stringBuilder2.append(')');
        }
        stringBuilder2.append("\n call GlideException#logRootCauses(String) for more detail");
        return stringBuilder2.toString();
    }

    private static void m2921a(java.lang.Throwable r1, java.lang.Appendable r2) {
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
        r0 = r1.getClass();	 Catch:{ IOException -> 0x0020 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0020 }
        r2 = r2.append(r0);	 Catch:{ IOException -> 0x0020 }
        r0 = ": ";	 Catch:{ IOException -> 0x0020 }
        r2 = r2.append(r0);	 Catch:{ IOException -> 0x0020 }
        r0 = r1.getMessage();	 Catch:{ IOException -> 0x0020 }
        r2 = r2.append(r0);	 Catch:{ IOException -> 0x0020 }
        r0 = 10;	 Catch:{ IOException -> 0x0020 }
        r2.append(r0);	 Catch:{ IOException -> 0x0020 }
        return;
    L_0x0020:
        r2 = new java.lang.RuntimeException;
        r2.<init>(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.GlideException.a(java.lang.Throwable, java.lang.Appendable):void");
    }
}
