package kotlin.reflect.jvm.internal.impl.renderer;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: DescriptorRenderer.kt */
public enum RenderingFormat {
    ;

    /* compiled from: DescriptorRenderer.kt */
    static final class HTML extends RenderingFormat {
        HTML(String str) {
            super(str, 1);
        }

        public final String mo5913a(String str) {
            Intrinsics.m26847b(str, "string");
            return StringsKt__StringsJVMKt.m41942a(StringsKt__StringsJVMKt.m41942a(str, Operation.LESS_THAN, "&lt;"), Operation.GREATER_THAN, "&gt;");
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    static final class PLAIN extends RenderingFormat {
        public final String mo5913a(String str) {
            Intrinsics.m26847b(str, "string");
            return str;
        }

        PLAIN(String str) {
            super(str, 0);
        }
    }

    public abstract String mo5913a(String str);
}
