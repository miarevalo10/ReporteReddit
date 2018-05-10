package com.instabug.bug.settings;

import android.net.Uri;
import com.instabug.bug.OnSdkDismissedCallback;
import com.instabug.bug.extendedbugreport.ExtendedBugReport.State;
import com.instabug.bug.model.C0477a;
import com.instabug.bug.model.ReportCategory;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: PerSessionSettings */
public class C0486b {
    private static C0486b f9138j;
    boolean f9139a = false;
    AttachmentsTypesParams f9140b = new AttachmentsTypesParams();
    List<ReportCategory> f9141c;
    OnSdkDismissedCallback f9142d;
    boolean f9143e = true;
    public Runnable f9144f;
    String f9145g;
    List<C0477a> f9146h = new ArrayList();
    State f9147i;
    private LinkedHashMap<Uri, String> f9148k = new LinkedHashMap(3);

    private C0486b() {
    }

    public static void m7828a() {
        f9138j = new C0486b();
    }

    public static C0486b m7829b() {
        return f9138j;
    }
}
