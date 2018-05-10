package com.reddit.social.presentation.chatinbox.view;

import com.reddit.frontpage.C1761R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/social/presentation/chatinbox/view/LoadingState;", "", "()V", "CONTENT", "EMPTY", "ERROR", "LOADING", "Lcom/reddit/social/presentation/chatinbox/view/LoadingState$LOADING;", "Lcom/reddit/social/presentation/chatinbox/view/LoadingState$EMPTY;", "Lcom/reddit/social/presentation/chatinbox/view/LoadingState$CONTENT;", "Lcom/reddit/social/presentation/chatinbox/view/LoadingState$ERROR;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatInboxScreen.kt */
public abstract class LoadingState {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/social/presentation/chatinbox/view/LoadingState$CONTENT;", "Lcom/reddit/social/presentation/chatinbox/view/LoadingState;", "()V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatInboxScreen.kt */
    public static final class CONTENT extends LoadingState {
        public static final CONTENT f29632a = new CONTENT();

        private CONTENT() {
            super();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/social/presentation/chatinbox/view/LoadingState$EMPTY;", "Lcom/reddit/social/presentation/chatinbox/view/LoadingState;", "()V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatInboxScreen.kt */
    public static final class EMPTY extends LoadingState {
        public static final EMPTY f29633a = new EMPTY();

        private EMPTY() {
            super();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/social/presentation/chatinbox/view/LoadingState$ERROR;", "Lcom/reddit/social/presentation/chatinbox/view/LoadingState;", "error", "", "(I)V", "getError", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatInboxScreen.kt */
    public static final class ERROR extends LoadingState {
        final int f29634a = C1761R.string.chat_error;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ERROR) {
                if (this.f29634a == ((ERROR) obj).f29634a) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.f29634a;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("ERROR(error=");
            stringBuilder.append(this.f29634a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public ERROR() {
            super();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/social/presentation/chatinbox/view/LoadingState$LOADING;", "Lcom/reddit/social/presentation/chatinbox/view/LoadingState;", "()V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatInboxScreen.kt */
    public static final class LOADING extends LoadingState {
        public static final LOADING f29635a = new LOADING();

        private LOADING() {
            super();
        }
    }

    private LoadingState() {
    }
}
