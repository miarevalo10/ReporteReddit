package com.instabug.bug.view.p002a;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageButton;
import com.instabug.bug.C0465R;
import com.instabug.bug.view.p002a.C0496a.C1278b;
import com.instabug.library.C0593R;
import com.instabug.library.annotation.AnnotationLayout;
import com.instabug.library.core.ui.ToolbarFragment;
import java.io.Serializable;

/* compiled from: AnnotationFragment */
public class C1728b extends ToolbarFragment<C1626c> implements C1278b {
    private String f19727a;
    private Uri f19728b;
    private AnnotationLayout f19729c;
    private C0497a f19730d;
    private int f19731e;
    private ImageButton f19732f;

    /* compiled from: AnnotationFragment */
    public interface C0497a extends Serializable {
        void mo4427a(Bitmap bitmap, Uri uri);
    }

    protected void onCloseButtonClicked() {
    }

    public static C1728b m21285a(String str, Uri uri, int i) {
        C1728b c1728b = new C1728b();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putParcelable("image_uri", uri);
        bundle.putSerializable("type", Integer.valueOf(i));
        c1728b.setArguments(bundle);
        return c1728b;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19727a = getArguments().getString("title");
        this.f19728b = (Uri) getArguments().getParcelable("image_uri");
        this.f19731e = getArguments().getInt("type");
        this.presenter = new C1626c(this);
        this.f19730d = (C0497a) getActivity();
    }

    protected int getContentLayout() {
        return C0465R.layout.instabug_fragment_annotation;
    }

    protected void initContentViews(View view, Bundle bundle) {
        this.f19732f = (ImageButton) view.findViewById(C0593R.id.instabug_btn_toolbar_right);
        this.f19729c = (AnnotationLayout) findViewById(C0593R.id.annotationLayout);
        ((C1626c) this.presenter).m19374a(this.f19731e, this.f19728b);
    }

    protected String getTitle() {
        return this.f19727a;
    }

    protected void onDoneButtonClicked() {
        this.f19730d.mo4427a(this.f19729c.getAnnotatedBitmap(), this.f19728b);
        getActivity().getSupportFragmentManager().mo219a().mo196a((Fragment) this).mo203c();
        getActivity().getSupportFragmentManager().mo224b("annotation_fragment_for_bug");
    }

    public final void mo4308a(int i) {
        this.f19732f.setImageResource(i);
    }

    public final void mo4309a(Uri uri) {
        this.f19729c.setBaseImage(uri, null);
    }

    public final void mo4307a() {
        this.f19732f.setRotation(0.0f);
    }
}
