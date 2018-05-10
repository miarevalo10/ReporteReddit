package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class Picasso {
    static final Handler f23827a = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 3) {
                int i2 = 0;
                List list;
                if (i == 8) {
                    list = (List) message.obj;
                    i = list.size();
                    for (int i3 = 0; i3 < i; i3++) {
                        BitmapHunter bitmapHunter = (BitmapHunter) list.get(i3);
                        Picasso picasso = bitmapHunter.f23735b;
                        Action action = bitmapHunter.f23744k;
                        List list2 = bitmapHunter.f23745l;
                        int i4 = 1;
                        int i5 = (list2 == null || list2.isEmpty()) ? 0 : 1;
                        if (action == null) {
                            if (i5 == 0) {
                                i4 = 0;
                            }
                        }
                        if (i4 != 0) {
                            Uri uri = bitmapHunter.f23740g.uri;
                            Exception exception = bitmapHunter.f23749p;
                            Bitmap bitmap = bitmapHunter.f23746m;
                            LoadedFrom loadedFrom = bitmapHunter.f23748o;
                            if (action != null) {
                                picasso.m25777a(bitmap, loadedFrom, action);
                            }
                            if (i5 != 0) {
                                int size = list2.size();
                                for (i5 = 0; i5 < size; i5++) {
                                    picasso.m25777a(bitmap, loadedFrom, (Action) list2.get(i5));
                                }
                            }
                        }
                    }
                    return;
                } else if (i != 13) {
                    StringBuilder stringBuilder = new StringBuilder("Unknown handler message received: ");
                    stringBuilder.append(message.what);
                    throw new AssertionError(stringBuilder.toString());
                } else {
                    list = (List) message.obj;
                    i = list.size();
                    while (i2 < i) {
                        Action action2 = (Action) list.get(i2);
                        Picasso picasso2 = action2.f23713a;
                        Bitmap bitmap2 = null;
                        if (MemoryPolicy.m25768a(action2.f23717e)) {
                            bitmap2 = picasso2.m25780b(action2.f23721i);
                        }
                        if (bitmap2 != null) {
                            picasso2.m25777a(bitmap2, LoadedFrom.MEMORY, action2);
                            if (picasso2.f23840n) {
                                String logId = action2.f23714b.logId();
                                StringBuilder stringBuilder2 = new StringBuilder("from ");
                                stringBuilder2.append(LoadedFrom.MEMORY);
                                Utils.m25826a("Main", "completed", logId, stringBuilder2.toString());
                            }
                        } else {
                            picasso2.m25778a(action2);
                            if (picasso2.f23840n) {
                                Utils.m25825a("Main", "resumed", action2.f23714b.logId());
                            }
                        }
                        i2++;
                    }
                    return;
                }
            }
            Action action3 = (Action) message.obj;
            if (action3.f23713a.f23840n) {
                Utils.m25826a("Main", "canceled", action3.f23714b.logId(), "target got garbage collected");
            }
            action3.f23713a.m25779a((Object) action3.m25743c());
        }
    };
    static volatile Picasso f23828b;
    final RequestTransformer f23829c;
    final List<RequestHandler> f23830d;
    final Context f23831e;
    final Dispatcher f23832f;
    final Cache f23833g;
    final Stats f23834h;
    final Map<Object, Action> f23835i;
    final Map<ImageView, DeferredRequestCreator> f23836j;
    final ReferenceQueue<Object> f23837k;
    final Config f23838l;
    boolean f23839m;
    volatile boolean f23840n;
    boolean f23841o;
    private final Listener f23842p;
    private final CleanupThread f23843q;

    public static class Builder {
        final Context f23803a;
        Downloader f23804b;
        ExecutorService f23805c;
        Cache f23806d;
        Listener f23807e;
        RequestTransformer f23808f;
        List<RequestHandler> f23809g;
        Config f23810h;
        boolean f23811i;
        boolean f23812j;

        public Builder(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f23803a = context.getApplicationContext();
        }
    }

    private static class CleanupThread extends Thread {
        private final ReferenceQueue<Object> f23815a;
        private final Handler f23816b;

        CleanupThread(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f23815a = referenceQueue;
            this.f23816b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = 10;
            android.os.Process.setThreadPriority(r0);
        L_0x0005:
            r0 = r3.f23815a;	 Catch:{ InterruptedException -> 0x0034, Exception -> 0x0028 }
            r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ InterruptedException -> 0x0034, Exception -> 0x0028 }
            r0 = r0.remove(r1);	 Catch:{ InterruptedException -> 0x0034, Exception -> 0x0028 }
            r0 = (com.squareup.picasso.Action.RequestWeakReference) r0;	 Catch:{ InterruptedException -> 0x0034, Exception -> 0x0028 }
            r1 = r3.f23816b;	 Catch:{ InterruptedException -> 0x0034, Exception -> 0x0028 }
            r1 = r1.obtainMessage();	 Catch:{ InterruptedException -> 0x0034, Exception -> 0x0028 }
            if (r0 == 0) goto L_0x0024;	 Catch:{ InterruptedException -> 0x0034, Exception -> 0x0028 }
        L_0x0017:
            r2 = 3;	 Catch:{ InterruptedException -> 0x0034, Exception -> 0x0028 }
            r1.what = r2;	 Catch:{ InterruptedException -> 0x0034, Exception -> 0x0028 }
            r0 = r0.f23712a;	 Catch:{ InterruptedException -> 0x0034, Exception -> 0x0028 }
            r1.obj = r0;	 Catch:{ InterruptedException -> 0x0034, Exception -> 0x0028 }
            r0 = r3.f23816b;	 Catch:{ InterruptedException -> 0x0034, Exception -> 0x0028 }
            r0.sendMessage(r1);	 Catch:{ InterruptedException -> 0x0034, Exception -> 0x0028 }
            goto L_0x0005;	 Catch:{ InterruptedException -> 0x0034, Exception -> 0x0028 }
        L_0x0024:
            r1.recycle();	 Catch:{ InterruptedException -> 0x0034, Exception -> 0x0028 }
            goto L_0x0005;
        L_0x0028:
            r0 = move-exception;
            r1 = r3.f23816b;
            r2 = new com.squareup.picasso.Picasso$CleanupThread$1;
            r2.<init>(r3, r0);
            r1.post(r2);
            return;
        L_0x0034:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.Picasso.CleanupThread.run():void");
        }
    }

    public interface Listener {
    }

    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        
        final int f23821d;

        private LoadedFrom(int i) {
            this.f23821d = i;
        }
    }

    public enum Priority {
        LOW,
        NORMAL,
        HIGH
    }

    public interface RequestTransformer {
        public static final RequestTransformer f23826a = new C25241();

        static class C25241 implements RequestTransformer {
            public final Request mo5460a(Request request) {
                return request;
            }

            C25241() {
            }
        }

        Request mo5460a(Request request);
    }

    private Picasso(Context context, Dispatcher dispatcher, Cache cache, Listener listener, RequestTransformer requestTransformer, List<RequestHandler> list, Stats stats, Config config, boolean z, boolean z2) {
        this.f23831e = context;
        this.f23832f = dispatcher;
        this.f23833g = cache;
        this.f23842p = listener;
        this.f23829c = requestTransformer;
        this.f23838l = config;
        listener = new ArrayList(7 + (list != null ? list.size() : null));
        listener.add(new ResourceRequestHandler(context));
        if (list != null) {
            listener.addAll(list);
        }
        listener.add(new ContactsPhotoRequestHandler(context));
        listener.add(new MediaStoreRequestHandler(context));
        listener.add(new ContentStreamRequestHandler(context));
        listener.add(new AssetRequestHandler(context));
        listener.add(new FileRequestHandler(context));
        listener.add(new NetworkRequestHandler(dispatcher.f23763d, stats));
        this.f23830d = Collections.unmodifiableList(listener);
        this.f23834h = stats;
        this.f23835i = new WeakHashMap();
        this.f23836j = new WeakHashMap();
        this.f23839m = z;
        this.f23840n = z2;
        this.f23837k = new ReferenceQueue();
        this.f23843q = new CleanupThread(this.f23837k, f23827a);
        this.f23843q.start();
    }

    public final RequestCreator m25776a(String str) {
        if (str == null) {
            return new RequestCreator(this, null);
        }
        if (str.trim().length() != 0) {
            return new RequestCreator(this, Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public final void m25778a(Action action) {
        Object c = action.m25743c();
        if (!(c == null || this.f23835i.get(c) == action)) {
            m25779a(c);
            this.f23835i.put(c, action);
        }
        Dispatcher dispatcher = this.f23832f;
        dispatcher.f23768i.sendMessage(dispatcher.f23768i.obtainMessage(1, action));
    }

    public final Bitmap m25780b(String str) {
        str = this.f23833g.get(str);
        if (str != null) {
            this.f23834h.m25802a();
        } else {
            this.f23834h.f23890c.sendEmptyMessage(1);
        }
        return str;
    }

    public final void m25779a(Object obj) {
        Utils.m25822a();
        Action action = (Action) this.f23835i.remove(obj);
        if (action != null) {
            action.mo5455b();
            Dispatcher dispatcher = this.f23832f;
            dispatcher.f23768i.sendMessage(dispatcher.f23768i.obtainMessage(2, action));
        }
        if (obj instanceof ImageView) {
            DeferredRequestCreator deferredRequestCreator = (DeferredRequestCreator) this.f23836j.remove((ImageView) obj);
            if (deferredRequestCreator != null) {
                deferredRequestCreator.f23755c = null;
                ImageView imageView = (ImageView) deferredRequestCreator.f23754b.get();
                if (imageView != null) {
                    ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnPreDrawListener(deferredRequestCreator);
                    }
                }
            }
        }
    }

    public static Picasso m25774a(Context context) {
        if (f23828b == null) {
            synchronized (Picasso.class) {
                if (f23828b == null) {
                    Builder builder = new Builder(context);
                    context = builder.f23803a;
                    if (builder.f23804b == null) {
                        builder.f23804b = Utils.m25816a(context);
                    }
                    if (builder.f23806d == null) {
                        builder.f23806d = new LruCache(context);
                    }
                    if (builder.f23805c == null) {
                        builder.f23805c = new PicassoExecutorService();
                    }
                    if (builder.f23808f == null) {
                        builder.f23808f = RequestTransformer.f23826a;
                    }
                    Stats stats = new Stats(builder.f23806d);
                    f23828b = new Picasso(context, new Dispatcher(context, builder.f23805c, f23827a, builder.f23804b, builder.f23806d, stats), builder.f23806d, builder.f23807e, builder.f23808f, builder.f23809g, stats, builder.f23810h, builder.f23811i, builder.f23812j);
                }
            }
        }
        return f23828b;
    }

    final void m25777a(Bitmap bitmap, LoadedFrom loadedFrom, Action action) {
        if (!action.f23724l) {
            if (!action.f23723k) {
                this.f23835i.remove(action.m25743c());
            }
            if (bitmap == null) {
                action.mo5453a();
                if (this.f23840n != null) {
                    Utils.m25825a("Main", "errored", action.f23714b.logId());
                }
            } else if (loadedFrom == null) {
                throw new AssertionError("LoadedFrom cannot be null.");
            } else {
                action.mo5454a(bitmap, loadedFrom);
                if (this.f23840n != null) {
                    action = action.f23714b.logId();
                    StringBuilder stringBuilder = new StringBuilder("from ");
                    stringBuilder.append(loadedFrom);
                    Utils.m25826a("Main", "completed", action, stringBuilder.toString());
                }
            }
        }
    }
}
