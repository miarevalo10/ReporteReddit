package com.reddit.frontpage.presentation.dialogs;

import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.commons.analytics.builders.CustomReasonsNoun;
import com.reddit.frontpage.commons.analytics.builders.CustomReportEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.CustomReportEventBuilder.Companion;
import com.reddit.frontpage.ui.listener.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: BaseThingReportDialog.kt */
final class C2296x606748bc<T> implements Consumer<String> {
    final /* synthetic */ BaseThingReportDialog$getSendReportWithPostActionConsumable$1 f28178a;

    C2296x606748bc(BaseThingReportDialog$getSendReportWithPostActionConsumable$1 baseThingReportDialog$getSendReportWithPostActionConsumable$1) {
        this.f28178a = baseThingReportDialog$getSendReportWithPostActionConsumable$1;
    }

    public final /* synthetic */ void mo4813a(Object obj) {
        this.f28178a.f28179a.m29511b().m34667a(this.f28178a.f28188j);
        if ((this.f28178a.f28183e instanceof Link) != null) {
            obj = CustomReportEventBuilder.f27449a;
            Companion.m21899a((Link) this.f28178a.f28183e, "post_report", "click", CustomReasonsNoun.f20025j.f20028l);
            return;
        }
        if (!((this.f28178a.f28183e instanceof Comment) == null || this.f28178a.f28187i == null)) {
            obj = CustomReportEventBuilder.f27449a;
            Companion.m21897a((Comment) this.f28178a.f28183e, this.f28178a.f28187i, "comment_report", "click", CustomReasonsNoun.f20025j.f20028l);
        }
    }
}
