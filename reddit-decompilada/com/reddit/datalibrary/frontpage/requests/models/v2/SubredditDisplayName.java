package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.raizlabs.android.dbflow.structure.BaseQueryModel;
import org.parceler.Parcel;

@Parcel
public class SubredditDisplayName extends BaseQueryModel {
    String display_name;

    public String getDisplayName() {
        return this.display_name;
    }
}
