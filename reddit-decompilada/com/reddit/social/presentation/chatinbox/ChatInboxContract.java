package com.reddit.social.presentation.chatinbox;

import com.reddit.datalibrary.social.data.common.StateStorageContract;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/social/presentation/chatinbox/ChatInboxContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatInboxContract.kt */
public interface ChatInboxContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/reddit/social/presentation/chatinbox/ChatInboxContract$Presenter;", "", "loadMore", "", "onCreateView", "view", "Lcom/reddit/social/presentation/chatinbox/ChatInboxContract$View;", "onDestroyView", "refresh", "restore", "stateStorage", "Lcom/reddit/datalibrary/social/data/common/StateStorageContract;", "save", "splashStartClicked", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatInboxContract.kt */
    public interface Presenter {
        void mo5106a();

        void mo5107a(StateStorageContract stateStorageContract);

        void mo5108a(View view);

        void mo5109b();

        void mo5110b(StateStorageContract stateStorageContract);

        void mo5111c();

        void mo5112d();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J \u0010\b\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0003H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&¨\u0006\u0015"}, d2 = {"Lcom/reddit/social/presentation/chatinbox/ChatInboxContract$View;", "", "hideLoadingMore", "", "isShowingSplash", "", "networkConnectionChange", "hasNetworkConnection", "renderConversations", "conversations", "", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "updateViewStateOnErrorOrEmpty", "showContentScreen", "showErrorMessage", "message", "", "showInbox", "showLoading", "showLoadingMore", "showSplashScreen", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatInboxContract.kt */
    public interface View {
        void mo7491a();

        void mo7492a(List<ChatInboxItem> list, boolean z);

        void mo7493a(boolean z);

        boolean an_();

        void mo7495b();

        void mo7496c();

        void mo7497d();

        void mo7498e();

        void mo7499f();
    }
}
