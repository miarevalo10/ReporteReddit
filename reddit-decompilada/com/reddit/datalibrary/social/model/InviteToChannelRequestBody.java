package com.reddit.datalibrary.social.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/datalibrary/social/model/InviteToChannelRequestBody;", "", "users", "", "Lcom/reddit/datalibrary/social/model/User;", "(Ljava/util/List;)V", "getUsers", "()Ljava/util/List;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: InviteToChannelRequestBody.kt */
public final class InviteToChannelRequestBody {
    @SerializedName(a = "users")
    private final List<User> users;

    public InviteToChannelRequestBody(List<User> list) {
        Intrinsics.m26847b(list, "users");
        this.users = list;
    }

    public final List<User> getUsers() {
        return this.users;
    }
}
