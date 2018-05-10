package com.instabug.library.core.plugin;

import android.net.Uri;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

@SuppressFBWarnings({"SE_BAD_FIELD"})
public class PluginPromptOption implements Serializable {
    private int icon;
    private int invocationMode;
    private int notificationCount;
    private OnInvocationListener onInvocationListener;
    private int order;
    private String title;

    public interface OnInvocationListener {
        void onInvoke(Uri uri);
    }

    public static class C0656a implements Serializable, Comparator<PluginPromptOption> {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return ((PluginPromptOption) obj).getOrder() - ((PluginPromptOption) obj2).getOrder();
        }
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int i) {
        this.order = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int getIcon() {
        return this.icon;
    }

    public void setIcon(int i) {
        this.icon = i;
    }

    public int getNotificationCount() {
        return this.notificationCount;
    }

    public void setNotificationCount(int i) {
        if (i > 99) {
            this.notificationCount = 99;
        } else if (i < 0) {
            this.notificationCount = 0;
        } else {
            this.notificationCount = i;
        }
    }

    public int getInvocationMode() {
        return this.invocationMode;
    }

    public void setInvocationMode(int i) {
        this.invocationMode = i;
    }

    public void invoke(Uri uri) {
        if (this.onInvocationListener != null) {
            this.onInvocationListener.onInvoke(uri);
        }
    }

    public void invoke() {
        invoke(null);
    }

    public static PluginPromptOption getPromptOptionByInvocationMode(int i) {
        Iterator it = C0657a.m8160c().iterator();
        while (it.hasNext()) {
            PluginPromptOption pluginPromptOption = (PluginPromptOption) it.next();
            if (pluginPromptOption.getInvocationMode() == i) {
                return pluginPromptOption;
            }
        }
        return 0;
    }

    public void setOnInvocationListener(OnInvocationListener onInvocationListener) {
        this.onInvocationListener = onInvocationListener;
    }
}
