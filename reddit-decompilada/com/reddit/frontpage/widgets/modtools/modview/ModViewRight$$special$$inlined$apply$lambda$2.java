package com.reddit.frontpage.widgets.modtools.modview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.ui.modtools.PopupPostModOptions;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModViewRight.kt */
final class ModViewRight$$special$$inlined$apply$lambda$2 implements OnClickListener {
    final /* synthetic */ ImageView f22019a;
    final /* synthetic */ ModViewRight f22020b;
    final /* synthetic */ Context f22021c;

    ModViewRight$$special$$inlined$apply$lambda$2(ImageView imageView, ModViewRight modViewRight, Context context) {
        this.f22019a = imageView;
        this.f22020b = modViewRight;
        this.f22021c = context;
    }

    public final void onClick(View view) {
        View popupPostModOptions = new PopupPostModOptions(this.f22021c, this.f22020b.getLink(), this.f22020b.getModerateListener(), AppAnalytics.m21849a((View) this.f22019a), new int[]{C1761R.id.action_remove_post, C1761R.id.action_remove_spam, C1761R.id.action_approve_post}, this.f22020b.f34539j);
        popupPostModOptions.m23582a(this.f22020b.getActionCompletedListener());
        popupPostModOptions.m23581a((OnDismissListener) new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                ModViewRight.m35310a(this.f22020b);
            }
        });
        popupPostModOptions.m23580a();
    }
}
