package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.CheckResult.IllegalFunctionName;
import kotlin.reflect.jvm.internal.impl.util.CheckResult.IllegalSignature;
import kotlin.reflect.jvm.internal.impl.util.CheckResult.SuccessCheck;

/* compiled from: modifierChecks.kt */
public abstract class AbstractModifierChecks {
    public abstract List<Checks> mo5947a();

    public final CheckResult m28075a(FunctionDescriptor functionDescriptor) {
        Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
        for (Checks checks : mo5947a()) {
            Check[] checkArr;
            String b;
            String str;
            Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
            int i = 0;
            int i2 = 1;
            if (checks.f26376a == null || (Intrinsics.m26845a(functionDescriptor.mo6689i(), checks.f26376a) ^ 1) == 0) {
                if (checks.f26377b != null) {
                    if (!checks.f26377b.m28147a(functionDescriptor.mo6689i().m27429a())) {
                    }
                }
                if (!(checks.f26378c == null || (checks.f26378c.contains(functionDescriptor.mo6689i()) ^ 1) == 0)) {
                }
                if (i2 != 0) {
                    Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
                    checkArr = checks.f26380e;
                    while (i < checkArr.length) {
                        b = checkArr[i].mo5945b(functionDescriptor);
                        if (b != null) {
                            return (CheckResult) new IllegalSignature(b);
                        }
                        i++;
                    }
                    str = (String) checks.f26379d.mo6492a(functionDescriptor);
                    if (str == null) {
                        return new IllegalSignature(str);
                    }
                    return (CheckResult) SuccessCheck.f33086b;
                }
            }
            i2 = 0;
            continue;
            if (i2 != 0) {
                Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
                checkArr = checks.f26380e;
                while (i < checkArr.length) {
                    b = checkArr[i].mo5945b(functionDescriptor);
                    if (b != null) {
                        return (CheckResult) new IllegalSignature(b);
                    }
                    i++;
                }
                str = (String) checks.f26379d.mo6492a(functionDescriptor);
                if (str == null) {
                    return (CheckResult) SuccessCheck.f33086b;
                }
                return new IllegalSignature(str);
            }
        }
        return (CheckResult) IllegalFunctionName.f33084b;
    }
}
