package com.reddit.frontpage.debug;

final /* synthetic */ class DebugActivity$$Lambda$12 implements Runnable {
    private final DebugActivity f20124a;

    DebugActivity$$Lambda$12(DebugActivity debugActivity) {
        this.f20124a = debugActivity;
    }

    public final void run() {
        DebugActivity debugActivity = this.f20124a;
        debugActivity.setResult(2);
        debugActivity.finish();
    }
}
