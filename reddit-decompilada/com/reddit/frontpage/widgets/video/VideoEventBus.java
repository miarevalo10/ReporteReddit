package com.reddit.frontpage.widgets.video;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoEventBus {
    public static final int VIDEO_EVENT_HIDE_AFTER_TIMEOUT = 3;
    public static final int VIDEO_EVENT_HIDE_CONTROL = 1;
    public static final int VIDEO_EVENT_SHOW_CONTROL = 0;
    public static final int VIDEO_EVENT_SHOW_CONTROL_PERMANENTLY = 2;
    private final Subject<VideoEventWrapper> bus = PublishSubject.create();
    private final AtomicInteger index = new AtomicInteger(0);

    public static final class VideoEventWrapper {
        public final int f22206a;
        public final int f22207b;

        public VideoEventWrapper(int i, int i2) {
            this.f22206a = i;
            this.f22207b = i2;
        }
    }

    public int getSenderId() {
        return this.index.getAndIncrement();
    }

    public void post(VideoEventWrapper videoEventWrapper) {
        this.bus.onNext(videoEventWrapper);
    }

    public Observable<VideoEventWrapper> asObservable() {
        return this.bus;
    }
}
