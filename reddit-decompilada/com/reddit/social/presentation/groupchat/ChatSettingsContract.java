package com.reddit.social.presentation.groupchat;

import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.social.presentation.presentationobjects.ContactData;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.Observable;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/social/presentation/groupchat/ChatSettingsContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatSettingsContract.kt */
public interface ChatSettingsContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\tH&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0006H&J&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\tH&J\b\u0010\u001f\u001a\u00020\u0003H&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H&J\b\u0010#\u001a\u00020\u0003H&¨\u0006$"}, d2 = {"Lcom/reddit/social/presentation/groupchat/ChatSettingsContract$Presenter;", "", "addToGroupClicked", "", "blockUser", "userId", "", "groupNameFocusChanged", "hasFocus", "", "init", "channelUrl", "leaveGroup", "load", "refresh", "membersCountClicked", "renameChannel", "name", "reportUser", "Lio/reactivex/Observable;", "userName", "reason", "requestLeaveGroup", "requestStartGroupChat", "requestUserBlock", "restore", "stateStorage", "Lcom/reddit/datalibrary/social/data/common/StateStorageContract;", "save", "setChannelMuted", "mute", "viewAttached", "viewCreated", "view", "Lcom/reddit/social/presentation/groupchat/ChatSettingsContract$View;", "viewDestroyed", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatSettingsContract.kt */
    public interface Presenter {
        Observable<Object> mo5178a(String str, String str2, String str3);

        void mo5179a();

        void mo5180a(StateStorageContract stateStorageContract);

        void mo5181a(View view);

        void mo5182a(String str);

        void mo5183a(String str, String str2);

        void mo5184a(boolean z);

        void mo5185b();

        void mo5186b(StateStorageContract stateStorageContract);

        void mo5187b(String str);

        void mo5188b(boolean z);

        void mo5189c();

        void mo5190c(String str);

        void mo5191c(boolean z);

        void mo5192d();

        void mo5193e();

        void mo5194f();

        void mo5195g();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u001e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&J\u001e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000eH&J\b\u0010\u0018\u001a\u00020\u0003H&J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u001b\u001a\u00020\u0003H&J\u0016\u0010\u001c\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0005H&J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u0003H&J\b\u0010$\u001a\u00020\u0003H&J\b\u0010%\u001a\u00020\u0003H&J\u0012\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010(H&¨\u0006)"}, d2 = {"Lcom/reddit/social/presentation/groupchat/ChatSettingsContract$View;", "", "confirmBlockUser", "", "userId", "", "username", "confirmLeaveGroup", "defocusGroupName", "disableChannelMuteToggle", "hideSaveButton", "navigateToChatInbox", "networkConnectionChange", "hasNetworkConnection", "", "openContactsScreen", "channelUrl", "members", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "openGroupMembersScreen", "", "setChannelMuted", "muted", "showAddToGroupButton", "showGroupName", "name", "showLeaveButton", "showMembers", "showMembersCount", "count", "", "showMessage", "message", "showNotificationsEnabled", "showNotificationsNotEnabled", "showSaveButton", "showStartGroupChatButton", "startGroupChat", "member", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatSettingsContract.kt */
    public interface View {
        void mo7570a();

        void mo7571a(int i);

        void mo7572a(ContactData contactData);

        void mo7573a(String str);

        void mo7574a(String str, String str2);

        void mo7575a(String str, List<UserData> list);

        void mo7576a(String str, Set<UserData> set);

        void mo7577a(List<UserData> list);

        void mo7578a(boolean z);

        void ar_();

        void as_();

        void mo7581b();

        void mo7582b(String str);

        void b_(boolean z);

        void mo7584c();

        void mo7585d();

        void mo7586e();

        void mo7587f();

        void mo7588g();

        void mo7589h();

        void mo7590i();
    }
}
