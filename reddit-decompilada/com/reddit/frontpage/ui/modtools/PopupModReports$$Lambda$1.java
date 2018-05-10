package com.reddit.frontpage.ui.modtools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.reddit.datalibrary.frontpage.data.provider.FlairProvider;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.SchedulerProvider;

final /* synthetic */ class PopupModReports$$Lambda$1 implements OnClickListener {
    private final PopupModReports f21470a;

    PopupModReports$$Lambda$1(PopupModReports popupModReports) {
        this.f21470a = popupModReports;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface = this.f21470a;
        dialogInterface.f21473b.dismiss();
        if ((dialogInterface.f21472a instanceof Comment) != 0) {
            i = new PopupCommentModOptions(dialogInterface.f21474c, (Comment) dialogInterface.f21472a, LinkUtil.m23776a(), dialogInterface.f21476e);
            i.f21458b = dialogInterface.f21475d;
            i.f21457a.m23284a();
            return;
        }
        if (!((dialogInterface.f21472a instanceof Link) == 0 || dialogInterface.f21472a == 0)) {
            i = new FlairProvider();
            dialogInterface.f21477f = FlairProvider.a(((Link) dialogInterface.f21472a).getSubreddit()).observeOn(SchedulerProvider.m23887c()).subscribe(new PopupModReports$$Lambda$2(dialogInterface), new PopupModReports$$Lambda$3(dialogInterface));
        }
    }
}
