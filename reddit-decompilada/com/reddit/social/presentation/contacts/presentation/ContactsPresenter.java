package com.reddit.social.presentation.contacts.presentation;

import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.datalibrary.social.model.User;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.CharSequencesKt;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.presentation.contacts.ContactsContract.Presenter;
import com.reddit.social.presentation.contacts.ContactsContract.View;
import com.reddit.social.presentation.contacts.view.ContactsActionType;
import com.reddit.social.presentation.contacts.view.ContactsActionType.ADD;
import com.reddit.social.presentation.contacts.view.ContactsActionType.CREATE;
import com.reddit.social.presentation.presentationobjects.ContactData;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.reddit.social.presentation.presentationobjects.UserStatus;
import com.reddit.social.util.ChatUtilKt;
import com.sendbird.android.SendBird;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jcodec.codecs.mjpeg.JpegConst;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0016J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\u000bH\u0016J\b\u00105\u001a\u00020-H\u0016J\u0010\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020\u0006H\u0016J\u0018\u00108\u001a\u00020-2\u0006\u00104\u001a\u00020\u000b2\u0006\u00109\u001a\u00020/H\u0002J\u0010\u0010:\u001a\u00020-2\u0006\u00107\u001a\u00020\u0006H\u0016J\u0018\u0010;\u001a\u00020-2\u0006\u00104\u001a\u00020\u000b2\u0006\u00109\u001a\u00020/H\u0002J\u0012\u0010<\u001a\u00020-2\b\u0010=\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010>\u001a\u00020-H\u0016J\u0018\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0016J\u0012\u0010A\u001a\u0004\u0018\u00010\u000b2\u0006\u0010B\u001a\u00020\u0006H\u0002J\b\u0010C\u001a\u00020-H\u0002J\b\u0010D\u001a\u00020\u0004H\u0016J\b\u0010E\u001a\u00020\u0004H\u0016J\b\u0010F\u001a\u000201H\u0016J\b\u0010G\u001a\u00020\u0006H\u0016J\u0018\u0010H\u001a\u00020\u00062\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0002J\u0010\u0010I\u001a\u00020-2\u0006\u0010=\u001a\u00020\u0006H\u0016J<\u0010J\u001a\u00020-2\b\u0010K\u001a\u0004\u0018\u00010\u00062\b\u0010L\u001a\u0004\u0018\u00010\u00062\b\u0010M\u001a\u0004\u0018\u00010%2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020+0\"H\u0016J\u0010\u0010N\u001a\u00020-2\u0006\u0010O\u001a\u00020\u0006H\u0016J\u0010\u0010P\u001a\u00020/2\u0006\u0010B\u001a\u00020\u0006H\u0002J\b\u0010Q\u001a\u00020-H\u0016J\u0010\u0010R\u001a\u00020-2\u0006\u0010S\u001a\u00020/H\u0002J\u0012\u0010T\u001a\u00020-2\b\u0010=\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010U\u001a\u00020-H\u0002J\b\u0010V\u001a\u00020-H\u0016J\u0010\u0010W\u001a\u00020-2\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010Z\u001a\u00020-2\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010[\u001a\u00020-2\u0006\u0010\\\u001a\u00020\u0004H\u0002J\u0010\u0010]\u001a\u00020-2\u0006\u00104\u001a\u00020\u000bH\u0016J\u0010\u0010^\u001a\u00020-2\u0006\u0010B\u001a\u00020\u0006H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u001e0\n8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\"X\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/reddit/social/presentation/contacts/presentation/ContactsPresenter;", "Lcom/reddit/social/presentation/contacts/ContactsContract$Presenter;", "()V", "MAX_MEMBERS_COUNT", "", "SELECTED_CONTACTS_KEY", "", "SHARE_TITLE_KEY", "SHARE_URL_KEY", "allContacts", "", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "availableContacts", "chatAnalytics", "Lcom/reddit/social/analytics/ChatAnalytics;", "getChatAnalytics", "()Lcom/reddit/social/analytics/ChatAnalytics;", "setChatAnalytics", "(Lcom/reddit/social/analytics/ChatAnalytics;)V", "chatDataRepository", "Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "getChatDataRepository", "()Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "setChatDataRepository", "(Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;)V", "contactsActionType", "Lcom/reddit/social/presentation/contacts/view/ContactsActionType;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "members", "Lcom/reddit/datalibrary/social/network/UserId;", "getMembers", "()Ljava/util/List;", "selectedUsers", "", "Lcom/reddit/datalibrary/social/model/User;", "shareLink", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "shareTitle", "shareUrl", "view", "Lcom/reddit/social/presentation/contacts/ContactsContract$View;", "сontactsInChannelAlready", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "attachView", "", "canAddTokenByEnter", "", "text", "", "prefix", "changeContactSelection", "contactData", "close", "contactAdded", "contactName", "contactDeselected", "notifyView", "contactRemoved", "contactSelected", "create", "channelName", "detach", "filter", "str", "getContact", "username", "getContacts", "getContactsCountLeft", "getContactsCountLimit", "getSubTitle", "getTitle", "getTokenFromString", "groupNameTextChanged", "init", "title", "url", "link", "inviteToChannel", "channelUrl", "isAvailableContact", "loadContacts", "networkConnectionChange", "isConnected", "onClickInviteButton", "reconnect", "refresh", "restore", "stateStorage", "Lcom/reddit/datalibrary/social/data/common/StateStorageContract;", "save", "updateGroupNameField", "numUsersSelected", "userClicked", "verifyUser", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ContactsPresenter.kt */
public final class ContactsPresenter implements Presenter {
    @Inject
    public ChatDataRepositoryContract f29709a;
    @Inject
    public ChatAnalytics f29710b;
    private final String f29711c = "SELECTED_CONTACTS_KEY";
    private final String f29712d = "SHARE_TITLE_KEY";
    private final String f29713e = "SHARE_URL_KEY";
    private final int f29714f = 100;
    private View f29715g;
    private ContactsActionType f29716h;
    private Set<User> f29717i = SetsKt__SetsKt.m26799a();
    private Set<UserData> f29718j = SetsKt__SetsKt.m26799a();
    private List<ContactData> f29719k = CollectionsKt__CollectionsKt.m26790a();
    private List<ContactData> f29720l = CollectionsKt__CollectionsKt.m26790a();
    private CompositeDisposable f29721m = new CompositeDisposable();
    private String f29722n;
    private String f29723o;
    private Link f29724p;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f22343a;

        static {
            int[] iArr = new int[UserStatus.values().length];
            f22343a = iArr;
            iArr[UserStatus.f22472b.ordinal()] = 1;
            f22343a[UserStatus.f22474d.ordinal()] = 2;
            f22343a[UserStatus.f22477g.ordinal()] = 3;
            f22343a[UserStatus.f22471a.ordinal()] = 4;
            f22343a[UserStatus.f22473c.ordinal()] = 5;
            f22343a[UserStatus.f22475e.ordinal()] = 6;
            f22343a[UserStatus.f22476f.ordinal()] = 7;
        }
    }

    public ContactsPresenter() {
        FrontpageApplication.m28878n().mo5092a(this);
    }

    public static final /* synthetic */ View m30713a(ContactsPresenter contactsPresenter) {
        contactsPresenter = contactsPresenter.f29715g;
        if (contactsPresenter == null) {
            Intrinsics.m26844a("view");
        }
        return contactsPresenter;
    }

    public final ChatAnalytics m30749g() {
        ChatAnalytics chatAnalytics = this.f29710b;
        if (chatAnalytics == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        return chatAnalytics;
    }

    public final List<String> m30750h() {
        Collection arrayList = new ArrayList();
        for (User user_id : this.f29717i) {
            String user_id2 = user_id.getUser_id();
            if (user_id2 != null) {
                arrayList.add(user_id2);
            }
        }
        arrayList = (List) arrayList;
        Iterable<UserData> iterable = this.f29718j;
        Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (UserData userData : iterable) {
            arrayList2.add(userData.f22464a);
        }
        return CollectionsKt___CollectionsKt.m41423b(arrayList, (Iterable) CollectionsKt___CollectionsKt.m41419a((Collection) (List) arrayList2, (Object) SessionUtil.m23898d()));
    }

    private final void m30717a(ContactData contactData, boolean z) {
        if (!ChatUtilKt.m24762b() && z) {
            this.f29717i = SetsKt__SetsKt.m26799a();
            View view = this.f29715g;
            if (view == null) {
                Intrinsics.m26844a("view");
            }
            view.mo7537e();
        }
        for (Object next : this.f29717i) {
            if (Intrinsics.m26845a(((User) next).getNickname(), contactData.f29927a)) {
                break;
            }
        }
        Object next2 = null;
        if (next2 == null) {
            this.f29717i = SetsKt___SetsKt.m32821b(this.f29717i, new User(contactData.f29929c, contactData.f29927a, contactData.f29928b));
        }
        if (z) {
            z = this.f29715g;
            if (!z) {
                Intrinsics.m26844a("view");
            }
            z.mo7533b(contactData.f29927a);
        }
        m30714a(this.f29717i.size());
        contactData = this.f29715g;
        if (contactData == null) {
            Intrinsics.m26844a("view");
        }
        contactData.mo7531b();
        if (this.f29717i.size() == true) {
            contactData = this.f29715g;
            if (contactData == null) {
                Intrinsics.m26844a("view");
            }
            contactData.mo7534c();
            return;
        }
        if (this.f29717i.size() == true) {
            contactData = this.f29716h;
            if (contactData == null) {
                Intrinsics.m26844a("contactsActionType");
            }
            if ((contactData instanceof CREATE) != null) {
                contactData = this.f29715g;
                if (contactData == null) {
                    Intrinsics.m26844a("view");
                }
                contactData.mo7535d();
            }
        }
    }

    private final void m30721b(ContactData contactData, boolean z) {
        for (Object next : this.f29717i) {
            if (Intrinsics.m26845a(((User) next).getNickname(), contactData.f29927a)) {
                break;
            }
        }
        Object next2 = null;
        User user = (User) next2;
        if (user != null) {
            this.f29717i = SetsKt___SetsKt.m32820a(this.f29717i, (Object) user);
        }
        if (z) {
            z = this.f29715g;
            if (!z) {
                Intrinsics.m26844a("view");
            }
            z.mo7241c(contactData.f29927a);
        }
        m30714a(this.f29717i.size());
        contactData = this.f29715g;
        if (contactData == null) {
            Intrinsics.m26844a("view");
        }
        contactData.mo7531b();
        if (this.f29717i.isEmpty() != null) {
            contactData = this.f29715g;
            if (contactData == null) {
                Intrinsics.m26844a("view");
            }
            contactData.mo7535d();
        }
    }

    private static String m30718b(CharSequence charSequence, String str) {
        Object previous;
        str = StringsKt__StringsKt.m42459b((CharSequence) new Regex(str).m28148b(charSequence, ""), new String[]{","});
        str = str.listIterator(str.size());
        while (str.hasPrevious()) {
            previous = str.previous();
            if ((Intrinsics.m26845a((Object) charSequence, (Object) "") ^ 1) != 0) {
                break;
            }
        }
        previous = null;
        String str2 = (String) previous;
        if (str2 != null) {
            if (str2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            charSequence = StringsKt__StringsKt.m42456b((CharSequence) str2).toString();
            if (charSequence != null) {
                return charSequence;
            }
        }
        return "";
    }

    public final boolean mo5140a(CharSequence charSequence, String str) {
        Intrinsics.m26847b(charSequence, "text");
        Intrinsics.m26847b(str, "prefix");
        return m30728g(m30718b(charSequence, str));
    }

    private final void m30714a(int i) {
        if (i > 1) {
            i = this.f29716h;
            if (i == 0) {
                Intrinsics.m26844a("contactsActionType");
            }
            if ((i instanceof CREATE) != 0) {
                i = this.f29715g;
                if (i == 0) {
                    Intrinsics.m26844a("view");
                }
                i.mo7539g();
                return;
            }
        }
        i = this.f29715g;
        if (i == 0) {
            Intrinsics.m26844a("view");
        }
        i.ap_();
    }

    private final ContactData m30725f(String str) {
        for (Object next : this.f29719k) {
            if (StringsKt__StringsJVMKt.m41946a(((ContactData) next).f29927a, str, true)) {
                break;
            }
        }
        Object next2 = null;
        return (ContactData) next2;
    }

    private final boolean m30728g(String str) {
        Iterable<ContactData> iterable = this.f29720l;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (ContactData contactData : iterable) {
                if (StringsKt__StringsJVMKt.m41946a(contactData.f29927a, str, true)) {
                    return true;
                }
            }
        }
        return null;
    }

    public final void mo5135a(View view) {
        Intrinsics.m26847b(view, "view");
        this.f29715g = view;
        CompositeDisposable compositeDisposable = this.f29721m;
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29709a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        DisposableKt.m26766a(compositeDisposable, chatDataRepositoryContract.mo4516a((Function1) new ContactsPresenter$attachView$1(view), (Function1) new ContactsPresenter$attachView$2(this)));
        ContactsActionType contactsActionType = this.f29716h;
        if (contactsActionType == null) {
            Intrinsics.m26844a("contactsActionType");
        }
        if (contactsActionType instanceof CREATE) {
            ContactData contactData = ((CREATE) contactsActionType).f29727a;
            if (contactData != null) {
                m30717a(contactData, true);
            }
            view.mo7522a((int) C1761R.string.start_chat_label);
            return;
        }
        if (contactsActionType instanceof ADD) {
            view.mo7522a((int) C1761R.string.invite_to_chat_label);
        }
    }

    public final String mo5146d() {
        int i;
        ContactsActionType contactsActionType = this.f29716h;
        if (contactsActionType == null) {
            Intrinsics.m26844a("contactsActionType");
        }
        if (contactsActionType instanceof CREATE) {
            i = C1761R.string.rdt_title_new_chat;
        } else if (contactsActionType instanceof ADD) {
            i = C1761R.string.rdt_title_invite_to_chat;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Object f = Util.m24027f(i);
        Intrinsics.m26843a(f, "Util.getString(\n      wh…nvite_to_chat\n      }\n  )");
        return f;
    }

    public final CharSequence mo5148e() {
        int i = m30729i();
        if (i > 0) {
            Object a = Util.m23959a((int) C1761R.plurals.fmt_you_can_add_more_people, i, Integer.valueOf(i));
            Intrinsics.m26843a(a, "Util.getQuantityString(R…tLeft, contactsCountLeft)");
            return (CharSequence) a;
        }
        a = Util.m24027f((int) C1761R.string.max_group_size_reached);
        Intrinsics.m26843a(a, "Util.getString(R.string.max_group_size_reached)");
        return CharSequencesKt.m24071a((CharSequence) a);
    }

    public final int mo5150f() {
        return Math.max(this.f29714f - Math.max(this.f29718j.size(), 1), 0);
    }

    private int m30729i() {
        return Math.max(mo5150f() - this.f29717i.size(), 0);
    }

    public final void mo5139a(String str, String str2, Link link, ContactsActionType contactsActionType, Set<UserData> set) {
        Intrinsics.m26847b(contactsActionType, "contactsActionType");
        Intrinsics.m26847b(set, "members");
        this.f29722n = str;
        this.f29723o = str2;
        this.f29724p = link;
        this.f29716h = contactsActionType;
        this.f29718j = set;
    }

    public final void mo5133a() {
        m30730j();
    }

    private final void m30730j() {
        CompositeDisposable compositeDisposable = this.f29721m;
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29709a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Object d = SessionUtil.m23898d();
        Intrinsics.m26843a(d, "getTypedCurrentSessionAccountID()");
        Observable observeOn = chatDataRepositoryContract.mo4534g(d).subscribeOn(SchedulerProvider.m23886b()).map(ContactsPresenter$getContacts$1.f29697a).doOnNext(new ContactsPresenter$getContacts$2(this)).map(new ContactsPresenter$getContacts$3(this)).map(new ContactsPresenter$getContacts$4(this)).observeOn(SchedulerProvider.m23887c());
        Intrinsics.m26843a((Object) observeOn, "chatDataRepository.conta…n(SchedulerProvider.ui())");
        DisposableKt.m26766a(compositeDisposable, ObservablesKt.m24091a(observeOn, (Function1) new ContactsPresenter$getContacts$5(this)));
    }

    public final void mo5137a(String str) {
        Intrinsics.m26847b(str, "contactName");
        ContactData f = m30725f(str);
        ContactsActionType contactsActionType;
        if (f != null) {
            if (this.f29710b == null) {
                Intrinsics.m26844a("chatAnalytics");
            }
            str = "contacts";
            contactsActionType = this.f29716h;
            if (contactsActionType == null) {
                Intrinsics.m26844a("contactsActionType");
            }
            ChatAnalytics.m24464a(str, contactsActionType, m30750h(), f.f29929c);
            f.f29930d = true;
            m30717a(f, false);
        } else {
            if (this.f29710b == null) {
                Intrinsics.m26844a("chatAnalytics");
            }
            String str2 = "search";
            contactsActionType = this.f29716h;
            if (contactsActionType == null) {
                Intrinsics.m26844a("contactsActionType");
            }
            ChatAnalytics.m24464a(str2, contactsActionType, m30750h(), null);
            m30717a(new ContactData(str, null, null, null, null, null, null, 248), false);
        }
        str = this.f29715g;
        if (str == null) {
            Intrinsics.m26844a("view");
        }
        str.mo7521a();
    }

    public final void mo5143b(String str) {
        Intrinsics.m26847b(str, "contactName");
        ContactData f = m30725f(str);
        if (f != null) {
            f.f29930d = false;
            m30721b(f, false);
        } else {
            m30721b(new ContactData(str, null, null, null, null, null, null, 248), false);
        }
        str = this.f29715g;
        if (str == null) {
            Intrinsics.m26844a("view");
        }
        str.mo7521a();
    }

    public final void mo5145c(String str) {
        ContactsActionType contactsActionType = this.f29716h;
        if (contactsActionType == null) {
            Intrinsics.m26844a("contactsActionType");
        }
        if (contactsActionType instanceof CREATE) {
            com.sendbird.android.User k = SendBird.m25001k();
            if (k == null) {
                str = this.f29715g;
                if (str == null) {
                    Intrinsics.m26844a("view");
                }
                String f = Util.m24027f((int) C1761R.string.chat_error_create_chat);
                Intrinsics.m26843a((Object) f, "Util.getString(R.string.chat_error_create_chat)");
                str.mo7524a(f);
                return;
            }
            View view = this.f29715g;
            if (view == null) {
                Intrinsics.m26844a("view");
            }
            view.mo7535d();
            List a = CollectionsKt___CollectionsKt.m41419a((Collection) CollectionsKt___CollectionsKt.m41449n(this.f29717i), (Object) new User(k.m25021d(), k.m25022e(), k.m25023f()));
            CompositeDisposable compositeDisposable = this.f29721m;
            ChatDataRepositoryContract chatDataRepositoryContract = this.f29709a;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            if (str == null) {
                str = null;
            } else if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            } else {
                str = StringsKt__StringsKt.m42456b((CharSequence) str).toString();
            }
            Object subscribe = chatDataRepositoryContract.mo4514a(a, str).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).doAfterTerminate(new ContactsPresenter$create$1(this)).subscribe(new ContactsPresenter$create$2(this, a), new ContactsPresenter$create$3(this));
            Intrinsics.m26843a(subscribe, "chatDataRepository.creat…eInviteButton()\n        }");
            DisposableKt.m26766a(compositeDisposable, subscribe);
            return;
        }
        if ((contactsActionType instanceof ADD) != null) {
            str = this.f29715g;
            if (str == null) {
                Intrinsics.m26844a("view");
            }
            contactsActionType = this.f29716h;
            if (contactsActionType == null) {
                Intrinsics.m26844a("contactsActionType");
            }
            if (contactsActionType == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.social.presentation.contacts.view.ContactsActionType.ADD");
            }
            str.mo7536d(((ADD) contactsActionType).f29726a);
        }
    }

    public final void mo5149e(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        View view = this.f29715g;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7535d();
        List n = CollectionsKt___CollectionsKt.m41449n(this.f29717i);
        CompositeDisposable compositeDisposable = this.f29721m;
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29709a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Object subscribe = chatDataRepositoryContract.mo4512a(str, n).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new ContactsPresenter$inviteToChannel$1(this, n, str), (Consumer) new ContactsPresenter$inviteToChannel$2(this));
        Intrinsics.m26843a(subscribe, "chatDataRepository.invit…eInviteButton()\n        }");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }

    public final void mo5138a(String str, String str2) {
        Intrinsics.m26847b(str, "str");
        Intrinsics.m26847b(str2, "prefix");
        str = m30718b((CharSequence) str, str2);
        if (TextUtils.isEmpty(str) != null) {
            str = this.f29715g;
            if (str == null) {
                Intrinsics.m26844a("view");
            }
            str.mo7528a(this.f29720l);
            return;
        }
        Collection arrayList = new ArrayList();
        str2 = ((Iterable) this.f29720l).iterator();
        while (true) {
            boolean z = true;
            if (!str2.hasNext()) {
                break;
            }
            Object next = str2.next();
            if (StringsKt__StringsJVMKt.m41949b(((ContactData) next).f29927a, str, true)) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (m30728g(str) == null) {
            Object obj;
            str2 = StringsKt__StringsJVMKt.m41946a(str, SessionUtil.m23899e(), true);
            Iterable<UserData> iterable = this.f29718j;
            Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (UserData userData : iterable) {
                arrayList2.add(userData.f22465b);
            }
            Iterable<String> iterable2 = (List) arrayList2;
            if (!((iterable2 instanceof Collection) && ((Collection) iterable2).isEmpty())) {
                for (String a : iterable2) {
                    if (StringsKt__StringsJVMKt.m41946a(a, str, true)) {
                        break;
                    }
                }
            }
            z = false;
            if (str2 != null) {
                obj = UserStatus.f22471a;
            } else if (z) {
                obj = UserStatus.f22473c;
            } else {
                obj = UserStatus.f22477g;
            }
            list = CollectionsKt___CollectionsKt.m41419a((Collection) list, (Object) new ContactData(str, null, null, (UserStatus) obj, null, null, null, (int) JpegConst.APP8));
            if (Intrinsics.m26845a(obj, UserStatus.f22477g) != null) {
                str2 = this.f29721m;
                ChatDataRepositoryContract chatDataRepositoryContract = this.f29709a;
                if (chatDataRepositoryContract == null) {
                    Intrinsics.m26844a("chatDataRepository");
                }
                Object subscribe = chatDataRepositoryContract.mo4547r(str).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new ContactsPresenter$verifyUser$1(this, str), new ContactsPresenter$verifyUser$2(this, str));
                Intrinsics.m26843a(subscribe, "chatDataRepository.getUs…EARCH, members)\n        }");
                DisposableKt.m26766a(str2, subscribe);
            }
        }
        str = this.f29715g;
        if (str == null) {
            Intrinsics.m26844a("view");
        }
        str.mo7528a(list);
    }

    public final void mo5147d(String str) {
        Intrinsics.m26847b(str, "channelName");
        if (this.f29717i.size() >= 2 && StringsKt__StringsJVMKt.m41943a((CharSequence) str) != null) {
            str = this.f29716h;
            if (str == null) {
                Intrinsics.m26844a("contactsActionType");
            }
            if ((str instanceof CREATE) != null) {
                str = this.f29715g;
                if (str == null) {
                    Intrinsics.m26844a("view");
                }
                str.mo7535d();
                return;
            }
        }
        str = this.f29715g;
        if (str == null) {
            Intrinsics.m26844a("view");
        }
        str.mo7534c();
    }

    public final void mo5141b() {
        if (this.f29710b == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        List h = m30750h();
        ContactsActionType contactsActionType = this.f29716h;
        if (contactsActionType == null) {
            Intrinsics.m26844a("contactsActionType");
        }
        ChatAnalytics.m24466a(h, contactsActionType);
    }

    public final void mo5144c() {
        this.f29721m.mo5626a();
    }

    public final void mo5134a(StateStorageContract stateStorageContract) {
        Intrinsics.m26847b(stateStorageContract, "stateStorage");
        com.sendbird.android.User k = SendBird.m25001k();
        if (k != null) {
            ChatDataRepositoryContract chatDataRepositoryContract = this.f29709a;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            Object d = k.m25021d();
            Intrinsics.m26843a(d, "it.userId");
            chatDataRepositoryContract.mo4550u(d);
        }
        String str = this.f29722n;
        if (str != null) {
            stateStorageContract.mo4475a(this.f29712d, (CharSequence) str);
        }
        str = this.f29723o;
        if (str != null) {
            stateStorageContract.mo4475a(this.f29713e, (CharSequence) str);
        }
        stateStorageContract.mo4476a(this.f29711c, new ArrayList(this.f29717i));
    }

    public final void mo5142b(StateStorageContract stateStorageContract) {
        Intrinsics.m26847b(stateStorageContract, "stateStorage");
        this.f29722n = stateStorageContract.mo4477b(this.f29712d);
        this.f29723o = stateStorageContract.mo4477b(this.f29713e);
        stateStorageContract = stateStorageContract.mo4478c(this.f29711c);
        if (stateStorageContract == null) {
            return;
        }
        if (stateStorageContract == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.reddit.datalibrary.social.model.User> /* = java.util.ArrayList<com.reddit.datalibrary.social.model.User> */");
        }
        this.f29717i = CollectionsKt___CollectionsKt.m41451p((Iterable) stateStorageContract);
    }

    public final void mo5136a(ContactData contactData) {
        Intrinsics.m26847b(contactData, "contactData");
        switch (WhenMappings.f22343a[contactData.f29931e.ordinal()]) {
            case 1:
            case 2:
                if (contactData.f29930d || m30729i() > 0) {
                    Intrinsics.m26847b(contactData, "contactData");
                    contactData.f29930d ^= true;
                    if (contactData.f29930d) {
                        m30717a(contactData, true);
                        return;
                    }
                    m30721b(contactData, true);
                }
                return;
            case 3:
                contactData.m30886a(UserStatus.f22475e);
                View view = this.f29715g;
                if (view == null) {
                    Intrinsics.m26844a("view");
                }
                view.mo7525a(contactData.f29927a, UserStatus.f22475e);
                return;
            case 4:
            case 5:
            case 6:
            case 7:
                return;
            default:
                return;
        }
    }

    public static final /* synthetic */ void m30716a(ContactsPresenter contactsPresenter, boolean z) {
        View view = contactsPresenter.f29715g;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7529a(z);
        if (z) {
            contactsPresenter.m30730j();
        }
    }
}
