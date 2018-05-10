package org.threeten.bp.zone;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class TzdbZoneRulesProvider extends ZoneRulesProvider {
    private List<String> f41553a;
    private final ConcurrentNavigableMap<String, Version> f41554b = new ConcurrentSkipListMap();
    private Set<String> f41555c = new CopyOnWriteArraySet();

    static class Version {
        private final String f41099a;
        private final String[] f41100b;
        private final short[] f41101c;
        private final AtomicReferenceArray<Object> f41102d;

        Version(String str, String[] strArr, short[] sArr, AtomicReferenceArray<Object> atomicReferenceArray) {
            this.f41102d = atomicReferenceArray;
            this.f41099a = str;
            this.f41100b = strArr;
            this.f41101c = sArr;
        }

        final ZoneRules m43216a(String str) {
            int binarySearch = Arrays.binarySearch(this.f41100b, str);
            if (binarySearch < 0) {
                return null;
            }
            try {
                short s = this.f41101c[binarySearch];
                Object obj = this.f41102d.get(s);
                if (obj instanceof byte[]) {
                    obj = Ser.m43210a(new DataInputStream(new ByteArrayInputStream((byte[]) obj)));
                    this.f41102d.set(s, obj);
                }
                return (ZoneRules) obj;
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder("Invalid binary time-zone data: TZDB:");
                stringBuilder.append(str);
                stringBuilder.append(", version: ");
                stringBuilder.append(this.f41099a);
                throw new ZoneRulesException(stringBuilder.toString(), e);
            }
        }

        public String toString() {
            return this.f41099a;
        }
    }

    public final String toString() {
        return "TZDB";
    }

    public TzdbZoneRulesProvider() {
        if (!m43654a(ZoneRulesProvider.class.getClassLoader())) {
            throw new ZoneRulesException("No time-zone rules found for 'TZDB'");
        }
    }

    public TzdbZoneRulesProvider(InputStream inputStream) {
        try {
            m43653a(inputStream);
        } catch (InputStream inputStream2) {
            throw new ZoneRulesException("Unable to load TZDB time-zone rules", inputStream2);
        }
    }

    protected final Set<String> mo7870a() {
        return new HashSet(this.f41553a);
    }

    protected final ZoneRules mo7871a(String str) {
        Jdk8Methods.m43168a((Object) str, "zoneId");
        ZoneRules a = ((Version) this.f41554b.lastEntry().getValue()).m43216a(str);
        if (a != null) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder("Unknown time-zone ID: ");
        stringBuilder.append(str);
        throw new ZoneRulesException(stringBuilder.toString());
    }

    private boolean m43654a(ClassLoader classLoader) {
        Object obj = null;
        try {
            classLoader = classLoader.getResources("org/threeten/bp/TZDB.dat");
            boolean z = false;
            while (classLoader.hasMoreElements()) {
                URL url = (URL) classLoader.nextElement();
                try {
                    z |= m43655a(url);
                    URL url2 = url;
                } catch (Exception e) {
                    classLoader = e;
                    obj = url;
                }
            }
            return z;
        } catch (Exception e2) {
            classLoader = e2;
            StringBuilder stringBuilder = new StringBuilder("Unable to load TZDB time-zone rules: ");
            stringBuilder.append(obj);
            throw new ZoneRulesException(stringBuilder.toString(), classLoader);
        }
    }

    private boolean m43655a(URL url) throws ClassNotFoundException, IOException, ZoneRulesException {
        boolean z = false;
        if (this.f41555c.add(url.toExternalForm())) {
            InputStream inputStream = null;
            try {
                InputStream openStream = url.openStream();
                try {
                    z = false | m43653a(openStream);
                    if (openStream != null) {
                        openStream.close();
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    inputStream = openStream;
                    url = th2;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw url;
                }
            } catch (Throwable th3) {
                url = th3;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw url;
            }
        }
        return z;
    }

    private boolean m43653a(InputStream inputStream) throws IOException, StreamCorruptedException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        if (dataInputStream.readByte() != 1) {
            throw new StreamCorruptedException("File format not recognised");
        }
        if ("TZDB".equals(dataInputStream.readUTF()) == null) {
            throw new StreamCorruptedException("File format not recognised");
        }
        inputStream = dataInputStream.readShort();
        String[] strArr = new String[inputStream];
        boolean z = false;
        for (int i = 0; i < inputStream; i++) {
            strArr[i] = dataInputStream.readUTF();
        }
        short readShort = dataInputStream.readShort();
        String[] strArr2 = new String[readShort];
        for (short s = (short) 0; s < readShort; s++) {
            strArr2[s] = dataInputStream.readUTF();
        }
        this.f41553a = Arrays.asList(strArr2);
        readShort = dataInputStream.readShort();
        Object[] objArr = new Object[readShort];
        for (short s2 = (short) 0; s2 < readShort; s2++) {
            byte[] bArr = new byte[dataInputStream.readShort()];
            dataInputStream.readFully(bArr);
            objArr[s2] = bArr;
        }
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(objArr);
        Iterable<Version> hashSet = new HashSet(inputStream);
        for (int i2 = 0; i2 < inputStream; i2++) {
            short readShort2 = dataInputStream.readShort();
            String[] strArr3 = new String[readShort2];
            short[] sArr = new short[readShort2];
            for (short s3 = (short) 0; s3 < readShort2; s3++) {
                strArr3[s3] = strArr2[dataInputStream.readShort()];
                sArr[s3] = dataInputStream.readShort();
            }
            hashSet.add(new Version(strArr[i2], strArr3, sArr, atomicReferenceArray));
        }
        for (Version version : hashSet) {
            Version version2 = (Version) this.f41554b.putIfAbsent(version.f41099a, version);
            if (version2 == null || version2.f41099a.equals(version.f41099a)) {
                z = true;
            } else {
                StringBuilder stringBuilder = new StringBuilder("Data already loaded for TZDB time-zone rules version: ");
                stringBuilder.append(version.f41099a);
                throw new ZoneRulesException(stringBuilder.toString());
            }
        }
        return z;
    }
}
