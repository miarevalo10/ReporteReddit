package com.reddit.frontpage.util;

import android.support.v4.util.SimpleArrayMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import timber.log.Timber;

public class VideoStateUtil {
    private static final SimpleArrayMap<String, VideoState> f21817a = new SimpleArrayMap();
    private static final HashSet<String> f21818b = new HashSet();

    public static final class VideoState {
        private static final long MAX_LIFE_TIME_MINUTES = 10;
        private long lastUpdated = System.currentTimeMillis();
        boolean muted;
        boolean paused;
        boolean playing;
        long position;

        public VideoState(boolean z, long j, boolean z2) {
            this.playing = z;
            this.position = j;
            this.muted = z2;
        }

        public final boolean isPlaying() {
            return this.playing;
        }

        public final boolean isPaused() {
            return this.paused;
        }

        public final void setPaused(boolean z) {
            this.paused = z;
        }

        public final long getPosition() {
            return this.position;
        }

        public final boolean isMuted() {
            return this.muted;
        }

        final void update(boolean z, long j, boolean z2) {
            this.playing = z;
            this.position = j;
            this.muted = z2;
            this.lastUpdated = System.currentTimeMillis();
        }

        final boolean hasExpired() {
            return TimeUnit.MINUTES.convert(System.currentTimeMillis() - this.lastUpdated, TimeUnit.MILLISECONDS) >= MAX_LIFE_TIME_MINUTES;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("VideoState{playing=");
            stringBuilder.append(this.playing);
            stringBuilder.append(", position=");
            stringBuilder.append(this.position);
            stringBuilder.append(", muted=");
            stringBuilder.append(this.muted);
            stringBuilder.append(", lastUpdated=");
            stringBuilder.append(this.lastUpdated);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static VideoState m24046a(String str) {
        VideoState videoState = (VideoState) f21817a.get(str);
        String str2 = "Restoring state for [%s], [%s]";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = videoState != null ? videoState.toString() : "null";
        Timber.b(str2, objArr);
        return (videoState == null || videoState.hasExpired() != null) ? null : videoState;
    }

    public static void m24049b(String str) {
        Timber.b("Removing state for [%s]", new Object[]{str});
        f21817a.remove(str);
    }

    public static void m24048a(String str, boolean z, long j, boolean z2) {
        VideoState videoState = (VideoState) f21817a.get(str);
        if (videoState == null) {
            videoState = new VideoState(z, j, z2);
        } else {
            videoState.update(z, j, z2);
        }
        Timber.b("Saving state for [%s], [%s]", new Object[]{str, videoState.toString()});
        f21817a.put(str, videoState);
    }

    public static void m24047a() {
        Timber.b("Reset video states", new Object[0]);
        f21817a.clear();
        f21818b.clear();
    }

    public static boolean m24050c(String str) {
        return f21818b.contains(str);
    }

    public static void m24051d(String str) {
        f21818b.add(str);
    }
}
