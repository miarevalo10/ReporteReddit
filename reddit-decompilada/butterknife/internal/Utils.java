package butterknife.internal;

import android.util.TypedValue;
import android.view.View;

public final class Utils {
    private static final TypedValue f2748a = new TypedValue();

    public static <T> T m2434a(View view, int i, String str, Class<T> cls) {
        return m2437c(view.findViewById(i), i, str, cls);
    }

    public static View m2433a(View view, int i, String str) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        view = m2435a(view, i);
        StringBuilder stringBuilder = new StringBuilder("Required view '");
        stringBuilder.append(view);
        stringBuilder.append("' with ID ");
        stringBuilder.append(i);
        stringBuilder.append(" for ");
        stringBuilder.append(str);
        stringBuilder.append(" was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public static <T> T m2436b(View view, int i, String str, Class<T> cls) {
        return m2437c(m2433a(view, i, str), i, str, cls);
    }

    public static <T> T m2437c(View view, int i, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (Class<T> cls2) {
            view = m2435a(view, i);
            StringBuilder stringBuilder = new StringBuilder("View '");
            stringBuilder.append(view);
            stringBuilder.append("' with ID ");
            stringBuilder.append(i);
            stringBuilder.append(" for ");
            stringBuilder.append(str);
            stringBuilder.append(" was of the wrong type. See cause for more info.");
            throw new IllegalStateException(stringBuilder.toString(), cls2);
        }
    }

    private static String m2435a(View view, int i) {
        if (view.isInEditMode()) {
            return "<unavailable while editing>";
        }
        return view.getContext().getResources().getResourceEntryName(i);
    }
}
