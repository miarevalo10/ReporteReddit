package com.reddit.frontpage.presentation.dialogs.customreports;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerThingReportComponent;
import com.reddit.frontpage.di.module.ThingReportModule;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.dialogs.BaseThingReportDialog;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.util.Util;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 /2\u00020\u0001:\u0001/B?\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\u0010\u000eBC\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\u0010\u0015J(\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J]\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010#JA\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0002¢\u0006\u0002\u0010%JH\u0010&\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002JY\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002¢\u0006\u0002\u0010*J@\u0010+\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J@\u0010,\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002JS\u0010-\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002¢\u0006\u0002\u0010.R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00060"}, d2 = {"Lcom/reddit/frontpage/presentation/dialogs/customreports/CustomReportReasonsDialog;", "Lcom/reddit/frontpage/presentation/dialogs/BaseThingReportDialog;", "blockUsername", "", "title", "context", "Landroid/content/Context;", "parentLink", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "thing", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "onLinkReported", "Lkotlin/Function0;", "", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;Lkotlin/jvm/functions/Function0;)V", "rules", "", "selectRuleTitle", "onAction", "Lcom/reddit/frontpage/ui/listener/Consumer;", "", "(Ljava/lang/String;Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;Lcom/reddit/frontpage/ui/listener/Consumer;)V", "getContext", "()Landroid/content/Context;", "screen", "Lcom/reddit/frontpage/nav/Screen;", "getScreen", "()Lcom/reddit/frontpage/nav/Screen;", "copyrightDialog", "getBaseDialog", "Landroid/app/Dialog;", "selectRulesTitle", "onNext", "name", "currentLink", "(Ljava/lang/String;Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;Lcom/reddit/frontpage/ui/listener/Consumer;Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;)Landroid/app/Dialog;", "getSendReportWithComplaintConsumable", "(Ljava/lang/String;Landroid/content/Context;Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;[Ljava/lang/String;)Lcom/reddit/frontpage/ui/listener/Consumer;", "getTargetedAtDialog", "reason", "getWhichRedditRulesViolationConsumable", "rulesLevelOne", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;[Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lcom/reddit/frontpage/ui/listener/Consumer;", "mainDialog", "redditRulesDialog", "subreditRulesDialog", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;[Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lcom/reddit/frontpage/presentation/dialogs/customreports/CustomReportReasonsDialog;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CustomReportReasonsDialog.kt */
public final class CustomReportReasonsDialog extends BaseThingReportDialog {
    public static final Companion f33845f = new Companion();
    private final Screen f33846g;
    private final Context f33847h;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/presentation/dialogs/customreports/CustomReportReasonsDialog$Companion;", "", "()V", "REASON", "", "createCustomReportReasonsDialog", "Lcom/reddit/frontpage/presentation/dialogs/customreports/CustomReportReasonsDialog;", "blockUsername", "title", "context", "Landroid/content/Context;", "parentLink", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "thing", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "onLinkReported", "Lkotlin/Function0;", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CustomReportReasonsDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public static CustomReportReasonsDialog m22821a(String str, String str2, Context context, Link link, Thing thing, Function0<Unit> function0) {
            Intrinsics.m26847b(str, "blockUsername");
            Intrinsics.m26847b(str2, "title");
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(link, "parentLink");
            Intrinsics.m26847b(thing, "thing");
            return new CustomReportReasonsDialog(str, str2, context, link, thing, (Function0) function0);
        }
    }

    public final Screen mo6458e() {
        return this.f33846g;
    }

    public final Context aa_() {
        return this.f33847h;
    }

    public CustomReportReasonsDialog(String str, String str2, Context context, Link link, Thing thing, Function0<Unit> function0) {
        String subreddit;
        Context context2 = context;
        String str3 = str;
        Intrinsics.m26847b(str3, "blockUsername");
        String str4 = str2;
        Intrinsics.m26847b(str4, "title");
        Intrinsics.m26847b(context2, "context");
        Link link2 = link;
        Intrinsics.m26847b(link2, "parentLink");
        Thing thing2 = thing;
        Intrinsics.m26847b(thing2, "thing");
        DaggerThingReportComponent.m29281a().m22161a(FrontpageApplication.m28875k()).m22162a(new ThingReportModule(this)).m22163a().mo4741a(this);
        Object a = Routing.m22617a(context);
        Intrinsics.m26843a(a, "Routing.getCurrentScreen(context)");
        this.f33846g = a;
        this.f33847h = context2;
        Object stringArray = context.getResources().getStringArray(C1761R.array.report_custom_reasons);
        Intrinsics.m26843a(stringArray, "reasons");
        Consumer customReportReasonsDialog$mainDialog$dialog$1 = new CustomReportReasonsDialog$mainDialog$dialog$1(this, link2, str4, str3, context2, thing2, function0);
        if (link.getSubreddit() != null) {
            subreddit = link.getSubreddit();
            if (subreddit == null) {
                Intrinsics.m26842a();
            }
        } else {
            subreddit = "";
        }
        String str5 = subreddit;
        Intrinsics.m26843a((Object) str5, "if (parentLink.subreddit… {\n          \"\"\n        }");
        Dialog a2 = m34659a(str4, context2, (String[]) stringArray, null, customReportReasonsDialog$mainDialog$dialog$1, str5, link2, thing2);
        Object f = Util.m24027f((int) C1761R.string.action_cancel);
        Intrinsics.m26843a(f, "Util.getString(R.string.action_cancel)");
        m29509a((String) f);
        m29508a(a2);
    }

    public CustomReportReasonsDialog(String str, Context context, String[] strArr, String str2, Link link, Consumer<Integer> consumer) {
        String str3 = str;
        Intrinsics.m26847b(str3, "title");
        Context context2 = context;
        Intrinsics.m26847b(context2, "context");
        String[] strArr2 = strArr;
        Intrinsics.m26847b(strArr2, "rules");
        String str4 = str2;
        Intrinsics.m26847b(str4, "selectRuleTitle");
        Link link2 = link;
        Intrinsics.m26847b(link2, "parentLink");
        Consumer consumer2 = consumer;
        Intrinsics.m26847b(consumer2, "onAction");
        DaggerThingReportComponent.m29281a().m22161a(FrontpageApplication.m28875k()).m22162a(new ThingReportModule(this)).m22163a().mo4741a(this);
        Object a = Routing.m22617a(context2);
        Intrinsics.m26843a(a, "Routing.getCurrentScreen(context)");
        this.f33846g = a;
        Screen screen = this.f33846g;
        Activity am_ = screen != null ? screen.am_() : null;
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        r9.f33847h = am_;
        m29508a(m34659a(str3, context2, strArr2, str4, consumer2, "", link2, null));
    }

    private final Dialog m34659a(String str, Context context, String[] strArr, String str2, Consumer<Integer> consumer, String str3, Link link, Thing thing) {
        if (((((Object[]) strArr).length == 0 ? 1 : 0) ^ 1) != 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f25295a;
            Object format = String.format(strArr[0], Arrays.copyOf(new Object[]{str3}, 1));
            Intrinsics.m26843a(format, "java.lang.String.format(format, *args)");
            strArr[0] = format;
        }
        m29508a((Dialog) m29505a(context, str, str2, strArr, consumer));
        str = this.f28192b;
        if (str != null) {
            str.setOnClickListener((OnClickListener) new CustomReportReasonsDialog$getBaseDialog$1(thing, link));
        }
        return m29504a();
    }

    public static final /* synthetic */ CustomReportReasonsDialog m34663a(CustomReportReasonsDialog customReportReasonsDialog, String str, String str2, Context context, Link link, Thing thing, String[] strArr, Function0 function0) {
        Consumer a = customReportReasonsDialog.m29507a(str, str2, context, link, thing, null, null, strArr, function0);
        String a2 = Util.m23960a((int) C1761R.string.option_report_reason_community_rules, link.getSubreddit());
        Intrinsics.m26843a((Object) a2, "Util.getString(R.string.…es, parentLink.subreddit)");
        return new CustomReportReasonsDialog(str, context, strArr, a2, link, a);
    }

    public static final /* synthetic */ CustomReportReasonsDialog m34662a(CustomReportReasonsDialog customReportReasonsDialog, String str, String str2, Context context, Link link, Thing thing, Function0 function0) {
        Object stringArray = context.getResources().getStringArray(C1761R.array.report_reasons_new);
        Intrinsics.m26843a(stringArray, "rules");
        Link link2 = link;
        Consumer c2299xe2b475 = new C2299xe2b475(customReportReasonsDialog, str, str2, context, link2, thing, stringArray, function0);
        String f = Util.m24027f((int) C1761R.string.option_report_reason_which_issue);
        Intrinsics.m26843a((Object) f, "Util.getString(R.string.…eport_reason_which_issue)");
        CustomReportReasonsDialog customReportReasonsDialog2 = new CustomReportReasonsDialog(str, context, (String[]) stringArray, f, link2, c2299xe2b475);
        stringArray = Util.m24027f((int) C1761R.string.action_back);
        Intrinsics.m26843a(stringArray, "Util.getString(R.string.action_back)");
        customReportReasonsDialog2.m29509a((String) stringArray);
        return customReportReasonsDialog2;
    }

    public static final /* synthetic */ CustomReportReasonsDialog m34660a(CustomReportReasonsDialog customReportReasonsDialog, String str, Context context, Link link, Thing thing) {
        Object stringArray = context.getResources().getStringArray(C1761R.array.report_custom_reasons_copyright);
        Intrinsics.m26843a(stringArray, "rules");
        Consumer customReportReasonsDialog$getSendReportWithComplaintConsumable$1 = new CustomReportReasonsDialog$getSendReportWithComplaintConsumable$1(customReportReasonsDialog, stringArray, thing, link, str, context);
        String f = Util.m24027f((int) C1761R.string.option_report_reason_which_issue);
        Intrinsics.m26843a((Object) f, "Util.getString(R.string.…eport_reason_which_issue)");
        return new CustomReportReasonsDialog(str, context, (String[]) stringArray, f, link, customReportReasonsDialog$getSendReportWithComplaintConsumable$1);
    }

    public static final /* synthetic */ CustomReportReasonsDialog m34661a(CustomReportReasonsDialog customReportReasonsDialog, String str, String str2, Context context, Link link, Thing thing, String str3, Function0 function0) {
        Object stringArray = context.getResources().getStringArray(C1761R.array.report_reasons_targeted_at);
        Intrinsics.m26843a(stringArray, "otherReasons");
        String str4 = str;
        Consumer a = customReportReasonsDialog.m29507a(str4, str2, context, link, thing, "site_reason_selected", str3, stringArray, function0);
        String f = Util.m24027f((int) C1761R.string.option_report_reason_harassment_targeted_at);
        Intrinsics.m26843a((Object) f, "Util.getString(R.string.…n_harassment_targeted_at)");
        BaseThingReportDialog customReportReasonsDialog2 = new CustomReportReasonsDialog(str4, context, (String[]) stringArray, f, link, a);
        stringArray = Util.m24027f((int) C1761R.string.action_submit);
        Intrinsics.m26843a(stringArray, "Util.getString(R.string.action_submit)");
        Intrinsics.m26847b(stringArray, "text");
        Button button = customReportReasonsDialog2.f28193c;
        if (button != null) {
            button.setText((CharSequence) stringArray);
        }
        return customReportReasonsDialog2;
    }
}
