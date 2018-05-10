package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

class Entity implements Serializable {
    @SerializedName(a = "indices")
    public final List<Integer> f24028a;

    public int mo5489a() {
        return ((Integer) this.f24028a.get(0)).intValue();
    }

    public int mo5490b() {
        return ((Integer) this.f24028a.get(1)).intValue();
    }
}
