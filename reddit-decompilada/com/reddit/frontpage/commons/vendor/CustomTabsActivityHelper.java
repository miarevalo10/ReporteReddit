package com.reddit.frontpage.commons.vendor;

import android.app.Activity;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v1.BaseEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent.ScreenViewPayload;
import com.reddit.frontpage.commons.analytics.outboundlinks.OutboundLinkTracker;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/reddit/frontpage/commons/vendor/CustomTabsActivityHelper;", "Lcom/reddit/frontpage/commons/vendor/ServiceConnectionCallback;", "()V", "client", "Landroid/support/customtabs/CustomTabsClient;", "connection", "Landroid/support/customtabs/CustomTabsServiceConnection;", "connectionCallback", "Lcom/reddit/frontpage/commons/vendor/CustomTabsActivityHelper$ConnectionCallback;", "customTabsSession", "Landroid/support/customtabs/CustomTabsSession;", "bindCustomTabsService", "", "activity", "Landroid/app/Activity;", "getSession", "mayLaunchUrl", "", "uri", "Landroid/net/Uri;", "extras", "Landroid/os/Bundle;", "otherLikelyBundles", "", "onServiceConnected", "onServiceDisconnected", "setConnectionCallback", "unbindCustomTabsService", "Companion", "ConnectionCallback", "CustomTabFallback", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CustomTabsActivityHelper.kt */
public final class CustomTabsActivityHelper {
    public static final Companion f20095a = new Companion();
    private static final String f20096b = "ext_browser";

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ>\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/commons/vendor/CustomTabsActivityHelper$Companion;", "", "()V", "SCREEN_NAME_BROWSER", "", "getSCREEN_NAME_BROWSER", "()Ljava/lang/String;", "launchFallback", "", "activity", "Landroid/app/Activity;", "uri", "Landroid/net/Uri;", "fallback", "Lcom/reddit/frontpage/commons/vendor/CustomTabsActivityHelper$CustomTabFallback;", "openCustomTab", "customTabsIntent", "Landroid/support/customtabs/CustomTabsIntent;", "fullname", "sourcePage", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CustomTabsActivityHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public static void m21967a(Activity activity, CustomTabsIntent customTabsIntent, Uri uri, String str, String str2, CustomTabFallback customTabFallback) {
            int i;
            CharSequence charSequence;
            int i2;
            ScreenViewEvent screenViewEvent;
            Object obj;
            Object uri2;
            Intrinsics.m26847b(activity, "activity");
            Intrinsics.m26847b(customTabsIntent, "customTabsIntent");
            Intrinsics.m26847b(uri, "uri");
            String a = CustomTabsHelper.m21971a(activity);
            Object scheme = uri.getScheme();
            CharSequence charSequence2 = (CharSequence) scheme;
            int i3 = 1;
            if (charSequence2 != null) {
                if (charSequence2.length() != 0) {
                    i = 0;
                    if (i == 0) {
                        uri = uri.buildUpon();
                        Intrinsics.m26843a(scheme, "scheme");
                        if (scheme != null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        scheme = scheme.toLowerCase();
                        Intrinsics.m26843a(scheme, "(this as java.lang.String).toLowerCase()");
                        uri = uri.scheme(scheme).build();
                        Intrinsics.m26843a((Object) uri, "uri.buildUpon().scheme(s…me.toLowerCase()).build()");
                    }
                    charSequence = str;
                    if (charSequence != null) {
                        if (charSequence.length() == 0) {
                            i2 = 0;
                            if (i2 == 0) {
                                charSequence = str2;
                                if (charSequence != null) {
                                    if (charSequence.length() != 0) {
                                        i3 = 0;
                                    }
                                }
                                if (i3 == 0) {
                                    screenViewEvent = new ScreenViewEvent(CustomTabsActivityHelper.f20096b);
                                    ((ScreenViewPayload) screenViewEvent.payload).target_url = uri.toString();
                                    ((ScreenViewPayload) screenViewEvent.payload).target_fullname = str;
                                    ((ScreenViewPayload) screenViewEvent.payload).source_page = str2;
                                    AppAnalytics.m21852a((BaseEvent) screenViewEvent);
                                }
                            }
                            if (a == null) {
                                obj = customTabsIntent.a;
                                Intrinsics.m26843a(obj, "customTabsIntent.intent");
                                obj.setPackage(a);
                                try {
                                    obj = customTabsIntent.a;
                                    Intrinsics.m26843a(obj, "customTabsIntent.intent");
                                    obj.setData(uri);
                                    activity.startActivityForResult(customTabsIntent.a, 3137, customTabsIntent.b);
                                    uri2 = uri.toString();
                                    Intrinsics.m26843a(uri2, "uri.toString()");
                                    OutboundLinkTracker.m21952a(uri2);
                                } catch (CustomTabsIntent customTabsIntent2) {
                                    Timber.c((Throwable) customTabsIntent2, "CustomTabsActivity.openCustomTab, ActivityNotFound", new Object[0]);
                                    m21966a(activity, uri, customTabFallback);
                                    return;
                                }
                            }
                            m21966a(activity, uri, customTabFallback);
                            return;
                        }
                    }
                    i2 = 1;
                    if (i2 == 0) {
                        charSequence = str2;
                        if (charSequence != null) {
                            if (charSequence.length() != 0) {
                                i3 = 0;
                            }
                        }
                        if (i3 == 0) {
                            screenViewEvent = new ScreenViewEvent(CustomTabsActivityHelper.f20096b);
                            ((ScreenViewPayload) screenViewEvent.payload).target_url = uri.toString();
                            ((ScreenViewPayload) screenViewEvent.payload).target_fullname = str;
                            ((ScreenViewPayload) screenViewEvent.payload).source_page = str2;
                            AppAnalytics.m21852a((BaseEvent) screenViewEvent);
                        }
                    }
                    if (a == null) {
                        m21966a(activity, uri, customTabFallback);
                        return;
                    }
                    obj = customTabsIntent2.a;
                    Intrinsics.m26843a(obj, "customTabsIntent.intent");
                    obj.setPackage(a);
                    obj = customTabsIntent2.a;
                    Intrinsics.m26843a(obj, "customTabsIntent.intent");
                    obj.setData(uri);
                    activity.startActivityForResult(customTabsIntent2.a, 3137, customTabsIntent2.b);
                    uri2 = uri.toString();
                    Intrinsics.m26843a(uri2, "uri.toString()");
                    OutboundLinkTracker.m21952a(uri2);
                }
            }
            i = 1;
            if (i == 0) {
                uri = uri.buildUpon();
                Intrinsics.m26843a(scheme, "scheme");
                if (scheme != null) {
                    scheme = scheme.toLowerCase();
                    Intrinsics.m26843a(scheme, "(this as java.lang.String).toLowerCase()");
                    uri = uri.scheme(scheme).build();
                    Intrinsics.m26843a((Object) uri, "uri.buildUpon().scheme(s…me.toLowerCase()).build()");
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            charSequence = str;
            if (charSequence != null) {
                if (charSequence.length() == 0) {
                    i2 = 0;
                    if (i2 == 0) {
                        charSequence = str2;
                        if (charSequence != null) {
                            if (charSequence.length() != 0) {
                                i3 = 0;
                            }
                        }
                        if (i3 == 0) {
                            screenViewEvent = new ScreenViewEvent(CustomTabsActivityHelper.f20096b);
                            ((ScreenViewPayload) screenViewEvent.payload).target_url = uri.toString();
                            ((ScreenViewPayload) screenViewEvent.payload).target_fullname = str;
                            ((ScreenViewPayload) screenViewEvent.payload).source_page = str2;
                            AppAnalytics.m21852a((BaseEvent) screenViewEvent);
                        }
                    }
                    if (a == null) {
                        obj = customTabsIntent2.a;
                        Intrinsics.m26843a(obj, "customTabsIntent.intent");
                        obj.setPackage(a);
                        obj = customTabsIntent2.a;
                        Intrinsics.m26843a(obj, "customTabsIntent.intent");
                        obj.setData(uri);
                        activity.startActivityForResult(customTabsIntent2.a, 3137, customTabsIntent2.b);
                        uri2 = uri.toString();
                        Intrinsics.m26843a(uri2, "uri.toString()");
                        OutboundLinkTracker.m21952a(uri2);
                    }
                    m21966a(activity, uri, customTabFallback);
                    return;
                }
            }
            i2 = 1;
            if (i2 == 0) {
                charSequence = str2;
                if (charSequence != null) {
                    if (charSequence.length() != 0) {
                        i3 = 0;
                    }
                }
                if (i3 == 0) {
                    screenViewEvent = new ScreenViewEvent(CustomTabsActivityHelper.f20096b);
                    ((ScreenViewPayload) screenViewEvent.payload).target_url = uri.toString();
                    ((ScreenViewPayload) screenViewEvent.payload).target_fullname = str;
                    ((ScreenViewPayload) screenViewEvent.payload).source_page = str2;
                    AppAnalytics.m21852a((BaseEvent) screenViewEvent);
                }
            }
            if (a == null) {
                m21966a(activity, uri, customTabFallback);
                return;
            }
            obj = customTabsIntent2.a;
            Intrinsics.m26843a(obj, "customTabsIntent.intent");
            obj.setPackage(a);
            obj = customTabsIntent2.a;
            Intrinsics.m26843a(obj, "customTabsIntent.intent");
            obj.setData(uri);
            activity.startActivityForResult(customTabsIntent2.a, 3137, customTabsIntent2.b);
            uri2 = uri.toString();
            Intrinsics.m26843a(uri2, "uri.toString()");
            OutboundLinkTracker.m21952a(uri2);
        }

        private static void m21966a(Activity activity, Uri uri, CustomTabFallback customTabFallback) {
            Intrinsics.m26847b(activity, "activity");
            Intrinsics.m26847b(uri, "uri");
            if (customTabFallback != null) {
                customTabFallback.mo4976a(activity, uri);
                Object uri2 = uri.toString();
                Intrinsics.m26843a(uri2, "uri.toString()");
                OutboundLinkTracker.m21952a(uri2);
                return;
            }
            Timber.e("CustomTabsActivityHelper.openCustomTab: can't launch activity and fallback is null", new Object[null]);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/commons/vendor/CustomTabsActivityHelper$CustomTabFallback;", "", "openUri", "", "activity", "Landroid/app/Activity;", "uri", "Landroid/net/Uri;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CustomTabsActivityHelper.kt */
    public interface CustomTabFallback {
        void mo4976a(Activity activity, Uri uri);
    }

    public static final void m21970a(Activity activity, CustomTabsIntent customTabsIntent, Uri uri, String str, String str2, CustomTabFallback customTabFallback) {
        Companion.m21967a(activity, customTabsIntent, uri, str, str2, customTabFallback);
    }
}
