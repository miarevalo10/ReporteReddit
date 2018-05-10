package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;

public interface EngineJobListener {
    void mo919a(EngineJob<?> engineJob, Key key);

    void mo920a(EngineJob<?> engineJob, Key key, EngineResource<?> engineResource);
}
