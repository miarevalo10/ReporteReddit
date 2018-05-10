package com.reddit.frontpage.ui.submit;

import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "flairList", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: BaseSubmitScreen.kt */
final class BaseSubmitScreen$setupFlair$4 extends Lambda implements Function1<List<LinkFlair>, Unit> {
    final /* synthetic */ BaseSubmitScreen f37390a;

    BaseSubmitScreen$setupFlair$4(BaseSubmitScreen baseSubmitScreen) {
        this.f37390a = baseSubmitScreen;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        List list = (List) obj;
        if (list.isEmpty()) {
            this.f37390a.ak();
        } else {
            this.f37390a.flairList = list;
            this.f37390a.m39511a(this.f37390a.flair, this.f37390a.flairTextEdit);
        }
        return Unit.f25273a;
    }
}
