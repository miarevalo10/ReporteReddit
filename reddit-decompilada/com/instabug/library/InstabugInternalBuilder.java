package com.instabug.library;

import android.content.Context;
import com.instabug.library.Instabug.Builder;
import com.instabug.library.invocation.InstabugInvocationEvent;

public class InstabugInternalBuilder {
    public static Instabug buildInstabug(Context context) {
        return new Builder(context, "f501f761142981d54b1fdea93963a934", InstabugInvocationEvent.FLOATING_BUTTON).build();
    }
}
