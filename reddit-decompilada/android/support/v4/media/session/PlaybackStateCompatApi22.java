package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@RequiresApi(22)
class PlaybackStateCompatApi22 {
    public static Bundle m969a(Object obj) {
        return ((PlaybackState) obj).getExtras();
    }
}
