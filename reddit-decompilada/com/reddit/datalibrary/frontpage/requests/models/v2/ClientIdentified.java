package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.reddit.frontpage.util.Util;

public abstract class ClientIdentified implements Identifiable {
    long _uniqueId;

    ClientIdentified() {
        this._uniqueId = Util.m24013d();
    }

    ClientIdentified(long j) {
        this._uniqueId = j;
    }

    public long getUniqueID() {
        return this._uniqueId;
    }
}
