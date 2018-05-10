package com.twitter.sdk.android.tweetui.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.twitter.sdk.android.tweetui.C2075R;

public class VideoControlView extends FrameLayout {
    MediaPlayerControl f24267a;
    ImageButton f24268b;
    TextView f24269c;
    TextView f24270d;
    SeekBar f24271e;
    @SuppressLint({"HandlerLeak"})
    public final Handler f24272f = new C20841(this);

    class C20841 extends Handler {
        final /* synthetic */ VideoControlView f24264a;

        C20841(VideoControlView videoControlView) {
            this.f24264a = videoControlView;
        }

        public void handleMessage(Message message) {
            if (message.what == 1001 && this.f24264a.f24267a != null) {
                message = this.f24264a;
                int duration = message.f24267a.getDuration();
                int currentPosition = message.f24267a.getCurrentPosition();
                int bufferPercentage = message.f24267a.getBufferPercentage();
                message.setDuration(duration);
                message.setCurrentTime(currentPosition);
                message.m25989a(currentPosition, duration, bufferPercentage);
                message = this.f24264a;
                if (message.f24267a.mo5517c()) {
                    message.f24268b.setImageResource(C2075R.drawable.tw__video_pause_btn);
                    message.f24268b.setContentDescription(message.getContext().getString(C2075R.string.tw__pause));
                } else if (message.f24267a.getCurrentPosition() > Math.max(message.f24267a.getDuration() - 500, 0)) {
                    message.f24268b.setImageResource(C2075R.drawable.tw__video_replay_btn);
                    message.f24268b.setContentDescription(message.getContext().getString(C2075R.string.tw__replay));
                } else {
                    message.f24268b.setImageResource(C2075R.drawable.tw__video_play_btn);
                    message.f24268b.setContentDescription(message.getContext().getString(C2075R.string.tw__play));
                }
                if (!(this.f24264a.m25991c() == null || this.f24264a.f24267a.mo5517c() == null)) {
                    sendMessageDelayed(obtainMessage(CredentialsApi.ACTIVITY_RESULT_OTHER_ACCOUNT), 500);
                }
            }
        }
    }

    class C20852 implements OnClickListener {
        final /* synthetic */ VideoControlView f24265a;

        C20852(VideoControlView videoControlView) {
            this.f24265a = videoControlView;
        }

        public void onClick(View view) {
            if (this.f24265a.f24267a.mo5517c() != null) {
                this.f24265a.f24267a.mo5516b();
            } else {
                this.f24265a.f24267a.mo5514a();
            }
            this.f24265a.m25990b();
        }
    }

    class C20863 implements OnSeekBarChangeListener {
        final /* synthetic */ VideoControlView f24266a;

        C20863(VideoControlView videoControlView) {
            this.f24266a = videoControlView;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                seekBar = (int) (((long) (this.f24266a.f24267a.getDuration() * i)) / 1000);
                this.f24266a.f24267a.mo5515a(seekBar);
                this.f24266a.setCurrentTime(seekBar);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            this.f24266a.f24272f.removeMessages(CredentialsApi.ACTIVITY_RESULT_OTHER_ACCOUNT);
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            this.f24266a.f24272f.sendEmptyMessage(CredentialsApi.ACTIVITY_RESULT_OTHER_ACCOUNT);
        }
    }

    public interface MediaPlayerControl {
        void mo5514a();

        void mo5515a(int i);

        void mo5516b();

        boolean mo5517c();

        int getBufferPercentage();

        int getCurrentPosition();

        int getDuration();
    }

    public VideoControlView(Context context) {
        super(context);
    }

    public VideoControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMediaPlayer(MediaPlayerControl mediaPlayerControl) {
        this.f24267a = mediaPlayerControl;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C2075R.layout.tw__video_control, this);
        this.f24268b = (ImageButton) findViewById(C2075R.id.tw__state_control);
        this.f24269c = (TextView) findViewById(C2075R.id.tw__current_time);
        this.f24270d = (TextView) findViewById(C2075R.id.tw__duration);
        this.f24271e = (SeekBar) findViewById(C2075R.id.tw__progress);
        this.f24271e.setMax(1000);
        this.f24271e.setOnSeekBarChangeListener(new C20863(this));
        this.f24268b.setOnClickListener(new C20852(this));
        setDuration(0);
        setCurrentTime(0);
        m25989a(0, 0, 0);
    }

    void setDuration(int i) {
        this.f24270d.setText(MediaTimeUtils.m25955a((long) i));
    }

    void setCurrentTime(int i) {
        this.f24269c.setText(MediaTimeUtils.m25955a((long) i));
    }

    final void m25989a(int i, int i2, int i3) {
        this.f24271e.setProgress((int) (i2 > 0 ? (1000 * ((long) i)) / ((long) i2) : 0));
        this.f24271e.setSecondaryProgress(i3 * 10);
    }

    final void m25988a() {
        this.f24272f.removeMessages(CredentialsApi.ACTIVITY_RESULT_OTHER_ACCOUNT);
        AnimationUtils.m25950a(this);
    }

    final void m25990b() {
        this.f24272f.sendEmptyMessage(CredentialsApi.ACTIVITY_RESULT_OTHER_ACCOUNT);
        AnimationUtils.m25951b(this);
    }

    public final boolean m25991c() {
        return getVisibility() == 0;
    }
}
