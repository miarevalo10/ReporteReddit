package android.support.v4.app;

import android.support.v4.content.Loader;

public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        Loader<D> mo1526a();

        void mo1527a(D d);

        void mo1528b();
    }

    public abstract <D> Loader<D> mo252a(int i, LoaderCallbacks<D> loaderCallbacks);

    public boolean mo253a() {
        return false;
    }

    public abstract <D> Loader<D> mo254b(int i, LoaderCallbacks<D> loaderCallbacks);
}
