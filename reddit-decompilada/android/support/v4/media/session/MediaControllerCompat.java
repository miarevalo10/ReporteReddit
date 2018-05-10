package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.annotation.RequiresApi;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback.Stub;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public final class MediaControllerCompat {

    public static abstract class Callback implements DeathRecipient {
        MessageHandler f1279a;
        boolean f1280b;
        private final Object f1281c;

        private class MessageHandler extends Handler {
            boolean f1278a;

            public void handleMessage(Message message) {
                if (this.f1278a) {
                    switch (message.what) {
                        case 1:
                            Object obj = message.obj;
                            message.getData();
                            return;
                        case 2:
                            message = message.obj;
                            return;
                        case 3:
                            message = message.obj;
                            return;
                        case 4:
                            message = message.obj;
                            break;
                        case 5:
                            message = message.obj;
                            return;
                        case 6:
                            message = message.obj;
                            return;
                        case 7:
                            message = message.obj;
                            return;
                        case 9:
                            ((Integer) message.obj).intValue();
                            return;
                        case 11:
                            ((Boolean) message.obj).booleanValue();
                            return;
                        case 12:
                            ((Integer) message.obj).intValue();
                            return;
                        default:
                            break;
                    }
                }
            }
        }

        private static class StubApi21 implements android.support.v4.media.session.MediaControllerCompatApi21.Callback {
            private final WeakReference<Callback> f11433a;

            StubApi21(Callback callback) {
                this.f11433a = new WeakReference(callback);
            }

            public final void mo341a() {
                this.f11433a.get();
            }

            public final void mo345b() {
                Callback callback = (Callback) this.f11433a.get();
                if (callback != null && callback.f1280b) {
                    int i = VERSION.SDK_INT;
                }
            }

            public final void mo343a(Object obj) {
                Callback callback = (Callback) this.f11433a.get();
                if (callback != null && !callback.f1280b) {
                    PlaybackStateCompat.m955a(obj);
                }
            }

            public final void mo346b(Object obj) {
                if (((Callback) this.f11433a.get()) != null) {
                    MediaMetadataCompat.m874a(obj);
                }
            }

            public final void mo344a(List<?> list) {
                if (((Callback) this.f11433a.get()) != null) {
                    QueueItem.m951a(list);
                }
            }

            public final void mo347c() {
                this.f11433a.get();
            }

            public final void mo348d() {
                this.f11433a.get();
            }

            public final void mo342a(int i, int i2, int i3, int i4, int i5) {
                if (((Callback) this.f11433a.get()) != null) {
                    PlaybackInfo playbackInfo = new PlaybackInfo(i, i2, i3, i4, i5);
                }
            }
        }

        private static class StubCompat extends Stub {
            private final WeakReference<Callback> f16501a;

            public final void mo288a(boolean z) throws RemoteException {
            }

            StubCompat(Callback callback) {
                this.f16501a = new WeakReference(callback);
            }

            public final void mo286a(String str, Bundle bundle) throws RemoteException {
                Callback callback = (Callback) this.f16501a.get();
                if (callback != null) {
                    callback.m938a(1, str, bundle);
                }
            }

            public void mo279a() throws RemoteException {
                Callback callback = (Callback) this.f16501a.get();
                if (callback != null) {
                    callback.m938a(8, null, null);
                }
            }

            public final void mo284a(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Callback callback = (Callback) this.f16501a.get();
                if (callback != null) {
                    callback.m938a(2, playbackStateCompat, null);
                }
            }

            public void mo282a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Callback callback = (Callback) this.f16501a.get();
                if (callback != null) {
                    callback.m938a(3, mediaMetadataCompat, null);
                }
            }

            public void mo287a(List<QueueItem> list) throws RemoteException {
                Callback callback = (Callback) this.f16501a.get();
                if (callback != null) {
                    callback.m938a(5, list, null);
                }
            }

            public void mo285a(CharSequence charSequence) throws RemoteException {
                Callback callback = (Callback) this.f16501a.get();
                if (callback != null) {
                    callback.m938a(6, charSequence, null);
                }
            }

            public final void mo291b(boolean z) throws RemoteException {
                Callback callback = (Callback) this.f16501a.get();
                if (callback != null) {
                    callback.m938a(11, Boolean.valueOf(z), null);
                }
            }

            public final void mo280a(int i) throws RemoteException {
                Callback callback = (Callback) this.f16501a.get();
                if (callback != null) {
                    callback.m938a(9, Integer.valueOf(i), null);
                }
            }

            public final void mo290b(int i) throws RemoteException {
                Callback callback = (Callback) this.f16501a.get();
                if (callback != null) {
                    callback.m938a(12, Integer.valueOf(i), null);
                }
            }

            public void mo281a(Bundle bundle) throws RemoteException {
                Callback callback = (Callback) this.f16501a.get();
                if (callback != null) {
                    callback.m938a(7, bundle, null);
                }
            }

            public void mo283a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Callback callback = (Callback) this.f16501a.get();
                if (callback != null) {
                    Object obj;
                    if (parcelableVolumeInfo != null) {
                        PlaybackInfo playbackInfo = new PlaybackInfo(parcelableVolumeInfo.f1298a, parcelableVolumeInfo.f1299b, parcelableVolumeInfo.f1300c, parcelableVolumeInfo.f1301d, parcelableVolumeInfo.f1302e);
                    } else {
                        obj = null;
                    }
                    callback.m938a(4, obj, null);
                }
            }

            public final void mo289b() throws RemoteException {
                Callback callback = (Callback) this.f16501a.get();
                if (callback != null) {
                    callback.m938a(13, null, null);
                }
            }
        }

        public Callback() {
            if (VERSION.SDK_INT >= 21) {
                this.f1281c = MediaControllerCompatApi21.m950a(new StubApi21(this));
            } else {
                this.f1281c = new StubCompat(this);
            }
        }

        final void m938a(int i, Object obj, Bundle bundle) {
            if (this.f1279a != null) {
                i = this.f1279a.obtainMessage(i, obj);
                i.setData(bundle);
                i.sendToTarget();
            }
        }
    }

    @RequiresApi(21)
    static class MediaControllerImplApi21 {
        private final List<Callback> f1283a;
        private IMediaSession f1284b;
        private HashMap<Callback, ExtraCallback> f1285c;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> f1282a;

            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f1282a.get();
                if (mediaControllerImplApi21 != null) {
                    if (bundle != null) {
                        mediaControllerImplApi21.f1284b = IMediaSession.Stub.m10101a(BundleCompat.m526a(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                        MediaControllerImplApi21.m940a(mediaControllerImplApi21);
                    }
                }
            }
        }

        private static class ExtraCallback extends StubCompat {
            ExtraCallback(Callback callback) {
                super(callback);
            }

            public final void mo279a() throws RemoteException {
                throw new AssertionError();
            }

            public final void mo282a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            public final void mo287a(List<QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            public final void mo285a(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            public final void mo281a(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public final void mo283a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }

        static /* synthetic */ void m940a(MediaControllerImplApi21 mediaControllerImplApi21) {
            if (mediaControllerImplApi21.f1284b != null) {
                synchronized (mediaControllerImplApi21.f1283a) {
                    for (Callback callback : mediaControllerImplApi21.f1283a) {
                        IMediaControllerCallback extraCallback = new ExtraCallback(callback);
                        mediaControllerImplApi21.f1285c.put(callback, extraCallback);
                        callback.f1280b = true;
                        try {
                            mediaControllerImplApi21.f1284b.mo300a(extraCallback);
                        } catch (Throwable e) {
                            Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                        }
                    }
                    mediaControllerImplApi21.f1283a.clear();
                }
            }
        }
    }

    public static final class PlaybackInfo {
        private final int f1286a;
        private final int f1287b;
        private final int f1288c;
        private final int f1289d;
        private final int f1290e;

        PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
            this.f1286a = i;
            this.f1287b = i2;
            this.f1288c = i3;
            this.f1289d = i4;
            this.f1290e = i5;
        }
    }
}
