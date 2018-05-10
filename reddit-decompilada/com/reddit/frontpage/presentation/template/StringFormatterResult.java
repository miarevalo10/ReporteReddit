package com.reddit.frontpage.presentation.template;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/template/StringFormatterResult;", "", "()V", "Error", "Success", "Lcom/reddit/frontpage/presentation/template/StringFormatterResult$Error;", "Lcom/reddit/frontpage/presentation/template/StringFormatterResult$Success;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: StringFormatter.kt */
public abstract class StringFormatterResult {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/template/StringFormatterResult$Error;", "Lcom/reddit/frontpage/presentation/template/StringFormatterResult;", "error", "", "value", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "getError", "()Ljava/lang/Throwable;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: StringFormatter.kt */
    public static final class Error extends StringFormatterResult {
        private final Throwable f28804a;
        private final String f28805b;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Error) {
                    Error error = (Error) obj;
                    if (Intrinsics.m26845a(this.f28804a, error.f28804a) && Intrinsics.m26845a(this.f28805b, error.f28805b)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            Throwable th = this.f28804a;
            int i = 0;
            int hashCode = (th != null ? th.hashCode() : 0) * 31;
            String str = this.f28805b;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Error(error=");
            stringBuilder.append(this.f28804a);
            stringBuilder.append(", value=");
            stringBuilder.append(this.f28805b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Error(Throwable th, String str) {
            Intrinsics.m26847b(th, "error");
            Intrinsics.m26847b(str, "value");
            super();
            this.f28804a = th;
            this.f28805b = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/presentation/template/StringFormatterResult$Success;", "Lcom/reddit/frontpage/presentation/template/StringFormatterResult;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: StringFormatter.kt */
    public static final class Success extends StringFormatterResult {
        final String f28806a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Success) {
                    if (Intrinsics.m26845a(this.f28806a, ((Success) obj).f28806a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f28806a;
            return str != null ? str.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Success(value=");
            stringBuilder.append(this.f28806a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Success(String str) {
            Intrinsics.m26847b(str, "value");
            super();
            this.f28806a = str;
        }
    }

    private StringFormatterResult() {
    }
}
