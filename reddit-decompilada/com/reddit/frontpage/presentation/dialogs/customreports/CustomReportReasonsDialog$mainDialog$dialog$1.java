package com.reddit.frontpage.presentation.dialogs.customreports;

import android.content.Context;
import com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommunityRule;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.ui.listener.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: CustomReportReasonsDialog.kt */
final class CustomReportReasonsDialog$mainDialog$dialog$1<T> implements Consumer<Integer> {
    final /* synthetic */ CustomReportReasonsDialog f28217a;
    final /* synthetic */ Link f28218b;
    final /* synthetic */ String f28219c;
    final /* synthetic */ String f28220d;
    final /* synthetic */ Context f28221e;
    final /* synthetic */ Thing f28222f;
    final /* synthetic */ Function0 f28223g;

    CustomReportReasonsDialog$mainDialog$dialog$1(CustomReportReasonsDialog customReportReasonsDialog, Link link, String str, String str2, Context context, Thing thing, Function0 function0) {
        this.f28217a = customReportReasonsDialog;
        this.f28218b = link;
        this.f28219c = str;
        this.f28220d = str2;
        this.f28221e = context;
        this.f28222f = thing;
        this.f28223g = function0;
    }

    public final /* synthetic */ void mo4813a(Object obj) {
        Integer num = (Integer) obj;
        if (num != null) {
            if (num.intValue() == 0) {
                LinkListingProvider.a(this.f28218b.getSubreddit(), new Consumer<List<CommunityRule>>() {
                    public final /* synthetic */ void mo4813a(java.lang.Object r9) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r8 = this;
                        r9 = (java.util.List) r9;
                        r0 = r9.size();
                        r0 = new java.lang.String[r0];
                        r1 = "rulesList";
                        kotlin.jvm.internal.Intrinsics.m26843a(r9, r1);
                        r1 = r9;
                        r1 = (java.util.Collection) r1;
                        r1 = r1.size();
                        r2 = 0;
                        r3 = r2;
                    L_0x0016:
                        if (r3 >= r1) goto L_0x0027;
                    L_0x0018:
                        r4 = r9.get(r3);
                        r4 = (com.reddit.datalibrary.frontpage.requests.models.v1.CommunityRule) r4;
                        r4 = r4.getName();
                        r0[r3] = r4;
                        r3 = r3 + 1;
                        goto L_0x0016;
                    L_0x0027:
                        r0 = (java.lang.Object[]) r0;	 Catch:{ IllegalArgumentException -> 0x0030 }
                        r9 = kotlin.collections.ArraysKt___ArraysKt.m36113m(r0);	 Catch:{ IllegalArgumentException -> 0x0030 }
                        r9 = (java.lang.String[]) r9;	 Catch:{ IllegalArgumentException -> 0x0030 }
                        goto L_0x0032;
                    L_0x0030:
                        r9 = new java.lang.String[r2];
                    L_0x0032:
                        r6 = r9;
                        r9 = r9;
                        r0 = r9.f28217a;
                        r9 = r9;
                        r1 = r9.f28219c;
                        r9 = r9;
                        r2 = r9.f28220d;
                        r9 = r9;
                        r3 = r9.f28221e;
                        r9 = r9;
                        r4 = r9.f28218b;
                        r9 = r9;
                        r5 = r9.f28222f;
                        r9 = r9;
                        r7 = r9.f28223g;
                        r9 = com.reddit.frontpage.presentation.dialogs.customreports.CustomReportReasonsDialog.m34663a(r0, r1, r2, r3, r4, r5, r6, r7);
                        r9.m29514c();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.presentation.dialogs.customreports.CustomReportReasonsDialog.mainDialog.dialog.1.1.a(java.lang.Object):void");
                    }
                });
                return;
            }
        }
        if (num != null) {
            if (num.intValue() == 1) {
                CustomReportReasonsDialog.m34662a(this.f28217a, this.f28219c, this.f28220d, this.f28221e, this.f28218b, this.f28222f, this.f28223g).m29514c();
                return;
            }
        }
        if (num != null && num.intValue() == 2) {
            CustomReportReasonsDialog.m34660a(this.f28217a, this.f28219c, this.f28221e, this.f28218b, this.f28222f).m29514c();
        }
    }
}
