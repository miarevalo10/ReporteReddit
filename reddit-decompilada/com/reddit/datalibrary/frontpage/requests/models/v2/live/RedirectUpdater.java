package com.reddit.datalibrary.frontpage.requests.models.v2.live;

public interface RedirectUpdater {
    void onFailure(Throwable th, String str);

    void onRedirect(String str);
}
