package com.reddit.social.util;

import android.content.Context;
import android.widget.Toast;
import com.sendbird.android.SendBird;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: DebugChatUtil.kt */
final class DebugChatUtilKt$toggleChatConnectionDebugTest$2<T> implements Consumer<Long> {
    final /* synthetic */ Context f29972a;

    DebugChatUtilKt$toggleChatConnectionDebugTest$2(Context context) {
        this.f29972a = context;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = this.f29972a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f25295a;
        StringBuilder stringBuilder = new StringBuilder("SendBird connection state: ");
        stringBuilder.append(SendBird.m24995h().name());
        Object format = String.format(stringBuilder.toString(), Arrays.copyOf(new Object[0], 0));
        Intrinsics.m26843a(format, "java.lang.String.format(format, *args)");
        Toast.makeText(obj, (CharSequence) format, 0).show();
    }
}
