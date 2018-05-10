package com.evernote.android.state;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public final class InjectionHelper {
    private final String mBaseKey;
    private final Map<String, Bundler<?>> mBundlers;

    public InjectionHelper(String str, Map<String, Bundler<?>> map) {
        this.mBaseKey = str;
        this.mBundlers = map;
    }

    public final <T> T getWithBundler(Bundle bundle, String str) {
        Bundler bundler = (Bundler) this.mBundlers.get(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundler.get(stringBuilder.toString(), bundle);
    }

    public final <T> void putWithBundler(Bundle bundle, String str, T t) {
        if (t != null) {
            Bundler bundler = (Bundler) this.mBundlers.get(str);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.mBaseKey);
            bundler.put(stringBuilder.toString(), t, bundle);
        }
    }

    public final boolean getBoolean(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getBoolean(stringBuilder.toString());
    }

    public final void putBoolean(Bundle bundle, String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putBoolean(stringBuilder.toString(), z);
    }

    public final Boolean getBoxedBoolean(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        if (!bundle.containsKey(stringBuilder.toString())) {
            return null;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return Boolean.valueOf(bundle.getBoolean(stringBuilder.toString()));
    }

    public final void putBoxedBoolean(Bundle bundle, String str, Boolean bool) {
        if (bool != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.mBaseKey);
            bundle.putBoolean(stringBuilder.toString(), bool.booleanValue());
        }
    }

    public final boolean[] getBooleanArray(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getBooleanArray(stringBuilder.toString());
    }

    public final void putBooleanArray(Bundle bundle, String str, boolean[] zArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putBooleanArray(stringBuilder.toString(), zArr);
    }

    public final byte getByte(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getByte(stringBuilder.toString());
    }

    public final void putByte(Bundle bundle, String str, byte b) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putByte(stringBuilder.toString(), b);
    }

    public final Byte getBoxedByte(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        if (!bundle.containsKey(stringBuilder.toString())) {
            return null;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return Byte.valueOf(bundle.getByte(stringBuilder.toString()));
    }

    public final void putBoxedByte(Bundle bundle, String str, Byte b) {
        if (b != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.mBaseKey);
            bundle.putByte(stringBuilder.toString(), b.byteValue());
        }
    }

    public final byte[] getByteArray(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getByteArray(stringBuilder.toString());
    }

    public final void putByteArray(Bundle bundle, String str, byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putByteArray(stringBuilder.toString(), bArr);
    }

    public final short getShort(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getShort(stringBuilder.toString());
    }

    public final void putShort(Bundle bundle, String str, short s) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putShort(stringBuilder.toString(), s);
    }

    public final Short getBoxedShort(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        if (!bundle.containsKey(stringBuilder.toString())) {
            return null;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return Short.valueOf(bundle.getShort(stringBuilder.toString()));
    }

    public final void putBoxedShort(Bundle bundle, String str, Short sh) {
        if (sh != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.mBaseKey);
            bundle.putShort(stringBuilder.toString(), sh.shortValue());
        }
    }

    public final short[] getShortArray(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getShortArray(stringBuilder.toString());
    }

    public final void putShortArray(Bundle bundle, String str, short[] sArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putShortArray(stringBuilder.toString(), sArr);
    }

    public final int getInt(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getInt(stringBuilder.toString());
    }

    public final void putInt(Bundle bundle, String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putInt(stringBuilder.toString(), i);
    }

    public final Integer getBoxedInt(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        if (!bundle.containsKey(stringBuilder.toString())) {
            return null;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return Integer.valueOf(bundle.getInt(stringBuilder.toString()));
    }

    public final void putBoxedInt(Bundle bundle, String str, Integer num) {
        if (num != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.mBaseKey);
            bundle.putInt(stringBuilder.toString(), num.intValue());
        }
    }

    public final int[] getIntArray(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getIntArray(stringBuilder.toString());
    }

    public final void putIntArray(Bundle bundle, String str, int[] iArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putIntArray(stringBuilder.toString(), iArr);
    }

    public final long getLong(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getLong(stringBuilder.toString());
    }

    public final void putLong(Bundle bundle, String str, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putLong(stringBuilder.toString(), j);
    }

    public final Long getBoxedLong(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        if (!bundle.containsKey(stringBuilder.toString())) {
            return null;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return Long.valueOf(bundle.getLong(stringBuilder.toString()));
    }

    public final void putBoxedLong(Bundle bundle, String str, Long l) {
        if (l != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.mBaseKey);
            bundle.putLong(stringBuilder.toString(), l.longValue());
        }
    }

    public final long[] getLongArray(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getLongArray(stringBuilder.toString());
    }

    public final void putLongArray(Bundle bundle, String str, long[] jArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putLongArray(stringBuilder.toString(), jArr);
    }

    public final float getFloat(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getFloat(stringBuilder.toString());
    }

    public final void putFloat(Bundle bundle, String str, float f) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putFloat(stringBuilder.toString(), f);
    }

    public final Float getBoxedFloat(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        if (!bundle.containsKey(stringBuilder.toString())) {
            return null;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return Float.valueOf(bundle.getFloat(stringBuilder.toString()));
    }

    public final void putBoxedFloat(Bundle bundle, String str, Float f) {
        if (f != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.mBaseKey);
            bundle.putFloat(stringBuilder.toString(), f.floatValue());
        }
    }

    public final float[] getFloatArray(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getFloatArray(stringBuilder.toString());
    }

    public final void putFloatArray(Bundle bundle, String str, float[] fArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putFloatArray(stringBuilder.toString(), fArr);
    }

    public final double getDouble(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getDouble(stringBuilder.toString());
    }

    public final void putDouble(Bundle bundle, String str, double d) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putDouble(stringBuilder.toString(), d);
    }

    public final Double getBoxedDouble(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        if (!bundle.containsKey(stringBuilder.toString())) {
            return null;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return Double.valueOf(bundle.getDouble(stringBuilder.toString()));
    }

    public final void putBoxedDouble(Bundle bundle, String str, Double d) {
        if (d != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.mBaseKey);
            bundle.putDouble(stringBuilder.toString(), d.doubleValue());
        }
    }

    public final double[] getDoubleArray(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getDoubleArray(stringBuilder.toString());
    }

    public final void putDoubleArray(Bundle bundle, String str, double[] dArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putDoubleArray(stringBuilder.toString(), dArr);
    }

    public final char getChar(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getChar(stringBuilder.toString());
    }

    public final void putChar(Bundle bundle, String str, char c) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putChar(stringBuilder.toString(), c);
    }

    public final Character getBoxedChar(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        if (!bundle.containsKey(stringBuilder.toString())) {
            return null;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return Character.valueOf(bundle.getChar(stringBuilder.toString()));
    }

    public final void putBoxedChar(Bundle bundle, String str, Character ch) {
        if (ch != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.mBaseKey);
            bundle.putChar(stringBuilder.toString(), ch.charValue());
        }
    }

    public final char[] getCharArray(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getCharArray(stringBuilder.toString());
    }

    public final void putCharArray(Bundle bundle, String str, char[] cArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putCharArray(stringBuilder.toString(), cArr);
    }

    public final String getString(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getString(stringBuilder.toString());
    }

    public final void putString(Bundle bundle, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putString(stringBuilder.toString(), str2);
    }

    public final String[] getStringArray(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getStringArray(stringBuilder.toString());
    }

    public final void putStringArray(Bundle bundle, String str, String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putStringArray(stringBuilder.toString(), strArr);
    }

    public final CharSequence getCharSequence(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getCharSequence(stringBuilder.toString());
    }

    public final void putCharSequence(Bundle bundle, String str, CharSequence charSequence) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putCharSequence(stringBuilder.toString(), charSequence);
    }

    public final CharSequence[] getCharSequenceArray(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getCharSequenceArray(stringBuilder.toString());
    }

    public final void putCharSequenceArray(Bundle bundle, String str, CharSequence[] charSequenceArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putCharSequenceArray(stringBuilder.toString(), charSequenceArr);
    }

    public final Bundle getBundle(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getBundle(stringBuilder.toString());
    }

    public final void putBundle(Bundle bundle, String str, Bundle bundle2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putBundle(stringBuilder.toString(), bundle2);
    }

    public final <T extends Parcelable> T getParcelable(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getParcelable(stringBuilder.toString());
    }

    public final void putParcelable(Bundle bundle, String str, Parcelable parcelable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putParcelable(stringBuilder.toString(), parcelable);
    }

    public final Parcelable[] getParcelableArray(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getParcelableArray(stringBuilder.toString());
    }

    public final void putParcelableArray(Bundle bundle, String str, Parcelable[] parcelableArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putParcelableArray(stringBuilder.toString(), parcelableArr);
    }

    public final <T extends Serializable> T getSerializable(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getSerializable(stringBuilder.toString());
    }

    public final void putSerializable(Bundle bundle, String str, Serializable serializable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putSerializable(stringBuilder.toString(), serializable);
    }

    public final ArrayList<Integer> getIntegerArrayList(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getIntegerArrayList(stringBuilder.toString());
    }

    public final void putIntegerArrayList(Bundle bundle, String str, ArrayList<Integer> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putIntegerArrayList(stringBuilder.toString(), arrayList);
    }

    public final ArrayList<String> getStringArrayList(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getStringArrayList(stringBuilder.toString());
    }

    public final void putStringArrayList(Bundle bundle, String str, ArrayList<String> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putStringArrayList(stringBuilder.toString(), arrayList);
    }

    public final ArrayList<CharSequence> getCharSequenceArrayList(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getCharSequenceArrayList(stringBuilder.toString());
    }

    public final void putCharSequenceArrayList(Bundle bundle, String str, ArrayList<CharSequence> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putCharSequenceArrayList(stringBuilder.toString(), arrayList);
    }

    public final <T extends Parcelable> ArrayList<T> getParcelableArrayList(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getParcelableArrayList(stringBuilder.toString());
    }

    public final void putParcelableArrayList(Bundle bundle, String str, ArrayList<? extends Parcelable> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putParcelableArrayList(stringBuilder.toString(), arrayList);
    }

    public final <T extends Parcelable> SparseArray<T> getSparseParcelableArray(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        return bundle.getSparseParcelableArray(stringBuilder.toString());
    }

    public final void putSparseParcelableArray(Bundle bundle, String str, SparseArray<? extends Parcelable> sparseArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.mBaseKey);
        bundle.putSparseParcelableArray(stringBuilder.toString(), sparseArray);
    }

    public final Parcelable getParent(Bundle bundle) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mBaseKey);
        stringBuilder.append("$$SUPER");
        return bundle.getParcelable(stringBuilder.toString());
    }

    public final Bundle putParent(Parcelable parcelable) {
        Bundle bundle = new Bundle();
        if (parcelable != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.mBaseKey);
            stringBuilder.append("$$SUPER");
            bundle.putParcelable(stringBuilder.toString(), parcelable);
        }
        return bundle;
    }
}
