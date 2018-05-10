package com.reddit.datalibrary.frontpage.data.provider;

import android.app.Activity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v7.app.AppCompatActivity;
import com.google.common.primitives.Ints;
import com.raizlabs.android.dbflow.structure.Model;

public abstract class LoaderProvider<T extends Model> extends BaseOtherProvider implements LoaderCallbacks<DelegatedFlowCursorList<T>> {
    private final int f16260a;
    private DelegatedFlowCursorList<T> f16261b;
    private boolean f16262c = true;

    protected abstract void mo3803d();

    public final /* synthetic */ void mo1527a(Object obj) {
        this.f16261b = (DelegatedFlowCursorList) obj;
        mo3803d();
    }

    LoaderProvider(int i) {
        this.f16260a = i;
    }

    public final void m16266a(Activity activity) {
        if (this.f16262c) {
            ((AppCompatActivity) activity).getSupportLoaderManager().mo254b(this.f16260a, this);
            this.f16262c = null;
            return;
        }
        ((AppCompatActivity) activity).getSupportLoaderManager().mo252a(this.f16260a, this);
    }

    public T mo3804a(int i) {
        return this.f16261b != null ? (Model) this.f16261b.getItem((long) i) : null;
    }

    public final int m16269c() {
        return this.f16261b != null ? Ints.m7283a(this.f16261b.getCount()) : 0;
    }

    public final void mo1528b() {
        this.f16261b = null;
    }
}
