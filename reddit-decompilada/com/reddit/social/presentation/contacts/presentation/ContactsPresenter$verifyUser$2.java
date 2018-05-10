package com.reddit.social.presentation.contacts.presentation;

import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ChatEventBuilder;
import com.reddit.social.analytics.ChatAnalytics.Source;
import com.reddit.social.presentation.presentationobjects.UserStatus;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ContactsPresenter.kt */
final class ContactsPresenter$verifyUser$2<T> implements Consumer<Throwable> {
    final /* synthetic */ ContactsPresenter f29707a;
    final /* synthetic */ String f29708b;

    ContactsPresenter$verifyUser$2(ContactsPresenter contactsPresenter, String str) {
        this.f29707a = contactsPresenter;
        this.f29708b = str;
    }

    public final /* synthetic */ void accept(Object obj) {
        ContactsPresenter.m30713a(this.f29707a).mo7525a(this.f29708b, UserStatus.f22476f);
        obj = this.f29707a.m30749g();
        String str = "search";
        List h = this.f29707a.m30750h();
        Intrinsics.m26847b(str, "userAddedMethod");
        Intrinsics.m26847b(h, "members");
        if (System.currentTimeMillis() - obj.f22295e > 300) {
            obj.f22295e = System.currentTimeMillis();
            ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(Source.f22285e.f22289h)).m21892b("view")).m21895c("alert_invalid_user")).m28926h(str).m28925g("direct").m28920d(Long.valueOf((long) h.size())).m28924f(null).mo4572a(false).m21891a();
        }
    }
}
