package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import java.util.List;

@RequiresApi(21)
class PlaybackStateCompatApi21 {

    static final class CustomAction {
        public static String m956a(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getAction();
        }

        public static CharSequence m957b(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getName();
        }

        public static int m958c(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getIcon();
        }

        public static Bundle m959d(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getExtras();
        }
    }

    public static int m960a(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static long m961b(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static long m962c(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static float m963d(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long m964e(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static CharSequence m965f(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long m966g(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static List<Object> m967h(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    public static long m968i(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }
}
