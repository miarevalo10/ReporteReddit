package com.reddit.frontpage.commons.analytics.builders;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006-"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/builders/ModNoun;", "", "actionName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getActionName", "()Ljava/lang/String;", "ENTER_MOD_MODE", "EXIT_MOD_MODE", "MOD_TOOLS_MENU", "APPROVE_LINK", "REMOVE_LINK", "SPAM_LINK", "DISTINGUISH_POST", "UNDISTINGUISH_POST", "CHANGE_POST_FLAIR", "APPROVE_COMMENT", "REMOVE_COMMENT", "SPAM_COMMENT", "DISTINGUISH_COMMENT", "DISTINGUISH_STICKY_COMMENT", "UNDISTINGUISH_COMMENT", "ADD_BANPAGE", "EDIT_SAVE", "REMOVE_BANPAGE", "SEE_DETAILS", "BAN_DIALOG_BANPAGE", "EDIT_USER", "ADD_MUTEPAGE", "REMOVE_MUTEPAGE", "MUTE_DIALOG_MUTEPAGE", "MORE_DETAIL", "ADD", "REMOVE", "ADD_APPROVED_SUBMITTER", "OPEN_INVITE_DIALOG", "INVITE_MODERATOR", "EDIT", "PERMISSION", "ACCEPT_INVITE", "DECLINE_INVITE", "BAN_DIALOG_IN_CONTEXT", "REMOVE_IN_CONTEXT", "ADD_IN_CONTEXT", "MOD_MAIL", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModEventBuilder.kt */
public enum ModNoun {
    ;
    
    public final String f20068M;

    private ModNoun(String str) {
        Intrinsics.m26847b(str, "actionName");
        this.f20068M = str;
    }
}
