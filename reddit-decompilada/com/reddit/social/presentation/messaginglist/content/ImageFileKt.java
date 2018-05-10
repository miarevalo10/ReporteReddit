package com.reddit.social.presentation.messaginglist.content;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.reddit.frontpage.util.ImageUtil;
import com.reddit.social.presentation.presentationobjects.ImageFileMessageData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jcodec.codecs.mjpeg.JpegConst;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0006¨\u0006\u0007"}, d2 = {"bind", "", "Lcom/reddit/social/presentation/messaginglist/content/ImageFileMessageContent;", "messageData", "Lcom/reddit/social/presentation/presentationobjects/ImageFileMessageData;", "imageFileMessageContent", "Landroid/view/ViewGroup;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: ImageFile.kt */
public final class ImageFileKt {
    public static final ImageFileMessageContent m24721a(ViewGroup viewGroup) {
        Intrinsics.m26847b(viewGroup, "$receiver");
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new LayoutParams(JpegConst.APP4, 148));
        return new ImageFileMessageContent(imageView);
    }

    public static final void m24722a(ImageFileMessageContent imageFileMessageContent, ImageFileMessageData imageFileMessageData) {
        Intrinsics.m26847b(imageFileMessageContent, "$receiver");
        Intrinsics.m26847b(imageFileMessageData, "messageData");
        String str = "gif";
        Context context = imageFileMessageContent.f29893b.getContext();
        String str2 = imageFileMessageData.f29939c;
        if (str2 != null) {
            CharSequence charSequence = str2;
            if ((charSequence.length() > 0 ? 1 : null) != null) {
                if (StringsKt__StringsKt.m42452a(charSequence, (CharSequence) str)) {
                    ImageUtil.m23722a(context, imageFileMessageData.f29938b, imageFileMessageContent.f29893b, str2);
                    return;
                } else {
                    ImageUtil.m23720a(context, str2, imageFileMessageContent.f29893b);
                    return;
                }
            }
        }
        if (StringsKt__StringsKt.m42452a((CharSequence) imageFileMessageData.f29938b, (CharSequence) str)) {
            ImageUtil.m23722a(context, imageFileMessageData.f29938b, imageFileMessageContent.f29893b, null);
        } else {
            ImageUtil.m23720a(context, imageFileMessageData.f29938b, imageFileMessageContent.f29893b);
        }
    }
}
