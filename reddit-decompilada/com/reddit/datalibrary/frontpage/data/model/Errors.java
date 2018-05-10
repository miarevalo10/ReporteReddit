package com.reddit.datalibrary.frontpage.data.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0017\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003HÆ\u0003J!\u0010\t\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R$\u0010\u0002\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/Errors;", "", "errors", "", "", "(Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModToolsPostResponse.kt */
public final class Errors {
    @Json(a = "errors")
    private final List<List<String>> errors;

    public static /* synthetic */ Errors copy$default(Errors errors, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = errors.errors;
        }
        return errors.copy(list);
    }

    public final List<List<String>> component1() {
        return this.errors;
    }

    public final Errors copy(List<? extends List<String>> list) {
        return new Errors(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Errors) {
                if (Intrinsics.a(this.errors, ((Errors) obj).errors)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List list = this.errors;
        return list != null ? list.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Errors(errors=");
        stringBuilder.append(this.errors);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Errors(List<? extends List<String>> list) {
        this.errors = list;
    }

    public final List<List<String>> getErrors() {
        return this.errors;
    }
}
