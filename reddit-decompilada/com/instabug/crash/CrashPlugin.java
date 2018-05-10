package com.instabug.crash;

import android.content.Context;
import android.content.Intent;
import com.instabug.crash.cache.CrashesCacheManager;
import com.instabug.crash.models.Crash;
import com.instabug.crash.network.InstabugCrashesUploaderService;
import com.instabug.crash.p013b.C0582a;
import com.instabug.crash.p013b.C0584c;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Network;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Session;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.User;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;
import com.instabug.library.core.plugin.Plugin;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.OnDiskCache;
import com.instabug.library.util.InstabugSDKLogger;
import rx.Subscription;
import rx.functions.Action1;

public class CrashPlugin extends Plugin {
    private Subscription subscribe;

    class C13311 implements Action1<SDKCoreEvent> {
        final /* synthetic */ CrashPlugin f15418a;

        C13311(CrashPlugin crashPlugin) {
            this.f15418a = crashPlugin;
        }

        public final /* synthetic */ void m15326a(Object obj) {
            Object obj2;
            SDKCoreEvent sDKCoreEvent = (SDKCoreEvent) obj;
            String type = sDKCoreEvent.getType();
            int hashCode = type.hashCode();
            if (hashCode != 3599307) {
                if (hashCode != 1843485230) {
                    if (hashCode == 1984987798) {
                        if (type.equals(Session.TYPE_SESSION)) {
                            obj2 = 1;
                            switch (obj2) {
                                case null:
                                    if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                                        this.f15418a.clearUserActivities();
                                        return;
                                    }
                                    break;
                                case 1:
                                    if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED) != null) {
                                        this.f15418a.startCrashesUploaderService();
                                        return;
                                    }
                                    break;
                                case 2:
                                    if (sDKCoreEvent.getValue().equals(Network.VALUE_ACTIVATED) != null) {
                                        this.f15418a.startCrashesUploaderService();
                                        break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                } else if (type.equals(Network.TYPE_NETWORK)) {
                    obj2 = 2;
                    switch (obj2) {
                        case null:
                            if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                                this.f15418a.clearUserActivities();
                                return;
                            }
                            break;
                        case 1:
                            if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED) != null) {
                                this.f15418a.startCrashesUploaderService();
                                return;
                            }
                            break;
                        case 2:
                            if (sDKCoreEvent.getValue().equals(Network.VALUE_ACTIVATED) != null) {
                                this.f15418a.startCrashesUploaderService();
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
            } else if (type.equals("user")) {
                obj2 = null;
                switch (obj2) {
                    case null:
                        if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                            this.f15418a.clearUserActivities();
                            return;
                        }
                        break;
                    case 1:
                        if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED) != null) {
                            this.f15418a.startCrashesUploaderService();
                            return;
                        }
                        break;
                    case 2:
                        if (sDKCoreEvent.getValue().equals(Network.VALUE_ACTIVATED) != null) {
                            this.f15418a.startCrashesUploaderService();
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
            obj2 = -1;
            switch (obj2) {
                case null:
                    if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                        this.f15418a.clearUserActivities();
                        return;
                    }
                    break;
                case 1:
                    if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED) != null) {
                        this.f15418a.startCrashesUploaderService();
                        return;
                    }
                    break;
                case 2:
                    if (sDKCoreEvent.getValue().equals(Network.VALUE_ACTIVATED) != null) {
                        this.f15418a.startCrashesUploaderService();
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void init(Context context) {
        super.init(context);
        C0582a.m7997a(context);
        subscribeOnSDKEvents();
        prepareCrashesCache();
        setExceptionHandler();
    }

    public void release() {
        if (this.subscribe != null) {
            this.subscribe.c();
        }
    }

    public long getLastActivityTime() {
        C0582a.m7995a();
        return C0582a.m8000c();
    }

    private void subscribeOnSDKEvents() {
        this.subscribe = SDKCoreEventSubscriber.subscribe(new C13311(this));
    }

    private void startCrashesUploaderService() {
        if (this.contextWeakReference != null) {
            Context context = (Context) this.contextWeakReference.get();
            if (context != null) {
                context.startService(new Intent((Context) this.contextWeakReference.get(), InstabugCrashesUploaderService.class));
            }
        }
    }

    private void clearUserActivities() {
        C0584c.m8003a().m8005a(0);
    }

    private void prepareCrashesCache() {
        InstabugSDKLogger.m8360v(this, "Creating Crashes disk cache");
        if (this.contextWeakReference != null && this.contextWeakReference.get() != null) {
            CacheManager.getInstance().addCache(new OnDiskCache((Context) this.contextWeakReference.get(), CrashesCacheManager.CRASHES_DISK_CACHE_KEY, CrashesCacheManager.CRASHES_DISK_CACHE_FILE_NAME, Crash.class));
        }
    }

    private void setExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(new C0581a());
    }
}
