package com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions;

import com.reddit.common.ThingType;
import com.reddit.common.ThingUtil;
import com.reddit.datalibrary.frontpage.data.model.ModToolsPostResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.util.ModUtil;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsPostResponse;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModQueueOptionsPresenter.kt */
final class ModQueueOptionsPresenter$onActon$1<T> implements Consumer<ModToolsPostResponse> {
    final /* synthetic */ ModQueueOptionsPresenter f28598a;
    final /* synthetic */ List f28599b;
    final /* synthetic */ String f28600c;
    final /* synthetic */ Map f28601d;

    ModQueueOptionsPresenter$onActon$1(ModQueueOptionsPresenter modQueueOptionsPresenter, List list, String str, Map map) {
        this.f28598a = modQueueOptionsPresenter;
        this.f28599b = list;
        this.f28600c = str;
        this.f28601d = map;
    }

    public final /* synthetic */ void accept(Object obj) {
        for (Thing thing : this.f28599b) {
            ModQueueOptionsPresenter modQueueOptionsPresenter;
            String str;
            Object obj2;
            if (Intrinsics.m26845a(ThingUtil.a(thing.getName()), ThingType.a)) {
                ModUtil.m23823a(thing.getName()).cacheApprovedState(thing.getName(), Boolean.valueOf(true));
                modQueueOptionsPresenter = this.f28598a;
                str = ModNoun.f20051j.f20068M;
                obj2 = this.f28600c;
                Intrinsics.m26843a(obj2, "uniqueId");
                if (thing == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.requests.models.v1.Comment");
                }
                Comment comment = (Comment) thing;
                String str2 = (String) this.f28601d.get(thing);
                if (str2 == null) {
                    str2 = "";
                }
                modQueueOptionsPresenter.commentAnalytics(str, obj2, comment, str2);
            } else {
                ModUtil.m23824a().cacheApprovedState(thing.getName(), Boolean.valueOf(true));
                modQueueOptionsPresenter = this.f28598a;
                str = ModNoun.f20045d.f20068M;
                obj2 = this.f28600c;
                Intrinsics.m26843a(obj2, "uniqueId");
                if (thing == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink");
                }
                modQueueOptionsPresenter.postAnalytics(str, obj2, (ClientLink) thing);
            }
        }
        ModQueueOptionsPresenter.access$getModerateListener$p(this.f28598a).mo4891a();
        Screens.m22631a(this.f28598a.getView().getContext(), (int) C1761R.string.success_post_approved);
    }
}
