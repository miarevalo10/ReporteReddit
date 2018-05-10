package com.reddit.frontpage.ui.submit;

import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "input", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkFlairSelectScreen.kt */
final class LinkFlairSelectScreen$showCustomFlairDialog$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ LinkFlairSelectScreen f37391a;
    final /* synthetic */ LinkFlair f37392b;

    LinkFlairSelectScreen$showCustomFlairDialog$1(LinkFlairSelectScreen linkFlairSelectScreen, LinkFlair linkFlair) {
        this.f37391a = linkFlairSelectScreen;
        this.f37392b = linkFlair;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "input");
        if (!TextUtils.equals(str, this.f37392b.getText())) {
            Map map = this.f37391a.flairEdits;
            Object id = this.f37392b.getId();
            Intrinsics.m26843a(id, "editableFlair.id");
            map.put(id, str);
            this.f37391a.m39555a(this.f37392b);
        }
        return Unit.f25273a;
    }
}
