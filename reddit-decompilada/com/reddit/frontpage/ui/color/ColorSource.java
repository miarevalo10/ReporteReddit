package com.reddit.frontpage.ui.color;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/ui/color/ColorSource;", "", "keyColor", "", "getKeyColor", "()Ljava/lang/Integer;", "setKeyColor", "(Ljava/lang/Integer;)V", "topColor", "getTopColor", "setTopColor", "addOnColorChangedCallback", "", "callback", "Lcom/reddit/frontpage/ui/color/ColorSource$OnColorChangedCallback;", "removeOnColorChangedCallback", "OnColorChangedCallback", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ColorSource.kt */
public interface ColorSource {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/ui/color/ColorSource$OnColorChangedCallback;", "", "onKeyColorChanged", "", "keyColor", "", "(Ljava/lang/Integer;)V", "onTopColorChanged", "topColor", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ColorSource.kt */
    public interface OnColorChangedCallback {
        void mo4943c(Integer num);

        void mo4944d(Integer num);
    }

    Integer mo4949M();

    void mo4950a(OnColorChangedCallback onColorChangedCallback);

    void mo4951a(Integer num);

    void mo4952b(OnColorChangedCallback onColorChangedCallback);

    void mo4953b(Integer num);

    Integer mo4954w();
}
