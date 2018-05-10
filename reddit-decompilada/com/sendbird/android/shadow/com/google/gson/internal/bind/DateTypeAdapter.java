package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.TypeAdapter;
import com.sendbird.android.shadow.com.google.gson.TypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory f30288a = new C24441();
    private final DateFormat f30289b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat f30290c = DateFormat.getDateTimeInstance(2, 2);

    static class C24441 implements TypeAdapterFactory {
        C24441() {
        }

        public final <T> TypeAdapter<T> mo5250a(Gson gson, TypeToken<T> typeToken) {
            return typeToken.f22996a == Date.class ? new DateTypeAdapter() : null;
        }
    }

    private synchronized java.util.Date m31177a(java.lang.String r3) {
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
        r0 = r2.f30290c;	 Catch:{ ParseException -> 0x000b }
        r0 = r0.parse(r3);	 Catch:{ ParseException -> 0x000b }
        monitor-exit(r2);
        return r0;
    L_0x0009:
        r3 = move-exception;
        goto L_0x0026;
    L_0x000b:
        r0 = r2.f30289b;	 Catch:{ ParseException -> 0x0013 }
        r0 = r0.parse(r3);	 Catch:{ ParseException -> 0x0013 }
        monitor-exit(r2);
        return r0;
    L_0x0013:
        r0 = new java.text.ParsePosition;	 Catch:{ ParseException -> 0x001f }
        r1 = 0;	 Catch:{ ParseException -> 0x001f }
        r0.<init>(r1);	 Catch:{ ParseException -> 0x001f }
        r0 = com.sendbird.android.shadow.com.google.gson.internal.bind.util.ISO8601Utils.m25139a(r3, r0);	 Catch:{ ParseException -> 0x001f }
        monitor-exit(r2);
        return r0;
    L_0x001f:
        r0 = move-exception;
        r1 = new com.sendbird.android.shadow.com.google.gson.JsonSyntaxException;	 Catch:{ all -> 0x0009 }
        r1.<init>(r3, r0);	 Catch:{ all -> 0x0009 }
        throw r1;	 Catch:{ all -> 0x0009 }
    L_0x0026:
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.com.google.gson.internal.bind.DateTypeAdapter.a(java.lang.String):java.util.Date");
    }

    private synchronized void m31178a(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.mo5281e();
        } else {
            jsonWriter.mo5277b(this.f30289b.format(date));
        }
    }

    public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo5258f() != JsonToken.NULL) {
            return m31177a(jsonReader.mo5261i());
        }
        jsonReader.mo5263k();
        return null;
    }
}
