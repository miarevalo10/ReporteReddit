package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\b&\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001e\u0010\u0006\u001a\u00020\u00078\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v1/BaseThing;", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "Ljava/io/Serializable;", "id", "", "name", "createdUtc", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getCreatedUtc", "()J", "setCreatedUtc", "(J)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BaseThing.kt */
public abstract class BaseThing implements Thing, Serializable {
    @SerializedName(a = "created_utc")
    @Json(a = "created_utc")
    public long createdUtc;
    private String id;
    private String name;

    public BaseThing(byte b) {
        this();
    }

    public BaseThing(String str, String str2) {
        Intrinsics.b(str, "id");
        Intrinsics.b(str2, "name");
        this.id = str;
        this.name = str2;
        this.createdUtc = null;
    }

    public final void m16419a(String str) {
        Intrinsics.b(str, "<set-?>");
        this.id = str;
    }

    public String getId() {
        return this.id;
    }

    public final void m16420b(String str) {
        Intrinsics.b(str, "<set-?>");
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    private /* synthetic */ BaseThing() {
        this("", "");
    }

    public long getCreatedUtc() {
        return this.createdUtc;
    }
}
