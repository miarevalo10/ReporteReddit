package com.reddit.social.presentation.chatrequests;

import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.sendbird.android.GroupChannel;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/social/presentation/chatrequests/ChatRequestContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatRequestContract.kt */
public interface ChatRequestContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\tH&J\b\u0010\u0013\u001a\u00020\tH&J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H&J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/reddit/social/presentation/chatrequests/ChatRequestContract$Presenter;", "", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "accept", "", "neverSeenNsfwDialog", "", "acceptInvite", "attachView", "view", "Lcom/reddit/social/presentation/chatrequests/ChatRequestContract$View;", "blockUser", "userId", "decline", "detachView", "reportUser", "Lio/reactivex/Observable;", "userName", "reason", "restore", "stateStorage", "Lcom/reddit/datalibrary/social/data/common/StateStorageContract;", "save", "viewProfile", "userData", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatRequestContract.kt */
    public interface Presenter {
        Observable<Object> mo5122a(String str, String str2, String str3);

        void mo5123a();

        void mo5124a(StateStorageContract stateStorageContract);

        void mo5125a(View view);

        void mo5126a(UserData userData);

        void mo5127a(String str);

        void mo5128a(boolean z);

        void mo5129b();

        void mo5130b(StateStorageContract stateStorageContract);

        void mo5131b(String str);

        void mo5132c();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0017\u001a\u00020\u0003H&J\u0012\u0010\u0018\u001a\u00020\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J\u001e\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\"H&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H&J\b\u0010$\u001a\u00020\u0003H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&¨\u0006&"}, d2 = {"Lcom/reddit/social/presentation/chatrequests/ChatRequestContract$View;", "", "allowConfirmed", "", "url", "", "title", "blockInviter", "blockMember", "userId", "closeScreen", "declineConfirmed", "disableButtons", "enableButtons", "networkConnectionChange", "hasNetworkConnection", "", "setHeader", "header", "setRequestMessage", "message", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "setScreenTitle", "showBlockerInfo", "showErrorMessage", "messageRes", "", "showInviter", "userData", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "showMembers", "channel", "Lcom/sendbird/android/GroupChannel;", "members", "", "showMessage", "showNsfwDialog", "showRequestInfo", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatRequestContract.kt */
    public interface View {
        void mo7505a();

        void mo7506a(int i);

        void mo7507a(HasMessageData hasMessageData);

        void mo7508a(UserData userData);

        void mo7509a(GroupChannel groupChannel);

        void mo7510a(GroupChannel groupChannel, List<UserData> list);

        void mo7511a(String str);

        void mo7512a(boolean z);

        void mo7513b();

        void mo7514b(String str);

        void mo7515c();

        void mo7241c(String str);

        void mo7516d();

        void mo7517d(String str);

        void mo7518e();

        void mo7519f();

        void mo7520g();
    }
}
