package com.reddit.frontpage.ui.share;

import android.content.Intent;
import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "tempFile", "Ljava/io/File;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ShareActivity.kt */
final class ShareActivity$onCreate$3 extends Lambda implements Function1<File, Unit> {
    final /* synthetic */ ShareActivity f37382a;

    ShareActivity$onCreate$3(ShareActivity shareActivity) {
        this.f37382a = shareActivity;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        final File file = (File) obj;
        this.f37382a.m42747a((Function1) new Function1<Intent, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                Intent intent = (Intent) obj;
                Intrinsics.m26847b(intent, "$receiver");
                Object obj2 = file;
                Intrinsics.m26843a(obj2, "tempFile");
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(obj2.getAbsolutePath()));
                return Unit.f25273a;
            }
        });
        return Unit.f25273a;
    }
}
