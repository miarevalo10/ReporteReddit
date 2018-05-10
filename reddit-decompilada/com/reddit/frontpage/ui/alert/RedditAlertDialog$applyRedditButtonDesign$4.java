package com.reddit.frontpage.ui.alert;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.ContextsKt;
import com.reddit.frontpage.util.kotlin.TextViewsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.anko.Sdk21PropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"applyTertiaryStyle", "", "Landroid/widget/Button;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAlertDialog.kt */
final class RedditAlertDialog$applyRedditButtonDesign$4 extends Lambda implements Function1<Button, Unit> {
    public static final RedditAlertDialog$applyRedditButtonDesign$4 f37167a = new RedditAlertDialog$applyRedditButtonDesign$4();

    RedditAlertDialog$applyRedditButtonDesign$4() {
        super(1);
    }

    public static void m37548a(Button button) {
        Intrinsics.m26847b(button, "$receiver");
        View view = button;
        Object context = button.getContext();
        Intrinsics.m26843a(context, "context");
        Sdk21PropertiesKt.m28413b(view, ContextsKt.m24077b(context, C1761R.attr.tertiaryButtonBackground));
        TextView textView = button;
        Object context2 = button.getContext();
        Intrinsics.m26843a(context2, "context");
        TextViewsKt.m24095a(textView, ContextsKt.m24077b(context2, C1761R.attr.textAppearanceRedditButton));
    }
}
