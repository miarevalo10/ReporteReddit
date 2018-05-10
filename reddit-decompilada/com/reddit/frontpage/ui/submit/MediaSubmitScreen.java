package com.reddit.frontpage.ui.submit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload_Table;
import com.reddit.datalibrary.frontpage.service.api.SubmitService.SubmitErrorEvent;
import com.reddit.datalibrary.frontpage.service.api.UploadService.UploadErrorEvent;
import com.reddit.datalibrary.frontpage.service.api.UploadService.UploadSuccessEvent;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService.SubmitVideoResultEvent;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.MainActivity;
import com.reddit.frontpage.VideoPreviewActivity;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.ui.listener.TextChangedListener;
import com.reddit.frontpage.util.FileUtil;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.PermissionUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.SubmitUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;
import com.reddit.frontpage.widgets.video.VideoPlayer;
import de.greenrobot.event.EventBus;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.io.File;
import java.net.URI;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import timber.log.Timber;

public class MediaSubmitScreen extends BaseSubmitScreen {
    private static final String f40170G = "MediaSubmitScreen";
    private static final long f40171H = TimeUnit.MILLISECONDS.convert(15, TimeUnit.MINUTES);
    boolean f40172A;
    Bitmap f40173B;
    int f40174C;
    int f40175D;
    String f40176E;
    boolean f40177F;
    private VideoPlayer f40178M;
    private AlertDialog f40179N;
    private AlertDialog f40180O;
    private AlertDialog f40181P;
    private CompositeDisposable f40182Q;
    private boolean f40183R;
    @BindView
    View captureImage;
    @BindView
    View captureVideo;
    @BindView
    View chooseMedia;
    @BindView
    View clearButton;
    @BindView
    ImageView galleryIcon;
    @BindView
    ImageView imageIcon;
    @BindView
    ImageView imagePreview;
    @State
    boolean isGif;
    @State
    boolean isImage;
    @State
    File mediaFile;
    @BindView
    View mediaOptionsContainer;
    @BindView
    ViewGroup mediaRoot;
    @BindView
    View previewMediaContainer;
    @State
    Uri sharedMediaUri;
    @BindView
    EditText submitTitle;
    @State
    int submitType;
    @BindView
    ImageView videoIcon;
    @BindView
    SimpleExoPlayerView videoPreview;
    @State
    int videoProcessState;

    class C23731 extends TextChangedListener {
        final /* synthetic */ MediaSubmitScreen f29325a;

        C23731(MediaSubmitScreen mediaSubmitScreen) {
            this.f29325a = mediaSubmitScreen;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f29325a.mo7479W();
        }
    }

    public String getAnalyticsScreenName() {
        return "post_media";
    }

    public final int mo7141s() {
        return C1761R.layout.screen_submit_media;
    }

    public static MediaSubmitScreen m41106a(int i, Subreddit subreddit, Uri uri) {
        BaseSubmitScreen mediaSubmitScreen = new MediaSubmitScreen();
        mediaSubmitScreen.originSubreddit = subreddit;
        mediaSubmitScreen.sharedMediaUri = uri;
        mediaSubmitScreen.submitType = i;
        return mediaSubmitScreen;
    }

    public static MediaSubmitScreen m41113d(String str) {
        MediaSubmitScreen mediaSubmitScreen = new MediaSubmitScreen();
        mediaSubmitScreen.f40183R = true;
        mediaSubmitScreen.m39537a(str);
        mediaSubmitScreen.submitType = 2;
        return mediaSubmitScreen;
    }

    public final void mo7477U() {
        if (this.isImage) {
            Context am_ = am_();
            if (am_ != null) {
                am_.startService(IntentUtil.m23748a(am_, this.mediaFile.getAbsolutePath(), this.submitRequestId));
            }
            return;
        }
        Maybe.fromCallable(new MediaSubmitScreen$$Lambda$11(this)).map(new MediaSubmitScreen$$Lambda$12(this)).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new MediaSubmitScreen$$Lambda$13(this));
    }

    public final int mo7480y() {
        return this.submitType == 0 ? C1761R.string.title_submit_image : C1761R.string.title_submit_video;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        layoutInflater = super.mo7139a(layoutInflater, viewGroup);
        if (this.submitType == 0) {
            this.imageIcon.setImageDrawable(ResourcesUtil.m22721a(viewGroup.getContext(), this.imageIcon.getDrawable(), (int) C1761R.attr.rdt_light_text_color));
            this.captureImage.setVisibility(0);
            this.captureImage.setOnClickListener(new MediaSubmitScreen$$Lambda$0(this));
        } else {
            this.videoIcon.setImageDrawable(ResourcesUtil.m22721a(viewGroup.getContext(), this.videoIcon.getDrawable(), (int) C1761R.attr.rdt_light_text_color));
            this.captureVideo.setVisibility(0);
            this.captureVideo.setOnClickListener(new MediaSubmitScreen$$Lambda$1(this));
        }
        this.galleryIcon.setImageDrawable(ResourcesUtil.m22721a(viewGroup.getContext(), this.galleryIcon.getDrawable(), (int) C1761R.attr.rdt_light_text_color));
        this.chooseMedia.setOnClickListener(new MediaSubmitScreen$$Lambda$2(this));
        this.clearButton.setOnClickListener(new MediaSubmitScreen$$Lambda$3(this));
        this.submitTitle.addTextChangedListener(new C23731(this));
        if (this.f40183R != null) {
            this.f40183R = false;
            Maybe.fromCallable(new MediaSubmitScreen$$Lambda$4(this)).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new MediaSubmitScreen$$Lambda$5(this));
        } else if (this.mediaFile != null) {
            aB();
        } else if (!(this.sharedMediaUri == null || PermissionUtil.m23865a((Screen) this) == null)) {
            m41111b(this.sharedMediaUri);
        }
        return layoutInflater;
    }

    protected final void mo7485b(String str) {
        super.mo7485b(str);
        if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(str) != null) {
            if (this.sharedMediaUri != null) {
                m41111b(this.sharedMediaUri);
                return;
            }
            m41128d(this.isImage);
        }
    }

    protected final void mo7241c(String str) {
        super.mo7241c(str);
        if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(str) != null) {
            if (this.sharedMediaUri != null) {
                Snackbar.a(this.K, C1761R.string.error_unable_to_share_media_permission, -1).a();
                return;
            }
            Snackbar.a(this.K, C1761R.string.error_unable_save_media_permission, -1).a();
        }
    }

    public final void mo7202a(int i, int i2, Intent intent) {
        super.mo7202a(i, i2, intent);
        if (i2 != -1) {
            aq();
            return;
        }
        switch (i) {
            case 0:
                this.isImage = true;
                aB();
                ao();
                return;
            case 1:
                this.f40176E = "camera-rear";
                this.isImage = false;
                m41112c(intent.getData());
                return;
            case 2:
                m41111b(intent.getData());
                return;
            case 3:
                if (intent != null) {
                    if (am_() != 0) {
                        this.mediaFile = new File(intent.getStringExtra("media_path"));
                        this.isGif = intent.getBooleanExtra("convert_to_gif", false);
                        this.isImage = false;
                        this.f40175D = aH();
                        aB();
                        i = am_();
                        if (i != 0) {
                            aC();
                            aD();
                            i.startService(VideoUploadService.getUploadFileIntent(i, this.mediaFile.getAbsolutePath(), this.submitRequestId, this.isGif));
                        }
                    }
                    return;
                }
                aq();
                return;
            default:
                Timber.b("Unrecognized request code %d", new Object[]{Integer.valueOf(i)});
                return;
        }
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        switch (this.videoProcessState) {
            case null:
                return;
            case 1:
                aE();
                return;
            case 2:
                this.videoProcessState = 3;
                Context am_ = am_();
                if (am_ != null) {
                    a(VideoPreviewActivity.m42720a(am_, this.mediaFile.getAbsolutePath()), 3);
                }
                return;
            case 3:
                ar();
                return;
            case 4:
                aG();
                break;
            default:
                break;
        }
    }

    protected final boolean mo7476Q() {
        if (!ap()) {
            mo7204a(Util.m24027f((int) C1761R.string.error_image_missing));
            return false;
        } else if ((TextUtils.isEmpty(this.submitTitle.getText().toString().trim()) ^ 1) != 0) {
            return super.mo7476Q();
        } else {
            mo7204a(Util.m24027f((int) C1761R.string.error_title_missing));
            return false;
        }
    }

    public final boolean mo6986J() {
        Util.m23972a(am_().getCurrentFocus());
        if (this.mediaFile == null) {
            return false;
        }
        aj();
        this.f40177F = true;
        return true;
    }

    public void onEventMainThread(UploadSuccessEvent uploadSuccessEvent) {
        if (TextUtils.equals(uploadSuccessEvent.requestId, this.submitRequestId)) {
            if (am_() != null) {
                SubmitUtil.m23910c(am_(), this.submitRequestId, m39519O(), this.submitTitle.getText().toString(), uploadSuccessEvent.url, m39524T(), this.latitude, this.longitude, m39522R(), m39523S());
            }
        }
    }

    public void onEventMainThread(UploadErrorEvent uploadErrorEvent) {
        if (TextUtils.equals(uploadErrorEvent.requestId, this.submitRequestId) != null) {
            EventBus.getDefault().post(new SubmitErrorEvent(this.submitRequestId, new Exception(Util.m24027f((int) C1761R.string.error_unable_to_upload))));
        }
    }

    public void onEventMainThread(SubmitVideoResultEvent submitVideoResultEvent) {
        if (TextUtils.equals(submitVideoResultEvent.requestId, this.submitRequestId) != null) {
            ai_();
            submitVideoResultEvent = MainActivity.m42700a(am_());
            submitVideoResultEvent.addFlags(536870912);
            am_().startActivity(submitVideoResultEvent);
        }
    }

    public final void mo7481Z() {
        super.mo7481Z();
        m39543x().setImeOptions(6);
    }

    protected final void mo7478V() {
        if (this.mediaFile == null || !m39520P()) {
            this.submitTitle.setHint(C1761R.string.submit_title_hint);
        } else {
            this.submitTitle.setHint(this.isImage ? C1761R.string.submit_image_title_hint_promoter : C1761R.string.submit_video_title_hint_promoter);
        }
    }

    private void ao() {
        if (PermissionUtil.m23865a((Screen) this)) {
            GlideApp.a(am_()).b(Uri.fromFile(this.mediaFile)).centerCrop().into(this.imagePreview);
        } else {
            Snackbar.a(this.K, C1761R.string.instabug_external_storage_permission_denied, 0).a();
        }
    }

    private void m41111b(android.net.Uri r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = r3.am_();
        if (r0 == 0) goto L_0x0068;
    L_0x0006:
        r0 = r3.am_();
        r0 = com.reddit.frontpage.util.FileUtil.m23688a(r0, r4);
        r1 = 0;
        r2 = 1;
        switch(r0) {
            case 0: goto L_0x0038;
            case 1: goto L_0x002e;
            default: goto L_0x0013;
        };
    L_0x0013:
        r0 = "Unsupported file type for URI [%s]";
        r2 = new java.lang.Object[r2];
        r4 = r4.toString();
        r2[r1] = r4;
        timber.log.Timber.d(r0, r2);
        r4 = 2131887332; // 0x7f1204e4 float:1.9409268E38 double:1.0532922915E-314;
        r4 = com.reddit.frontpage.util.Util.m24027f(r4);
        r3.mo7204a(r4);
        r3.aq();
        goto L_0x0068;
    L_0x002e:
        r3.isImage = r1;
        r0 = "gallery";
        r3.f40176E = r0;
        r3.m41112c(r4);
        return;
    L_0x0038:
        r3.isImage = r2;
        r0 = r3.am_();	 Catch:{ SecurityException -> 0x005d }
        r4 = com.reddit.frontpage.util.FileUtil.m23697b(r0, r4);	 Catch:{ SecurityException -> 0x005d }
        r0 = android.text.TextUtils.isEmpty(r4);	 Catch:{ SecurityException -> 0x005d }
        if (r0 != 0) goto L_0x0052;	 Catch:{ SecurityException -> 0x005d }
    L_0x0048:
        r4 = r3.m41114f(r4);	 Catch:{ SecurityException -> 0x005d }
        if (r4 == 0) goto L_0x0052;	 Catch:{ SecurityException -> 0x005d }
    L_0x004e:
        r3.aB();	 Catch:{ SecurityException -> 0x005d }
        return;	 Catch:{ SecurityException -> 0x005d }
    L_0x0052:
        r4 = 2131886376; // 0x7f120128 float:1.940733E38 double:1.053291819E-314;	 Catch:{ SecurityException -> 0x005d }
        r4 = com.reddit.frontpage.util.Util.m24027f(r4);	 Catch:{ SecurityException -> 0x005d }
        r3.mo7204a(r4);	 Catch:{ SecurityException -> 0x005d }
        return;
    L_0x005d:
        r4 = 2131887136; // 0x7f120420 float:1.940887E38 double:1.0532921947E-314;
        r4 = com.reddit.frontpage.util.Util.m24027f(r4);
        r3.mo7204a(r4);
        return;
    L_0x0068:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.ui.submit.MediaSubmitScreen.b(android.net.Uri):void");
    }

    private void m41112c(Uri uri) {
        aE();
        this.videoProcessState = 1;
        Observable.fromCallable(new MediaSubmitScreen$$Lambda$18(uri)).subscribeOn(SchedulerProvider.m23885a()).observeOn(SchedulerProvider.m23887c()).subscribe(new MediaSubmitScreen$$Lambda$19(this), new MediaSubmitScreen$$Lambda$20(this));
    }

    private boolean ap() {
        return (this.mediaFile == null || TextUtils.isEmpty(this.mediaFile.getAbsolutePath())) ? false : true;
    }

    final /* synthetic */ void m41123a(VideoUpload videoUpload) throws Exception {
        this.submitTitle.setText(videoUpload.getTitle());
        if (!TextUtils.isEmpty(videoUpload.getSubreddit())) {
            m39542w().m30538a(videoUpload.getSubreddit(), null, null);
        }
        this.mediaFile = new File(videoUpload.getFilePath());
        this.videoProcessState = 3;
        this.isGif = videoUpload.isGif();
        this.isImage = null;
        ar();
    }

    final void aj() {
        RedditAlertDialog redditAlertDialog = new RedditAlertDialog(am_(), true);
        redditAlertDialog.f21113a.b(C1761R.string.discard_submission).a(C1761R.string.action_discard, new MediaSubmitScreen$$Lambda$6(this)).b(C1761R.string.action_cancel, new MediaSubmitScreen$$Lambda$7(this));
        this.f40181P = redditAlertDialog.m23323a();
    }

    final /* synthetic */ void am() {
        this.sharedMediaUri = null;
        aq();
        if (this.f40177F) {
            m29351F();
            if (this.i.c.b() == 0 && am_() != null) {
                am_().finish();
            }
        }
    }

    private void aq() {
        this.mediaFile = null;
        this.f40172A = false;
        this.f40174C = 0;
        this.f40175D = 0;
        this.f40176E = null;
        this.videoProcessState = 0;
        mo7478V();
        if (am_() != null) {
            mo7479W();
            if (!this.isImage) {
                Context context = FrontpageApplication.f27402a;
                context.startService(VideoUploadService.getCancelUploadIntent(context, this.submitRequestId));
            }
            this.submitRequestId = UUID.randomUUID().toString();
            this.mediaOptionsContainer.setVisibility(0);
            this.previewMediaContainer.setVisibility(8);
            as();
            this.f40173B = null;
        }
    }

    private void ar() {
        if (this.mediaFile != null && !this.isImage) {
            aC();
            aD();
            aB();
        }
    }

    private void as() {
        this.videoPreview.setPlayer(null);
        this.f40173B = null;
        if (this.f40178M != null) {
            this.f40178M.m24368d();
            this.f40178M.m24365b(f40170G);
            this.f40178M = null;
        }
    }

    private void aB() {
        this.mediaOptionsContainer.setVisibility(8);
        this.previewMediaContainer.setVisibility(0);
        mo7478V();
        if (this.isImage) {
            this.imagePreview.setVisibility(0);
            this.videoPreview.setVisibility(8);
            ao();
            return;
        }
        this.imagePreview.setVisibility(8);
        this.videoPreview.setVisibility(0);
        this.f40178M = VideoPlayer.m24338a(f40170G);
        if (this.f40178M == null) {
            this.f40178M = VideoPlayer.m24336a(am_(), f40170G, f40170G);
            this.f40178M.m24361a(this.mediaFile.getAbsolutePath(), null, this.isGif);
            this.videoPreview.setPlayer(this.f40178M.f22221c);
        }
        this.videoPreview.setUseController(this.isGif ^ 1);
        this.f40178M.m24362a(this.isGif);
        this.f40178M.m24366c();
        if (!this.f40178M.f22223e) {
            FrontpageApplication.m28873i().mo5025a().m23652a();
        }
        if (this.f40173B == null) {
            Maybe.fromCallable(new MediaSubmitScreen$$Lambda$8(this)).subscribeOn(SchedulerProvider.m23885a()).observeOn(SchedulerProvider.m23887c()).subscribe(new MediaSubmitScreen$$Lambda$9(this), MediaSubmitScreen$$Lambda$10.f29314a);
        }
    }

    private boolean m41114f(String str) {
        try {
            this.mediaFile = new File(new URI(str));
        } catch (Throwable e) {
            Timber.c(e, e.getMessage(), new Object[0]);
        }
        if (this.mediaFile == null) {
            try {
                StringBuilder stringBuilder = new StringBuilder("file://");
                stringBuilder.append(str.replace(" ", "%20"));
                this.mediaFile = new File(new URI(stringBuilder.toString()));
            } catch (String str2) {
                Timber.c(str2, str2.getMessage(), new Object[0]);
            }
        }
        if (this.mediaFile != null) {
            return true;
        }
        return false;
    }

    final void m41128d(boolean z) {
        this.isImage = z;
        if (PermissionUtil.m23865a((Screen) this)) {
            Intent intent = new Intent(z ? "android.media.action.IMAGE_CAPTURE" : "android.media.action.VIDEO_CAPTURE");
            Context am_ = am_();
            int i = (am_ == null || intent.resolveActivity(am_.getPackageManager()) == null) ? 0 : 1;
            if (i != 0) {
                if (z) {
                    try {
                        this.mediaFile = FileUtil.m23689a(0);
                    } catch (Throwable e) {
                        Timber.c(e, f40170G, new Object[0]);
                    }
                }
                m41109a(intent, z);
                return;
            }
            mo7204a((CharSequence) Util.m24027f((int) true));
        }
    }

    private void m41109a(Intent intent, boolean z) {
        if (!z) {
            a(intent, 1);
        } else if (this.mediaFile) {
            z = FileProvider.a(aq_(), Util.m24027f((int) C1761R.string.provider_authority_file), this.mediaFile);
            intent.putExtra("output", z);
            intent.addFlags(1);
            intent.addFlags(2);
            if (VERSION.SDK_INT < 21) {
                Activity am_ = am_();
                if (am_ != null) {
                    for (ResolveInfo resolveInfo : am_.getPackageManager().queryIntentActivities(intent, 65536)) {
                        am_.grantUriPermission(resolveInfo.activityInfo.packageName, z, 3);
                    }
                }
            }
            a(intent, false);
        }
    }

    private void m41108a(int i) {
        RedditAlertDialog redditAlertDialog = new RedditAlertDialog(am_(), (byte) 0);
        redditAlertDialog.f21113a.b(i == 1 ? C1761R.string.video_file_size_exceeded : C1761R.string.video_length_exceeded).a(C1761R.string.action_okay, null);
        this.f40179N = redditAlertDialog.m23323a();
    }

    private void aC() {
        if (this.f40182Q == null) {
            this.f40182Q = new CompositeDisposable();
        }
        this.f40182Q.mo5631a(VideoUploadService.getProgressObservable().filter(new MediaSubmitScreen$$Lambda$14(this)).distinctUntilChanged().observeOn(SchedulerProvider.m23887c()).subscribe(new MediaSubmitScreen$$Lambda$15(this)));
    }

    private void aD() {
        if (this.f40182Q == null) {
            this.f40182Q = new CompositeDisposable();
        }
        this.f40182Q.mo5631a(VideoUploadService.getUploadFailedObservable().filter(new MediaSubmitScreen$$Lambda$16(this)).observeOn(SchedulerProvider.m23887c()).subscribe(new MediaSubmitScreen$$Lambda$17(this)));
    }

    final /* synthetic */ void al() throws Exception {
        this.f40172A = true;
        m39529Y();
        mo7204a(Util.m24027f((int) C1761R.string.error_unable_to_upload_video));
    }

    private void aE() {
        aF();
        this.f40180O = RedditAlertDialog.m23309a(am_(), (int) C1761R.string.processing_file, false);
        this.f40180O.show();
    }

    private void aF() {
        if (this.f40180O != null && this.f40180O.isShowing()) {
            this.f40180O.dismiss();
        }
        this.f40180O = null;
    }

    final /* synthetic */ void ak() throws Exception {
        aG();
    }

    private void aG() {
        this.videoProcessState = 4;
        if (this.e) {
            aF();
            mo7204a(Util.m24027f((int) C1761R.string.error_unable_to_load_video));
            aq();
        }
    }

    private int aH() {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(am_(), Uri.fromFile(this.mediaFile));
        return (int) Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
    }

    protected final void mo6993c(View view) {
        if (this.f40182Q != null) {
            this.f40182Q.mo5626a();
            this.f40182Q = null;
        }
        as();
        m39529Y();
        if (this.f40179N != null && this.f40179N.isShowing()) {
            this.f40179N.dismiss();
        }
        this.f40179N = null;
        if (this.f40181P != null && this.f40181P.isShowing()) {
            this.f40181P.dismiss();
        }
        this.f40181P = null;
        aF();
        super.mo6993c(view);
    }

    public final void mo7479W() {
        View view = this.f39344y;
        if (view != null) {
            if (!mo7487X()) {
                view.setEnabled(false);
            } else if (ap()) {
                view.setEnabled(true);
            } else {
                view.setEnabled(false);
            }
        }
    }

    final /* synthetic */ void m41129e(String str) {
        this.mediaFile = !TextUtils.isEmpty(str) ? new File(str) : null;
        if (this.mediaFile == null) {
            aG();
            return;
        }
        int i = 2;
        this.videoProcessState = 2;
        if (this.e) {
            aF();
            Object obj = 1;
            if ((this.mediaFile.length() <= 1000000000 ? 1 : null) == null) {
                i = 1;
            } else {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(am_(), Uri.fromFile(this.mediaFile));
                if (Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) > f40171H) {
                    obj = null;
                }
                if (obj != null) {
                    i = null;
                }
            }
            if (i == null) {
                this.f40174C = aH();
                this.videoProcessState = 3;
                Context am_ = am_();
                if (am_ != null) {
                    a(VideoPreviewActivity.m42720a(am_, this.mediaFile.getAbsolutePath()), 3);
                }
                return;
            }
            m41108a(i);
            aq();
        }
    }

    final /* synthetic */ VideoUpload an() {
        return (VideoUpload) SQLite.select(new IProperty[0]).from(VideoUpload.class).where(new SQLOperator[]{VideoUpload_Table.requestId.eq(this.submitRequestId)}).querySingle();
    }
}
