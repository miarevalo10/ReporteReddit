package com.instabug.chat;

import android.content.Context;
import android.content.Intent;
import com.instabug.chat.model.Message;
import com.instabug.chat.network.InstabugPushNotificationTokenService;
import com.instabug.chat.p005a.C0534b;
import com.instabug.chat.p007d.C0539a;
import com.instabug.chat.p007d.C0540b;
import com.instabug.chat.settings.C0554a;
import com.instabug.library.core.plugin.Plugin;
import com.instabug.library.core.plugin.PluginPromptOption;
import java.util.ArrayList;
import java.util.List;
import rx.Subscription;

public class ChatPlugin extends Plugin implements C0540b {
    private Subscription coreEventsSubscription;

    public void init(Context context) {
        super.init(context);
        C0535a.m7880a(context);
        subscribeOnCoreEvents();
        C0539a.m7900a().m7911a((C0540b) this);
        sendPushNotificationToken();
    }

    public void release() {
        unSubscribeFromCoreEvents();
        C0535a.m7879a();
        C0539a.m7900a().m7912b((C0540b) this);
    }

    public long getLastActivityTime() {
        return C0535a.m7882b();
    }

    public ArrayList<PluginPromptOption> getPromptOptions() {
        return C0535a.m7883b((Context) this.contextWeakReference.get());
    }

    public List<Message> onNewMessagesReceived(List<Message> list) {
        if (this.contextWeakReference != null) {
            Context context = (Context) this.contextWeakReference.get();
            if (context != null) {
                C0534b.m7867a().m7875a(context, (List) list);
            }
        }
        return null;
    }

    private void subscribeOnCoreEvents() {
        this.coreEventsSubscription = C0535a.m7878a(C0535a.m7884c((Context) this.contextWeakReference.get()));
    }

    private void unSubscribeFromCoreEvents() {
        C0535a.m7881a(this.coreEventsSubscription);
    }

    private void sendPushNotificationToken() {
        if (!C0554a.m7958m() && !C0554a.m7957l().isEmpty() && this.contextWeakReference != null) {
            Context context = (Context) this.contextWeakReference.get();
            if (context != null) {
                context.startService(new Intent(context, InstabugPushNotificationTokenService.class));
            }
        }
    }
}
