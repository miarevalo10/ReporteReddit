package com.reddit.social.util;

import android.content.Context;
import com.reddit.frontpage.util.SchedulerProvider;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"sub", "Lio/reactivex/disposables/Disposable;", "toggleChatConnectionDebugTest", "", "context", "Landroid/content/Context;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: DebugChatUtil.kt */
public final class DebugChatUtilKt {
    private static Disposable f22482a;

    public static final void m24768a(Context context) {
        Intrinsics.m26847b(context, "context");
        if (f22482a != null) {
            Disposable disposable = f22482a;
            if (disposable == null) {
                Intrinsics.m26842a();
            }
            if (!disposable.mo5627b()) {
                context = f22482a;
                if (context != null) {
                    context.mo5626a();
                    return;
                }
                return;
            }
        }
        f22482a = Observable.interval(5, TimeUnit.SECONDS).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).takeWhile(DebugChatUtilKt$toggleChatConnectionDebugTest$1.f29971a).subscribe((Consumer) new DebugChatUtilKt$toggleChatConnectionDebugTest$2(context));
    }
}
