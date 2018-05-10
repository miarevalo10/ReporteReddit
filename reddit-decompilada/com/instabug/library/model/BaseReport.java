package com.instabug.library.model;

import java.io.Serializable;

public abstract class BaseReport implements Serializable {
    private boolean hasVideo = false;
    protected String id;
    private boolean isVideoEncoded = false;
    protected State state;

    public String getId() {
        return this.id;
    }

    public BaseReport setId(String str) {
        this.id = str;
        return this;
    }

    public State getState() {
        return this.state;
    }

    public BaseReport setState(State state) {
        this.state = state;
        return this;
    }

    public boolean hasVideo() {
        return this.hasVideo;
    }

    public BaseReport setHasVideo(boolean z) {
        this.hasVideo = z;
        return this;
    }

    public boolean isVideoEncoded() {
        return this.isVideoEncoded;
    }

    public BaseReport setVideoEncoded(boolean z) {
        this.isVideoEncoded = z;
        return this;
    }
}
