package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonIOException;
import com.sendbird.android.shadow.com.google.gson.JsonNull;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonPrimitive;
import com.sendbird.android.shadow.com.google.gson.JsonSyntaxException;
import com.sendbird.android.shadow.com.google.gson.TypeAdapter;
import com.sendbird.android.shadow.com.google.gson.TypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.annotations.SerializedName;
import com.sendbird.android.shadow.com.google.gson.internal.LazilyParsedNumber;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
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
    public static final TypeAdapter<String> f22943A = new TypeAdapter<String>() {
        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5277b((String) obj);
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            JsonToken f = jsonReader.mo5258f();
            if (f == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            } else if (f == JsonToken.BOOLEAN) {
                return Boolean.toString(jsonReader.mo5262j());
            } else {
                return jsonReader.mo5261i();
            }
        }
    };
    public static final TypeAdapter<BigDecimal> f22944B = new TypeAdapter<BigDecimal>() {
        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            return AnonymousClass17.m31262b(jsonReader);
        }

        public final /* bridge */ /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5273a((BigDecimal) obj);
        }

        private static BigDecimal m31262b(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            }
            try {
                return new BigDecimal(jsonReader.mo5261i());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
    };
    public static final TypeAdapter<BigInteger> f22945C = new TypeAdapter<BigInteger>() {
        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            return AnonymousClass18.m31265b(jsonReader);
        }

        public final /* bridge */ /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5273a((BigInteger) obj);
        }

        private static BigInteger m31265b(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            }
            try {
                return new BigInteger(jsonReader.mo5261i());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
    };
    public static final TypeAdapterFactory f22946D = m25134a(String.class, f22943A);
    public static final TypeAdapter<StringBuilder> f22947E = new TypeAdapter<StringBuilder>() {
        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            StringBuilder stringBuilder = (StringBuilder) obj;
            jsonWriter.mo5277b(stringBuilder == null ? null : stringBuilder.toString());
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() != JsonToken.NULL) {
                return new StringBuilder(jsonReader.mo5261i());
            }
            jsonReader.mo5263k();
            return null;
        }
    };
    public static final TypeAdapterFactory f22948F = m25134a(StringBuilder.class, f22947E);
    public static final TypeAdapter<StringBuffer> f22949G = new TypeAdapter<StringBuffer>() {
        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            StringBuffer stringBuffer = (StringBuffer) obj;
            jsonWriter.mo5277b(stringBuffer == null ? null : stringBuffer.toString());
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() != JsonToken.NULL) {
                return new StringBuffer(jsonReader.mo5261i());
            }
            jsonReader.mo5263k();
            return null;
        }
    };
    public static final TypeAdapterFactory f22950H = m25134a(StringBuffer.class, f22949G);
    public static final TypeAdapter<URL> f22951I = new TypeAdapter<URL>() {
        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            URL url = (URL) obj;
            jsonWriter.mo5277b(url == null ? null : url.toExternalForm());
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            }
            jsonReader = jsonReader.mo5261i();
            if ("null".equals(jsonReader)) {
                return null;
            }
            return new URL(jsonReader);
        }
    };
    public static final TypeAdapterFactory f22952J = m25134a(URL.class, f22951I);
    public static final TypeAdapter<URI> f22953K = new TypeAdapter<URI>() {
        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            return AnonymousClass22.m31276b(jsonReader);
        }

        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            URI uri = (URI) obj;
            jsonWriter.mo5277b(uri == null ? null : uri.toASCIIString());
        }

        private static URI m31276b(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            }
            try {
                jsonReader = jsonReader.mo5261i();
                if ("null".equals(jsonReader)) {
                    return null;
                }
                return new URI(jsonReader);
            } catch (Throwable e) {
                throw new JsonIOException(e);
            }
        }
    };
    public static final TypeAdapterFactory f22954L = m25134a(URI.class, f22953K);
    public static final TypeAdapter<InetAddress> f22955M = new TypeAdapter<InetAddress>() {
        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            InetAddress inetAddress = (InetAddress) obj;
            jsonWriter.mo5277b(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() != JsonToken.NULL) {
                return InetAddress.getByName(jsonReader.mo5261i());
            }
            jsonReader.mo5263k();
            return null;
        }
    };
    public static final TypeAdapterFactory f22956N = m25136b(InetAddress.class, f22955M);
    public static final TypeAdapter<UUID> f22957O = new TypeAdapter<UUID>() {
        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            UUID uuid = (UUID) obj;
            jsonWriter.mo5277b(uuid == null ? null : uuid.toString());
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() != JsonToken.NULL) {
                return UUID.fromString(jsonReader.mo5261i());
            }
            jsonReader.mo5263k();
            return null;
        }
    };
    public static final TypeAdapterFactory f22958P = m25134a(UUID.class, f22957O);
    public static final TypeAdapter<Currency> f22959Q = new TypeAdapter<Currency>() {
        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5277b(((Currency) obj).getCurrencyCode());
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            return Currency.getInstance(jsonReader.mo5261i());
        }
    }.m25081a();
    public static final TypeAdapterFactory f22960R = m25134a(Currency.class, f22959Q);
    public static final TypeAdapterFactory f22961S = new TypeAdapterFactory() {
        public final <T> TypeAdapter<T> mo5250a(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.f22996a != Timestamp.class) {
                return null;
            }
            gson = gson.m25063a(Date.class);
            return new TypeAdapter<Timestamp>(this) {
                final /* synthetic */ AnonymousClass26 f30339b;

                public final /* bridge */ /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
                    gson.mo5242a(jsonWriter, (Timestamp) obj);
                }

                public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
                    Date date = (Date) gson.mo5241a(jsonReader);
                    return date != null ? new Timestamp(date.getTime()) : null;
                }
            };
        }
    };
    public static final TypeAdapter<Calendar> f22962T = new TypeAdapter<Calendar>() {
        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            Calendar calendar = (Calendar) obj;
            if (calendar == null) {
                jsonWriter.mo5281e();
                return;
            }
            jsonWriter.mo5278c();
            jsonWriter.mo5274a("year");
            jsonWriter.mo5271a((long) calendar.get(1));
            jsonWriter.mo5274a("month");
            jsonWriter.mo5271a((long) calendar.get(2));
            jsonWriter.mo5274a("dayOfMonth");
            jsonWriter.mo5271a((long) calendar.get(5));
            jsonWriter.mo5274a("hourOfDay");
            jsonWriter.mo5271a((long) calendar.get(11));
            jsonWriter.mo5274a("minute");
            jsonWriter.mo5271a((long) calendar.get(12));
            jsonWriter.mo5274a("second");
            jsonWriter.mo5271a((long) calendar.get(13));
            jsonWriter.mo5280d();
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            }
            jsonReader.mo5254c();
            int i = 0;
            int i2 = i;
            int i3 = i2;
            int i4 = i3;
            int i5 = i4;
            int i6 = i5;
            while (jsonReader.mo5258f() != JsonToken.END_OBJECT) {
                String h = jsonReader.mo5260h();
                int n = jsonReader.mo5266n();
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
            jsonReader.mo5256d();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }
    };
    public static final TypeAdapterFactory f22963U;
    public static final TypeAdapter<Locale> f22964V = new TypeAdapter<Locale>() {
        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            Locale locale = (Locale) obj;
            jsonWriter.mo5277b(locale == null ? null : locale.toString());
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            String str = null;
            if (jsonReader.mo5258f() == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.mo5261i(), EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
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
    public static final TypeAdapterFactory f22965W = m25134a(Locale.class, f22964V);
    public static final TypeAdapter<JsonElement> f22966X = new TypeAdapter<JsonElement>() {
        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            return m31293b(jsonReader);
        }

        private JsonElement m31293b(JsonReader jsonReader) throws IOException {
            JsonElement jsonArray;
            switch (jsonReader.mo5258f()) {
                case NUMBER:
                    return new JsonPrimitive(new LazilyParsedNumber(jsonReader.mo5261i()));
                case BOOLEAN:
                    return new JsonPrimitive(Boolean.valueOf(jsonReader.mo5262j()));
                case STRING:
                    return new JsonPrimitive(jsonReader.mo5261i());
                case NULL:
                    jsonReader.mo5263k();
                    return JsonNull.f30234a;
                case BEGIN_ARRAY:
                    jsonArray = new JsonArray();
                    jsonReader.mo5252a();
                    while (jsonReader.mo5257e()) {
                        jsonArray.m31117a(m31293b(jsonReader));
                    }
                    jsonReader.mo5253b();
                    return jsonArray;
                case BEGIN_OBJECT:
                    jsonArray = new JsonObject();
                    jsonReader.mo5254c();
                    while (jsonReader.mo5257e()) {
                        jsonArray.m31125a(jsonReader.mo5260h(), m31293b(jsonReader));
                    }
                    jsonReader.mo5256d();
                    return jsonArray;
                default:
                    throw new IllegalArgumentException();
            }
        }

        private void m31292a(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
            if (jsonElement != null) {
                if (!(jsonElement instanceof JsonNull)) {
                    if (jsonElement instanceof JsonPrimitive) {
                        jsonElement = jsonElement.m25075j();
                        if (jsonElement.f30237a instanceof Number) {
                            jsonWriter.mo5273a(jsonElement.mo5243b());
                            return;
                        } else if (jsonElement.f30237a instanceof Boolean) {
                            jsonWriter.mo5275a(jsonElement.mo5248g());
                            return;
                        } else {
                            jsonWriter.mo5277b(jsonElement.mo5244c());
                            return;
                        }
                    } else if (jsonElement instanceof JsonArray) {
                        jsonWriter.mo5270a();
                        jsonElement = jsonElement.m25074i().iterator();
                        while (jsonElement.hasNext()) {
                            m31292a(jsonWriter, (JsonElement) jsonElement.next());
                        }
                        jsonWriter.mo5276b();
                        return;
                    } else if (jsonElement instanceof JsonObject) {
                        jsonWriter.mo5278c();
                        for (Entry entry : jsonElement.m25073h().f30235a.entrySet()) {
                            jsonWriter.mo5274a((String) entry.getKey());
                            m31292a(jsonWriter, (JsonElement) entry.getValue());
                        }
                        jsonWriter.mo5280d();
                        return;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Couldn't write ");
                        stringBuilder.append(jsonElement.getClass());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
            }
            jsonWriter.mo5281e();
        }
    };
    public static final TypeAdapterFactory f22967Y = m25136b(JsonElement.class, f22966X);
    public static final TypeAdapterFactory f22968Z = new TypeAdapterFactory() {
        public final <T> TypeAdapter<T> mo5250a(Gson gson, TypeToken<T> typeToken) {
            gson = typeToken.f22996a;
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
    public static final TypeAdapter<Class> f22969a = new C24491().m25081a();
    public static final TypeAdapterFactory f22970b = m25134a(Class.class, f22969a);
    public static final TypeAdapter<BitSet> f22971c = new C24512().m25081a();
    public static final TypeAdapterFactory f22972d = m25134a(BitSet.class, f22971c);
    public static final TypeAdapter<Boolean> f22973e = new C24533();
    public static final TypeAdapter<Boolean> f22974f = new C24544();
    public static final TypeAdapterFactory f22975g = m25135a(Boolean.TYPE, Boolean.class, f22973e);
    public static final TypeAdapter<Number> f22976h = new C24555();
    public static final TypeAdapterFactory f22977i = m25135a(Byte.TYPE, Byte.class, f22976h);
    public static final TypeAdapter<Number> f22978j = new C24566();
    public static final TypeAdapterFactory f22979k = m25135a(Short.TYPE, Short.class, f22978j);
    public static final TypeAdapter<Number> f22980l = new C24577();
    public static final TypeAdapterFactory f22981m = m25135a(Integer.TYPE, Integer.class, f22980l);
    public static final TypeAdapter<AtomicInteger> f22982n = new C24588().m25081a();
    public static final TypeAdapterFactory f22983o = m25134a(AtomicInteger.class, f22982n);
    public static final TypeAdapter<AtomicBoolean> f22984p = new C24599().m25081a();
    public static final TypeAdapterFactory f22985q = m25134a(AtomicBoolean.class, f22984p);
    public static final TypeAdapter<AtomicIntegerArray> f22986r = new TypeAdapter<AtomicIntegerArray>() {
        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            return AnonymousClass10.m31246b(jsonReader);
        }

        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
            jsonWriter.mo5270a();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.mo5271a((long) atomicIntegerArray.get(i));
            }
            jsonWriter.mo5276b();
        }

        private static AtomicIntegerArray m31246b(JsonReader jsonReader) throws IOException {
            List arrayList = new ArrayList();
            jsonReader.mo5252a();
            while (jsonReader.mo5257e()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.mo5266n()));
                } catch (Throwable e) {
                    throw new JsonSyntaxException(e);
                }
            }
            jsonReader.mo5253b();
            jsonReader = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(jsonReader);
            for (int i = 0; i < jsonReader; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }
    }.m25081a();
    public static final TypeAdapterFactory f22987s = m25134a(AtomicIntegerArray.class, f22986r);
    public static final TypeAdapter<Number> f22988t = new TypeAdapter<Number>() {
        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            return AnonymousClass11.m31249b(jsonReader);
        }

        public final /* bridge */ /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5273a((Number) obj);
        }

        private static Number m31249b(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.mo5265m());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
    };
    public static final TypeAdapter<Number> f22989u = new TypeAdapter<Number>() {
        public final /* bridge */ /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5273a((Number) obj);
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.mo5264l());
            }
            jsonReader.mo5263k();
            return null;
        }
    };
    public static final TypeAdapter<Number> f22990v = new TypeAdapter<Number>() {
        public final /* bridge */ /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5273a((Number) obj);
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.mo5264l());
            }
            jsonReader.mo5263k();
            return null;
        }
    };
    public static final TypeAdapter<Number> f22991w = new TypeAdapter<Number>() {
        public final /* bridge */ /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5273a((Number) obj);
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            JsonToken f = jsonReader.mo5258f();
            int i = AnonymousClass36.f22942a[f.ordinal()];
            if (i != 1) {
                switch (i) {
                    case 3:
                        break;
                    case 4:
                        jsonReader.mo5263k();
                        return null;
                    default:
                        StringBuilder stringBuilder = new StringBuilder("Expecting number, got: ");
                        stringBuilder.append(f);
                        throw new JsonSyntaxException(stringBuilder.toString());
                }
            }
            return new LazilyParsedNumber(jsonReader.mo5261i());
        }
    };
    public static final TypeAdapterFactory f22992x = m25134a(Number.class, f22991w);
    public static final TypeAdapter<Character> f22993y = new TypeAdapter<Character>() {
        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            Character ch = (Character) obj;
            jsonWriter.mo5277b(ch == null ? null : String.valueOf(ch));
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            }
            jsonReader = jsonReader.mo5261i();
            if (jsonReader.length() == 1) {
                return Character.valueOf(jsonReader.charAt(0));
            }
            StringBuilder stringBuilder = new StringBuilder("Expecting character, got: ");
            stringBuilder.append(jsonReader);
            throw new JsonSyntaxException(stringBuilder.toString());
        }
    };
    public static final TypeAdapterFactory f22994z = m25135a(Character.TYPE, Character.class, f22993y);

    static class C24491 extends TypeAdapter<Class> {
        C24491() {
        }

        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            Class cls = (Class) obj;
            StringBuilder stringBuilder = new StringBuilder("Attempted to serialize java.lang.Class: ");
            stringBuilder.append(cls.getName());
            stringBuilder.append(". Forgot to register a type adapter?");
            throw new UnsupportedOperationException(stringBuilder.toString());
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    static class C24512 extends TypeAdapter<BitSet> {
        C24512() {
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            return C24512.m31296b(jsonReader);
        }

        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            BitSet bitSet = (BitSet) obj;
            jsonWriter.mo5270a();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.mo5271a((long) bitSet.get(i));
            }
            jsonWriter.mo5276b();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.util.BitSet m31296b(com.sendbird.android.shadow.com.google.gson.stream.JsonReader r6) throws java.io.IOException {
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
            r0 = new java.util.BitSet;
            r0.<init>();
            r6.mo5252a();
            r1 = r6.mo5258f();
            r2 = 0;
            r3 = r2;
        L_0x000e:
            r4 = com.sendbird.android.shadow.com.google.gson.stream.JsonToken.END_ARRAY;
            if (r1 == r4) goto L_0x006a;
        L_0x0012:
            r4 = com.sendbird.android.shadow.com.google.gson.internal.bind.TypeAdapters.AnonymousClass36.f22942a;
            r5 = r1.ordinal();
            r4 = r4[r5];
            r5 = 1;
            switch(r4) {
                case 1: goto L_0x0058;
                case 2: goto L_0x0053;
                case 3: goto L_0x0032;
                default: goto L_0x001e;
            };
        L_0x001e:
            r6 = new com.sendbird.android.shadow.com.google.gson.JsonSyntaxException;
            r0 = new java.lang.StringBuilder;
            r2 = "Invalid bitset value type: ";
            r0.<init>(r2);
            r0.append(r1);
            r0 = r0.toString();
            r6.<init>(r0);
            throw r6;
        L_0x0032:
            r1 = r6.mo5261i();
            r4 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x003f }
            if (r4 == 0) goto L_0x003d;
        L_0x003c:
            goto L_0x005e;
        L_0x003d:
            r5 = r2;
            goto L_0x005e;
        L_0x003f:
            r6 = new com.sendbird.android.shadow.com.google.gson.JsonSyntaxException;
            r0 = new java.lang.StringBuilder;
            r2 = "Error: Expecting: bitset number value (1, 0), Found: ";
            r0.<init>(r2);
            r0.append(r1);
            r0 = r0.toString();
            r6.<init>(r0);
            throw r6;
        L_0x0053:
            r5 = r6.mo5262j();
            goto L_0x005e;
        L_0x0058:
            r1 = r6.mo5266n();
            if (r1 == 0) goto L_0x003d;
        L_0x005e:
            if (r5 == 0) goto L_0x0063;
        L_0x0060:
            r0.set(r3);
        L_0x0063:
            r3 = r3 + 1;
            r1 = r6.mo5258f();
            goto L_0x000e;
        L_0x006a:
            r6.mo5253b();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.com.google.gson.internal.bind.TypeAdapters.2.b(com.sendbird.android.shadow.com.google.gson.stream.JsonReader):java.util.BitSet");
        }
    }

    static class C24533 extends TypeAdapter<Boolean> {
        C24533() {
        }

        public final /* bridge */ /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5272a((Boolean) obj);
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            } else if (jsonReader.mo5258f() == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(jsonReader.mo5261i()));
            } else {
                return Boolean.valueOf(jsonReader.mo5262j());
            }
        }
    }

    static class C24544 extends TypeAdapter<Boolean> {
        C24544() {
        }

        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            Boolean bool = (Boolean) obj;
            jsonWriter.mo5277b(bool == null ? "null" : bool.toString());
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() != JsonToken.NULL) {
                return Boolean.valueOf(jsonReader.mo5261i());
            }
            jsonReader.mo5263k();
            return null;
        }
    }

    static class C24555 extends TypeAdapter<Number> {
        C24555() {
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            return C24555.m31310b(jsonReader);
        }

        public final /* bridge */ /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5273a((Number) obj);
        }

        private static Number m31310b(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            }
            try {
                return Byte.valueOf((byte) jsonReader.mo5266n());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
    }

    static class C24566 extends TypeAdapter<Number> {
        C24566() {
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            return C24566.m31313b(jsonReader);
        }

        public final /* bridge */ /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5273a((Number) obj);
        }

        private static Number m31313b(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            }
            try {
                return Short.valueOf((short) jsonReader.mo5266n());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
    }

    static class C24577 extends TypeAdapter<Number> {
        C24577() {
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            return C24577.m31316b(jsonReader);
        }

        public final /* bridge */ /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5273a((Number) obj);
        }

        private static Number m31316b(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.mo5266n());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
    }

    static class C24588 extends TypeAdapter<AtomicInteger> {
        C24588() {
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            return C24588.m31319b(jsonReader);
        }

        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5271a((long) ((AtomicInteger) obj).get());
        }

        private static AtomicInteger m31319b(JsonReader jsonReader) throws IOException {
            try {
                return new AtomicInteger(jsonReader.mo5266n());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
    }

    static class C24599 extends TypeAdapter<AtomicBoolean> {
        C24599() {
        }

        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5275a(((AtomicBoolean) obj).get());
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            return new AtomicBoolean(jsonReader.mo5262j());
        }
    }

    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> f30352a = new HashMap();
        private final Map<T, String> f30353b = new HashMap();

        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            Enum enumR = (Enum) obj;
            jsonWriter.mo5277b(enumR == null ? null : (String) this.f30353b.get(enumR));
        }

        public EnumTypeAdapter(Class<T> cls) {
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    Object name = enumR.name();
                    SerializedName serializedName = (SerializedName) cls.getField(name).getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        name = serializedName.m25089a();
                        for (Object put : serializedName.m25090b()) {
                            this.f30352a.put(put, enumR);
                        }
                    }
                    this.f30352a.put(name, enumR);
                    this.f30353b.put(enumR, name);
                }
            } catch (Class<T> cls2) {
                throw new AssertionError(cls2);
            }
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() != JsonToken.NULL) {
                return (Enum) this.f30352a.get(jsonReader.mo5261i());
            }
            jsonReader.mo5263k();
            return null;
        }
    }

    static {
        final Class cls = Calendar.class;
        final Class cls2 = GregorianCalendar.class;
        final TypeAdapter typeAdapter = f22962T;
        f22963U = new TypeAdapterFactory() {
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

            public final <T> TypeAdapter<T> mo5250a(Gson gson, TypeToken<T> typeToken) {
                gson = typeToken.f22996a;
                if (gson != cls) {
                    if (gson != cls2) {
                        return null;
                    }
                }
                return typeAdapter;
            }
        };
    }

    public static <TT> TypeAdapterFactory m25134a(final Class<TT> cls, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() {
            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder("Factory[type=");
                stringBuilder.append(cls.getName());
                stringBuilder.append(",adapter=");
                stringBuilder.append(typeAdapter);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }

            public final <T> TypeAdapter<T> mo5250a(Gson gson, TypeToken<T> typeToken) {
                return typeToken.f22996a == cls ? typeAdapter : null;
            }
        };
    }

    public static <TT> TypeAdapterFactory m25135a(final Class<TT> cls, final Class<TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
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

            public final <T> TypeAdapter<T> mo5250a(Gson gson, TypeToken<T> typeToken) {
                gson = typeToken.f22996a;
                if (gson != cls) {
                    if (gson != cls2) {
                        return null;
                    }
                }
                return typeAdapter;
            }
        };
    }

    private static <T1> TypeAdapterFactory m25136b(final Class<T1> cls, final TypeAdapter<T1> typeAdapter) {
        return new TypeAdapterFactory() {
            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder("Factory[typeHierarchy=");
                stringBuilder.append(cls.getName());
                stringBuilder.append(",adapter=");
                stringBuilder.append(typeAdapter);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }

            public final <T2> TypeAdapter<T2> mo5250a(Gson gson, TypeToken<T2> typeToken) {
                gson = typeToken.f22996a;
                if (cls.isAssignableFrom(gson) == null) {
                    return null;
                }
                return new TypeAdapter<T1>(this) {
                    final /* synthetic */ AnonymousClass35 f30349b;

                    public final void mo5242a(JsonWriter jsonWriter, T1 t1) throws IOException {
                        typeAdapter.mo5242a(jsonWriter, t1);
                    }

                    public final T1 mo5241a(JsonReader jsonReader) throws IOException {
                        jsonReader = typeAdapter.mo5241a(jsonReader);
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
