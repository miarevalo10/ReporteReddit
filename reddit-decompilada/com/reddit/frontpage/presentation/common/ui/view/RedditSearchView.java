package com.reddit.frontpage.presentation.common.ui.view;

import android.content.Context;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.widget.SearchView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.util.Consumer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J\b\u0010\u000e\u001a\u00020\nH\u0002¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/RedditSearchView;", "Landroid/support/v7/widget/SearchView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "disableInput", "", "onClick", "Lcom/reddit/frontpage/util/Consumer;", "Landroid/view/View;", "styleText", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditSearchView.kt */
public final class RedditSearchView extends SearchView {
    public static final Companion f33791a = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/RedditSearchView$Companion;", "", "()V", "NO_MARGIN", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditSearchView.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public RedditSearchView(Context context) {
        this(context, null, 0, 6, null);
    }

    public RedditSearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ RedditSearchView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = C1761R.attr.searchViewStyle;
        }
        this(context, attributeSet, i);
    }

    public RedditSearchView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        attributeSet = findViewById(C1761R.id.search_src_text);
        if (attributeSet == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.EditText");
        }
        EditText editText = (EditText) attributeSet;
        Object context2 = getContext();
        Intrinsics.m26843a(context2, "context");
        editText.setHintTextColor(ResourcesUtil.m22740i(context2, C1761R.attr.rdt_hint_text_color));
        attributeSet = findViewById(C1761R.id.search_mag_icon);
        if (attributeSet == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
        }
        ImageView imageView = (ImageView) attributeSet;
        i = imageView.getLayoutParams();
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        ((LayoutParams) i).leftMargin = 0;
        ImageViewCompat.a(imageView, ResourcesUtil.m22738h(context, (int) C1761R.attr.rdt_action_icon_color));
        context = findViewById(C1761R.id.search_edit_frame);
        if (context == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        }
        context = context.getLayoutParams();
        if (context == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        ((LayoutParams) context).leftMargin = 0;
    }

    public final void m34598a(Consumer<View> consumer) {
        Intrinsics.m26847b(consumer, "onClick");
        setOnClickListener(new RedditSearchView$inlined$sam$OnClickListener$i$7f478c20(new RedditSearchView$disableInput$2(consumer)));
        View findViewById = findViewById(C1761R.id.search_src_text);
        if (findViewById == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.EditText");
        }
        EditText editText = (EditText) findViewById;
        editText.setFocusable(false);
        editText.setOnClickListener((OnClickListener) new RedditSearchView$inlined$sam$OnClickListener$i$7f478c20(new RedditSearchView$disableInput$$inlined$apply$lambda$1(consumer)));
    }
}
