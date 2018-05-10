package com.reddit.datalibrary.social.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0011R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/reddit/datalibrary/social/model/CreateChannelRequestBody;", "", "name", "", "cover_url", "custom_type", "data", "users", "", "Lcom/reddit/datalibrary/social/model/User;", "is_distinct", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "getCover_url", "()Ljava/lang/String;", "getCustom_type", "getData", "()Z", "getName", "getUsers", "()Ljava/util/List;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CreateChannelRequestBody.kt */
public final class CreateChannelRequestBody {
    @SerializedName(a = "cover_url")
    private final String cover_url;
    @SerializedName(a = "custom_type")
    private final String custom_type;
    @SerializedName(a = "data")
    private final String data;
    @SerializedName(a = "is_distinct")
    private final boolean is_distinct;
    @SerializedName(a = "name")
    private final String name;
    @SerializedName(a = "users")
    private final List<User> users;

    public CreateChannelRequestBody(String str, String str2, String str3, String str4, List<User> list, boolean z) {
        Intrinsics.m26847b(list, "users");
        this.name = str;
        this.cover_url = str2;
        this.custom_type = str3;
        this.data = str4;
        this.users = list;
        this.is_distinct = z;
    }

    public final String getName() {
        return this.name;
    }

    public final String getCover_url() {
        return this.cover_url;
    }

    public final String getCustom_type() {
        return this.custom_type;
    }

    public final String getData() {
        return this.data;
    }

    public final List<User> getUsers() {
        return this.users;
    }

    public final boolean is_distinct() {
        return this.is_distinct;
    }
}
