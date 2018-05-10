package com.reddit.frontpage.ui.profile.profilesettings.presentation;

import android.net.Uri;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.common.rx.Thread;
import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.data.model.ProfileSettings;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.usecase.UploadingImageUseCase;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.ui.profile.profilesettings.ProfileSettingsContract.Parameters;
import com.reddit.frontpage.ui.profile.profilesettings.ProfileSettingsContract.View;
import com.reddit.frontpage.ui.profile.profilesettings.analytics.ProfileSettingsAnalyticsContract;
import com.reddit.frontpage.ui.profile.profilesettings.model.AccountMapper;
import com.reddit.frontpage.ui.profile.profilesettings.model.ImageType;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.File;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B7\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\b\u0010 \u001a\u00020\u001bH\u0016J\b\u0010!\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020\u001bH\u0016J\u001a\u0010#\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0016J(\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0011H\u0016J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020*0/2\u0006\u00100\u001a\u0002012\u0006\u0010$\u001a\u00020%H\u0002J\b\u00102\u001a\u00020\u001bH\u0016J\b\u00103\u001a\u00020\u001bH\u0016J \u00104\u001a\u0002052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0011H\u0002J\u0010\u00106\u001a\u0002052\u0006\u0010-\u001a\u00020\u0011H\u0002J\u0018\u00107\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u00108\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u00109\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0002J\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020*0/2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/presentation/ProfileSettingsPresenter;", "Lcom/reddit/frontpage/ui/profile/profilesettings/ProfileSettingsContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "view", "Lcom/reddit/frontpage/ui/profile/profilesettings/ProfileSettingsContract$View;", "accountRepository", "Lcom/reddit/frontpage/domain/repository/AccountRepository;", "parameters", "Lcom/reddit/frontpage/ui/profile/profilesettings/ProfileSettingsContract$Parameters;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "analytics", "Lcom/reddit/frontpage/ui/profile/profilesettings/analytics/ProfileSettingsAnalyticsContract;", "uploadingImageUseCase", "Lcom/reddit/frontpage/domain/usecase/UploadingImageUseCase;", "(Lcom/reddit/frontpage/ui/profile/profilesettings/ProfileSettingsContract$View;Lcom/reddit/frontpage/domain/repository/AccountRepository;Lcom/reddit/frontpage/ui/profile/profilesettings/ProfileSettingsContract$Parameters;Lcom/reddit/common/rx/PostExecutionThread;Lcom/reddit/frontpage/ui/profile/profilesettings/analytics/ProfileSettingsAnalyticsContract;Lcom/reddit/frontpage/domain/usecase/UploadingImageUseCase;)V", "hasCustomAvatar", "", "getHasCustomAvatar", "()Z", "setHasCustomAvatar", "(Z)V", "hasCustomBanner", "getHasCustomBanner", "setHasCustomBanner", "isSaving", "attach", "", "getFileFromUri", "Ljava/io/File;", "contentUri", "Landroid/net/Uri;", "onAvatarClicked", "onBannerClicked", "onCloseClicked", "onImageFilePicked", "imageType", "Lcom/reddit/frontpage/ui/profile/profilesettings/model/ImageType;", "onPhotoTaken", "file", "onSaveClicked", "displayName", "", "about", "contentVisible", "showActiveCommunities", "reachAccountImage", "Lio/reactivex/Single;", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "removeBanner", "restoreAvatar", "updateProfileSettings", "Lio/reactivex/Completable;", "updateShowingActiveCommunities", "uploadAccountImage", "uploadAvatar", "uploadBanner", "uploadImage", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ProfileSettingsPresenter.kt */
public final class ProfileSettingsPresenter extends DisposablePresenter {
    public static final Companion f34413d = new Companion();
    public boolean f34414a;
    public boolean f34415b;
    public final View f34416c;
    private boolean f34417e;
    private final AccountRepository f34418f;
    private final Parameters f34419g;
    private final PostExecutionThread f34420h;
    private final ProfileSettingsAnalyticsContract f34421i;
    private final UploadingImageUseCase f34422j;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/presentation/ProfileSettingsPresenter$Companion;", "", "()V", "URL_REACH_NUM_ATTEMPTS", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ProfileSettingsPresenter.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f21568a;
        public static final /* synthetic */ int[] f21569b;
        public static final /* synthetic */ int[] f21570c;
        public static final /* synthetic */ int[] f21571d;

        static {
            int[] iArr = new int[ImageType.values().length];
            f21568a = iArr;
            iArr[ImageType.f21564a.ordinal()] = 1;
            f21568a[ImageType.f21565b.ordinal()] = 2;
            iArr = new int[ImageType.values().length];
            f21569b = iArr;
            iArr[ImageType.f21564a.ordinal()] = 1;
            f21569b[ImageType.f21565b.ordinal()] = 2;
            iArr = new int[ImageType.values().length];
            f21570c = iArr;
            iArr[ImageType.f21564a.ordinal()] = 1;
            f21570c[ImageType.f21565b.ordinal()] = 2;
            iArr = new int[ImageType.values().length];
            f21571d = iArr;
            iArr[ImageType.f21564a.ordinal()] = 1;
            f21571d[ImageType.f21565b.ordinal()] = 2;
        }
    }

    @Inject
    public ProfileSettingsPresenter(View view, AccountRepository accountRepository, Parameters parameters, PostExecutionThread postExecutionThread, ProfileSettingsAnalyticsContract profileSettingsAnalyticsContract, UploadingImageUseCase uploadingImageUseCase) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(accountRepository, "accountRepository");
        Intrinsics.m26847b(parameters, "parameters");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        Intrinsics.m26847b(profileSettingsAnalyticsContract, "analytics");
        Intrinsics.m26847b(uploadingImageUseCase, "uploadingImageUseCase");
        this.f34416c = view;
        this.f34418f = accountRepository;
        this.f34419g = parameters;
        this.f34420h = postExecutionThread;
        this.f34421i = profileSettingsAnalyticsContract;
        this.f34422j = uploadingImageUseCase;
    }

    public final void attach() {
        this.f34421i.mo5010a();
        Object doOnSuccess = this.f34418f.m22393a().map(new ProfileSettingsPresenterKt$sam$Function$0a704ecf(new ProfileSettingsPresenter$attach$1(AccountMapper.f21543a))).doOnSuccess(new ProfileSettingsPresenter$attach$2(this));
        Intrinsics.m26843a(doOnSuccess, "accountRepository.getMyA…faultBanner\n            }");
        doOnSuccess = SinglesKt.m24094b(doOnSuccess, this.f34420h).subscribe(new ProfileSettingsPresenterKt$sam$Consumer$96495eed(new ProfileSettingsPresenter$attach$3(this.f34416c)), new ProfileSettingsPresenter$attach$4(this));
        Intrinsics.m26843a(doOnSuccess, "accountRepository.getMyA…otifyLoadAccountError() }");
        handleDispose(doOnSuccess);
    }

    public final void m35170a(String str, String str2, boolean z, boolean z2) {
        Intrinsics.m26847b(str, "displayName");
        Intrinsics.m26847b(str2, "about");
        if (!this.f34417e) {
            this.f34417e = true;
            this.f34421i.mo5012a(str, str2, z, z2);
            CompletableSource[] completableSourceArr = new CompletableSource[2];
            Object flatMapCompletable = this.f34418f.m22399d(this.f34419g.f21529a).map(new ProfileSettingsPresenter$updateProfileSettings$1(str, str2, z)).flatMapCompletable((Function) new ProfileSettingsPresenterKt$sam$Function$0a704ecf((Function1) new ProfileSettingsPresenter$updateProfileSettings$2(this.f34418f)));
            Intrinsics.m26843a(flatMapCompletable, "accountRepository.getUse…ateUserSubredditSettings)");
            completableSourceArr[0] = (CompletableSource) flatMapCompletable;
            completableSourceArr[1] = this.f34418f.m22391a(new ProfileSettings(z2));
            flatMapCompletable = Completable.mergeArray(completableSourceArr);
            Intrinsics.m26843a(flatMapCompletable, "Completable\n            …ommunities)\n            )");
            flatMapCompletable = CompletablesKt.m24074b(flatMapCompletable, (Thread) this.f34420h).doFinally((Action) new ProfileSettingsPresenter$onSaveClicked$1(this)).subscribe((Action) new ProfileSettingsPresenter$onSaveClicked$2(this), (Consumer) new ProfileSettingsPresenter$onSaveClicked$3(this));
            Intrinsics.m26843a(flatMapCompletable, "Completable\n            …aveError()\n            })");
            handleDispose(flatMapCompletable);
        }
    }

    public final void m35168a(Uri uri, ImageType imageType) {
        Intrinsics.m26847b(imageType, "imageType");
        uri = m35160a(uri);
        if (uri != null) {
            m35162b(uri, imageType);
        } else {
            this.f34416c.mo7225a();
        }
    }

    private static java.io.File m35160a(android.net.Uri r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.reddit.frontpage.FrontpageApplication.f27402a;	 Catch:{ Exception -> 0x0013 }
        r0 = (android.content.Context) r0;	 Catch:{ Exception -> 0x0013 }
        r2 = com.reddit.frontpage.util.FileUtil.m23697b(r0, r2);	 Catch:{ Exception -> 0x0013 }
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0013 }
        r1 = new java.net.URI;	 Catch:{ Exception -> 0x0013 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0013 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0013 }
        goto L_0x0014;
    L_0x0013:
        r0 = 0;
    L_0x0014:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.ui.profile.profilesettings.presentation.ProfileSettingsPresenter.a(android.net.Uri):java.io.File");
    }

    public final void m35169a(File file, ImageType imageType) {
        Intrinsics.m26847b(file, "file");
        Intrinsics.m26847b(imageType, "imageType");
        m35162b(file, imageType);
    }

    private final void m35162b(File file, ImageType imageType) {
        Object subscribe;
        switch (WhenMappings.f21568a[imageType.ordinal()]) {
            case 1:
                this.f34416c.aj_();
                subscribe = SinglesKt.m24094b(m35164c(file, imageType), (Thread) this.f34420h).doAfterTerminate((Action) new ProfileSettingsPresenter$uploadAvatar$1(this)).subscribe(new ProfileSettingsPresenterKt$sam$Consumer$96495eed((Function1) new ProfileSettingsPresenter$uploadAvatar$2(this.f34416c)), (Consumer) new ProfileSettingsPresenter$uploadAvatar$3(this));
                Intrinsics.m26843a(subscribe, "uploadImage(file, imageT…yUnableLoadImageError() }");
                handleDispose(subscribe);
                return;
            case 2:
                this.f34416c.mo7238i();
                subscribe = SinglesKt.m24094b(m35164c(file, imageType), (Thread) this.f34420h).doAfterTerminate((Action) new ProfileSettingsPresenter$uploadBanner$1(this)).subscribe((Consumer) new ProfileSettingsPresenter$uploadBanner$2(this), new ProfileSettingsPresenter$uploadBanner$3(this));
                Intrinsics.m26843a(subscribe, "uploadImage(file, imageT…yUnableLoadImageError() }");
                handleDispose(subscribe);
                break;
            default:
                break;
        }
    }

    private Single<String> m35164c(File file, ImageType imageType) {
        String str;
        Intrinsics.m26847b(file, "file");
        Intrinsics.m26847b(imageType, "imageType");
        switch (WhenMappings.f21569b[imageType.ordinal()]) {
            case 1:
                str = "profileIcon";
                break;
            case 2:
                str = "profileBanner";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        UploadingImageUseCase uploadingImageUseCase = this.f34422j;
        String str2 = this.f34419g.f21529a;
        Intrinsics.m26847b(str2, "userSubredditDisplayName");
        Intrinsics.m26847b(file, "file");
        Intrinsics.m26847b(str, "imageType");
        Object fromFile = Uri.fromFile(file);
        Intrinsics.m26843a(fromFile, "uri");
        fromFile = uploadingImageUseCase.f20296a.m22395a(str2, MapsKt__MapsKt.m36121a(TuplesKt.m26780a("filepath", fromFile.getLastPathSegment()), TuplesKt.m26780a("mimetype", "image/jpeg"), TuplesKt.m26780a("raw_json", "1"), TuplesKt.m26780a("imagetype", str))).flatMap(new UploadingImageUseCase$uploadImage$1(uploadingImageUseCase, fromFile, r3));
        Intrinsics.m26843a(fromFile, "accountRepository.getFil…eUrl(it, uri, fileName) }");
        fromFile = fromFile.flatMap(new ProfileSettingsPresenter$uploadImage$1(this, str)).flatMap(new ProfileSettingsPresenter$uploadImage$2(this)).doOnSuccess(new ProfileSettingsPresenter$uploadImage$3(this, imageType)).flatMap(new ProfileSettingsPresenter$uploadImage$4(this, imageType));
        Intrinsics.m26843a(fromFile, "uploadingImageUseCase\n  …untImage(it, imageType) }");
        return fromFile;
    }

    public final void m35167a() {
        Object subscribe = CompletablesKt.m24074b(this.f34418f.m22401f(this.f34419g.f21529a), this.f34420h).subscribe(new ProfileSettingsPresenter$removeBanner$1(this), new ProfileSettingsPresenter$removeBanner$2(this));
        Intrinsics.m26843a(subscribe, "accountRepository.remove…tifyRemoveBannerError() }");
        handleDispose(subscribe);
    }

    public final void m35171b() {
        Object subscribe = SinglesKt.m24094b(this.f34418f.m22400e(this.f34419g.f21529a), this.f34420h).subscribe(new ProfileSettingsPresenter$restoreAvatar$1(this), new ProfileSettingsPresenter$restoreAvatar$2(this));
        Intrinsics.m26843a(subscribe, "accountRepository.remove…ifyRestoreAvatarError() }");
        handleDispose(subscribe);
    }

    public final void m35172c() {
        this.f34421i.mo5016d();
        this.f34416c.mo7237f();
    }

    public static final /* synthetic */ Single m35159a(Account account, ImageType imageType) {
        String str = null;
        switch (WhenMappings.f21571d[imageType.ordinal()]) {
            case 1:
                account = account.getSubreddit();
                if (account != null) {
                    str = account.getIconImg();
                    break;
                }
                break;
            case 2:
                account = account.getSubreddit();
                if (account != null) {
                    str = account.getBannerImg();
                    break;
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Object map = Single.fromCallable((Callable) new ProfileSettingsPresenter$reachAccountImage$1(str)).map((Function) new ProfileSettingsPresenter$reachAccountImage$2(str));
        Intrinsics.m26843a(map, "Single.fromCallable { Ur…e\")\n          }\n        }");
        return map;
    }
}
