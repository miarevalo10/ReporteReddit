package kotlin.text;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "startIndex", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: Strings.kt */
final class StringsKt__StringsKt$rangesDelimitedBy$4 extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ List f38975a;
    final /* synthetic */ boolean f38976b = false;

    StringsKt__StringsKt$rangesDelimitedBy$4(List list) {
        this.f38975a = list;
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        CharSequence charSequence = (CharSequence) obj;
        int intValue = ((Number) obj2).intValue();
        Intrinsics.m26847b(charSequence, "$receiver");
        obj = StringsKt__StringsKt.m42450a(charSequence, (Collection) this.f38975a, intValue, this.f38976b);
        return obj != null ? TuplesKt.m26780a(obj.f25267a, Integer.valueOf(((String) obj.f25268b).length())) : null;
    }
}
