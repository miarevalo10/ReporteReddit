package com.reddit.datalibrary.frontpage.requests.models.v1;

import java.io.Serializable;

@Deprecated
public abstract class ThingWrapper<T extends Thing> implements Serializable {
    private T data;
    private String kind;

    public String getKind() {
        return this.kind;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }
}
