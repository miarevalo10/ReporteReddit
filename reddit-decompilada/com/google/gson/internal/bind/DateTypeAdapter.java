package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory f15044a = new C12361();
    private final DateFormat f15045b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat f15046c = DateFormat.getDateTimeInstance(2, 2);

    static class C12361 implements TypeAdapterFactory {
        C12361() {
        }

        public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
            return typeToken.f8834a == Date.class ? new DateTypeAdapter() : null;
        }
    }

    private synchronized java.util.Date m14980a(java.lang.String r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f15046c;	 Catch:{ ParseException -> 0x000b }
        r0 = r0.parse(r3);	 Catch:{ ParseException -> 0x000b }
        monitor-exit(r2);
        return r0;
    L_0x0009:
        r3 = move-exception;
        goto L_0x0026;
    L_0x000b:
        r0 = r2.f15045b;	 Catch:{ ParseException -> 0x0013 }
        r0 = r0.parse(r3);	 Catch:{ ParseException -> 0x0013 }
        monitor-exit(r2);
        return r0;
    L_0x0013:
        r0 = new java.text.ParsePosition;	 Catch:{ ParseException -> 0x001f }
        r1 = 0;	 Catch:{ ParseException -> 0x001f }
        r0.<init>(r1);	 Catch:{ ParseException -> 0x001f }
        r0 = com.google.gson.internal.bind.util.ISO8601Utils.m7568a(r3, r0);	 Catch:{ ParseException -> 0x001f }
        monitor-exit(r2);
        return r0;
    L_0x001f:
        r0 = move-exception;
        r1 = new com.google.gson.JsonSyntaxException;	 Catch:{ all -> 0x0009 }
        r1.<init>(r3, r0);	 Catch:{ all -> 0x0009 }
        throw r1;	 Catch:{ all -> 0x0009 }
    L_0x0026:
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.DateTypeAdapter.a(java.lang.String):java.util.Date");
    }

    private synchronized void m14981a(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.mo2499f();
        } else {
            jsonWriter.mo2494b(this.f15045b.format(date));
        }
    }

    public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo2475f() != JsonToken.NULL) {
            return m14980a(jsonReader.mo2478i());
        }
        jsonReader.mo2480k();
        return null;
    }
}
