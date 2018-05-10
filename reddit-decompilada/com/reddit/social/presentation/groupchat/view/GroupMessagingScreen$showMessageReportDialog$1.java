package com.reddit.social.presentation.groupchat.view;

import com.reddit.datalibrary.social.model.ReportMessageKt;
import com.reddit.social.presentation.groupchat.ChatContract.Presenter;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "", "index", "", "apply", "(Ljava/lang/Integer;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingScreen.kt */
final class GroupMessagingScreen$showMessageReportDialog$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ GroupMessagingScreen f29863a;
    final /* synthetic */ HasMessageData f29864b;
    final /* synthetic */ List f29865c;

    GroupMessagingScreen$showMessageReportDialog$1(GroupMessagingScreen groupMessagingScreen, HasMessageData hasMessageData, List list) {
        this.f29863a = groupMessagingScreen;
        this.f29864b = hasMessageData;
        this.f29865c = list;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Integer num = (Integer) obj;
        Intrinsics.m26847b(num, "index");
        Presenter w = this.f29863a.m41332w();
        HasMessageData hasMessageData = this.f29864b;
        obj = this.f29865c.get(num.intValue());
        Intrinsics.m26843a(obj, "reasons[index]");
        return w.mo5160a(hasMessageData, (String) obj, ReportMessageKt.getMessageReportFrom(this.f29864b));
    }
}
