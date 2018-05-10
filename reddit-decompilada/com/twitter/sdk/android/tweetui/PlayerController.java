package com.twitter.sdk.android.tweetui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.twitter.sdk.android.core.IntentUtils;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.Callback;
import com.twitter.sdk.android.tweetui.internal.VideoControlView;
import com.twitter.sdk.android.tweetui.internal.VideoView;

class PlayerController {
    final VideoView f24191a;
    final VideoControlView f24192b;
    final ProgressBar f24193c;
    final TextView f24194d;
    View f24195e;
    int f24196f = 0;
    boolean f24197g = true;
    final Callback f24198h;

    class C20701 implements OnPreparedListener {
        final /* synthetic */ PlayerController f24185a;

        C20701(PlayerController playerController) {
            this.f24185a = playerController;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            this.f24185a.f24193c.setVisibility(8);
        }
    }

    class C20712 implements OnInfoListener {
        final /* synthetic */ PlayerController f24186a;

        C20712(PlayerController playerController) {
            this.f24186a = playerController;
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 702) {
                this.f24186a.f24193c.setVisibility(8);
                return true;
            } else if (i != 701) {
                return false;
            } else {
                this.f24186a.f24193c.setVisibility(0);
                return true;
            }
        }
    }

    class C20723 implements OnClickListener {
        final /* synthetic */ PlayerController f24187a;

        C20723(PlayerController playerController) {
            this.f24187a = playerController;
        }

        public void onClick(View view) {
            if (this.f24187a.f24191a.mo5517c() != null) {
                this.f24187a.f24191a.mo5516b();
            } else {
                this.f24187a.f24191a.mo5514a();
            }
        }
    }

    class C20734 implements OnClickListener {
        final /* synthetic */ String f24188a;
        final /* synthetic */ PlayerController f24189b;

        C20734(PlayerController playerController, String str) {
            this.f24189b = playerController;
            this.f24188a = str;
        }

        public void onClick(View view) {
            IntentUtils.m25838a(this.f24189b.f24194d.getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.f24188a)));
        }
    }

    class C20745 implements OnClickListener {
        final /* synthetic */ PlayerController f24190a;

        C20745(PlayerController playerController) {
            this.f24190a = playerController;
        }

        public void onClick(View view) {
            if (this.f24190a.f24194d.getVisibility() == null) {
                this.f24190a.f24194d.setVisibility(8);
            } else {
                this.f24190a.f24194d.setVisibility(0);
            }
        }
    }

    PlayerController(View view, Callback callback) {
        this.f24195e = view;
        this.f24191a = (VideoView) view.findViewById(C2075R.id.video_view);
        this.f24192b = (VideoControlView) view.findViewById(C2075R.id.video_control_view);
        this.f24193c = (ProgressBar) view.findViewById(C2075R.id.video_progress_view);
        this.f24194d = (TextView) view.findViewById(C2075R.id.call_to_action_view);
        this.f24198h = callback;
    }
}
