package com.instabug.library.internal.video;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import com.instabug.library.C0593R;
import com.instabug.library.C0645b;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.InstabugBaseFragment;
import com.instabug.library.InstabugCustomTextPlaceHolder.Key;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.PlaceHolderUtils;

public class VideoPlayerFragment extends InstabugBaseFragment {
    public static final String TAG = "video_player_fragment";
    public static final String VIDEO_PATH = "video.uri";
    private MediaController mediaControls;
    private int position = 0;
    private ProgressDialog progressDialog;
    private String videoUri;
    private VideoView videoView;

    class C06891 implements OnPreparedListener {
        final /* synthetic */ VideoPlayerFragment f9628a;

        C06891(VideoPlayerFragment videoPlayerFragment) {
            this.f9628a = videoPlayerFragment;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            this.f9628a.progressDialog.dismiss();
            this.f9628a.videoView.seekTo(this.f9628a.position);
            if (this.f9628a.position == null) {
                this.f9628a.videoView.start();
            } else {
                this.f9628a.videoView.pause();
            }
        }
    }

    class C06902 implements OnErrorListener {
        final /* synthetic */ VideoPlayerFragment f9629a;

        C06902(VideoPlayerFragment videoPlayerFragment) {
            this.f9629a = videoPlayerFragment;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            this.f9629a.progressDialog.dismiss();
            return null;
        }
    }

    public static VideoPlayerFragment newInstance(String str) {
        VideoPlayerFragment videoPlayerFragment = new VideoPlayerFragment();
        Bundle bundle = new Bundle();
        bundle.putString(VIDEO_PATH, str);
        videoPlayerFragment.setArguments(bundle);
        return videoPlayerFragment;
    }

    protected int getLayout() {
        return C0593R.layout.instabug_lyt_video_view;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.videoView = (VideoView) view.findViewById(C0593R.id.video_view);
        if (C0645b.m8104a().m8113b(Feature.WHITE_LABELING) == State.DISABLED) {
            getActivity().findViewById(C0593R.id.instabug_pbi_footer).setVisibility(8);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.mediaControls == null) {
            this.mediaControls = new MediaController(getActivity());
        }
        this.progressDialog = new ProgressDialog(getActivity());
        this.progressDialog.setMessage("Loading...");
        this.progressDialog.setCancelable(false);
        this.progressDialog.show();
        try {
            this.videoView.setMediaController(this.mediaControls);
            this.videoView.setVideoURI(Uri.parse(this.videoUri));
        } catch (Bundle bundle2) {
            InstabugSDKLogger.m8358e(this, bundle2.getMessage(), bundle2);
        }
        this.videoView.requestFocus();
        this.videoView.setOnPreparedListener(new C06891(this));
        this.videoView.setOnErrorListener(new C06902(this));
    }

    protected String getTitle() {
        return PlaceHolderUtils.getPlaceHolder(Key.VIDEO_PLAYER_TITLE, getString(C0593R.string.instabug_str_video_player));
    }

    protected void consumeNewInstanceSavedArguments() {
        this.videoUri = getArguments().getString(VIDEO_PATH);
    }

    protected void restoreState(Bundle bundle) {
        this.position = bundle.getInt("Position");
        this.videoView.seekTo(this.position);
    }

    protected void saveState(Bundle bundle) {
        bundle.putInt("Position", this.videoView.getCurrentPosition());
        this.videoView.pause();
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (C0645b.m8104a().m8113b(Feature.WHITE_LABELING) == State.DISABLED) {
            getActivity().findViewById(C0593R.id.instabug_pbi_footer).setVisibility(0);
        }
    }
}
