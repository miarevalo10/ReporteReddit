package kotlin.reflect.jvm.internal.impl.name;

import io.fabric.sdk.android.services.events.EventsFilesManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: NameUtils.kt */
public final class NameUtils {
    public static final NameUtils f25868a = null;
    private static final Regex f25869b = null;

    static {
        NameUtils nameUtils = new NameUtils();
    }

    private NameUtils() {
        f25868a = this;
        f25869b = new Regex("[^\\p{L}\\p{Digit}]");
    }

    public static final String m27431a(String str) {
        Intrinsics.m26847b(str, "name");
        return f25869b.m28146a(str, EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
    }
}
