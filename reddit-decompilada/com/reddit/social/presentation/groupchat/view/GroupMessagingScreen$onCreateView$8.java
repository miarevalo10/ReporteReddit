package com.reddit.social.presentation.groupchat.view;

import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "test"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingScreen.kt */
final class GroupMessagingScreen$onCreateView$8<T> implements Predicate<CharSequence> {
    public static final GroupMessagingScreen$onCreateView$8 f29857a = new GroupMessagingScreen$onCreateView$8();

    GroupMessagingScreen$onCreateView$8() {
    }

    public final /* synthetic */ boolean test(Object obj) {
        CharSequence charSequence = (CharSequence) obj;
        Intrinsics.m26847b(charSequence, "it");
        return charSequence.length() > null ? true : null;
    }
}
