package com.instabug.chat;

import android.content.Context;
import android.content.Intent;
import com.instabug.chat.cache.C0538a;
import com.instabug.chat.network.InstabugMessageUploaderService;
import com.instabug.chat.p007d.C0542c;
import com.instabug.chat.settings.C0554a;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Invocation;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Network;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Session;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.User;

/* compiled from: CoreEventsHandler */
class C0537b {
    private static void m7895a(Context context) {
        context.startService(new Intent(context, InstabugMessageUploaderService.class));
    }

    static void m7896a(Context context, SDKCoreEvent sDKCoreEvent) {
        Object obj = null;
        if ((InstabugCore.getFeatureState(Feature.IN_APP_MESSAGING) == State.ENABLED ? 1 : null) != null) {
            String type = sDKCoreEvent.getType();
            int hashCode = type.hashCode();
            if (hashCode == 3599307) {
                if (type.equals("user")) {
                    obj = 2;
                    switch (obj) {
                        case null:
                            sDKCoreEvent.getValue().equals(Invocation.VALUE_INVOKED);
                            if (sDKCoreEvent.getValue().equals(Invocation.VALUE_DISMISSED) != null) {
                                return;
                            }
                        case 1:
                            if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED)) {
                                C0538a.m7898a(context);
                                C0537b.m7895a(context);
                                C0542c.m7913a().m7924b();
                            }
                            if (sDKCoreEvent.getValue().equals(Session.VALUE_FINISHED) != null) {
                                C0538a.m7899b();
                                C0537b.m7895a(context);
                                C0542c.m7913a().m7925c();
                                return;
                            }
                            break;
                        case 2:
                            if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_IN) != null) {
                                C0542c.m7913a().m7924b();
                            }
                            if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                                C0554a.m7934a((long) null);
                                return;
                            }
                            break;
                        case 3:
                            if (sDKCoreEvent.getValue().equals(Network.VALUE_ACTIVATED) != null) {
                                C0538a.m7899b();
                                C0537b.m7895a(context);
                                C0542c.m7913a().m7924b();
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
            } else if (hashCode == 1738700944) {
                if (type.equals(Invocation.TYPE_INVOCATION)) {
                    switch (obj) {
                        case null:
                            sDKCoreEvent.getValue().equals(Invocation.VALUE_INVOKED);
                            if (sDKCoreEvent.getValue().equals(Invocation.VALUE_DISMISSED) != null) {
                                return;
                            }
                            break;
                        case 1:
                            if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED)) {
                                C0538a.m7898a(context);
                                C0537b.m7895a(context);
                                C0542c.m7913a().m7924b();
                            }
                            if (sDKCoreEvent.getValue().equals(Session.VALUE_FINISHED) != null) {
                                C0538a.m7899b();
                                C0537b.m7895a(context);
                                C0542c.m7913a().m7925c();
                                return;
                            }
                            break;
                        case 2:
                            if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_IN) != null) {
                                C0542c.m7913a().m7924b();
                            }
                            if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                                C0554a.m7934a((long) null);
                                return;
                            }
                            break;
                        case 3:
                            if (sDKCoreEvent.getValue().equals(Network.VALUE_ACTIVATED) != null) {
                                C0538a.m7899b();
                                C0537b.m7895a(context);
                                C0542c.m7913a().m7924b();
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
            } else if (hashCode == 1843485230) {
                if (type.equals(Network.TYPE_NETWORK)) {
                    obj = 3;
                    switch (obj) {
                        case null:
                            sDKCoreEvent.getValue().equals(Invocation.VALUE_INVOKED);
                            if (sDKCoreEvent.getValue().equals(Invocation.VALUE_DISMISSED) != null) {
                                return;
                            }
                        case 1:
                            if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED)) {
                                C0538a.m7898a(context);
                                C0537b.m7895a(context);
                                C0542c.m7913a().m7924b();
                            }
                            if (sDKCoreEvent.getValue().equals(Session.VALUE_FINISHED) != null) {
                                C0538a.m7899b();
                                C0537b.m7895a(context);
                                C0542c.m7913a().m7925c();
                                return;
                            }
                            break;
                        case 2:
                            if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_IN) != null) {
                                C0542c.m7913a().m7924b();
                            }
                            if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                                C0554a.m7934a((long) null);
                                return;
                            }
                            break;
                        case 3:
                            if (sDKCoreEvent.getValue().equals(Network.VALUE_ACTIVATED) != null) {
                                C0538a.m7899b();
                                C0537b.m7895a(context);
                                C0542c.m7913a().m7924b();
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
            } else if (hashCode == 1984987798) {
                if (type.equals(Session.TYPE_SESSION)) {
                    obj = 1;
                    switch (obj) {
                        case null:
                            sDKCoreEvent.getValue().equals(Invocation.VALUE_INVOKED);
                            if (sDKCoreEvent.getValue().equals(Invocation.VALUE_DISMISSED) != null) {
                                return;
                            }
                            break;
                        case 1:
                            if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED)) {
                                C0538a.m7898a(context);
                                C0537b.m7895a(context);
                                C0542c.m7913a().m7924b();
                            }
                            if (sDKCoreEvent.getValue().equals(Session.VALUE_FINISHED) != null) {
                                C0538a.m7899b();
                                C0537b.m7895a(context);
                                C0542c.m7913a().m7925c();
                                return;
                            }
                            break;
                        case 2:
                            if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_IN) != null) {
                                C0542c.m7913a().m7924b();
                            }
                            if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                                C0554a.m7934a((long) null);
                                return;
                            }
                            break;
                        case 3:
                            if (sDKCoreEvent.getValue().equals(Network.VALUE_ACTIVATED) != null) {
                                C0538a.m7899b();
                                C0537b.m7895a(context);
                                C0542c.m7913a().m7924b();
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            obj = -1;
            switch (obj) {
                case null:
                    sDKCoreEvent.getValue().equals(Invocation.VALUE_INVOKED);
                    if (sDKCoreEvent.getValue().equals(Invocation.VALUE_DISMISSED) != null) {
                        return;
                    }
                    break;
                case 1:
                    if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED)) {
                        C0538a.m7898a(context);
                        C0537b.m7895a(context);
                        C0542c.m7913a().m7924b();
                    }
                    if (sDKCoreEvent.getValue().equals(Session.VALUE_FINISHED) != null) {
                        C0538a.m7899b();
                        C0537b.m7895a(context);
                        C0542c.m7913a().m7925c();
                        return;
                    }
                    break;
                case 2:
                    if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_IN) != null) {
                        C0542c.m7913a().m7924b();
                    }
                    if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                        C0554a.m7934a((long) null);
                        return;
                    }
                    break;
                case 3:
                    if (sDKCoreEvent.getValue().equals(Network.VALUE_ACTIVATED) != null) {
                        C0538a.m7899b();
                        C0537b.m7895a(context);
                        C0542c.m7913a().m7924b();
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
