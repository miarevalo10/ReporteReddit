package android.support.v7.preference.internal;

import android.content.Context;
import android.support.v7.preference.DialogPreference;
import android.util.AttributeSet;
import java.util.Set;

public abstract class AbstractMultiSelectListPreference extends DialogPreference {
    public abstract CharSequence[] mo488f();

    public abstract Set<String> mo3186g();

    public abstract CharSequence[] m16810i();

    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
