package com.instabug.survey.ui.custom;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.util.DrawableUtils;
import com.instabug.library.view.ViewUtils;
import com.instabug.survey.C0787R;
import java.util.ArrayList;
import java.util.List;

public class NPSLayout extends LinearLayout {
    private int f9993a;
    private List<TextView> f9994b = new ArrayList();
    private final int f9995c;
    private C0821a f9996d;

    public interface C0821a {
        void mo4348a(int i);
    }

    public NPSLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        attributeSet = context.obtainStyledAttributes(attributeSet, C0787R.styleable.NPSLayout);
        this.f9993a = attributeSet.getInteger(C0787R.styleable.NPSLayout_rows, 2);
        attributeSet.recycle();
        this.f9995c = ViewUtils.convertDpToPx(context, 4.0f);
        setOrientation(1);
        m8441a();
    }

    private void m8441a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i = 0;
        layoutParams.setMargins(0, ViewUtils.convertDpToPx(getContext(), 8.0f), 0, ViewUtils.convertDpToPx(getContext(), 8.0f));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout2.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout2.setGravity(17);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout2.setLayoutParams(layoutParams);
        while (i < 11) {
            if (i >= 6) {
                if (i >= 6) {
                    if (this.f9993a == 2) {
                        m8442a(i, linearLayout2);
                    }
                }
                i++;
            }
            m8442a(i, linearLayout);
            i++;
        }
        addView(linearLayout);
        addView(linearLayout2);
    }

    private void m8442a(final int i, LinearLayout linearLayout) {
        final View textView = new TextView(getContext());
        textView.setText(String.valueOf(i));
        if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
            textView.setBackgroundResource(C0787R.drawable.survey_nps_bg_light_tv);
            textView.setTextColor(ContextCompat.m719c(getContext(), C0787R.color.survey_nps_txt_color_light));
        } else {
            textView.setBackgroundResource(C0787R.drawable.survey_nps_bg_dark_tv);
            textView.setTextColor(ContextCompat.m719c(getContext(), C0787R.color.survey_nps_txt_color_dark));
        }
        textView.setTextSize(2, 24.0f);
        textView.setTypeface(null, 1);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.convertDpToPx(getContext(), 40.0f), ViewUtils.convertDpToPx(getContext(), 40.0f));
        layoutParams.setMargins(this.f9995c, 0, this.f9995c, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(17);
        linearLayout.addView(textView);
        textView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NPSLayout f9992c;

            public void onClick(View view) {
                NPSLayout.m8443a(this.f9992c, i);
                if (this.f9992c.f9996d != null) {
                    this.f9992c.f9996d.mo4348a(Integer.parseInt(textView.getText().toString()));
                }
            }
        });
        this.f9994b.add(textView);
    }

    private void setTextViewColorsAccordingToTheme(TextView textView) {
        if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
            DrawableUtils.setColor(textView, ContextCompat.m719c(getContext(), C0787R.color.surveys_nps_box_color_white));
            textView.setTextColor(ContextCompat.m719c(getContext(), C0787R.color.survey_nps_txt_color_light));
            return;
        }
        DrawableUtils.setColor(textView, ContextCompat.m719c(getContext(), C0787R.color.survey_nps_txt_bg_color_dark));
        textView.setTextColor(ContextCompat.m719c(getContext(), C0787R.color.survey_nps_txt_color_dark));
    }

    private void setTextViewColorsSelected(TextView textView) {
        DrawableUtils.setColor(textView, Instabug.getPrimaryColor());
        textView.setTextColor(Color.parseColor("#FFFFFF"));
    }

    public void setNPSClickListener(C0821a c0821a) {
        this.f9996d = c0821a;
    }

    public void setSelectedAnswer(String str) {
        for (TextView textView : this.f9994b) {
            if (textView.getText().toString().equals(str)) {
                setTextViewColorsSelected(textView);
            } else {
                setTextViewColorsAccordingToTheme(textView);
            }
        }
    }

    static /* synthetic */ void m8443a(NPSLayout nPSLayout, int i) {
        int i2 = 0;
        for (TextView textView : nPSLayout.f9994b) {
            if (i2 == i) {
                nPSLayout.setTextViewColorsSelected(textView);
            } else {
                nPSLayout.setTextViewColorsAccordingToTheme(textView);
            }
            i2++;
        }
    }
}
