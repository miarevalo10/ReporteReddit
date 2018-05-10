package com.reddit.datalibrary.frontpage.data.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010\f\u001a\u0004\u0018\u00010\rJ\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\rHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/ModToolsPostResponse;", "", "json", "Lcom/reddit/datalibrary/frontpage/data/model/Errors;", "(Lcom/reddit/datalibrary/frontpage/data/model/Errors;)V", "getJson", "()Lcom/reddit/datalibrary/frontpage/data/model/Errors;", "component1", "copy", "equals", "", "other", "getFirstErrorMessage", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModToolsPostResponse.kt */
public final class ModToolsPostResponse {
    @Json(a = "json")
    private final Errors json;

    public static /* synthetic */ ModToolsPostResponse copy$default(ModToolsPostResponse modToolsPostResponse, Errors errors, int i, Object obj) {
        if ((i & 1) != 0) {
            errors = modToolsPostResponse.json;
        }
        return modToolsPostResponse.copy(errors);
    }

    public final Errors component1() {
        return this.json;
    }

    public final ModToolsPostResponse copy(Errors errors) {
        return new ModToolsPostResponse(errors);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ModToolsPostResponse) {
                if (Intrinsics.a(this.json, ((ModToolsPostResponse) obj).json)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Errors errors = this.json;
        return errors != null ? errors.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ModToolsPostResponse(json=");
        stringBuilder.append(this.json);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ModToolsPostResponse(Errors errors) {
        this.json = errors;
    }

    public final Errors getJson() {
        return this.json;
    }

    public final String getFirstErrorMessage() {
        Errors errors = this.json;
        if ((errors != null ? errors.getErrors() : null) == null || (this.json.getErrors().isEmpty() ^ 1) == 0) {
            return null;
        }
        return (String) ((List) this.json.getErrors().get(0)).get(1);
    }
}
