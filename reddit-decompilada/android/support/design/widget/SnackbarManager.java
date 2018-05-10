package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class SnackbarManager {
    private static SnackbarManager f608d;
    final Object f609a = new Object();
    SnackbarRecord f610b;
    SnackbarRecord f611c;
    private final Handler f612e = new Handler(Looper.getMainLooper(), new C00371(this));

    class C00371 implements android.os.Handler.Callback {
        final /* synthetic */ SnackbarManager f604a;

        C00371(SnackbarManager snackbarManager) {
            this.f604a = snackbarManager;
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return null;
            }
            SnackbarManager snackbarManager = this.f604a;
            SnackbarRecord snackbarRecord = (SnackbarRecord) message.obj;
            synchronized (snackbarManager.f609a) {
                if (snackbarManager.f610b == snackbarRecord || snackbarManager.f611c == snackbarRecord) {
                    snackbarManager.m290a(snackbarRecord, 2);
                }
            }
            return true;
        }
    }

    interface Callback {
        void mo60a();

        void mo61a(int i);
    }

    private static class SnackbarRecord {
        final WeakReference<Callback> f605a;
        int f606b;
        boolean f607c;

        SnackbarRecord(int i, Callback callback) {
            this.f605a = new WeakReference(callback);
            this.f606b = i;
        }

        final boolean m281a(Callback callback) {
            return (callback == null || this.f605a.get() != callback) ? null : true;
        }
    }

    static SnackbarManager m282a() {
        if (f608d == null) {
            f608d = new SnackbarManager();
        }
        return f608d;
    }

    private SnackbarManager() {
    }

    public final void m287a(int i, Callback callback) {
        synchronized (this.f609a) {
            if (m285f(callback)) {
                this.f610b.f606b = i;
                this.f612e.removeCallbacksAndMessages(this.f610b);
                m283a(this.f610b);
                return;
            }
            if (m286g(callback)) {
                this.f611c.f606b = i;
            } else {
                this.f611c = new SnackbarRecord(i, callback);
            }
            if (this.f610b == 0 || m290a(this.f610b, 4) == 0) {
                this.f610b = 0;
                m284b();
                return;
            }
        }
    }

    public final void m289a(Callback callback, int i) {
        synchronized (this.f609a) {
            if (m285f(callback)) {
                m290a(this.f610b, i);
            } else if (m286g(callback) != null) {
                m290a(this.f611c, i);
            }
        }
    }

    public final void m288a(Callback callback) {
        synchronized (this.f609a) {
            if (m285f(callback) != null) {
                this.f610b = null;
                if (this.f611c != null) {
                    m284b();
                }
            }
        }
    }

    public final void m291b(Callback callback) {
        synchronized (this.f609a) {
            if (m285f(callback) != null) {
                m283a(this.f610b);
            }
        }
    }

    public final void m292c(Callback callback) {
        synchronized (this.f609a) {
            if (m285f(callback) != null && this.f610b.f607c == null) {
                this.f610b.f607c = true;
                this.f612e.removeCallbacksAndMessages(this.f610b);
            }
        }
    }

    public final void m293d(Callback callback) {
        synchronized (this.f609a) {
            if (!(m285f(callback) == null || this.f610b.f607c == null)) {
                this.f610b.f607c = false;
                m283a(this.f610b);
            }
        }
    }

    public final boolean m294e(Callback callback) {
        synchronized (this.f609a) {
            if (!m285f(callback)) {
                if (m286g(callback) == null) {
                    callback = null;
                }
            }
            callback = true;
        }
        return callback;
    }

    private void m284b() {
        if (this.f611c != null) {
            this.f610b = this.f611c;
            this.f611c = null;
            Callback callback = (Callback) this.f610b.f605a.get();
            if (callback != null) {
                callback.mo60a();
                return;
            }
            this.f610b = null;
        }
    }

    final boolean m290a(SnackbarRecord snackbarRecord, int i) {
        Callback callback = (Callback) snackbarRecord.f605a.get();
        if (callback == null) {
            return null;
        }
        this.f612e.removeCallbacksAndMessages(snackbarRecord);
        callback.mo61a(i);
        return true;
    }

    private boolean m285f(Callback callback) {
        return (this.f610b == null || this.f610b.m281a(callback) == null) ? null : true;
    }

    private boolean m286g(Callback callback) {
        return (this.f611c == null || this.f611c.m281a(callback) == null) ? null : true;
    }

    private void m283a(SnackbarRecord snackbarRecord) {
        if (snackbarRecord.f606b != -2) {
            int i = 2750;
            if (snackbarRecord.f606b > 0) {
                i = snackbarRecord.f606b;
            } else if (snackbarRecord.f606b == -1) {
                i = 1500;
            }
            this.f612e.removeCallbacksAndMessages(snackbarRecord);
            this.f612e.sendMessageDelayed(Message.obtain(this.f612e, 0, snackbarRecord), (long) i);
        }
    }
}
