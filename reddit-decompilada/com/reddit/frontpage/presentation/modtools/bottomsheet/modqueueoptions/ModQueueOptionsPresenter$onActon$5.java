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
final class ModQueueOptionsPresenter$onActon$5<T> implements Consumer<ModToolsPostResponse> {
    final /* synthetic */ ModQueueOptionsPresenter f28608a;
    final /* synthetic */ List f28609b;
    final /* synthetic */ String f28610c;
    final /* synthetic */ Map f28611d;

    ModQueueOptionsPresenter$onActon$5(ModQueueOptionsPresenter modQueueOptionsPresenter, List list, String str, Map map) {
        this.f28608a = modQueueOptionsPresenter;
        this.f28609b = list;
        this.f28610c = str;
        this.f28611d = map;
    }

    public final /* synthetic */ void accept(Object obj) {
        for (Thing thing : this.f28609b) {
            ModQueueOptionsPresenter modQueueOptionsPresenter;
            String str;
            Object obj2;
            if (Intrinsics.m26845a(ThingUtil.a(thing.getName()), ThingType.a)) {
                ModUtil.m23823a(thing.getName()).m30450a(thing.getName(), Boolean.valueOf(true));
                modQueueOptionsPresenter = this.f28608a;
                str = ModNoun.f20053l.f20068M;
                obj2 = this.f28610c;
                Intrinsics.m26843a(obj2, "uniqueId");
                if (thing == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.requests.models.v1.Comment");
                }
                Comment comment = (Comment) thing;
                String str2 = (String) this.f28611d.get(thing);
                if (str2 == null) {
                    str2 = "";
                }
                modQueueOptionsPresenter.commentAnalytics(str, obj2, comment, str2);
            } else {
                ModUtil.m23824a().m30458d(thing.getName(), Boolean.valueOf(true));
                modQueueOptionsPresenter = this.f28608a;
                str = ModNoun.f20047f.f20068M;
                obj2 = this.f28610c;
                Intrinsics.m26843a(obj2, "uniqueId");
                if (thing == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink");
                }
                modQueueOptionsPresenter.postAnalytics(str, obj2, (ClientLink) thing);
            }
        }
        ModQueueOptionsPresenter.access$getModerateListener$p(this.f28608a).mo4891a();
        Screens.m22631a(this.f28608a.getView().getContext(), (int) C1761R.string.success_post_removed_spam);
    }
}
