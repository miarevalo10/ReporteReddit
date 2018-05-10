package com.instabug.library.instacapture.screenshot;

import android.app.Activity;
import android.graphics.Bitmap;
import com.instabug.library.instacapture.p021a.C0664b;
import rx.Observable;
import rx.functions.Func0;

/* compiled from: ViewsBitmapObservable */
public final class C0672b {
    public static Observable<Bitmap> m8183a(final Activity activity, final int[] iArr) {
        return Observable.a(new Func0<Observable<Bitmap>>() {
            public final /* synthetic */ Object call() {
                Bitmap screenshotBitmap = ScreenshotTaker.getScreenshotBitmap(activity, iArr);
                if (screenshotBitmap != null) {
                    return Observable.b(screenshotBitmap);
                }
                return Observable.b(new C0664b());
            }
        });
    }
}
