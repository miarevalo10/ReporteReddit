package com.instabug.bug.extendedbugreport;

import android.content.Context;
import com.instabug.bug.C0465R;
import com.instabug.bug.model.C0477a;
import com.instabug.library.util.LocaleUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ExtendedBugReport {

    public enum State {
        DISABLED,
        ENABLED_WITH_REQUIRED_FIELDS,
        ENABLED_WITH_OPTIONAL_FIELDS
    }

    public static List<C0477a> m7771a(Context context, State state) {
        if (state == State.ENABLED_WITH_REQUIRED_FIELDS) {
            return m7772a(context, true);
        }
        return m7772a(context, (boolean) null);
    }

    private static List<C0477a> m7772a(Context context, boolean z) {
        List<C0477a> arrayList = new ArrayList();
        arrayList.add(new C0477a(context.getString(C0465R.string.instabug_str_steps_to_reproduce), LocaleUtils.getLocaleStringResource(Locale.ENGLISH, C0465R.string.instabug_str_steps_to_reproduce, context), z, "repro_steps"));
        arrayList.add(new C0477a(context.getString(C0465R.string.instabug_str_actual_results), LocaleUtils.getLocaleStringResource(Locale.ENGLISH, C0465R.string.instabug_str_actual_results, context), z, "actual_result"));
        arrayList.add(new C0477a(context.getString(C0465R.string.instabug_str_expected_results), LocaleUtils.getLocaleStringResource(Locale.ENGLISH, C0465R.string.instabug_str_expected_results, context), z, "expected_result"));
        return arrayList;
    }
}
