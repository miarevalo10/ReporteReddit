package com.reddit.frontpage.ui.detail;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u0006\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/ui/detail/OnLinkActionListener;", "", "onLinkDeleted", "", "onLinkHidden", "onLinkUnhidden", "HideLinkActionEvent", "UnhideLinkActionEvent", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnLinkActionListener.kt */
public interface OnLinkActionListener {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/ui/detail/OnLinkActionListener$HideLinkActionEvent;", "", "position", "", "(I)V", "getPosition", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnLinkActionListener.kt */
    public static final class HideLinkActionEvent {
        public final int f21174a;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HideLinkActionEvent) {
                if (this.f21174a == ((HideLinkActionEvent) obj).f21174a) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.f21174a;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("HideLinkActionEvent(position=");
            stringBuilder.append(this.f21174a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public HideLinkActionEvent(int i) {
            this.f21174a = i;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/ui/detail/OnLinkActionListener$UnhideLinkActionEvent;", "", "position", "", "(I)V", "getPosition", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnLinkActionListener.kt */
    public static final class UnhideLinkActionEvent {
        private final int f21175a;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UnhideLinkActionEvent) {
                if (this.f21175a == ((UnhideLinkActionEvent) obj).f21175a) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.f21175a;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("UnhideLinkActionEvent(position=");
            stringBuilder.append(this.f21175a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public UnhideLinkActionEvent(int i) {
            this.f21175a = i;
        }
    }

    void q_();

    void mo7146x();

    void mo7147y();
}
