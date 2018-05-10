package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;

public class Reflection {
    private static final ReflectionFactory f25292a;
    private static final KClass[] f25293b = new KClass[0];

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "kotlin.reflect.jvm.internal.ReflectionFactoryImpl";	 Catch:{ ClassCastException -> 0x000e, ClassCastException -> 0x000e, ClassCastException -> 0x000e, ClassCastException -> 0x000e }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassCastException -> 0x000e, ClassCastException -> 0x000e, ClassCastException -> 0x000e, ClassCastException -> 0x000e }
        r1 = r1.newInstance();	 Catch:{ ClassCastException -> 0x000e, ClassCastException -> 0x000e, ClassCastException -> 0x000e, ClassCastException -> 0x000e }
        r1 = (kotlin.jvm.internal.ReflectionFactory) r1;	 Catch:{ ClassCastException -> 0x000e, ClassCastException -> 0x000e, ClassCastException -> 0x000e, ClassCastException -> 0x000e }
        r0 = r1;
    L_0x000e:
        if (r0 == 0) goto L_0x0011;
    L_0x0010:
        goto L_0x0016;
    L_0x0011:
        r0 = new kotlin.jvm.internal.ReflectionFactory;
        r0.<init>();
    L_0x0016:
        f25292a = r0;
        r0 = 0;
        r0 = new kotlin.reflect.KClass[r0];
        f25293b = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.Reflection.<clinit>():void");
    }

    public static KDeclarationContainer m26851a(Class cls, String str) {
        return f25292a.mo5697a(cls, str);
    }

    public static KClass m26850a(Class cls) {
        return f25292a.mo5696a(cls);
    }

    public static String m26849a(Lambda lambda) {
        return f25292a.mo5695a(lambda);
    }

    public static KFunction m26852a(FunctionReference functionReference) {
        return f25292a.mo5698a(functionReference);
    }

    public static KProperty0 m26855a(PropertyReference0 propertyReference0) {
        return f25292a.mo5701a(propertyReference0);
    }

    public static KMutableProperty0 m26853a(MutablePropertyReference0 mutablePropertyReference0) {
        return f25292a.mo5699a(mutablePropertyReference0);
    }

    public static KProperty1 m26856a(PropertyReference1 propertyReference1) {
        return f25292a.mo5702a(propertyReference1);
    }

    public static KMutableProperty1 m26854a(MutablePropertyReference1 mutablePropertyReference1) {
        return f25292a.mo5700a(mutablePropertyReference1);
    }
}
