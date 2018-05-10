package com.reddit.social.presentation.groupchat;

import android.net.Uri;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.datalibrary.social.model.ReportMessage;
import com.reddit.social.domain.functions.MessagesBatch;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/social/presentation/groupchat/ChatContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatContract.kt */
public interface ChatContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&J8\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0003H&J&\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0005H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0005H&J\b\u0010&\u001a\u00020\u0003H&J\b\u0010'\u001a\u00020\u0003H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H&J\b\u0010+\u001a\u00020\u0003H&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.H&¨\u0006/"}, d2 = {"Lcom/reddit/social/presentation/groupchat/ChatContract$Presenter;", "", "deleteMessage", "", "channelUrl", "", "messageId", "", "requestId", "detach", "endTyping", "init", "recipientId", "recipientUsername", "channelName", "shareTitle", "shareUrl", "shareLink", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "deepLink", "", "loadMoreMessages", "reportMessage", "Lio/reactivex/Observable;", "message", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "reason", "Lcom/reddit/datalibrary/social/model/ReportMessage;", "resendMessage", "restore", "stateStorage", "Lcom/reddit/datalibrary/social/data/common/StateStorageContract;", "revealUsername", "revealUsernameRequested", "save", "sendClicked", "sendSnoomoji", "snoomoji", "settings", "startTyping", "uploadFileConfirmed", "uri", "Landroid/net/Uri;", "viewAttached", "viewCreated", "view", "Lcom/reddit/social/presentation/groupchat/ChatContract$View;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatContract.kt */
    public interface Presenter {
        Observable<Object> mo5160a(HasMessageData hasMessageData, String str, ReportMessage reportMessage);

        void mo5161a();

        void mo5162a(Uri uri);

        void mo5163a(StateStorageContract stateStorageContract);

        void mo5164a(View view);

        void mo5165a(HasMessageData hasMessageData);

        void mo5166a(String str);

        void mo5167a(String str, long j, String str2);

        void mo5168a(String str, String str2);

        void mo5169a(String str, String str2, String str3, Link link);

        void mo5170b();

        void mo5171b(StateStorageContract stateStorageContract);

        void mo5172b(String str);

        void mo5173c();

        void mo5174c(String str);

        void mo5175d();

        void mo5176e();

        void mo5177f();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000eH&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000eH&J\u0016\u0010\u001f\u001a\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H&J\u001a\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010(\u001a\u00020\u00032\b\b\u0001\u0010)\u001a\u00020*H&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000eH&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u000eH&J\b\u0010.\u001a\u00020\u0003H&J\u0018\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000eH&J\u0018\u00102\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u00103\u001a\u000204H&J\u0010\u00105\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u00066"}, d2 = {"Lcom/reddit/social/presentation/groupchat/ChatContract$View;", "", "addNewMessage", "", "message", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "addNewMessages", "messagesBatch", "Lcom/reddit/social/domain/functions/MessagesBatch;", "addOldMessages", "clearInputField", "disableSendButton", "enableSendButton", "getInputFieldText", "", "loadError", "loading", "loadingStarted", "loadingStopped", "markMessageSent", "requestId", "messageId", "", "networkConnectionChange", "hasNetworkConnection", "", "removeMessage", "sendError", "sending", "setKeyboardHint", "channelName", "setMembers", "members", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "setTitle", "title", "subtitle", "setTypingIndicator", "typingTitle", "showErrorMessage", "messageRes", "", "showErrorMessageTooLong", "showMessageSettings", "url", "showRefreshing", "showRevealConfirmationDialog", "currentUserName", "recipient", "updateMessageStatus", "status", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "updateMessages", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatContract.kt */
    public interface View {
        void mo7547a();

        void mo7548a(int i);

        void mo7549a(long j);

        void mo7550a(MessagesBatch messagesBatch);

        void mo7551a(HasMessageData hasMessageData);

        void mo7552a(String str);

        void mo7553a(String str, long j);

        void mo7554a(String str, SentStatus sentStatus);

        void mo7555a(String str, String str2);

        void mo7556a(List<UserData> list);

        void mo7557a(boolean z);

        void mo7558b();

        void mo7559b(MessagesBatch messagesBatch);

        void mo7560b(String str);

        String mo7561c();

        void mo7562c(MessagesBatch messagesBatch);

        void mo7241c(String str);

        void mo7563d();

        void mo7564d(String str);

        void mo7565e();

        void mo7566e(String str);

        void mo7567f();

        void mo7568g();

        void mo7569h();
    }
}
