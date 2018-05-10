package com.cookpad.puree;

public class Key {
    private String f3677a;

    private Key(Class<? extends JsonConvertible> cls) {
        this.f3677a = cls.getName();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Key)) {
            return null;
        }
        return this.f3677a.equals(((Key) obj).f3677a);
    }

    public int hashCode() {
        return this.f3677a.hashCode();
    }

    public static Key m3251a(Class<? extends JsonConvertible> cls) {
        return new Key(cls);
    }
}
