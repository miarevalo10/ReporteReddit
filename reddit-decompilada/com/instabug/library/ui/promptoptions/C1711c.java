package com.instabug.library.ui.promptoptions;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.instabug.library.C0593R;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.core.ui.BaseFragment;
import com.instabug.library.invocation.C1381b;
import com.instabug.library.ui.promptoptions.C0767b.C1400b;
import com.instabug.library.util.InstabugLogoProvider;
import java.util.ArrayList;

/* compiled from: PromptOptionsFragment */
public class C1711c extends BaseFragment<C1668d> implements OnClickListener, OnItemClickListener, C1400b {
    private Uri f19293a;
    private C0768a f19294b;
    private TextView f19295c;
    private C0766a f19296d;
    private ArrayList<PluginPromptOption> f19297e;

    /* compiled from: PromptOptionsFragment */
    interface C0768a {
        void mo4444a();
    }

    public static C1711c m20533a(Uri uri) {
        C1711c c1711c = new C1711c();
        Bundle bundle = new Bundle();
        bundle.putParcelable("screenshotUri", uri);
        c1711c.setArguments(bundle);
        return c1711c;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.presenter == null) {
            this.presenter = new C1668d(this);
        }
        this.f19297e = C1381b.m15431c().m15441f();
        this.f19293a = (Uri) getArguments().getParcelable("screenshotUri");
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof C0768a) {
            this.f19294b = (C0768a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnHomeFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.f19294b = null;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        C1668d.m19522c();
    }

    protected int getLayout() {
        return C0593R.layout.instabug_fragment_prompt_options;
    }

    protected void initViews(View view, Bundle bundle) {
        this.f19295c = (TextView) findViewById(C0593R.id.instabug_fragment_title);
        ListView listView = (ListView) findViewById(C0593R.id.instabug_prompt_options_list_view);
        listView.setOnItemClickListener(this);
        this.f19296d = new C0766a();
        listView.setAdapter(this.f19296d);
        findViewById(C0593R.id.instabug_prompt_options_dialog_container).setOnClickListener(this);
    }

    public void onStart() {
        super.onStart();
        ((C1668d) this.presenter).m19523a();
    }

    public void onStop() {
        super.onStop();
        ((C1668d) this.presenter).m19524b();
    }

    public final void mo4073a(String str) {
        this.f19295c.setText(str);
    }

    public final void mo4072a() {
        if (this.f19297e != null && this.f19297e.size() > 0) {
            this.f19296d.f9893a = this.f19297e;
            this.f19296d.notifyDataSetChanged();
        }
    }

    public final void mo4074b() {
        getActivity().findViewById(C0593R.id.instabug_pbi_footer).setVisibility(8);
        findViewById(C0593R.id.instabug_pbi_container).setVisibility(0);
        ImageView imageView = (ImageView) findViewById(C0593R.id.image_instabug_logo);
        imageView.setColorFilter(Color.parseColor("#FFFFFF"), Mode.SRC_ATOP);
        imageView.setImageBitmap(InstabugLogoProvider.getInstabugLogo());
    }

    public final void mo4075c() {
        findViewById(C0593R.id.instabug_pbi_container).setVisibility(8);
    }

    public void onClick(View view) {
        if (view.getId() == C0593R.id.instabug_prompt_options_dialog_container) {
            finishActivity();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ((C1668d) this.presenter).m19524b();
        ((PluginPromptOption) this.f19297e.get(i)).invoke(this.f19293a);
        if (this.f19294b != null) {
            this.f19294b.mo4444a();
        }
        finishActivity();
    }
}
