package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: FqNamesUtil.kt */
public final class FqNamesUtilKt {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f25865a;

        static {
            int[] iArr = new int[State.values().length];
            f25865a = iArr;
            iArr[State.f25874a.ordinal()] = 1;
            f25865a[State.f25876c.ordinal()] = 2;
            f25865a[State.f25875b.ordinal()] = 3;
        }
    }

    public static final boolean m27423a(String str) {
        if (str == null) {
            return false;
        }
        State state = State.f25874a;
        str = StringsKt__StringsKt.m42463c(str);
        while (str.hasNext()) {
            char a = str.mo6745a();
            switch (WhenMappings.f25865a[state.ordinal()]) {
                case 1:
                case 2:
                    if (Character.isJavaIdentifierPart(a)) {
                        state = State.f25875b;
                        break;
                    }
                    return false;
                case 3:
                    if (a != '.') {
                        if (Character.isJavaIdentifierPart(a)) {
                            break;
                        }
                        return false;
                    }
                    state = State.f25876c;
                    break;
                default:
                    break;
            }
        }
        return Intrinsics.m26845a((Object) state, State.f25876c) ^ 1;
    }
}
