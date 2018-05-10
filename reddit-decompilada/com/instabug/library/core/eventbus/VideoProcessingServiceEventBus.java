package com.instabug.library.core.eventbus;

import com.instabug.library.internal.video.VideoProcessingService.Action;

public class VideoProcessingServiceEventBus extends EventBus<Action> {
    private static VideoProcessingServiceEventBus instance;

    public static VideoProcessingServiceEventBus getInstance() {
        if (instance == null) {
            instance = new VideoProcessingServiceEventBus();
        }
        return instance;
    }
}
