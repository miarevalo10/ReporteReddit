package paperparcel.internal;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import paperparcel.TypeAdapter;

public final class StaticAdapters {
    public static final TypeAdapter<Integer> f41124a = new C30871();
    public static final TypeAdapter<Boolean> f41125b = new C30882();
    public static final TypeAdapter<Double> f41126c = new C30893();
    public static final TypeAdapter<Float> f41127d = new C30904();
    public static final TypeAdapter<Long> f41128e = new C30915();
    public static final TypeAdapter<Byte> f41129f = new C30926();
    public static final TypeAdapter<Character> f41130g = new C30937();
    public static final TypeAdapter<Short> f41131h = new C30948();
    public static final TypeAdapter<boolean[]> f41132i = new C30959();
    public static final TypeAdapter<Bundle> f41133j = new TypeAdapter<Bundle>() {
        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeBundle((Bundle) obj);
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return parcel.readBundle(getClass().getClassLoader());
        }
    };
    public static final TypeAdapter<byte[]> f41134k = new TypeAdapter<byte[]>() {
        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeByteArray((byte[]) obj);
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return parcel.createByteArray();
        }
    };
    public static final TypeAdapter<char[]> f41135l = new TypeAdapter<char[]>() {
        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeCharArray((char[]) obj);
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return parcel.createCharArray();
        }
    };
    public static final TypeAdapter<CharSequence> f41136m = new TypeAdapter<CharSequence>() {
        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            TextUtils.writeToParcel((CharSequence) obj, parcel, i);
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    };
    public static final TypeAdapter<double[]> f41137n = new TypeAdapter<double[]>() {
        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeDoubleArray((double[]) obj);
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return parcel.createDoubleArray();
        }
    };
    public static final TypeAdapter<float[]> f41138o = new TypeAdapter<float[]>() {
        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeFloatArray((float[]) obj);
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return parcel.createFloatArray();
        }
    };
    public static final TypeAdapter<IBinder> f41139p = new TypeAdapter<IBinder>() {
        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeStrongBinder((IBinder) obj);
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return parcel.readStrongBinder();
        }
    };
    public static final TypeAdapter<int[]> f41140q = new TypeAdapter<int[]>() {
        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeIntArray((int[]) obj);
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return parcel.createIntArray();
        }
    };
    public static final TypeAdapter<long[]> f41141r = new TypeAdapter<long[]>() {
        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeLongArray((long[]) obj);
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return parcel.createLongArray();
        }
    };
    public static final TypeAdapter<PersistableBundle> f41142s = new TypeAdapter<PersistableBundle>() {
        @TargetApi(21)
        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writePersistableBundle((PersistableBundle) obj);
        }

        @TargetApi(21)
        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return parcel.readPersistableBundle(getClass().getClassLoader());
        }
    };
    public static final TypeAdapter<short[]> f41143t = new TypeAdapter<short[]>() {
        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            short[] sArr = (short[]) obj;
            parcel.writeInt(sArr.length);
            for (short writeInt : sArr) {
                parcel.writeInt(writeInt);
            }
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            int readInt = parcel.readInt();
            Object obj = new short[readInt];
            for (int i = 0; i < readInt; i++) {
                obj[i] = (short) parcel.readInt();
            }
            return obj;
        }
    };
    public static final TypeAdapter<Size> f41144u = new TypeAdapter<Size>() {
        @TargetApi(21)
        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeSize((Size) obj);
        }

        @TargetApi(21)
        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return parcel.readSize();
        }
    };
    public static final TypeAdapter<SizeF> f41145v = new TypeAdapter<SizeF>() {
        @TargetApi(21)
        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeSizeF((SizeF) obj);
        }

        @TargetApi(21)
        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return parcel.readSizeF();
        }
    };
    public static TypeAdapter<SparseBooleanArray> f41146w = new TypeAdapter<SparseBooleanArray>() {
        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeSparseBooleanArray((SparseBooleanArray) obj);
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return parcel.readSparseBooleanArray();
        }
    };
    public static final TypeAdapter<String> f41147x = new TypeAdapter<String>() {
        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeString((String) obj);
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return parcel.readString();
        }
    };

    static class C30871 implements TypeAdapter<Integer> {
        C30871() {
        }

        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeInt(((Integer) obj).intValue());
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return Integer.valueOf(parcel.readInt());
        }
    }

    static class C30882 implements TypeAdapter<Boolean> {
        C30882() {
        }

        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeInt(((Boolean) obj).booleanValue());
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    static class C30893 implements TypeAdapter<Double> {
        C30893() {
        }

        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeDouble(((Double) obj).doubleValue());
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return Double.valueOf(parcel.readDouble());
        }
    }

    static class C30904 implements TypeAdapter<Float> {
        C30904() {
        }

        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeFloat(((Float) obj).floatValue());
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return Float.valueOf(parcel.readFloat());
        }
    }

    static class C30915 implements TypeAdapter<Long> {
        C30915() {
        }

        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeLong(((Long) obj).longValue());
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return Long.valueOf(parcel.readLong());
        }
    }

    static class C30926 implements TypeAdapter<Byte> {
        C30926() {
        }

        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeByte(((Byte) obj).byteValue());
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return Byte.valueOf(parcel.readByte());
        }
    }

    static class C30937 implements TypeAdapter<Character> {
        C30937() {
        }

        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeInt(((Character) obj).charValue());
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return Character.valueOf((char) parcel.readInt());
        }
    }

    static class C30948 implements TypeAdapter<Short> {
        C30948() {
        }

        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeInt(((Short) obj).intValue());
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return Short.valueOf((short) parcel.readInt());
        }
    }

    static class C30959 implements TypeAdapter<boolean[]> {
        C30959() {
        }

        public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
            parcel.writeBooleanArray((boolean[]) obj);
        }

        public final /* synthetic */ Object mo7872a(Parcel parcel) {
            return parcel.createBooleanArray();
        }
    }
}
