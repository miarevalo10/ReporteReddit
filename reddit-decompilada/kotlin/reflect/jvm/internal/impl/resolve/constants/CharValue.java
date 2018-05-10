package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class CharValue extends IntegerValueConstant<Character> {
    private final SimpleType f36144a;

    public CharValue(char c, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        super(Character.valueOf(c));
        this.f36144a = kotlinBuiltIns.m27024v();
    }

    public final String toString() {
        String str;
        String str2 = "\\u%04X ('%s')";
        r2 = new Object[2];
        int i = 0;
        r2[0] = Integer.valueOf(((Character) mo5919b()).charValue());
        char charValue = ((Character) mo5919b()).charValue();
        switch (charValue) {
            case '\b':
                str = "\\b";
                break;
            case '\t':
                str = "\\t";
                break;
            case '\n':
                str = "\\n";
                break;
            case '\f':
                str = "\\f";
                break;
            case '\r':
                str = "\\r";
                break;
            default:
                byte type = (byte) Character.getType(charValue);
                if (!(type == (byte) 0 || type == (byte) 13 || type == (byte) 14 || type == (byte) 15 || type == (byte) 16 || type == (byte) 18 || type == (byte) 19)) {
                    i = 1;
                }
                if (i == 0) {
                    str = Operation.EMPTY_PARAM;
                    break;
                }
                str = Character.toString(charValue);
                Intrinsics.m26843a((Object) str, "Character.toString(c)");
                break;
        }
        r2[1] = str;
        Object format = String.format(str2, Arrays.copyOf(r2, 2));
        Intrinsics.m26843a(format, "java.lang.String.format(this, *args)");
        return format;
    }

    public final /* bridge */ /* synthetic */ KotlinType mo5917a() {
        return this.f36144a;
    }
}
