package com.reddit.frontpage.presentation.communities.model;

import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/model/CommunityListItem;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "viewType", "", "itemId", "", "(IJ)V", "getItemId", "()J", "getViewType", "()I", "Lcom/reddit/frontpage/presentation/communities/model/CommunityListItemPresentationModel;", "Lcom/reddit/frontpage/presentation/communities/model/SubredditDiscoveryUnitItemPresentationModel;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunityListItem.kt */
public abstract class CommunityListItem implements Listable {
    public final int f33831a;
    public final long f33832b;

    public int getMinAndroidVersion() {
        return 0;
    }

    private CommunityListItem(int i, long j) {
        this.f33831a = i;
        this.f33832b = j;
    }
}
