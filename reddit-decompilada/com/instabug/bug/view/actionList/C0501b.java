package com.instabug.bug.view.actionList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.instabug.library.C0593R;
import java.util.List;

/* compiled from: ActionsListAdapter */
public class C0501b extends BaseAdapter {
    final List<C0499a> f9185a;

    /* compiled from: ActionsListAdapter */
    private static class C0500a {
        TextView f9183a;
        ImageView f9184b;

        C0500a(View view) {
            this.f9183a = (TextView) view.findViewById(C0593R.id.instabug_label);
            this.f9184b = (ImageView) view.findViewById(C0593R.id.instabug_icon);
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public /* synthetic */ Object getItem(int i) {
        return m7837a(i);
    }

    public C0501b(List<C0499a> list) {
        this.f9185a = list;
    }

    public int getCount() {
        return this.f9185a.size();
    }

    private C0499a m7837a(int i) {
        return (C0499a) this.f9185a.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(C0593R.layout.instabug_item_actions_list, viewGroup, false);
            viewGroup = new C0500a(view);
            view.setTag(viewGroup);
        } else {
            viewGroup = (C0500a) view.getTag();
        }
        i = m7837a(i);
        viewGroup.f9183a.setText(i.f9180a);
        if (i.f9181b > 0) {
            viewGroup.f9184b.setImageResource(i.f9181b);
            viewGroup.f9184b.setVisibility(0);
        } else {
            viewGroup.f9184b.setVisibility(8);
        }
        return view;
    }
}
