package com.reddit.social.presentation.contacts.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.social.data.common.StateStorageBundle;
import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.ui.tokenautocomplete.TokenCompleteTextView.TokenListener;
import com.reddit.frontpage.util.BundlerSetParcelable;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.social.presentation.EditTextWithCounter;
import com.reddit.social.presentation.contacts.ContactsContract.Presenter;
import com.reddit.social.presentation.contacts.ContactsContract.View;
import com.reddit.social.presentation.presentationobjects.ContactData;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.reddit.social.presentation.presentationobjects.UserStatus;
import com.reddit.social.util.BundlerContactsActionType;
import com.reddit.social.util.ChatUtilKt;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  \u00012\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002 \u0001B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u0004H\u0016J\b\u0010`\u001a\u00020^H\u0016J\b\u0010a\u001a\u00020^H\u0016J\u0010\u0010b\u001a\u00020^2\u0006\u0010c\u001a\u00020dH\u0014J\b\u0010e\u001a\u00020^H\u0016J\b\u0010f\u001a\u00020^H\u0016J\b\u0010g\u001a\u00020\u0004H\u0016J\b\u0010h\u001a\u00020iH\u0016J\b\u0010j\u001a\u00020iH\u0016J\b\u0010k\u001a\u00020^H\u0016J\u0010\u0010l\u001a\u00020^2\u0006\u0010m\u001a\u00020nH\u0016J\u0010\u0010o\u001a\u00020^2\u0006\u0010p\u001a\u00020qH\u0014J\b\u0010r\u001a\u00020nH\u0016J\u0018\u0010s\u001a\u00020q2\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020wH\u0016J\u0010\u0010x\u001a\u00020^2\u0006\u0010p\u001a\u00020qH\u0016J\u0010\u0010y\u001a\u00020^2\u0006\u0010p\u001a\u00020qH\u0014J\u0010\u0010z\u001a\u00020n2\u0006\u0010{\u001a\u00020|H\u0016J\u0010\u0010}\u001a\u00020^2\u0006\u0010~\u001a\u00020H\u0014J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020H\u0014J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020\u0004H\u0016J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020\u0004H\u0016J\u0011\u0010\u0001\u001a\u00020^2\u0006\u0010_\u001a\u00020\u0004H\u0016J\u0011\u0010\u0001\u001a\u00020^2\u0006\u0010_\u001a\u00020\u0004H\u0016J\t\u0010\u0001\u001a\u00020^H\u0014J\u0014\u0010\u0001\u001a\u00020^2\t\b\u0001\u0010\u0001\u001a\u00020iH\u0016J\u001a\u0010\u0001\u001a\u00020^2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0016J=\u0010\u0001\u001a\u00020^2\b\u0010R\u001a\u0004\u0018\u00010\u00042\b\u0010Z\u001a\u0004\u0018\u00010\u00042\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\u0007\u001a\u00020\b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0002J\u001b\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u0004H\u0016J\u001c\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020\u0004H\u0016J\t\u0010\u0001\u001a\u00020^H\u0016J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020\u0004H\u0016J3\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010.H\u0016J\t\u0010\u0001\u001a\u00020^H\u0016J\t\u0010\u0001\u001a\u00020^H\u0016R\u000e\u0010\u0006\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010-\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00103\u001a\b\u0012\u0004\u0012\u000205048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u00020;8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001e\u0010@\u001a\u00020;8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R\u001e\u0010C\u001a\u00020D8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001e\u0010I\u001a\u00020J8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001e\u0010O\u001a\u00020;8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010=\"\u0004\bQ\u0010?R \u0010R\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001e\u0010W\u001a\u00020;8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010=\"\u0004\bY\u0010?R \u0010Z\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010T\"\u0004\b\\\u0010V¨\u0006¡\u0001"}, d2 = {"Lcom/reddit/social/presentation/contacts/view/ContactsScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/social/presentation/contacts/ContactsContract$View;", "Lcom/reddit/frontpage/ui/tokenautocomplete/TokenCompleteTextView$TokenListener;", "", "()V", "contactFilterRegex", "contactsActionType", "Lcom/reddit/social/presentation/contacts/view/ContactsActionType;", "getContactsActionType", "()Lcom/reddit/social/presentation/contacts/view/ContactsActionType;", "setContactsActionType", "(Lcom/reddit/social/presentation/contacts/view/ContactsActionType;)V", "contactsAdapter", "Lcom/reddit/social/presentation/contacts/view/ContactsAdapter;", "contactsCompletionView", "Lcom/reddit/social/presentation/contacts/view/ContactsCompletionView;", "getContactsCompletionView", "()Lcom/reddit/social/presentation/contacts/view/ContactsCompletionView;", "setContactsCompletionView", "(Lcom/reddit/social/presentation/contacts/view/ContactsCompletionView;)V", "contactsContainer", "Landroid/widget/LinearLayout;", "getContactsContainer", "()Landroid/widget/LinearLayout;", "setContactsContainer", "(Landroid/widget/LinearLayout;)V", "contactsPrefix", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "groupNameContainer", "getGroupNameContainer", "setGroupNameContainer", "groupNameEditText", "Lcom/reddit/social/presentation/EditTextWithCounter;", "getGroupNameEditText", "()Lcom/reddit/social/presentation/EditTextWithCounter;", "setGroupNameEditText", "(Lcom/reddit/social/presentation/EditTextWithCounter;)V", "inviteButton", "Landroid/widget/Button;", "getInviteButton", "()Landroid/widget/Button;", "setInviteButton", "(Landroid/widget/Button;)V", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "getLink", "()Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "setLink", "(Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;)V", "members", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "getMembers", "()Ljava/util/Set;", "setMembers", "(Ljava/util/Set;)V", "noConnectionBanner", "Landroid/widget/TextView;", "getNoConnectionBanner", "()Landroid/widget/TextView;", "setNoConnectionBanner", "(Landroid/widget/TextView;)V", "noContactsView", "getNoContactsView", "setNoContactsView", "presenter", "Lcom/reddit/social/presentation/contacts/ContactsContract$Presenter;", "getPresenter", "()Lcom/reddit/social/presentation/contacts/ContactsContract$Presenter;", "setPresenter", "(Lcom/reddit/social/presentation/contacts/ContactsContract$Presenter;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "subtitleTextView", "getSubtitleTextView", "setSubtitleTextView", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleTextView", "getTitleTextView", "setTitleTextView", "url", "getUrl", "setUrl", "addContactToken", "", "contact", "clearContacts", "closeScreen", "configureActionBar", "actionBar", "Landroid/support/v7/app/ActionBar;", "disableInviteButton", "enableInviteButton", "getAnalyticsScreenName", "getDefaultScreenPosition", "", "getLayoutId", "hideGroupName", "networkConnectionChange", "hasNetworkConnection", "", "onAttach", "view", "Landroid/view/View;", "onBackPressed", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDetach", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRestoreInstanceState", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onTokenAdded", "token", "onTokenRemoved", "removeContactToken", "removeSelectedContact", "sendScreenViewEvent", "setButtonText", "textRes", "setContacts", "contacts", "", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "setState", "setUnknownUserExistentStatus", "name", "id", "setUnknownUserStatus", "status", "Lcom/reddit/social/presentation/presentationobjects/UserStatus;", "showErrorMessage", "message", "showGroupName", "showInviteToChannelDialog", "channelUrl", "toGroupMessaging", "shareTitle", "shareUrl", "shareLink", "updateData", "updateToolbar", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ContactsScreen.kt */
public final class ContactsScreen extends MvpBaseScreen implements TokenListener<String>, View {
    public static final Companion f40201w = new Companion();
    private CompositeDisposable f40202A;
    @State(BundlerContactsActionType.class)
    public ContactsActionType contactsActionType;
    @BindView
    public ContactsCompletionView contactsCompletionView;
    @BindView
    public LinearLayout contactsContainer;
    @BindView
    public LinearLayout groupNameContainer;
    @BindView
    public EditTextWithCounter groupNameEditText;
    @BindView
    public Button inviteButton;
    @State
    Link link;
    @State(BundlerSetParcelable.class)
    public Set<UserData> members;
    @BindView
    public TextView noConnectionBanner;
    @BindView
    public TextView noContactsView;
    @BindView
    public RecyclerView recyclerView;
    @BindView
    public TextView subtitleTextView;
    @State
    String title = "";
    @BindView
    public TextView titleTextView;
    @State
    String url = "";
    @Inject
    public Presenter f40203v;
    private ContactsAdapter f40204x;
    private String f40205y;
    private String f40206z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ:\u0010\u0003\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¨\u0006\u000f"}, d2 = {"Lcom/reddit/social/presentation/contacts/view/ContactsScreen$Companion;", "", "()V", "newInstance", "Lcom/reddit/social/presentation/contacts/view/ContactsScreen;", "contactsActionType", "Lcom/reddit/social/presentation/contacts/view/ContactsActionType;", "members", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "title", "", "url", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ContactsScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ContactsScreen m24597a(ContactsActionType contactsActionType, Set<UserData> set) {
            Intrinsics.m26847b(contactsActionType, "contactsActionType");
            Intrinsics.m26847b(set, "members");
            ContactsScreen contactsScreen = new ContactsScreen();
            ContactsScreen.m41235a(contactsScreen, contactsActionType, set);
            return contactsScreen;
        }
    }

    protected final void E_() {
    }

    public final String getAnalyticsScreenName() {
        return "chat_contacts";
    }

    public final int mo7141s() {
        return C1761R.layout.screen_contacts;
    }

    public final int mo7143u() {
        return 2;
    }

    public ContactsScreen() {
        super();
        FrontpageApplication.m28878n().mo5093a(this);
    }

    public static final /* synthetic */ String m41234a(ContactsScreen contactsScreen) {
        contactsScreen = contactsScreen.f40206z;
        if (contactsScreen == null) {
            Intrinsics.m26844a("contactFilterRegex");
        }
        return contactsScreen;
    }

    public final /* synthetic */ void mo7523a(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "token");
        Presenter presenter = this.f40203v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5137a(str);
    }

    public final /* synthetic */ void mo7532b(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "token");
        Presenter presenter = this.f40203v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5143b(str);
    }

    public final Presenter m41266w() {
        Presenter presenter = this.f40203v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return presenter;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View mo7139a(android.view.LayoutInflater r7, android.view.ViewGroup r8) {
        /*
        r6 = this;
        r0 = "inflater";
        kotlin.jvm.internal.Intrinsics.m26847b(r7, r0);
        r0 = "container";
        kotlin.jvm.internal.Intrinsics.m26847b(r8, r0);
        super.mo7139a(r7, r8);
        r7 = new io.reactivex.disposables.CompositeDisposable;
        r7.<init>();
        r6.f40202A = r7;
        r7 = 2131887095; // 0x7f1203f7 float:1.9408787E38 double:1.0532921745E-314;
        r7 = com.reddit.frontpage.util.Util.m24027f(r7);
        r8 = "Util.getString(R.string.…ontacts_edit_text_prefix)";
        kotlin.jvm.internal.Intrinsics.m26843a(r7, r8);
        r6.f40205y = r7;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = r6.f40205y;
        if (r8 != 0) goto L_0x0030;
    L_0x002b:
        r0 = "contactsPrefix";
        kotlin.jvm.internal.Intrinsics.m26844a(r0);
    L_0x0030:
        r7.append(r8);
        r8 = "*";
        r7.append(r8);
        r7 = r7.toString();
        r6.f40206z = r7;
        r7 = io.reactivex.subjects.PublishSubject.create();
        r8 = new com.reddit.social.presentation.contacts.view.ContactsAdapter;
        r0 = "clickSubject";
        kotlin.jvm.internal.Intrinsics.m26843a(r7, r0);
        r8.<init>(r7);
        r6.f40204x = r8;
        r8 = r6.f40202A;
        if (r8 != 0) goto L_0x0057;
    L_0x0052:
        r0 = "disposables";
        kotlin.jvm.internal.Intrinsics.m26844a(r0);
    L_0x0057:
        r7 = (io.reactivex.Observable) r7;
        r0 = new com.reddit.social.presentation.contacts.view.ContactsScreen$onCreateView$1;
        r0.<init>(r6);
        r0 = (kotlin.jvm.functions.Function1) r0;
        r7 = com.reddit.frontpage.util.kotlin.ObservablesKt.m24091a(r7, r0);
        io.reactivex.rxkotlin.DisposableKt.m26766a(r8, r7);
        r7 = r6.recyclerView;
        if (r7 != 0) goto L_0x0070;
    L_0x006b:
        r8 = "recyclerView";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x0070:
        r8 = new android.support.v7.widget.LinearLayoutManager;
        r0 = r6.am_();
        r0 = (android.content.Context) r0;
        r1 = 1;
        r2 = 0;
        r8.<init>(r0, r1, r2);
        r8 = (android.support.v7.widget.RecyclerView.LayoutManager) r8;
        r7.setLayoutManager(r8);
        r7 = r6.recyclerView;
        if (r7 != 0) goto L_0x008b;
    L_0x0086:
        r8 = "recyclerView";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x008b:
        r8 = r6.f40204x;
        if (r8 != 0) goto L_0x0094;
    L_0x008f:
        r0 = "contactsAdapter";
        kotlin.jvm.internal.Intrinsics.m26844a(r0);
    L_0x0094:
        r8 = (android.support.v7.widget.RecyclerView.Adapter) r8;
        r7.setAdapter(r8);
        r6.mo7535d();
        r7 = r6.inviteButton;
        if (r7 != 0) goto L_0x00a5;
    L_0x00a0:
        r8 = "inviteButton";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x00a5:
        r8 = new com.reddit.social.presentation.contacts.view.ContactsScreen$onCreateView$2;
        r8.<init>(r6);
        r8 = (android.view.View.OnClickListener) r8;
        r7.setOnClickListener(r8);
        r7 = r6.contactsCompletionView;
        if (r7 != 0) goto L_0x00b8;
    L_0x00b3:
        r8 = "contactsCompletionView";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x00b8:
        r8 = r6.f40203v;
        if (r8 != 0) goto L_0x00c1;
    L_0x00bc:
        r0 = "presenter";
        kotlin.jvm.internal.Intrinsics.m26844a(r0);
    L_0x00c1:
        r8 = r8.mo5150f();
        r7.setTokenLimit(r8);
        r7 = r6.contactsCompletionView;
        if (r7 != 0) goto L_0x00d1;
    L_0x00cc:
        r8 = "contactsCompletionView";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x00d1:
        r8 = r6;
        r8 = (com.reddit.frontpage.ui.tokenautocomplete.TokenCompleteTextView.TokenListener) r8;
        r7.setTokenListener(r8);
        r7 = r6.contactsCompletionView;
        if (r7 != 0) goto L_0x00e0;
    L_0x00db:
        r8 = "contactsCompletionView";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x00e0:
        r8 = com.reddit.frontpage.ui.tokenautocomplete.TokenCompleteTextView.TokenClickStyle.Select;
        r7.setTokenClickStyle(r8);
        r7 = r6.contactsCompletionView;
        if (r7 != 0) goto L_0x00ee;
    L_0x00e9:
        r8 = "contactsCompletionView";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x00ee:
        r8 = r6.f40205y;
        if (r8 != 0) goto L_0x00f7;
    L_0x00f2:
        r0 = "contactsPrefix";
        kotlin.jvm.internal.Intrinsics.m26844a(r0);
    L_0x00f7:
        r8 = (java.lang.CharSequence) r8;
        r7.setPrefix(r8);
        r7 = r6.contactsCompletionView;
        if (r7 != 0) goto L_0x0105;
    L_0x0100:
        r8 = "contactsCompletionView";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x0105:
        r7.setAllowDuplicates(r2);
        r7 = r6.contactsCompletionView;
        if (r7 != 0) goto L_0x0111;
    L_0x010c:
        r8 = "contactsCompletionView";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x0111:
        r8 = 3;
        r8 = new char[r8];
        r8 = {44, 59, 32};
        r7.setSplitChar(r8);
        r7 = r6.contactsCompletionView;
        if (r7 != 0) goto L_0x0123;
    L_0x011e:
        r8 = "contactsCompletionView";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x0123:
        r8 = 0;
        r7.setAdapter(r8);
        r7 = r6.contactsCompletionView;
        if (r7 != 0) goto L_0x0130;
    L_0x012b:
        r8 = "contactsCompletionView";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x0130:
        r7.setDropDownHeight(r2);
        r7 = r6.contactsCompletionView;
        if (r7 != 0) goto L_0x013c;
    L_0x0137:
        r8 = "contactsCompletionView";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x013c:
        r8 = new com.reddit.social.presentation.contacts.view.ContactsScreen$onCreateView$3;
        r8.<init>(r6);
        r8 = (android.widget.TextView.OnEditorActionListener) r8;
        r7.setOnEditorActionListener(r8);
        r7 = r6.contactsCompletionView;
        if (r7 != 0) goto L_0x014f;
    L_0x014a:
        r8 = "contactsCompletionView";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x014f:
        r8 = new com.reddit.social.presentation.contacts.view.ContactsScreen$onCreateView$4;
        r8.<init>();
        r8 = (android.view.ActionMode.Callback) r8;
        r7.setCustomSelectionActionModeCallback(r8);
        r7 = r6.f40202A;
        if (r7 != 0) goto L_0x0162;
    L_0x015d:
        r8 = "disposables";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x0162:
        r8 = r6.contactsCompletionView;
        if (r8 != 0) goto L_0x016b;
    L_0x0166:
        r0 = "contactsCompletionView";
        kotlin.jvm.internal.Intrinsics.m26844a(r0);
    L_0x016b:
        r8 = (android.widget.TextView) r8;
        r8 = com.jakewharton.rxbinding2.widget.RxTextView.a(r8);
        r0 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r8 = r8.debounce(r0, r2);
        r0 = com.reddit.frontpage.util.SchedulerProvider.m23887c();
        r8 = r8.observeOn(r0);
        r0 = new com.reddit.social.presentation.contacts.view.ContactsScreen$onCreateView$5;
        r0.<init>(r6);
        r0 = (io.reactivex.functions.Consumer) r0;
        r8 = r8.subscribe(r0);
        r0 = "RxTextView.textChanges(c…actFilterRegex)\n        }";
        kotlin.jvm.internal.Intrinsics.m26843a(r8, r0);
        io.reactivex.rxkotlin.DisposableKt.m26766a(r7, r8);
        r7 = r6.groupNameEditText;
        if (r7 != 0) goto L_0x019d;
    L_0x0198:
        r8 = "groupNameEditText";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x019d:
        r7 = r7.getEditText();
        r7 = (android.widget.TextView) r7;
        r8 = new com.reddit.social.presentation.contacts.view.ContactsScreen$onCreateView$6;
        r8.<init>(r6);
        r8 = (kotlin.jvm.functions.Function1) r8;
        org.jetbrains.anko.sdk21.listeners.Sdk21ListenersListenersKt.m28425a(r7, r8);
        r0 = r6.f40203v;
        if (r0 != 0) goto L_0x01b6;
    L_0x01b1:
        r7 = "presenter";
        kotlin.jvm.internal.Intrinsics.m26844a(r7);
    L_0x01b6:
        r1 = r6.title;
        r2 = r6.url;
        r3 = r6.link;
        r4 = r6.contactsActionType;
        if (r4 != 0) goto L_0x01c5;
    L_0x01c0:
        r7 = "contactsActionType";
        kotlin.jvm.internal.Intrinsics.m26844a(r7);
    L_0x01c5:
        r5 = r6.members;
        if (r5 != 0) goto L_0x01ce;
    L_0x01c9:
        r7 = "members";
        kotlin.jvm.internal.Intrinsics.m26844a(r7);
    L_0x01ce:
        r0.mo5139a(r1, r2, r3, r4, r5);
        r7 = r6.f40203v;
        if (r7 != 0) goto L_0x01da;
    L_0x01d5:
        r8 = "presenter";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x01da:
        r8 = r6;
        r8 = (com.reddit.social.presentation.contacts.ContactsContract.View) r8;
        r7.mo5135a(r8);
        r7 = r6.f40203v;
        if (r7 != 0) goto L_0x01e9;
    L_0x01e4:
        r8 = "presenter";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x01e9:
        r7.mo5133a();
        r6.mo7521a();
        r7 = r6.contactsContainer;
        if (r7 != 0) goto L_0x01f8;
    L_0x01f3:
        r8 = "contactsContainer";
        kotlin.jvm.internal.Intrinsics.m26844a(r8);
    L_0x01f8:
        r8 = new android.animation.LayoutTransition;
        r8.<init>();
        r0 = 50;
        r8.setDuration(r0);
        r7.setLayoutTransition(r8);
        r7 = r6.K;
        r8 = "rootView";
        kotlin.jvm.internal.Intrinsics.m26843a(r7, r8);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.social.presentation.contacts.view.ContactsScreen.a(android.view.LayoutInflater, android.view.ViewGroup):android.view.View");
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        actionBar.c(false);
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        view = this.contactsCompletionView;
        if (view == null) {
            Intrinsics.m26844a("contactsCompletionView");
        }
        view.requestFocus();
        view = this.contactsCompletionView;
        if (view == null) {
            Intrinsics.m26844a("contactsCompletionView");
        }
        Util.m23999b(view);
    }

    protected final void mo6993c(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        ContactsCompletionView contactsCompletionView = this.contactsCompletionView;
        if (contactsCompletionView == null) {
            Intrinsics.m26844a("contactsCompletionView");
        }
        Util.m23972a((android.view.View) contactsCompletionView);
        super.mo6993c(view);
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return null;
        }
        menuItem = this.f40203v;
        if (menuItem == null) {
            Intrinsics.m26844a("presenter");
        }
        menuItem.mo5141b();
        m29351F();
        return true;
    }

    public final boolean mo6986J() {
        Presenter presenter = this.f40203v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5141b();
        return super.mo6986J();
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        CompositeDisposable compositeDisposable = this.f40202A;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        compositeDisposable.mo5626a();
        Presenter presenter = this.f40203v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5144c();
        super.mo6987a(view);
    }

    protected final void mo6991b(Bundle bundle) {
        Intrinsics.m26847b(bundle, "outState");
        Presenter presenter = this.f40203v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5134a((StateStorageContract) new StateStorageBundle(bundle));
        super.mo6991b(bundle);
    }

    protected final void mo7199c(Bundle bundle) {
        Intrinsics.m26847b(bundle, "savedInstanceState");
        Presenter presenter = this.f40203v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5142b((StateStorageContract) new StateStorageBundle(bundle));
        super.mo7199c(bundle);
    }

    public final void mo7521a() {
        TextView textView = this.titleTextView;
        if (textView == null) {
            Intrinsics.m26844a("titleTextView");
        }
        Presenter presenter = this.f40203v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        textView.setText(presenter.mo5146d());
        if (ChatUtilKt.m24762b()) {
            textView = this.subtitleTextView;
            if (textView == null) {
                Intrinsics.m26844a("subtitleTextView");
            }
            ViewsKt.m24107c(textView);
            textView = this.subtitleTextView;
            if (textView == null) {
                Intrinsics.m26844a("subtitleTextView");
            }
            presenter = this.f40203v;
            if (presenter == null) {
                Intrinsics.m26844a("presenter");
            }
            textView.setText(presenter.mo5148e());
        }
    }

    public final void mo7533b(String str) {
        Intrinsics.m26847b(str, "contact");
        ContactsCompletionView contactsCompletionView = this.contactsCompletionView;
        if (contactsCompletionView == null) {
            Intrinsics.m26844a("contactsCompletionView");
        }
        String completionText = contactsCompletionView.getCompletionText();
        ContactsCompletionView contactsCompletionView2 = this.contactsCompletionView;
        if (contactsCompletionView2 == null) {
            Intrinsics.m26844a("contactsCompletionView");
        }
        contactsCompletionView2.m35273b();
        CharSequence charSequence = completionText;
        if (TextUtils.isEmpty(charSequence)) {
            contactsCompletionView = this.contactsCompletionView;
            if (contactsCompletionView == null) {
                Intrinsics.m26844a("contactsCompletionView");
            }
            contactsCompletionView.m35274b((Object) str);
            return;
        }
        contactsCompletionView2 = this.contactsCompletionView;
        if (contactsCompletionView2 == null) {
            Intrinsics.m26844a("contactsCompletionView");
        }
        contactsCompletionView2.m35270a((Object) str, charSequence);
    }

    public final void mo7241c(String str) {
        Intrinsics.m26847b(str, "contact");
        ContactsCompletionView contactsCompletionView = this.contactsCompletionView;
        if (contactsCompletionView == null) {
            Intrinsics.m26844a("contactsCompletionView");
        }
        contactsCompletionView.m35276c((Object) str);
    }

    public final void mo7525a(String str, UserStatus userStatus) {
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(userStatus, "status");
        ContactsAdapter contactsAdapter = this.f40204x;
        if (contactsAdapter == null) {
            Intrinsics.m26844a("contactsAdapter");
        }
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(userStatus, "status");
        List b = contactsAdapter.m30757b();
        ListIterator listIterator = b.listIterator(b.size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.m26845a(((ContactData) listIterator.previous()).f29927a, (Object) str)) {
                str = listIterator.nextIndex();
                break;
            }
        }
        str = -1;
        if (str != -1) {
            ((ContactData) contactsAdapter.m30757b().get(str)).m30886a(userStatus);
            contactsAdapter.d(str);
        }
    }

    public final void mo7526a(String str, String str2) {
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(str2, "id");
        ContactsAdapter contactsAdapter = this.f40204x;
        if (contactsAdapter == null) {
            Intrinsics.m26844a("contactsAdapter");
        }
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(str2, "id");
        List b = contactsAdapter.m30757b();
        ListIterator listIterator = b.listIterator(b.size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.m26845a(((ContactData) listIterator.previous()).f29927a, (Object) str)) {
                str = listIterator.nextIndex();
                break;
            }
        }
        str = -1;
        if (str != -1) {
            ((ContactData) contactsAdapter.m30757b().get(str)).m30886a(UserStatus.f22474d);
            ((ContactData) contactsAdapter.m30757b().get(str)).f29929c = str2;
            contactsAdapter.d(str);
        }
    }

    public final void mo7535d() {
        Button button = this.inviteButton;
        if (button == null) {
            Intrinsics.m26844a("inviteButton");
        }
        button.setEnabled(false);
    }

    public final void mo7537e() {
        ContactsCompletionView contactsCompletionView = this.contactsCompletionView;
        if (contactsCompletionView == null) {
            Intrinsics.m26844a("contactsCompletionView");
        }
        contactsCompletionView.m35275c();
    }

    public final void mo7534c() {
        Button button = this.inviteButton;
        if (button == null) {
            Intrinsics.m26844a("inviteButton");
        }
        button.setEnabled(true);
    }

    public final void mo7531b() {
        ContactsAdapter contactsAdapter = this.f40204x;
        if (contactsAdapter == null) {
            Intrinsics.m26844a("contactsAdapter");
        }
        contactsAdapter.e();
    }

    public final void mo7528a(List<ContactData> list) {
        Intrinsics.m26847b(list, "contacts");
        ContactsAdapter contactsAdapter = this.f40204x;
        if (contactsAdapter == null) {
            Intrinsics.m26844a("contactsAdapter");
        }
        Intrinsics.m26847b(list, "<set-?>");
        contactsAdapter.f29729b.m30902a(contactsAdapter, ContactsAdapter.f29728a[0], list);
    }

    public final void mo7527a(String str, String str2, String str3, Link link) {
        Intrinsics.m26847b(str, "channelUrl");
        C_().l();
        Routing.m22619a((Context) am_(), Nav.m22558a(str, str2, str3, link));
    }

    public final void mo7524a(String str) {
        Intrinsics.m26847b(str, "message");
        Toast.makeText(am_(), str, 1).show();
    }

    public final void mo7539g() {
        LinearLayout linearLayout = this.groupNameContainer;
        if (linearLayout == null) {
            Intrinsics.m26844a("groupNameContainer");
        }
        ViewsKt.m24107c(linearLayout);
    }

    public final void ap_() {
        LinearLayout linearLayout = this.groupNameContainer;
        if (linearLayout == null) {
            Intrinsics.m26844a("groupNameContainer");
        }
        ViewsKt.m24109d(linearLayout);
    }

    public final void mo7529a(boolean z) {
        TextView textView = this.noConnectionBanner;
        if (textView == null) {
            Intrinsics.m26844a("noConnectionBanner");
        }
        ViewsKt.m24106b(textView, z ^ 1);
    }

    public final void mo7536d(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion companion = RedditAlertDialog.f21112b;
        Object am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23304b((Context) am_, new ContactsScreen$showInviteToChannelDialog$1(this, str)).m23323a();
    }

    public final void mo7538f() {
        m29351F();
    }

    public final void mo7522a(int i) {
        Button button = this.inviteButton;
        if (button == null) {
            Intrinsics.m26844a("inviteButton");
        }
        button.setText(i);
    }

    public static final /* synthetic */ void m41235a(ContactsScreen contactsScreen, ContactsActionType contactsActionType, Set set) {
        contactsScreen.title = null;
        contactsScreen.url = null;
        contactsScreen.link = null;
        contactsScreen.contactsActionType = contactsActionType;
        contactsScreen.members = set;
    }
}
