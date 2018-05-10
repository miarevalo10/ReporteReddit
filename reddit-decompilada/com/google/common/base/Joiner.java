package com.google.common.base;

import java.io.IOException;
import java.util.Iterator;

public class Joiner {
    final String f8231a;

    public static Joiner m6882a(String str) {
        return new Joiner(str);
    }

    public static Joiner m6881a() {
        return new Joiner("&");
    }

    private Joiner(String str) {
        this.f8231a = (String) Preconditions.m6908a((Object) str);
    }

    private Joiner(Joiner joiner) {
        this.f8231a = joiner.f8231a;
    }

    public <A extends Appendable> A mo2325a(A a, Iterator<?> it) throws IOException {
        Preconditions.m6908a((Object) a);
        if (it.hasNext()) {
            a.append(mo2322a(it.next()));
            while (it.hasNext()) {
                a.append(this.f8231a);
                a.append(mo2322a(it.next()));
            }
        }
        return a;
    }

    private StringBuilder m6883a(StringBuilder stringBuilder, Iterator<?> it) {
        try {
            mo2325a((Appendable) stringBuilder, (Iterator) it);
            return stringBuilder;
        } catch (StringBuilder stringBuilder2) {
            throw new AssertionError(stringBuilder2);
        }
    }

    public final String m6886a(Iterable<?> iterable) {
        return m6883a(new StringBuilder(), iterable.iterator()).toString();
    }

    public Joiner mo2324b(final String str) {
        Preconditions.m6908a((Object) str);
        return new Joiner(this, this) {
            final /* synthetic */ Joiner f14832c;

            final CharSequence mo2322a(Object obj) {
                return obj == null ? str : this.f14832c.mo2322a(obj);
            }

            public final Joiner mo2324b(String str) {
                throw new UnsupportedOperationException("already specified useForNull");
            }

            public final Joiner mo2323b() {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    public Joiner mo2323b() {
        return new Joiner(this, this) {
            final /* synthetic */ Joiner f14833b;

            public final <A extends Appendable> A mo2325a(A a, Iterator<?> it) throws IOException {
                Preconditions.m6909a((Object) a, (Object) "appendable");
                Preconditions.m6909a((Object) it, (Object) "parts");
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next != null) {
                        a.append(this.f14833b.mo2322a(next));
                        break;
                    }
                }
                while (it.hasNext()) {
                    next = it.next();
                    if (next != null) {
                        a.append(this.f14833b.f8231a);
                        a.append(this.f14833b.mo2322a(next));
                    }
                }
                return a;
            }

            public final Joiner mo2324b(String str) {
                throw new UnsupportedOperationException("already specified skipNulls");
            }
        };
    }

    CharSequence mo2322a(Object obj) {
        Preconditions.m6908a(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
