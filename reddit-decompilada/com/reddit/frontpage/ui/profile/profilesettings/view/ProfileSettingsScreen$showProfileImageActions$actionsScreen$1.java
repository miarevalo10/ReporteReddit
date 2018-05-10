package com.reddit.frontpage.ui.profile.profilesettings.view;

import com.reddit.frontpage.ui.profile.profilesettings.model.ImageAction;
import com.reddit.frontpage.ui.profile.profilesettings.model.ImageType;
import com.reddit.frontpage.ui.profile.profilesettings.view.ProfileSettingsScreen.WhenMappings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "action", "Lcom/reddit/frontpage/ui/profile/profilesettings/model/ImageAction;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileSettingsScreen.kt */
final class ProfileSettingsScreen$showProfileImageActions$actionsScreen$1 extends Lambda implements Function1<ImageAction, Unit> {
    final /* synthetic */ ProfileSettingsScreen f37362a;
    final /* synthetic */ ImageType f37363b;

    ProfileSettingsScreen$showProfileImageActions$actionsScreen$1(ProfileSettingsScreen profileSettingsScreen, ImageType imageType) {
        this.f37362a = profileSettingsScreen;
        this.f37363b = imageType;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ImageAction imageAction = (ImageAction) obj;
        Intrinsics.m26847b(imageAction, "action");
        switch (WhenMappings.f21575a[imageAction.ordinal()]) {
            case 1:
                ProfileSettingsScreen.m39425a(this.f37362a, this.f37363b);
                break;
            case 2:
                ProfileSettingsScreen.m39427b(this.f37362a, this.f37363b);
                break;
            case 3:
                this.f37362a.m39454w().m35167a();
                break;
            case 4:
                this.f37362a.m39454w().m35171b();
                break;
            default:
                break;
        }
        return Unit.f25273a;
    }
}
