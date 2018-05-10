package com.reddit.frontpage.presentation.analytics;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.domain.model.Subreddit;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J0\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J0\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/presentation/analytics/SearchAnalytics;", "", "onRecentClick", "", "position", "", "query", "", "onRecentView", "onTypeAhead", "onTypeAheadClick", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "onTypeAheadSubmission", "onTypeAheadView", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SearchAnalytics.kt */
public interface SearchAnalytics {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: SearchAnalytics.kt */
    public static final class DefaultImpls {
        public static /* bridge */ /* synthetic */ void m22656a(SearchAnalytics searchAnalytics, int i, String str, Account account, Subreddit subreddit, int i2) {
            if ((i2 & 4) != 0) {
                account = null;
            }
            if ((i2 & 8) != 0) {
                subreddit = null;
            }
            searchAnalytics.mo4779a(i, str, account, subreddit);
        }
    }

    void mo4778a(int i, String str);

    void mo4779a(int i, String str, Account account, Subreddit subreddit);

    void mo4780a(String str);

    void mo4781b(int i, String str);

    void mo4782b(String str);

    void mo4783c(int i, String str);
}
