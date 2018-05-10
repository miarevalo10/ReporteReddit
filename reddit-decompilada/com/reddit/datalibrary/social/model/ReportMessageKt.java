package com.reddit.datalibrary.social.model;

import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.social.presentation.presentationobjects.AdminMessageData;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.ImageFileMessageData;
import com.reddit.social.presentation.presentationobjects.RedditImageContentMessageData;
import com.reddit.social.presentation.presentationobjects.RedditVideoContentMessageData;
import com.reddit.social.presentation.presentationobjects.TextMessageData;
import com.reddit.social.presentation.presentationobjects.VideoFileMessageData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"getMessageReportFrom", "Lcom/reddit/datalibrary/social/model/ReportMessage;", "message", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: ReportMessage.kt */
public final class ReportMessageKt {
    public static final ReportMessage getMessageReportFrom(HasMessageData hasMessageData) {
        String str;
        String str2;
        RedditVideoContentMessageData redditVideoContentMessageData;
        ImageResolution imageResolution;
        RedditImageContentMessageData redditImageContentMessageData;
        Intrinsics.m26847b(hasMessageData, "message");
        String str3 = hasMessageData.mo5204a().f22438k;
        long j = hasMessageData.mo5204a().f22430c;
        long j2 = hasMessageData.mo5204a().f22429b;
        String str4 = hasMessageData.mo5204a().f22431d;
        String str5 = hasMessageData.mo5204a().f22432e;
        String str6 = hasMessageData.mo5204a().f22439l;
        String str7 = hasMessageData.mo5204a().f22440m;
        if (hasMessageData instanceof AdminMessageData) {
            str = ((AdminMessageData) hasMessageData).f29924a;
        } else if (hasMessageData instanceof TextMessageData) {
            str = ((TextMessageData) hasMessageData).f29964a;
        } else {
            str2 = null;
            if (hasMessageData instanceof ImageFileMessageData) {
                hasMessageData = ((ImageFileMessageData) hasMessageData).f29938b;
            } else if (hasMessageData instanceof VideoFileMessageData) {
                hasMessageData = ((VideoFileMessageData) hasMessageData).f29969b;
            } else if (hasMessageData instanceof RedditImageContentMessageData) {
                if (hasMessageData instanceof RedditVideoContentMessageData) {
                    redditVideoContentMessageData = (RedditVideoContentMessageData) hasMessageData;
                    imageResolution = redditVideoContentMessageData.f29956c;
                    if (imageResolution == null) {
                        imageResolution = redditVideoContentMessageData.f29955b;
                    }
                    if (imageResolution == null) {
                        imageResolution = redditVideoContentMessageData.f29954a;
                    }
                    if (imageResolution != null) {
                        hasMessageData = imageResolution.getUrl();
                    }
                }
                hasMessageData = null;
            } else {
                redditImageContentMessageData = (RedditImageContentMessageData) hasMessageData;
                str = redditImageContentMessageData.f29951e;
                if (str == null) {
                    str = redditImageContentMessageData.f29950d;
                }
                if (str == null) {
                    str = redditImageContentMessageData.f29949c;
                }
                hasMessageData = str;
            }
            return new ReportMessage(new ReportMessageFields(str3, j, j2, str4, str5, str6, str7, str2, hasMessageData));
        }
        str2 = str;
        if (hasMessageData instanceof ImageFileMessageData) {
            hasMessageData = ((ImageFileMessageData) hasMessageData).f29938b;
        } else if (hasMessageData instanceof VideoFileMessageData) {
            hasMessageData = ((VideoFileMessageData) hasMessageData).f29969b;
        } else if (hasMessageData instanceof RedditImageContentMessageData) {
            if (hasMessageData instanceof RedditVideoContentMessageData) {
                redditVideoContentMessageData = (RedditVideoContentMessageData) hasMessageData;
                imageResolution = redditVideoContentMessageData.f29956c;
                if (imageResolution == null) {
                    imageResolution = redditVideoContentMessageData.f29955b;
                }
                if (imageResolution == null) {
                    imageResolution = redditVideoContentMessageData.f29954a;
                }
                if (imageResolution != null) {
                    hasMessageData = imageResolution.getUrl();
                }
            }
            hasMessageData = null;
        } else {
            redditImageContentMessageData = (RedditImageContentMessageData) hasMessageData;
            str = redditImageContentMessageData.f29951e;
            if (str == null) {
                str = redditImageContentMessageData.f29950d;
            }
            if (str == null) {
                str = redditImageContentMessageData.f29949c;
            }
            hasMessageData = str;
        }
        return new ReportMessage(new ReportMessageFields(str3, j, j2, str4, str5, str6, str7, str2, hasMessageData));
    }
}
