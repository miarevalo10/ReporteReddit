package com.reddit.frontpage.presentation.common;

import android.content.res.Resources;
import com.reddit.frontpage.domain.common.ResourceProvider;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J)\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/common/AndroidResourceProvider;", "Lcom/reddit/frontpage/domain/common/ResourceProvider;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "getString", "", "id", "", "formatArgs", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AndroidResourceProvider.kt */
public final class AndroidResourceProvider implements ResourceProvider {
    private final Resources f28085a;

    public AndroidResourceProvider(Resources resources) {
        Intrinsics.m26847b(resources, "resources");
        this.f28085a = resources;
    }

    public final String mo4794a(int i, Object... objArr) {
        Intrinsics.m26847b(objArr, "formatArgs");
        Object string = this.f28085a.getString(i, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.m26843a(string, "resources.getString(id, *formatArgs)");
        return string;
    }
}
