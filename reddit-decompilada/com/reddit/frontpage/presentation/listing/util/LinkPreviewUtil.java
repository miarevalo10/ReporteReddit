package com.reddit.frontpage.presentation.listing.util;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.domain.model.Image;
import com.reddit.frontpage.domain.model.ImageResolution;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.Preview;
import com.reddit.frontpage.domain.model.Variant;
import com.reddit.frontpage.presentation.listing.model.ImageLinkPreviewPresentationModel;
import com.reddit.frontpage.presentation.listing.model.ImageResolutionPresentationModel;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/util/LinkPreviewUtil;", "", "()V", "getImagePreview", "Lcom/reddit/frontpage/presentation/listing/model/ImageLinkPreviewPresentationModel;", "link", "Lcom/reddit/frontpage/domain/model/Link;", "spoiler", "", "over18", "preview", "Lcom/reddit/frontpage/domain/model/Preview;", "getMp4Preview", "", "size", "Lcom/reddit/frontpage/presentation/listing/util/Size;", "params", "Lcom/reddit/frontpage/presentation/listing/util/LinkPreviewUtil$Mp4PreviewParams;", "getSelfImage", "Lcom/reddit/frontpage/presentation/listing/model/ImageResolutionPresentationModel;", "Mp4PreviewParams", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkPreviewUtil.kt */
public final class LinkPreviewUtil {
    public static final LinkPreviewUtil f20852a = new LinkPreviewUtil();

    @PaperParcel
    @Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 $2\u00020\u0001:\u0001$BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J[\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006%"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/util/LinkPreviewUtil$Mp4PreviewParams;", "Lpaperparcel/PaperParcelable;", "isVideo", "", "redditVideoDashUrl", "", "hasMp4Url", "mp4Resolutions", "", "Lcom/reddit/frontpage/domain/model/ImageResolution;", "mp4Url", "isImgurLink", "imgurMp4Url", "(ZLjava/lang/String;ZLjava/util/List;Ljava/lang/String;ZLjava/lang/String;)V", "getHasMp4Url", "()Z", "getImgurMp4Url", "()Ljava/lang/String;", "getMp4Resolutions", "()Ljava/util/List;", "getMp4Url", "getRedditVideoDashUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkPreviewUtil.kt */
    public static final class Mp4PreviewParams implements PaperParcelable {
        public static final Creator<Mp4PreviewParams> CREATOR = PaperParcelLinkPreviewUtil_Mp4PreviewParams.f20855c;
        public static final Companion f28521h = new Companion();
        final boolean f28522a;
        final String f28523b;
        final boolean f28524c;
        final List<ImageResolution> f28525d;
        final String f28526e;
        final boolean f28527f;
        final String f28528g;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tR\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/util/LinkPreviewUtil$Mp4PreviewParams$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/presentation/listing/util/LinkPreviewUtil$Mp4PreviewParams;", "kotlin.jvm.PlatformType", "mp4Variant", "Lcom/reddit/frontpage/domain/model/Variant;", "Lcom/reddit/frontpage/domain/model/Link;", "getMp4Variant", "(Lcom/reddit/frontpage/domain/model/Link;)Lcom/reddit/frontpage/domain/model/Variant;", "from", "link", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: LinkPreviewUtil.kt */
        public static final class Companion {
            private Companion() {
            }

            public static Variant m23075a(Link link) {
                link = link.getPreview();
                if (link != null) {
                    link = link.getImages();
                    if (link != null) {
                        Image image = (Image) CollectionsKt___CollectionsKt.m41430d((List) link);
                        if (image != null) {
                            link = image.getVariants();
                            if (link != null) {
                                return link.getMp4();
                            }
                        }
                    }
                }
                return null;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Mp4PreviewParams) {
                Mp4PreviewParams mp4PreviewParams = (Mp4PreviewParams) obj;
                if ((this.f28522a == mp4PreviewParams.f28522a) && Intrinsics.m26845a(this.f28523b, mp4PreviewParams.f28523b)) {
                    if ((this.f28524c == mp4PreviewParams.f28524c) && Intrinsics.m26845a(this.f28525d, mp4PreviewParams.f28525d) && Intrinsics.m26845a(this.f28526e, mp4PreviewParams.f28526e)) {
                        return (this.f28527f == mp4PreviewParams.f28527f) && Intrinsics.m26845a(this.f28528g, mp4PreviewParams.f28528g);
                    }
                }
            }
        }

        public final int hashCode() {
            int i = this.f28522a;
            int i2 = 1;
            if (i != 0) {
                i = 1;
            }
            i *= 31;
            String str = this.f28523b;
            int i3 = 0;
            i = (i + (str != null ? str.hashCode() : 0)) * 31;
            int i4 = this.f28524c;
            if (i4 != 0) {
                i4 = 1;
            }
            i = (i + i4) * 31;
            List list = this.f28525d;
            i = (i + (list != null ? list.hashCode() : 0)) * 31;
            str = this.f28526e;
            i = (i + (str != null ? str.hashCode() : 0)) * 31;
            boolean z = this.f28527f;
            if (!z) {
                i2 = z;
            }
            i = (i + i2) * 31;
            String str2 = this.f28528g;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i + i3;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Mp4PreviewParams(isVideo=");
            stringBuilder.append(this.f28522a);
            stringBuilder.append(", redditVideoDashUrl=");
            stringBuilder.append(this.f28523b);
            stringBuilder.append(", hasMp4Url=");
            stringBuilder.append(this.f28524c);
            stringBuilder.append(", mp4Resolutions=");
            stringBuilder.append(this.f28525d);
            stringBuilder.append(", mp4Url=");
            stringBuilder.append(this.f28526e);
            stringBuilder.append(", isImgurLink=");
            stringBuilder.append(this.f28527f);
            stringBuilder.append(", imgurMp4Url=");
            stringBuilder.append(this.f28528g);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Mp4PreviewParams(boolean z, String str, boolean z2, List<ImageResolution> list, String str2, boolean z3, String str3) {
            Intrinsics.m26847b(list, "mp4Resolutions");
            this.f28522a = z;
            this.f28523b = str;
            this.f28524c = z2;
            this.f28525d = list;
            this.f28526e = str2;
            this.f28527f = z3;
            this.f28528g = str3;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            Intrinsics.m26847b(parcel, "dest");
            DefaultImpls.writeToParcel(this, parcel, i);
        }
    }

    private LinkPreviewUtil() {
    }

    public static ImageLinkPreviewPresentationModel m23076a(boolean z, boolean z2, Preview preview) {
        if (preview == null) {
            return null;
        }
        List a = CollectionsKt___CollectionsKt.m41419a((Collection) ((Image) CollectionsKt___CollectionsKt.m41430d(preview.getImages())).getResolutions(), (Object) ((Image) CollectionsKt___CollectionsKt.m41430d(preview.getImages())).getSource());
        if ((FrontpageSettings.a().g() && z2) || z) {
            z = ((Image) CollectionsKt___CollectionsKt.m41430d((List) preview.getImages())).getVariants().getObfuscated();
            if (!z) {
                return null;
            }
            a = z.getResolutions();
        }
        return new ImageLinkPreviewPresentationModel(a);
    }

    public static ImageResolutionPresentationModel m23077a(Link link) {
        Intrinsics.m26847b(link, "link");
        link = link.getPreview();
        if (link != null) {
            link = link.getImages();
            if (link != null) {
                Image image = (Image) CollectionsKt___CollectionsKt.m41430d((List) link);
                if (image != null) {
                    link = image.getSource();
                    if (link != null) {
                        return new ImageResolutionPresentationModel(link.getUrl(), link.getWidth(), link.getHeight());
                    }
                }
            }
        }
        return null;
    }

    public static String m23078a(Size size, Mp4PreviewParams mp4PreviewParams) {
        Intrinsics.m26847b(size, "size");
        Intrinsics.m26847b(mp4PreviewParams, "params");
        if (mp4PreviewParams.f28522a) {
            size = mp4PreviewParams.f28523b;
            if (size != null) {
                return size;
            }
        } else if (mp4PreviewParams.f28524c) {
            return (((Collection) mp4PreviewParams.f28525d).isEmpty() ^ 1) != 0 ? LinkPreviewUtilKt.m23079a(mp4PreviewParams.f28525d, size).getUrl() : mp4PreviewParams.f28526e;
        } else {
            if (mp4PreviewParams.f28527f != null) {
                return mp4PreviewParams.f28528g;
            }
        }
        return null;
    }
}
