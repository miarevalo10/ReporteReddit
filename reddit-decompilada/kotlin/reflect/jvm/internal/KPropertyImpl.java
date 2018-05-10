package kotlin.reflect.jvm.internal;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 <*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004;<=>B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB3\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0010J\n\u00102\u001a\u0004\u0018\u00010+H\u0004J\u0013\u00103\u001a\u00020&2\b\u00104\u001a\u0004\u0018\u00010\nH\u0002J\u001e\u00105\u001a\u0004\u0018\u00010\n2\b\u00106\u001a\u0004\u0018\u00010+2\b\u00107\u001a\u0004\u0018\u00010\nH\u0004J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u0007H\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR!\u0010\u001d\u001a\u0015\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\r0\r0\u001e¢\u0006\u0002\b X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010'R\u0014\u0010(\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0013\u0010*\u001a\u0004\u0018\u00010+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001b\u0010.\u001a\u000f\u0012\u0006\u0012\u0004\u0018\u00010+0\u001e¢\u0006\u0002\b X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u00100¨\u0006?"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "R", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "descriptor_", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "Lorg/jetbrains/annotations/NotNull;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "javaField", "Ljava/lang/reflect/Field;", "getJavaField", "()Ljava/lang/reflect/Field;", "javaField_", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateField", "equals", "other", "getDelegate", "field", "receiver", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: KPropertyImpl.kt */
public abstract class KPropertyImpl<R> extends KCallableImpl<R> implements KProperty<R> {
    public static final Companion f36034f = new Companion();
    private static final Object f36035h = new Object();
    private final LazySoftVal<Field> f36036a;
    final KDeclarationContainerImpl f36037b;
    final String f36038c;
    final String f36039d;
    final Object f36040e;
    private final LazySoftVal<PropertyDescriptor> f36041g;

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", "", "()V", "EXTENSION_PROPERTY_DELEGATE", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: KPropertyImpl.kt */
    public static final class Companion {
        private Companion() {
        }

        public static Object m26911a() {
            return KPropertyImpl.f36035h;
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: KPropertyImpl.kt */
    public static abstract class Accessor<PropertyType, ReturnType> extends KCallableImpl<ReturnType> implements KFunction<ReturnType> {
        public abstract KPropertyImpl<PropertyType> mo7255d();

        public abstract PropertyAccessorDescriptor mo7076i();

        public final KDeclarationContainerImpl mo6674e() {
            return mo7255d().f36037b;
        }

        public final boolean mo6675f() {
            return mo7255d().mo6675f();
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004R\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8VX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: KPropertyImpl.kt */
    public static abstract class Getter<R> extends Accessor<R, R> implements kotlin.reflect.KProperty.Getter<R> {
        static final /* synthetic */ KProperty[] f38284a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Getter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Getter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;"))};
        private final LazySoftVal f38285b = ReflectProperties.m26919b(new KPropertyImpl$Getter$descriptor$2(this));
        private final LazySoftVal f38286c = ReflectProperties.m26919b(new KPropertyImpl$Getter$caller$2(this));

        public final /* synthetic */ CallableMemberDescriptor mo6676a() {
            return m38274j();
        }

        public final /* synthetic */ PropertyAccessorDescriptor mo7076i() {
            return m38274j();
        }

        public final String mo5687b() {
            StringBuilder stringBuilder = new StringBuilder("<get-");
            stringBuilder.append(mo7255d().f36038c);
            stringBuilder.append(Operation.GREATER_THAN);
            return stringBuilder.toString();
        }

        private PropertyGetterDescriptor m38274j() {
            return (PropertyGetterDescriptor) this.f38285b.mo5694a();
        }

        public final FunctionCaller<?> mo6677c() {
            return (FunctionCaller) this.f38286c.mo5694a();
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0005¢\u0006\u0002\u0010\u0005R\u001f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8VX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: KPropertyImpl.kt */
    public static abstract class Setter<R> extends Accessor<R, Unit> implements kotlin.reflect.KMutableProperty.Setter<R> {
        static final /* synthetic */ KProperty[] f38289a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Setter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Setter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;"))};
        private final LazySoftVal f38290b = ReflectProperties.m26919b(new KPropertyImpl$Setter$descriptor$2(this));
        private final LazySoftVal f38291c = ReflectProperties.m26919b(new KPropertyImpl$Setter$caller$2(this));

        public final /* synthetic */ CallableMemberDescriptor mo6676a() {
            return m38279j();
        }

        public final /* synthetic */ PropertyAccessorDescriptor mo7076i() {
            return m38279j();
        }

        public final String mo5687b() {
            StringBuilder stringBuilder = new StringBuilder("<set-");
            stringBuilder.append(mo7255d().f36038c);
            stringBuilder.append(Operation.GREATER_THAN);
            return stringBuilder.toString();
        }

        private PropertySetterDescriptor m38279j() {
            return (PropertySetterDescriptor) this.f38290b.mo5694a();
        }

        public final FunctionCaller<?> mo6677c() {
            return (FunctionCaller) this.f38291c.mo5694a();
        }
    }

    public abstract Getter<R> mo7074j();

    public final /* synthetic */ CallableMemberDescriptor mo6676a() {
        return m36189m();
    }

    public final KDeclarationContainerImpl mo6674e() {
        return this.f36037b;
    }

    public final String mo5687b() {
        return this.f36038c;
    }

    private KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, PropertyDescriptor propertyDescriptor, Object obj) {
        this.f36037b = kDeclarationContainerImpl;
        this.f36038c = str;
        this.f36039d = str2;
        this.f36040e = obj;
        this.f36036a = ReflectProperties.m26919b((Function0) new KPropertyImpl$javaField_$1(this));
        this.f36041g = ReflectProperties.m26917a(propertyDescriptor, (Function0) new KPropertyImpl$descriptor_$1(this));
    }

    public KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        Intrinsics.m26847b(kDeclarationContainerImpl, "container");
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(str2, "signature");
        this(kDeclarationContainerImpl, str, str2, null, obj);
    }

    public KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        Intrinsics.m26847b(kDeclarationContainerImpl, "container");
        Intrinsics.m26847b(propertyDescriptor, "descriptor");
        Object a = propertyDescriptor.mo6689i().m27429a();
        Intrinsics.m26843a(a, "descriptor.name.asString()");
        RuntimeTypeMapper runtimeTypeMapper = RuntimeTypeMapper.f25343a;
        this(kDeclarationContainerImpl, a, RuntimeTypeMapper.m26929a(propertyDescriptor).mo5691a(), propertyDescriptor, CallableReference.f32530c);
    }

    public final boolean mo6675f() {
        return Intrinsics.m26845a(this.f36040e, CallableReference.f32530c) ^ 1;
    }

    public final Field m36187k() {
        return (Field) this.f36036a.mo5694a();
    }

    protected final Field m36188l() {
        return m36189m().mo7824B() ? m36187k() : null;
    }

    protected final Object m36180a(Field field, Object obj) {
        try {
            if (obj != Companion.m26911a() || m36189m().mo7755d() != null) {
                return field != null ? field.get(obj) : null;
            } else {
                obj = new StringBuilder();
                StringBuilder stringBuilder = new StringBuilder("'");
                stringBuilder.append(this);
                stringBuilder.append("' is not an extension property and thus getExtensionDelegate() ");
                obj.append(stringBuilder.toString());
                obj.append("is not going to work, use getDelegate() instead");
                throw ((Throwable) new RuntimeException(obj.toString()));
            }
        } catch (Field field2) {
            throw ((Throwable) new IllegalPropertyDelegateAccessException(field2));
        }
    }

    public final PropertyDescriptor m36189m() {
        Object a = this.f36041g.mo5694a();
        Intrinsics.m26843a(a, "descriptor_()");
        return (PropertyDescriptor) a;
    }

    public final FunctionCaller<?> mo6677c() {
        return mo7074j().mo6677c();
    }

    public boolean equals(Object obj) {
        obj = UtilKt.m26936b(obj);
        if (obj != null && Intrinsics.m26845a(this.f36037b, obj.f36037b) && Intrinsics.m26845a(this.f36038c, obj.f36038c) && Intrinsics.m26845a(this.f36039d, obj.f36039d) && Intrinsics.m26845a(this.f36040e, obj.f36040e) != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.f25341a;
        return ReflectionObjectRenderer.m26922a(m36189m());
    }

    public int hashCode() {
        return (((this.f36037b.hashCode() * 31) + this.f36038c.hashCode()) * 31) + this.f36039d.hashCode();
    }
}
