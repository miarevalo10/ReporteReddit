package com.reddit.frontpage.presentation.postoption;

import com.reddit.frontpage.domain.model.Subreddit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/postoption/PostOptionsContract;", "", "Parameters", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PostOptionsContract.kt */
public interface PostOptionsContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/presentation/postoption/PostOptionsContract$Parameters;", "", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "(Lcom/reddit/frontpage/domain/model/Subreddit;)V", "getSubreddit", "()Lcom/reddit/frontpage/domain/model/Subreddit;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: PostOptionsContract.kt */
    public static final class Parameters {
        final Subreddit f20958a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    if (Intrinsics.m26845a(this.f20958a, ((Parameters) obj).f20958a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            Subreddit subreddit = this.f20958a;
            return subreddit != null ? subreddit.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Parameters(subreddit=");
            stringBuilder.append(this.f20958a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Parameters(Subreddit subreddit) {
            this.f20958a = subreddit;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/presentation/postoption/PostOptionsContract$View;", "", "enableAllOptions", "", "enable", "", "enableImageOption", "enableLinkOption", "enableTextOption", "enableVideoOption", "setDestination", "destination", "", "keyColor", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: PostOptionsContract.kt */
    public interface View {

        @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
        /* compiled from: PostOptionsContract.kt */
        public static final class DefaultImpls {
        }

        void mo6976a();

        void mo6977a(String str, String str2);

        void mo6978a(boolean z);

        void mo6979b(boolean z);

        void mo6980c(boolean z);

        void mo6981d(boolean z);
    }
}
