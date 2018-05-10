package com.reddit.datalibrary.frontpage.redditauth.api.errors;

import java.util.List;

public class LoginError extends Throwable {
    public final String f10849a;
    public final String f10850b;
    public final String f10851c;

    public LoginError(List<String> list) {
        this.f10849a = (String) list.get(0);
        this.f10850b = (String) list.get(1);
        this.f10851c = (String) list.get(2);
    }

    public String toString() {
        return String.format("[%s, %s, %s]", new Object[]{this.f10849a, this.f10850b, this.f10851c});
    }
}
