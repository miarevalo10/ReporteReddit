package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;

public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean f14827a;
    private transient Converter<B, A> f14828b;

    private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        final Converter<A, B> f18408a;

        public final int hashCode() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.google.common.base.Converter.ReverseConverter.hashCode():int
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 6 more
*/
            /*
            // Can't load method instructions.
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Converter.ReverseConverter.hashCode():int");
        }

        ReverseConverter(Converter<A, B> converter) {
            this.f18408a = converter;
        }

        protected final A mo3583a(B b) {
            throw new AssertionError();
        }

        protected final B mo3584b(A a) {
            throw new AssertionError();
        }

        final A mo3585d(B b) {
            return this.f18408a.mo3586e(b);
        }

        final B mo3586e(A a) {
            return this.f18408a.mo3585d(a);
        }

        public final Converter<A, B> mo3582a() {
            return this.f18408a;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ReverseConverter)) {
                return null;
            }
            return this.f18408a.equals(((ReverseConverter) obj).f18408a);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f18408a);
            stringBuilder.append(".reverse()");
            return stringBuilder.toString();
        }
    }

    protected abstract B mo3583a(A a);

    protected abstract A mo3584b(B b);

    protected Converter() {
        this((byte) 0);
    }

    private Converter(byte b) {
        this.f14827a = true;
    }

    public final B m14544c(A a) {
        return mo3585d(a);
    }

    B mo3585d(A a) {
        if (!this.f14827a) {
            return mo3583a((Object) a);
        }
        if (a == null) {
            return null;
        }
        return Preconditions.m6908a(mo3583a((Object) a));
    }

    A mo3586e(B b) {
        if (!this.f14827a) {
            return mo3584b(b);
        }
        if (b == null) {
            return null;
        }
        return Preconditions.m6908a(mo3584b(b));
    }

    public final Iterable<B> m14541a(final Iterable<? extends A> iterable) {
        Preconditions.m6909a((Object) iterable, (Object) "fromIterable");
        return new Iterable<B>(this) {
            final /* synthetic */ Converter f8229b;

            class C04371 implements Iterator<B> {
                final /* synthetic */ C04381 f8226a;
                private final Iterator<? extends A> f8227b = iterable.iterator();

                C04371(C04381 c04381) {
                    this.f8226a = c04381;
                }

                public boolean hasNext() {
                    return this.f8227b.hasNext();
                }

                public B next() {
                    return this.f8226a.f8229b.mo3585d(this.f8227b.next());
                }

                public void remove() {
                    this.f8227b.remove();
                }
            }

            public Iterator<B> iterator() {
                return new C04371(this);
            }
        };
    }

    public Converter<B, A> mo3582a() {
        Converter<B, A> converter = this.f14828b;
        if (converter != null) {
            return converter;
        }
        converter = new ReverseConverter(this);
        this.f14828b = converter;
        return converter;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Deprecated
    public final B apply(A a) {
        return mo3585d(a);
    }
}
