package com.nytimes.android.external.cache3;

import java.util.Arrays;

public final class MoreObjects {

    public static final class ToStringHelper {
        private final String f10205a;
        private ValueHolder f10206b;
        private ValueHolder f10207c;
        private boolean f10208d;

        private static final class ValueHolder {
            String f10202a;
            Object f10203b;
            ValueHolder f10204c;

            private ValueHolder() {
            }
        }

        private ToStringHelper(String str) {
            this.f10206b = new ValueHolder();
            this.f10207c = this.f10206b;
            this.f10208d = false;
            this.f10205a = (String) Preconditions.m8670a((Object) str);
        }

        public final ToStringHelper m8663a(String str, int i) {
            return m8665a(str, String.valueOf(i));
        }

        public final ToStringHelper m8664a(String str, long j) {
            return m8665a(str, String.valueOf(j));
        }

        public final String toString() {
            boolean z = this.f10208d;
            String str = "";
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append(this.f10205a);
            stringBuilder.append('{');
            for (ValueHolder valueHolder = this.f10206b.f10204c; valueHolder != null; valueHolder = valueHolder.f10204c) {
                Object obj = valueHolder.f10203b;
                if (!z || obj != null) {
                    stringBuilder.append(str);
                    str = ", ";
                    if (valueHolder.f10202a != null) {
                        stringBuilder.append(valueHolder.f10202a);
                        stringBuilder.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        stringBuilder.append(obj);
                    } else {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        stringBuilder.append(deepToString.substring(1, deepToString.length() - 1));
                    }
                }
            }
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        private ValueHolder m8661a() {
            ValueHolder valueHolder = new ValueHolder();
            this.f10207c.f10204c = valueHolder;
            this.f10207c = valueHolder;
            return valueHolder;
        }

        final ToStringHelper m8665a(String str, Object obj) {
            ValueHolder a = m8661a();
            a.f10203b = obj;
            a.f10202a = (String) Preconditions.m8670a((Object) str);
            return this;
        }

        public final ToStringHelper m8662a(Object obj) {
            m8661a().f10203b = obj;
            return this;
        }
    }

    public static <T> T m8667a(T t, T t2) {
        return t != null ? t : Preconditions.m8670a((Object) t2);
    }

    public static ToStringHelper m8666a(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }
}
