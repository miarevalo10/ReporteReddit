package com.google.common.collect;

public final class Multimaps {
    static boolean m7236a(Multimap<?, ?> multimap, Object obj) {
        if (obj == multimap) {
            return true;
        }
        if (!(obj instanceof Multimap)) {
            return null;
        }
        return multimap.mo2388f().equals(((Multimap) obj).mo2388f());
    }
}
