package kotlin.reflect.jvm.internal.impl.serialization;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class.Kind;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.MemberKind;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Modality;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Visibility;

public class Flags {
    public static final BooleanFlagField f26146A;
    public static final BooleanFlagField f26147B;
    public static final BooleanFlagField f26148C;
    public static final BooleanFlagField f26149D;
    public static final BooleanFlagField f26150a = FlagField.m27794a();
    public static final BooleanFlagField f26151b;
    public static final FlagField<Visibility> f26152c;
    public static final FlagField<Modality> f26153d;
    public static final FlagField<Kind> f26154e;
    public static final BooleanFlagField f26155f;
    public static final BooleanFlagField f26156g;
    public static final BooleanFlagField f26157h;
    public static final BooleanFlagField f26158i = FlagField.m27795a(f26152c);
    public static final FlagField<MemberKind> f26159j;
    public static final BooleanFlagField f26160k;
    public static final BooleanFlagField f26161l;
    public static final BooleanFlagField f26162m;
    public static final BooleanFlagField f26163n;
    public static final BooleanFlagField f26164o;
    public static final BooleanFlagField f26165p;
    public static final BooleanFlagField f26166q;
    public static final BooleanFlagField f26167r;
    public static final BooleanFlagField f26168s;
    public static final BooleanFlagField f26169t;
    public static final BooleanFlagField f26170u;
    public static final BooleanFlagField f26171v;
    public static final BooleanFlagField f26172w;
    public static final BooleanFlagField f26173x;
    public static final BooleanFlagField f26174y;
    public static final BooleanFlagField f26175z;

    public static abstract class FlagField<E> {
        protected final int f26144a;
        protected final int f26145b;

        public abstract E mo5920b(int i);

        public static <E extends EnumLite> FlagField<E> m27796a(FlagField<?> flagField, E[] eArr) {
            return new EnumLiteFlagField(flagField.f26144a + flagField.f26145b, eArr);
        }

        public static BooleanFlagField m27794a() {
            return new BooleanFlagField(0);
        }

        public static BooleanFlagField m27795a(FlagField<?> flagField) {
            return new BooleanFlagField(flagField.f26144a + flagField.f26145b);
        }

        private FlagField(int i, int i2) {
            this.f26144a = i;
            this.f26145b = i2;
        }
    }

    public static class BooleanFlagField extends FlagField<Boolean> {
        public final /* synthetic */ Object mo5920b(int i) {
            return m33502a(i);
        }

        public BooleanFlagField(int i) {
            super(i, 1);
        }

        public final Boolean m33502a(int i) {
            i = Boolean.valueOf((i & (1 << this.a)) != 0 ? 1 : 0);
            if (i != 0) {
                return i;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/serialization/Flags$BooleanFlagField", "get"}));
        }
    }

    private static class EnumLiteFlagField<E extends EnumLite> extends FlagField<E> {
        private final E[] f32955c;

        public EnumLiteFlagField(int i, E[] eArr) {
            super(i, m33504a(eArr));
            this.f32955c = eArr;
        }

        private static <E> int m33504a(E[] eArr) {
            if (eArr == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumEntries", "kotlin/reflect/jvm/internal/impl/serialization/Flags$EnumLiteFlagField", "bitWidth"}));
            }
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i = 31; i >= 0; i--) {
                if (((1 << i) & length) != 0) {
                    return i + 1;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Empty enum: ");
            stringBuilder.append(eArr.getClass());
            throw new IllegalStateException(stringBuilder.toString());
        }

        public final /* synthetic */ Object mo5920b(int i) {
            i = (i & (((1 << this.b) - 1) << this.a)) >> this.a;
            for (EnumLite enumLite : this.f32955c) {
                if (enumLite.mo5922a() == i) {
                    return enumLite;
                }
            }
            return 0;
        }
    }

    static {
        FlagField a = FlagField.m27794a();
        f26151b = a;
        a = FlagField.m27796a(a, Visibility.values());
        f26152c = a;
        a = FlagField.m27796a(a, Modality.values());
        f26153d = a;
        a = FlagField.m27796a(a, Kind.values());
        f26154e = a;
        a = FlagField.m27795a(a);
        f26155f = a;
        a = FlagField.m27795a(a);
        f26156g = a;
        f26157h = FlagField.m27795a(a);
        a = FlagField.m27796a(f26153d, MemberKind.values());
        f26159j = a;
        a = FlagField.m27795a(a);
        f26160k = a;
        a = FlagField.m27795a(a);
        f26161l = a;
        a = FlagField.m27795a(a);
        f26162m = a;
        a = FlagField.m27795a(a);
        f26163n = a;
        a = FlagField.m27795a(a);
        f26164o = a;
        f26165p = FlagField.m27795a(a);
        a = FlagField.m27795a(f26159j);
        f26166q = a;
        a = FlagField.m27795a(a);
        f26167r = a;
        a = FlagField.m27795a(a);
        f26168s = a;
        a = FlagField.m27795a(a);
        f26169t = a;
        a = FlagField.m27795a(a);
        f26170u = a;
        a = FlagField.m27795a(a);
        f26171v = a;
        a = FlagField.m27795a(a);
        f26172w = a;
        f26173x = FlagField.m27795a(a);
        a = FlagField.m27795a(f26151b);
        f26174y = a;
        a = FlagField.m27795a(a);
        f26175z = a;
        f26146A = FlagField.m27795a(a);
        a = FlagField.m27795a(f26153d);
        f26147B = a;
        a = FlagField.m27795a(a);
        f26148C = a;
        f26149D = FlagField.m27795a(a);
    }
}
