package com.instabug.library.internal.media;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.HashMap;
import java.util.Map;

public class AudioPlayer {
    private String filePath;
    private MediaPlayer mediaPlayer;
    private OnCompletionListener onCompletionListener;
    private C0678b onGetDurationListener;
    private Map<String, OnStopListener> onStopListeners = new HashMap();

    class C06752 implements OnCompletionListener {
        final /* synthetic */ AudioPlayer f9604a;

        C06752(AudioPlayer audioPlayer) {
            this.f9604a = audioPlayer;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            this.f9604a.notifyOnStopListeners();
        }
    }

    public static abstract class OnStopListener {
        private String filePath;

        public abstract void onStop();

        public String getFilePath() {
            return this.filePath;
        }

        public OnStopListener(String str) {
            this.filePath = str;
        }
    }

    enum C0677a {
        START,
        PAUSE,
        GET_DURATION
    }

    public interface C0678b {
        void mo2566a(int i);
    }

    private void prepare(final C0677a c0677a) {
        try {
            this.mediaPlayer = new MediaPlayer();
            this.mediaPlayer.setDataSource(this.filePath);
            this.mediaPlayer.setOnPreparedListener(new OnPreparedListener(this) {
                final /* synthetic */ AudioPlayer f9603b;

                public void onPrepared(MediaPlayer mediaPlayer) {
                    this.f9603b.doAction(c0677a);
                }
            });
            this.mediaPlayer.prepareAsync();
            if (this.onCompletionListener != null) {
                this.mediaPlayer.setOnCompletionListener(this.onCompletionListener);
            }
        } catch (C0677a c0677a2) {
            InstabugSDKLogger.m8358e(this, "Playing audio file failed", c0677a2);
        }
    }

    public void addOnStopListener(OnStopListener onStopListener) {
        this.onStopListeners.put(onStopListener.getFilePath(), onStopListener);
        if (this.onCompletionListener == null) {
            this.onCompletionListener = new C06752(this);
            if (this.mediaPlayer != null) {
                this.mediaPlayer.setOnCompletionListener(this.onCompletionListener);
            }
        }
    }

    private void notifyOnStopListeners() {
        for (OnStopListener onStop : this.onStopListeners.values()) {
            onStop.onStop();
        }
    }

    private void stream(String str, C0677a c0677a) {
        if (str == null) {
            InstabugSDKLogger.m8357e(this, "Audio file path can not be null");
        } else if (str.equals(this.filePath)) {
            doAction(c0677a);
        } else {
            this.filePath = str;
            prepare(c0677a);
        }
    }

    public void getDurationAsync(String str, C0678b c0678b) {
        stream(str, C0677a.GET_DURATION);
        this.onGetDurationListener = c0678b;
    }

    public void start(String str) {
        pause();
        stream(str, C0677a.START);
    }

    public void pause() {
        notifyOnStopListeners();
        doAction(C0677a.PAUSE);
    }

    public void release() {
        this.filePath = null;
        if (this.mediaPlayer != null) {
            if (this.mediaPlayer.isPlaying()) {
                this.mediaPlayer.stop();
            }
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    private void doAction(C0677a c0677a) {
        switch (c0677a) {
            case START:
                if (this.mediaPlayer.isPlaying() == null) {
                    this.mediaPlayer.start();
                    return;
                }
                break;
            case PAUSE:
                if (!(this.mediaPlayer == null || this.mediaPlayer.isPlaying() == null)) {
                    this.mediaPlayer.pause();
                    return;
                }
            case GET_DURATION:
                this.onGetDurationListener.mo2566a(this.mediaPlayer.getDuration());
                break;
            default:
                break;
        }
    }

    public static String getFormattedDurationText(long j) {
        int i = (int) (j / 3600000);
        int i2 = (int) ((j % 3600000) / 60000);
        j = (int) ((j % 60000) / 1000);
        if (i > 0) {
            return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(j)});
        }
        return String.format("%02d:%02d", new Object[]{Integer.valueOf(i2), Integer.valueOf(j)});
    }
}
