package com.reddit.frontpage.presentation.modtools.base;

import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.Presenter;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H&J\b\u0010\u0019\u001a\u00020\u0017H&J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0005H&R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsPresenter;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "()V", "after", "", "getAfter", "()Ljava/lang/String;", "setAfter", "(Ljava/lang/String;)V", "allUsersLoaded", "", "getAllUsersLoaded", "()Z", "setAllUsersLoaded", "(Z)V", "loadingUsers", "getLoadingUsers", "setLoadingUsers", "previouslyAttached", "getPreviouslyAttached", "setPreviouslyAttached", "attach", "", "loadUsers", "performNegativeAction", "reload", "searchUser", "username", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BaseModeratorsPresenter.kt */
public abstract class BaseModeratorsPresenter extends DisposablePresenter implements Presenter {
    private boolean f34069a;
    public String f34070b;
    public boolean f34071c;
    public boolean f34072d;

    public abstract void mo6481a();

    public void destroy() {
    }

    public void attach() {
        if (!this.f34069a) {
            this.f34069a = true;
            mo6481a();
        }
    }

    public final void mo6482d() {
        this.f34070b = null;
        this.f34071c = false;
        this.f34072d = false;
        mo6481a();
    }
}
