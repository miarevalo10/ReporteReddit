package com.instabug.bug;

import android.content.Context;
import com.instabug.bug.settings.C0485a;
import com.instabug.library.core.plugin.Plugin;
import com.instabug.library.core.plugin.PluginPromptOption;
import java.util.ArrayList;
import rx.Subscription;

public class BugPlugin extends Plugin {
    private Subscription coreEventsSubscription;

    public void init(Context context) {
        super.init(context);
        C0467a.m7729a(context);
        subscribeOnCoreEvents();
    }

    private void subscribeOnCoreEvents() {
        this.coreEventsSubscription = C0467a.m7725a(C0467a.m7733b((Context) this.contextWeakReference.get()));
    }

    public ArrayList<PluginPromptOption> getPromptOptions() {
        return C0467a.m7737c((Context) this.contextWeakReference.get());
    }

    public void release() {
        C0467a.m7726a();
        unSubscribeFromCoreEvents();
    }

    private void unSubscribeFromCoreEvents() {
        C0467a.m7732a(this.coreEventsSubscription);
    }

    public long getLastActivityTime() {
        C0485a.m7793a();
        return C0485a.m7821l();
    }
}
