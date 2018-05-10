package com.reddit.frontpage.ui.profile.profilesettings.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ui.view.RedditBottomSheetDialog;
import com.reddit.frontpage.ui.profile.profilesettings.model.ImageAction;
import com.reddit.frontpage.ui.profile.profilesettings.model.ImageActions;
import com.reddit.frontpage.ui.profile.profilesettings.model.ImageType;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0002J'\u0010\u0012\u001a\u00020\f*\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u00152\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0017R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/view/ProfileImageActionsScreen;", "Lcom/reddit/frontpage/presentation/common/ui/view/RedditBottomSheetDialog;", "context", "Landroid/content/Context;", "imageActions", "Lcom/reddit/frontpage/ui/profile/profilesettings/model/ImageActions;", "actionSelected", "Lkotlin/Function1;", "Lcom/reddit/frontpage/ui/profile/profilesettings/model/ImageAction;", "Lkotlin/ParameterName;", "name", "action", "", "(Landroid/content/Context;Lcom/reddit/frontpage/ui/profile/profilesettings/model/ImageActions;Lkotlin/jvm/functions/Function1;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSelect", "setIcon", "Landroid/widget/TextView;", "drawableRes", "", "tint", "(Landroid/widget/TextView;ILjava/lang/Integer;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ProfileImageActionsScreen.kt */
public final class ProfileImageActionsScreen extends RedditBottomSheetDialog {
    private final ImageActions f39268d;
    private final Function1<ImageAction, Unit> f39269e;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f21573a;

        static {
            int[] iArr = new int[ImageType.values().length];
            f21573a = iArr;
            iArr[ImageType.f21564a.ordinal()] = 1;
            f21573a[ImageType.f21565b.ordinal()] = 2;
        }
    }

    public ProfileImageActionsScreen(Context context, ImageActions imageActions, Function1<? super ImageAction, Unit> function1) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(imageActions, "imageActions");
        Intrinsics.m26847b(function1, "actionSelected");
        super(context);
        this.f39268d = imageActions;
        this.f39269e = function1;
    }

    protected final void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        setContentView((int) C1761R.layout.profile_image_options);
        bundle = getContext();
        switch (WhenMappings.f21573a[this.f39268d.f21562e.ordinal()]) {
            case 1:
                i = C1761R.string.profile_image_options_avatar_title;
                break;
            case 2:
                i = C1761R.string.profile_image_options_banner_title;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        m36781a((String) bundle.getString(i));
        bundle = this.f39268d.f21563f;
        ImageAction imageAction = ImageAction.f21552a;
        Object obj = (TextView) findViewById(C1761R.id.option_camera);
        Intrinsics.m26843a(obj, "option_camera");
        ViewsKt.m24106b((View) obj, bundle.contains(imageAction));
        obj = (TextView) findViewById(C1761R.id.option_camera);
        Intrinsics.m26843a(obj, "option_camera");
        m39411a(obj, C1761R.drawable.ic_icon_camera, null);
        obj = (TextView) findViewById(C1761R.id.option_camera);
        Intrinsics.m26843a(obj, "option_camera");
        ((View) obj).setOnClickListener(new ProfileImageActionsScreen$inlined$sam$OnClickListener$i$7f478c20(new ProfileImageActionsScreen$onCreate$$inlined$run$lambda$1(imageAction, this, bundle)));
        imageAction = ImageAction.f21553b;
        obj = (TextView) findViewById(C1761R.id.option_library);
        Intrinsics.m26843a(obj, "option_library");
        ViewsKt.m24106b((View) obj, bundle.contains(imageAction));
        obj = (TextView) findViewById(C1761R.id.option_library);
        Intrinsics.m26843a(obj, "option_library");
        m39411a(obj, C1761R.drawable.ic_view_gallery, null);
        obj = (TextView) findViewById(C1761R.id.option_library);
        Intrinsics.m26843a(obj, "option_library");
        ((View) obj).setOnClickListener(new ProfileImageActionsScreen$inlined$sam$OnClickListener$i$7f478c20(new ProfileImageActionsScreen$onCreate$$inlined$run$lambda$2(imageAction, this, bundle)));
        imageAction = ImageAction.f21554c;
        obj = (TextView) findViewById(C1761R.id.option_restore_default_avatar);
        Intrinsics.m26843a(obj, "option_restore_default_avatar");
        ViewsKt.m24106b((View) obj, bundle.contains(imageAction));
        obj = (TextView) findViewById(C1761R.id.option_restore_default_avatar);
        Intrinsics.m26843a(obj, "option_restore_default_avatar");
        m39411a(obj, C1761R.drawable.ic_icon_clear, Integer.valueOf(C1761R.color.rdt_red));
        obj = (TextView) findViewById(C1761R.id.option_restore_default_avatar);
        Intrinsics.m26843a(obj, "option_restore_default_avatar");
        ((View) obj).setOnClickListener(new ProfileImageActionsScreen$inlined$sam$OnClickListener$i$7f478c20(new ProfileImageActionsScreen$onCreate$$inlined$run$lambda$3(imageAction, this, bundle)));
        imageAction = ImageAction.f21555d;
        obj = (TextView) findViewById(C1761R.id.option_remove_banner);
        Intrinsics.m26843a(obj, "option_remove_banner");
        ViewsKt.m24106b((View) obj, bundle.contains(imageAction));
        obj = (TextView) findViewById(C1761R.id.option_remove_banner);
        Intrinsics.m26843a(obj, "option_remove_banner");
        m39411a(obj, C1761R.drawable.ic_icon_delete, Integer.valueOf(C1761R.color.rdt_red));
        obj = (TextView) findViewById(C1761R.id.option_remove_banner);
        Intrinsics.m26843a(obj, "option_remove_banner");
        ((View) obj).setOnClickListener((OnClickListener) new ProfileImageActionsScreen$inlined$sam$OnClickListener$i$7f478c20(new ProfileImageActionsScreen$onCreate$$inlined$run$lambda$4(imageAction, this, bundle)));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m39411a(android.widget.TextView r2, int r3, java.lang.Integer r4) {
        /*
        if (r4 == 0) goto L_0x0028;
    L_0x0002:
        r0 = r4;
        r0 = (java.lang.Number) r0;
        r0.intValue();
        r0 = r2.getContext();
        r1 = "context";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r1);
        r4 = r4.intValue();
        r4 = com.reddit.frontpage.presentation.common.ResourcesUtil.m22727c(r0, r3, r4);
        r0 = r2.getContext();
        r1 = "context";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r1);
        r4 = com.reddit.frontpage.presentation.common.ResourcesUtil.m22728c(r0, r4);
        if (r4 != 0) goto L_0x0035;
    L_0x0028:
        r4 = r2.getContext();
        r0 = "context";
        kotlin.jvm.internal.Intrinsics.m26843a(r4, r0);
        r4 = com.reddit.frontpage.presentation.common.ResourcesUtil.m22729d(r4, r3);
    L_0x0035:
        r3 = 0;
        r2.setCompoundDrawablesRelative(r4, r3, r3, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.ui.profile.profilesettings.view.ProfileImageActionsScreen.a(android.widget.TextView, int, java.lang.Integer):void");
    }

    public static final /* synthetic */ void m39412a(ProfileImageActionsScreen profileImageActionsScreen, ImageAction imageAction) {
        profileImageActionsScreen.f39269e.mo6492a(imageAction);
        profileImageActionsScreen.dismiss();
    }
}
