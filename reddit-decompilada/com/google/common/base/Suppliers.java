package com.google.common.base;

import java.io.Serializable;

public final class Suppliers {

    private static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
        final T f14837a;

        SupplierOfInstance(T t) {
            this.f14837a = t;
        }

        public final T mo2328a() {
            return this.f14837a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SupplierOfInstance)) {
                return null;
            }
            return Objects.m14557a(this.f14837a, ((SupplierOfInstance) obj).f14837a);
        }

        public int hashCode() {
            return Objects.m14556a(this.f14837a);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Suppliers.ofInstance(");
            stringBuilder.append(this.f14837a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    public static <T> Supplier<T> m6935a(T t) {
        return new SupplierOfInstance(t);
    }
}
