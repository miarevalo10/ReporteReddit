package com.reddit.frontpage.ui.alert;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.ColorStateList;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.birbit.android.jobqueue.JobManager;
import com.instabug.library.model.NetworkLog;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.datalibrary.frontpage.job.ReportJob;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.dialogs.customreports.CustomReportReasonsDialog;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ContextsKt;
import com.reddit.frontpage.util.kotlin.TextViewsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import io.reactivex.Single;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.anko.CustomViewPropertiesKt;
import org.jetbrains.anko.DimensionsKt;
import org.jetbrains.anko.Sdk21PropertiesKt;
import org.jetbrains.anko.ViewChildrenSequencesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\f\u0010\u0010\u001a\u00020\u0011*\u00020\u000eH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/ui/alert/RedditAlertDialog;", "", "context", "Landroid/content/Context;", "colorPositiveActionRed", "", "(Landroid/content/Context;Z)V", "getColorPositiveActionRed", "()Z", "dialogBuilder", "Landroid/support/v7/app/AlertDialog$Builder;", "getDialogBuilder", "()Landroid/support/v7/app/AlertDialog$Builder;", "create", "Landroid/support/v7/app/AlertDialog;", "show", "applyRedditButtonDesign", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditAlertDialog.kt */
public final class RedditAlertDialog {
    public static final Companion f21112b = new Companion();
    public final Builder f21113a;
    private final boolean f21114c;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0007J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0007J8\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0007J(\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0007JT\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\r2:\u0010\u0017\u001a6\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u0018j\u0002`\u001eH\u0007JL\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062:\u0010 \u001a6\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u0018j\u0002`\u001eH\u0007JL\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062:\u0010 \u001a6\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u0018j\u0002`\u001eH\u0007JT\u0010\"\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\b2:\u0010$\u001a6\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u0018j\u0002`\u001eH\u0007JL\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062:\u0010\u0017\u001a6\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u0018j\u0002`\u001eH\u0007JL\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062:\u0010\u0017\u001a6\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u0018j\u0002`\u001eH\u0007J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020(H\u0007Jv\u0010)\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2:\u0010\u0017\u001a6\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u0018j\u0002`\u001e2\b\b\u0002\u0010,\u001a\u00020-H\u0007JF\u0010\u001c\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u00010\r2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001304H\u0007JF\u0010\u001c\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\b2\u0006\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u00010\r2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001304H\u0007J\u0018\u00107\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00108\u001a\u00020\rH\u0007J\u0010\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020;H\u0007J\u0001\u0010<\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062:\u0010=\u001a6\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u0018j\u0002`\u001e2:\u0010>\u001a6\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u0018j\u0002`\u001eH\u0007J \u0010?\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020-H\u0007J2\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\r2\u0006\u0010D\u001a\u00020\r2\b\u0010E\u001a\u0004\u0018\u00010\r2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002J@\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\r2\u0006\u00105\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0007J&\u0010N\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\r2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007J&\u0010O\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\r2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007J.\u0010P\u001a\b\u0012\u0004\u0012\u00020\b0Q2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\r0S2\b\b\u0003\u00105\u001a\u00020\bH\u0007J\u0010\u0010T\u001a\u00020\u00132\u0006\u0010:\u001a\u00020;H\u0007J\u0010\u0010U\u001a\u00020\u00042\u0006\u0010:\u001a\u00020;H\u0007J(\u0010V\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u0018\u0010W\u001a\u00020\u00132\u0006\u0010:\u001a\u00020;2\u0006\u0010X\u001a\u00020YH\u0004JL\u0010Z\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062:\u0010[\u001a6\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u0018j\u0002`\u001eH\u0007¨\u0006\\"}, d2 = {"Lcom/reddit/frontpage/ui/alert/RedditAlertDialog$Companion;", "", "()V", "alert", "Lcom/reddit/frontpage/ui/alert/RedditAlertDialog;", "context", "Landroid/content/Context;", "iconRes", "", "titleRes", "messageRes", "subMessageRes", "titleText", "", "messageText", "subMessageText", "communityError", "onDialogClosed", "Lkotlin/Function0;", "", "communityWarning", "confirmBlockUser", "username", "positiveCallback", "Lkotlin/Function2;", "Landroid/content/DialogInterface;", "Lkotlin/ParameterName;", "name", "dialog", "which", "Lcom/reddit/frontpage/ui/alert/DialogOnClickListener;", "confirmDeleteComment", "deleteCallback", "confirmDeletePost", "confirmGiveGold", "creddits", "confirmCallback", "confirmInviteToGroup", "confirmLeaveGroup", "confirmModBlockUser", "Landroid/content/DialogInterface$OnClickListener;", "confirmModUserAction", "contentRes", "positiveText", "isDestructive", "", "Landroid/support/v7/app/AlertDialog;", "maxLength", "titleResId", "hintResId", "prefill", "onTextSubmitted", "Lkotlin/Function1;", "title", "hint", "displayTable", "tableHtml", "forceUpdate", "activity", "Landroid/app/Activity;", "modInviteDialog", "acceptCallback", "declineCallback", "progressDialog", "resId", "canCancel", "report", "kindWithId", "reason", "otherReason", "onLinkReported", "reportCustomReasonsDialogMain", "Lcom/reddit/frontpage/presentation/dialogs/customreports/CustomReportReasonsDialog;", "blockUsername", "parentLink", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "thing", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "reportDialog", "reportOtherDialog", "selector", "Lio/reactivex/Single;", "actions", "", "showNewUserAlertExperiment", "suggestUpdate", "suspendedUserAlert", "update", "appConfig", "Lcom/reddit/datalibrary/frontpage/requests/models/config/AppConfiguration;", "warnDataLoss", "leaveListener", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditAlertDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        private static RedditAlertDialog m23290a(Context context, int i, int i2, int i3, int i4) {
            Intrinsics.m26847b(context, "context");
            Object string = context.getResources().getString(i2);
            Object string2 = context.getResources().getString(i3);
            i4 = context.getResources().getString(i4);
            Intrinsics.m26843a(string, "title");
            Intrinsics.m26843a(string2, "message");
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(string, "titleText");
            Intrinsics.m26847b(string2, "messageText");
            View inflate = LayoutInflater.from(context).inflate(C1761R.layout.widget_alert_layout, null);
            ImageView imageView = (ImageView) inflate.findViewById(C1761R.id.icon);
            Object obj = (TextView) inflate.findViewById(C1761R.id.title);
            Object obj2 = (TextView) inflate.findViewById(C1761R.id.message);
            Object obj3 = (TextView) inflate.findViewById(C1761R.id.sub_message);
            Intrinsics.m26843a(obj2, "message");
            obj2.setText((CharSequence) string2);
            Intrinsics.m26843a(obj3, "subMessage");
            obj3.setText((CharSequence) i4);
            if (i4 == 0) {
                obj3.setVisibility(8);
            }
            imageView.setImageResource(i);
            Intrinsics.m26843a(obj, "title");
            obj.setText((CharSequence) string);
            i = new RedditAlertDialog(context);
            i.f21113a.a(inflate);
            return i;
        }

        public static RedditAlertDialog m23289a(Context context) {
            Intrinsics.m26847b(context, "context");
            context = m23290a(context, (int) C1761R.drawable.ic_user_banned, (int) C1761R.string.title_warning, (int) C1761R.string.account_suspended, (int) C1761R.string.error_message_cannot_vote);
            context.f21113a.a(C1761R.string.action_continue, null);
            return context;
        }

        public static RedditAlertDialog m23291a(Context context, int i, int i2, int i3, Function0<Unit> function0) {
            Intrinsics.m26847b(context, "context");
            context = m23290a(context, (int) C1761R.drawable.header_popup_private, i, i2, i3);
            if (function0 != null) {
                context.f21113a.a((OnDismissListener) new RedditAlertDialog$Companion$communityError$1$1$1(function0));
            }
            return context;
        }

        public static RedditAlertDialog m23296a(Context context, String str, Function0<Unit> function0) {
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(str, "kindWithId");
            Intrinsics.m26847b(function0, "onLinkReported");
            String[] stringArray = context.getResources().getStringArray(C1761R.array.report_reasons);
            RedditAlertDialog redditAlertDialog = new RedditAlertDialog(context, true);
            redditAlertDialog.f21113a.a(C1761R.string.action_report).a(new RedditAlertDialog$Companion$reportDialog$$inlined$apply$lambda$1(stringArray, context, str, function0));
            return redditAlertDialog;
        }

        public static CustomReportReasonsDialog m23287a(String str, String str2, Context context, Link link, Thing thing, Function0<Unit> function0) {
            Intrinsics.m26847b(str, "blockUsername");
            Intrinsics.m26847b(str2, "title");
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(link, "parentLink");
            Intrinsics.m26847b(thing, "thing");
            com.reddit.frontpage.presentation.dialogs.customreports.CustomReportReasonsDialog.Companion companion = CustomReportReasonsDialog.f33845f;
            return com.reddit.frontpage.presentation.dialogs.customreports.CustomReportReasonsDialog.Companion.m22821a(str, str2, context, link, thing, function0);
        }

        public static AlertDialog m23285a(Context context, int i, String str, String str2, String str3, Function1<? super String, Unit> function1) {
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(str, "title");
            Intrinsics.m26847b(str2, "hint");
            Intrinsics.m26847b(function1, "onTextSubmitted");
            View inflate = LayoutInflater.from(context).inflate(C1761R.layout.rdt_dialog_text_input_layout, null);
            Object obj = (EditText) inflate.findViewById(C1761R.id.dialog_text_input);
            Intrinsics.m26843a(obj, "inputView");
            InputFilter[] inputFilterArr = new InputFilter[1];
            i = 0;
            inputFilterArr[0] = new LengthFilter(i);
            obj.setFilters(inputFilterArr);
            CharSequence charSequence = str2;
            if ((charSequence.length() == 0 ? 1 : 0) == 0) {
                obj.setHint(charSequence);
            }
            CharSequence charSequence2 = str3;
            if (charSequence2 == null || charSequence2.length() == null) {
                i = 1;
            }
            if (i == 0) {
                obj.setText(charSequence2);
            }
            i = new RedditAlertDialog(context);
            i.f21113a.a(str).a(inflate).a(C1761R.string.action_okay, (OnClickListener) new RedditAlertDialog$Companion$dialog$$inlined$apply$lambda$1(str, inflate, function1, obj));
            context = i.m23324b();
            context.setOnShowListener((OnShowListener) new RedditAlertDialog$Companion$dialog$1(context));
            obj.addTextChangedListener((TextWatcher) new RedditAlertDialog$Companion$dialog$2(context, obj));
            return context;
        }

        public static Single<Integer> m23301a(Context context, Collection<String> collection, int i) {
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(collection, "actions");
            Object create = Single.create(new RedditAlertDialog$Companion$selector$1(context, collection, i));
            Intrinsics.m26843a(create, "Single.create { emitter …   builder.show()\n      }");
            return create;
        }

        public static RedditAlertDialog m23297a(Context context, String str, Function2<? super DialogInterface, ? super Integer, Unit> function2) {
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(str, "username");
            Intrinsics.m26847b(function2, "positiveCallback");
            RedditAlertDialog redditAlertDialog = new RedditAlertDialog(context, true);
            redditAlertDialog.f21113a.a(context.getString(C1761R.string.fmt_block_toast_title, new Object[]{str})).b(C1761R.string.prompt_confirm_block).b(C1761R.string.action_cancel, null).a(C1761R.string.action_block, (OnClickListener) new RedditAlertDialogKt$sam$OnClickListener$4ed99a24(function2));
            return redditAlertDialog;
        }

        public static RedditAlertDialog m23298a(Context context, Function2<? super DialogInterface, ? super Integer, Unit> function2) {
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(function2, "positiveCallback");
            RedditAlertDialog redditAlertDialog = new RedditAlertDialog(context, true);
            redditAlertDialog.f21113a.a(C1761R.string.leave_group_title).b(C1761R.string.prompt_confirm_leave_group).b(C1761R.string.action_cancel, null).a(C1761R.string.action_leave, new RedditAlertDialogKt$sam$OnClickListener$4ed99a24(function2));
            return redditAlertDialog;
        }

        public static RedditAlertDialog m23304b(Context context, Function2<? super DialogInterface, ? super Integer, Unit> function2) {
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(function2, "positiveCallback");
            RedditAlertDialog redditAlertDialog = new RedditAlertDialog(context);
            redditAlertDialog.f21113a.a(C1761R.string.add_to_group_title).b(C1761R.string.prompt_confirm_invite_to_group).b(C1761R.string.action_cancel, null).a(C1761R.string.action_okay, new RedditAlertDialogKt$sam$OnClickListener$4ed99a24(function2));
            return redditAlertDialog;
        }

        public static RedditAlertDialog m23293a(Context context, String str) {
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(str, "tableHtml");
            View inflate = LayoutInflater.from(context).inflate(C1761R.layout.fragment_community_info_wiki, null);
            Object obj = (WebView) inflate.findViewById(C1761R.id.web_view);
            obj.loadDataWithBaseURL("https://m.reddit.com", str, NetworkLog.HTML, "UTF-8", null);
            Intrinsics.m26843a(obj, "webView");
            obj.setWebViewClient((WebViewClient) new RedditAlertDialog$Companion$displayTable$1(context));
            str = new RedditAlertDialog(context);
            str.f21113a.a(inflate);
            return str;
        }

        public static RedditAlertDialog m23288a(Activity activity) {
            Intrinsics.m26847b(activity, "activity");
            Object a = FrontpageSettings.a();
            Intrinsics.m26843a(a, "FrontpageSettings.getInstance()");
            AppConfiguration t = a.t();
            RedditAlertDialog redditAlertDialog = new RedditAlertDialog(activity);
            redditAlertDialog.f21113a.a(C1761R.string.upgrade_dialog_title).b(t.global.app_version_check.popup_content).a(C1761R.string.upgrade_dialog_positive_button, new RedditAlertDialog$Companion$forceUpdate$$inlined$apply$lambda$1(t, activity)).a(new RedditAlertDialog$Companion$forceUpdate$$inlined$apply$lambda$2(t, activity));
            return redditAlertDialog;
        }

        public static RedditAlertDialog m23306c(Context context, Function2<? super DialogInterface, ? super Integer, Unit> function2) {
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(function2, "deleteCallback");
            RedditAlertDialog redditAlertDialog = new RedditAlertDialog(context, true);
            redditAlertDialog.f21113a.a(C1761R.string.dialog_delete_title).b(C1761R.string.dialog_delete_post_content).b(C1761R.string.action_cancel, null).a(C1761R.string.action_delete, new RedditAlertDialogKt$sam$OnClickListener$4ed99a24(function2));
            return redditAlertDialog;
        }

        public static RedditAlertDialog m23307d(Context context, Function2<? super DialogInterface, ? super Integer, Unit> function2) {
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(function2, "deleteCallback");
            RedditAlertDialog redditAlertDialog = new RedditAlertDialog(context, true);
            redditAlertDialog.f21113a.a(C1761R.string.dialog_delete_title).b(C1761R.string.dialog_delete_comment_content).b(C1761R.string.action_cancel, null).a(C1761R.string.action_delete, new RedditAlertDialogKt$sam$OnClickListener$4ed99a24(function2));
            return redditAlertDialog;
        }

        public static RedditAlertDialog m23292a(Context context, int i, Function2<? super DialogInterface, ? super Integer, Unit> function2) {
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(function2, "confirmCallback");
            RedditAlertDialog redditAlertDialog = new RedditAlertDialog(context);
            redditAlertDialog.f21113a.a(Util.m23959a((int) C1761R.plurals.fmt_title_creddits, i, Integer.valueOf(i))).b(C1761R.string.prompt_give_gold).b(C1761R.string.action_cancel, null).a(C1761R.string.action_give_gold, (OnClickListener) new RedditAlertDialogKt$sam$OnClickListener$4ed99a24(function2));
            return redditAlertDialog;
        }

        public static RedditAlertDialog m23295a(Context context, String str, int i, int i2, int i3, Function2<? super DialogInterface, ? super Integer, Unit> function2, boolean z) {
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(str, "username");
            Intrinsics.m26847b(function2, "positiveCallback");
            RedditAlertDialog redditAlertDialog = new RedditAlertDialog(context, z);
            redditAlertDialog.f21113a.a(context.getString(i, new Object[]{str})).b(i2).b(C1761R.string.action_cancel, 0).a(i3, (OnClickListener) new RedditAlertDialogKt$sam$OnClickListener$4ed99a24(function2));
            return redditAlertDialog;
        }

        public static RedditAlertDialog m23299a(Context context, Function2<? super DialogInterface, ? super Integer, Unit> function2, Function2<? super DialogInterface, ? super Integer, Unit> function22) {
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(function2, "acceptCallback");
            Intrinsics.m26847b(function22, "declineCallback");
            RedditAlertDialog redditAlertDialog = new RedditAlertDialog(context, false);
            redditAlertDialog.f21113a.a(C1761R.string.mod_tools_invite_title).b(C1761R.string.mod_tools_invite_content).b(C1761R.string.action_modtools_decline, new RedditAlertDialogKt$sam$OnClickListener$4ed99a24(function22)).a(false).a(C1761R.string.action_modtools_accept, (OnClickListener) new RedditAlertDialogKt$sam$OnClickListener$4ed99a24(function2));
            return redditAlertDialog;
        }

        protected static void m23302a(Activity activity, AppConfiguration appConfiguration) {
            Intrinsics.m26847b(activity, "activity");
            Intrinsics.m26847b(appConfiguration, "appConfig");
            activity.startActivity(IntentUtil.m23764b(appConfiguration.global.app_version_check.update_url));
            activity.finish();
        }

        public static void m23305b(Activity activity) {
            Intrinsics.m26847b(activity, "activity");
            RedditAlertDialog redditAlertDialog = new RedditAlertDialog(activity);
            redditAlertDialog.f21113a.a(C1761R.string.app_name).b(C1761R.string.prompt_new_user).a(C1761R.string.option_yes, RedditAlertDialog$Companion$showNewUserAlertExperiment$1$1.f21108a).b(C1761R.string.option_no, RedditAlertDialog$Companion$showNewUserAlertExperiment$1$2.f21109a);
            redditAlertDialog.m23323a();
        }

        public static void m23308e(Context context, Function2<? super DialogInterface, ? super Integer, Unit> function2) {
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(function2, "leaveListener");
            RedditAlertDialog redditAlertDialog = new RedditAlertDialog(context, true);
            redditAlertDialog.f21113a.a(C1761R.string.title_warning).b(C1761R.string.submit_warn_data_loss).a(C1761R.string.action_leave, new RedditAlertDialogKt$sam$OnClickListener$4ed99a24(function2)).b(C1761R.string.action_cancel, null);
            redditAlertDialog.m23323a();
        }

        public static AlertDialog m23286a(Context context, int i, boolean z) {
            Intrinsics.m26847b(context, "context");
            View inflate = LayoutInflater.from(context).inflate(C1761R.layout.progress_dialog_layout, null);
            Object obj = (TextView) inflate.findViewById(C1761R.id.progress_dialog_text);
            Intrinsics.m26843a(obj, "messageText");
            obj.setText(context.getString(i));
            i = new RedditAlertDialog(context);
            i.f21113a.a(inflate).a(z);
            return i.m23324b();
        }

        public static final /* synthetic */ void m23303a(String str, String str2, String str3, Function0 function0) {
            JobManager a = RedditJobManager.a();
            if (a == null) {
                Intrinsics.m26842a();
            }
            a.a(new ReportJob(str, str2, str3));
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public RedditAlertDialog(Context context, byte b) {
        this(context);
    }

    public static final AlertDialog m23309a(Context context, int i, boolean z) {
        return Companion.m23286a(context, i, z);
    }

    public static final CustomReportReasonsDialog m23310a(String str, String str2, Context context, Link link, Thing thing, Function0<Unit> function0) {
        return Companion.m23287a(str, str2, context, link, thing, (Function0) function0);
    }

    public static final RedditAlertDialog m23311a(Activity activity) {
        return Companion.m23288a(activity);
    }

    public static final RedditAlertDialog m23312a(Context context) {
        return Companion.m23289a(context);
    }

    public static final RedditAlertDialog m23313a(Context context, int i, Function2<? super DialogInterface, ? super Integer, Unit> function2) {
        return Companion.m23292a(context, i, (Function2) function2);
    }

    public static final RedditAlertDialog m23314a(Context context, String str) {
        return Companion.m23293a(context, str);
    }

    public static final RedditAlertDialog m23315a(Context context, String str, Function2<? super DialogInterface, ? super Integer, Unit> function2) {
        return Companion.m23297a(context, str, (Function2) function2);
    }

    public static final RedditAlertDialog m23316a(Context context, Function2<? super DialogInterface, ? super Integer, Unit> function2) {
        return Companion.m23306c(context, function2);
    }

    public static final RedditAlertDialog m23319b(Context context) {
        return Companion.m23291a(context, (int) C1761R.string.debug_dummy_community_error_title, (int) C1761R.string.debug_dummy_community_error_message, (int) C1761R.string.debug_dummy_community_error_submessage, null);
    }

    public static final RedditAlertDialog m23320b(Context context, Function2<? super DialogInterface, ? super Integer, Unit> function2) {
        return Companion.m23307d(context, function2);
    }

    public static final void m23321b(Activity activity) {
        Companion.m23305b(activity);
    }

    public static final void m23322c(Context context, Function2<? super DialogInterface, ? super Integer, Unit> function2) {
        Companion.m23308e(context, function2);
    }

    public RedditAlertDialog(Context context, boolean z) {
        Intrinsics.m26847b(context, "context");
        this.f21114c = z;
        this.f21113a = new Builder(context);
    }

    public final AlertDialog m23323a() {
        Object c = this.f21113a.c();
        m23317a((AlertDialog) c);
        Intrinsics.m26843a(c, "dialogBuilder.show().app…plyRedditButtonDesign() }");
        return c;
    }

    public final AlertDialog m23324b() {
        Object b = this.f21113a.b();
        b.setOnShowListener(new RedditAlertDialog$create$$inlined$apply$lambda$1(b, this));
        Intrinsics.m26843a(b, "dialogBuilder.create().a…yRedditButtonDesign() } }");
        return b;
    }

    private final void m23317a(AlertDialog alertDialog) {
        View view;
        View findViewById = alertDialog.findViewById(C1761R.id.title_template);
        if (findViewById != null) {
            Object context = alertDialog.getContext();
            Intrinsics.m26843a(context, "context");
            CustomViewPropertiesKt.m28402a(findViewById, DimensionsKt.m28408a(context, C1761R.dimen.dialog_top_padding));
        }
        TextView textView = (TextView) alertDialog.findViewById(16908299);
        if (textView != null) {
            context = alertDialog.getContext();
            Intrinsics.m26843a(context, "context");
            TextViewsKt.m24095a(textView, ContextsKt.m24077b(context, C1761R.attr.textAppearanceRedditBody));
        }
        ViewGroup viewGroup = (ViewGroup) alertDialog.findViewById(C1761R.id.contentPanel);
        if (viewGroup != null) {
            viewGroup.setMinimumHeight(0);
        }
        Button a = alertDialog.a(-1);
        Button a2 = alertDialog.a(-3);
        Button a3 = alertDialog.a(-2);
        List<Button> d = CollectionsKt__CollectionsKt.m26798d(a, a2, a3);
        Button button = (Button) CollectionsKt___CollectionsKt.m41434e((List) d);
        Sequence sequence = null;
        ViewParent parent = button != null ? button.getParent() : null;
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup2 = (ViewGroup) parent;
        if (viewGroup2 != null) {
            LayoutParams layoutParams = viewGroup2.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            marginLayoutParams.height = -2;
            view = viewGroup2;
            marginLayoutParams.topMargin = DimensionsKt.m28408a(view.getContext(), C1761R.dimen.double_pad);
            CustomViewPropertiesKt.m28405b(view, DimensionsKt.m28408a(view.getContext(), C1761R.dimen.dialog_buttons_side_padding));
            Sequence a4 = SequencesKt___SequencesKt.m33708a(ViewChildrenSequencesKt.m28417a(view), (Function1) RedditAlertDialog$$special$$inlined$filterIsInstance$1.f37164a);
            if ((SequencesKt___SequencesKt.m33717f(a4) > 1 ? 1 : 0) != 0) {
                sequence = a4;
            }
            if (sequence != null) {
                sequence = SequencesKt___SequencesKt.m33719g(sequence);
                if (sequence != null) {
                    Iterator a5 = sequence.mo5679a();
                    while (a5.hasNext()) {
                        List list = (List) a5.next();
                        Button button2 = (Button) list.get(0);
                        Button button3 = (Button) list.get(1);
                        int a6 = DimensionsKt.m28408a(view.getContext(), C1761R.dimen.dialog_buttons_inner_spacing) / 2;
                        LayoutParams layoutParams2 = button2.getLayoutParams();
                        if (layoutParams2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        }
                        ((MarginLayoutParams) layoutParams2).setMarginEnd(a6);
                        layoutParams = button3.getLayoutParams();
                        if (layoutParams == null) {
                            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        }
                        ((MarginLayoutParams) layoutParams).setMarginStart(a6);
                    }
                }
            }
            viewGroup2.requestLayout();
        }
        view = alertDialog.findViewById(C1761R.id.spacer);
        if (view != null) {
            ViewsKt.m24109d(view);
        }
        for (Button layoutParams3 : d) {
            LayoutParams layoutParams4 = layoutParams3.getLayoutParams();
            if (layoutParams4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) layoutParams4;
            layoutParams5.gravity = 0;
            layoutParams5.weight = 1.0f;
            layoutParams5.width = 0;
            Object context2 = alertDialog.getContext();
            Intrinsics.m26843a(context2, "context");
            layoutParams5.height = DimensionsKt.m28408a(context2, C1761R.dimen.rdt_button_min_height);
        }
        if (a != null) {
            View view2 = a;
            context = a.getContext();
            Intrinsics.m26843a(context, "context");
            Sdk21PropertiesKt.m28413b(view2, ContextsKt.m24077b(context, C1761R.attr.primaryButtonBackground));
            if (this.f21114c != null) {
                Object context3 = a.getContext();
                Intrinsics.m26843a(context3, "context");
                a.setBackgroundTintList(ColorStateList.valueOf(ContextsKt.m24075a(context3, C1761R.color.rdt_red)));
            }
            TextView textView2 = a;
            Object context4 = a.getContext();
            Intrinsics.m26843a(context4, "context");
            TextViewsKt.m24095a(textView2, ContextsKt.m24077b(context4, C1761R.attr.textAppearanceRedditButtonColored));
        }
        alertDialog = RedditAlertDialog$applyRedditButtonDesign$4.f37167a;
        if (a2 != null) {
            RedditAlertDialog$applyRedditButtonDesign$4.m37548a(a2);
        }
        if (a3 != null) {
            RedditAlertDialog$applyRedditButtonDesign$4.m37548a(a3);
        }
    }
}
