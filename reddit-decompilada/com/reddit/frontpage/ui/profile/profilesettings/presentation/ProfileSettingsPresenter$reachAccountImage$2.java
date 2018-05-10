package com.reddit.frontpage.ui.profile.profilesettings.presentation;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "reachable", "", "apply", "(Ljava/lang/Boolean;)Ljava/lang/String;"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileSettingsPresenter.kt */
final class ProfileSettingsPresenter$reachAccountImage$2<T, R> implements Function<T, R> {
    final /* synthetic */ String f29248a;

    ProfileSettingsPresenter$reachAccountImage$2(String str) {
        this.f29248a = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Boolean bool = (Boolean) obj;
        Intrinsics.m26847b(bool, "reachable");
        if (bool.booleanValue() != null) {
            return this.f29248a;
        }
        StringBuilder stringBuilder = new StringBuilder("Url ");
        stringBuilder.append(this.f29248a);
        stringBuilder.append(" is not reachable");
        throw ((Throwable) new Exception(stringBuilder.toString()));
    }
}
