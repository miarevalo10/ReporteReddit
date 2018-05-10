package com.google.android.gms.common.api;

public class Response<T extends Result> {
    private T zzfne;

    protected Response(T t) {
        this.zzfne = t;
    }

    protected T getResult() {
        return this.zzfne;
    }

    public void setResult(T t) {
        this.zzfne = t;
    }
}
