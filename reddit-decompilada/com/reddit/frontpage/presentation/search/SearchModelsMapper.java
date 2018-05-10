package com.reddit.frontpage.presentation.search;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.common.ResourceProvider;
import com.reddit.frontpage.domain.model.AccountSearchResultItem;
import com.reddit.frontpage.domain.model.SearchResultItem;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.model.SubredditSearchResultItem;
import com.reddit.frontpage.presentation.carousel.SubredditMapper;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModelType;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.formatter.NumberFormatter;
import com.reddit.frontpage.ui.profile.profilesettings.model.AccountMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/presentation/search/SearchModelsMapper;", "", "()V", "formatStats", "", "item", "Lcom/reddit/frontpage/domain/model/SearchResultItem;", "resourceProvider", "Lcom/reddit/frontpage/domain/common/ResourceProvider;", "numberFormatter", "Lcom/reddit/frontpage/presentation/formatter/NumberFormatter;", "accountFormatter", "Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;", "toCommunityPresentationModel", "Lcom/reddit/frontpage/presentation/search/SearchModelsMapper$SearchItemPresentationModel;", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "SearchItemPresentationModel", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitySearchModels.kt */
public final class SearchModelsMapper {
    public static final SearchModelsMapper f20973a = new SearchModelsMapper();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/presentation/search/SearchModelsMapper$SearchItemPresentationModel;", "", "communityPresentationModel", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "numSubscribers", "", "subscribed", "", "(Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;Ljava/lang/String;Z)V", "getCommunityPresentationModel", "()Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "getNumSubscribers", "()Ljava/lang/String;", "getSubscribed", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitySearchModels.kt */
    public static final class SearchItemPresentationModel {
        final CommunityPresentationModel f20970a;
        final String f20971b;
        final boolean f20972c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SearchItemPresentationModel) {
                SearchItemPresentationModel searchItemPresentationModel = (SearchItemPresentationModel) obj;
                if (Intrinsics.m26845a(this.f20970a, searchItemPresentationModel.f20970a) && Intrinsics.m26845a(this.f20971b, searchItemPresentationModel.f20971b)) {
                    if (this.f20972c == searchItemPresentationModel.f20972c) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            CommunityPresentationModel communityPresentationModel = this.f20970a;
            int i = 0;
            int hashCode = (communityPresentationModel != null ? communityPresentationModel.hashCode() : 0) * 31;
            String str = this.f20971b;
            if (str != null) {
                i = str.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            i = this.f20972c;
            if (i != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("SearchItemPresentationModel(communityPresentationModel=");
            stringBuilder.append(this.f20970a);
            stringBuilder.append(", numSubscribers=");
            stringBuilder.append(this.f20971b);
            stringBuilder.append(", subscribed=");
            stringBuilder.append(this.f20972c);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public SearchItemPresentationModel(CommunityPresentationModel communityPresentationModel, String str, boolean z) {
            Intrinsics.m26847b(communityPresentationModel, "communityPresentationModel");
            Intrinsics.m26847b(str, "numSubscribers");
            this.f20970a = communityPresentationModel;
            this.f20971b = str;
            this.f20972c = z;
        }
    }

    private SearchModelsMapper() {
    }

    public static CommunityPresentationModel m23192a(Subreddit subreddit) {
        Intrinsics.m26847b(subreddit, "subreddit");
        SubredditMapper subredditMapper = SubredditMapper.f20341a;
        return SubredditMapper.m22680a(CommunityPresentationModelType.f20484b, CommunityPresentationSection.f20487a, subreddit);
    }

    public static SearchItemPresentationModel m23193a(SearchResultItem searchResultItem, ResourceProvider resourceProvider, NumberFormatter numberFormatter, AccountFormatter accountFormatter) {
        Intrinsics.m26847b(searchResultItem, "item");
        Intrinsics.m26847b(resourceProvider, "resourceProvider");
        Intrinsics.m26847b(numberFormatter, "numberFormatter");
        Intrinsics.m26847b(accountFormatter, "accountFormatter");
        boolean z = false;
        CommunityPresentationModel a;
        if (searchResultItem instanceof SubredditSearchResultItem) {
            Subreddit subreddit = ((SubredditSearchResultItem) searchResultItem).getSubreddit();
            SubredditMapper subredditMapper = SubredditMapper.f20341a;
            a = SubredditMapper.m22680a(CommunityPresentationModelType.f20484b, CommunityPresentationSection.f20487a, subreddit);
            searchResultItem = m23194b(searchResultItem, resourceProvider, numberFormatter, accountFormatter);
            resourceProvider = subreddit.getUserIsSubscriber();
            if (resourceProvider != null) {
                z = resourceProvider.booleanValue();
            }
            return new SearchItemPresentationModel(a, searchResultItem, z);
        } else if (searchResultItem instanceof AccountSearchResultItem) {
            Account account = ((AccountSearchResultItem) searchResultItem).getAccount();
            AccountMapper accountMapper = AccountMapper.f21543a;
            a = AccountMapper.m23603b(account);
            searchResultItem = m23194b(searchResultItem, resourceProvider, numberFormatter, accountFormatter);
            resourceProvider = account.getSubreddit();
            if (resourceProvider == null) {
                Intrinsics.m26842a();
            }
            resourceProvider = resourceProvider.getUserIsSubscriber();
            if (resourceProvider != null) {
                z = resourceProvider.booleanValue();
            }
            return new SearchItemPresentationModel(a, searchResultItem, z);
        } else {
            throw ((Throwable) new IllegalStateException("Unhandled search result item type"));
        }
    }

    private static String m23194b(SearchResultItem searchResultItem, ResourceProvider resourceProvider, NumberFormatter numberFormatter, AccountFormatter accountFormatter) {
        if (searchResultItem instanceof SubredditSearchResultItem) {
            return resourceProvider.mo4794a(C1761R.string.fmt_num_subscribers_simple, (Object[]) new String[]{numberFormatter.mo4823a(((SubredditSearchResultItem) searchResultItem).getSubreddit().getSubscribers())});
        } else if ((searchResultItem instanceof AccountSearchResultItem) != null) {
            searchResultItem = ((AccountSearchResultItem) searchResultItem).getAccount();
            numberFormatter = accountFormatter.mo4820b(searchResultItem);
            searchResultItem = accountFormatter.mo4818a(searchResultItem);
            return resourceProvider.mo4794a(C1761R.string.fmt_num_karma_simple, numberFormatter, searchResultItem);
        } else {
            throw ((Throwable) new IllegalStateException("Unhandled search result item type"));
        }
    }
}
