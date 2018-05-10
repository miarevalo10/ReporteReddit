package com.instabug.chat.p036c;

import android.content.Context;
import android.net.Uri;
import com.instabug.chat.model.Attachment;
import com.instabug.chat.ui.C0559a;
import com.instabug.library.screenshot.ExtraScreenshotHelper;
import com.instabug.library.screenshot.ExtraScreenshotHelper.OnCaptureListener;
import com.instabug.library.util.InstabugSDKLogger;
import java.lang.ref.WeakReference;

/* compiled from: ScreenshotHelper */
public class C1300a implements OnCaptureListener {
    private static C1300a f15363d;
    public WeakReference<Context> f15364a;
    public ExtraScreenshotHelper f15365b = new ExtraScreenshotHelper();
    public String f15366c;

    private C1300a() {
    }

    public static C1300a m15264a() {
        if (f15363d == null) {
            f15363d = new C1300a();
        }
        return f15363d;
    }

    public void onExtraScreenshotCaptured(Uri uri) {
        StringBuilder stringBuilder = new StringBuilder("Uri: ");
        stringBuilder.append(uri);
        InstabugSDKLogger.m8360v(C1300a.class, stringBuilder.toString());
        this.f15365b.release();
        if (this.f15364a != null) {
            Context context = (Context) this.f15364a.get();
            if (context != null) {
                String str = this.f15366c;
                Attachment attachment = new Attachment();
                attachment.setState(Attachment.STATE_OFFLINE);
                attachment.setType(Attachment.TYPE_IMAGE).setLocalPath(uri.getPath()).setName(uri.getLastPathSegment());
                context.startActivity(C0559a.m7966a(context, str, attachment));
            }
        }
    }
}
