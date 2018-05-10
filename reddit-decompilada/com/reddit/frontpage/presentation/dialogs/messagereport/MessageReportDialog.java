package com.reddit.frontpage.presentation.dialogs.messagereport;

import android.app.Dialog;
import android.content.Context;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerThingReportComponent;
import com.reddit.frontpage.di.module.ThingReportModule;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.dialogs.BaseThingReportDialog;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ8\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/presentation/dialogs/messagereport/MessageReportDialog;", "Lcom/reddit/frontpage/presentation/dialogs/BaseThingReportDialog;", "context", "Landroid/content/Context;", "blockUsername", "", "title", "thing", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "onLinkReported", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;Lkotlin/jvm/functions/Function0;)V", "getContext", "()Landroid/content/Context;", "screen", "Lcom/reddit/frontpage/nav/Screen;", "getScreen", "()Lcom/reddit/frontpage/nav/Screen;", "mainDialog", "Landroid/app/Dialog;", "username", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MessageReportDialog.kt */
public final class MessageReportDialog extends BaseThingReportDialog {
    public static final Companion f33852f = new Companion();
    private final Screen f33853g;
    private final Context f33854h;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/presentation/dialogs/messagereport/MessageReportDialog$Companion;", "", "()V", "REASON", "", "createReportMessageDialog", "Lcom/reddit/frontpage/presentation/dialogs/messagereport/MessageReportDialog;", "context", "Landroid/content/Context;", "blockUsername", "title", "thing", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "onLinkReported", "Lkotlin/Function0;", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: MessageReportDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public static MessageReportDialog m22830a(Context context, String str, String str2, Thing thing) {
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(str, "blockUsername");
            Intrinsics.m26847b(str2, "title");
            Intrinsics.m26847b(thing, "thing");
            return new MessageReportDialog(context, str, str2, thing);
        }
    }

    public static final MessageReportDialog m34668a(Context context, String str, String str2, Thing thing) {
        return Companion.m22830a(context, str, str2, thing);
    }

    public final Context aa_() {
        return this.f33854h;
    }

    public MessageReportDialog(Context context, String str, String str2, Thing thing) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(str, "blockUsername");
        Intrinsics.m26847b(str2, "title");
        Intrinsics.m26847b(thing, "thing");
        this.f33854h = context;
        Object a = Routing.m22617a(this.f33854h);
        Intrinsics.m26843a(a, "Routing.getCurrentScreen(context)");
        this.f33853g = a;
        DaggerThingReportComponent.m29281a().m22161a(FrontpageApplication.m28875k()).m22162a(new ThingReportModule(this)).m22163a().mo4742a(this);
        context = this.f33854h;
        Object stringArray = context.getResources().getStringArray(C1761R.array.report_message);
        Intrinsics.m26843a(stringArray, "reasons");
        context = m29505a(context, str2, null, stringArray, m29507a(str2, str, context, null, thing, "change_this_when_needed", "", stringArray, null));
        Object f = Util.m24027f((int) C1761R.string.action_cancel);
        Intrinsics.m26843a(f, "Util.getString(R.string.action_cancel)");
        m29509a((String) f);
        m29508a((Dialog) context);
    }

    public final Screen mo6458e() {
        return this.f33853g;
    }
}
