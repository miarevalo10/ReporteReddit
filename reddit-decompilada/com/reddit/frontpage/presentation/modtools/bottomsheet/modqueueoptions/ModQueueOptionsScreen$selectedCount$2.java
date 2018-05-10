package com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions;

import android.view.View;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModQueueOptionsScreen.kt */
final class ModQueueOptionsScreen$selectedCount$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ ModQueueOptionsScreen f36980a;

    ModQueueOptionsScreen$selectedCount$2(ModQueueOptionsScreen modQueueOptionsScreen) {
        this.f36980a = modQueueOptionsScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View view = this.f36980a;
        int i = C1761R.id.selected_number;
        if (view.f28619g == null) {
            view.f28619g = new HashMap();
        }
        View view2 = (View) view.f28619g.get(Integer.valueOf(i));
        if (view2 == null) {
            view2 = view.findViewById(i);
            view.f28619g.put(Integer.valueOf(i), view2);
        }
        return (TextView) view2;
    }
}
