package com.reddit.frontpage.presentation.listing.util;

import com.reddit.frontpage.domain.model.ImageResolution;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"getSizedPreview", "Lcom/reddit/frontpage/domain/model/ImageResolution;", "", "size", "Lcom/reddit/frontpage/presentation/listing/util/Size;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: LinkPreviewUtil.kt */
public final class LinkPreviewUtilKt {
    public static final ImageResolution m23079a(List<ImageResolution> list, Size size) {
        Intrinsics.m26847b(list, "$receiver");
        Intrinsics.m26847b(size, "size");
        if (list.isEmpty()) {
            throw ((Throwable) new IllegalStateException("Can't get a sized preview if no preview sizes are available."));
        }
        Object previous;
        Iterable iterable = list;
        ArrayList arrayList = new ArrayList();
        for (Object next : iterable) {
            ImageResolution imageResolution = (ImageResolution) next;
            Object obj = (((double) (imageResolution.getHeight() / 2)) > ((double) size.f20857b) * 1.1d || ((double) (imageResolution.getWidth() / 2)) > ((double) size.f20856a) * 1.1d) ? null : 1;
            if (obj == null) {
                break;
            }
            arrayList.add(next);
        }
        List list2 = arrayList;
        size = list2.listIterator(list2.size());
        while (size.hasPrevious()) {
            Object obj2;
            previous = size.previous();
            ImageResolution imageResolution2 = (ImageResolution) previous;
            if (imageResolution2.getHeight() <= 0 || imageResolution2.getWidth() <= 0) {
                obj2 = null;
                continue;
            } else {
                obj2 = 1;
                continue;
            }
            if (obj2 != null) {
                break;
            }
        }
        previous = null;
        ImageResolution imageResolution3 = (ImageResolution) previous;
        return imageResolution3 == null ? (ImageResolution) CollectionsKt___CollectionsKt.m41430d((List) list) : imageResolution3;
    }
}
