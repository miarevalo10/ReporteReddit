package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.BasePresenter;
import com.reddit.frontpage.presentation.communities.model.CommunityListItem;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModelType;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection;
import com.reddit.frontpage.presentation.listing.common.ListingView;
import com.reddit.frontpage.util.Util;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u0000 \u00022\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesContract;", "", "Companion", "Presenter", "Section", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitiesContract.kt */
public interface CommunitiesContract {
    public static final Companion f20439a = Companion.f20438a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Companion;", "", "()V", "DEFAULT_ID", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitiesContract.kt */
    public static final class Companion {
        static final /* synthetic */ Companion f20438a = new Companion();

        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "Lcom/reddit/frontpage/presentation/carousel/ListingCarouselActions;", "areCommunitiesTheSame", "", "first", "Lcom/reddit/frontpage/presentation/communities/model/CommunityListItem;", "second", "areCommunityContentsTheSame", "onCommunityClicked", "", "item", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "onFavoriteClicked", "onSectionClicked", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    public interface Presenter extends BasePresenter {
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Section;", "", "Lcom/reddit/frontpage/presentation/communities/CollapseSection;", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "(Ljava/lang/String;I)V", "REDDIT_PICKS", "MULTIS", "FAVORITES", "FOLLOWING", "SUBSCRIPTIONS", "MODERATING", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitiesContract.kt */
    public enum Section implements CollapseSection<CommunityPresentationModel> {
        ;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Section$FAVORITES;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Section;", "(Ljava/lang/String;I)V", "collapseItem", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "getCollapseItem", "()Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "expandItem", "getExpandItem", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: CommunitiesContract.kt */
        static final class FAVORITES extends Section {
            private final CommunityPresentationModel f33793g;
            private final CommunityPresentationModel f33794h;

            FAVORITES(String str) {
                super(str, 2);
                CommunityPresentationModelType communityPresentationModelType = CommunityPresentationModelType.f20483a;
                String f = Util.m24027f((int) C1761R.string.communities_section_favorited_expand_name);
                CommunityPresentationSection communityPresentationSection = CommunityPresentationSection.f20490d;
                com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion companion = CommunityPresentationModel.f20468o;
                this.f33793g = new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType, communityPresentationSection, f, null, null, null, null, null, null, null, false, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion.m22800a(String.valueOf(CommunityPresentationSection.f20490d.ordinal()), new String[0]), false, 12272);
                CommunityPresentationModelType communityPresentationModelType2 = CommunityPresentationModelType.f20483a;
                String f2 = Util.m24027f((int) C1761R.string.communities_section_favorited_collapse_name);
                CommunityPresentationSection communityPresentationSection2 = CommunityPresentationSection.f20490d;
                companion = CommunityPresentationModel.f20468o;
                this.f33794h = new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType2, communityPresentationSection2, f2, null, null, null, null, null, null, null, false, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion.m22800a(String.valueOf(CommunityPresentationSection.f20490d.ordinal()), new String[0]), false, 12272);
            }

            public final /* bridge */ /* synthetic */ Object mo6450a() {
                return this.f33793g;
            }

            public final /* bridge */ /* synthetic */ Object mo6451b() {
                return this.f33794h;
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Section$FOLLOWING;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Section;", "(Ljava/lang/String;I)V", "collapseItem", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "getCollapseItem", "()Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "expandItem", "getExpandItem", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: CommunitiesContract.kt */
        static final class FOLLOWING extends Section {
            private final CommunityPresentationModel f33795g;
            private final CommunityPresentationModel f33796h;

            FOLLOWING(String str) {
                super(str, 3);
                CommunityPresentationModelType communityPresentationModelType = CommunityPresentationModelType.f20483a;
                String f = Util.m24027f((int) C1761R.string.communities_section_following_expand_name);
                CommunityPresentationSection communityPresentationSection = CommunityPresentationSection.f20491e;
                com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion companion = CommunityPresentationModel.f20468o;
                this.f33795g = new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType, communityPresentationSection, f, null, null, null, null, null, null, null, false, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion.m22800a(String.valueOf(CommunityPresentationSection.f20491e.ordinal()), new String[0]), false, 12272);
                CommunityPresentationModelType communityPresentationModelType2 = CommunityPresentationModelType.f20483a;
                String f2 = Util.m24027f((int) C1761R.string.communities_section_following_collapse_name);
                CommunityPresentationSection communityPresentationSection2 = CommunityPresentationSection.f20491e;
                companion = CommunityPresentationModel.f20468o;
                this.f33796h = new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType2, communityPresentationSection2, f2, null, null, null, null, null, null, null, false, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion.m22800a(String.valueOf(CommunityPresentationSection.f20491e.ordinal()), new String[0]), false, 12272);
            }

            public final /* bridge */ /* synthetic */ Object mo6450a() {
                return this.f33795g;
            }

            public final /* bridge */ /* synthetic */ Object mo6451b() {
                return this.f33796h;
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Section$MODERATING;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Section;", "(Ljava/lang/String;I)V", "collapseItem", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "getCollapseItem", "()Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "expandItem", "getExpandItem", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: CommunitiesContract.kt */
        static final class MODERATING extends Section {
            private final CommunityPresentationModel f33797g;
            private final CommunityPresentationModel f33798h;

            MODERATING(String str) {
                super(str, 5);
                CommunityPresentationModelType communityPresentationModelType = CommunityPresentationModelType.f20483a;
                String f = Util.m24027f((int) C1761R.string.communities_section_moderating_expand_name);
                CommunityPresentationSection communityPresentationSection = CommunityPresentationSection.f20493g;
                com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion companion = CommunityPresentationModel.f20468o;
                this.f33797g = new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType, communityPresentationSection, f, null, null, null, null, null, null, null, false, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion.m22800a(String.valueOf(CommunityPresentationSection.f20493g.ordinal()), new String[0]), false, 12272);
                CommunityPresentationModelType communityPresentationModelType2 = CommunityPresentationModelType.f20483a;
                String f2 = Util.m24027f((int) C1761R.string.communities_section_moderating_collapse_name);
                CommunityPresentationSection communityPresentationSection2 = CommunityPresentationSection.f20493g;
                companion = CommunityPresentationModel.f20468o;
                this.f33798h = new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType2, communityPresentationSection2, f2, null, null, null, null, null, null, null, false, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion.m22800a(String.valueOf(CommunityPresentationSection.f20493g.ordinal()), new String[0]), false, 12272);
            }

            public final /* bridge */ /* synthetic */ Object mo6450a() {
                return this.f33797g;
            }

            public final /* bridge */ /* synthetic */ Object mo6451b() {
                return this.f33798h;
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Section$MULTIS;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Section;", "(Ljava/lang/String;I)V", "collapseItem", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "getCollapseItem", "()Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "expandItem", "getExpandItem", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: CommunitiesContract.kt */
        static final class MULTIS extends Section {
            private final CommunityPresentationModel f33799g;
            private final CommunityPresentationModel f33800h;

            MULTIS(String str) {
                super(str, 1);
                CommunityPresentationModelType communityPresentationModelType = CommunityPresentationModelType.f20483a;
                String f = Util.m24027f((int) C1761R.string.communities_section_multis_expand_name);
                CommunityPresentationSection communityPresentationSection = CommunityPresentationSection.f20489c;
                com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion companion = CommunityPresentationModel.f20468o;
                this.f33799g = new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType, communityPresentationSection, f, null, null, null, null, null, null, null, false, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion.m22800a(String.valueOf(CommunityPresentationSection.f20489c.ordinal()), new String[0]), false, 12272);
                CommunityPresentationModelType communityPresentationModelType2 = CommunityPresentationModelType.f20483a;
                String f2 = Util.m24027f((int) C1761R.string.communities_section_multis_collapse_name);
                CommunityPresentationSection communityPresentationSection2 = CommunityPresentationSection.f20489c;
                companion = CommunityPresentationModel.f20468o;
                this.f33800h = new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType2, communityPresentationSection2, f2, null, null, null, null, null, null, null, false, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion.m22800a(String.valueOf(CommunityPresentationSection.f20489c.ordinal()), new String[0]), false, 12272);
            }

            public final /* bridge */ /* synthetic */ Object mo6450a() {
                return this.f33799g;
            }

            public final /* bridge */ /* synthetic */ Object mo6451b() {
                return this.f33800h;
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Section$REDDIT_PICKS;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Section;", "(Ljava/lang/String;I)V", "collapseItem", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "getCollapseItem", "()Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "expandItem", "getExpandItem", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: CommunitiesContract.kt */
        static final class REDDIT_PICKS extends Section {
            private final CommunityPresentationModel f33801g;
            private final CommunityPresentationModel f33802h;

            REDDIT_PICKS(String str) {
                super(str, 0);
                CommunityPresentationModelType communityPresentationModelType = CommunityPresentationModelType.f20483a;
                String f = Util.m24027f((int) C1761R.string.communities_section_reddit_picks_expand_name);
                CommunityPresentationSection communityPresentationSection = CommunityPresentationSection.f20488b;
                com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion companion = CommunityPresentationModel.f20468o;
                CommunityPresentationModel communityPresentationModel = r2;
                CommunityPresentationModel communityPresentationModel2 = new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType, communityPresentationSection, f, null, null, null, null, null, null, null, false, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion.m22800a(String.valueOf(CommunityPresentationSection.f20488b.ordinal()), new String[0]), false, 12272);
                this.f33801g = communityPresentationModel;
                CommunityPresentationModelType communityPresentationModelType2 = CommunityPresentationModelType.f20483a;
                String f2 = Util.m24027f((int) C1761R.string.communities_section_reddit_picks_collapse_name);
                CommunityPresentationSection communityPresentationSection2 = CommunityPresentationSection.f20488b;
                companion = CommunityPresentationModel.f20468o;
                this.f33802h = new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType2, communityPresentationSection2, f2, null, null, null, null, null, null, null, false, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion.m22800a(String.valueOf(CommunityPresentationSection.f20488b.ordinal()), new String[0]), false, 12272);
            }

            public final /* bridge */ /* synthetic */ Object mo6450a() {
                return this.f33801g;
            }

            public final /* bridge */ /* synthetic */ Object mo6451b() {
                return this.f33802h;
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Section$SUBSCRIPTIONS;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Section;", "(Ljava/lang/String;I)V", "collapseItem", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "getCollapseItem", "()Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "expandItem", "getExpandItem", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: CommunitiesContract.kt */
        static final class SUBSCRIPTIONS extends Section {
            private final CommunityPresentationModel f33803g;
            private final CommunityPresentationModel f33804h;

            SUBSCRIPTIONS(String str) {
                super(str, 4);
                CommunityPresentationModelType communityPresentationModelType = CommunityPresentationModelType.f20483a;
                String f = Util.m24027f((int) C1761R.string.communities_section_subscriptions_expand_name);
                CommunityPresentationSection communityPresentationSection = CommunityPresentationSection.f20492f;
                com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion companion = CommunityPresentationModel.f20468o;
                this.f33803g = new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType, communityPresentationSection, f, null, null, null, null, null, null, null, false, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion.m22800a(String.valueOf(CommunityPresentationSection.f20492f.ordinal()), new String[0]), false, 12272);
                CommunityPresentationModelType communityPresentationModelType2 = CommunityPresentationModelType.f20483a;
                String f2 = Util.m24027f((int) C1761R.string.communities_section_subscriptions_collapse_name);
                CommunityPresentationSection communityPresentationSection2 = CommunityPresentationSection.f20492f;
                companion = CommunityPresentationModel.f20468o;
                this.f33804h = new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType2, communityPresentationSection2, f2, null, null, null, null, null, null, null, false, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion.m22800a(String.valueOf(CommunityPresentationSection.f20492f.ordinal()), new String[0]), false, 12272);
            }

            public final /* bridge */ /* synthetic */ Object mo6450a() {
                return this.f33803g;
            }

            public final /* bridge */ /* synthetic */ Object mo6451b() {
                return this.f33804h;
            }
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH&J\b\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\bH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\nH&R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$View;", "Lcom/reddit/frontpage/presentation/listing/common/ListingView;", "Lcom/reddit/frontpage/presentation/communities/model/CommunityListItem;", "username", "", "getUsername", "()Ljava/lang/String;", "diffAndSetItems", "", "communities", "", "disableFastScroll", "enableFastScroll", "getOldListItems", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitiesContract.kt */
    public interface View extends ListingView<CommunityListItem> {
        void mo7326a(List<? extends CommunityListItem> list);

        void mo7327b();

        void mo7331c();

        List<CommunityListItem> mo7332d();

        String r_();
    }
}
