package com.reddit.datalibrary.frontpage.service.api;

import java.util.concurrent.Callable;

final /* synthetic */ class UploadService$$Lambda$0 implements Callable {
    private final UploadService arg$1;
    private final String arg$2;
    private final String arg$3;

    UploadService$$Lambda$0(UploadService uploadService, String str, String str2) {
        this.arg$1 = uploadService;
        this.arg$2 = str;
        this.arg$3 = str2;
    }

    public final Object call() {
        return this.arg$1.lambda$getFileUploadLease$0$UploadService(this.arg$2, this.arg$3);
    }
}
