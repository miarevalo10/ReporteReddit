package com.reddit.social.domain.usecases;

import com.reddit.social.domain.functions.RawMessagesBatch;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\b0\u00020\u00012\u0015\u0010\t\u001a\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lcom/reddit/social/domain/functions/RawMessagesBatch;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "p1", "Lkotlin/ParameterName;", "name", "batch", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LoadMessagesUseCase.kt */
final class LoadMessagesUseCase$load$1 extends FunctionReference implements Function1<RawMessagesBatch, Observable<Pair<? extends RawMessagesBatch, ? extends Map<String, ? extends UserData>>>> {
    LoadMessagesUseCase$load$1(LoadMessagesUseCase loadMessagesUseCase) {
        super(1, loadMessagesUseCase);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(LoadMessagesUseCase.class);
    }

    public final String mo5687b() {
        return "fetchUsersData";
    }

    public final String mo6932c() {
        return "fetchUsersData(Lcom/reddit/social/domain/functions/RawMessagesBatch;)Lio/reactivex/Observable;";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        RawMessagesBatch rawMessagesBatch = (RawMessagesBatch) obj;
        Intrinsics.m26847b(rawMessagesBatch, "p1");
        return LoadMessagesUseCase.m24493a((LoadMessagesUseCase) this.b, rawMessagesBatch);
    }
}
