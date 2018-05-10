package com.reddit.datalibrary.frontpage.data.model;

import com.raizlabs.android.dbflow.structure.BaseModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000b\"\u0004\b\u000e\u0010\rR\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/LinkMutationsDataModel;", "Lcom/raizlabs/android/dbflow/structure/BaseModel;", "linkId", "", "isRead", "", "readTimestampUtc", "", "isHidden", "isSaved", "(Ljava/lang/String;ZJZZ)V", "()Z", "setHidden", "(Z)V", "setRead", "setSaved", "getLinkId", "()Ljava/lang/String;", "setLinkId", "(Ljava/lang/String;)V", "getReadTimestampUtc", "()J", "setReadTimestampUtc", "(J)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkMutationsDataModel.kt */
public final class LinkMutationsDataModel extends BaseModel {
    private boolean isHidden;
    private boolean isRead;
    private boolean isSaved;
    private String linkId;
    private long readTimestampUtc;

    public LinkMutationsDataModel() {
        this(null, false, 0, false, false, 31, null);
    }

    public static /* synthetic */ LinkMutationsDataModel copy$default(LinkMutationsDataModel linkMutationsDataModel, String str, boolean z, long j, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = linkMutationsDataModel.linkId;
        }
        if ((i & 2) != 0) {
            z = linkMutationsDataModel.isRead;
        }
        boolean z4 = z;
        if ((i & 4) != 0) {
            j = linkMutationsDataModel.readTimestampUtc;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            z2 = linkMutationsDataModel.isHidden;
        }
        boolean z5 = z2;
        if ((i & 16) != 0) {
            z3 = linkMutationsDataModel.isSaved;
        }
        return linkMutationsDataModel.copy(str, z4, j2, z5, z3);
    }

    public final String component1() {
        return this.linkId;
    }

    public final boolean component2() {
        return this.isRead;
    }

    public final long component3() {
        return this.readTimestampUtc;
    }

    public final boolean component4() {
        return this.isHidden;
    }

    public final boolean component5() {
        return this.isSaved;
    }

    public final LinkMutationsDataModel copy(String str, boolean z, long j, boolean z2, boolean z3) {
        Intrinsics.b(str, "linkId");
        return new LinkMutationsDataModel(str, z, j, z2, z3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LinkMutationsDataModel) {
            LinkMutationsDataModel linkMutationsDataModel = (LinkMutationsDataModel) obj;
            if (Intrinsics.a(this.linkId, linkMutationsDataModel.linkId)) {
                if (this.isRead == linkMutationsDataModel.isRead) {
                    if (this.readTimestampUtc == linkMutationsDataModel.readTimestampUtc) {
                        if (this.isHidden == linkMutationsDataModel.isHidden) {
                            if (this.isSaved == linkMutationsDataModel.isSaved) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.linkId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        int i = this.isRead;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        long j = this.readTimestampUtc;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        i = this.isHidden;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        i = this.isSaved;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LinkMutationsDataModel(linkId=");
        stringBuilder.append(this.linkId);
        stringBuilder.append(", isRead=");
        stringBuilder.append(this.isRead);
        stringBuilder.append(", readTimestampUtc=");
        stringBuilder.append(this.readTimestampUtc);
        stringBuilder.append(", isHidden=");
        stringBuilder.append(this.isHidden);
        stringBuilder.append(", isSaved=");
        stringBuilder.append(this.isSaved);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final String getLinkId() {
        return this.linkId;
    }

    public final void setLinkId(String str) {
        Intrinsics.b(str, "<set-?>");
        this.linkId = str;
    }

    public final boolean isRead() {
        return this.isRead;
    }

    public final void setRead(boolean z) {
        this.isRead = z;
    }

    public /* synthetic */ LinkMutationsDataModel(String str, boolean z, long j, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != null) {
            str = "";
        }
        boolean z4 = false;
        defaultConstructorMarker = (i & 2) != null ? null : z;
        if (i & 4) {
            j = System.currentTimeMillis();
        }
        long j2 = j;
        boolean z5 = i & 8 ? false : z2;
        if (!(i & 16)) {
            z4 = z3;
        }
        this(str, defaultConstructorMarker, j2, z5, z4);
    }

    public final long getReadTimestampUtc() {
        return this.readTimestampUtc;
    }

    public final void setReadTimestampUtc(long j) {
        this.readTimestampUtc = j;
    }

    public final boolean isHidden() {
        return this.isHidden;
    }

    public final void setHidden(boolean z) {
        this.isHidden = z;
    }

    public final boolean isSaved() {
        return this.isSaved;
    }

    public final void setSaved(boolean z) {
        this.isSaved = z;
    }

    public LinkMutationsDataModel(String str, boolean z, long j, boolean z2, boolean z3) {
        Intrinsics.b(str, "linkId");
        this.linkId = str;
        this.isRead = z;
        this.readTimestampUtc = j;
        this.isHidden = z2;
        this.isSaved = z3;
    }
}
