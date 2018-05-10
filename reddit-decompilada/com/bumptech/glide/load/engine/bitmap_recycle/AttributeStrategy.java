package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.util.Util;

class AttributeStrategy implements LruPoolStrategy {
    private final KeyPool f12469a = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> f12470b = new GroupedLinkedMap();

    static class Key implements Poolable {
        int f12465a;
        int f12466b;
        Config f12467c;
        private final KeyPool f12468d;

        public Key(KeyPool keyPool) {
            this.f12468d = keyPool;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.f12465a == key.f12465a && this.f12466b == key.f12466b && this.f12467c == key.f12467c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((this.f12465a * 31) + this.f12466b)) + (this.f12467c != null ? this.f12467c.hashCode() : 0);
        }

        public String toString() {
            return AttributeStrategy.m11367c(this.f12465a, this.f12466b, this.f12467c);
        }

        public final void mo929a() {
            this.f12468d.m2945a(this);
        }
    }

    static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        final Key m11365a(int i, int i2, Config config) {
            Key key = (Key) m2946b();
            key.f12465a = i;
            key.f12466b = i2;
            key.f12467c = config;
            return key;
        }

        protected final /* synthetic */ Poolable mo930a() {
            return new Key(this);
        }
    }

    AttributeStrategy() {
    }

    public final void mo933a(Bitmap bitmap) {
        this.f12470b.m2958a(this.f12469a.m11365a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public final Bitmap mo932a(int i, int i2, Config config) {
        return (Bitmap) this.f12470b.m2957a(this.f12469a.m11365a(i, i2, config));
    }

    public final Bitmap mo931a() {
        return (Bitmap) this.f12470b.m2956a();
    }

    public final String mo934b(int i, int i2, Config config) {
        return m11367c(i, i2, config);
    }

    public final int mo936c(Bitmap bitmap) {
        return Util.m3224a(bitmap);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AttributeStrategy:\n  ");
        stringBuilder.append(this.f12470b);
        return stringBuilder.toString();
    }

    static String m11367c(int i, int i2, Config config) {
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(i);
        stringBuilder.append("x");
        stringBuilder.append(i2);
        stringBuilder.append("], ");
        stringBuilder.append(config);
        return stringBuilder.toString();
    }

    public final String mo935b(Bitmap bitmap) {
        return m11367c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }
}
