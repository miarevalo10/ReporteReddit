package com.instabug.bug;

import android.content.Context;
import android.content.Intent;
import com.instabug.bug.view.BugReportingActivity;

/* compiled from: BugReportingActivityLauncher */
public class C0469b {
    public static Intent m7753a(Context context) {
        Intent intent = new Intent(context, BugReportingActivity.class);
        intent.putExtra("com.instabug.library.process", 162);
        intent.setFlags(268435456);
        intent.addFlags(65536);
        return intent;
    }

    public static Intent m7754b(Context context) {
        Intent intent = new Intent(context, BugReportingActivity.class);
        intent.putExtra("com.instabug.library.process", 161);
        intent.setFlags(268435456);
        intent.addFlags(65536);
        return intent;
    }

    public static Intent m7755c(Context context) {
        Intent intent = new Intent(context, BugReportingActivity.class);
        intent.putExtra("com.instabug.library.process", 167);
        intent.addFlags(65536);
        intent.addFlags(268435456);
        return intent;
    }

    static Intent m7756d(Context context) {
        Intent intent = new Intent(context, BugReportingActivity.class);
        intent.putExtra("com.instabug.library.process", 169);
        intent.addFlags(65536);
        return intent;
    }
}
