package com.reddit.frontpage.ui.alert;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ContextsKt;

public class DialogMenu {
    LayoutInflater f21082a;
    final LinearLayout f21083b;
    OnMenuItemClickListener f21084c;
    public OnDismissListener f21085d;
    final OnClickListener f21086e;
    private Context f21087f;
    private final ScrollView f21088g;
    private Dialog f21089h;

    class C18781 implements OnClickListener {
        final /* synthetic */ DialogMenu f21080a;

        C18781(DialogMenu dialogMenu) {
            this.f21080a = dialogMenu;
        }

        public void onClick(View view) {
            MenuItem menuItem = (MenuItem) view.getTag();
            if (this.f21080a.f21084c != null) {
                this.f21080a.f21084c.a(menuItem);
            }
            this.f21080a.f21089h.dismiss();
            this.f21080a.f21087f = null;
            this.f21080a.f21082a = null;
        }
    }

    public static class Builder {
        public DialogMenu f21081a = null;

        public Builder(Context context) {
            this.f21081a = new DialogMenu(context);
        }

        public final Builder m23277a(OnMenuItemClickListener onMenuItemClickListener) {
            this.f21081a.f21084c = onMenuItemClickListener;
            return this;
        }

        public final Builder m23278a(Menu menu) {
            DialogMenu dialogMenu = this.f21081a;
            int size = menu.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = menu.getItem(i);
                if (item.isVisible()) {
                    View inflate = dialogMenu.f21082a.inflate(C1761R.layout.listitem_popup_row, dialogMenu.f21083b, false);
                    inflate.setTag(item);
                    ImageView imageView = (ImageView) inflate.findViewById(C1761R.id.icon);
                    TextView textView = (TextView) inflate.findViewById(C1761R.id.text);
                    if (item.getIcon() != null) {
                        imageView.setImageDrawable(item.getIcon());
                    } else {
                        imageView.setVisibility(8);
                    }
                    if (item.getTitle() != null) {
                        textView.setText(item.getTitle());
                    }
                    if (item.isEnabled()) {
                        inflate.setOnClickListener(dialogMenu.f21086e);
                    } else {
                        textView.setAlpha(0.25f);
                        imageView.setAlpha(0.25f);
                        inflate.setClickable(false);
                    }
                    dialogMenu.f21083b.addView(inflate);
                }
            }
            return this;
        }

        public final DialogMenu m23279a() {
            return this.f21081a;
        }
    }

    private DialogMenu(Context context) {
        this.f21086e = new C18781(this);
        this.f21087f = context;
        this.f21082a = LayoutInflater.from(this.f21087f);
        this.f21083b = new LinearLayout(context);
        this.f21083b.setOrientation(1);
        this.f21088g = new ScrollView(context);
        this.f21088g.addView(this.f21083b);
        context = Util.m24012d((int) C1761R.dimen.quarter_pad);
        this.f21083b.setPadding(0, context, 0, context);
    }

    public final void m23284a() {
        this.f21089h = new android.support.v7.app.AlertDialog.Builder(ContextsKt.m24076a(this.f21087f)).a(this.f21088g).a(this.f21085d).c();
    }
}
