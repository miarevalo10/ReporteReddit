package com.reddit.social.presentation.contacts.presentation;

import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.presentation.contacts.ContactsContract.View;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ContactsPresenter.kt */
final class ContactsPresenter$create$2<T> implements Consumer<String> {
    final /* synthetic */ ContactsPresenter f29694a;
    final /* synthetic */ List f29695b;

    ContactsPresenter$create$2(ContactsPresenter contactsPresenter, List list) {
        this.f29694a = contactsPresenter;
        this.f29695b = list;
    }

    public final /* synthetic */ void accept(Object obj) {
        String str = (String) obj;
        View a = ContactsPresenter.m30713a(this.f29694a);
        Intrinsics.m26843a((Object) str, UpdateFragment.FRAGMENT_URL);
        a.mo7527a(str, this.f29694a.f29722n, this.f29694a.f29723o, this.f29694a.f29724p);
        this.f29694a.m30749g();
        ChatAnalytics.m24465a(str, this.f29695b);
    }
}
