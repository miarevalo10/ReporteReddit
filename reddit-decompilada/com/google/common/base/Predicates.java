package com.google.common.base;

import java.io.Serializable;

public final class Predicates {

    private static class IsEqualToPredicate<T> implements Predicate<T>, Serializable {
        private final T f14834a;

        private IsEqualToPredicate(T t) {
            this.f14834a = t;
        }

        public final boolean mo2326a(T t) {
            return this.f14834a.equals(t);
        }

        public int hashCode() {
            return this.f14834a.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof IsEqualToPredicate)) {
                return null;
            }
            return this.f14834a.equals(((IsEqualToPredicate) obj).f14834a);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Predicates.equalTo(");
            stringBuilder.append(this.f14834a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    private static class NotPredicate<T> implements Predicate<T>, Serializable {
        final Predicate<T> f14835a;

        public int hashCode() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.google.common.base.Predicates.NotPredicate.hashCode():int
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Predicates.NotPredicate.hashCode():int");
        }

        NotPredicate(Predicate<T> predicate) {
            this.f14835a = (Predicate) Preconditions.m6908a((Object) predicate);
        }

        public final boolean mo2326a(T t) {
            return this.f14835a.mo2326a(t) == null ? true : null;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NotPredicate)) {
                return null;
            }
            return this.f14835a.equals(((NotPredicate) obj).f14835a);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Predicates.not(");
            stringBuilder.append(this.f14835a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    public static <T> Predicate<T> m6925a(Predicate<T> predicate) {
        return new NotPredicate(predicate);
    }

    public static <T> Predicate<T> m6926a(T t) {
        return new IsEqualToPredicate(t);
    }
}
