package com.danikula.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.danikula.videocache.file.FileCache;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;

final class HttpProxyCacheServerClients {
    final AtomicInteger f3745a = new AtomicInteger(0);
    volatile HttpProxyCache f3746b;
    private final String f3747c;
    private final List<CacheListener> f3748d = new CopyOnWriteArrayList();
    private final CacheListener f3749e;
    private final Config f3750f;

    private static final class UiListenerHandler extends Handler implements CacheListener {
        private final String f12682a;
        private final List<CacheListener> f12683b;

        public UiListenerHandler(String str, List<CacheListener> list) {
            super(Looper.getMainLooper());
            this.f12682a = str;
            this.f12683b = list;
        }

        public final void mo1098a(File file, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        public final void handleMessage(Message message) {
            for (CacheListener a : this.f12683b) {
                a.mo1098a((File) message.obj, message.arg1);
            }
        }
    }

    public HttpProxyCacheServerClients(String str, Config config) {
        this.f3747c = (String) Preconditions.m3330a((Object) str);
        this.f3750f = (Config) Preconditions.m3330a((Object) config);
        this.f3749e = new UiListenerHandler(str, this.f3748d);
    }

    final synchronized void m3320a() throws ProxyCacheException {
        HttpProxyCache httpProxyCache;
        if (this.f3746b == null) {
            HttpUrlSource httpUrlSource = new HttpUrlSource(this.f3747c, this.f3750f.f3722d);
            Config config = this.f3750f;
            httpProxyCache = new HttpProxyCache(httpUrlSource, new FileCache(new File(config.f3719a, config.f3720b.mo1104a(this.f3747c)), this.f3750f.f3721c));
            httpProxyCache.f12681c = this.f3749e;
        } else {
            httpProxyCache = this.f3746b;
        }
        this.f3746b = httpProxyCache;
    }

    final synchronized void m3321b() {
        if (this.f3745a.decrementAndGet() <= 0) {
            ProxyCache proxyCache = this.f3746b;
            synchronized (proxyCache.f3767g) {
                Logger logger = ProxyCache.f3761d;
                StringBuilder stringBuilder = new StringBuilder("Shutdown proxy for ");
                stringBuilder.append(proxyCache.f3765e);
                logger.a(stringBuilder.toString());
                try {
                    proxyCache.f3769i = true;
                    if (proxyCache.f3768h != null) {
                        proxyCache.f3768h.interrupt();
                    }
                    proxyCache.f3766f.close();
                } catch (Throwable e) {
                    ProxyCache.m3338a(e);
                }
            }
            this.f3746b = null;
        }
    }
}
