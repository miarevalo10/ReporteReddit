package com.google.common.base;

import java.util.Arrays;

public final class MoreObjects {

    public static final class ToStringHelper {
        private final String f8235a;
        private final ValueHolder f8236b;
        private ValueHolder f8237c;
        private boolean f8238d;

        private static final class ValueHolder {
            String f8232a;
            Object f8233b;
            ValueHolder f8234c;

            private ValueHolder() {
            }
        }

        private ToStringHelper(String str) {
            this.f8236b = new ValueHolder();
            this.f8237c = this.f8236b;
            this.f8238d = false;
            this.f8235a = (String) Preconditions.m6908a((Object) str);
        }

        public final ToStringHelper m6891a(String str, int i) {
            return m6893a(str, String.valueOf(i));
        }

        public final ToStringHelper m6892a(String str, long j) {
            return m6893a(str, String.valueOf(j));
        }

        public final String toString() {
            boolean z = this.f8238d;
            String str = "";
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append(this.f8235a);
            stringBuilder.append('{');
            for (ValueHolder valueHolder = this.f8236b.f8234c; valueHolder != null; valueHolder = valueHolder.f8234c) {
                Object obj = valueHolder.f8233b;
                if (!z || obj != null) {
                    stringBuilder.append(str);
                    str = ", ";
                    if (valueHolder.f8232a != null) {
                        stringBuilder.append(valueHolder.f8232a);
                        stringBuilder.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        stringBuilder.append(obj);
                    } else {
                        CharSequence deepToString = Arrays.deepToString(new Object[]{obj});
                        stringBuilder.append(deepToString, 1, deepToString.length() - 1);
                    }
                }
            }
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        private ValueHolder m6889a() {
            ValueHolder valueHolder = new ValueHolder();
            this.f8237c.f8234c = valueHolder;
            this.f8237c = valueHolder;
            return valueHolder;
        }

        public final ToStringHelper m6893a(String str, Object obj) {
            ValueHolder a = m6889a();
            a.f8233b = obj;
            a.f8232a = (String) Preconditions.m6908a((Object) str);
            return this;
        }

        public final ToStringHelper m6890a(Object obj) {
            m6889a().f8233b = obj;
            return this;
        }
    }

    public static <T> T m6895a(T t, T t2) {
        if (t != null) {
            return t;
        }
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper m6894a(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }
}
