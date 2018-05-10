package com.reddit.frontpage.commons.analytics.builders;

import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/builders/CustomReportEventBuilder;", "Lcom/reddit/frontpage/commons/analytics/builders/BaseEventBuilder;", "()V", "prepareAnalytics", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CustomReportEventBuilder.kt */
public final class CustomReportEventBuilder extends BaseEventBuilder<CustomReportEventBuilder> {
    public static final Companion f27449a = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J(\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J(\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/builders/CustomReportEventBuilder$Companion;", "", "()V", "ACTION_CLICK", "", "SOURCE_COMMENT_OVERFLOW", "SOURCE_COMMENT_REPORT", "SOURCE_POST_OVERFLOW", "SOURCE_POST_REPORT", "sendEvent", "", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "parentLink", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "source", "action", "noun", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CustomReportEventBuilder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static void m21900a(LinkPresentationModel linkPresentationModel, String str, String str2, String str3) {
            Intrinsics.m26847b(linkPresentationModel, "link");
            Intrinsics.m26847b(str, "source");
            Intrinsics.m26847b(str2, "action");
            Intrinsics.m26847b(str3, "noun");
            ((CustomReportEventBuilder) ((CustomReportEventBuilder) ((CustomReportEventBuilder) ((CustomReportEventBuilder) ((CustomReportEventBuilder) AppAnalytics.m21881r().m21888a(str)).m21892b(str2)).m21895c(str3)).m21889a(linkPresentationModel.ag, linkPresentationModel.af)).m21890a(linkPresentationModel.getName(), AppAnalytics.m21848a(linkPresentationModel.getListableType()).name(), linkPresentationModel.f33999z)).m21891a();
        }

        public static void m21898a(Comment comment, String str, String str2, String str3) {
            Intrinsics.m26847b(comment, "comment");
            Intrinsics.m26847b(str, "source");
            Intrinsics.m26847b(str2, "action");
            Intrinsics.m26847b(str3, "noun");
            CustomReportEventBuilder customReportEventBuilder = (CustomReportEventBuilder) ((CustomReportEventBuilder) ((CustomReportEventBuilder) AppAnalytics.m21881r().m21888a(str)).m21892b(str2)).m21895c(str3);
            Object i = comment.i();
            Intrinsics.m26843a(i, "comment.subredditId");
            Object h = comment.h();
            Intrinsics.m26843a(h, "comment.subreddit");
            customReportEventBuilder = (CustomReportEventBuilder) customReportEventBuilder.m21889a(i, h);
            str2 = comment.getName();
            Object j = comment.j();
            Intrinsics.m26843a(j, "comment.linkId");
            ((CustomReportEventBuilder) customReportEventBuilder.m21893b(str2, j)).m21891a();
        }

        public static void m21897a(Comment comment, Link link, String str, String str2, String str3) {
            Intrinsics.m26847b(comment, "comment");
            Intrinsics.m26847b(link, "parentLink");
            Intrinsics.m26847b(str, "source");
            Intrinsics.m26847b(str2, "action");
            Intrinsics.m26847b(str3, "noun");
            CustomReportEventBuilder customReportEventBuilder = (CustomReportEventBuilder) ((CustomReportEventBuilder) ((CustomReportEventBuilder) AppAnalytics.m21881r().m21888a(str)).m21892b(str2)).m21895c(str3);
            Object i = comment.i();
            Intrinsics.m26843a(i, "comment.subredditId");
            Object h = comment.h();
            Intrinsics.m26843a(h, "comment.subreddit");
            customReportEventBuilder = (CustomReportEventBuilder) customReportEventBuilder.m21889a(i, h);
            str2 = link.getName();
            str3 = AppAnalytics.m21848a(link.getListableType()).name();
            Object title = link.getTitle();
            Intrinsics.m26843a(title, "parentLink.title");
            CustomReportEventBuilder customReportEventBuilder2 = (CustomReportEventBuilder) customReportEventBuilder.m21890a(str2, str3, title);
            str = comment.getName();
            Object j = comment.j();
            Intrinsics.m26843a(j, "comment.linkId");
            ((CustomReportEventBuilder) customReportEventBuilder2.m21893b(str, j)).m21891a();
        }

        public static void m21899a(Link link, String str, String str2, String str3) {
            Intrinsics.m26847b(link, "link");
            Intrinsics.m26847b(str, "source");
            Intrinsics.m26847b(str2, "action");
            Intrinsics.m26847b(str3, "noun");
            if (link.getSubredditDetail() != null) {
                Object subredditDetail = link.getSubredditDetail();
                Intrinsics.m26843a(subredditDetail, "link.subredditDetail");
                if (subredditDetail.b() != null) {
                    CustomReportEventBuilder customReportEventBuilder = (CustomReportEventBuilder) ((CustomReportEventBuilder) ((CustomReportEventBuilder) AppAnalytics.m21881r().m21888a(str)).m21892b(str2)).m21895c(str3);
                    str2 = link.getSubredditDetail().getName();
                    Object subredditDetail2 = link.getSubredditDetail();
                    Intrinsics.m26843a(subredditDetail2, "link.subredditDetail");
                    subredditDetail2 = subredditDetail2.b();
                    Intrinsics.m26843a(subredditDetail2, "link.subredditDetail.displayName");
                    customReportEventBuilder = (CustomReportEventBuilder) customReportEventBuilder.m21889a(str2, subredditDetail2);
                    str2 = link.getName();
                    str3 = AppAnalytics.m21848a(link.getListableType()).name();
                    Object title = link.getTitle();
                    Intrinsics.m26843a(title, "link.title");
                    ((CustomReportEventBuilder) customReportEventBuilder.m21890a(str2, str3, title)).m21891a();
                }
            }
        }
    }

    public static final void m28935a(Comment comment, Link link, String str, String str2, String str3) {
        Companion.m21897a(comment, link, str, str2, str3);
    }

    public static final void m28936a(Comment comment, String str, String str2, String str3) {
        Companion.m21898a(comment, str, str2, str3);
    }

    public static final void m28937a(Link link, String str, String str2, String str3) {
        Companion.m21899a(link, str, str2, str3);
    }

    public final void mo4573b() {
    }
}
