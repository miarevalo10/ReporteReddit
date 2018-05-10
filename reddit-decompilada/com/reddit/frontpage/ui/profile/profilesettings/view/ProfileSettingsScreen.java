package com.reddit.frontpage.ui.profile.profilesettings.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Switch;
import com.bumptech.glide.request.RequestOptions;
import com.evernote.android.state.State;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.requests.images.ImageProgressLoadListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.animation.SnooProgressDrawable;
import com.reddit.frontpage.di.component.DaggerProfileSettingsComponent;
import com.reddit.frontpage.di.component.ProfileSettingsComponent.Builder;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.profile.profilesettings.ProfileSettingsContract.Parameters;
import com.reddit.frontpage.ui.profile.profilesettings.ProfileSettingsContract.View;
import com.reddit.frontpage.ui.profile.profilesettings.model.AccountPresentationModel;
import com.reddit.frontpage.ui.profile.profilesettings.model.ImageAction;
import com.reddit.frontpage.ui.profile.profilesettings.model.ImageActions;
import com.reddit.frontpage.ui.profile.profilesettings.model.ImageType;
import com.reddit.frontpage.ui.profile.profilesettings.presentation.ProfileSettingsPresenter;
import com.reddit.frontpage.util.FileUtil;
import com.reddit.frontpage.util.PermissionUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.InvalidatableLazy;
import com.reddit.frontpage.util.kotlin.LazyKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.ShapedIconView;
import com.reddit.social.presentation.EditTextWithCounter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0002J\b\u0010^\u001a\u00020WH\u0016J\u0010\u0010_\u001a\u00020W2\u0006\u0010`\u001a\u00020aH\u0014J\b\u0010b\u001a\u00020cH\u0016J\b\u0010d\u001a\u00020cH\u0016J\b\u0010e\u001a\u00020WH\u0016J\b\u0010f\u001a\u00020WH\u0016J\u0018\u0010g\u001a\u00020W2\u0006\u0010\\\u001a\u00020]2\u0006\u0010h\u001a\u00020iH\u0002J\b\u0010j\u001a\u00020WH\u0016J\b\u0010k\u001a\u00020WH\u0016J\b\u0010l\u001a\u00020WH\u0016J\b\u0010m\u001a\u00020WH\u0016J\b\u0010n\u001a\u00020WH\u0016J\"\u0010o\u001a\u00020W2\u0006\u0010p\u001a\u00020c2\u0006\u0010q\u001a\u00020c2\b\u0010r\u001a\u0004\u0018\u00010]H\u0016J\b\u0010s\u001a\u00020[H\u0016J\u0018\u0010t\u001a\u00020W2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020xH\u0016J\u0018\u0010y\u001a\u00020%2\u0006\u0010w\u001a\u00020z2\u0006\u0010{\u001a\u00020|H\u0016J\b\u0010}\u001a\u00020WH\u0016J\u0010\u0010~\u001a\u00020W2\u0006\u0010\u001a\u00020%H\u0016J\t\u0010\u0001\u001a\u00020WH\u0014J\u0013\u0010\u0001\u001a\u00020[2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0011\u0010\u0001\u001a\u00020W2\u0006\u0010h\u001a\u00020iH\u0002J\u0014\u0010\u0001\u001a\u00020W2\t\u0010\u0001\u001a\u0004\u0018\u00010QH\u0016J\u0014\u0010\u0001\u001a\u00020W2\t\u0010\u0001\u001a\u0004\u0018\u00010QH\u0016J\t\u0010\u0001\u001a\u00020WH\u0016J\t\u0010\u0001\u001a\u00020WH\u0016J\u0013\u0010\u0001\u001a\u00020W2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0011\u0010\u0001\u001a\u00020W2\u0006\u0010h\u001a\u00020iH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b\u001f\u0010\rR\u001b\u0010!\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b\"\u0010\u0012R\u001b\u0010$\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b(\u0010\t\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\t\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b/\u0010\u001cR\u001b\u00101\u001a\u0002028BX\u0002¢\u0006\f\n\u0004\b5\u0010\t\u001a\u0004\b3\u00104R\u001b\u00106\u001a\u0002078BX\u0002¢\u0006\f\n\u0004\b:\u0010\t\u001a\u0004\b8\u00109R\u001b\u0010;\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b=\u0010\t\u001a\u0004\b<\u0010\u0007R\u001e\u0010>\u001a\u00020?8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001b\u0010D\u001a\u0002028BX\u0002¢\u0006\f\n\u0004\bF\u0010\t\u001a\u0004\bE\u00104R\u001b\u0010G\u001a\u0002078BX\u0002¢\u0006\f\n\u0004\bI\u0010\t\u001a\u0004\bH\u00109R\u001e\u0010J\u001a\u00020K8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001e\u0010P\u001a\u00020Q8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U¨\u0006\u0001"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/view/ProfileSettingsScreen;", "Lcom/reddit/frontpage/ui/BaseScreen;", "Lcom/reddit/frontpage/ui/profile/profilesettings/ProfileSettingsContract$View;", "()V", "aboutField", "Lcom/reddit/social/presentation/EditTextWithCounter;", "getAboutField", "()Lcom/reddit/social/presentation/EditTextWithCounter;", "aboutField$delegate", "Lcom/reddit/frontpage/util/kotlin/InvalidatableLazy;", "avatarCamera", "Landroid/support/v7/widget/AppCompatImageView;", "getAvatarCamera", "()Landroid/support/v7/widget/AppCompatImageView;", "avatarCamera$delegate", "avatarPreloader", "Landroid/widget/ProgressBar;", "getAvatarPreloader", "()Landroid/widget/ProgressBar;", "avatarPreloader$delegate", "avatarView", "Lcom/reddit/frontpage/widgets/ShapedIconView;", "getAvatarView", "()Lcom/reddit/frontpage/widgets/ShapedIconView;", "avatarView$delegate", "avatarViewContainer", "Landroid/widget/FrameLayout;", "getAvatarViewContainer", "()Landroid/widget/FrameLayout;", "avatarViewContainer$delegate", "bannerCamera", "getBannerCamera", "bannerCamera$delegate", "bannerPreloader", "getBannerPreloader", "bannerPreloader$delegate", "bannerShadow", "Landroid/view/View;", "getBannerShadow", "()Landroid/view/View;", "bannerShadow$delegate", "bannerView", "Landroid/widget/ImageView;", "getBannerView", "()Landroid/widget/ImageView;", "bannerView$delegate", "bannerViewContainer", "getBannerViewContainer", "bannerViewContainer$delegate", "contentVisibleRow", "Landroid/widget/LinearLayout;", "getContentVisibleRow", "()Landroid/widget/LinearLayout;", "contentVisibleRow$delegate", "contentVisibleSwitch", "Landroid/widget/Switch;", "getContentVisibleSwitch", "()Landroid/widget/Switch;", "contentVisibleSwitch$delegate", "displayNameField", "getDisplayNameField", "displayNameField$delegate", "presenter", "Lcom/reddit/frontpage/ui/profile/profilesettings/presentation/ProfileSettingsPresenter;", "getPresenter", "()Lcom/reddit/frontpage/ui/profile/profilesettings/presentation/ProfileSettingsPresenter;", "setPresenter", "(Lcom/reddit/frontpage/ui/profile/profilesettings/presentation/ProfileSettingsPresenter;)V", "showActiveRow", "getShowActiveRow", "showActiveRow$delegate", "showActiveSwitch", "getShowActiveSwitch", "showActiveSwitch$delegate", "tempImageFile", "Ljava/io/File;", "getTempImageFile", "()Ljava/io/File;", "setTempImageFile", "(Ljava/io/File;)V", "userSubredditDisplayName", "", "getUserSubredditDisplayName", "()Ljava/lang/String;", "setUserSubredditDisplayName", "(Ljava/lang/String;)V", "bind", "", "account", "Lcom/reddit/frontpage/ui/profile/profilesettings/model/AccountPresentationModel;", "canLaunchCamera", "", "intent", "Landroid/content/Intent;", "closeScreen", "configureActionBar", "actionBar", "Landroid/support/v7/app/ActionBar;", "getDefaultScreenPosition", "", "getLayoutId", "hideAvatarUploading", "hideBannerUploading", "launchCamera", "type", "Lcom/reddit/frontpage/ui/profile/profilesettings/model/ImageType;", "notifyLoadAccountError", "notifyRemoveBannerError", "notifyRestoreAvatarError", "notifySaveError", "notifyUnableLoadImageError", "onActivityResult", "requestCode", "resultCode", "data", "onBackPressed", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "view", "onInitialize", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "openLibraryWithPermissions", "setAvatar", "url", "setBanner", "showAvatarUploading", "showBannerUploading", "showProfileImageActions", "imageActions", "Lcom/reddit/frontpage/ui/profile/profilesettings/model/ImageActions;", "takePhotoWithPermissions", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ProfileSettingsScreen.kt */
public final class ProfileSettingsScreen extends BaseScreen implements View {
    static final /* synthetic */ KProperty[] f39270v = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ProfileSettingsScreen.class), "bannerViewContainer", "getBannerViewContainer()Landroid/widget/FrameLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ProfileSettingsScreen.class), "bannerView", "getBannerView()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ProfileSettingsScreen.class), "bannerShadow", "getBannerShadow()Landroid/view/View;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ProfileSettingsScreen.class), "bannerCamera", "getBannerCamera()Landroid/support/v7/widget/AppCompatImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ProfileSettingsScreen.class), "bannerPreloader", "getBannerPreloader()Landroid/widget/ProgressBar;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ProfileSettingsScreen.class), "avatarViewContainer", "getAvatarViewContainer()Landroid/widget/FrameLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ProfileSettingsScreen.class), "avatarView", "getAvatarView()Lcom/reddit/frontpage/widgets/ShapedIconView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ProfileSettingsScreen.class), "avatarCamera", "getAvatarCamera()Landroid/support/v7/widget/AppCompatImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ProfileSettingsScreen.class), "avatarPreloader", "getAvatarPreloader()Landroid/widget/ProgressBar;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ProfileSettingsScreen.class), "showActiveRow", "getShowActiveRow()Landroid/widget/LinearLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ProfileSettingsScreen.class), "showActiveSwitch", "getShowActiveSwitch()Landroid/widget/Switch;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ProfileSettingsScreen.class), "contentVisibleRow", "getContentVisibleRow()Landroid/widget/LinearLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ProfileSettingsScreen.class), "contentVisibleSwitch", "getContentVisibleSwitch()Landroid/widget/Switch;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ProfileSettingsScreen.class), "displayNameField", "getDisplayNameField()Lcom/reddit/social/presentation/EditTextWithCounter;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ProfileSettingsScreen.class), "aboutField", "getAboutField()Lcom/reddit/social/presentation/EditTextWithCounter;"))};
    public static final Companion f39271x = new Companion();
    private final InvalidatableLazy f39272A = LazyKt.m24085a((BaseScreen) this, (Function0) new ProfileSettingsScreen$bannerShadow$2(this));
    private final InvalidatableLazy f39273B = LazyKt.m24085a((BaseScreen) this, (Function0) new ProfileSettingsScreen$bannerCamera$2(this));
    private final InvalidatableLazy f39274C = LazyKt.m24085a((BaseScreen) this, (Function0) new ProfileSettingsScreen$bannerPreloader$2(this));
    private final InvalidatableLazy f39275D = LazyKt.m24085a((BaseScreen) this, (Function0) new ProfileSettingsScreen$avatarViewContainer$2(this));
    private final InvalidatableLazy f39276E = LazyKt.m24085a((BaseScreen) this, (Function0) new ProfileSettingsScreen$avatarView$2(this));
    private final InvalidatableLazy f39277F = LazyKt.m24085a((BaseScreen) this, (Function0) new ProfileSettingsScreen$avatarCamera$2(this));
    private final InvalidatableLazy f39278G = LazyKt.m24085a((BaseScreen) this, (Function0) new ProfileSettingsScreen$avatarPreloader$2(this));
    private final InvalidatableLazy f39279H = LazyKt.m24085a((BaseScreen) this, (Function0) new ProfileSettingsScreen$showActiveRow$2(this));
    private final InvalidatableLazy f39280M = LazyKt.m24085a((BaseScreen) this, (Function0) new ProfileSettingsScreen$showActiveSwitch$2(this));
    private final InvalidatableLazy f39281N = LazyKt.m24085a((BaseScreen) this, (Function0) new ProfileSettingsScreen$contentVisibleRow$2(this));
    private final InvalidatableLazy f39282O = LazyKt.m24085a((BaseScreen) this, (Function0) new ProfileSettingsScreen$contentVisibleSwitch$2(this));
    private final InvalidatableLazy f39283P = LazyKt.m24085a((BaseScreen) this, (Function0) new ProfileSettingsScreen$displayNameField$2(this));
    private final InvalidatableLazy f39284Q = LazyKt.m24085a((BaseScreen) this, (Function0) new ProfileSettingsScreen$aboutField$2(this));
    @State
    public File tempImageFile;
    @State
    public String userSubredditDisplayName;
    @Inject
    public ProfileSettingsPresenter f39285w;
    private final InvalidatableLazy f39286y = LazyKt.m24085a((BaseScreen) this, (Function0) new ProfileSettingsScreen$bannerViewContainer$2(this));
    private final InvalidatableLazy f39287z = LazyKt.m24085a((BaseScreen) this, (Function0) new ProfileSettingsScreen$bannerView$2(this));

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/view/ProfileSettingsScreen$Companion;", "", "()V", "RESULT_CODE_AVATAR_FROM_LIBRARY", "", "RESULT_CODE_AVATAR_TAKE_PHOTO", "RESULT_CODE_BANNER_FROM_LIBRARY", "RESULT_CODE_BANNER_TAKE_PHOTO", "newInstance", "Lcom/reddit/frontpage/ui/profile/profilesettings/view/ProfileSettingsScreen;", "userSubredditDisplayName", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ProfileSettingsScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ProfileSettingsScreen m23605a(String str) {
            Intrinsics.m26847b(str, "userSubredditDisplayName");
            ProfileSettingsScreen profileSettingsScreen = new ProfileSettingsScreen();
            Intrinsics.m26847b(str, "<set-?>");
            profileSettingsScreen.userSubredditDisplayName = str;
            return profileSettingsScreen;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f21575a;
        public static final /* synthetic */ int[] f21576b;
        public static final /* synthetic */ int[] f21577c;

        static {
            int[] iArr = new int[ImageAction.values().length];
            f21575a = iArr;
            iArr[ImageAction.f21552a.ordinal()] = 1;
            f21575a[ImageAction.f21553b.ordinal()] = 2;
            f21575a[ImageAction.f21555d.ordinal()] = 3;
            f21575a[ImageAction.f21554c.ordinal()] = 4;
            iArr = new int[ImageType.values().length];
            f21576b = iArr;
            iArr[ImageType.f21564a.ordinal()] = 1;
            f21576b[ImageType.f21565b.ordinal()] = 2;
            iArr = new int[ImageType.values().length];
            f21577c = iArr;
            iArr[ImageType.f21564a.ordinal()] = 1;
            f21577c[ImageType.f21565b.ordinal()] = 2;
        }
    }

    private final android.view.View m39413O() {
        return (android.view.View) this.f39272A.mo5678b();
    }

    private final AppCompatImageView m39414P() {
        return (AppCompatImageView) this.f39273B.mo5678b();
    }

    private final ProgressBar m39415Q() {
        return (ProgressBar) this.f39274C.mo5678b();
    }

    private final FrameLayout m39416R() {
        return (FrameLayout) this.f39275D.mo5678b();
    }

    private final AppCompatImageView m39417S() {
        return (AppCompatImageView) this.f39277F.mo5678b();
    }

    private final ProgressBar m39418T() {
        return (ProgressBar) this.f39278G.mo5678b();
    }

    private final Switch m39419U() {
        return (Switch) this.f39280M.mo5678b();
    }

    private final Switch m39420V() {
        return (Switch) this.f39282O.mo5678b();
    }

    private final EditTextWithCounter m39421W() {
        return (EditTextWithCounter) this.f39283P.mo5678b();
    }

    private final EditTextWithCounter m39422X() {
        return (EditTextWithCounter) this.f39284Q.mo5678b();
    }

    public static final ProfileSettingsScreen m39429c(String str) {
        return Companion.m23605a(str);
    }

    private final FrameLayout m39430x() {
        return (FrameLayout) this.f39286y.mo5678b();
    }

    private final ImageView m39431y() {
        return (ImageView) this.f39287z.mo5678b();
    }

    public final int mo7141s() {
        return C1761R.layout.screen_profile_settings;
    }

    public final int mo7143u() {
        return 2;
    }

    public final ProfileSettingsPresenter m39454w() {
        ProfileSettingsPresenter profileSettingsPresenter = this.f39285w;
        if (profileSettingsPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return profileSettingsPresenter;
    }

    protected final void mo7142t() {
        super.mo7142t();
        Builder a = DaggerProfileSettingsComponent.m29260a();
        UserComponent k = FrontpageApplication.m28875k();
        Intrinsics.m26843a((Object) k, "FrontpageApplication.getUserComponent()");
        a = a.mo4726a(k).mo4728a((View) this);
        String str = this.userSubredditDisplayName;
        if (str == null) {
            Intrinsics.m26844a("userSubredditDisplayName");
        }
        a.mo4727a(new Parameters(str)).mo4729a().mo4730a(this);
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        n();
        ((LinearLayout) ((Lazy) this.f39279H).mo5678b()).setOnClickListener(new ProfileSettingsScreen$inlined$sam$OnClickListener$i$7f478c20((Function1) new ProfileSettingsScreen$onCreateView$1(this)));
        ((LinearLayout) ((Lazy) this.f39281N).mo5678b()).setOnClickListener(new ProfileSettingsScreen$inlined$sam$OnClickListener$i$7f478c20((Function1) new ProfileSettingsScreen$onCreateView$2(this)));
        layoutInflater = this.f39285w;
        if (layoutInflater == null) {
            Intrinsics.m26844a("presenter");
        }
        layoutInflater.attach();
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        actionBar.a(C1761R.string.title_edit_profile);
    }

    public final void m39437a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_profile_settings, menu);
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            menuItem = this.f39285w;
            if (menuItem == null) {
                Intrinsics.m26844a("presenter");
            }
            menuItem.m35172c();
            return true;
        } else if (itemId != C1761R.id.action_save) {
            return super.mo7201a(menuItem);
        } else {
            menuItem = this.f39285w;
            if (menuItem == null) {
                Intrinsics.m26844a("presenter");
            }
            menuItem.m35170a(m39421W().getEditText().getText().toString(), m39422X().getEditText().getText().toString(), m39420V().isChecked(), m39419U().isChecked());
            return true;
        }
    }

    public final void mo7227a(ImageActions imageActions) {
        Intrinsics.m26847b(imageActions, "imageActions");
        Object am_ = am_();
        if (am_ != null) {
            ImageType imageType = imageActions.f21562e;
            Intrinsics.m26843a(am_, "context");
            new ProfileImageActionsScreen((Context) am_, imageActions, new ProfileSettingsScreen$showProfileImageActions$actionsScreen$1(this, imageType)).show();
        }
    }

    private final void m39424a(Intent intent, ImageType imageType) {
        Context aq_ = aq_();
        if (aq_ != null) {
            String f = Util.m24027f((int) C1761R.string.provider_authority_file);
            File file = this.tempImageFile;
            if (file == null) {
                Intrinsics.m26844a("tempImageFile");
            }
            Uri a = FileProvider.a(aq_, f, file);
            intent.putExtra("output", a);
            intent.addFlags(1);
            intent.addFlags(2);
            int i = 3;
            if (VERSION.SDK_INT < 21) {
                Object am_ = am_();
                if (am_ != null) {
                    Intrinsics.m26843a(am_, "context");
                    Object queryIntentActivities = am_.getPackageManager().queryIntentActivities(intent, 65536);
                    Intrinsics.m26843a(queryIntentActivities, "context.packageManager.q…nager.MATCH_DEFAULT_ONLY)");
                    Iterable<ResolveInfo> iterable = (Iterable) queryIntentActivities;
                    Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                    for (ResolveInfo resolveInfo : iterable) {
                        arrayList.add(resolveInfo.activityInfo.packageName);
                    }
                    for (String grantUriPermission : (List) arrayList) {
                        am_.grantUriPermission(grantUriPermission, a, 3);
                    }
                } else {
                    return;
                }
            }
            switch (WhenMappings.f21576b[imageType.ordinal()]) {
                case 1:
                    break;
                case 2:
                    i = 4;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            a(intent, i);
        }
    }

    public final void mo7202a(int i, int i2, Intent intent) {
        super.mo7202a(i, i2, intent);
        if (i2 == -1) {
            Uri uri = 0;
            File file;
            switch (i) {
                case 1:
                    i = this.f39285w;
                    if (i == 0) {
                        Intrinsics.m26844a("presenter");
                    }
                    if (intent != null) {
                        uri = intent.getData();
                    }
                    i.m35168a(uri, ImageType.f21564a);
                    return;
                case 2:
                    i = this.f39285w;
                    if (i == 0) {
                        Intrinsics.m26844a("presenter");
                    }
                    if (intent != null) {
                        uri = intent.getData();
                    }
                    i.m35168a(uri, ImageType.f21565b);
                    return;
                case 3:
                    i = this.f39285w;
                    if (i == 0) {
                        Intrinsics.m26844a("presenter");
                    }
                    file = this.tempImageFile;
                    if (file == 0) {
                        Intrinsics.m26844a("tempImageFile");
                    }
                    i.m35169a(file, ImageType.f21564a);
                    return;
                case 4:
                    i = this.f39285w;
                    if (i == 0) {
                        Intrinsics.m26844a("presenter");
                    }
                    file = this.tempImageFile;
                    if (file == 0) {
                        Intrinsics.m26844a("tempImageFile");
                    }
                    i.m35169a(file, ImageType.f21565b);
                    break;
                default:
                    break;
            }
        }
    }

    public final void mo7191l() {
        super.mo7191l();
        ProfileSettingsPresenter profileSettingsPresenter = this.f39285w;
        if (profileSettingsPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        profileSettingsPresenter.detach();
    }

    public final void mo7226a(AccountPresentationModel accountPresentationModel) {
        Intrinsics.m26847b(accountPresentationModel, "account");
        m39421W().getEditText().setText(accountPresentationModel.f21544a);
        m39422X().getEditText().setText(accountPresentationModel.f21545b);
        m39419U().setChecked(accountPresentationModel.f21546c);
        m39420V().setChecked(accountPresentationModel.f21547d);
        mo7233b(accountPresentationModel.f21548e);
        mo7228a(accountPresentationModel.f21549f);
        m39430x().setOnClickListener(new ProfileSettingsScreen$inlined$sam$OnClickListener$i$7f478c20(new ProfileSettingsScreen$bind$2(this)));
        m39416R().setOnClickListener(new ProfileSettingsScreen$inlined$sam$OnClickListener$i$7f478c20(new ProfileSettingsScreen$bind$3(this)));
    }

    public final void aj_() {
        ViewsKt.m24107c(m39418T());
        ViewsKt.m24109d(m39417S());
        m39416R().setEnabled(false);
    }

    public final void ak_() {
        ViewsKt.m24109d(m39418T());
        ViewsKt.m24107c(m39417S());
        m39416R().setEnabled(true);
    }

    public final void mo7238i() {
        ViewsKt.m24107c(m39415Q());
        ViewsKt.m24109d(m39414P());
        m39430x().setEnabled(false);
    }

    public final void al_() {
        ViewsKt.m24109d(m39415Q());
        ViewsKt.m24107c(m39414P());
        m39430x().setEnabled(true);
    }

    public final void mo7233b(String str) {
        Object am_ = am_();
        if (am_ != null) {
            Object obj;
            Context context;
            SnooProgressDrawable snooProgressDrawable;
            Drawable drawable;
            CharSequence charSequence = str;
            if (charSequence != null) {
                if (charSequence.length() != 0) {
                    obj = null;
                    if (obj == null) {
                        m39431y().setImageDrawable(null);
                        ViewsKt.m24109d(m39413O());
                        str = m39414P();
                        Intrinsics.m26843a(am_, "context");
                        str.setColorFilter(ResourcesUtil.m22740i((Context) am_, C1761R.attr.rdt_action_icon_color));
                    }
                    context = (Context) am_;
                    snooProgressDrawable = new SnooProgressDrawable(context);
                    drawable = snooProgressDrawable;
                    GlideApp.a(am_).b(str).placeholder(drawable).apply(RequestOptions.a(drawable)).listener(ImageProgressLoadListener.a(snooProgressDrawable, str)).into(m39431y());
                    ViewsKt.m24107c(m39413O());
                    str = m39414P();
                    Intrinsics.m26843a(am_, "context");
                    str.setColorFilter(ResourcesUtil.m22740i(context, C1761R.attr.rdt_light_text_color));
                    return;
                }
            }
            obj = 1;
            if (obj == null) {
                context = (Context) am_;
                snooProgressDrawable = new SnooProgressDrawable(context);
                drawable = snooProgressDrawable;
                GlideApp.a(am_).b(str).placeholder(drawable).apply(RequestOptions.a(drawable)).listener(ImageProgressLoadListener.a(snooProgressDrawable, str)).into(m39431y());
                ViewsKt.m24107c(m39413O());
                str = m39414P();
                Intrinsics.m26843a(am_, "context");
                str.setColorFilter(ResourcesUtil.m22740i(context, C1761R.attr.rdt_light_text_color));
                return;
            }
            m39431y().setImageDrawable(null);
            ViewsKt.m24109d(m39413O());
            str = m39414P();
            Intrinsics.m26843a(am_, "context");
            str.setColorFilter(ResourcesUtil.m22740i((Context) am_, C1761R.attr.rdt_action_icon_color));
        }
    }

    public final void mo7225a() {
        m37532c((int) C1761R.string.error_unable_to_load);
    }

    public final void mo7235d() {
        m37532c((int) C1761R.string.profile_settings_error_load_account);
    }

    public final void mo7236e() {
        m37532c((int) C1761R.string.profile_settings_error_update_account_settings);
    }

    public final void mo7232b() {
        m37532c((int) C1761R.string.profile_settings_error_restore_avatar);
    }

    public final void mo7234c() {
        m37532c((int) C1761R.string.profile_settings_error_remove_banner);
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6987a(view);
        this.I.m24081a();
    }

    public final boolean mo6986J() {
        ProfileSettingsPresenter profileSettingsPresenter = this.f39285w;
        if (profileSettingsPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        profileSettingsPresenter.m35172c();
        return true;
    }

    public final void mo7237f() {
        m29351F();
    }

    public final void mo7228a(String str) {
        Util.m23987a((ShapedIconView) this.f39276E.mo5678b(), str, null, true);
        ViewsKt.m24107c(m39416R());
    }

    public static final /* synthetic */ void m39425a(ProfileSettingsScreen profileSettingsScreen, ImageType imageType) {
        if (PermissionUtil.m23865a((Screen) profileSettingsScreen)) {
            int i;
            File a;
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            Object am_ = profileSettingsScreen.am_();
            if (am_ != null) {
                Intrinsics.m26843a(am_, "context");
                if (intent.resolveActivity(am_.getPackageManager()) != null) {
                    i = 1;
                    a = FileUtil.m23689a(0);
                    if (i != 0 || a == null) {
                        profileSettingsScreen.mo7204a((CharSequence) Util.m24027f((int) C1761R.string.error_unable_to_access_camera));
                    } else {
                        profileSettingsScreen.tempImageFile = a;
                        profileSettingsScreen.m39424a(intent, imageType);
                        return;
                    }
                }
            }
            i = 0;
            try {
                a = FileUtil.m23689a(0);
            } catch (IOException e) {
                Timber.c(e, "Can't create file", new Object[0]);
                a = null;
            }
            if (i != 0) {
            }
            profileSettingsScreen.mo7204a((CharSequence) Util.m24027f((int) C1761R.string.error_unable_to_access_camera));
        }
    }

    public static final /* synthetic */ void m39427b(ProfileSettingsScreen profileSettingsScreen, ImageType imageType) {
        if (PermissionUtil.m23865a((Screen) profileSettingsScreen)) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            String str = "image/*";
            intent.setType(str);
            intent.putExtra("android.intent.extra.MIME_TYPES", str);
            switch (WhenMappings.f21577c[imageType.ordinal()]) {
                case 1:
                    imageType = true;
                    break;
                case 2:
                    imageType = 2;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            profileSettingsScreen.a(Intent.createChooser(intent, null), imageType);
        }
    }
}
