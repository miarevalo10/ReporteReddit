package kotlin.reflect.jvm.internal;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: AnnotationConstructorCaller.kt */
final class C2919xa743ec88 extends Lambda implements Function0<Integer> {
    final /* synthetic */ Map f38209a;

    C2919xa743ec88(Map map) {
        this.f38209a = map;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        int i = 0;
        for (Entry entry : this.f38209a.entrySet()) {
            int hashCode;
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof boolean[]) {
                hashCode = Arrays.hashCode((boolean[]) value);
            } else if (value instanceof char[]) {
                hashCode = Arrays.hashCode((char[]) value);
            } else if (value instanceof byte[]) {
                hashCode = Arrays.hashCode((byte[]) value);
            } else if (value instanceof short[]) {
                hashCode = Arrays.hashCode((short[]) value);
            } else if (value instanceof int[]) {
                hashCode = Arrays.hashCode((int[]) value);
            } else if (value instanceof float[]) {
                hashCode = Arrays.hashCode((float[]) value);
            } else if (value instanceof long[]) {
                hashCode = Arrays.hashCode((long[]) value);
            } else if (value instanceof double[]) {
                hashCode = Arrays.hashCode((double[]) value);
            } else if (value instanceof Object[]) {
                hashCode = Arrays.hashCode((Object[]) value);
            } else {
                hashCode = value.hashCode();
            }
            i += hashCode ^ (127 * str.hashCode());
        }
        return Integer.valueOf(i);
    }
}
