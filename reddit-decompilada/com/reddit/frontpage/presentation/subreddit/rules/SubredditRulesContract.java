package com.reddit.frontpage.presentation.subreddit.rules;

import com.reddit.datalibrary.frontpage.data.model.SubredditRule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/subreddit/rules/SubredditRulesContract;", "", "Parameters", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubredditRulesContract.kt */
public interface SubredditRulesContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/presentation/subreddit/rules/SubredditRulesContract$Parameters;", "", "subredditName", "", "(Ljava/lang/String;)V", "getSubredditName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SubredditRulesContract.kt */
    public static final class Parameters {
        public final String f20974a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    if (Intrinsics.m26845a(this.f20974a, ((Parameters) obj).f20974a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f20974a;
            return str != null ? str.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Parameters(subredditName=");
            stringBuilder.append(this.f20974a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Parameters(String str) {
            Intrinsics.m26847b(str, "subredditName");
            this.f20974a = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/subreddit/rules/SubredditRulesContract$View;", "", "bind", "", "descriptionHtml", "", "rules", "", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditRule;", "hideLoading", "notifyNoRules", "notifyUnableLoadRules", "showLoading", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SubredditRulesContract.kt */
    public interface View {
        void mo7184a();

        void mo7186a(String str);

        void mo7187a(List<SubredditRule> list);

        void mo7188b();

        void mo7189c();

        void mo7190d();
    }
}
