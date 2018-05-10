package com.instabug.bug.screenshot;

import android.content.Context;
import android.net.Uri;
import com.instabug.bug.C0469b;
import com.instabug.bug.C0474d;
import com.instabug.library.model.Attachment.Type;
import com.instabug.library.screenshot.ExtraScreenshotHelper;
import com.instabug.library.screenshot.ExtraScreenshotHelper.OnCaptureListener;
import com.instabug.library.util.InstabugSDKLogger;
import java.lang.ref.WeakReference;

/* compiled from: ScreenshotHelper */
public class C1268a implements OnCaptureListener {
    private static C1268a f15329c;
    public WeakReference<Context> f15330a;
    public ExtraScreenshotHelper f15331b = new ExtraScreenshotHelper();

    private C1268a() {
    }

    public static C1268a m15217a() {
        if (f15329c == null) {
            f15329c = new C1268a();
        }
        return f15329c;
    }

    public void onExtraScreenshotCaptured(Uri uri) {
        StringBuilder stringBuilder = new StringBuilder("Uri: ");
        stringBuilder.append(uri);
        InstabugSDKLogger.m8360v(C1268a.class, stringBuilder.toString());
        this.f15331b.release();
        C0474d.m7762a().f9100a.m15214a(uri, Type.IMAGE);
        if (this.f15330a != null) {
            Context context = (Context) this.f15330a.get();
            if (context != null) {
                context.startActivity(C0469b.m7755c(context));
            }
        }
    }
}
