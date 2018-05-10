package com.reddit.frontpage.commons.analytics.builders;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/builders/CustomReasonsNoun;", "", "actionName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getActionName", "()Ljava/lang/String;", "MENU", "POST_REPORT", "SAVE", "UNSAVE", "HIDE", "RULE_TYPE_CANCEL", "RULE_BACK", "RULE_TARGET_BACK", "RULE_CONTAINS_BACK", "BLOCK", "COMMENT_REPORT", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CustomReportEventBuilder.kt */
public enum CustomReasonsNoun {
    ;
    
    public final String f20028l;

    private CustomReasonsNoun(String str) {
        Intrinsics.m26847b(str, "actionName");
        this.f20028l = str;
    }
}
