package com.reddit.frontpage.widgets.modtools;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView.OnEditorActionListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\"B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u001dR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006#"}, d2 = {"Lcom/reddit/frontpage/widgets/modtools/ModSearchView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "clearView", "Landroid/support/v7/widget/AppCompatImageView;", "getClearView", "()Landroid/support/v7/widget/AppCompatImageView;", "clearView$delegate", "Lkotlin/Lazy;", "searchView", "Landroid/widget/EditText;", "getSearchView", "()Landroid/widget/EditText;", "searchView$delegate", "searchViewCallback", "Lcom/reddit/frontpage/widgets/modtools/ModSearchView$SearchViewCallback;", "getSearchViewCallback", "()Lcom/reddit/frontpage/widgets/modtools/ModSearchView$SearchViewCallback;", "setSearchViewCallback", "(Lcom/reddit/frontpage/widgets/modtools/ModSearchView$SearchViewCallback;)V", "hideSearchIcon", "", "setQuery", "query", "", "showSearchIcon", "SearchViewCallback", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModSearchView.kt */
public final class ModSearchView extends FrameLayout {
    static final /* synthetic */ KProperty[] f22000a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModSearchView.class), "searchView", "getSearchView()Landroid/widget/EditText;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModSearchView.class), "clearView", "getClearView()Landroid/support/v7/widget/AppCompatImageView;"))};
    private SearchViewCallback f22001b;
    private final Lazy f22002c;
    private final Lazy f22003d;
    private HashMap f22004e;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/widgets/modtools/ModSearchView$SearchViewCallback;", "", "onClear", "", "onClick", "onTextChanged", "s", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModSearchView.kt */
    public interface SearchViewCallback {
        void mo4907a();

        void mo4908a(CharSequence charSequence);

        void mo4909b();
    }

    public ModSearchView(Context context) {
        this(context, null, 0, 6, null);
    }

    public ModSearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final AppCompatImageView getClearView() {
        return (AppCompatImageView) this.f22003d.mo5678b();
    }

    private final EditText getSearchView() {
        return (EditText) this.f22002c.mo5678b();
    }

    public final View m24219a(int i) {
        if (this.f22004e == null) {
            this.f22004e = new HashMap();
        }
        View view = (View) this.f22004e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f22004e.put(Integer.valueOf(i), view);
        return view;
    }

    public /* synthetic */ ModSearchView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public ModSearchView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f22002c = LazyKt.m26777a((Function0) new ModSearchView$searchView$2(this));
        this.f22003d = LazyKt.m26777a((Function0) new ModSearchView$clearView$2(this));
        View.inflate(getContext(), C1761R.layout.search_view_mod, this);
        getClearView().setOnClickListener((OnClickListener) new ModSearchView$$special$$inlined$apply$lambda$1(this));
        context = getSearchView();
        attributeSet = new TypedValue();
        Object context2 = context.getContext();
        Intrinsics.m26843a(context2, "context");
        context2.getTheme().resolveAttribute(C1761R.attr.rdt_action_icon_color, attributeSet, true);
        ViewCompat.a((View) context, ColorStateList.valueOf(attributeSet.data));
        m24221b();
        context.setOnFocusChangeListener((OnFocusChangeListener) new ModSearchView$$special$$inlined$apply$lambda$2(this));
        context.setOnEditorActionListener((OnEditorActionListener) new ModSearchView$$special$$inlined$apply$lambda$3(context, this));
        context.addTextChangedListener((TextWatcher) new ModSearchView$$special$$inlined$apply$lambda$4(this));
    }

    @TargetApi(21)
    public ModSearchView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i, i2);
        this.f22002c = LazyKt.m26777a((Function0) new ModSearchView$searchView$2(this));
        this.f22003d = LazyKt.m26777a((Function0) new ModSearchView$clearView$2(this));
        View.inflate(getContext(), C1761R.layout.search_view_mod, this);
        getClearView().setOnClickListener((OnClickListener) new ModSearchView$$special$$inlined$apply$lambda$5(this));
        context = getSearchView();
        attributeSet = new TypedValue();
        Object context2 = context.getContext();
        Intrinsics.m26843a(context2, "context");
        context2.getTheme().resolveAttribute(C1761R.attr.rdt_action_icon_color, attributeSet, true);
        ViewCompat.a((View) context, ColorStateList.valueOf(attributeSet.data));
        m24221b();
        context.setOnFocusChangeListener((OnFocusChangeListener) new ModSearchView$$special$$inlined$apply$lambda$6(this));
        context.setOnEditorActionListener((OnEditorActionListener) new ModSearchView$$special$$inlined$apply$lambda$7(context, this));
        context.addTextChangedListener((TextWatcher) new ModSearchView$$special$$inlined$apply$lambda$8(this));
    }

    public final SearchViewCallback getSearchViewCallback() {
        return this.f22001b;
    }

    public final void setSearchViewCallback(SearchViewCallback searchViewCallback) {
        this.f22001b = searchViewCallback;
    }

    public final void m24220a() {
        getSearchView().setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    public final void m24221b() {
        Context context = getContext();
        Intrinsics.m26843a((Object) context, "context");
        Context context2 = getContext();
        Intrinsics.m26843a((Object) context2, "context");
        getSearchView().setCompoundDrawablesWithIntrinsicBounds(ResourcesUtil.m22733e(context, ResourcesUtil.m22718a(context2, (int) C1761R.drawable.ic_icon_search)), null, null, null);
    }

    public final void setQuery(String str) {
        Intrinsics.m26847b(str, "query");
        getSearchView().setText(str);
    }
}
