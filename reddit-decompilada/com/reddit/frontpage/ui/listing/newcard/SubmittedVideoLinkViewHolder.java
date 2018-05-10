package com.reddit.frontpage.ui.listing.newcard;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubmittedVideoLink;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.MainActivity;
import com.reddit.frontpage.util.SchedulerProvider;
import io.reactivex.Maybe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class SubmittedVideoLinkViewHolder extends LinkViewHolder implements VisibilityDependent {
    private final OnClickListener f37298A = new SubmittedVideoLinkViewHolder$$Lambda$2(this);
    @BindView
    View linkClose;
    @BindView
    View linkEdit;
    @BindView
    TextView linkMessage;
    @BindView
    ImageView linkPreview;
    @BindView
    ProgressBar linkProgress;
    @BindView
    View linkRetry;
    @BindView
    ImageView linkStatus;
    @BindView
    TextView linkSubreddit;
    @BindView
    TextView linkTitle;
    private Disposable f37299v;
    private Disposable f37300w;
    private boolean f37301x;
    private final OnClickListener f37302y = new SubmittedVideoLinkViewHolder$$Lambda$0(this);
    private final OnClickListener f37303z = new SubmittedVideoLinkViewHolder$$Lambda$1(this);

    protected final void mo7001a(int i) {
    }

    protected final void mo7003b(boolean z) {
    }

    public final boolean mo7005v() {
        return true;
    }

    public static SubmittedVideoLinkViewHolder m37633a(ViewGroup viewGroup) {
        return new SubmittedVideoLinkViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_submitted_video_link_legacy, viewGroup, false));
    }

    public final void mo7002a(Link link) {
        super.mo7002a(link);
        this.f37301x = true;
        if (link instanceof SubmittedVideoLink) {
            VideoUpload videoUpload = ((SubmittedVideoLink) link).videoUpload;
            m37639c(videoUpload.getRequestId());
            m37637b(videoUpload);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(link);
        stringBuilder.append(" not of type SubmittedVideoLink");
        throw new ClassCastException(stringBuilder.toString());
    }

    public final void ap() {
        if (!this.f37301x) {
            this.f37301x = true;
            if (this.s != null && (this.s instanceof SubmittedVideoLink)) {
                m37639c(((SubmittedVideoLink) this.s).videoUpload.getRequestId());
            }
        }
    }

    public final void aq() {
        if (this.f37301x) {
            if (this.f37299v != null) {
                this.f37299v.mo5626a();
                this.f37299v = null;
            }
            m37632B();
            this.f37301x = false;
        }
    }

    private SubmittedVideoLinkViewHolder(View view) {
        super(view);
        ButterKnife.a(this, view);
        view.setClickable(false);
        view.setEnabled(false);
    }

    private void m37637b(VideoUpload videoUpload) {
        Timber.b("Binding submitted post [%s], state [%s]", new Object[]{videoUpload.getTitle(), VideoUploadService.getVideoStateName(videoUpload)});
        if (this.s instanceof SubmittedVideoLink) {
            ((SubmittedVideoLink) this.s).videoUpload.setStatus(videoUpload.getStatus());
        }
        GlideApp.a(this.c.getContext()).b(videoUpload.getThumbnail()).centerCrop().into(this.linkPreview).f();
        this.linkClose.setOnClickListener(this.f37302y);
        this.linkEdit.setOnClickListener(this.f37303z);
        this.linkRetry.setOnClickListener(this.f37298A);
        this.linkSubreddit.setText(videoUpload.getSubreddit());
        this.linkTitle.setText(videoUpload.getTitle());
        int status = videoUpload.getStatus();
        switch (status) {
            case 0:
            case 1:
                this.linkProgress.setIndeterminate(true);
                this.linkProgress.setVisibility(0);
                this.linkMessage.setVisibility(0);
                this.linkMessage.setText(C1761R.string.upload_pending);
                this.linkStatus.setVisibility(8);
                this.linkClose.setVisibility(0);
                this.linkRetry.setVisibility(8);
                this.linkEdit.setVisibility(8);
                return;
            case 2:
                this.linkMessage.setVisibility(0);
                this.linkMessage.setText(C1761R.string.uploading);
                this.linkStatus.setVisibility(8);
                this.linkProgress.setVisibility(0);
                this.linkProgress.setIndeterminate(false);
                this.linkProgress.setMax(100);
                if (this.f37300w != null) {
                    this.f37300w.mo5626a();
                }
                this.f37300w = new CompositeDisposable(VideoUploadService.getProgressObservable().filter(new SubmittedVideoLinkViewHolder$$Lambda$8(videoUpload)).distinctUntilChanged().observeOn(SchedulerProvider.m23887c()).subscribe(new SubmittedVideoLinkViewHolder$$Lambda$9(this)));
                this.linkClose.setVisibility(0);
                this.linkRetry.setVisibility(8);
                this.linkEdit.setVisibility(8);
                return;
            case 3:
            case 4:
                m37632B();
                this.linkProgress.setIndeterminate(true);
                this.linkProgress.setVisibility(0);
                this.linkMessage.setVisibility(0);
                this.linkMessage.setText(C1761R.string.uploading);
                this.linkClose.setVisibility(8);
                this.linkStatus.setVisibility(8);
                this.linkRetry.setVisibility(8);
                this.linkEdit.setVisibility(8);
                return;
            case 5:
                m37632B();
                this.linkMessage.setVisibility(0);
                this.linkMessage.setText(C1761R.string.video_upload_processing);
                this.linkClose.setVisibility(8);
                this.linkProgress.setVisibility(4);
                this.linkStatus.setVisibility(0);
                this.linkRetry.setVisibility(8);
                this.linkEdit.setVisibility(8);
                return;
            case 6:
            case 7:
                if (TextUtils.isEmpty(videoUpload.getUploadError())) {
                    m37638b(this.c.getContext().getString(status == 6 ? C1761R.string.video_upload_failed_try_again : C1761R.string.video_post_failed_try_again));
                    break;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(videoUpload.getUploadError().substring(0, 1).toUpperCase());
                stringBuilder.append(videoUpload.getUploadError().substring(1));
                m37638b(stringBuilder.toString());
                return;
            default:
                break;
        }
    }

    private void m37638b(String str) {
        m37632B();
        this.linkMessage.setVisibility(0);
        this.linkMessage.setText(str);
        this.linkClose.setVisibility(0);
        this.linkProgress.setVisibility(4);
        this.linkStatus.setVisibility(8);
        this.linkRetry.setVisibility(0);
        this.linkEdit.setVisibility(0);
    }

    final /* synthetic */ void m37642a(VideoUpload videoUpload) throws Exception {
        if (this.f37301x) {
            m37637b(videoUpload);
        }
    }

    private void m37639c(String str) {
        if (this.f37299v != null) {
            this.f37299v.mo5626a();
        }
        this.f37299v = VideoUploadService.getVideoStateObservable().filter(new SubmittedVideoLinkViewHolder$$Lambda$6(str)).distinctUntilChanged().observeOn(SchedulerProvider.m23887c()).subscribe(new SubmittedVideoLinkViewHolder$$Lambda$7(this));
    }

    private void m37632B() {
        if (this.f37300w != null) {
            this.f37300w.mo5626a();
            this.f37300w = null;
        }
    }

    final /* synthetic */ void m37646x() throws Exception {
        if (this.f37301x && this.s != null && (this.s instanceof SubmittedVideoLink)) {
            Maybe.fromCallable(new SubmittedVideoLinkViewHolder$$Lambda$3(this, ((SubmittedVideoLink) this.s).videoUpload)).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new SubmittedVideoLinkViewHolder$$Lambda$4(this), SubmittedVideoLinkViewHolder$$Lambda$5.f29137a);
        }
    }

    final /* synthetic */ void m37647y() {
        Context context = this.c.getContext();
        context.startService(VideoUploadService.getRetryUploadIntent(context, ((SubmittedVideoLink) this.s).videoUpload.getRequestId()));
    }

    final /* synthetic */ void m37648z() {
        Context context = this.c.getContext();
        Intent a = MainActivity.m42701a(context, ((SubmittedVideoLink) this.s).videoUpload.getRequestId());
        a.addFlags(268435456);
        context.startActivity(a);
    }

    final /* synthetic */ void m37640A() {
        if (SubmittedVideoLink.class.isInstance(this.s)) {
            VideoUpload videoUpload = ((SubmittedVideoLink) this.s).videoUpload;
            Context context = this.c.getContext();
            context.startService(VideoUploadService.getCancelUploadIntent(context, videoUpload.getRequestId()));
        }
    }
}
