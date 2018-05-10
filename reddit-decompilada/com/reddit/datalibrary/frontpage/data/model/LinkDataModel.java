package com.reddit.datalibrary.frontpage.data.model;

import com.raizlabs.android.dbflow.rx2.structure.BaseRXModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/LinkDataModel;", "Lcom/raizlabs/android/dbflow/rx2/structure/BaseRXModel;", "linkId", "", "listingPosition", "", "linkJson", "(Ljava/lang/String;ILjava/lang/String;)V", "getLinkId", "()Ljava/lang/String;", "setLinkId", "(Ljava/lang/String;)V", "getLinkJson", "setLinkJson", "listing", "Lcom/reddit/datalibrary/frontpage/data/model/ListingDataModel;", "getListing", "()Lcom/reddit/datalibrary/frontpage/data/model/ListingDataModel;", "setListing", "(Lcom/reddit/datalibrary/frontpage/data/model/ListingDataModel;)V", "getListingPosition", "()I", "setListingPosition", "(I)V", "mutations", "Lcom/reddit/datalibrary/frontpage/data/model/LinkMutationsDataModel;", "getMutations", "()Lcom/reddit/datalibrary/frontpage/data/model/LinkMutationsDataModel;", "setMutations", "(Lcom/reddit/datalibrary/frontpage/data/model/LinkMutationsDataModel;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkDataModel.kt */
public final class LinkDataModel extends BaseRXModel {
    private String linkId;
    private String linkJson;
    private ListingDataModel listing;
    private int listingPosition;
    private LinkMutationsDataModel mutations;

    public LinkDataModel() {
        this(null, 0, null, 7, null);
    }

    public final String getLinkId() {
        return this.linkId;
    }

    public final void setLinkId(String str) {
        Intrinsics.b(str, "<set-?>");
        this.linkId = str;
    }

    public final int getListingPosition() {
        return this.listingPosition;
    }

    public final void setListingPosition(int i) {
        this.listingPosition = i;
    }

    public /* synthetic */ LinkDataModel(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 1) != null) {
            str = "";
        }
        if ((i2 & 2) != null) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        this(str, i, str2);
    }

    public final String getLinkJson() {
        return this.linkJson;
    }

    public final void setLinkJson(String str) {
        Intrinsics.b(str, "<set-?>");
        this.linkJson = str;
    }

    public LinkDataModel(String str, int i, String str2) {
        Intrinsics.b(str, "linkId");
        Intrinsics.b(str2, "linkJson");
        this.linkId = str;
        this.listingPosition = i;
        this.linkJson = str2;
    }

    public final ListingDataModel getListing() {
        return this.listing;
    }

    public final void setListing(ListingDataModel listingDataModel) {
        this.listing = listingDataModel;
    }

    public final LinkMutationsDataModel getMutations() {
        return this.mutations;
    }

    public final void setMutations(LinkMutationsDataModel linkMutationsDataModel) {
        this.mutations = linkMutationsDataModel;
    }
}
