package com.reddit.datalibrary.frontpage.data.provider;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import com.raizlabs.android.dbflow.list.FlowCursorList.Builder;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.structure.Model;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase;

public class DBFlowLoader<T extends Model> extends AsyncTaskLoader<DelegatedFlowCursorList<T>> {
    private final ModelQueriable<T> f18735o;
    private DelegatedFlowCursorList<T> f18736p;

    public final /* synthetic */ void mo3791a(Object obj) {
        DelegatedFlowCursorList delegatedFlowCursorList = (DelegatedFlowCursorList) obj;
        if (delegatedFlowCursorList != null) {
            delegatedFlowCursorList.close();
        }
    }

    public final /* synthetic */ void mo3792b(Object obj) {
        m19707a((DelegatedFlowCursorList) obj);
    }

    public DBFlowLoader(Context context, ModelQueriable<T> modelQueriable) {
        super(context);
        this.f18735o = modelQueriable;
    }

    protected final void mo3403f() {
        if (this.f18736p != null) {
            m19707a(this.f18736p);
        }
        boolean z = this.f1193m;
        this.f1193m = false;
        this.f1194n |= z;
        if (z || this.f18736p == null) {
            m739h();
        }
    }

    protected final void mo3793j() {
        m738g();
    }

    protected final void mo3794l() {
        super.mo3794l();
        m738g();
        if (this.f18736p != null) {
            this.f18736p.close();
        }
        this.f18736p = null;
    }

    private void m19707a(DelegatedFlowCursorList<T> delegatedFlowCursorList) {
        if (this.f1192l) {
            if (delegatedFlowCursorList != null) {
                delegatedFlowCursorList.close();
            }
            return;
        }
        DelegatedFlowCursorList<T> delegatedFlowCursorList2 = this.f18736p;
        this.f18736p = delegatedFlowCursorList;
        if (this.f1190j) {
            super.mo3792b(delegatedFlowCursorList);
        }
        if (!(delegatedFlowCursorList2 == null || delegatedFlowCursorList2 == delegatedFlowCursorList)) {
            delegatedFlowCursorList2.close();
        }
    }

    public final /* synthetic */ Object mo3402d() {
        RedditFlowDatabase.m8769c();
        return new DelegatedFlowCursorList(new Builder(this.f18735o).cacheModels(false));
    }
}
