package com.instabug.library.ui.promptoptions;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.instabug.library.C0593R;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.util.Colorizer;
import java.util.ArrayList;

/* compiled from: PromptOptionsAdapter */
public class C0766a extends BaseAdapter {
    ArrayList<PluginPromptOption> f9893a = new ArrayList();

    /* compiled from: PromptOptionsAdapter */
    private static class C0765a {
        public ImageView f9890a;
        public TextView f9891b;
        public TextView f9892c;

        C0765a(View view) {
            this.f9890a = (ImageView) view.findViewById(C0593R.id.instabug_prompt_option_icon);
            this.f9891b = (TextView) view.findViewById(C0593R.id.instabug_prompt_option_title);
            this.f9892c = (TextView) view.findViewById(C0593R.id.instabug_notification_count);
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m8338a(i);
    }

    public int getCount() {
        return this.f9893a.size();
    }

    private PluginPromptOption m8338a(int i) {
        return (PluginPromptOption) this.f9893a.get(i);
    }

    public long getItemId(int i) {
        return (long) ((PluginPromptOption) this.f9893a.get(i)).getOrder();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(C0593R.layout.instabug_list_item_prompt_option, viewGroup, false);
            viewGroup = new C0765a(view);
            view.setTag(viewGroup);
        } else {
            viewGroup = (C0765a) view.getTag();
        }
        i = m8338a(i);
        viewGroup.f9891b.setText(i.getTitle());
        viewGroup.f9890a.setImageResource(i.getIcon());
        if (i.getNotificationCount() > 0) {
            viewGroup.f9892c.setVisibility(0);
            viewGroup.f9892c.setBackgroundDrawable(Colorizer.getPrimaryColorTintedDrawable(ContextCompat.m714a(viewGroup.f9892c.getContext(), C0593R.drawable.instabug_bg_white_oval)));
            viewGroup.f9892c.setText(String.valueOf(i.getNotificationCount()));
        } else {
            viewGroup.f9892c.setVisibility(8);
        }
        return view;
    }
}
