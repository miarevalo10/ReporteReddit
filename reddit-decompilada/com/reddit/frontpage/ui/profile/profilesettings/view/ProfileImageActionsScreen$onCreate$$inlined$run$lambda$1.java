package com.reddit.frontpage.ui.profile.profilesettings.view;

import android.view.View;
import com.reddit.frontpage.ui.profile.profilesettings.model.ImageAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileImageActionsScreen.kt */
final class ProfileImageActionsScreen$onCreate$$inlined$run$lambda$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ ImageAction f37331a;
    final /* synthetic */ ProfileImageActionsScreen f37332b;
    final /* synthetic */ List f37333c;

    ProfileImageActionsScreen$onCreate$$inlined$run$lambda$1(ImageAction imageAction, ProfileImageActionsScreen profileImageActionsScreen, List list) {
        this.f37331a = imageAction;
        this.f37332b = profileImageActionsScreen;
        this.f37333c = list;
        super(1);
    }

    public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
        ProfileImageActionsScreen.m39412a(this.f37332b, this.f37331a);
        return Unit.f25273a;
    }
}
