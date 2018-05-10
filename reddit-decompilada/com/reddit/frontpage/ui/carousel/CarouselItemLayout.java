package com.reddit.frontpage.ui.carousel;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/CarouselItemLayout;", "", "itemsPerScreen", "", "layoutFile", "", "snappingSupported", "", "(Ljava/lang/String;IFIZ)V", "getItemsPerScreen", "()F", "getLayoutFile", "()I", "getSnappingSupported", "()Z", "SMALL", "LARGE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CarouselItemLayout.kt */
public enum CarouselItemLayout {
    ;
    
    private final float itemsPerScreen;
    private final int layoutFile;
    private final boolean snappingSupported;

    protected CarouselItemLayout(float f, int i, boolean z) {
        this.itemsPerScreen = f;
        this.layoutFile = i;
        this.snappingSupported = z;
    }

    public final float getItemsPerScreen() {
        return this.itemsPerScreen;
    }

    public final int getLayoutFile() {
        return this.layoutFile;
    }

    public final boolean getSnappingSupported() {
        return this.snappingSupported;
    }
}
