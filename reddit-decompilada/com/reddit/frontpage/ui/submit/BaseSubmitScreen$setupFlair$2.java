package com.reddit.frontpage.ui.submit;

import com.reddit.datalibrary.frontpage.data.provider.FlairProvider;
import com.reddit.frontpage.util.SubredditUtil;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a^\u0012(\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00050\u0002 \u0004*.\u0012(\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00050\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lio/reactivex/Flowable;", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "kotlin.jvm.PlatformType", "", "subredditName", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: BaseSubmitScreen.kt */
final class BaseSubmitScreen$setupFlair$2<T, R> implements Function<T, Publisher<? extends R>> {
    public static final BaseSubmitScreen$setupFlair$2 f29305a = new BaseSubmitScreen$setupFlair$2();

    BaseSubmitScreen$setupFlair$2() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "subredditName");
        FlairProvider flairProvider = new FlairProvider();
        return FlairProvider.a(SubredditUtil.m23912a(str));
    }
}
