package com.reddit.datalibrary.frontpage.service.api;

import android.os.HandlerThread;

final /* synthetic */ class SubmitService$$Lambda$0 implements Runnable {
    private final SubmitService arg$1;
    private final String arg$2;
    private final String arg$3;
    private final HandlerThread arg$4;

    SubmitService$$Lambda$0(SubmitService submitService, String str, String str2, HandlerThread handlerThread) {
        this.arg$1 = submitService;
        this.arg$2 = str;
        this.arg$3 = str2;
        this.arg$4 = handlerThread;
    }

    public final void run() {
        this.arg$1.lambda$awaitImageResponse$0$SubmitService(this.arg$2, this.arg$3, this.arg$4);
    }
}
