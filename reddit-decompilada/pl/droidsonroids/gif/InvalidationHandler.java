package pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Iterator;

class InvalidationHandler extends Handler {
    private final WeakReference<GifDrawable> f41200a;

    public InvalidationHandler(GifDrawable gifDrawable) {
        super(Looper.getMainLooper());
        this.f41200a = new WeakReference(gifDrawable);
    }

    public void handleMessage(Message message) {
        GifDrawable gifDrawable = (GifDrawable) this.f41200a.get();
        if (gifDrawable != null) {
            if (message.what == -1) {
                gifDrawable.invalidateSelf();
                return;
            }
            Iterator it = gifDrawable.f41154g.iterator();
            while (it.hasNext()) {
                it.next();
                int i = message.what;
            }
        }
    }
}
