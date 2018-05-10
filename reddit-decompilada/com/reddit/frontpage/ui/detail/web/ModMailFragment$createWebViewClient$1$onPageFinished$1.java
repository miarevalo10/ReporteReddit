package com.reddit.frontpage.ui.detail.web;

import android.webkit.ValueCallback;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "s", "", "kotlin.jvm.PlatformType", "onReceiveValue"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModMailFragment.kt */
final class ModMailFragment$createWebViewClient$1$onPageFinished$1<T> implements ValueCallback<String> {
    public static final ModMailFragment$createWebViewClient$1$onPageFinished$1 f21201a = new ModMailFragment$createWebViewClient$1$onPageFinished$1();

    ModMailFragment$createWebViewClient$1$onPageFinished$1() {
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Timber.b("Inject headers response: %s", new Object[]{(String) obj});
    }
}
