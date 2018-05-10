package com.reddit.frontpage.presentation.dialogs.customreports;

import android.net.Uri;
import android.text.TextUtils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.RedditThemedActivity;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: CustomReportReasonsDialog.kt */
final class C2297x181551da<T> implements Consumer<String> {
    final /* synthetic */ CustomReportReasonsDialog$getSendReportWithComplaintConsumable$1 f28198a;
    final /* synthetic */ String f28199b;

    C2297x181551da(CustomReportReasonsDialog$getSendReportWithComplaintConsumable$1 customReportReasonsDialog$getSendReportWithComplaintConsumable$1, String str) {
        this.f28198a = customReportReasonsDialog$getSendReportWithComplaintConsumable$1;
        this.f28199b = str;
    }

    public final /* synthetic */ void mo4813a(Object obj) {
        obj = "";
        if (TextUtils.equals(this.f28199b, Util.m24027f((int) C1761R.string.option_reason_copyright))) {
            obj = Util.m24027f((int) C1761R.string.url_copiright_complaint);
            Intrinsics.m26843a(obj, "Util.getString(R.string.url_copiright_complaint)");
        } else if (TextUtils.equals(this.f28199b, Util.m24027f((int) C1761R.string.option_reason_trademark))) {
            obj = Util.m24027f((int) C1761R.string.url_trademark_complaint);
            Intrinsics.m26843a(obj, "Util.getString(R.string.url_trademark_complaint)");
        }
        Util.m23973a((RedditThemedActivity) Util.m24025f(this.f28198a.f28205f), Uri.parse(obj), null);
    }
}
