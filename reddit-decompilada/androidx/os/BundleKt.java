package androidx.os;

import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"bundleOf", "Landroid/os/Bundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/Bundle;", "core-ktx_release"}, k = 2, mv = {1, 1, 9})
/* compiled from: Bundle.kt */
public final class BundleKt {
    public static final Bundle m2396a(Pair<String, ? extends Object>... pairArr) {
        Bundle bundle = new Bundle(((Object[]) pairArr).length);
        for (Pair pair : pairArr) {
            String str = (String) pair.a;
            Object obj = pair.b;
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                bundle.putByte(str, ((Number) obj).byteValue());
            } else if (obj instanceof Character) {
                bundle.putChar(str, ((Character) obj).charValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Number) obj).doubleValue());
            } else if (obj instanceof Float) {
                bundle.putFloat(str, ((Number) obj).floatValue());
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Number) obj).longValue());
            } else if (obj instanceof Short) {
                bundle.putShort(str, ((Number) obj).shortValue());
            } else if (obj instanceof Bundle) {
                bundle.putBundle(str, (Bundle) obj);
            } else if (obj instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) obj);
            } else if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) obj);
            } else if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof char[]) {
                bundle.putCharArray(str, (char[]) obj);
            } else if (obj instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) obj);
            } else if (obj instanceof float[]) {
                bundle.putFloatArray(str, (float[]) obj);
            } else if (obj instanceof int[]) {
                bundle.putIntArray(str, (int[]) obj);
            } else if (obj instanceof long[]) {
                bundle.putLongArray(str, (long[]) obj);
            } else if (obj instanceof short[]) {
                bundle.putShortArray(str, (short[]) obj);
            } else if (obj instanceof Object[]) {
                Class componentType = obj.getClass().getComponentType();
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    }
                    bundle.putParcelableArray(str, (Parcelable[]) obj);
                } else if (String.class.isAssignableFrom(componentType)) {
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    }
                    bundle.putStringArray(str, (String[]) obj);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    }
                    bundle.putCharSequenceArray(str, (CharSequence[]) obj);
                } else if (Serializable.class.isAssignableFrom(componentType)) {
                    bundle.putSerializable(str, (Serializable) obj);
                } else {
                    Intrinsics.a(componentType, "componentType");
                    pairArr = componentType.getCanonicalName();
                    r1 = new StringBuilder("Illegal value array type ");
                    r1.append(pairArr);
                    r1.append(" for key \"");
                    r1.append(str);
                    r1.append('\"');
                    throw new IllegalArgumentException(r1.toString());
                }
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            } else if (VERSION.SDK_INT >= 18 && (obj instanceof Binder)) {
                bundle.putBinder(str, (IBinder) obj);
            } else if (VERSION.SDK_INT >= 21 && (obj instanceof Size)) {
                bundle.putSize(str, (Size) obj);
            } else if (VERSION.SDK_INT < 21 || !(obj instanceof SizeF)) {
                pairArr = obj.getClass().getCanonicalName();
                r1 = new StringBuilder("Illegal value type ");
                r1.append(pairArr);
                r1.append(" for key \"");
                r1.append(str);
                r1.append('\"');
                throw new IllegalArgumentException(r1.toString());
            } else {
                bundle.putSizeF(str, (SizeF) obj);
            }
        }
        return bundle;
    }
}
