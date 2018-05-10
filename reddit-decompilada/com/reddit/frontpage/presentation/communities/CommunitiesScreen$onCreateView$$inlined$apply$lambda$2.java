package com.reddit.frontpage.presentation.communities;

import android.view.View;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollItemIndicator;
import com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollItemIndicator.Icon;
import com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollItemIndicator.Text;
import com.reddit.frontpage.presentation.communities.model.CommunityListItemPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.WhenMappings;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator;", "position", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesScreen.kt */
final class CommunitiesScreen$onCreateView$$inlined$apply$lambda$2 extends Lambda implements Function1<Integer, FastScrollItemIndicator> {
    final /* synthetic */ CommunitiesScreen f36449a;
    final /* synthetic */ View f36450b;

    CommunitiesScreen$onCreateView$$inlined$apply$lambda$2(CommunitiesScreen communitiesScreen, View view) {
        this.f36449a = communitiesScreen;
        this.f36450b = view;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = this.f36449a.m40556O().f28118a.get(((Number) obj).intValue());
        Object obj2 = null;
        if (!(obj instanceof CommunityListItemPresentationModel)) {
            obj = null;
        }
        CommunityListItemPresentationModel communityListItemPresentationModel = (CommunityListItemPresentationModel) obj;
        if (communityListItemPresentationModel != null) {
            obj = communityListItemPresentationModel.mo7150a();
            if (obj != null) {
                switch (WhenMappings.f20467a[obj.f20471c.ordinal()]) {
                    case 1:
                        String str = obj.f20473e;
                        if (str != null) {
                            if (obj.f20480l != null) {
                                str = null;
                            }
                            if (str != null) {
                                if (str == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                                obj = str.substring(null, 1);
                                Intrinsics.m26843a(obj, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                if (obj != null) {
                                    if (obj == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    obj = obj.toUpperCase();
                                    Intrinsics.m26843a(obj, "(this as java.lang.String).toUpperCase()");
                                    if (obj != null) {
                                        obj2 = new Text(obj);
                                    }
                                }
                            }
                        }
                        return (FastScrollItemIndicator) obj2;
                    case 2:
                        return null;
                    case 3:
                        return null;
                    case 4:
                        return null;
                    case 5:
                        return (FastScrollItemIndicator) new Icon(C1761R.drawable.ind_favorite);
                    case 6:
                        return null;
                    case 7:
                        return (FastScrollItemIndicator) new Icon(C1761R.drawable.ind_moderator);
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        }
        return null;
    }
}
