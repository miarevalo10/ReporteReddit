package kotlin.reflect.jvm.internal;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.Arrays;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010&\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "entry", "", "", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: AnnotationConstructorCaller.kt */
final class C2920xd18867f3 extends Lambda implements Function1<Entry<? extends String, ? extends Object>, String> {
    public static final C2920xd18867f3 f38210a = new C2920xd18867f3();

    C2920xd18867f3() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Entry entry = (Entry) obj;
        Intrinsics.m26847b(entry, "entry");
        String str = (String) entry.getKey();
        obj = entry.getValue();
        if (obj instanceof boolean[]) {
            obj = Arrays.toString((boolean[]) obj);
        } else if (obj instanceof char[]) {
            obj = Arrays.toString((char[]) obj);
        } else if (obj instanceof byte[]) {
            obj = Arrays.toString((byte[]) obj);
        } else if (obj instanceof short[]) {
            obj = Arrays.toString((short[]) obj);
        } else if (obj instanceof int[]) {
            obj = Arrays.toString((int[]) obj);
        } else if (obj instanceof float[]) {
            obj = Arrays.toString((float[]) obj);
        } else if (obj instanceof long[]) {
            obj = Arrays.toString((long[]) obj);
        } else if (obj instanceof double[]) {
            obj = Arrays.toString((double[]) obj);
        } else if (obj instanceof Object[]) {
            obj = Arrays.toString((Object[]) obj);
        } else {
            obj = obj.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(Operation.EQUALS);
        stringBuilder.append(obj);
        return stringBuilder.toString();
    }
}
