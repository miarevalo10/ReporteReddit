package com.reddit.social.presentation.contacts;

import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.social.presentation.contacts.view.ContactsActionType;
import com.reddit.social.presentation.presentationobjects.ContactData;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.reddit.social.presentation.presentationobjects.UserStatus;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/social/presentation/contacts/ContactsContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ContactsContract.kt */
public interface ContactsContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000bH&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000bH&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0017H&J\b\u0010\u0019\u001a\u00020\tH&J\b\u0010\u001a\u001a\u00020\u000bH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u000bH&J<\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u000bH&J\b\u0010)\u001a\u00020\u0003H&J\u0012\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u000bH&J\b\u0010,\u001a\u00020\u0003H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H&J\u0010\u00100\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H&J\u0010\u00101\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&¨\u00062"}, d2 = {"Lcom/reddit/social/presentation/contacts/ContactsContract$Presenter;", "", "attachView", "", "view", "Lcom/reddit/social/presentation/contacts/ContactsContract$View;", "canAddTokenByEnter", "", "text", "", "prefix", "", "changeContactSelection", "contactData", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "close", "contactAdded", "contactName", "contactRemoved", "detach", "filter", "str", "getContactsCountLeft", "", "getContactsCountLimit", "getSubTitle", "getTitle", "groupNameTextChanged", "s", "init", "title", "url", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "type", "Lcom/reddit/social/presentation/contacts/view/ContactsActionType;", "members", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "inviteToChannel", "channelUrl", "loadContacts", "onClickInviteButton", "channelName", "refresh", "restore", "stateStorage", "Lcom/reddit/datalibrary/social/data/common/StateStorageContract;", "save", "userClicked", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ContactsContract.kt */
    public interface Presenter {
        void mo5133a();

        void mo5134a(StateStorageContract stateStorageContract);

        void mo5135a(View view);

        void mo5136a(ContactData contactData);

        void mo5137a(String str);

        void mo5138a(String str, String str2);

        void mo5139a(String str, String str2, Link link, ContactsActionType contactsActionType, Set<UserData> set);

        boolean mo5140a(CharSequence charSequence, String str);

        void mo5141b();

        void mo5142b(StateStorageContract stateStorageContract);

        void mo5143b(String str);

        void mo5144c();

        void mo5145c(String str);

        String mo5146d();

        void mo5147d(String str);

        CharSequence mo5148e();

        void mo5149e(String str);

        int mo5150f();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0010\u001a\u00020\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u0012H&J\u0016\u0010\u0013\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0005H&J\b\u0010\u001f\u001a\u00020\u0003H&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0005H&J.\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010&H&J\b\u0010'\u001a\u00020\u0003H&J\b\u0010(\u001a\u00020\u0003H&¨\u0006)"}, d2 = {"Lcom/reddit/social/presentation/contacts/ContactsContract$View;", "", "addContactToken", "", "contact", "", "clearContacts", "closeScreen", "disableInviteButton", "enableInviteButton", "hideGroupName", "networkConnectionChange", "hasNetworkConnection", "", "removeContactToken", "removeSelectedContact", "setButtonText", "textRes", "", "setContacts", "contacts", "", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "setUnknownUserExistentStatus", "name", "id", "setUnknownUserStatus", "status", "Lcom/reddit/social/presentation/presentationobjects/UserStatus;", "showErrorMessage", "message", "showGroupName", "showInviteToChannelDialog", "channelUrl", "toGroupMessaging", "shareTitle", "shareUrl", "shareLink", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "updateData", "updateToolbar", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ContactsContract.kt */
    public interface View {
        void mo7521a();

        void mo7522a(int i);

        void mo7524a(String str);

        void mo7525a(String str, UserStatus userStatus);

        void mo7526a(String str, String str2);

        void mo7527a(String str, String str2, String str3, Link link);

        void mo7528a(List<ContactData> list);

        void mo7529a(boolean z);

        void ap_();

        void mo7531b();

        void mo7533b(String str);

        void mo7534c();

        void mo7241c(String str);

        void mo7535d();

        void mo7536d(String str);

        void mo7537e();

        void mo7538f();

        void mo7539g();
    }
}
