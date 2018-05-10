package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.KParameter.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "R", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KCallableImpl.kt */
final class KCallableImpl$parameters_$1 extends Lambda implements Function0<ArrayList<KParameter>> {
    final /* synthetic */ KCallableImpl f38221a;

    KCallableImpl$parameters_$1(KCallableImpl kCallableImpl) {
        this.f38221a = kCallableImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        int i;
        final CallableMemberDescriptor a = this.f38221a.mo6676a();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (a.mo7756e() == null || this.f38221a.mo6675f()) {
            i = 0;
        } else {
            arrayList.add(new KParameterImpl(this.f38221a, 0, Kind.f25297a, new Function0<ReceiverParameterDescriptor>() {
                public final /* synthetic */ Object invoke() {
                    ReceiverParameterDescriptor e = a.mo7756e();
                    if (e == null) {
                        Intrinsics.m26842a();
                    }
                    return e;
                }
            }));
            i = 1;
        }
        if (!(a.mo7755d() == null || this.f38221a.mo6675f())) {
            int i3 = i + 1;
            arrayList.add(new KParameterImpl(this.f38221a, i, Kind.f25298b, new Function0<ReceiverParameterDescriptor>() {
                public final /* synthetic */ Object invoke() {
                    ReceiverParameterDescriptor d = a.mo7755d();
                    if (d == null) {
                        Intrinsics.m26842a();
                    }
                    return d;
                }
            }));
            i = i3;
        }
        int size = a.mo7757k().size() - 1;
        if (size >= 0) {
            while (true) {
                int i4 = i + 1;
                arrayList.add(new KParameterImpl(this.f38221a, i, Kind.f25299c, new Function0<ValueParameterDescriptor>() {
                    public final /* synthetic */ Object invoke() {
                        Object obj = a.mo7757k().get(i2);
                        Intrinsics.m26843a(obj, "descriptor.valueParameters[i]");
                        return (ValueParameterDescriptor) obj;
                    }
                }));
                if (i2 == size) {
                    break;
                }
                i2++;
                i = i4;
            }
        }
        if (this.f38221a.m32889h() && (a instanceof JavaCallableMemberDescriptor)) {
            List list = arrayList;
            if (list.size() > 1) {
                CollectionsKt__MutableCollectionsKt.m38191a(list, (Comparator) new KCallableImpl$parameters_$1$$special$$inlined$sortBy$1());
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }
}
