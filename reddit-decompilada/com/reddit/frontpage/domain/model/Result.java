package com.reddit.frontpage.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/domain/model/Result;", "T", "", "()V", "error", "", "getError", "()Ljava/lang/String;", "Error", "Success", "Lcom/reddit/frontpage/domain/model/Result$Success;", "Lcom/reddit/frontpage/domain/model/Result$Error;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Result.kt */
public abstract class Result<T> {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J#\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/domain/model/Result$Error;", "T", "Lcom/reddit/frontpage/domain/model/Result;", "error", "", "isTextError", "", "(Ljava/lang/String;Z)V", "getError", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Result.kt */
    public static final class Error<T> extends Result<T> {
        private final String error;
        private final boolean isTextError;

        public static /* synthetic */ Error copy$default(Error error, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.getError();
            }
            if ((i & 2) != 0) {
                z = error.isTextError;
            }
            return error.copy(str, z);
        }

        public final String component1() {
            return getError();
        }

        public final boolean component2() {
            return this.isTextError;
        }

        public final Error<T> copy(String str, boolean z) {
            Intrinsics.m26847b(str, "error");
            return new Error(str, z);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Error) {
                Error error = (Error) obj;
                if (Intrinsics.m26845a(getError(), error.getError())) {
                    if (this.isTextError == error.isTextError) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            String error = getError();
            int hashCode = (error != null ? error.hashCode() : 0) * 31;
            int i = this.isTextError;
            if (i != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Error(error=");
            stringBuilder.append(getError());
            stringBuilder.append(", isTextError=");
            stringBuilder.append(this.isTextError);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public final String getError() {
            return this.error;
        }

        public /* synthetic */ Error(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 2) != 0) {
                z = false;
            }
            this(str, z);
        }

        public final boolean isTextError() {
            return this.isTextError;
        }

        public Error(String str, boolean z) {
            Intrinsics.m26847b(str, "error");
            super();
            this.error = str;
            this.isTextError = z;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\nJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/domain/model/Result$Success;", "T", "Lcom/reddit/frontpage/domain/model/Result;", "result", "(Ljava/lang/Object;)V", "error", "", "getError", "()Ljava/lang/String;", "getResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/reddit/frontpage/domain/model/Result$Success;", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Result.kt */
    public static final class Success<T> extends Result<T> {
        private final T result;

        public static /* synthetic */ Success copy$default(Success success, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.result;
            }
            return success.copy(obj);
        }

        public final T component1() {
            return this.result;
        }

        public final Success<T> copy(T t) {
            return new Success(t);
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Success) {
                    if (Intrinsics.m26845a(this.result, ((Success) obj).result)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final String getError() {
            return null;
        }

        public final int hashCode() {
            Object obj = this.result;
            return obj != null ? obj.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Success(result=");
            stringBuilder.append(this.result);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Success(T t) {
            super();
            this.result = t;
        }

        public final T getResult() {
            return this.result;
        }
    }

    public abstract String getError();

    private Result() {
    }
}
