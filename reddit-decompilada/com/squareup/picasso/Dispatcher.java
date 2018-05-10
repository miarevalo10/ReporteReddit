package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

class Dispatcher {
    final DispatcherThread f23760a = new DispatcherThread();
    final Context f23761b;
    final ExecutorService f23762c;
    final Downloader f23763d;
    final Map<String, BitmapHunter> f23764e;
    final Map<Object, Action> f23765f;
    final Map<Object, Action> f23766g;
    final Set<Object> f23767h;
    final Handler f23768i;
    final Handler f23769j;
    final Cache f23770k;
    final Stats f23771l;
    final List<BitmapHunter> f23772m;
    final NetworkBroadcastReceiver f23773n;
    final boolean f23774o;
    boolean f23775p;

    private static class DispatcherHandler extends Handler {
        private final Dispatcher f23758a;

        public DispatcherHandler(Looper looper, Dispatcher dispatcher) {
            super(looper);
            this.f23758a = dispatcher;
        }

        public void handleMessage(final Message message) {
            boolean z = false;
            Dispatcher dispatcher;
            switch (message.what) {
                case 1:
                    this.f23758a.m25757a((Action) message.obj, true);
                    return;
                case 2:
                    Action action = (Action) message.obj;
                    dispatcher = this.f23758a;
                    String str = action.f23721i;
                    BitmapHunter bitmapHunter = (BitmapHunter) dispatcher.f23764e.get(str);
                    if (bitmapHunter != null) {
                        bitmapHunter.m25748a(action);
                        if (bitmapHunter.m25749a()) {
                            dispatcher.f23764e.remove(str);
                            if (action.f23713a.f23840n) {
                                Utils.m25825a("Dispatcher", "canceled", action.f23714b.logId());
                            }
                        }
                    }
                    if (dispatcher.f23767h.contains(action.f23722j)) {
                        dispatcher.f23766g.remove(action.m25743c());
                        if (action.f23713a.f23840n) {
                            Utils.m25826a("Dispatcher", "canceled", action.f23714b.logId(), "because paused request got canceled");
                        }
                    }
                    action = (Action) dispatcher.f23765f.remove(action.m25743c());
                    if (action != null && action.f23713a.f23840n) {
                        Utils.m25826a("Dispatcher", "canceled", action.f23714b.logId(), "from replaying");
                    }
                    return;
                case 4:
                    BitmapHunter bitmapHunter2 = (BitmapHunter) message.obj;
                    dispatcher = this.f23758a;
                    if (MemoryPolicy.m25769b(bitmapHunter2.f23741h)) {
                        dispatcher.f23770k.set(bitmapHunter2.f23739f, bitmapHunter2.f23746m);
                    }
                    dispatcher.f23764e.remove(bitmapHunter2.f23739f);
                    dispatcher.m25763d(bitmapHunter2);
                    if (bitmapHunter2.f23735b.f23840n) {
                        Utils.m25826a("Dispatcher", "batched", Utils.m25819a(bitmapHunter2), "for completion");
                    }
                    return;
                case 5:
                    this.f23758a.m25762c((BitmapHunter) message.obj);
                    return;
                case 6:
                    this.f23758a.m25759a((BitmapHunter) message.obj, false);
                    return;
                case 7:
                    message = this.f23758a;
                    List arrayList = new ArrayList(message.f23772m);
                    message.f23772m.clear();
                    message.f23769j.sendMessage(message.f23769j.obtainMessage(8, arrayList));
                    Dispatcher.m25754a(arrayList);
                    return;
                case 9:
                    this.f23758a.m25756a((NetworkInfo) message.obj);
                    return;
                case 10:
                    dispatcher = this.f23758a;
                    if (message.arg1 == 1) {
                        z = true;
                    }
                    dispatcher.f23775p = z;
                    return;
                case 11:
                    message = message.obj;
                    dispatcher = this.f23758a;
                    if (dispatcher.f23767h.add(message)) {
                        Iterator it = dispatcher.f23764e.values().iterator();
                        while (it.hasNext()) {
                            BitmapHunter bitmapHunter3 = (BitmapHunter) it.next();
                            boolean z2 = bitmapHunter3.f23735b.f23840n;
                            Action action2 = bitmapHunter3.f23744k;
                            List list = bitmapHunter3.f23745l;
                            boolean z3 = (list == null || list.isEmpty()) ? false : true;
                            if (action2 != null || z3) {
                                StringBuilder stringBuilder;
                                if (action2 != null && action2.f23722j.equals(message)) {
                                    bitmapHunter3.m25748a(action2);
                                    dispatcher.f23766g.put(action2.m25743c(), action2);
                                    if (z2) {
                                        String logId = action2.f23714b.logId();
                                        stringBuilder = new StringBuilder("because tag '");
                                        stringBuilder.append(message);
                                        stringBuilder.append("' was paused");
                                        Utils.m25826a("Dispatcher", "paused", logId, stringBuilder.toString());
                                    }
                                }
                                if (z3) {
                                    for (int size = list.size() - 1; size >= 0; size--) {
                                        Action action3 = (Action) list.get(size);
                                        if (action3.f23722j.equals(message)) {
                                            bitmapHunter3.m25748a(action3);
                                            dispatcher.f23766g.put(action3.m25743c(), action3);
                                            if (z2) {
                                                String logId2 = action3.f23714b.logId();
                                                stringBuilder = new StringBuilder("because tag '");
                                                stringBuilder.append(message);
                                                stringBuilder.append("' was paused");
                                                Utils.m25826a("Dispatcher", "paused", logId2, stringBuilder.toString());
                                            }
                                        }
                                    }
                                }
                                if (bitmapHunter3.m25749a()) {
                                    it.remove();
                                    if (z2) {
                                        Utils.m25826a("Dispatcher", "canceled", Utils.m25819a(bitmapHunter3), "all actions paused");
                                    }
                                }
                            }
                        }
                    }
                    return;
                case 12:
                    this.f23758a.m25760a(message.obj);
                    return;
                default:
                    Picasso.f23827a.post(new Runnable(this) {
                        final /* synthetic */ DispatcherHandler f23757b;

                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder("Unknown handler message received: ");
                            stringBuilder.append(message.what);
                            throw new AssertionError(stringBuilder.toString());
                        }
                    });
                    return;
            }
        }
    }

    static class DispatcherThread extends HandlerThread {
        DispatcherThread() {
            super("Picasso-Dispatcher", 10);
        }
    }

    static class NetworkBroadcastReceiver extends BroadcastReceiver {
        final Dispatcher f23759a;

        NetworkBroadcastReceiver(Dispatcher dispatcher) {
            this.f23759a = dispatcher;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if (!"android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) != null) {
                        ConnectivityManager connectivityManager = (ConnectivityManager) Utils.m25817a(context, "connectivity");
                        intent = this.f23759a;
                        intent.f23768i.sendMessage(intent.f23768i.obtainMessage(9, connectivityManager.getActiveNetworkInfo()));
                    }
                } else if (intent.hasExtra("state") != null) {
                    context = this.f23759a;
                    context.f23768i.sendMessage(context.f23768i.obtainMessage(10, intent.getBooleanExtra("state", false), 0));
                }
            }
        }
    }

    Dispatcher(Context context, ExecutorService executorService, Handler handler, Downloader downloader, Cache cache, Stats stats) {
        this.f23760a.start();
        Utils.m25823a(this.f23760a.getLooper());
        this.f23761b = context;
        this.f23762c = executorService;
        this.f23764e = new LinkedHashMap();
        this.f23765f = new WeakHashMap();
        this.f23766g = new WeakHashMap();
        this.f23767h = new HashSet();
        this.f23768i = new DispatcherHandler(this.f23760a.getLooper(), this);
        this.f23763d = downloader;
        this.f23769j = handler;
        this.f23770k = cache;
        this.f23771l = stats;
        this.f23772m = new ArrayList(4);
        this.f23775p = Utils.m25833d(this.f23761b);
        this.f23774o = Utils.m25829b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.f23773n = new NetworkBroadcastReceiver(this);
        context = this.f23773n;
        executorService = new IntentFilter();
        executorService.addAction("android.intent.action.AIRPLANE_MODE");
        if (context.f23759a.f23774o != null) {
            executorService.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        context.f23759a.f23761b.registerReceiver(context, executorService);
    }

    final void m25758a(BitmapHunter bitmapHunter) {
        this.f23768i.sendMessageDelayed(this.f23768i.obtainMessage(5, bitmapHunter), 500);
    }

    final void m25761b(BitmapHunter bitmapHunter) {
        this.f23768i.sendMessage(this.f23768i.obtainMessage(6, bitmapHunter));
    }

    final void m25757a(Action action, boolean z) {
        if (this.f23767h.contains(action.f23722j)) {
            this.f23766g.put(action.m25743c(), action);
            if (action.f23713a.f23840n) {
                String logId = action.f23714b.logId();
                StringBuilder stringBuilder = new StringBuilder("because tag '");
                stringBuilder.append(action.f23722j);
                stringBuilder.append("' is paused");
                Utils.m25826a("Dispatcher", "paused", logId, stringBuilder.toString());
            }
            return;
        }
        BitmapHunter bitmapHunter = (BitmapHunter) this.f23764e.get(action.f23721i);
        if (bitmapHunter != null) {
            z = bitmapHunter.f23735b.f23840n;
            Request request = action.f23714b;
            if (bitmapHunter.f23744k == null) {
                bitmapHunter.f23744k = action;
                if (z) {
                    if (bitmapHunter.f23745l != null) {
                        if (bitmapHunter.f23745l.isEmpty() == null) {
                            Utils.m25826a("Hunter", "joined", request.logId(), Utils.m25820a(bitmapHunter, "to "));
                        }
                    }
                    Utils.m25826a("Hunter", "joined", request.logId(), "to empty hunter");
                    return;
                }
                return;
            }
            if (bitmapHunter.f23745l == null) {
                bitmapHunter.f23745l = new ArrayList(3);
            }
            bitmapHunter.f23745l.add(action);
            if (z) {
                Utils.m25826a("Hunter", "joined", request.logId(), Utils.m25820a(bitmapHunter, "to "));
            }
            action = action.f23714b.priority;
            if (action.ordinal() > bitmapHunter.f23752s.ordinal()) {
                bitmapHunter.f23752s = action;
            }
        } else if (this.f23762c.isShutdown()) {
            if (action.f23713a.f23840n) {
                Utils.m25826a("Dispatcher", "ignored", action.f23714b.logId(), "because shut down");
            }
        } else {
            Object a = BitmapHunter.m25745a(action.f23713a, this, this.f23770k, this.f23771l, action);
            a.f23747n = this.f23762c.submit(a);
            this.f23764e.put(action.f23721i, a);
            if (z) {
                this.f23765f.remove(action.m25743c());
            }
            if (action.f23713a.f23840n) {
                Utils.m25825a("Dispatcher", "enqueued", action.f23714b.logId());
            }
        }
    }

    final void m25760a(Object obj) {
        if (this.f23767h.remove(obj)) {
            Object obj2 = null;
            Iterator it = this.f23766g.values().iterator();
            while (it.hasNext()) {
                Action action = (Action) it.next();
                if (action.f23722j.equals(obj)) {
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                    }
                    obj2.add(action);
                    it.remove();
                }
            }
            if (obj2 != null) {
                this.f23769j.sendMessage(this.f23769j.obtainMessage(13, obj2));
            }
        }
    }

    final void m25762c(BitmapHunter bitmapHunter) {
        if (!bitmapHunter.m25750b()) {
            boolean z = false;
            if (this.f23762c.isShutdown()) {
                m25759a(bitmapHunter, false);
                return;
            }
            boolean z2;
            NetworkInfo networkInfo = null;
            if (this.f23774o) {
                networkInfo = ((ConnectivityManager) Utils.m25817a(this.f23761b, "connectivity")).getActiveNetworkInfo();
            }
            int i = (networkInfo == null || !networkInfo.isConnected()) ? false : 1;
            if ((bitmapHunter.f23751r > 0 ? 1 : false) == 0) {
                z2 = false;
            } else {
                bitmapHunter.f23751r--;
                z2 = bitmapHunter.f23743j.mo5457a(networkInfo);
            }
            boolean b = bitmapHunter.f23743j.mo5458b();
            if (z2) {
                if (this.f23774o) {
                    if (i == 0) {
                        m25759a(bitmapHunter, b);
                        if (b) {
                            m25755e(bitmapHunter);
                        }
                        return;
                    }
                }
                if (bitmapHunter.f23735b.f23840n) {
                    Utils.m25825a("Dispatcher", "retrying", Utils.m25819a(bitmapHunter));
                }
                if (bitmapHunter.f23749p instanceof ContentLengthException) {
                    bitmapHunter.f23742i |= NetworkPolicy.NO_CACHE.f23802d;
                }
                bitmapHunter.f23747n = this.f23762c.submit(bitmapHunter);
                return;
            }
            if (this.f23774o && b) {
                z = true;
            }
            m25759a(bitmapHunter, z);
            if (z) {
                m25755e(bitmapHunter);
            }
        }
    }

    final void m25756a(NetworkInfo networkInfo) {
        if (this.f23762c instanceof PicassoExecutorService) {
            PicassoExecutorService picassoExecutorService = (PicassoExecutorService) this.f23762c;
            if (networkInfo != null) {
                if (networkInfo.isConnectedOrConnecting()) {
                    int type = networkInfo.getType();
                    if (!(type == 6 || type == 9)) {
                        switch (type) {
                            case 0:
                                type = networkInfo.getSubtype();
                                switch (type) {
                                    case 1:
                                    case 2:
                                        picassoExecutorService.m25784a(1);
                                        break;
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                        picassoExecutorService.m25784a(2);
                                        break;
                                    default:
                                        switch (type) {
                                            case 12:
                                                break;
                                            case 13:
                                            case 14:
                                            case 15:
                                                picassoExecutorService.m25784a(3);
                                                break;
                                            default:
                                                picassoExecutorService.m25784a(3);
                                                break;
                                        }
                                        picassoExecutorService.m25784a(2);
                                        break;
                                }
                            case 1:
                                break;
                            default:
                                picassoExecutorService.m25784a(3);
                                break;
                        }
                    }
                    picassoExecutorService.m25784a(4);
                }
            }
            picassoExecutorService.m25784a(3);
        }
        if (networkInfo != null && networkInfo.isConnected() != null && this.f23765f.isEmpty() == null) {
            networkInfo = this.f23765f.values().iterator();
            while (networkInfo.hasNext()) {
                Action action = (Action) networkInfo.next();
                networkInfo.remove();
                if (action.f23713a.f23840n) {
                    Utils.m25825a("Dispatcher", "replaying", action.f23714b.logId());
                }
                m25757a(action, false);
            }
        }
    }

    private void m25753a(Action action) {
        Object c = action.m25743c();
        if (c != null) {
            action.f23723k = true;
            this.f23765f.put(c, action);
        }
    }

    final void m25763d(BitmapHunter bitmapHunter) {
        if (!bitmapHunter.m25750b()) {
            this.f23772m.add(bitmapHunter);
            if (this.f23768i.hasMessages(7) == null) {
                this.f23768i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    static void m25754a(List<BitmapHunter> list) {
        if (!list.isEmpty() && ((BitmapHunter) list.get(0)).f23735b.f23840n) {
            StringBuilder stringBuilder = new StringBuilder();
            for (BitmapHunter bitmapHunter : list) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(Utils.m25819a(bitmapHunter));
            }
            Utils.m25825a("Dispatcher", "delivered", stringBuilder.toString());
        }
    }

    final void m25759a(BitmapHunter bitmapHunter, boolean z) {
        if (bitmapHunter.f23735b.f23840n) {
            String str = "Dispatcher";
            String str2 = "batched";
            String a = Utils.m25819a(bitmapHunter);
            StringBuilder stringBuilder = new StringBuilder("for error");
            stringBuilder.append(z ? " (will replay)" : "");
            Utils.m25826a(str, str2, a, stringBuilder.toString());
        }
        this.f23764e.remove(bitmapHunter.f23739f);
        m25763d(bitmapHunter);
    }

    private void m25755e(BitmapHunter bitmapHunter) {
        Action action = bitmapHunter.f23744k;
        if (action != null) {
            m25753a(action);
        }
        bitmapHunter = bitmapHunter.f23745l;
        if (bitmapHunter != null) {
            int size = bitmapHunter.size();
            for (int i = 0; i < size; i++) {
                m25753a((Action) bitmapHunter.get(i));
            }
        }
    }
}
