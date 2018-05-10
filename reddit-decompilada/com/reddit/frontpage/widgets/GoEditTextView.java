package com.reddit.frontpage.widgets;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputFilter;
import android.util.AttributeSet;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;

public class GoEditTextView extends AppCompatEditText {
    OnGoClickedListener f34520a;
    private final InputFilter f34521b;

    public interface OnGoClickedListener {
        boolean mo5021a();
    }

    static final /* synthetic */ CharSequence m35291a(CharSequence charSequence) {
        return (charSequence == null || "~!@#$%^&*()+`-={}[];:'\",./<>?|\\".contains(charSequence) == null) ? null : "";
    }

    public GoEditTextView(Context context) {
        super(context);
        this.f34521b = GoEditTextView$$Lambda$0.f21870a;
        m35292a();
    }

    public GoEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34521b = GoEditTextView$$Lambda$1.f21871a;
        m35292a();
    }

    public GoEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34521b = GoEditTextView$$Lambda$2.f21872a;
        m35292a();
    }

    private void m35292a() {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, ResourcesUtil.m22732e(getContext(), (int) C1761R.drawable.ic_icon_search), null);
        setOnTouchListener(new GoEditTextView$$Lambda$3(this));
        setSingleLine(true);
        setFilters(new InputFilter[]{this.f34521b});
    }

    public void setOnGoClickedListener(OnGoClickedListener onGoClickedListener) {
        this.f34520a = onGoClickedListener;
    }
}
