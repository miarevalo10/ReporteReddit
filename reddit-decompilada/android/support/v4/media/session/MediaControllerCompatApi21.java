package android.support.v4.media.session;

import android.media.MediaMetadata;
import android.media.session.MediaSession.QueueItem;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import java.util.List;

@RequiresApi(21)
class MediaControllerCompatApi21 {

    public interface Callback {
        void mo341a();

        void mo342a(int i, int i2, int i3, int i4, int i5);

        void mo343a(Object obj);

        void mo344a(List<?> list);

        void mo345b();

        void mo346b(Object obj);

        void mo347c();

        void mo348d();
    }

    static class CallbackProxy<T extends Callback> extends android.media.session.MediaController.Callback {
        protected final T f1291a;

        public CallbackProxy(T t) {
            this.f1291a = t;
        }

        public void onSessionDestroyed() {
            this.f1291a.mo341a();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            this.f1291a.mo345b();
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f1291a.mo343a((Object) playbackState);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f1291a.mo346b(mediaMetadata);
        }

        public void onQueueChanged(List<QueueItem> list) {
            this.f1291a.mo344a((List) list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f1291a.mo347c();
        }

        public void onExtrasChanged(Bundle bundle) {
            this.f1291a.mo348d();
        }

        public void onAudioInfoChanged(android.media.session.MediaController.PlaybackInfo playbackInfo) {
            this.f1291a.mo342a(playbackInfo.getPlaybackType(), PlaybackInfo.m949a(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }

    public static class PlaybackInfo {
        public static int m949a(Object obj) {
            obj = ((android.media.session.MediaController.PlaybackInfo) obj).getAudioAttributes();
            if ((obj.getFlags() & 1) == 1) {
                return 7;
            }
            if ((obj.getFlags() & 4) == 4) {
                return 6;
            }
            switch (obj.getUsage()) {
                case 1:
                case 11:
                case 12:
                case 14:
                    return 3;
                case 2:
                    return null;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 13:
                    return 1;
                default:
                    return 3;
            }
        }
    }

    public static Object m950a(Callback callback) {
        return new CallbackProxy(callback);
    }
}
