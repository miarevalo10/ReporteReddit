package com.instabug.library.core.plugin;

import android.content.Context;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public abstract class Plugin {
    public static final int STATE_BACKGROUND = 0;
    public static final int STATE_FOREGROUND = 1;
    public static final int STATE_PROCESSING_ATTACHMENT = 2;
    protected WeakReference<Context> contextWeakReference;
    protected int state = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PluginState {
    }

    public abstract long getLastActivityTime();

    public ArrayList<PluginPromptOption> getPromptOptions() {
        return null;
    }

    public void invoke(PluginPromptOption pluginPromptOption) {
    }

    public abstract void release();

    public void init(Context context) {
        this.contextWeakReference = new WeakReference(context);
    }

    public void setState(int i) {
        this.state = i;
    }

    public int getState() {
        return this.state;
    }

    public Context getAppContext() {
        if (this.contextWeakReference == null) {
            return null;
        }
        return (Context) this.contextWeakReference.get();
    }

    public boolean isAppContextAvailable() {
        return (this.contextWeakReference == null || this.contextWeakReference.get() == null) ? false : true;
    }
}
