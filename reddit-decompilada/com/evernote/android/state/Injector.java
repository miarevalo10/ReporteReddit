package com.evernote.android.state;

import android.os.Bundle;
import android.os.Parcelable;

public class Injector {

    public static abstract class Object<T> extends Injector {
        static final Object<?> DEFAULT = new C15991();

        static class C15991 extends Object<Object> {
            public final void restore(Object obj, Bundle bundle) {
            }

            public final void save(Object obj, Bundle bundle) {
            }

            C15991() {
            }
        }

        public abstract void restore(T t, Bundle bundle);

        public abstract void save(T t, Bundle bundle);
    }

    public static abstract class View<T> extends Injector {
        static final View<?> DEFAULT = new C16001();

        static class C16001 extends View<Object> {
            public final Parcelable restore(Object obj, Parcelable parcelable) {
                return parcelable;
            }

            public final Parcelable save(Object obj, Parcelable parcelable) {
                return parcelable;
            }

            C16001() {
            }
        }

        public abstract Parcelable restore(T t, Parcelable parcelable);

        public abstract Parcelable save(T t, Parcelable parcelable);
    }

    protected Injector() {
    }
}
