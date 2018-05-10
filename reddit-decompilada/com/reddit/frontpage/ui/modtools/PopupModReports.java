package com.reddit.frontpage.ui.modtools;

import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.requests.models.Reportable;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ClickEventBuilder;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;
import io.reactivex.disposables.Disposable;

public class PopupModReports {
    final Reportable f21472a;
    final Dialog f21473b;
    final Context f21474c;
    final OnModActionCompletedListener f21475d;
    String f21476e = null;
    Disposable f21477f;

    public PopupModReports(Context context, Reportable reportable, String str, OnModActionCompletedListener onModActionCompletedListener) {
        this.f21472a = reportable;
        this.f21474c = context;
        this.f21476e = str;
        this.f21475d = new PopupModReports$$Lambda$0(this, onModActionCompletedListener);
        str = new StringBuilder();
        if (reportable.getModReports().length > null) {
            str.append("<b>");
            str.append(Util.m24027f((int) C1761R.string.mod_mod_reports));
            str.append("</b><br>");
            for (String[] strArr : reportable.getModReports()) {
                str.append(strArr[1]);
                str.append(": ");
                str.append(strArr[0]);
                str.append("<br>");
            }
            str.append("<br>");
        }
        if (reportable.getUserReports().length > null) {
            str.append("<b>");
            str.append(Util.m24027f((int) C1761R.string.mod_user_reports));
            str.append("</b><br>");
            for (String[] strArr2 : reportable.getUserReports()) {
                str.append(strArr2[0]);
                str.append(" (");
                str.append(strArr2[1]);
                str.append(")<br>");
            }
            str.append("<br>");
        }
        reportable = context.getResources().getDimensionPixelSize(C1761R.dimen.dialog_side_padding);
        onModActionCompletedListener = Util.m24012d((int) C1761R.dimen.double_pad);
        View textView = new TextView(context);
        textView.setTextAppearance(context, C1761R.style.TextAppearance.RedditBase.Body);
        textView.setText(Html.fromHtml(str.toString()));
        textView.setPadding(reportable, onModActionCompletedListener, reportable, onModActionCompletedListener);
        reportable = new RedditAlertDialog(context, (byte) 0);
        reportable.f21113a.a(C1761R.string.mod_reports).a(textView).a(C1761R.string.action_moderate, new PopupModReports$$Lambda$1(this));
        this.f21473b = reportable.m23324b();
    }

    final void m23560a() {
        if (this.f21477f != null) {
            this.f21477f.mo5626a();
        }
    }

    final void m23561a(boolean z) {
        PopupPostModOptions popupPostModOptions = new PopupPostModOptions(this.f21474c, (Link) this.f21472a, LinkUtil.m23776a(), this.f21476e, new int[]{C1761R.id.action_view_reports}, z);
        popupPostModOptions.f21479b = this.f21475d;
        popupPostModOptions.m23581a(new PopupModReports$$Lambda$4(this));
        popupPostModOptions.f21478a.m23284a();
    }

    public final void m23562b() {
        ClickEventBuilder b;
        if (this.f21472a instanceof Comment) {
            b = AppAnalytics.m21858b();
            b.f19954a = this.f21476e;
            b.f19955b = "comment_mod_view_reports";
            b.f19956c = ((Comment) this.f21472a).link_url;
            b.m21825a();
        } else if (this.f21472a instanceof Link) {
            b = AppAnalytics.m21858b();
            b.f19954a = this.f21476e;
            b.f19955b = "post_mod_view_reports";
            b.f19956c = ((Link) this.f21472a).getUrl();
            b.m21825a();
        }
        this.f21473b.show();
    }
}
