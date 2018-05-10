package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.datalibrary.social.model.ChannelMuteStatus;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "sendbirdEnabled", "channelMuteStatus", "Lcom/reddit/datalibrary/social/model/ChannelMuteStatus;", "apply", "(Ljava/lang/Boolean;Lcom/reddit/datalibrary/social/model/ChannelMuteStatus;)Z"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingSettingsPresenter.kt */
final class MessagingSettingsPresenter$load$3<T1, T2, R> implements BiFunction<Boolean, ChannelMuteStatus, Boolean> {
    public static final MessagingSettingsPresenter$load$3 f29830a = new MessagingSettingsPresenter$load$3();

    MessagingSettingsPresenter$load$3() {
    }

    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        ChannelMuteStatus channelMuteStatus = (ChannelMuteStatus) obj2;
        Intrinsics.m26847b(bool, "sendbirdEnabled");
        Intrinsics.m26847b(channelMuteStatus, "channelMuteStatus");
        if (bool.booleanValue() != null) {
            if (channelMuteStatus.isMuted() == null) {
                obj = null;
                return Boolean.valueOf(obj);
            }
        }
        obj = true;
        return Boolean.valueOf(obj);
    }
}
