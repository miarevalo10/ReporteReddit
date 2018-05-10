package com.reddit.frontpage.presentation.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatRadioButton;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.dialogs.customreports.ThingReportContract.View;
import com.reddit.frontpage.presentation.dialogs.customreports.ThingReportContract.View.DefaultImpls;
import com.reddit.frontpage.presentation.dialogs.customreports.ThingReportPresenter;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.util.FontUtil;
import com.reddit.frontpage.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\n\b&\u0018\u0000 V2\u00020\u0001:\u0002VWB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0004J\u0014\u0010'\u001a\u00020(2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,J@\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u00103\u001a\u0002002\u0006\u00104\u001a\u0002002\f\u00105\u001a\b\u0012\u0004\u0012\u0002000,H\u0002JP\u00106\u001a\u00020\n2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u00103\u001a\u0002002\b\u00107\u001a\u0004\u0018\u0001002\u0006\u00108\u001a\u0002002\f\u00105\u001a\b\u0012\u0004\u0012\u0002000,2\u0006\u00109\u001a\u00020:JJ\u0010;\u001a\u00020\n2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u00103\u001a\u0002002\b\u00107\u001a\u0004\u0018\u0001002\u0006\u00104\u001a\u0002002\f\u00105\u001a\b\u0012\u0004\u0012\u0002000,H\u0002Jo\u0010<\u001a\b\u0012\u0004\u0012\u00020=0,2\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u0001002\b\u0010A\u001a\u0004\u0018\u0001002\f\u0010B\u001a\b\u0012\u0004\u0012\u0002000C2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010EH\u0004¢\u0006\u0002\u0010FJC\u0010G\u001a\u00020\n2\u0006\u00101\u001a\u0002022\u0006\u0010/\u001a\u0002002\b\u0010H\u001a\u0004\u0018\u0001002\f\u0010I\u001a\b\u0012\u0004\u0012\u0002000C2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020=0,H\u0004¢\u0006\u0002\u0010KJ\u0010\u0010L\u001a\u00020(2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020(2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010P\u001a\u00020(2\u0006\u00104\u001a\u000200H\u0016J\u000e\u0010Q\u001a\u00020(2\u0006\u0010R\u001a\u000200J\u000e\u0010S\u001a\u00020(2\u0006\u0010R\u001a\u000200J\u000e\u0010T\u001a\u00020(2\u0006\u0010R\u001a\u000200J\u0006\u0010U\u001a\u00020(R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#¨\u0006X"}, d2 = {"Lcom/reddit/frontpage/presentation/dialogs/BaseThingReportDialog;", "Lcom/reddit/frontpage/presentation/dialogs/customreports/ThingReportContract$View;", "()V", "closeButton", "Landroid/widget/ImageView;", "getCloseButton", "()Landroid/widget/ImageView;", "setCloseButton", "(Landroid/widget/ImageView;)V", "dialog", "Landroid/app/Dialog;", "getDialog", "()Landroid/app/Dialog;", "setDialog", "(Landroid/app/Dialog;)V", "negativeButton", "Landroid/widget/Button;", "getNegativeButton", "()Landroid/widget/Button;", "setNegativeButton", "(Landroid/widget/Button;)V", "positiveButton", "getPositiveButton", "setPositiveButton", "presenter", "Lcom/reddit/frontpage/presentation/dialogs/customreports/ThingReportPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/dialogs/customreports/ThingReportPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/dialogs/customreports/ThingReportPresenter;)V", "selectReasonView", "Landroid/widget/TextView;", "getSelectReasonView", "()Landroid/widget/TextView;", "setSelectReasonView", "(Landroid/widget/TextView;)V", "termsView", "getTermsView", "setTermsView", "decorateTermsView", "", "parentLink", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "decorator", "Lcom/reddit/frontpage/ui/listener/Consumer;", "Landroid/view/View;", "getPostComplaintDialog", "title", "", "context", "Landroid/content/Context;", "actionString", "username", "onAction", "getPostDialog", "message", "blockUsername", "type", "Lcom/reddit/frontpage/presentation/dialogs/BaseThingReportDialog$DialogType;", "getPostReportDialog", "getSendReportWithPostActionConsumable", "", "thing", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "reason", "reasonOne", "otherReasons", "", "onLinkReported", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lcom/reddit/frontpage/ui/listener/Consumer;", "initDialog", "selectRulesTitle", "rules", "onNext", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/reddit/frontpage/ui/listener/Consumer;)Landroid/app/Dialog;", "onReportError", "error", "", "onUserBlockError", "onUserBlocked", "setNegativeButtonText", "text", "setPositiveButtonText", "setTermsViewText", "show", "Companion", "DialogType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BaseThingReportDialog.kt */
public abstract class BaseThingReportDialog implements View {
    public static final Companion f28189e = new Companion();
    private static final List<Dialog> f28190i = new ArrayList();
    protected Dialog f28191a;
    protected Button f28192b;
    protected Button f28193c;
    @Inject
    public ThingReportPresenter f28194d;
    private ImageView f28195f;
    private TextView f28196g;
    private TextView f28197h;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/dialogs/BaseThingReportDialog$Companion;", "", "()V", "ALPHA_FULL_FLOAT", "", "ALPHA_TRANSLUCENT_FLOAT", "dialogStack", "", "Landroid/app/Dialog;", "getDialogStack", "()Ljava/util/List;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BaseThingReportDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public static List<Dialog> m22820a() {
            return BaseThingReportDialog.f28190i;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/dialogs/BaseThingReportDialog$DialogType;", "", "(Ljava/lang/String;I)V", "POST_BLOCK", "POST_COMPLIANT", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BaseThingReportDialog.kt */
    public enum DialogType {
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20512a;

        static {
            int[] iArr = new int[DialogType.values().length];
            f20512a = iArr;
            iArr[DialogType.f20509a.ordinal()] = 1;
            f20512a[DialogType.f20510b.ordinal()] = 2;
        }
    }

    protected final Dialog m29504a() {
        Dialog dialog = this.f28191a;
        if (dialog == null) {
            Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
        }
        return dialog;
    }

    protected final void m29508a(Dialog dialog) {
        Intrinsics.m26847b(dialog, "<set-?>");
        this.f28191a = dialog;
    }

    public final ThingReportPresenter m29511b() {
        ThingReportPresenter thingReportPresenter = this.f28194d;
        if (thingReportPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return thingReportPresenter;
    }

    public final Dialog m29506a(String str, Context context, Link link, String str2, String str3, String str4, Consumer<String> consumer, DialogType dialogType) {
        Intrinsics.m26847b(str, "title");
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(str2, "actionString");
        Intrinsics.m26847b(str4, "blockUsername");
        Intrinsics.m26847b(consumer, "onAction");
        Intrinsics.m26847b(dialogType, "type");
        Button button;
        TextView textView;
        switch (WhenMappings.f20512a[dialogType.ordinal()]) {
            case 1:
                dialogType = new AppCompatDialog(context);
                dialogType.setContentView(C1761R.layout.dialog_custom_reports_post_action);
                dialogType.setCanceledOnTouchOutside(true);
                dialogType.setTitle(str);
                this.f28196g = (TextView) dialogType.findViewById(C1761R.id.terms);
                this.f28195f = (ImageView) dialogType.findViewById(C1761R.id.close);
                str = this.f28195f;
                if (str != null) {
                    str.setOnClickListener((OnClickListener) new BaseThingReportDialog$getPostReportDialog$1(dialogType));
                }
                button = (Button) dialogType.findViewById(C1761R.id.cancel);
                if (button != null) {
                    button.setOnClickListener((OnClickListener) new BaseThingReportDialog$getPostReportDialog$2(dialogType));
                }
                textView = (TextView) dialogType.findViewById(C1761R.id.action);
                if (textView != null) {
                    textView.setText(str2);
                }
                if (textView != null) {
                    textView.setOnClickListener((OnClickListener) new BaseThingReportDialog$getPostReportDialog$3(consumer, str4));
                }
                textView = (TextView) dialogType.findViewById(C1761R.id.message);
                if (textView != null) {
                    textView.setText(str3);
                }
                m29502a(link);
                return (Dialog) dialogType;
            case 2:
                str3 = new AppCompatDialog(context);
                str3.setContentView(C1761R.layout.dialog_custom_reports_complaint);
                str3.setCanceledOnTouchOutside(true);
                str3.setTitle(str);
                this.f28195f = (ImageView) str3.findViewById(C1761R.id.close);
                str = this.f28195f;
                if (str != null) {
                    str.setOnClickListener((OnClickListener) new BaseThingReportDialog$getPostComplaintDialog$1(str3));
                }
                button = (Button) str3.findViewById(C1761R.id.cancel);
                if (button != null) {
                    button.setOnClickListener((OnClickListener) new BaseThingReportDialog$getPostComplaintDialog$2(str3));
                }
                textView = (TextView) str3.findViewById(C1761R.id.action);
                if (textView != null) {
                    textView.setText(str2);
                }
                if (textView != null) {
                    textView.setOnClickListener((OnClickListener) new BaseThingReportDialog$getPostComplaintDialog$3(consumer, str4));
                }
                this.f28196g = (TextView) str3.findViewById(C1761R.id.terms);
                m29502a(link);
                Dialog dialog = (Dialog) str3;
                this.f28191a = dialog;
                return dialog;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    protected final Dialog m29505a(Context context, String str, String str2, String[] strArr, Consumer<Integer> consumer) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(str, "title");
        Intrinsics.m26847b(strArr, "rules");
        Intrinsics.m26847b(consumer, "onNext");
        AppCompatDialog appCompatDialog = new AppCompatDialog(context);
        appCompatDialog.setContentView(C1761R.layout.dialog_custom_report_main);
        appCompatDialog.setCanceledOnTouchOutside(true);
        appCompatDialog.setTitle(str);
        CharSequence charSequence = str2;
        if (TextUtils.isEmpty(charSequence) == null) {
            this.f28197h = (TextView) appCompatDialog.findViewById(C1761R.id.select_reason);
            str = this.f28197h;
            if (str != null) {
                str.setVisibility(0);
            }
            str = this.f28197h;
            if (str != null) {
                str.setText(charSequence);
            }
            str = appCompatDialog.findViewById(C1761R.id.separator);
            if (str != null) {
                str.setVisibility(0);
            }
        }
        RadioGroup radioGroup = (RadioGroup) appCompatDialog.findViewById(C1761R.id.radio_group);
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener((OnCheckedChangeListener) new BaseThingReportDialog$initDialog$1(this));
        }
        this.f28195f = (ImageView) appCompatDialog.findViewById(C1761R.id.close);
        str2 = this.f28195f;
        if (str2 != null) {
            str2.setOnClickListener(new BaseThingReportDialog$initDialog$2(appCompatDialog));
        }
        this.f28192b = (Button) appCompatDialog.findViewById(C1761R.id.cancel);
        str2 = this.f28192b;
        if (str2 != null) {
            str2.setText(Util.m24027f((int) C1761R.string.action_back));
        }
        str2 = this.f28192b;
        if (str2 != null) {
            str2.setOnClickListener(BaseThingReportDialog$initDialog$3.f20523a);
        }
        this.f28193c = (Button) appCompatDialog.findViewById(C1761R.id.next);
        str2 = this.f28193c;
        if (str2 != null) {
            str2.setOnClickListener(new BaseThingReportDialog$initDialog$4(radioGroup, consumer, appCompatDialog));
        }
        str2 = this.f28193c;
        if (str2 != null) {
            str2.setEnabled(false);
        }
        str2 = this.f28193c;
        if (str2 != null) {
            str2.setAlpha(0.5f);
        }
        this.f28196g = (TextView) appCompatDialog.findViewById(C1761R.id.terms);
        Consumer<Integer> length = strArr.length;
        for (consumer = null; consumer < length; consumer++) {
            AppCompatRadioButton appCompatRadioButton = new AppCompatRadioButton(context, null, 16842878);
            LayoutParams layoutParams = new LayoutParams(-2, -2, 1.0f);
            layoutParams.setMargins(Util.m24029g((int) C1761R.dimen.quad_pad), Util.m24029g((int) C1761R.dimen.triple_pad), Util.m24029g((int) C1761R.dimen.quad_pad), 0);
            appCompatRadioButton.setLayoutParams(layoutParams);
            appCompatRadioButton.setTextSize(0, Util.m24018e());
            appCompatRadioButton.setPadding(Util.m24029g((int) C1761R.dimen.double_pad), 0, 0, 0);
            FontUtil.m23704a("benton-sans-medium", appCompatRadioButton);
            appCompatRadioButton.setText(strArr[consumer]);
            appCompatRadioButton.setTag(Integer.valueOf(consumer));
            if (radioGroup != null) {
                radioGroup.addView(appCompatRadioButton);
            }
        }
        return appCompatDialog;
    }

    protected final Consumer<Integer> m29507a(String str, String str2, Context context, Link link, Thing thing, String str3, String str4, String[] strArr, Function0<Unit> function0) {
        String str5 = str;
        Intrinsics.m26847b(str5, "title");
        String str6 = str2;
        Intrinsics.m26847b(str6, "blockUsername");
        Context context2 = context;
        Intrinsics.m26847b(context2, "context");
        Thing thing2 = thing;
        Intrinsics.m26847b(thing2, "thing");
        Object obj = strArr;
        Intrinsics.m26847b(obj, "otherReasons");
        return new BaseThingReportDialog$getSendReportWithPostActionConsumable$1(this, str3, str4, obj, thing2, function0, str5, context2, link, str6);
    }

    private void m29502a(Link link) {
        Object[] objArr = new Object[2];
        String str = null;
        objArr[0] = link != null ? link.getSubreddit() : null;
        if (link != null) {
            str = link.getSubreddit();
        }
        objArr[1] = str;
        link = Util.m23960a((int) C1761R.string.mod_report_rules, objArr);
        TextView textView = this.f28196g;
        if (textView != null) {
            textView.setText(Html.fromHtml(link));
        }
        link = this.f28196g;
        if (link != null) {
            link.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public final void m29509a(String str) {
        Intrinsics.m26847b(str, "text");
        Button button = this.f28192b;
        if (button != null) {
            button.setText(str);
        }
    }

    public final void m29514c() {
        Dialog dialog = this.f28191a;
        if (dialog == null) {
            Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
        }
        dialog.show();
        dialog.getWindow().setLayout(-1, -2);
        List a = Companion.m22820a();
        Dialog dialog2 = this.f28191a;
        if (dialog2 == null) {
            Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
        }
        if (!a.contains(dialog2)) {
            a = Companion.m22820a();
            dialog2 = this.f28191a;
            if (dialog2 == null) {
                Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
            }
            a.add(dialog2);
        }
    }

    public final void mo4815b(String str) {
        Intrinsics.m26847b(str, "username");
        Dialog dialog = this.f28191a;
        if (dialog == null) {
            Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
        }
        TextView textView = (TextView) dialog.findViewById(C1761R.id.action);
        if (textView != null) {
            textView.setText(aa_().getString(C1761R.string.fmt_blocked_user, new Object[]{str}));
        }
        Companion.m22820a().clear();
    }

    public final void mo4814a(Throwable th) {
        Intrinsics.m26847b(th, "error");
        th = this.f28191a;
        if (th == null) {
            Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
        }
        th.dismiss();
        Screens.m22628a(mo6458e(), (int) C1761R.string.error_report_user).a();
    }

    public final void mo4816b(Throwable th) {
        Intrinsics.m26847b(th, "error");
        DefaultImpls.m22825b(this, th);
        th = this.f28191a;
        if (th == null) {
            Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
        }
        th.dismiss();
    }
}
