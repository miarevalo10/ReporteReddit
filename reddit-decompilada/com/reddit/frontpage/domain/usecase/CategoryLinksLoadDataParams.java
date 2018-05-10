package com.reddit.frontpage.domain.usecase;

import com.reddit.frontpage.domain.model.SubredditCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/CategoryLinksLoadDataParams;", "Lcom/reddit/frontpage/domain/usecase/Params;", "category", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "after", "", "(Lcom/reddit/frontpage/domain/model/SubredditCategory;Ljava/lang/String;)V", "getAfter", "()Ljava/lang/String;", "getCategory", "()Lcom/reddit/frontpage/domain/model/SubredditCategory;", "Load", "Refresh", "Lcom/reddit/frontpage/domain/usecase/CategoryLinksLoadDataParams$Load;", "Lcom/reddit/frontpage/domain/usecase/CategoryLinksLoadDataParams$Refresh;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CategoryLinksLoadData.kt */
public abstract class CategoryLinksLoadDataParams implements Params {
    public final SubredditCategory f27972a;
    final String f27973b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/CategoryLinksLoadDataParams$Load;", "Lcom/reddit/frontpage/domain/usecase/CategoryLinksLoadDataParams;", "category", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "after", "", "(Lcom/reddit/frontpage/domain/model/SubredditCategory;Ljava/lang/String;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CategoryLinksLoadData.kt */
    public static final class Load extends CategoryLinksLoadDataParams {
        public Load(SubredditCategory subredditCategory, String str) {
            Intrinsics.m26847b(subredditCategory, "category");
            super(subredditCategory, str);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/CategoryLinksLoadDataParams$Refresh;", "Lcom/reddit/frontpage/domain/usecase/CategoryLinksLoadDataParams;", "category", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "(Lcom/reddit/frontpage/domain/model/SubredditCategory;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CategoryLinksLoadData.kt */
    public static final class Refresh extends CategoryLinksLoadDataParams {
        public Refresh(SubredditCategory subredditCategory) {
            Intrinsics.m26847b(subredditCategory, "category");
            super(subredditCategory);
        }
    }

    private CategoryLinksLoadDataParams(SubredditCategory subredditCategory, String str) {
        this.f27972a = subredditCategory;
        this.f27973b = str;
    }
}
