package com.reddit.frontpage.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import com.evernote.android.state.StateSaver;
import com.reddit.frontpage.widgets.action.RedditAction;

public abstract class RedditView extends FrameLayout {
    protected RedditAction f21940a;

    public abstract int getLayoutId();

    public RedditView(Context context) {
        super(context);
        mo5070a();
    }

    public RedditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo5070a();
    }

    public RedditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo5070a();
    }

    @TargetApi(21)
    public RedditView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        mo5070a();
    }

    public void mo5070a() {
        inflate(getContext(), getLayoutId(), this);
        ButterKnife.a(this);
    }

    protected Parcelable onSaveInstanceState() {
        return StateSaver.saveInstanceState(this, super.onSaveInstanceState());
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(StateSaver.restoreInstanceState(this, parcelable));
    }

    static final /* synthetic */ void m24190a(RedditAction redditAction) {
        if (!redditAction.mo5065a() || redditAction.mo6540b() != null) {
        }
    }
}
