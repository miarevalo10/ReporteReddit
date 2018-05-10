package com.instabug.bug.view.actionList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.instabug.bug.BugPlugin;
import com.instabug.bug.C0470c;
import com.instabug.bug.view.actionList.C0502c.C1279a;
import com.instabug.library.C0593R;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseFragment;
import com.instabug.library.util.InstabugLogoProvider;
import java.util.ArrayList;

/* compiled from: ActionsListFragment */
public class C1707d extends BaseFragment<C1627e> implements OnClickListener, C1279a {
    private ArrayList<C0499a> f19282a;
    private String f19283b;

    public static C1707d m20527a(String str, ArrayList<C0499a> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putSerializable("actionsList", arrayList);
        str = new C1707d();
        str.setArguments(bundle);
        return str;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (this.presenter == null) {
            this.presenter = new C1627e(this);
        }
        if (getArguments() != null) {
            this.f19283b = getArguments().getString("title");
            this.f19282a = (ArrayList) getArguments().getSerializable("actionsList");
            getArguments().remove("actionsList");
        }
    }

    protected int getLayout() {
        return C0593R.layout.instabug_lyt_actions_list;
    }

    protected void initViews(View view, Bundle bundle) {
        ((TextView) findViewById(C0593R.id.instabug_fragment_title)).setText(this.f19283b);
        ListView listView = (ListView) findViewById(C0593R.id.instabug_actions_list);
        bundle = new C0501b(this.f19282a);
        listView.setAdapter(bundle);
        listView.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ C1707d f9187b;

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ((C0499a) bundle.f9185a.get(i)).f9182c.run();
                this.f9187b.getActivity().getSupportFragmentManager().mo219a().mo196a(this.f9187b).mo203c();
            }
        });
        findViewById(C0593R.id.instabug_container).setOnClickListener(this);
        findViewById(C0593R.id.instabug_fragment_title).setOnClickListener(this);
        if (InstabugCore.getFeatureState(Feature.WHITE_LABELING) == State.ENABLED) {
            findViewById(C0593R.id.instabug_pbi_container).setVisibility(8);
            return;
        }
        findViewById(C0593R.id.instabug_pbi_container).setVisibility(null);
        ((ImageView) findViewById(C0593R.id.image_instabug_logo)).setImageBitmap(InstabugLogoProvider.getInstabugLogo());
    }

    public void onClick(View view) {
        view = view.getId();
        if (view == C0593R.id.instabug_container || view == C0593R.id.instabug_fragment_title) {
            getActivity().finish();
            C0470c.m7757a();
            BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
            if (bugPlugin != null && bugPlugin.getState() != 2) {
                bugPlugin.setState(0);
            }
        }
    }
}
