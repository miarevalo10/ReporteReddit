package com.reddit.frontpage.presentation.modtools.modqueue.modcommunities;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.communities.CollapseSection;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModelType;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection;
import com.reddit.frontpage.util.Util;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesContract;", "", "Presenter", "Section", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModCommunitiesContract.kt */
public interface ModCommunitiesContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003H&J\u0016\u0010\r\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesContract$View;", "", "username", "", "getUsername", "()Ljava/lang/String;", "diffAndSetCommunities", "", "communities", "", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "navigateToScreen", "name", "setCommunities", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModCommunitiesContract.kt */
    public interface View {
        String mo7395a();

        void mo7396a(String str);

        void mo7397a(List<CommunityPresentationModel> list);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesContract$Section;", "", "Lcom/reddit/frontpage/presentation/communities/CollapseSection;", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "(Ljava/lang/String;I)V", "Moderating", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModCommunitiesContract.kt */
    public enum Section implements CollapseSection<CommunityPresentationModel> {
        ;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesContract$Section$Moderating;", "Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesContract$Section;", "(Ljava/lang/String;I)V", "collapseItem", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "getCollapseItem", "()Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "expandItem", "getExpandItem", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: ModCommunitiesContract.kt */
        static final class Moderating extends Section {
            private final CommunityPresentationModel f34077b;
            private final CommunityPresentationModel f34078c;

            Moderating(String str) {
                super(str);
                CommunityPresentationModelType communityPresentationModelType = CommunityPresentationModelType.f20483a;
                String f = Util.m24027f((int) C1761R.string.title_moderating);
                CommunityPresentationSection communityPresentationSection = CommunityPresentationSection.f20493g;
                Companion companion = CommunityPresentationModel.f20468o;
                CommunityPresentationModel communityPresentationModel = r1;
                CommunityPresentationModel communityPresentationModel2 = new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType, communityPresentationSection, f, null, null, null, null, null, null, null, false, Companion.m22800a(String.valueOf(CommunityPresentationSection.f20493g.ordinal()), new String[0]), false, 12272);
                this.f34077b = communityPresentationModel;
                CommunityPresentationModelType communityPresentationModelType2 = CommunityPresentationModelType.f20483a;
                String f2 = Util.m24027f((int) C1761R.string.title_moderating);
                CommunityPresentationSection communityPresentationSection2 = CommunityPresentationSection.f20493g;
                Companion companion2 = CommunityPresentationModel.f20468o;
                this.f34078c = new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType2, communityPresentationSection2, f2, null, null, null, null, null, null, null, false, Companion.m22800a(String.valueOf(CommunityPresentationSection.f20493g.ordinal()), new String[0]), false, 12272);
            }

            public final /* bridge */ /* synthetic */ Object mo6450a() {
                return this.f34077b;
            }

            public final /* bridge */ /* synthetic */ Object mo6451b() {
                return this.f34078c;
            }
        }

        protected Section(String str) {
        }
    }
}
