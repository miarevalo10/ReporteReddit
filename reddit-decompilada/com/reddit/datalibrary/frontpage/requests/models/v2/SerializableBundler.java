package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import java.io.Serializable;

public class SerializableBundler<T extends Serializable> implements Bundler<T> {
    public /* synthetic */ void put(String str, Object obj, Bundle bundle) {
        bundle.putSerializable(str, (Serializable) obj);
    }

    public /* synthetic */ Object get(String str, Bundle bundle) {
        return bundle.getSerializable(str);
    }
}
