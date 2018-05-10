package com.reddit.social.presentation.chatrequests;

import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/social/presentation/chatrequests/ChatRequestListContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatRequestListContract.kt */
public interface ChatRequestListContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/reddit/social/presentation/chatrequests/ChatRequestListContract$Presenter;", "", "attachView", "", "view", "Lcom/reddit/social/presentation/chatrequests/ChatRequestListContract$View;", "detach", "loadMore", "refresh", "restore", "stateStorage", "Lcom/reddit/datalibrary/social/data/common/StateStorageContract;", "save", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatRequestListContract.kt */
    public interface Presenter {
        void mo5116a();

        void mo5117a(StateStorageContract stateStorageContract);

        void mo5118a(View view);

        void mo5119b();

        void mo5120b(StateStorageContract stateStorageContract);

        void mo5121c();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/reddit/social/presentation/chatrequests/ChatRequestListContract$View;", "", "networkConnectionChange", "", "hasNetworkConnection", "", "showChatRequests", "chatRequests", "", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "showErrorMessage", "message", "", "showLoadingMore", "showRefreshing", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatRequestListContract.kt */
    public interface View {
        void mo7500a();

        void mo7501a(String str);

        void mo7502a(List<ChatInboxItem> list);

        void mo7503a(boolean z);

        void mo7504b();
    }
}
