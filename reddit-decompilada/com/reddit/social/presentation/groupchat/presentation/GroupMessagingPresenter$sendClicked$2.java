package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.sendbird.android.BaseMessage;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a,\u0012(\u0012&\u0012\u0004\u0012\u00020\u0003\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00020\u00020\u00012!\u0010\b\u001a\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "Lcom/sendbird/android/BaseMessage;", "", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "p1", "Lkotlin/ParameterName;", "name", "pair", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$sendClicked$2 extends FunctionReference implements Function1<Pair<? extends SentStatus, ? extends BaseMessage>, Observable<Pair<? extends SentStatus, ? extends Pair<? extends BaseMessage, ? extends Map<String, ? extends UserData>>>>> {
    GroupMessagingPresenter$sendClicked$2(GroupMessagingPresenter groupMessagingPresenter) {
        super(1, groupMessagingPresenter);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(GroupMessagingPresenter.class);
    }

    public final String mo5687b() {
        return "fetchUserData";
    }

    public final String mo6932c() {
        return "fetchUserData(Lkotlin/Pair;)Lio/reactivex/Observable;";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.m26847b(pair, "p1");
        return GroupMessagingPresenter.m30777a((GroupMessagingPresenter) this.b, pair);
    }
}
