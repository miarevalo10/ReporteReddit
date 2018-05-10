package com.instabug.survey.ui.p031a.p032b;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.instabug.library.Instabug;
import com.instabug.library.util.AttrResolver;
import com.instabug.survey.C0787R;
import com.instabug.survey.p027a.C1412b;

/* compiled from: SurveyMCQGridAdapter */
public class C0812b extends BaseAdapter {
    private final LayoutInflater f9979a;
    private C0810a f9980b;
    private C1412b f9981c;
    private int f9982d = -1;
    private Context f9983e;

    /* compiled from: SurveyMCQGridAdapter */
    public interface C0810a {
        void mo4347a(String str);
    }

    /* compiled from: SurveyMCQGridAdapter */
    private static class C0811b {
        TextView f9978a;

        private C0811b() {
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public /* synthetic */ Object getItem(int i) {
        return m8435a(i);
    }

    public C0812b(Activity activity, C1412b c1412b, C0810a c0810a) {
        this.f9983e = activity;
        this.f9979a = LayoutInflater.from(activity);
        this.f9981c = c1412b;
        m8436a(c1412b);
        this.f9980b = c0810a;
    }

    public int getCount() {
        return (this.f9981c == null || this.f9981c.f15568d == null) ? 0 : this.f9981c.f15568d.size();
    }

    private String m8435a(int i) {
        return (String) this.f9981c.f15568d.get(i);
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new C0811b();
            viewGroup = this.f9979a.inflate(C0787R.layout.instabug_survey_mcq_item, null);
            view.f9978a = (TextView) viewGroup.findViewById(C0787R.id.ib_survey_optionalAnswer_tv);
            viewGroup.setTag(view);
        } else {
            viewGroup = view;
            view = (C0811b) view.getTag();
        }
        view.f9978a.setText((CharSequence) this.f9981c.f15568d.get(i));
        if (i == this.f9982d) {
            view.f9978a.setBackgroundColor(Instabug.getPrimaryColor());
            view.f9978a.setTextColor(-1);
        } else {
            view.f9978a.setBackgroundColor(AttrResolver.resolveAttributeColor(this.f9983e, C0787R.attr.instabug_survey_mcq_unselected_bg));
            view.f9978a.setTextColor(AttrResolver.resolveAttributeColor(this.f9983e, C0787R.attr.instabug_survey_mcq_text_color));
        }
        final String str = (String) this.f9981c.f15568d.get(i);
        view.f9978a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C0812b f9977c;

            public void onClick(View view) {
                C0812b.m8437a(this.f9977c, i);
                this.f9977c.f9980b.mo4347a(str);
            }
        });
        return viewGroup;
    }

    public final String m8438a() {
        if (this.f9982d == -1) {
            return null;
        }
        return m8435a(this.f9982d);
    }

    private void m8436a(C1412b c1412b) {
        int i = 0;
        while (i < c1412b.f15568d.size()) {
            if (c1412b.f15569e == null || !c1412b.f15569e.equals(c1412b.f15568d.get(i))) {
                i++;
            } else {
                this.f9982d = i;
                return;
            }
        }
    }

    static /* synthetic */ void m8437a(C0812b c0812b, int i) {
        c0812b.f9982d = i;
        c0812b.notifyDataSetChanged();
    }
}
