package com.reddit.frontpage.ui.profile.profilesettings.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/model/ImageActions;", "", "type", "Lcom/reddit/frontpage/ui/profile/profilesettings/model/ImageType;", "actions", "", "Lcom/reddit/frontpage/ui/profile/profilesettings/model/ImageAction;", "(Ljava/lang/String;ILcom/reddit/frontpage/ui/profile/profilesettings/model/ImageType;Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "getType", "()Lcom/reddit/frontpage/ui/profile/profilesettings/model/ImageType;", "CUSTOM_AVATAR", "DEFAULT_AVATAR", "CUSTOM_BANNER", "DEFAULT_BANNER", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ImageActions.kt */
public enum ImageActions {
    ;
    
    public final ImageType f21562e;
    public final List<ImageAction> f21563f;

    private ImageActions(ImageType imageType, List<? extends ImageAction> list) {
        Intrinsics.m26847b(imageType, "type");
        Intrinsics.m26847b(list, "actions");
        this.f21562e = imageType;
        this.f21563f = list;
    }
}
