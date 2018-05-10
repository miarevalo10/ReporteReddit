package com.reddit.social.presentation.groupchat;

import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.social.presentation.presentationobjects.UserData;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/social/presentation/groupchat/GroupMembersContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GroupMembersContract.kt */
public interface GroupMembersContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0017"}, d2 = {"Lcom/reddit/social/presentation/groupchat/GroupMembersContract$Presenter;", "", "attachView", "", "view", "Lcom/reddit/social/presentation/groupchat/GroupMembersContract$View;", "blockUser", "userId", "", "detach", "init", "channelUrl", "members", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "reportUser", "userName", "reason", "requestUserBlock", "restore", "stateStorage", "Lcom/reddit/datalibrary/social/data/common/StateStorageContract;", "save", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GroupMembersContract.kt */
    public interface Presenter {
        void mo5151a();

        void mo5152a(StateStorageContract stateStorageContract);

        void mo5153a(View view);

        void mo5154a(String str);

        void mo5155a(String str, String str2);

        void mo5156a(String str, String str2, String str3);

        void mo5157a(String str, List<UserData> list);

        void mo5158b(StateStorageContract stateStorageContract);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H&¨\u0006\u0015"}, d2 = {"Lcom/reddit/social/presentation/groupchat/GroupMembersContract$View;", "", "blockMember", "", "userId", "", "confirmBlockUser", "username", "networkConnectionChange", "hasNetworkConnection", "", "reportUserError", "error", "", "reportUserSuccess", "setMembers", "members", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "showMessage", "message", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GroupMembersContract.kt */
    public interface View {
        void mo7540a();

        void mo7541a(String str);

        void mo7542a(String str, String str2);

        void mo7543a(Throwable th);

        void mo7544a(List<UserData> list);

        void mo7545a(boolean z);

        void mo7546b(String str);
    }
}
