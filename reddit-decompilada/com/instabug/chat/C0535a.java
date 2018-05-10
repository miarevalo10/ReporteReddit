package com.instabug.chat;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.instabug.chat.cache.C0538a;
import com.instabug.chat.cache.ChatsCacheManager;
import com.instabug.chat.eventbus.ChatTimeUpdatedEventBus;
import com.instabug.chat.p007d.C0542c;
import com.instabug.chat.p007d.C0542c.C0541a;
import com.instabug.chat.settings.C0554a;
import com.instabug.library.C0593R;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugCustomTextPlaceHolder.Key;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.core.plugin.PluginPromptOption.OnInvocationListener;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.PlaceHolderUtils;
import java.util.ArrayList;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: ChatPluginWrapper */
class C0535a {

    /* compiled from: ChatPluginWrapper */
    static class C12921 implements OnInvocationListener {
        C12921() {
        }

        public final void onInvoke(Uri uri) {
            C0535a.m7885c();
        }
    }

    C0535a() {
    }

    static void m7880a(Context context) {
        C0554a.m7935a(context);
        C0538a.m7898a(context);
        C0538a.m7897a();
        C0542c a = C0542c.m7913a();
        a.f9252a = new Handler();
        a.f9253b = new C0541a(a, context);
        a.f9254c = ChatTimeUpdatedEventBus.getInstance().subscribe(a.f9255d);
    }

    static long m7882b() {
        return C0554a.m7946d();
    }

    static ArrayList<PluginPromptOption> m7883b(Context context) {
        ArrayList<PluginPromptOption> arrayList = new ArrayList();
        if ((InstabugCore.getFeatureState(Feature.IN_APP_MESSAGING) == State.ENABLED ? 1 : 0) != 0) {
            PluginPromptOption pluginPromptOption = new PluginPromptOption();
            pluginPromptOption.setOrder(1);
            pluginPromptOption.setInvocationMode(4);
            pluginPromptOption.setNotificationCount(ChatsCacheManager.getUnreadCount());
            pluginPromptOption.setIcon(C0520R.drawable.instabug_ic_talk_to_us);
            pluginPromptOption.setTitle(PlaceHolderUtils.getPlaceHolder(Key.START_CHATS, LocaleUtils.getLocaleStringResource(Instabug.getLocale(context), C0593R.string.instabug_str_talk_to_us, context)));
            pluginPromptOption.setOnInvocationListener(new C12921());
            arrayList.add(pluginPromptOption);
        }
        return arrayList;
    }

    static Subscription m7878a(Action1<SDKCoreEvent> action1) {
        return SDKCoreEventSubscriber.subscribe(action1);
    }

    static Action1<SDKCoreEvent> m7884c(final Context context) {
        return new Action1<SDKCoreEvent>() {
            public final /* synthetic */ void m15256a(Object obj) {
                C0537b.m7896a(context, (SDKCoreEvent) obj);
            }
        };
    }

    static void m7881a(Subscription subscription) {
        if (subscription != null && !subscription.d()) {
            subscription.c();
        }
    }

    static void m7879a() {
        C0542c a = C0542c.m7913a();
        a.m7925c();
        if (!(a.f9254c == null || a.f9254c.d())) {
            a.f9254c.c();
        }
        a.f9252a = null;
        a.f9253b = null;
        C0538a.m7899b();
    }

    static /* synthetic */ void m7885c() {
        ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
        if (chatPlugin != null) {
            chatPlugin.setState(1);
        }
        InstabugSDKLogger.m8356d(C0535a.class, "setPluginStateForeground->change plugin state to FOREGROUND");
        if (ChatsCacheManager.getValidChats().size() > 0) {
            InstabugChat.showChats();
        } else {
            InstabugChat.openNewChat();
        }
    }
}
