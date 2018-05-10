package com.reddit.datalibrary.frontpage.requests.models.v1;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v1/Features;", "Ljava/io/Serializable;", "chat_group_rollout", "", "(Z)V", "getChat_group_rollout", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Features.kt */
public final class Features implements Serializable {
    public final boolean chat_group_rollout = false;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Features) {
            if (this.chat_group_rollout == ((Features) obj).chat_group_rollout) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        boolean z = this.chat_group_rollout;
        return z ? 1 : z;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Features(chat_group_rollout=");
        stringBuilder.append(this.chat_group_rollout);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private Features() {
    }
}
