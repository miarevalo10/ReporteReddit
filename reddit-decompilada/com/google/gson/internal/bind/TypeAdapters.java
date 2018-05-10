package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class TypeAdapters {
    public static final TypeAdapter<String> f8781A = new TypeAdapter<String>() {
        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo2494b((String) obj);
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            JsonToken f = jsonReader.mo2475f();
            if (f == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            } else if (f == JsonToken.BOOLEAN) {
                return Boolean.toString(jsonReader.mo2479j());
            } else {
                return jsonReader.mo2478i();
            }
        }
    };
    public static final TypeAdapter<BigDecimal> f8782B = new TypeAdapter<BigDecimal>() {
        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            return AnonymousClass17.m15071b(jsonReader);
        }

        public final /* bridge */ /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo2490a((BigDecimal) obj);
        }

        private static BigDecimal m15071b(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            }
            try {
                return new BigDecimal(jsonReader.mo2478i());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
    };
    public static final TypeAdapter<BigInteger> f8783C = new TypeAdapter<BigInteger>() {
        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            return AnonymousClass18.m15074b(jsonReader);
        }

        public final /* bridge */ /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo2490a((BigInteger) obj);
        }

        private static BigInteger m15074b(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            }
            try {
                return new BigInteger(jsonReader.mo2478i());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
    };
    public static final TypeAdapterFactory f8784D = m7563a(String.class, f8781A);
    public static final TypeAdapter<StringBuilder> f8785E = new TypeAdapter<StringBuilder>() {
        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            StringBuilder stringBuilder = (StringBuilder) obj;
            jsonWriter.mo2494b(stringBuilder == null ? null : stringBuilder.toString());
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() != JsonToken.NULL) {
                return new StringBuilder(jsonReader.mo2478i());
            }
            jsonReader.mo2480k();
            return null;
        }
    };
    public static final TypeAdapterFactory f8786F = m7563a(StringBuilder.class, f8785E);
    public static final TypeAdapter<StringBuffer> f8787G = new TypeAdapter<StringBuffer>() {
        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            StringBuffer stringBuffer = (StringBuffer) obj;
            jsonWriter.mo2494b(stringBuffer == null ? null : stringBuffer.toString());
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() != JsonToken.NULL) {
                return new StringBuffer(jsonReader.mo2478i());
            }
            jsonReader.mo2480k();
            return null;
        }
    };
    public static final TypeAdapterFactory f8788H = m7563a(StringBuffer.class, f8787G);
    public static final TypeAdapter<URL> f8789I = new TypeAdapter<URL>() {
        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            URL url = (URL) obj;
            jsonWriter.mo2494b(url == null ? null : url.toExternalForm());
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            }
            jsonReader = jsonReader.mo2478i();
            if ("null".equals(jsonReader)) {
                return null;
            }
            return new URL(jsonReader);
        }
    };
    public static final TypeAdapterFactory f8790J = m7563a(URL.class, f8789I);
    public static final TypeAdapter<URI> f8791K = new TypeAdapter<URI>() {
        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            return AnonymousClass22.m15085b(jsonReader);
        }

        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            URI uri = (URI) obj;
            jsonWriter.mo2494b(uri == null ? null : uri.toASCIIString());
        }

        private static URI m15085b(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            }
            try {
                jsonReader = jsonReader.mo2478i();
                if ("null".equals(jsonReader)) {
                    return null;
                }
                return new URI(jsonReader);
            } catch (Throwable e) {
                throw new JsonIOException(e);
            }
        }
    };
    public static final TypeAdapterFactory f8792L = m7563a(URI.class, f8791K);
    public static final TypeAdapter<InetAddress> f8793M = new TypeAdapter<InetAddress>() {
        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            InetAddress inetAddress = (InetAddress) obj;
            jsonWriter.mo2494b(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() != JsonToken.NULL) {
                return InetAddress.getByName(jsonReader.mo2478i());
            }
            jsonReader.mo2480k();
            return null;
        }
    };
    public static final TypeAdapterFactory f8794N = m7565b(InetAddress.class, f8793M);
    public static final TypeAdapter<UUID> f8795O = new TypeAdapter<UUID>() {
        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            UUID uuid = (UUID) obj;
            jsonWriter.mo2494b(uuid == null ? null : uuid.toString());
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() != JsonToken.NULL) {
                return UUID.fromString(jsonReader.mo2478i());
            }
            jsonReader.mo2480k();
            return null;
        }
    };
    public static final TypeAdapterFactory f8796P = m7563a(UUID.class, f8795O);
    public static final TypeAdapter<Currency> f8797Q = new TypeAdapter<Currency>() {
        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo2494b(((Currency) obj).getCurrencyCode());
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            return Currency.getInstance(jsonReader.mo2478i());
        }
    }.m7508a();
    public static final TypeAdapterFactory f8798R = m7563a(Currency.class, f8797Q);
    public static final TypeAdapterFactory f8799S = new TypeAdapterFactory() {
        public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.f8834a != Timestamp.class) {
                return null;
            }
            gson = gson.m7476a(Date.class);
            return new TypeAdapter<Timestamp>(this) {
                final /* synthetic */ AnonymousClass26 f15101b;

                public final /* bridge */ /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
                    gson.mo2459a(jsonWriter, (Timestamp) obj);
                }

                public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
                    Date date = (Date) gson.mo2458a(jsonReader);
                    return date != null ? new Timestamp(date.getTime()) : null;
                }
            };
        }
    };
    public static final TypeAdapter<Calendar> f8800T = new TypeAdapter<Calendar>() {
        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            Calendar calendar = (Calendar) obj;
            if (calendar == null) {
                jsonWriter.mo2499f();
                return;
            }
            jsonWriter.mo2497d();
            jsonWriter.mo2491a("year");
            jsonWriter.mo2488a((long) calendar.get(1));
            jsonWriter.mo2491a("month");
            jsonWriter.mo2488a((long) calendar.get(2));
            jsonWriter.mo2491a("dayOfMonth");
            jsonWriter.mo2488a((long) calendar.get(5));
            jsonWriter.mo2491a("hourOfDay");
            jsonWriter.mo2488a((long) calendar.get(11));
            jsonWriter.mo2491a("minute");
            jsonWriter.mo2488a((long) calendar.get(12));
            jsonWriter.mo2491a("second");
            jsonWriter.mo2488a((long) calendar.get(13));
            jsonWriter.mo2498e();
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            }
            jsonReader.mo2471c();
            int i = 0;
            int i2 = i;
            int i3 = i2;
            int i4 = i3;
            int i5 = i4;
            int i6 = i5;
            while (jsonReader.mo2475f() != JsonToken.END_OBJECT) {
                String h = jsonReader.mo2477h();
                int n = jsonReader.mo2483n();
                if ("year".equals(h)) {
                    i = n;
                } else if ("month".equals(h)) {
                    i2 = n;
                } else if ("dayOfMonth".equals(h)) {
                    i3 = n;
                } else if ("hourOfDay".equals(h)) {
                    i4 = n;
                } else if ("minute".equals(h)) {
                    i5 = n;
                } else if ("second".equals(h)) {
                    i6 = n;
                }
            }
            jsonReader.mo2473d();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }
    };
    public static final TypeAdapterFactory f8801U;
    public static final TypeAdapter<Locale> f8802V = new TypeAdapter<Locale>() {
        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            Locale locale = (Locale) obj;
            jsonWriter.mo2494b(locale == null ? null : locale.toString());
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            String str = null;
            if (jsonReader.mo2475f() == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.mo2478i(), EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
            jsonReader = stringTokenizer.hasMoreElements() != null ? stringTokenizer.nextToken() : null;
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (stringTokenizer.hasMoreElements()) {
                str = stringTokenizer.nextToken();
            }
            if (nextToken == null && str == null) {
                return new Locale(jsonReader);
            }
            if (str == null) {
                return new Locale(jsonReader, nextToken);
            }
            return new Locale(jsonReader, nextToken, str);
        }
    };
    public static final TypeAdapterFactory f8803W = m7563a(Locale.class, f8802V);
    public static final TypeAdapter<JsonElement> f8804X = new TypeAdapter<JsonElement>() {
        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            return m15102b(jsonReader);
        }

        private JsonElement m15102b(JsonReader jsonReader) throws IOException {
            JsonElement jsonArray;
            switch (jsonReader.mo2475f()) {
                case NUMBER:
                    return new JsonPrimitive(new LazilyParsedNumber(jsonReader.mo2478i()));
                case BOOLEAN:
                    return new JsonPrimitive(Boolean.valueOf(jsonReader.mo2479j()));
                case STRING:
                    return new JsonPrimitive(jsonReader.mo2478i());
                case NULL:
                    jsonReader.mo2480k();
                    return JsonNull.f14990a;
                case BEGIN_ARRAY:
                    jsonArray = new JsonArray();
                    jsonReader.mo2469a();
                    while (jsonReader.mo2474e()) {
                        jsonArray.m14921a(m15102b(jsonReader));
                    }
                    jsonReader.mo2470b();
                    return jsonArray;
                case BEGIN_OBJECT:
                    jsonArray = new JsonObject();
                    jsonReader.mo2471c();
                    while (jsonReader.mo2474e()) {
                        jsonArray.m14930a(jsonReader.mo2477h(), m15102b(jsonReader));
                    }
                    jsonReader.mo2473d();
                    return jsonArray;
                default:
                    throw new IllegalArgumentException();
            }
        }

        private void m15101a(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
            if (jsonElement != null) {
                if (!(jsonElement instanceof JsonNull)) {
                    if (jsonElement instanceof JsonPrimitive) {
                        jsonElement = jsonElement.m7502j();
                        if (jsonElement.f14993a instanceof Number) {
                            jsonWriter.mo2490a(jsonElement.mo2460b());
                            return;
                        } else if (jsonElement.f14993a instanceof Boolean) {
                            jsonWriter.mo2492a(jsonElement.mo2465g());
                            return;
                        } else {
                            jsonWriter.mo2494b(jsonElement.mo2461c());
                            return;
                        }
                    } else if (jsonElement instanceof JsonArray) {
                        jsonWriter.mo2493b();
                        jsonElement = jsonElement.m7501i().iterator();
                        while (jsonElement.hasNext()) {
                            m15101a(jsonWriter, (JsonElement) jsonElement.next());
                        }
                        jsonWriter.mo2495c();
                        return;
                    } else if (jsonElement instanceof JsonObject) {
                        jsonWriter.mo2497d();
                        for (Entry entry : jsonElement.m7500h().f14991a.entrySet()) {
                            jsonWriter.mo2491a((String) entry.getKey());
                            m15101a(jsonWriter, (JsonElement) entry.getValue());
                        }
                        jsonWriter.mo2498e();
                        return;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Couldn't write ");
                        stringBuilder.append(jsonElement.getClass());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
            }
            jsonWriter.mo2499f();
        }
    };
    public static final TypeAdapterFactory f8805Y = m7565b(JsonElement.class, f8804X);
    public static final TypeAdapterFactory f8806Z = new TypeAdapterFactory() {
        public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
            gson = typeToken.f8834a;
            if (Enum.class.isAssignableFrom(gson) != null) {
                if (gson != Enum.class) {
                    if (gson.isEnum() == null) {
                        gson = gson.getSuperclass();
                    }
                    return new EnumTypeAdapter(gson);
                }
            }
            return null;
        }
    };
    public static final TypeAdapter<Class> f8807a = new C12411();
    public static final TypeAdapterFactory f8808b = m7563a(Class.class, f8807a);
    public static final TypeAdapter<BitSet> f8809c = new C12432();
    public static final TypeAdapterFactory f8810d = m7563a(BitSet.class, f8809c);
    public static final TypeAdapter<Boolean> f8811e = new C12453();
    public static final TypeAdapter<Boolean> f8812f = new C12464();
    public static final TypeAdapterFactory f8813g = m7564a(Boolean.TYPE, Boolean.class, f8811e);
    public static final TypeAdapter<Number> f8814h = new C12475();
    public static final TypeAdapterFactory f8815i = m7564a(Byte.TYPE, Byte.class, f8814h);
    public static final TypeAdapter<Number> f8816j = new C12486();
    public static final TypeAdapterFactory f8817k = m7564a(Short.TYPE, Short.class, f8816j);
    public static final TypeAdapter<Number> f8818l = new C12497();
    public static final TypeAdapterFactory f8819m = m7564a(Integer.TYPE, Integer.class, f8818l);
    public static final TypeAdapter<AtomicInteger> f8820n = new C12508().m7508a();
    public static final TypeAdapterFactory f8821o = m7563a(AtomicInteger.class, f8820n);
    public static final TypeAdapter<AtomicBoolean> f8822p = new C12519().m7508a();
    public static final TypeAdapterFactory f8823q = m7563a(AtomicBoolean.class, f8822p);
    public static final TypeAdapter<AtomicIntegerArray> f8824r = new TypeAdapter<AtomicIntegerArray>() {
        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            return AnonymousClass10.m15055b(jsonReader);
        }

        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
            jsonWriter.mo2493b();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.mo2488a((long) atomicIntegerArray.get(i));
            }
            jsonWriter.mo2495c();
        }

        private static AtomicIntegerArray m15055b(JsonReader jsonReader) throws IOException {
            List arrayList = new ArrayList();
            jsonReader.mo2469a();
            while (jsonReader.mo2474e()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.mo2483n()));
                } catch (Throwable e) {
                    throw new JsonSyntaxException(e);
                }
            }
            jsonReader.mo2470b();
            jsonReader = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(jsonReader);
            for (int i = 0; i < jsonReader; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }
    }.m7508a();
    public static final TypeAdapterFactory f8825s = m7563a(AtomicIntegerArray.class, f8824r);
    public static final TypeAdapter<Number> f8826t = new TypeAdapter<Number>() {
        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            return AnonymousClass11.m15058b(jsonReader);
        }

        public final /* bridge */ /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo2490a((Number) obj);
        }

        private static Number m15058b(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.mo2482m());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
    };
    public static final TypeAdapter<Number> f8827u = new TypeAdapter<Number>() {
        public final /* bridge */ /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo2490a((Number) obj);
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.mo2481l());
            }
            jsonReader.mo2480k();
            return null;
        }
    };
    public static final TypeAdapter<Number> f8828v = new TypeAdapter<Number>() {
        public final /* bridge */ /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo2490a((Number) obj);
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.mo2481l());
            }
            jsonReader.mo2480k();
            return null;
        }
    };
    public static final TypeAdapter<Number> f8829w = new TypeAdapter<Number>() {
        public final /* bridge */ /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo2490a((Number) obj);
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            JsonToken f = jsonReader.mo2475f();
            int i = AnonymousClass36.f8780a[f.ordinal()];
            if (i == 1) {
                return new LazilyParsedNumber(jsonReader.mo2478i());
            }
            if (i != 4) {
                StringBuilder stringBuilder = new StringBuilder("Expecting number, got: ");
                stringBuilder.append(f);
                throw new JsonSyntaxException(stringBuilder.toString());
            }
            jsonReader.mo2480k();
            return null;
        }
    };
    public static final TypeAdapterFactory f8830x = m7563a(Number.class, f8829w);
    public static final TypeAdapter<Character> f8831y = new TypeAdapter<Character>() {
        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            Character ch = (Character) obj;
            jsonWriter.mo2494b(ch == null ? null : String.valueOf(ch));
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            }
            jsonReader = jsonReader.mo2478i();
            if (jsonReader.length() == 1) {
                return Character.valueOf(jsonReader.charAt(0));
            }
            StringBuilder stringBuilder = new StringBuilder("Expecting character, got: ");
            stringBuilder.append(jsonReader);
            throw new JsonSyntaxException(stringBuilder.toString());
        }
    };
    public static final TypeAdapterFactory f8832z = m7564a(Character.TYPE, Character.class, f8831y);

    static class C12411 extends TypeAdapter<Class> {
        C12411() {
        }

        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            Class cls = (Class) obj;
            if (cls == null) {
                jsonWriter.mo2499f();
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("Attempted to serialize java.lang.Class: ");
            stringBuilder.append(cls.getName());
            stringBuilder.append(". Forgot to register a type adapter?");
            throw new UnsupportedOperationException(stringBuilder.toString());
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    static class C12432 extends TypeAdapter<BitSet> {
        C12432() {
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            return C12432.m15105b(jsonReader);
        }

        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            BitSet bitSet = (BitSet) obj;
            if (bitSet == null) {
                jsonWriter.mo2499f();
                return;
            }
            jsonWriter.mo2493b();
            for (int i = 0; i < bitSet.length(); i++) {
                jsonWriter.mo2488a((long) bitSet.get(i));
            }
            jsonWriter.mo2495c();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.util.BitSet m15105b(com.google.gson.stream.JsonReader r6) throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = r6.mo2475f();
            r1 = com.google.gson.stream.JsonToken.NULL;
            if (r0 != r1) goto L_0x000d;
        L_0x0008:
            r6.mo2480k();
            r6 = 0;
            return r6;
        L_0x000d:
            r0 = new java.util.BitSet;
            r0.<init>();
            r6.mo2469a();
            r1 = r6.mo2475f();
            r2 = 0;
            r3 = r2;
        L_0x001b:
            r4 = com.google.gson.stream.JsonToken.END_ARRAY;
            if (r1 == r4) goto L_0x0077;
        L_0x001f:
            r4 = com.google.gson.internal.bind.TypeAdapters.AnonymousClass36.f8780a;
            r5 = r1.ordinal();
            r4 = r4[r5];
            r5 = 1;
            switch(r4) {
                case 1: goto L_0x0065;
                case 2: goto L_0x0060;
                case 3: goto L_0x003f;
                default: goto L_0x002b;
            };
        L_0x002b:
            r6 = new com.google.gson.JsonSyntaxException;
            r0 = new java.lang.StringBuilder;
            r2 = "Invalid bitset value type: ";
            r0.<init>(r2);
            r0.append(r1);
            r0 = r0.toString();
            r6.<init>(r0);
            throw r6;
        L_0x003f:
            r1 = r6.mo2478i();
            r4 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x004c }
            if (r4 == 0) goto L_0x004a;
        L_0x0049:
            goto L_0x006b;
        L_0x004a:
            r5 = r2;
            goto L_0x006b;
        L_0x004c:
            r6 = new com.google.gson.JsonSyntaxException;
            r0 = new java.lang.StringBuilder;
            r2 = "Error: Expecting: bitset number value (1, 0), Found: ";
            r0.<init>(r2);
            r0.append(r1);
            r0 = r0.toString();
            r6.<init>(r0);
            throw r6;
        L_0x0060:
            r5 = r6.mo2479j();
            goto L_0x006b;
        L_0x0065:
            r1 = r6.mo2483n();
            if (r1 == 0) goto L_0x004a;
        L_0x006b:
            if (r5 == 0) goto L_0x0070;
        L_0x006d:
            r0.set(r3);
        L_0x0070:
            r3 = r3 + 1;
            r1 = r6.mo2475f();
            goto L_0x001b;
        L_0x0077:
            r6.mo2470b();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.TypeAdapters.2.b(com.google.gson.stream.JsonReader):java.util.BitSet");
        }
    }

    static class C12453 extends TypeAdapter<Boolean> {
        C12453() {
        }

        public final /* bridge */ /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo2489a((Boolean) obj);
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            } else if (jsonReader.mo2475f() == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(jsonReader.mo2478i()));
            } else {
                return Boolean.valueOf(jsonReader.mo2479j());
            }
        }
    }

    static class C12464 extends TypeAdapter<Boolean> {
        C12464() {
        }

        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            Boolean bool = (Boolean) obj;
            jsonWriter.mo2494b(bool == null ? "null" : bool.toString());
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() != JsonToken.NULL) {
                return Boolean.valueOf(jsonReader.mo2478i());
            }
            jsonReader.mo2480k();
            return null;
        }
    }

    static class C12475 extends TypeAdapter<Number> {
        C12475() {
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            return C12475.m15120b(jsonReader);
        }

        public final /* bridge */ /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo2490a((Number) obj);
        }

        private static Number m15120b(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            }
            try {
                return Byte.valueOf((byte) jsonReader.mo2483n());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
    }

    static class C12486 extends TypeAdapter<Number> {
        C12486() {
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            return C12486.m15123b(jsonReader);
        }

        public final /* bridge */ /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo2490a((Number) obj);
        }

        private static Number m15123b(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            }
            try {
                return Short.valueOf((short) jsonReader.mo2483n());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
    }

    static class C12497 extends TypeAdapter<Number> {
        C12497() {
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            return C12497.m15126b(jsonReader);
        }

        public final /* bridge */ /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo2490a((Number) obj);
        }

        private static Number m15126b(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.mo2483n());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
    }

    static class C12508 extends TypeAdapter<AtomicInteger> {
        C12508() {
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            return C12508.m15129b(jsonReader);
        }

        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo2488a((long) ((AtomicInteger) obj).get());
        }

        private static AtomicInteger m15129b(JsonReader jsonReader) throws IOException {
            try {
                return new AtomicInteger(jsonReader.mo2483n());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
    }

    static class C12519 extends TypeAdapter<AtomicBoolean> {
        C12519() {
        }

        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo2492a(((AtomicBoolean) obj).get());
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            return new AtomicBoolean(jsonReader.mo2479j());
        }
    }

    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> f15116a = new HashMap();
        private final Map<T, String> f15117b = new HashMap();

        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            Enum enumR = (Enum) obj;
            jsonWriter.mo2494b(enumR == null ? null : (String) this.f15117b.get(enumR));
        }

        public EnumTypeAdapter(Class<T> cls) {
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    Object name = enumR.name();
                    SerializedName serializedName = (SerializedName) cls.getField(name).getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        name = serializedName.m7517a();
                        for (Object put : serializedName.m7518b()) {
                            this.f15116a.put(put, enumR);
                        }
                    }
                    this.f15116a.put(name, enumR);
                    this.f15117b.put(enumR, name);
                }
            } catch (Class<T> cls2) {
                throw new AssertionError(cls2);
            }
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() != JsonToken.NULL) {
                return (Enum) this.f15116a.get(jsonReader.mo2478i());
            }
            jsonReader.mo2480k();
            return null;
        }
    }

    static {
        final Class cls = Calendar.class;
        final Class cls2 = GregorianCalendar.class;
        final TypeAdapter typeAdapter = f8800T;
        f8801U = new TypeAdapterFactory() {
            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder("Factory[type=");
                stringBuilder.append(cls.getName());
                stringBuilder.append(Operation.PLUS);
                stringBuilder.append(cls2.getName());
                stringBuilder.append(",adapter=");
                stringBuilder.append(typeAdapter);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }

            public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
                gson = typeToken.f8834a;
                if (gson != cls) {
                    if (gson != cls2) {
                        return null;
                    }
                }
                return typeAdapter;
            }
        };
    }

    public static <TT> TypeAdapterFactory m7562a(final TypeToken<TT> typeToken, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() {
            public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
                return typeToken.equals(typeToken) != null ? typeAdapter : null;
            }
        };
    }

    public static <TT> TypeAdapterFactory m7563a(final Class<TT> cls, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() {
            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder("Factory[type=");
                stringBuilder.append(cls.getName());
                stringBuilder.append(",adapter=");
                stringBuilder.append(typeAdapter);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }

            public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
                return typeToken.f8834a == cls ? typeAdapter : null;
            }
        };
    }

    public static <TT> TypeAdapterFactory m7564a(final Class<TT> cls, final Class<TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() {
            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder("Factory[type=");
                stringBuilder.append(cls2.getName());
                stringBuilder.append(Operation.PLUS);
                stringBuilder.append(cls.getName());
                stringBuilder.append(",adapter=");
                stringBuilder.append(typeAdapter);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }

            public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
                gson = typeToken.f8834a;
                if (gson != cls) {
                    if (gson != cls2) {
                        return null;
                    }
                }
                return typeAdapter;
            }
        };
    }

    private static <T1> TypeAdapterFactory m7565b(final Class<T1> cls, final TypeAdapter<T1> typeAdapter) {
        return new TypeAdapterFactory() {
            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder("Factory[typeHierarchy=");
                stringBuilder.append(cls.getName());
                stringBuilder.append(",adapter=");
                stringBuilder.append(typeAdapter);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }

            public final <T2> TypeAdapter<T2> mo2467a(Gson gson, TypeToken<T2> typeToken) {
                gson = typeToken.f8834a;
                if (cls.isAssignableFrom(gson) == null) {
                    return null;
                }
                return new TypeAdapter<T1>(this) {
                    final /* synthetic */ AnonymousClass35 f15113b;

                    public final void mo2459a(JsonWriter jsonWriter, T1 t1) throws IOException {
                        typeAdapter.mo2459a(jsonWriter, t1);
                    }

                    public final T1 mo2458a(JsonReader jsonReader) throws IOException {
                        jsonReader = typeAdapter.mo2458a(jsonReader);
                        if (jsonReader == null || gson.isInstance(jsonReader)) {
                            return jsonReader;
                        }
                        StringBuilder stringBuilder = new StringBuilder("Expected a ");
                        stringBuilder.append(gson.getName());
                        stringBuilder.append(" but was ");
                        stringBuilder.append(jsonReader.getClass().getName());
                        throw new JsonSyntaxException(stringBuilder.toString());
                    }
                };
            }
        };
    }
}
