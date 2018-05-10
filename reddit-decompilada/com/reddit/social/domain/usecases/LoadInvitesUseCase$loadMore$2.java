package com.reddit.social.domain.usecases;

import com.reddit.social.presentation.presentationobjects.UserData;
import com.sendbird.android.GroupChannel;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a.\u0012*\u0012(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t0\u00020\u00012\u001b\u0010\n\u001a\u0017\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "Lcom/sendbird/android/GroupChannel;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "p1", "Lkotlin/ParameterName;", "name", "channels", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LoadInvitesUseCase.kt */
final class LoadInvitesUseCase$loadMore$2 extends FunctionReference implements Function1<List<? extends GroupChannel>, Observable<Pair<? extends List<? extends GroupChannel>, ? extends Map<String, ? extends UserData>>>> {
    public LoadInvitesUseCase$loadMore$2(LoadInvitesUseCase loadInvitesUseCase) {
        super(1, loadInvitesUseCase);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(LoadInvitesUseCase.class);
    }

    public final String mo5687b() {
        return "fetchUserData";
    }

    public final String mo6932c() {
        return "fetchUserData(Ljava/util/List;)Lio/reactivex/Observable;";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        List list = (List) obj;
        Intrinsics.m26847b(list, "p1");
        return LoadInvitesUseCase.m24491a((LoadInvitesUseCase) this.b, list);
    }
}
