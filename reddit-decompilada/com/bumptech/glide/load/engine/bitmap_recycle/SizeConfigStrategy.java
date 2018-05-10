package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.RequiresApi;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

@RequiresApi(19)
public class SizeConfigStrategy implements LruPoolStrategy {
    private static final Config[] f12494a = new Config[]{Config.ARGB_8888, null};
    private static final Config[] f12495b = new Config[]{Config.RGB_565};
    private static final Config[] f12496c = new Config[]{Config.ARGB_4444};
    private static final Config[] f12497d = new Config[]{Config.ALPHA_8};
    private final KeyPool f12498e = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> f12499f = new GroupedLinkedMap();
    private final Map<Config, NavigableMap<Integer, Integer>> f12500g = new HashMap();

    static /* synthetic */ class C02741 {
        static final /* synthetic */ int[] f3449a = new int[Config.values().length];

        static {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = android.graphics.Bitmap.Config.values();
            r0 = r0.length;
            r0 = new int[r0];
            f3449a = r0;
            r0 = f3449a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f3449a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.graphics.Bitmap.Config.RGB_565;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f3449a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = android.graphics.Bitmap.Config.ARGB_4444;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = f3449a;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = android.graphics.Bitmap.Config.ALPHA_8;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.1.<clinit>():void");
        }
    }

    static final class Key implements Poolable {
        int f12491a;
        Config f12492b;
        private final KeyPool f12493c;

        public Key(KeyPool keyPool) {
            this.f12493c = keyPool;
        }

        public final void mo929a() {
            this.f12493c.m2945a(this);
        }

        public final String toString() {
            return SizeConfigStrategy.m11413a(this.f12491a, this.f12492b);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.f12491a != key.f12491a || Util.m3232a(this.f12492b, key.f12492b) == null) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (31 * this.f12491a) + (this.f12492b != null ? this.f12492b.hashCode() : 0);
        }
    }

    static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        public final Key m11412a(int i, Config config) {
            Key key = (Key) m2946b();
            key.f12491a = i;
            key.f12492b = config;
            return key;
        }

        protected final /* synthetic */ Poolable mo930a() {
            return new Key(this);
        }
    }

    public final void mo933a(Bitmap bitmap) {
        Key a = this.f12498e.m11412a(Util.m3224a(bitmap), bitmap.getConfig());
        this.f12499f.m2958a(a, bitmap);
        bitmap = m11414a(bitmap.getConfig());
        Integer num = (Integer) bitmap.get(Integer.valueOf(a.f12491a));
        Integer valueOf = Integer.valueOf(a.f12491a);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        bitmap.put(valueOf, Integer.valueOf(i));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap mo932a(int r10, int r11, android.graphics.Bitmap.Config r12) {
        /*
        r9 = this;
        r0 = com.bumptech.glide.util.Util.m3223a(r10, r11, r12);
        r1 = r9.f12498e;
        r1 = r1.m11412a(r0, r12);
        r2 = com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.C02741.f3449a;
        r3 = r12.ordinal();
        r2 = r2[r3];
        r3 = 0;
        switch(r2) {
            case 1: goto L_0x0025;
            case 2: goto L_0x0022;
            case 3: goto L_0x001f;
            case 4: goto L_0x001c;
            default: goto L_0x0016;
        };
    L_0x0016:
        r2 = 1;
        r2 = new android.graphics.Bitmap.Config[r2];
        r2[r3] = r12;
        goto L_0x0027;
    L_0x001c:
        r2 = f12497d;
        goto L_0x0027;
    L_0x001f:
        r2 = f12496c;
        goto L_0x0027;
    L_0x0022:
        r2 = f12495b;
        goto L_0x0027;
    L_0x0025:
        r2 = f12494a;
    L_0x0027:
        r4 = r2.length;
    L_0x0028:
        if (r3 >= r4) goto L_0x0068;
    L_0x002a:
        r5 = r2[r3];
        r6 = r9.m11414a(r5);
        r7 = java.lang.Integer.valueOf(r0);
        r6 = r6.ceilingKey(r7);
        r6 = (java.lang.Integer) r6;
        if (r6 == 0) goto L_0x0065;
    L_0x003c:
        r7 = r6.intValue();
        r8 = r0 * 8;
        if (r7 > r8) goto L_0x0065;
    L_0x0044:
        r2 = r6.intValue();
        if (r2 != r0) goto L_0x0055;
    L_0x004a:
        if (r5 != 0) goto L_0x004f;
    L_0x004c:
        if (r12 == 0) goto L_0x0068;
    L_0x004e:
        goto L_0x0055;
    L_0x004f:
        r12 = r5.equals(r12);
        if (r12 != 0) goto L_0x0068;
    L_0x0055:
        r12 = r9.f12498e;
        r12.m2945a(r1);
        r12 = r9.f12498e;
        r0 = r6.intValue();
        r1 = r12.m11412a(r0, r5);
        goto L_0x0068;
    L_0x0065:
        r3 = r3 + 1;
        goto L_0x0028;
    L_0x0068:
        r12 = r9.f12499f;
        r12 = r12.m2957a(r1);
        r12 = (android.graphics.Bitmap) r12;
        if (r12 == 0) goto L_0x008b;
    L_0x0072:
        r0 = r1.f12491a;
        r0 = java.lang.Integer.valueOf(r0);
        r9.m11415a(r0, r12);
        r0 = r12.getConfig();
        if (r0 == 0) goto L_0x0086;
    L_0x0081:
        r0 = r12.getConfig();
        goto L_0x0088;
    L_0x0086:
        r0 = android.graphics.Bitmap.Config.ARGB_8888;
    L_0x0088:
        r12.reconfigure(r10, r11, r0);
    L_0x008b:
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.a(int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap");
    }

    public final Bitmap mo931a() {
        Bitmap bitmap = (Bitmap) this.f12499f.m2956a();
        if (bitmap != null) {
            m11415a(Integer.valueOf(Util.m3224a(bitmap)), bitmap);
        }
        return bitmap;
    }

    private void m11415a(Integer num, Bitmap bitmap) {
        NavigableMap a = m11414a(bitmap.getConfig());
        Integer num2 = (Integer) a.get(num);
        if (num2 == null) {
            StringBuilder stringBuilder = new StringBuilder("Tried to decrement empty size, size: ");
            stringBuilder.append(num);
            stringBuilder.append(", removed: ");
            stringBuilder.append(mo935b(bitmap));
            stringBuilder.append(", this: ");
            stringBuilder.append(this);
            throw new NullPointerException(stringBuilder.toString());
        } else if (num2.intValue() == 1) {
            a.remove(num);
        } else {
            a.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> m11414a(Config config) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f12500g.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        NavigableMap treeMap = new TreeMap();
        this.f12500g.put(config, treeMap);
        return treeMap;
    }

    public final String mo935b(Bitmap bitmap) {
        return m11413a(Util.m3224a(bitmap), bitmap.getConfig());
    }

    public final String mo934b(int i, int i2, Config config) {
        return m11413a(Util.m3223a(i, i2, config), config);
    }

    public final int mo936c(Bitmap bitmap) {
        return Util.m3224a(bitmap);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SizeConfigStrategy{groupedMap=");
        stringBuilder.append(this.f12499f);
        stringBuilder.append(", sortedSizes=(");
        for (Entry entry : this.f12500g.entrySet()) {
            stringBuilder.append(entry.getKey());
            stringBuilder.append('[');
            stringBuilder.append(entry.getValue());
            stringBuilder.append("], ");
        }
        if (!this.f12500g.isEmpty()) {
            stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
        }
        stringBuilder.append(")}");
        return stringBuilder.toString();
    }

    static String m11413a(int i, Config config) {
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(i);
        stringBuilder.append("](");
        stringBuilder.append(config);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
