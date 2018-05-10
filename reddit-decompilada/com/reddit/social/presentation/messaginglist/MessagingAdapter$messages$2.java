package com.reddit.social.presentation.messaginglist;

import com.reddit.social.presentation.presentationobjects.HasMessageData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "m1", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "m2", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingAdapter.kt */
final class MessagingAdapter$messages$2 extends Lambda implements Function2<HasMessageData, HasMessageData, Boolean> {
    public static final MessagingAdapter$messages$2 f37569a = new MessagingAdapter$messages$2();

    MessagingAdapter$messages$2() {
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        HasMessageData hasMessageData = (HasMessageData) obj;
        HasMessageData hasMessageData2 = (HasMessageData) obj2;
        Intrinsics.m26847b(hasMessageData, "m1");
        Intrinsics.m26847b(hasMessageData2, "m2");
        return Boolean.valueOf(hasMessageData.mo5204a().f22429b == hasMessageData2.mo5204a().f22429b ? true : null);
    }
}
