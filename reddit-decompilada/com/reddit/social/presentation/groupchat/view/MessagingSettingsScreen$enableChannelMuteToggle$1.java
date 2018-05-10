package com.reddit.social.presentation.groupchat.view;

import android.widget.CompoundButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "isChecked", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingSettingsScreen.kt */
final class MessagingSettingsScreen$enableChannelMuteToggle$1 extends Lambda implements Function2<CompoundButton, Boolean, Unit> {
    final /* synthetic */ MessagingSettingsScreen f37545a;

    MessagingSettingsScreen$enableChannelMuteToggle$1(MessagingSettingsScreen messagingSettingsScreen) {
        this.f37545a = messagingSettingsScreen;
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        this.f37545a.mo7570a();
        this.f37545a.m41360w().mo5188b(booleanValue);
        return Unit.f25273a;
    }
}
