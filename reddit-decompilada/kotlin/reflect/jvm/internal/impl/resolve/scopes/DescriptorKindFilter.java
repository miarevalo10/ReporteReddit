package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: MemberScope.kt */
public final class DescriptorKindFilter {
    public static final DescriptorKindFilter f26113c = new DescriptorKindFilter(Companion.m27766g());
    public static final DescriptorKindFilter f26114d = new DescriptorKindFilter(Companion.m27769j());
    public static final DescriptorKindFilter f26115e = new DescriptorKindFilter(Companion.m27760a());
    public static final DescriptorKindFilter f26116f = new DescriptorKindFilter(Companion.m27761b());
    public static final DescriptorKindFilter f26117g = new DescriptorKindFilter(Companion.m27762c());
    public static final DescriptorKindFilter f26118h = new DescriptorKindFilter(Companion.m27767h());
    public static final DescriptorKindFilter f26119i = new DescriptorKindFilter(Companion.m27763d());
    public static final DescriptorKindFilter f26120j = new DescriptorKindFilter(Companion.m27764e());
    public static final DescriptorKindFilter f26121k = new DescriptorKindFilter(Companion.m27765f());
    public static final DescriptorKindFilter f26122l = new DescriptorKindFilter(Companion.m27768i());
    public static final Companion f26123m = new Companion();
    private static int f26124n = 1;
    private static final int f26125o = Companion.m27772m();
    private static final int f26126p = Companion.m27772m();
    private static final int f26127q = Companion.m27772m();
    private static final int f26128r = Companion.m27772m();
    private static final int f26129s = Companion.m27772m();
    private static final int f26130t = Companion.m27772m();
    private static final int f26131u = (Companion.m27772m() - 1);
    private static final int f26132v = ((Companion.m27760a() | Companion.m27761b()) | Companion.m27762c());
    private static final int f26133w = ((Companion.m27761b() | Companion.m27764e()) | Companion.m27765f());
    private static final int f26134x = (Companion.m27764e() | Companion.m27765f());
    private static final List<MaskToName> f26135y;
    private static final List<MaskToName> f26136z;
    final int f26137a;
    public final List<DescriptorKindExclude> f26138b;

    /* compiled from: MemberScope.kt */
    public static final class Companion {

        /* compiled from: MemberScope.kt */
        private static final class MaskToName {
            final int f26111a;
            final String f26112b;

            public MaskToName(int i, String str) {
                Intrinsics.m26847b(str, "name");
                this.f26111a = i;
                this.f26112b = str;
            }
        }

        private Companion() {
        }

        public static int m27760a() {
            return DescriptorKindFilter.f26125o;
        }

        public static int m27761b() {
            return DescriptorKindFilter.f26126p;
        }

        public static int m27762c() {
            return DescriptorKindFilter.f26127q;
        }

        public static int m27763d() {
            return DescriptorKindFilter.f26128r;
        }

        public static int m27764e() {
            return DescriptorKindFilter.f26129s;
        }

        public static int m27765f() {
            return DescriptorKindFilter.f26130t;
        }

        public static int m27766g() {
            return DescriptorKindFilter.f26131u;
        }

        public static int m27767h() {
            return DescriptorKindFilter.f26132v;
        }

        public static int m27768i() {
            return DescriptorKindFilter.f26133w;
        }

        public static int m27769j() {
            return DescriptorKindFilter.f26134x;
        }

        public static final /* synthetic */ int m27772m() {
            int a = DescriptorKindFilter.f26124n;
            Companion companion = DescriptorKindFilter.f26123m;
            companion = DescriptorKindFilter.f26123m;
            DescriptorKindFilter.f26124n = DescriptorKindFilter.f26124n << 1;
            return a;
        }
    }

    public DescriptorKindFilter(int r1, java.util.List<? extends kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude> r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.<init>(int, java.util.List):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.<init>(int, java.util.List):void");
    }

    public final boolean m27787a(int i) {
        return (i & this.f26137a) != 0;
    }

    public final String toString() {
        Object obj;
        String str;
        for (Object next : f26135y) {
            if (((MaskToName) next).f26111a == this.f26137a) {
                obj = 1;
                continue;
            } else {
                obj = null;
                continue;
            }
            if (obj != null) {
                break;
            }
        }
        Object next2 = null;
        MaskToName maskToName = (MaskToName) next2;
        if (maskToName != null) {
            str = maskToName.f26112b;
        } else {
            str = null;
        }
        if (str == null) {
            Collection arrayList = new ArrayList();
            for (MaskToName maskToName2 : f26136z) {
                if (m27787a(maskToName2.f26111a)) {
                    obj = maskToName2.f26112b;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            str = CollectionsKt___CollectionsKt.m41412a((Iterable) (List) arrayList, (CharSequence) " | ", null, null, 0, null, null, 62);
        }
        StringBuilder stringBuilder = new StringBuilder("DescriptorKindFilter(");
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(this.f26138b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    static {
        Object[] objArr = (Object[]) DescriptorKindFilter.class.getFields();
        Collection arrayList = new ArrayList();
        for (Object obj : objArr) {
            Object obj2;
            if (Modifier.isStatic(((Field) obj2).getModifiers())) {
                arrayList.add(obj2);
            }
        }
        Collection arrayList2 = new ArrayList();
        Iterator it = ((List) arrayList).iterator();
        while (true) {
            obj2 = null;
            if (!it.hasNext()) {
                break;
            }
            Field field = (Field) it.next();
            Object obj3 = field.get(null);
            if (!(obj3 instanceof DescriptorKindFilter)) {
                obj3 = null;
            }
            DescriptorKindFilter descriptorKindFilter = (DescriptorKindFilter) obj3;
            if (descriptorKindFilter != null) {
                int i = descriptorKindFilter.f26137a;
                Object name = field.getName();
                Intrinsics.m26843a(name, "field.name");
                obj2 = new MaskToName(i, name);
            }
            if (obj2 != null) {
                arrayList2.add(obj2);
            }
        }
        f26135y = CollectionsKt.m28089a((Collection) (List) arrayList2);
        objArr = (Object[]) DescriptorKindFilter.class.getFields();
        arrayList = new ArrayList();
        for (Object obj32 : objArr) {
            if (Modifier.isStatic(((Field) obj32).getModifiers())) {
                arrayList.add(obj32);
            }
        }
        arrayList2 = new ArrayList();
        for (Object name2 : (List) arrayList) {
            if (Intrinsics.m26845a(((Field) name2).getType(), Integer.TYPE)) {
                arrayList2.add(name2);
            }
        }
        arrayList = new ArrayList();
        for (Field field2 : (List) arrayList2) {
            obj32 = field2.get(null);
            if (obj32 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            Object maskToName;
            i = ((Integer) obj32).intValue();
            if ((i == ((-i) & i) ? 1 : (byte) 0) != 0) {
                name2 = field2.getName();
                Intrinsics.m26843a(name2, "field.name");
                maskToName = new MaskToName(i, name2);
            } else {
                maskToName = null;
            }
            if (maskToName != null) {
                arrayList.add(maskToName);
            }
        }
        f26136z = CollectionsKt.m28089a((Collection) (List) arrayList);
    }
}
