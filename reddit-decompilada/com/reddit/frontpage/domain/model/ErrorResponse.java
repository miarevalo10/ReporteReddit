package com.reddit.frontpage.domain.model;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bR\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/domain/model/ErrorResponse;", "", "errors", "", "", "(Ljava/util/List;)V", "firstError", "getFirstError", "()Ljava/lang/String;", "firstErrorList", "hasErrors", "", "isTextFirstError", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ErrorResponse.kt */
public abstract class ErrorResponse {
    public static final Companion Companion = new Companion();
    private static final int ERROR_MESSAGE_INDEX = 1;
    private static final int ERROR_MESSAGE_TYPE_INDEX = 2;
    private static final String ERROR_MESSAGE_TYPE_TEXT = "text";
    private final List<List<String>> errors;
    private final String firstError;
    private final List<String> firstErrorList = ((List) CollectionsKt___CollectionsKt.m41434e((List) this.errors));

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/domain/model/ErrorResponse$Companion;", "", "()V", "ERROR_MESSAGE_INDEX", "", "ERROR_MESSAGE_TYPE_INDEX", "ERROR_MESSAGE_TYPE_TEXT", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ErrorResponse.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public ErrorResponse(List<? extends List<String>> list) {
        Intrinsics.m26847b(list, "errors");
        this.errors = list;
        list = this.firstErrorList;
        this.firstError = list != null ? (String) list.get(1) : null;
    }

    public final String getFirstError() {
        return this.firstError;
    }

    public final boolean hasErrors() {
        return !((Collection) this.errors).isEmpty();
    }

    public final boolean isTextFirstError() {
        Object obj = "text";
        List list = this.firstErrorList;
        return Intrinsics.m26845a(obj, list != null ? (String) list.get(2) : null);
    }
}
