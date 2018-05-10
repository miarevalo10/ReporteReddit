package com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator;", "", "()V", "Icon", "Text", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator$Icon;", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator$Text;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FastScrollItemIndicator.kt */
public abstract class FastScrollItemIndicator {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator$Icon;", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator;", "iconRes", "", "(I)V", "getIconRes", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: FastScrollItemIndicator.kt */
    public static final class Icon extends FastScrollItemIndicator {
        final int f28090a;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Icon) {
                if (this.f28090a == ((Icon) obj).f28090a) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.f28090a;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Icon(iconRes=");
            stringBuilder.append(this.f28090a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Icon(int i) {
            super();
            this.f28090a = i;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator$Text;", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator;", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: FastScrollItemIndicator.kt */
    public static final class Text extends FastScrollItemIndicator {
        final String f28091a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Text) {
                    if (Intrinsics.m26845a(this.f28091a, ((Text) obj).f28091a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f28091a;
            return str != null ? str.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Text(text=");
            stringBuilder.append(this.f28091a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Text(String str) {
            Intrinsics.m26847b(str, "text");
            super();
            this.f28091a = str;
        }
    }

    private FastScrollItemIndicator() {
    }
}
