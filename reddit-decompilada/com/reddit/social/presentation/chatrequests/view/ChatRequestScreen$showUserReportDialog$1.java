package com.reddit.social.presentation.chatrequests.view;

import com.reddit.social.presentation.chatrequests.ChatRequestContract.Presenter;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "", "index", "", "apply", "(Ljava/lang/Integer;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRequestScreen.kt */
final class ChatRequestScreen$showUserReportDialog$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ ChatRequestScreen f29679a;
    final /* synthetic */ UserData f29680b;
    final /* synthetic */ List f29681c;

    ChatRequestScreen$showUserReportDialog$1(ChatRequestScreen chatRequestScreen, UserData userData, List list) {
        this.f29679a = chatRequestScreen;
        this.f29680b = userData;
        this.f29681c = list;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Integer num = (Integer) obj;
        Intrinsics.m26847b(num, "index");
        Presenter w = this.f29679a.m41233w();
        String str = this.f29680b.f22465b;
        String str2 = this.f29680b.f22464a;
        obj = this.f29681c.get(num.intValue());
        Intrinsics.m26843a(obj, "reasons[index]");
        return w.mo5122a(str, str2, (String) obj);
    }
}
