package com.instabug.bug;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.instabug.bug.cache.C0471a;
import com.instabug.bug.network.InstabugBugsUploaderService;
import com.instabug.bug.settings.C0485a;
import com.instabug.bug.view.actionList.service.ReportCategoriesService;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Invocation;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Network;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Session;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.User;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.model.Attachment;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.Iterator;

/* compiled from: CoreEventsHandler */
public class C0470c {
    static void m7759a(Context context, SDKCoreEvent sDKCoreEvent) {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("receive new core event: ");
        stringBuilder.append(sDKCoreEvent.toString());
        InstabugSDKLogger.m8360v(C0470c.class, stringBuilder.toString());
        String type = sDKCoreEvent.getType();
        int hashCode = type.hashCode();
        if (hashCode != 3599307) {
            if (hashCode != 1738700944) {
                if (hashCode != 1843485230) {
                    if (hashCode == 1984987798) {
                        if (type.equals(Session.TYPE_SESSION)) {
                            obj = 1;
                            switch (obj) {
                                case null:
                                    sDKCoreEvent.getValue().equals(Invocation.VALUE_INVOKED);
                                    if (sDKCoreEvent.getValue().equals(Invocation.VALUE_DISMISSED) != null) {
                                        C0470c.m7757a();
                                        return;
                                    }
                                    break;
                                case 1:
                                    if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED)) {
                                        C0470c.m7758a(context);
                                        ReportCategoriesService.m19375a(context);
                                        return;
                                    } else if (sDKCoreEvent.getValue().equals(Session.VALUE_FINISHED) != null) {
                                        C0471a.m7760a();
                                        return;
                                    }
                                    break;
                                case 2:
                                    if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                                        C0485a.m7793a();
                                        C0485a.m7794a((long) null);
                                        return;
                                    }
                                    break;
                                case 3:
                                    if (sDKCoreEvent.getValue().equals(Network.VALUE_ACTIVATED) != null) {
                                        C0470c.m7758a(context);
                                        break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                } else if (type.equals(Network.TYPE_NETWORK)) {
                    obj = 3;
                    switch (obj) {
                        case null:
                            sDKCoreEvent.getValue().equals(Invocation.VALUE_INVOKED);
                            if (sDKCoreEvent.getValue().equals(Invocation.VALUE_DISMISSED) != null) {
                                C0470c.m7757a();
                                return;
                            }
                            break;
                        case 1:
                            if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED)) {
                                C0470c.m7758a(context);
                                ReportCategoriesService.m19375a(context);
                                return;
                            } else if (sDKCoreEvent.getValue().equals(Session.VALUE_FINISHED) != null) {
                                C0471a.m7760a();
                                return;
                            }
                            break;
                        case 2:
                            if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                                C0485a.m7793a();
                                C0485a.m7794a((long) null);
                                return;
                            }
                            break;
                        case 3:
                            if (sDKCoreEvent.getValue().equals(Network.VALUE_ACTIVATED) != null) {
                                C0470c.m7758a(context);
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
            } else if (type.equals(Invocation.TYPE_INVOCATION)) {
                obj = null;
                switch (obj) {
                    case null:
                        sDKCoreEvent.getValue().equals(Invocation.VALUE_INVOKED);
                        if (sDKCoreEvent.getValue().equals(Invocation.VALUE_DISMISSED) != null) {
                            C0470c.m7757a();
                            return;
                        }
                        break;
                    case 1:
                        if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED)) {
                            C0470c.m7758a(context);
                            ReportCategoriesService.m19375a(context);
                            return;
                        } else if (sDKCoreEvent.getValue().equals(Session.VALUE_FINISHED) != null) {
                            C0471a.m7760a();
                            return;
                        }
                        break;
                    case 2:
                        if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                            C0485a.m7793a();
                            C0485a.m7794a((long) null);
                            return;
                        }
                        break;
                    case 3:
                        if (sDKCoreEvent.getValue().equals(Network.VALUE_ACTIVATED) != null) {
                            C0470c.m7758a(context);
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
        } else if (type.equals("user")) {
            obj = 2;
            switch (obj) {
                case null:
                    sDKCoreEvent.getValue().equals(Invocation.VALUE_INVOKED);
                    if (sDKCoreEvent.getValue().equals(Invocation.VALUE_DISMISSED) != null) {
                        C0470c.m7757a();
                        return;
                    }
                    break;
                case 1:
                    if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED)) {
                        C0470c.m7758a(context);
                        ReportCategoriesService.m19375a(context);
                        return;
                    } else if (sDKCoreEvent.getValue().equals(Session.VALUE_FINISHED) != null) {
                        C0471a.m7760a();
                        return;
                    }
                    break;
                case 2:
                    if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                        C0485a.m7793a();
                        C0485a.m7794a((long) null);
                        return;
                    }
                    break;
                case 3:
                    if (sDKCoreEvent.getValue().equals(Network.VALUE_ACTIVATED) != null) {
                        C0470c.m7758a(context);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        obj = -1;
        switch (obj) {
            case null:
                sDKCoreEvent.getValue().equals(Invocation.VALUE_INVOKED);
                if (sDKCoreEvent.getValue().equals(Invocation.VALUE_DISMISSED) != null) {
                    C0470c.m7757a();
                    return;
                }
                break;
            case 1:
                if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED)) {
                    C0470c.m7758a(context);
                    ReportCategoriesService.m19375a(context);
                    return;
                } else if (sDKCoreEvent.getValue().equals(Session.VALUE_FINISHED) != null) {
                    C0471a.m7760a();
                    return;
                }
                break;
            case 2:
                if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                    C0485a.m7793a();
                    C0485a.m7794a((long) null);
                    return;
                }
                break;
            case 3:
                if (sDKCoreEvent.getValue().equals(Network.VALUE_ACTIVATED) != null) {
                    C0470c.m7758a(context);
                    break;
                }
                break;
            default:
                break;
        }
    }

    private static void m7758a(Context context) {
        if (context != null) {
            context.startService(new Intent(context, InstabugBugsUploaderService.class));
        }
    }

    public static void m7757a() {
        InstabugSDKLogger.m8356d(C0470c.class, "SDK dismissed Handle sdk dismissing");
        C0485a.m7793a();
        if (C0485a.m7817h() != null) {
            C0485a.m7793a();
            C0485a.m7817h().onSdkDismissed(C0474d.m7762a().f9102c, C0474d.m7762a().f9100a.f15312c);
        }
        C0474d a = C0474d.m7762a();
        if (!(a.f9100a == null || a.f9100a.f15314e == null)) {
            Iterator it = a.f9100a.f15314e.iterator();
            while (it.hasNext()) {
                DiskUtils.deleteFile(((Attachment) it.next()).getLocalPath());
            }
        }
        a.f9100a = null;
        Activity targetActivity = InstabugInternalTrackingDelegate.getInstance().getTargetActivity();
        if (targetActivity != null) {
            targetActivity.startActivity(C0469b.m7756d(InstabugInternalTrackingDelegate.getInstance().getCurrentActivity()));
        }
    }
}
