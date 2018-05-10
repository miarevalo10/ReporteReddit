package com.reddit.social.presentation.messaginglist.content;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.Sdk21PropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0010\u0010\n\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/reddit/social/presentation/messaginglist/content/LinkKt$bindLinkEmbed$3", "Lcom/bumptech/glide/request/target/SimpleTarget;", "Landroid/graphics/Bitmap;", "(Lcom/reddit/social/presentation/messaginglist/content/LinkContent;)V", "onLoadFailed", "", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Link.kt */
public final class LinkKt$bindLinkEmbed$3 extends SimpleTarget<Bitmap> {
    final /* synthetic */ LinkContent f39379a;

    LinkKt$bindLinkEmbed$3(LinkContent linkContent) {
        this.f39379a = linkContent;
    }

    public final /* synthetic */ void m39618a(Object obj, Transition transition) {
        Bitmap bitmap = (Bitmap) obj;
        Intrinsics.m26847b(bitmap, "resource");
        ViewsKt.m24107c((View) this.f39379a.f29897e);
        Sdk21PropertiesKt.m28411a(this.f39379a.f29897e, bitmap);
    }

    public final void m39619c(Drawable drawable) {
        ViewsKt.m24109d((View) this.f39379a.f29897e);
    }
}
