package com.reddit.social.presentation.contacts.presentation;

import com.google.gson.JsonElement;
import com.reddit.datalibrary.social.model.User;
import com.reddit.social.analytics.ChatAnalytics;
import com.sendbird.android.SendBird;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/google/gson/JsonElement;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ContactsPresenter.kt */
final class ContactsPresenter$inviteToChannel$1<T> implements Consumer<JsonElement> {
    final /* synthetic */ ContactsPresenter f29701a;
    final /* synthetic */ List f29702b;
    final /* synthetic */ String f29703c;

    ContactsPresenter$inviteToChannel$1(ContactsPresenter contactsPresenter, List list, String str) {
        this.f29701a = contactsPresenter;
        this.f29702b = list;
        this.f29703c = str;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = SendBird.m25001k();
        obj = CollectionsKt___CollectionsKt.m41419a((Collection) this.f29702b, (Object) new User(obj.m25021d(), obj.m25022e(), obj.m25023f()));
        this.f29701a.m30749g();
        ChatAnalytics.m24469b(this.f29703c, obj);
        ContactsPresenter.m30713a(this.f29701a).mo7538f();
    }
}
