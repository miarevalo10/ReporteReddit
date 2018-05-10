package com.reddit.frontpage.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.util.ArrayMap;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.reddit.config.GlideApp;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.CustomViewPropertiesKt;
import org.jetbrains.anko.DimensionsKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u001aN\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017\u001a\f\u0010\u0019\u001a\u0004\u0018\u00010\u0005*\u00020\r\u001a1\u0010\u001a\u001a\u00020\u000b*\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001f\"8\u0010\u0000\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006 "}, d2 = {"nsfwBitmaps", "Landroid/util/ArrayMap;", "Lkotlin/Pair;", "", "Ljava/lang/ref/SoftReference;", "Landroid/graphics/Bitmap;", "getNsfwBitmaps", "()Landroid/util/ArrayMap;", "setNsfwBitmaps", "(Landroid/util/ArrayMap;)V", "setChatAvatars", "", "coverImage", "Landroid/widget/ImageView;", "iconFront", "iconBack", "iconPairContainer", "Landroid/view/ViewGroup;", "members", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "inviter", "isPrivate", "", "isAccepted", "getNsfwBitmap", "setAvatar", "iconUrl", "", "isNsfw", "cornerRadius", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: AvatarUtil.kt */
public final class AvatarUtilKt {
    private static ArrayMap<Pair<Integer, Integer>, SoftReference<Bitmap>> f21703a = new ArrayMap();

    public static final void m23659a(ImageView imageView, String str, Boolean bool, Integer num) {
        Intrinsics.m26847b(imageView, "$receiver");
        View view = imageView;
        CustomViewPropertiesKt.m28403a(view, null);
        imageView.setImageDrawable(null);
        if (Intrinsics.m26845a((Object) bool, Boolean.valueOf(true)) != null) {
            imageView.post((Runnable) new AvatarUtilKt$setAvatar$1(imageView));
        } else if (str != null) {
            str = GlideApp.a(imageView.getContext()).b(str);
            if (num != null) {
                num = num.intValue();
            } else {
                num = DimensionsKt.m28408a(view.getContext(), C1761R.dimen.user_avatar_corner_radius);
            }
            Intrinsics.m26843a(str.transform((Transformation) new RoundedCorners(num)).into(imageView), "GlideApp.with(context)\n …    )\n        .into(this)");
        } else {
            Timber.e("icon url is null", new Object[null]);
            Context context = imageView.getContext();
            Intrinsics.m26843a((Object) context, "context");
            CustomViewPropertiesKt.m28403a(view, ResourcesUtil.m22723b(context, (int) C1761R.attr.rdt_chat_missing_avatar));
        }
    }

    public static final Bitmap m23656a(ImageView imageView) {
        Intrinsics.m26847b(imageView, "$receiver");
        Bitmap bitmap = null;
        if (imageView.getWidth() > 0) {
            if (imageView.getHeight() > 0) {
                Pair pair = new Pair(Integer.valueOf(imageView.getWidth()), Integer.valueOf(imageView.getHeight()));
                SoftReference softReference = (SoftReference) f21703a.get(pair);
                if (softReference != null) {
                    bitmap = (Bitmap) softReference.get();
                }
                if (bitmap == null) {
                    bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Config.RGB_565);
                    Canvas canvas = new Canvas(bitmap);
                    Paint paint = new Paint();
                    paint.setColor(ContextCompat.c(imageView.getContext(), C1761R.color.rdt_off_black));
                    paint.setStyle(Style.FILL);
                    canvas.drawPaint(paint);
                    paint.setColor(ContextCompat.c(imageView.getContext(), C1761R.color.nsfw_avatar_text));
                    paint.setTextSize((float) (imageView.getWidth() / 4));
                    paint.setAntiAlias(true);
                    Rect rect = new Rect();
                    String string = imageView.getResources().getString(C1761R.string.label_nsfw);
                    paint.getTextBounds(string, 0, string.length(), rect);
                    float width = (((float) imageView.getWidth()) / 2.0f) - ((float) rect.centerX());
                    canvas.drawText(imageView.getResources().getString(C1761R.string.label_nsfw), width, (((float) imageView.getHeight()) / 2.0f) - ((float) rect.centerY()), paint);
                    f21703a.put(pair, new SoftReference(bitmap));
                }
                if (bitmap == null) {
                    Intrinsics.m26842a();
                }
                return bitmap;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m23657a(android.widget.ImageView r5, android.widget.ImageView r6, android.widget.ImageView r7, android.view.ViewGroup r8, java.util.List<com.reddit.social.presentation.presentationobjects.UserData> r9, com.reddit.social.presentation.presentationobjects.UserData r10, boolean r11, boolean r12) {
        /*
        r0 = "coverImage";
        kotlin.jvm.internal.Intrinsics.m26847b(r5, r0);
        r0 = "iconFront";
        kotlin.jvm.internal.Intrinsics.m26847b(r6, r0);
        r0 = "iconBack";
        kotlin.jvm.internal.Intrinsics.m26847b(r7, r0);
        r0 = "iconPairContainer";
        kotlin.jvm.internal.Intrinsics.m26847b(r8, r0);
        r0 = "members";
        kotlin.jvm.internal.Intrinsics.m26847b(r9, r0);
        r9 = (java.lang.Iterable) r9;
        r0 = r9.iterator();
    L_0x001f:
        r1 = r0.hasNext();
        r2 = 0;
        if (r1 == 0) goto L_0x003a;
    L_0x0026:
        r1 = r0.next();
        r3 = r1;
        r3 = (com.reddit.social.presentation.presentationobjects.UserData) r3;
        r3 = r3.f22464a;
        r4 = com.reddit.frontpage.util.SessionUtil.m23898d();
        r3 = kotlin.jvm.internal.Intrinsics.m26845a(r3, r4);
        if (r3 == 0) goto L_0x001f;
    L_0x0039:
        goto L_0x003b;
    L_0x003a:
        r1 = r2;
    L_0x003b:
        r0 = r1;
        r0 = (com.reddit.social.presentation.presentationobjects.UserData) r0;
        r1 = new kotlin.jvm.internal.Ref$ObjectRef;
        r1.<init>();
        r3 = 0;
        r4 = 1;
        if (r11 == 0) goto L_0x0067;
    L_0x0047:
        r9 = r9.iterator();
    L_0x004b:
        r10 = r9.hasNext();
        if (r10 == 0) goto L_0x0060;
    L_0x0051:
        r10 = r9.next();
        r11 = r10;
        r11 = (com.reddit.social.presentation.presentationobjects.UserData) r11;
        r11 = kotlin.jvm.internal.Intrinsics.m26845a(r11, r0);
        r11 = r11 ^ r4;
        if (r11 == 0) goto L_0x004b;
    L_0x005f:
        goto L_0x0061;
    L_0x0060:
        r10 = r2;
    L_0x0061:
        r10 = (com.reddit.social.presentation.presentationobjects.UserData) r10;
        r1.f25291a = r10;
        goto L_0x00f7;
    L_0x0067:
        if (r12 != 0) goto L_0x00b8;
    L_0x0069:
        if (r10 != 0) goto L_0x0088;
    L_0x006b:
        r10 = r9.iterator();
    L_0x006f:
        r11 = r10.hasNext();
        if (r11 == 0) goto L_0x0084;
    L_0x0075:
        r11 = r10.next();
        r12 = r11;
        r12 = (com.reddit.social.presentation.presentationobjects.UserData) r12;
        r12 = kotlin.jvm.internal.Intrinsics.m26845a(r12, r0);
        r12 = r12 ^ r4;
        if (r12 == 0) goto L_0x006f;
    L_0x0083:
        goto L_0x0085;
    L_0x0084:
        r11 = r2;
    L_0x0085:
        r10 = r11;
        r10 = (com.reddit.social.presentation.presentationobjects.UserData) r10;
    L_0x0088:
        r1.f25291a = r10;
        r9 = r9.iterator();
    L_0x008e:
        r10 = r9.hasNext();
        if (r10 == 0) goto L_0x00b3;
    L_0x0094:
        r10 = r9.next();
        r11 = r10;
        r11 = (com.reddit.social.presentation.presentationobjects.UserData) r11;
        r12 = r1.f25291a;
        r12 = (com.reddit.social.presentation.presentationobjects.UserData) r12;
        r12 = kotlin.jvm.internal.Intrinsics.m26845a(r11, r12);
        r12 = r12 ^ r4;
        if (r12 == 0) goto L_0x00af;
    L_0x00a6:
        r11 = kotlin.jvm.internal.Intrinsics.m26845a(r11, r0);
        r11 = r11 ^ r4;
        if (r11 == 0) goto L_0x00af;
    L_0x00ad:
        r11 = r4;
        goto L_0x00b0;
    L_0x00af:
        r11 = r3;
    L_0x00b0:
        if (r11 == 0) goto L_0x008e;
    L_0x00b2:
        goto L_0x00b4;
    L_0x00b3:
        r10 = r2;
    L_0x00b4:
        r9 = r10;
        r9 = (com.reddit.social.presentation.presentationobjects.UserData) r9;
        goto L_0x00f8;
    L_0x00b8:
        r11 = kotlin.collections.CollectionsKt___CollectionsKt.m41420a(r9, r10);
        if (r11 == 0) goto L_0x00c8;
    L_0x00be:
        r11 = kotlin.jvm.internal.Intrinsics.m26845a(r10, r0);
        r11 = r11 ^ r4;
        if (r11 == 0) goto L_0x00c8;
    L_0x00c5:
        r1.f25291a = r10;
        goto L_0x00f5;
    L_0x00c8:
        r9 = r9.iterator();
    L_0x00cc:
        r10 = r9.hasNext();
        if (r10 == 0) goto L_0x00e1;
    L_0x00d2:
        r10 = r9.next();
        r11 = r10;
        r11 = (com.reddit.social.presentation.presentationobjects.UserData) r11;
        r11 = kotlin.jvm.internal.Intrinsics.m26845a(r11, r0);
        r11 = r11 ^ r4;
        if (r11 == 0) goto L_0x00cc;
    L_0x00e0:
        goto L_0x00e2;
    L_0x00e1:
        r10 = r2;
    L_0x00e2:
        r9 = r10;
        r9 = (com.reddit.social.presentation.presentationobjects.UserData) r9;
        if (r9 != 0) goto L_0x00e8;
    L_0x00e7:
        r9 = r0;
    L_0x00e8:
        r1.f25291a = r9;
        r9 = r1.f25291a;
        r9 = (com.reddit.social.presentation.presentationobjects.UserData) r9;
        r9 = kotlin.jvm.internal.Intrinsics.m26845a(r9, r0);
        r9 = r9 ^ r4;
        if (r9 == 0) goto L_0x00f7;
    L_0x00f5:
        r9 = r0;
        goto L_0x00f8;
    L_0x00f7:
        r9 = r2;
    L_0x00f8:
        r10 = r5;
        r10 = (android.view.View) r10;
        if (r9 != 0) goto L_0x00ff;
    L_0x00fd:
        r11 = r4;
        goto L_0x0100;
    L_0x00ff:
        r11 = r3;
    L_0x0100:
        com.reddit.frontpage.util.kotlin.ViewsKt.m24106b(r10, r11);
        r8 = (android.view.View) r8;
        if (r9 == 0) goto L_0x0108;
    L_0x0107:
        r3 = r4;
    L_0x0108:
        com.reddit.frontpage.util.kotlin.ViewsKt.m24106b(r8, r3);
        if (r9 != 0) goto L_0x0125;
    L_0x010d:
        r6 = r1.f25291a;
        r6 = (com.reddit.social.presentation.presentationobjects.UserData) r6;
        if (r6 == 0) goto L_0x0124;
    L_0x0113:
        r7 = r6.f22466c;
        r8 = r6.f22465b;
        r6 = r6.f22470g;
        r6 = com.reddit.frontpage.util.AccountPrefsUtil.m23630a(r8, r6);
        r6 = java.lang.Boolean.valueOf(r6);
        m23659a(r5, r7, r6, r2);
    L_0x0124:
        return;
    L_0x0125:
        r5 = r1.f25291a;
        r5 = (com.reddit.social.presentation.presentationobjects.UserData) r5;
        if (r5 == 0) goto L_0x013c;
    L_0x012b:
        r8 = r5.f22466c;
        r10 = r5.f22465b;
        r5 = r5.f22470g;
        r5 = com.reddit.frontpage.util.AccountPrefsUtil.m23630a(r10, r5);
        r5 = java.lang.Boolean.valueOf(r5);
        m23659a(r6, r8, r5, r2);
    L_0x013c:
        r5 = r9.f22466c;
        r6 = r9.f22465b;
        r8 = r9.f22470g;
        r6 = com.reddit.frontpage.util.AccountPrefsUtil.m23630a(r6, r8);
        r6 = java.lang.Boolean.valueOf(r6);
        m23659a(r7, r5, r6, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.AvatarUtilKt.a(android.widget.ImageView, android.widget.ImageView, android.widget.ImageView, android.view.ViewGroup, java.util.List, com.reddit.social.presentation.presentationobjects.UserData, boolean, boolean):void");
    }
}
