package org.parceler;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.parceler.Parcels.ParcelableFactory;
import org.parceler.converter.ArrayListParcelConverter;
import org.parceler.converter.BooleanArrayParcelConverter;
import org.parceler.converter.CharArrayParcelConverter;
import org.parceler.converter.CollectionParcelConverter;
import org.parceler.converter.HashMapParcelConverter;
import org.parceler.converter.HashSetParcelConverter;
import org.parceler.converter.LinkedHashMapParcelConverter;
import org.parceler.converter.LinkedHashSetParcelConverter;
import org.parceler.converter.LinkedListParcelConverter;
import org.parceler.converter.NullableParcelConverter;
import org.parceler.converter.SparseArrayParcelConverter;
import org.parceler.converter.TreeMapParcelConverter;
import org.parceler.converter.TreeSetParcelConverter;

final class NonParcelRepository implements Repository<ParcelableFactory> {
    private static final NonParcelRepository f33429a = new NonParcelRepository();
    private final Map<Class, ParcelableFactory> f33430b = new HashMap();

    private static class BooleanArrayParcelableFactory implements ParcelableFactory<boolean[]> {
        private BooleanArrayParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new BooleanArrayParcelable((boolean[]) obj);
        }
    }

    private static class BooleanParcelableFactory implements ParcelableFactory<Boolean> {
        private BooleanParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new BooleanParcelable(((Boolean) obj).booleanValue());
        }
    }

    private static class BundleParcelableFactory implements ParcelableFactory<Bundle> {
        private BundleParcelableFactory() {
        }

        public final /* bridge */ /* synthetic */ Parcelable mo6359a(Object obj) {
            return (Bundle) obj;
        }
    }

    private static class ByteArrayParcelableFactory implements ParcelableFactory<byte[]> {
        private ByteArrayParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new ByteArrayParcelable((byte[]) obj);
        }
    }

    private static class ByteParcelableFactory implements ParcelableFactory<Byte> {
        private ByteParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new ByteParcelable((Byte) obj);
        }
    }

    private static class CharArrayParcelableFactory implements ParcelableFactory<char[]> {
        private CharArrayParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new CharArrayParcelable((char[]) obj);
        }
    }

    private static class CharacterParcelableFactory implements ParcelableFactory<Character> {
        private CharacterParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new CharacterParcelable((Character) obj);
        }
    }

    private static class CollectionParcelableFactory implements ParcelableFactory<Collection> {
        private CollectionParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new CollectionParcelable((Collection) obj);
        }
    }

    private static class ConverterParcelable<T> implements Parcelable, ParcelWrapper<T> {
        private final T f33425a;
        private final TypeRangeParcelConverter<T, T> f33426b;

        public int describeContents() {
            return 0;
        }

        private ConverterParcelable(Parcel parcel, TypeRangeParcelConverter<T, T> typeRangeParcelConverter) {
            this(typeRangeParcelConverter.mo6361c(parcel), (TypeRangeParcelConverter) typeRangeParcelConverter);
        }

        private ConverterParcelable(T t, TypeRangeParcelConverter<T, T> typeRangeParcelConverter) {
            this.f33426b = typeRangeParcelConverter;
            this.f33425a = t;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f33426b.mo6362c(this.f33425a, parcel);
        }

        public T getParcel() {
            return this.f33425a;
        }
    }

    private static class DoubleParcelableFactory implements ParcelableFactory<Double> {
        private DoubleParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new DoubleParcelable((Double) obj);
        }
    }

    private static class FloatParcelableFactory implements ParcelableFactory<Float> {
        private FloatParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new FloatParcelable((Float) obj);
        }
    }

    private static class IBinderParcelableFactory implements ParcelableFactory<IBinder> {
        private IBinderParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new IBinderParcelable((IBinder) obj);
        }
    }

    private static class IntegerParcelableFactory implements ParcelableFactory<Integer> {
        private IntegerParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new IntegerParcelable((Integer) obj);
        }
    }

    private static class LinkedHashMapParcelableFactory implements ParcelableFactory<LinkedHashMap> {
        private LinkedHashMapParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new LinkedHashMapParcelable((LinkedHashMap) obj);
        }
    }

    private static class LinkedHashSetParcelableFactory implements ParcelableFactory<LinkedHashSet> {
        private LinkedHashSetParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new LinkedHashSetParcelable((LinkedHashSet) obj);
        }
    }

    private static class LinkedListParcelableFactory implements ParcelableFactory<LinkedList> {
        private LinkedListParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new LinkedListParcelable((LinkedList) obj);
        }
    }

    private static class ListParcelableFactory implements ParcelableFactory<List> {
        private ListParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new ListParcelable((List) obj);
        }
    }

    private static class LongParcelableFactory implements ParcelableFactory<Long> {
        private LongParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new LongParcelable((Long) obj);
        }
    }

    private static class MapParcelableFactory implements ParcelableFactory<Map> {
        private MapParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new MapParcelable((Map) obj);
        }
    }

    public static final class ParcelableParcelable implements Parcelable, ParcelWrapper<Parcelable> {
        public static final ParcelableParcelableCreator CREATOR = new ParcelableParcelableCreator();
        private Parcelable f33427a;

        private static final class ParcelableParcelableCreator implements Creator<ParcelableParcelable> {
            private ParcelableParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ParcelableParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ParcelableParcelable(parcel);
            }
        }

        public final int describeContents() {
            return 0;
        }

        private ParcelableParcelable(Parcel parcel) {
            this.f33427a = parcel.readParcelable(ParcelableParcelable.class.getClassLoader());
        }

        private ParcelableParcelable(Parcelable parcelable) {
            this.f33427a = parcelable;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f33427a, i);
        }

        public final /* bridge */ /* synthetic */ Object getParcel() {
            return this.f33427a;
        }
    }

    static class ParcelableParcelableFactory implements ParcelableFactory<Parcelable> {
        ParcelableParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new ParcelableParcelable((Parcelable) obj);
        }
    }

    private static class SetParcelableFactory implements ParcelableFactory<Set> {
        private SetParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new SetParcelable((Set) obj);
        }
    }

    private static class SparseArrayParcelableFactory implements ParcelableFactory<SparseArray> {
        private SparseArrayParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new SparseArrayParcelable((SparseArray) obj);
        }
    }

    private static class SparseBooleanArrayParcelableFactory implements ParcelableFactory<SparseBooleanArray> {
        private SparseBooleanArrayParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new SparseBooleanArrayParcelable((SparseBooleanArray) obj);
        }
    }

    public static final class StringParcelable implements Parcelable, ParcelWrapper<String> {
        public static final StringParcelableCreator CREATOR = new StringParcelableCreator();
        private String f33428a;

        private static final class StringParcelableCreator implements Creator<StringParcelable> {
            private StringParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StringParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StringParcelable(parcel);
            }
        }

        public final int describeContents() {
            return 0;
        }

        private StringParcelable(Parcel parcel) {
            this.f33428a = parcel.readString();
        }

        private StringParcelable(String str) {
            this.f33428a = str;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f33428a);
        }

        public final /* bridge */ /* synthetic */ Object getParcel() {
            return this.f33428a;
        }
    }

    private static class StringParcelableFactory implements ParcelableFactory<String> {
        private StringParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new StringParcelable((String) obj);
        }
    }

    private static class TreeMapParcelableFactory implements ParcelableFactory<Map> {
        private TreeMapParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new TreeMapParcelable((Map) obj);
        }
    }

    private static class TreeSetParcelableFactory implements ParcelableFactory<Set> {
        private TreeSetParcelableFactory() {
        }

        public final /* synthetic */ Parcelable mo6359a(Object obj) {
            return new TreeSetParcelable((Set) obj);
        }
    }

    public static final class BooleanArrayParcelable extends ConverterParcelable<boolean[]> {
        public static final BooleanArrayParcelableCreator CREATOR = new BooleanArrayParcelableCreator();
        private static final BooleanArrayParcelConverter f36237a = new BooleanArrayParcelConverter();

        private static final class BooleanArrayParcelableCreator implements Creator<BooleanArrayParcelable> {
            private BooleanArrayParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new BooleanArrayParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new BooleanArrayParcelable(parcel);
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public BooleanArrayParcelable(Parcel parcel) {
            super(parcel, f36237a);
        }

        public BooleanArrayParcelable(boolean[] zArr) {
            super((Object) zArr, f36237a);
        }
    }

    public static final class BooleanParcelable extends ConverterParcelable<Boolean> {
        public static final BooleanParcelableCreator CREATOR = new BooleanParcelableCreator();
        private static final NullableParcelConverter<Boolean> f36238a = new C30171();

        private static final class BooleanParcelableCreator implements Creator<BooleanParcelable> {
            private BooleanParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new BooleanParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new BooleanParcelable(parcel);
            }
        }

        static class C30171 extends NullableParcelConverter<Boolean> {
            C30171() {
            }

            public final /* synthetic */ void mo6867a(Object obj, Parcel parcel) {
                parcel.writeBooleanArray(new boolean[]{((Boolean) obj).booleanValue()});
            }

            public final /* synthetic */ Object mo6866a(Parcel parcel) {
                return Boolean.valueOf(parcel.createBooleanArray()[0]);
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public BooleanParcelable(Parcel parcel) {
            super(parcel, f36238a);
        }

        public BooleanParcelable(boolean z) {
            super(Boolean.valueOf(z), f36238a);
        }
    }

    public static final class ByteArrayParcelable extends ConverterParcelable<byte[]> {
        public static final ByteArrayParcelableCreator CREATOR = new ByteArrayParcelableCreator();
        private static final NullableParcelConverter<byte[]> f36239a = new C30181();

        private static final class ByteArrayParcelableCreator implements Creator<ByteArrayParcelable> {
            private ByteArrayParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ByteArrayParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ByteArrayParcelable(parcel);
            }
        }

        static class C30181 extends NullableParcelConverter<byte[]> {
            C30181() {
            }

            public final /* synthetic */ void mo6867a(Object obj, Parcel parcel) {
                parcel.writeByteArray((byte[]) obj);
            }

            public final /* synthetic */ Object mo6866a(Parcel parcel) {
                return parcel.createByteArray();
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public ByteArrayParcelable(Parcel parcel) {
            super(parcel, f36239a);
        }

        public ByteArrayParcelable(byte[] bArr) {
            super((Object) bArr, f36239a);
        }
    }

    public static final class ByteParcelable extends ConverterParcelable<Byte> {
        public static final ByteParcelableCreator CREATOR = new ByteParcelableCreator();
        private static final NullableParcelConverter<Byte> f36240a = new C30191();

        private static final class ByteParcelableCreator implements Creator<ByteParcelable> {
            private ByteParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ByteParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ByteParcelable(parcel);
            }
        }

        static class C30191 extends NullableParcelConverter<Byte> {
            C30191() {
            }

            public final /* synthetic */ void mo6867a(Object obj, Parcel parcel) {
                parcel.writeByte(((Byte) obj).byteValue());
            }

            public final /* synthetic */ Object mo6866a(Parcel parcel) {
                return Byte.valueOf(parcel.readByte());
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public ByteParcelable(Parcel parcel) {
            super(parcel, f36240a);
        }

        public ByteParcelable(Byte b) {
            super((Object) b, f36240a);
        }
    }

    public static final class CharArrayParcelable extends ConverterParcelable<char[]> {
        public static final CharArrayParcelableCreator CREATOR = new CharArrayParcelableCreator();
        private static final CharArrayParcelConverter f36241a = new CharArrayParcelConverter();

        private static final class CharArrayParcelableCreator implements Creator<CharArrayParcelable> {
            private CharArrayParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CharArrayParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CharArrayParcelable(parcel);
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public CharArrayParcelable(Parcel parcel) {
            super(parcel, f36241a);
        }

        public CharArrayParcelable(char[] cArr) {
            super((Object) cArr, f36241a);
        }
    }

    public static final class CharacterParcelable extends ConverterParcelable<Character> {
        public static final CharacterParcelableCreator CREATOR = new CharacterParcelableCreator();
        private static final NullableParcelConverter<Character> f36242a = new C30201();

        private static final class CharacterParcelableCreator implements Creator<CharacterParcelable> {
            private CharacterParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CharacterParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CharacterParcelable(parcel);
            }
        }

        static class C30201 extends NullableParcelConverter<Character> {
            C30201() {
            }

            public final /* synthetic */ void mo6867a(Object obj, Parcel parcel) {
                parcel.writeCharArray(new char[]{((Character) obj).charValue()});
            }

            public final /* synthetic */ Object mo6866a(Parcel parcel) {
                return Character.valueOf(parcel.createCharArray()[0]);
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public CharacterParcelable(Parcel parcel) {
            super(parcel, f36242a);
        }

        public CharacterParcelable(Character ch) {
            super((Object) ch, f36242a);
        }
    }

    public static final class CollectionParcelable extends ConverterParcelable<Collection> {
        public static final CollectionParcelableCreator CREATOR = new CollectionParcelableCreator();
        private static final CollectionParcelConverter f36243a = new C30211();

        private static final class CollectionParcelableCreator implements Creator<CollectionParcelable> {
            private CollectionParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CollectionParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CollectionParcelable(parcel);
            }
        }

        static class C30211 extends ArrayListParcelConverter {
            C30211() {
            }

            public final Object mo7130a(Parcel parcel) {
                return Parcels.m28673a(parcel.readParcelable(CollectionParcelable.class.getClassLoader()));
            }

            public final void mo7131a(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.m28672a(obj), 0);
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public CollectionParcelable(Parcel parcel) {
            super(parcel, f36243a);
        }

        public CollectionParcelable(Collection collection) {
            super((Object) collection, f36243a);
        }
    }

    public static final class DoubleParcelable extends ConverterParcelable<Double> {
        public static final DoubleParcelableCreator CREATOR = new DoubleParcelableCreator();
        private static final NullableParcelConverter<Double> f36244a = new C30221();

        private static final class DoubleParcelableCreator implements Creator<DoubleParcelable> {
            private DoubleParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DoubleParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DoubleParcelable(parcel);
            }
        }

        static class C30221 extends NullableParcelConverter<Double> {
            C30221() {
            }

            public final /* synthetic */ void mo6867a(Object obj, Parcel parcel) {
                parcel.writeDouble(((Double) obj).doubleValue());
            }

            public final /* synthetic */ Object mo6866a(Parcel parcel) {
                return Double.valueOf(parcel.readDouble());
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public DoubleParcelable(Parcel parcel) {
            super(parcel, f36244a);
        }

        public DoubleParcelable(Double d) {
            super((Object) d, f36244a);
        }
    }

    public static final class FloatParcelable extends ConverterParcelable<Float> {
        public static final FloatParcelableCreator CREATOR = new FloatParcelableCreator();
        private static final NullableParcelConverter<Float> f36245a = new C30231();

        private static final class FloatParcelableCreator implements Creator<FloatParcelable> {
            private FloatParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new FloatParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new FloatParcelable(parcel);
            }
        }

        static class C30231 extends NullableParcelConverter<Float> {
            C30231() {
            }

            public final /* synthetic */ void mo6867a(Object obj, Parcel parcel) {
                parcel.writeFloat(((Float) obj).floatValue());
            }

            public final /* synthetic */ Object mo6866a(Parcel parcel) {
                return Float.valueOf(parcel.readFloat());
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public FloatParcelable(Parcel parcel) {
            super(parcel, f36245a);
        }

        public FloatParcelable(Float f) {
            super((Object) f, f36245a);
        }
    }

    public static final class IBinderParcelable extends ConverterParcelable<IBinder> {
        public static final IBinderParcelableCreator CREATOR = new IBinderParcelableCreator();
        private static final NullableParcelConverter<IBinder> f36246a = new C30241();

        private static final class IBinderParcelableCreator implements Creator<IBinderParcelable> {
            private IBinderParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new IBinderParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new IBinderParcelable(parcel);
            }
        }

        static class C30241 extends NullableParcelConverter<IBinder> {
            C30241() {
            }

            public final /* synthetic */ void mo6867a(Object obj, Parcel parcel) {
                parcel.writeStrongBinder((IBinder) obj);
            }

            public final /* synthetic */ Object mo6866a(Parcel parcel) {
                return parcel.readStrongBinder();
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public IBinderParcelable(Parcel parcel) {
            super(parcel, f36246a);
        }

        public IBinderParcelable(IBinder iBinder) {
            super((Object) iBinder, f36246a);
        }
    }

    public static final class IntegerParcelable extends ConverterParcelable<Integer> {
        public static final IntegerParcelableCreator CREATOR = new IntegerParcelableCreator();
        private static final NullableParcelConverter<Integer> f36247a = new C30251();

        private static final class IntegerParcelableCreator implements Creator<IntegerParcelable> {
            private IntegerParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new IntegerParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new IntegerParcelable(parcel);
            }
        }

        static class C30251 extends NullableParcelConverter<Integer> {
            C30251() {
            }

            public final /* synthetic */ void mo6867a(Object obj, Parcel parcel) {
                parcel.writeInt(((Integer) obj).intValue());
            }

            public final /* synthetic */ Object mo6866a(Parcel parcel) {
                return Integer.valueOf(parcel.readInt());
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public IntegerParcelable(Parcel parcel) {
            super(parcel, f36247a);
        }

        public IntegerParcelable(Integer num) {
            super((Object) num, f36247a);
        }
    }

    public static final class LinkedHashMapParcelable extends ConverterParcelable<LinkedHashMap> {
        public static final LinkedHashMapParcelableCreator CREATOR = new LinkedHashMapParcelableCreator();
        private static final LinkedHashMapParcelConverter f36248a = new C30261();

        private static final class LinkedHashMapParcelableCreator implements Creator<LinkedHashMapParcelable> {
            private LinkedHashMapParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LinkedHashMapParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LinkedHashMapParcelable(parcel);
            }
        }

        static class C30261 extends LinkedHashMapParcelConverter {
            C30261() {
            }

            public final void mo7133a(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.m28672a(obj), 0);
            }

            public final void mo7135b(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.m28672a(obj), 0);
            }

            public final Object mo7132a(Parcel parcel) {
                return Parcels.m28673a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            public final Object mo7134b(Parcel parcel) {
                return Parcels.m28673a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LinkedHashMapParcelable(Parcel parcel) {
            super(parcel, f36248a);
        }

        public LinkedHashMapParcelable(LinkedHashMap linkedHashMap) {
            super((Object) linkedHashMap, f36248a);
        }
    }

    public static final class LinkedHashSetParcelable extends ConverterParcelable<LinkedHashSet> {
        public static final LinkedHashSetParcelableCreator CREATOR = new LinkedHashSetParcelableCreator();
        private static final LinkedHashSetParcelConverter f36249a = new C30271();

        private static final class LinkedHashSetParcelableCreator implements Creator<LinkedHashSetParcelable> {
            private LinkedHashSetParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LinkedHashSetParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LinkedHashSetParcelable(parcel);
            }
        }

        static class C30271 extends LinkedHashSetParcelConverter {
            C30271() {
            }

            public final Object mo7130a(Parcel parcel) {
                return Parcels.m28673a(parcel.readParcelable(LinkedHashSetParcelable.class.getClassLoader()));
            }

            public final void mo7131a(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.m28672a(obj), 0);
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LinkedHashSetParcelable(Parcel parcel) {
            super(parcel, f36249a);
        }

        public LinkedHashSetParcelable(LinkedHashSet linkedHashSet) {
            super((Object) linkedHashSet, f36249a);
        }
    }

    public static final class LinkedListParcelable extends ConverterParcelable<LinkedList> {
        public static final LinkedListParcelableCreator CREATOR = new LinkedListParcelableCreator();
        private static final LinkedListParcelConverter f36250a = new C30281();

        private static final class LinkedListParcelableCreator implements Creator<LinkedListParcelable> {
            private LinkedListParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LinkedListParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LinkedListParcelable(parcel);
            }
        }

        static class C30281 extends LinkedListParcelConverter {
            C30281() {
            }

            public final Object mo7130a(Parcel parcel) {
                return Parcels.m28673a(parcel.readParcelable(LinkedListParcelable.class.getClassLoader()));
            }

            public final void mo7131a(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.m28672a(obj), 0);
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LinkedListParcelable(Parcel parcel) {
            super(parcel, f36250a);
        }

        public LinkedListParcelable(LinkedList linkedList) {
            super((Object) linkedList, f36250a);
        }
    }

    public static final class ListParcelable extends ConverterParcelable<List> {
        public static final ListParcelableCreator CREATOR = new ListParcelableCreator();
        private static final ArrayListParcelConverter f36251a = new C30291();

        private static final class ListParcelableCreator implements Creator<ListParcelable> {
            private ListParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ListParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ListParcelable(parcel);
            }
        }

        static class C30291 extends ArrayListParcelConverter {
            C30291() {
            }

            public final Object mo7130a(Parcel parcel) {
                return Parcels.m28673a(parcel.readParcelable(ListParcelable.class.getClassLoader()));
            }

            public final void mo7131a(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.m28672a(obj), 0);
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public ListParcelable(Parcel parcel) {
            super(parcel, f36251a);
        }

        public ListParcelable(List list) {
            super((Object) list, f36251a);
        }
    }

    public static final class LongParcelable extends ConverterParcelable<Long> {
        public static final LongParcelableCreator CREATOR = new LongParcelableCreator();
        private static final NullableParcelConverter<Long> f36252a = new C30301();

        private static final class LongParcelableCreator implements Creator<LongParcelable> {
            private LongParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LongParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LongParcelable(parcel);
            }
        }

        static class C30301 extends NullableParcelConverter<Long> {
            C30301() {
            }

            public final /* synthetic */ void mo6867a(Object obj, Parcel parcel) {
                parcel.writeLong(((Long) obj).longValue());
            }

            public final /* synthetic */ Object mo6866a(Parcel parcel) {
                return Long.valueOf(parcel.readLong());
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LongParcelable(Parcel parcel) {
            super(parcel, f36252a);
        }

        public LongParcelable(Long l) {
            super((Object) l, f36252a);
        }
    }

    public static final class MapParcelable extends ConverterParcelable<Map> {
        public static final MapParcelableCreator CREATOR = new MapParcelableCreator();
        private static final HashMapParcelConverter f36253a = new C30311();

        private static final class MapParcelableCreator implements Creator<MapParcelable> {
            private MapParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MapParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new MapParcelable(parcel);
            }
        }

        static class C30311 extends HashMapParcelConverter {
            C30311() {
            }

            public final void mo7133a(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.m28672a(obj), 0);
            }

            public final void mo7135b(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.m28672a(obj), 0);
            }

            public final Object mo7132a(Parcel parcel) {
                return Parcels.m28673a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            public final Object mo7134b(Parcel parcel) {
                return Parcels.m28673a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public MapParcelable(Parcel parcel) {
            super(parcel, f36253a);
        }

        public MapParcelable(Map map) {
            super((Object) map, f36253a);
        }
    }

    public static final class SetParcelable extends ConverterParcelable<Set> {
        public static final SetParcelableCreator CREATOR = new SetParcelableCreator();
        private static final HashSetParcelConverter f36254a = new C30321();

        private static final class SetParcelableCreator implements Creator<SetParcelable> {
            private SetParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SetParcelable(parcel);
            }
        }

        static class C30321 extends HashSetParcelConverter {
            C30321() {
            }

            public final Object mo7130a(Parcel parcel) {
                return Parcels.m28673a(parcel.readParcelable(SetParcelable.class.getClassLoader()));
            }

            public final void mo7131a(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.m28672a(obj), 0);
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public SetParcelable(Parcel parcel) {
            super(parcel, f36254a);
        }

        public SetParcelable(Set set) {
            super((Object) set, f36254a);
        }
    }

    public static final class SparseArrayParcelable extends ConverterParcelable<SparseArray> {
        public static final SparseArrayCreator CREATOR = new SparseArrayCreator();
        private static final SparseArrayParcelConverter f36255a = new C30331();

        private static final class SparseArrayCreator implements Creator<SparseArrayParcelable> {
            private SparseArrayCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SparseArrayParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SparseArrayParcelable(parcel);
            }
        }

        static class C30331 extends SparseArrayParcelConverter {
            C30331() {
            }

            public final Object mo7136a(Parcel parcel) {
                return Parcels.m28673a(parcel.readParcelable(SparseArrayParcelable.class.getClassLoader()));
            }

            public final void mo7137a(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.m28672a(obj), 0);
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public SparseArrayParcelable(Parcel parcel) {
            super(parcel, f36255a);
        }

        public SparseArrayParcelable(SparseArray sparseArray) {
            super((Object) sparseArray, f36255a);
        }
    }

    public static final class SparseBooleanArrayParcelable extends ConverterParcelable<SparseBooleanArray> {
        public static final SparseBooleanArrayCreator CREATOR = new SparseBooleanArrayCreator();
        private static final NullableParcelConverter<SparseBooleanArray> f36256a = new C30341();

        private static final class SparseBooleanArrayCreator implements Creator<SparseBooleanArrayParcelable> {
            private SparseBooleanArrayCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SparseBooleanArrayParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SparseBooleanArrayParcelable(parcel);
            }
        }

        static class C30341 extends NullableParcelConverter<SparseBooleanArray> {
            C30341() {
            }

            public final /* synthetic */ void mo6867a(Object obj, Parcel parcel) {
                parcel.writeSparseBooleanArray((SparseBooleanArray) obj);
            }

            public final /* synthetic */ Object mo6866a(Parcel parcel) {
                return parcel.readSparseBooleanArray();
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public SparseBooleanArrayParcelable(Parcel parcel) {
            super(parcel, f36256a);
        }

        public SparseBooleanArrayParcelable(SparseBooleanArray sparseBooleanArray) {
            super((Object) sparseBooleanArray, f36256a);
        }
    }

    public static final class TreeMapParcelable extends ConverterParcelable<Map> {
        public static final TreeMapParcelableCreator CREATOR = new TreeMapParcelableCreator();
        private static final TreeMapParcelConverter f36257a = new C30351();

        private static final class TreeMapParcelableCreator implements Creator<TreeMapParcelable> {
            private TreeMapParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new TreeMapParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new TreeMapParcelable(parcel);
            }
        }

        static class C30351 extends TreeMapParcelConverter {
            C30351() {
            }

            public final void mo7133a(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.m28672a(obj), 0);
            }

            public final void mo7135b(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.m28672a(obj), 0);
            }

            public final Object mo7132a(Parcel parcel) {
                return Parcels.m28673a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            public final Object mo7134b(Parcel parcel) {
                return Parcels.m28673a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public TreeMapParcelable(Parcel parcel) {
            super(parcel, f36257a);
        }

        public TreeMapParcelable(Map map) {
            super((Object) map, f36257a);
        }
    }

    public static final class TreeSetParcelable extends ConverterParcelable<Set> {
        public static final TreeSetParcelableCreator CREATOR = new TreeSetParcelableCreator();
        private static final TreeSetParcelConverter f36258a = new C30361();

        private static final class TreeSetParcelableCreator implements Creator<TreeSetParcelable> {
            private TreeSetParcelableCreator() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new TreeSetParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new TreeSetParcelable(parcel);
            }
        }

        static class C30361 extends TreeSetParcelConverter {
            C30361() {
            }

            public final Object mo7130a(Parcel parcel) {
                return Parcels.m28673a(parcel.readParcelable(TreeSetParcelable.class.getClassLoader()));
            }

            public final void mo7131a(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.m28672a(obj), 0);
            }
        }

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public TreeSetParcelable(Parcel parcel) {
            super(parcel, f36258a);
        }

        public TreeSetParcelable(Set set) {
            super((Object) set, f36258a);
        }
    }

    private NonParcelRepository() {
        this.f33430b.put(Collection.class, new CollectionParcelableFactory());
        this.f33430b.put(List.class, new ListParcelableFactory());
        this.f33430b.put(ArrayList.class, new ListParcelableFactory());
        this.f33430b.put(Set.class, new SetParcelableFactory());
        this.f33430b.put(HashSet.class, new SetParcelableFactory());
        this.f33430b.put(TreeSet.class, new TreeSetParcelableFactory());
        this.f33430b.put(SparseArray.class, new SparseArrayParcelableFactory());
        this.f33430b.put(Map.class, new MapParcelableFactory());
        this.f33430b.put(HashMap.class, new MapParcelableFactory());
        this.f33430b.put(TreeMap.class, new TreeMapParcelableFactory());
        this.f33430b.put(Integer.class, new IntegerParcelableFactory());
        this.f33430b.put(Long.class, new LongParcelableFactory());
        this.f33430b.put(Double.class, new DoubleParcelableFactory());
        this.f33430b.put(Float.class, new FloatParcelableFactory());
        this.f33430b.put(Byte.class, new ByteParcelableFactory());
        this.f33430b.put(String.class, new StringParcelableFactory());
        this.f33430b.put(Character.class, new CharacterParcelableFactory());
        this.f33430b.put(Boolean.class, new BooleanParcelableFactory());
        this.f33430b.put(byte[].class, new ByteArrayParcelableFactory());
        this.f33430b.put(char[].class, new CharArrayParcelableFactory());
        this.f33430b.put(boolean[].class, new BooleanArrayParcelableFactory());
        this.f33430b.put(IBinder.class, new IBinderParcelableFactory());
        this.f33430b.put(Bundle.class, new BundleParcelableFactory());
        this.f33430b.put(SparseBooleanArray.class, new SparseBooleanArrayParcelableFactory());
        this.f33430b.put(LinkedList.class, new LinkedListParcelableFactory());
        this.f33430b.put(LinkedHashMap.class, new LinkedHashMapParcelableFactory());
        this.f33430b.put(SortedMap.class, new TreeMapParcelableFactory());
        this.f33430b.put(SortedSet.class, new TreeSetParcelableFactory());
        this.f33430b.put(LinkedHashSet.class, new LinkedHashSetParcelableFactory());
    }

    public static NonParcelRepository m34208a() {
        return f33429a;
    }

    public final Map<Class, ParcelableFactory> mo6360b() {
        return this.f33430b;
    }
}
