package com.reddit.frontpage.util;

import android.content.Context;
import android.content.Intent;
import com.reddit.datalibrary.frontpage.service.api.SubmitService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jo\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0002\b\u0014H\u0002J^\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0007J^\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0007J^\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/util/SubmitUtil;", "", "()V", "submit", "", "context", "Landroid/content/Context;", "submitIdentifier", "", "subreddit", "title", "location", "latitude", "", "longitude", "flairText", "flairId", "onIntentBuilt", "Lkotlin/Function1;", "Landroid/content/Intent;", "Lkotlin/ExtensionFunctionType;", "submitImage", "imageLink", "submitLink", "link", "submitSelf", "text", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubmitUtil.kt */
public final class SubmitUtil {
    public static final SubmitUtil f21802a = new SubmitUtil();

    private SubmitUtil() {
    }

    public static final void m23908a(Context context, String str, String str2, String str3, String str4, String str5, double d, double d2, String str6, String str7) {
        String str8 = str4;
        Context context2 = context;
        Intrinsics.m26847b(context2, "context");
        String str9 = str;
        Intrinsics.m26847b(str9, "submitIdentifier");
        String str10 = str2;
        Intrinsics.m26847b(str10, "subreddit");
        String str11 = str3;
        Intrinsics.m26847b(str11, "title");
        Intrinsics.m26847b(str8, "text");
        m23907a(context2, str9, str10, str11, str5, d, d2, str6, str7, (Function1) new SubmitUtil$submitSelf$1(str8));
    }

    public static final void m23909b(Context context, String str, String str2, String str3, String str4, String str5, double d, double d2, String str6, String str7) {
        String str8 = str4;
        Context context2 = context;
        Intrinsics.m26847b(context2, "context");
        String str9 = str;
        Intrinsics.m26847b(str9, "submitIdentifier");
        String str10 = str2;
        Intrinsics.m26847b(str10, "subreddit");
        String str11 = str3;
        Intrinsics.m26847b(str11, "title");
        Intrinsics.m26847b(str8, "link");
        m23907a(context2, str9, str10, str11, str5, d, d2, str6, str7, (Function1) new SubmitUtil$submitLink$1(str8));
    }

    public static final void m23910c(Context context, String str, String str2, String str3, String str4, String str5, double d, double d2, String str6, String str7) {
        String str8 = str4;
        Context context2 = context;
        Intrinsics.m26847b(context2, "context");
        String str9 = str;
        Intrinsics.m26847b(str9, "submitIdentifier");
        String str10 = str2;
        Intrinsics.m26847b(str10, "subreddit");
        String str11 = str3;
        Intrinsics.m26847b(str11, "title");
        Intrinsics.m26847b(str8, "imageLink");
        m23907a(context2, str9, str10, str11, str5, d, d2, str6, str7, (Function1) new SubmitUtil$submitImage$1(str8));
    }

    private static void m23907a(Context context, String str, String str2, String str3, String str4, double d, double d2, String str5, String str6, Function1<? super Intent, Unit> function1) {
        Intent intent = new Intent(context, SubmitService.class);
        intent.putExtra(SubmitService.EXTRA_REQUEST_ID, str);
        intent.putExtra(SubmitService.EXTRA_SUBREDDIT, str2);
        intent.putExtra(SubmitService.EXTRA_TITLE, str3);
        str = SubmitService.EXTRA_LOCATION;
        if (str4 == null) {
            str4 = "";
        }
        intent.putExtra(str, str4);
        intent.putExtra(SubmitService.EXTRA_LATITUDE, String.valueOf(d));
        intent.putExtra(SubmitService.EXTRA_LONGITUDE, String.valueOf(d2));
        intent.putExtra(SubmitService.EXTRA_FLAIR_TEXT, str5);
        intent.putExtra(SubmitService.EXTRA_FLAIR_ID, str6);
        function1.mo6492a(intent);
        context.startService(intent);
    }
}
