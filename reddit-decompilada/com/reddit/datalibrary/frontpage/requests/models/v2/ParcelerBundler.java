package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import org.parceler.Parcels;

public class ParcelerBundler<T> implements Bundler<T> {
    public void put(String str, T t, Bundle bundle) {
        bundle.putParcelable(str, Parcels.m28672a((Object) t));
    }

    public T get(String str, Bundle bundle) {
        return Parcels.m28673a(bundle.getParcelable(str));
    }
}
