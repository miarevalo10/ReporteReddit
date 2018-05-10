package com.instabug.library.core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.TextView;
import com.instabug.library.C0593R;
import com.instabug.library.core.ui.BaseContract.Presenter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.SystemServiceUtils;

public abstract class ToolbarFragment<P extends Presenter> extends BaseFragment<P> {
    protected ImageButton toolbarImageButtonClose;
    protected ImageButton toolbarImageButtonDone;

    class C06581 implements OnClickListener {
        final /* synthetic */ ToolbarFragment f9585a;

        C06581(ToolbarFragment toolbarFragment) {
            this.f9585a = toolbarFragment;
        }

        public void onClick(View view) {
            SystemServiceUtils.hideInputMethod(this.f9585a.getActivity());
            this.f9585a.onDoneButtonClicked();
        }
    }

    class C06592 implements OnClickListener {
        final /* synthetic */ ToolbarFragment f9586a;

        C06592(ToolbarFragment toolbarFragment) {
            this.f9586a = toolbarFragment;
        }

        public void onClick(View view) {
            SystemServiceUtils.hideInputMethod(this.f9586a.getActivity());
            this.f9586a.onCloseButtonClicked();
            this.f9586a.getActivity().onBackPressed();
        }
    }

    public abstract int getContentLayout();

    public abstract String getTitle();

    public abstract void initContentViews(View view, Bundle bundle);

    public abstract void onCloseButtonClicked();

    public abstract void onDoneButtonClicked();

    protected void initViews(View view, Bundle bundle) {
        initToolbarViews();
        ViewStub viewStub = (ViewStub) findViewById(C0593R.id.instabug_content);
        viewStub.setLayoutResource(getContentLayout());
        viewStub.inflate();
        initContentViews(view, bundle);
        setTitle(getTitle());
    }

    private void initToolbarViews() {
        this.toolbarImageButtonDone = (ImageButton) findViewById(C0593R.id.instabug_btn_toolbar_right);
        this.toolbarImageButtonDone.setOnClickListener(new C06581(this));
        this.toolbarImageButtonClose = (ImageButton) findViewById(C0593R.id.instabug_btn_toolbar_left);
        this.toolbarImageButtonClose.setOnClickListener(new C06592(this));
    }

    protected int getLayout() {
        return C0593R.layout.instabug_fragment_toolbar;
    }

    protected void setTitle(String str) {
        if (this.rootView == null) {
            InstabugSDKLogger.m8360v(this, "Calling setTitle before inflating the view! Ignoring call");
            return;
        }
        TextView textView = (TextView) findViewById(C0593R.id.instabug_fragment_title);
        StringBuilder stringBuilder = new StringBuilder("Setting fragment title to \"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        textView.setText(str);
    }
}
