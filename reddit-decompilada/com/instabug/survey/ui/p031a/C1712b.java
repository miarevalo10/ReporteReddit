package com.instabug.survey.ui.p031a;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.instabug.library.core.ui.BaseFragment;
import com.instabug.library.ui.custom.InstabugAutoResizeTextView;
import com.instabug.library.ui.custom.InstabugScrollView;
import com.instabug.library.ui.custom.InstabugScrollView.OnScrollListener;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.OrientationUtils;
import com.instabug.survey.C0787R;
import com.instabug.survey.p027a.C1412b;

/* compiled from: QuestionFragment */
public abstract class C1712b extends BaseFragment {
    protected C1412b f19298a;
    protected C0806a f19299b;
    protected TextView f19300c;
    private View f19301d;
    private View f19302e;
    private InstabugScrollView f19303f;

    /* compiled from: QuestionFragment */
    class C08071 implements OnGlobalLayoutListener {
        final /* synthetic */ C1712b f9973a;

        /* compiled from: QuestionFragment */
        class C14191 implements OnScrollListener {
            final /* synthetic */ C08071 f15591a;

            C14191(C08071 c08071) {
                this.f15591a = c08071;
            }

            public void onTopReached() {
                this.f15591a.f9973a.f19301d.setVisibility(4);
                this.f15591a.f9973a.f19302e.setVisibility(0);
                InstabugSDKLogger.m8356d(this, "onTopReached");
                StringBuilder stringBuilder = new StringBuilder("scrollViewHeight ");
                stringBuilder.append(this.f15591a.f9973a.f19303f.getHeight());
                InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                stringBuilder = new StringBuilder("childHeight");
                stringBuilder.append(this.f15591a.f9973a.f19303f.getChildAt(0).getHeight());
                InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            }

            public void onBottomReached() {
                this.f15591a.f9973a.f19301d.setVisibility(0);
                this.f15591a.f9973a.f19302e.setVisibility(4);
                InstabugSDKLogger.m8356d(this, "onBottomReached");
                StringBuilder stringBuilder = new StringBuilder("scrollViewHeight ");
                stringBuilder.append(this.f15591a.f9973a.f19303f.getHeight());
                InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                stringBuilder = new StringBuilder("childHeight");
                stringBuilder.append(this.f15591a.f9973a.f19303f.getChildAt(0).getHeight());
                InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            }

            public void onScrolling() {
                this.f15591a.f9973a.f19301d.setVisibility(0);
                this.f15591a.f9973a.f19302e.setVisibility(0);
                InstabugSDKLogger.m8356d(this, "onScrolling");
                StringBuilder stringBuilder = new StringBuilder("scrollViewHeight ");
                stringBuilder.append(this.f15591a.f9973a.f19303f.getHeight());
                InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                stringBuilder = new StringBuilder("childHeight");
                stringBuilder.append(this.f15591a.f9973a.f19303f.getChildAt(0).getHeight());
                InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            }
        }

        C08071(C1712b c1712b) {
            this.f9973a = c1712b;
        }

        public void onGlobalLayout() {
            if (this.f9973a.f19303f.getHeight() >= this.f9973a.f19303f.getChildAt(0).getHeight()) {
                this.f9973a.f19302e.setVisibility(8);
                this.f9973a.f19301d.setVisibility(8);
                return;
            }
            this.f9973a.f19303f.setOnScrollListener(new C14191(this));
        }
    }

    public abstract String mo4346a();

    protected final void m20542a(C0806a c0806a) {
        this.f19299b = c0806a;
    }

    public void initViews(View view, Bundle bundle) {
        this.f19303f = (InstabugScrollView) view.findViewById(C0787R.id.ib_dialog_survey_scrollview_container);
        this.f19301d = view.findViewById(C0787R.id.instabug_survey_top_separator);
        this.f19302e = view.findViewById(C0787R.id.instabug_survey_bottom_separator);
        this.f19300c = (TextView) view.findViewById(C0787R.id.instabug_text_view_question);
        if (this.f19300c != null && (this.f19300c instanceof InstabugAutoResizeTextView) != null) {
            ((InstabugAutoResizeTextView) this.f19300c).setMinTextSize(40.0f);
        }
    }

    protected final void m20543b() {
        if (this.f19300c != null && OrientationUtils.isInLandscape(getActivity())) {
            this.f19300c.setMaxLines(3);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f19303f != null) {
            this.f19303f.getViewTreeObserver().addOnGlobalLayoutListener(new C08071(this));
        }
    }
}
