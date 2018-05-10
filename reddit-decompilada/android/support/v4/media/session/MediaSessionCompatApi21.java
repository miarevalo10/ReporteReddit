package android.support.v4.media.session;

import android.support.annotation.RequiresApi;

@RequiresApi(21)
class MediaSessionCompatApi21 {

    static class QueueItem {
        public static Object m952a(Object obj) {
            return ((android.media.session.MediaSession.QueueItem) obj).getDescription();
        }

        public static long m953b(Object obj) {
            return ((android.media.session.MediaSession.QueueItem) obj).getQueueId();
        }
    }
}
