package com.reddit.frontpage.video.mpdparser.data.model;

import java.util.List;

public class SimpleManifest implements DashManifest {
    private final String f29418a = null;
    private final String f29419b = null;
    private final String f29420c = null;
    private final String f29421d = null;
    private final String f29422e = null;
    private final List<Period> f29423f = null;

    public int mo5048a() {
        return this.f29423f.size();
    }

    public Period mo5049a(int i) {
        return (Period) this.f29423f.get(i);
    }
}
