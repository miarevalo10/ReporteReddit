package com.instabug.chat.ui.p009a;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageButton;
import com.instabug.chat.C0520R;
import com.instabug.chat.ui.p009a.C0557a.C1315a;
import com.instabug.chat.ui.p009a.C0557a.C1316b;
import com.instabug.library.C0593R;
import com.instabug.library.annotation.AnnotationLayout;
import com.instabug.library.core.ui.ToolbarFragment;

/* compiled from: AnnotationFragment */
public class C1731b extends ToolbarFragment<C1315a> implements C1316b {
    private String f19751a;
    private String f19752b;
    private Uri f19753c;
    private AnnotationLayout f19754d;
    private C0558a f19755e;

    /* compiled from: AnnotationFragment */
    public interface C0558a {
        void mo4330a(String str, Uri uri);
    }

    protected void onCloseButtonClicked() {
    }

    public static C1731b m21322a(String str, String str2, Uri uri) {
        C1731b c1731b = new C1731b();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("chat_id", str2);
        bundle.putParcelable("image_uri", uri);
        c1731b.setArguments(bundle);
        return c1731b;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19755e = (C0558a) getActivity().getSupportFragmentManager().mo218a("chat_fragment");
        this.f19751a = getArguments().getString("title");
        this.f19752b = getArguments().getString("chat_id");
        this.f19753c = (Uri) getArguments().getParcelable("image_uri");
        this.presenter = new C1638c(this);
    }

    protected int getContentLayout() {
        return C0520R.layout.instabug_fragment_annotation;
    }

    protected void initContentViews(View view, Bundle bundle) {
        ((ImageButton) view.findViewById(C0593R.id.instabug_btn_toolbar_right)).setImageResource(C0593R.drawable.instabug_ic_send);
        this.f19754d = (AnnotationLayout) view.findViewById(C0593R.id.annotationLayout);
        this.f19754d.setBaseImage(this.f19753c, null);
    }

    protected String getTitle() {
        return this.f19751a;
    }

    protected void onDoneButtonClicked() {
        ((C1315a) this.presenter).mo3645a(this.f19754d.getAnnotatedBitmap(), this.f19753c);
        if (this.f19755e != null) {
            this.f19755e.mo4330a(this.f19752b, this.f19753c);
        }
        getActivity().getSupportFragmentManager().mo219a().mo196a((Fragment) this).mo203c();
        getActivity().getSupportFragmentManager().mo224b("annotation_fragment_for_chat");
    }
}
