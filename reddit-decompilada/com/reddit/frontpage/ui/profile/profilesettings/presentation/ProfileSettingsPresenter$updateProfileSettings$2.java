package com.reddit.frontpage.ui.profile.profilesettings.presentation;

import com.reddit.frontpage.domain.repository.AccountRepository;
import io.reactivex.Completable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "p1", "", "", "Lkotlin/ParameterName;", "name", "params", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileSettingsPresenter.kt */
final class ProfileSettingsPresenter$updateProfileSettings$2 extends FunctionReference implements Function1<Map<String, ? extends String>, Completable> {
    ProfileSettingsPresenter$updateProfileSettings$2(AccountRepository accountRepository) {
        super(1, accountRepository);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(AccountRepository.class);
    }

    public final String mo5687b() {
        return "updateUserSubredditSettings";
    }

    public final String mo6932c() {
        return "updateUserSubredditSettings(Ljava/util/Map;)Lio/reactivex/Completable;";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Map map = (Map) obj;
        Intrinsics.m26847b(map, "p1");
        return ((AccountRepository) this.b).m22392a(map);
    }
}
