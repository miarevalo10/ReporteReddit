package com.instabug.chat.ui.p011c;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import com.instabug.chat.C0520R;
import com.instabug.chat.model.Chat;
import com.instabug.chat.ui.p011c.C0577b.C1328a;
import com.instabug.chat.ui.p011c.C0577b.C1329b;
import com.instabug.library.InstabugCustomTextPlaceHolder.Key;
import com.instabug.library.core.ui.ToolbarFragment;
import com.instabug.library.util.Colorizer;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.PlaceHolderUtils;
import java.util.ArrayList;

/* compiled from: ChatsFragment */
public class C1733c extends ToolbarFragment<C1328a> implements OnClickListener, OnItemClickListener, C1329b {
    private C0576a f19759a;
    private ArrayList<Chat> f19760b;
    private C0578a f19761c;

    /* compiled from: ChatsFragment */
    public interface C0578a {
        void mo4441b(String str);

        void mo4443d();
    }

    protected void onCloseButtonClicked() {
    }

    protected void onDoneButtonClicked() {
    }

    public static C1733c m21341c() {
        C1733c c1733c = new C1733c();
        c1733c.setArguments(new Bundle());
        return c1733c;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19761c = (C0578a) getActivity();
        this.presenter = new C1641d(this);
        this.f19760b = new ArrayList();
    }

    protected int getContentLayout() {
        return C0520R.layout.instabug_fragment_chats;
    }

    protected void initContentViews(View view, Bundle bundle) {
        view.findViewById(C0520R.id.instabug_btn_toolbar_right).setVisibility(8);
        ListView listView = (ListView) view.findViewById(C0520R.id.instabug_lst_chats);
        listView.setOnItemClickListener(this);
        this.f19759a = new C0576a(getActivity(), this.f19760b);
        listView.setAdapter(this.f19759a);
        ImageButton imageButton = (ImageButton) view.findViewById(C0520R.id.instabug_btn_new_chat);
        imageButton.setBackgroundDrawable(Colorizer.getPrimaryColorTintedDrawable(ContextCompat.m714a(getContext(), C0520R.drawable.instabug_bg_white_oval)));
        imageButton.setOnClickListener(this);
    }

    protected String getTitle() {
        return PlaceHolderUtils.getPlaceHolder(Key.CONVERSATIONS_LIST_TITLE, getString(C0520R.string.instabug_str_conversations));
    }

    public void onStart() {
        super.onStart();
        ((C1328a) this.presenter).mo3664a();
    }

    public void onStop() {
        super.onStop();
        ((C1328a) this.presenter).mo3665b();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j = new StringBuilder("Chat id: ");
        j.append(((Chat) adapterView.getItemAtPosition(i)).getId());
        InstabugSDKLogger.m8360v(C1733c.class, j.toString());
        if (this.f19761c != null) {
            this.f19761c.mo4441b(((Chat) adapterView.getItemAtPosition(i)).getId());
        }
    }

    public void onClick(View view) {
        if (view.getId() == C0520R.id.instabug_btn_new_chat && this.f19761c != null) {
            this.f19761c.mo4443d();
        }
    }

    public final void mo4344a(ArrayList<Chat> arrayList) {
        this.f19760b = arrayList;
    }

    public final void mo4343a() {
        this.f19759a.f9343a = this.f19760b;
        this.f19759a.notifyDataSetChanged();
    }

    public final boolean mo4345b() {
        return getFragmentManager().mo216a(C0520R.id.instabug_fragment_container) instanceof C1733c;
    }
}
