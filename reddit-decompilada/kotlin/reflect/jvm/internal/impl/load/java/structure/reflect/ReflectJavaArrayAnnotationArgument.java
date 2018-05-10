package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationArgument.Factory;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class ReflectJavaArrayAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaArrayAnnotationArgument {
    private final Object[] f36101b;

    public ReflectJavaArrayAnnotationArgument(Name name, Object[] objArr) {
        Intrinsics.m26847b(objArr, "values");
        super(name);
        this.f36101b = objArr;
    }

    public final List<ReflectJavaAnnotationArgument> mo6705b() {
        Object[] objArr = this.f36101b;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (obj == null) {
                Intrinsics.m26842a();
            }
            arrayList.add(Factory.m27247a(obj, null));
        }
        return (List) arrayList;
    }
}
