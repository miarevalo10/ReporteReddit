package com.reddit.frontpage.ui;

import android.widget.ImageView;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.AccountInfo;
import io.reactivex.functions.Consumer;

final /* synthetic */ class BaseScreen$$Lambda$0 implements Consumer {
    private final BaseScreen f28864a;
    private final ImageView f28865b;

    BaseScreen$$Lambda$0(BaseScreen baseScreen, ImageView imageView) {
        this.f28864a = baseScreen;
        this.f28865b = imageView;
    }

    public final void accept(Object obj) {
        this.f28864a.m37524a(((AccountInfo) obj).f20265b, this.f28865b);
    }
}
