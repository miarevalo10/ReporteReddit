package com.reddit.social.presentation.groupchat.view;

import com.reddit.social.presentation.groupchat.ChatSettingsContract.Presenter;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "", "index", "", "apply", "(Ljava/lang/Integer;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingSettingsScreen.kt */
final class MessagingSettingsScreen$showUserReportDialog$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ MessagingSettingsScreen f29871a;
    final /* synthetic */ UserData f29872b;
    final /* synthetic */ List f29873c;

    MessagingSettingsScreen$showUserReportDialog$1(MessagingSettingsScreen messagingSettingsScreen, UserData userData, List list) {
        this.f29871a = messagingSettingsScreen;
        this.f29872b = userData;
        this.f29873c = list;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Integer num = (Integer) obj;
        Intrinsics.m26847b(num, "index");
        Presenter w = this.f29871a.m41360w();
        String str = this.f29872b.f22465b;
        String str2 = this.f29872b.f22464a;
        obj = this.f29873c.get(num.intValue());
        Intrinsics.m26843a(obj, "reasons[index]");
        return w.mo5178a(str, str2, (String) obj);
    }
}
