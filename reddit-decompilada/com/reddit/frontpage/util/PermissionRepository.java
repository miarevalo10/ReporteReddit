package com.reddit.frontpage.util;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/util/PermissionRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "canReadLocation", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PermissionRepository.kt */
public final class PermissionRepository {
    private final Context f21776a;

    @Inject
    public PermissionRepository(Context context) {
        Intrinsics.m26847b(context, "context");
        this.f21776a = context;
    }

    public final boolean m23859a() {
        return ActivityCompat.a(this.f21776a, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }
}
