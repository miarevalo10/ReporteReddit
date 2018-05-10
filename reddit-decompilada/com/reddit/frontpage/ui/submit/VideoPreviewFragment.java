package com.reddit.frontpage.ui.submit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.BaseActivity.OnBackPressedListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.service.video.VideoTrimService;
import com.reddit.frontpage.ui.BaseFrontpageFragment;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.widgets.video.ClippingBarView;
import com.reddit.frontpage.widgets.video.ClippingBounds;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;
import com.reddit.frontpage.widgets.video.VideoPlayer;
import io.reactivex.Maybe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.io.File;

public class VideoPreviewFragment extends BaseFrontpageFragment implements OnBackPressedListener {
    String f39355a;
    VideoPlayer f39356b;
    File f39357c;
    @BindView
    ClippingBarView clippingBarView;
    ClippingBounds f39358d;
    DialogFragment f39359g;
    @BindView
    SwitchCompat gifSwitch;
    Bitmap f39360h;
    private CompositeDisposable f39361i;
    private Disposable f39362j;
    private boolean f39363k;
    private AlertDialog f39364l;
    @BindView
    SimpleExoPlayerView simpleExoPlayerView;
    @BindView
    ViewGroup videoLayout;

    public String getAnalyticsScreenName() {
        return "videopreview";
    }

    public final int mo7160h() {
        return C1761R.layout.fragment_video_preview;
    }

    public static VideoPreviewFragment m39570a(String str) {
        VideoPreviewFragment videoPreviewFragment = new VideoPreviewFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("file_path", str);
        videoPreviewFragment.setArguments(bundle);
        return videoPreviewFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.f39355a = getArguments().getString("file_path");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        ButterKnife.a(this, this.e);
        this.f39357c = new File(this.f39355a);
        m39572b();
        this.gifSwitch.setOnCheckedChangeListener(new VideoPreviewFragment$$Lambda$0(this));
        return this.e;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C1761R.menu.menu_video_preview, menu);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onOptionsItemSelected(android.view.MenuItem r7) {
        /*
        r6 = this;
        r0 = r7.getItemId();
        r1 = 2131427392; // 0x7f0b0040 float:1.8476399E38 double:1.053065051E-314;
        if (r0 == r1) goto L_0x000e;
    L_0x0009:
        r7 = super.onOptionsItemSelected(r7);
        return r7;
    L_0x000e:
        r7 = r6.f39363k;
        r0 = 1;
        if (r7 != 0) goto L_0x0092;
    L_0x0013:
        r6.f39363k = r0;
        r7 = r6.f39358d;
        r1 = 0;
        if (r7 == 0) goto L_0x0054;
    L_0x001a:
        r7 = r6.f39358d;
        r7 = r7.f22104b;
        if (r7 <= 0) goto L_0x0022;
    L_0x0020:
        r7 = r0;
        goto L_0x0023;
    L_0x0022:
        r7 = r1;
    L_0x0023:
        if (r7 != 0) goto L_0x0053;
    L_0x0025:
        r7 = new android.media.MediaMetadataRetriever;
        r7.<init>();
        r2 = r6.getActivity();
        r3 = r6.f39357c;
        r3 = android.net.Uri.fromFile(r3);
        r7.setDataSource(r2, r3);
        r2 = 9;
        r7 = r7.extractMetadata(r2);
        r2 = java.lang.Long.parseLong(r7);
        r4 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r2 = r2 + r4;
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 / r4;
        r7 = (int) r2;
        r2 = r6.f39358d;
        r2 = r2.f22105c;
        if (r2 >= r7) goto L_0x0050;
    L_0x004e:
        r7 = r0;
        goto L_0x0051;
    L_0x0050:
        r7 = r1;
    L_0x0051:
        if (r7 == 0) goto L_0x0054;
    L_0x0053:
        r1 = r0;
    L_0x0054:
        if (r1 == 0) goto L_0x0089;
    L_0x0056:
        r7 = r6.f39356b;
        r7.m24368d();
        r7 = com.reddit.frontpage.ui.submit.TrimVideoDialog.m37832c();
        r6.f39359g = r7;
        r7 = r6.f39359g;
        r1 = r6.getFragmentManager();
        r2 = "TrimVideoDialog";
        r7.a(r1, r2);
        r6.m39573c();
        r7 = r6.getActivity();
        r1 = r6.f39357c;
        r1 = r1.getAbsolutePath();
        r2 = r6.f39358d;
        r2 = r2.f22104b;
        r3 = r6.f39358d;
        r3 = r3.f22105c;
        r1 = com.reddit.frontpage.service.video.VideoTrimService.m23252a(r7, r1, r2, r3);
        r7.startService(r1);
        goto L_0x0092;
    L_0x0089:
        r7 = r6.f39357c;
        r7 = r7.getAbsolutePath();
        r6.m39575b(r7);
    L_0x0092:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.ui.submit.VideoPreviewFragment.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    public void onResume() {
        super.onResume();
        this.f39361i = new CompositeDisposable();
        this.f39361i.mo5631a(FrontpageApplication.m28872h().mo4569b().f22106a.filter(new VideoPreviewFragment$$Lambda$5(this)).observeOn(SchedulerProvider.m23887c()).subscribe(new VideoPreviewFragment$$Lambda$6(this)));
        this.f39361i.mo5631a(ClippingBarView.getClippingEndReachedObservable().observeOn(SchedulerProvider.m23887c()).subscribe(new VideoPreviewFragment$$Lambda$7(this)));
        this.f39361i.mo5631a(ClippingBarView.getClippingEventObservable().observeOn(SchedulerProvider.m23887c()).filter(new VideoPreviewFragment$$Lambda$8(this)).subscribe(new VideoPreviewFragment$$Lambda$9(this)));
        this.f39359g = (DialogFragment) getFragmentManager().a("TrimVideoDialog");
        if (this.f39359g != null) {
            m39573c();
        }
        m39572b();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).m42470a(this);
        }
    }

    public void onDetach() {
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).m42471b(this);
        }
        super.onDetach();
    }

    public final boolean mo4975a() {
        RedditAlertDialog redditAlertDialog = new RedditAlertDialog(getActivity(), true);
        redditAlertDialog.f21113a.b(C1761R.string.discard_preview_video).a(C1761R.string.action_discard, new VideoPreviewFragment$$Lambda$1(this)).b(C1761R.string.action_cancel, null);
        redditAlertDialog.m23323a();
        return true;
    }

    private void m39572b() {
        if (this.f39357c != null) {
            if (this.f39356b == null) {
                this.f39356b = VideoPlayer.m24336a(getContext(), "PREVIEW_FRAGMENT", "PREVIEW_FRAGMENT");
                this.f39356b.m24361a(this.f39357c.getAbsolutePath(), null, this.gifSwitch.isChecked());
            }
            boolean isChecked = this.gifSwitch.isChecked();
            this.simpleExoPlayerView.setPlayer(this.f39356b.f22221c);
            this.f39356b.m24366c();
            this.f39356b.m24362a(isChecked);
            if (!this.f39356b.f22223e) {
                FrontpageApplication.m28873i().mo5025a().m23652a();
            }
            this.clippingBarView.setVideoPlayer(this.f39356b);
            if (this.f39360h == null) {
                Maybe.fromCallable(new VideoPreviewFragment$$Lambda$2(this)).subscribeOn(SchedulerProvider.m23885a()).observeOn(SchedulerProvider.m23887c()).subscribe(new VideoPreviewFragment$$Lambda$3(this), VideoPreviewFragment$$Lambda$4.f29337a);
            }
        }
    }

    final void m39575b(String str) {
        Intent intent = new Intent();
        intent.putExtra("media_path", str);
        intent.putExtra("convert_to_gif", this.gifSwitch.isChecked());
        str = getActivity();
        str.setResult(-1, intent);
        str.finish();
    }

    private void m39573c() {
        if (this.f39362j != null) {
            this.f39362j.mo5626a();
        }
        this.f39362j = VideoTrimService.m23253a().filter(new VideoPreviewFragment$$Lambda$10(this)).observeOn(SchedulerProvider.m23887c()).subscribe(new VideoPreviewFragment$$Lambda$11(this));
    }

    public void onPause() {
        if (this.f39361i != null) {
            this.f39361i.mo5626a();
            this.f39361i = null;
        }
        if (this.f39362j != null) {
            this.f39362j.mo5626a();
            this.f39362j = null;
        }
        if (getActivity().isFinishing()) {
            this.clippingBarView.setVideoPlayer(null);
            this.simpleExoPlayerView.setPlayer(null);
            this.clippingBarView.setVideoPlayer(null);
            if (this.f39356b != null) {
                this.f39356b.m24365b("PREVIEW_FRAGMENT");
                this.f39356b = null;
            }
        } else if (this.f39356b != null) {
            this.f39356b.m24368d();
        }
        if (this.f39364l != null && this.f39364l.isShowing()) {
            this.f39364l.dismiss();
        }
        this.f39364l = null;
        super.onPause();
    }
}
