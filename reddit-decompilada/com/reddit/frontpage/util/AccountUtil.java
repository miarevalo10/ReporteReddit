package com.reddit.frontpage.util;

import android.content.Context;
import android.view.View;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.nav.Screen;

public class AccountUtil {
    public static void m23631a(Screen screen, String str) {
        String a = Util.m23960a((int) C1761R.string.fmt_u_name, str);
        View view = screen.j;
        Context context = view.getContext();
        Object[] objArr = new Object[1];
        StringBuilder stringBuilder = new StringBuilder(Operation.DIVISION);
        stringBuilder.append(a);
        objArr[0] = stringBuilder.toString();
        String a2 = LinkUtil.m23778a(Util.m23960a((int) C1761R.string.fmt_permalink_base, objArr));
        screen = AppAnalytics.m21868e().m21834a(view);
        screen.f19996f = str;
        screen.f19995e = a2;
        screen.m21837a();
        context.startActivity(IntentUtil.m23746a(context, String.format("%s\n\n%s", new Object[]{a, a2})));
    }
}
