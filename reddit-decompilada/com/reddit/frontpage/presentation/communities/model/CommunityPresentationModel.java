package com.reddit.frontpage.presentation.communities.model;

import com.google.android.gms.ads.AdRequest;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jcodec.codecs.mpeg12.MPEGConst;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b-\b\b\u0018\u0000 D2\u00020\u0001:\u0001DB\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r¢\u0006\u0002\u0010\u0016J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00102\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u00103\u001a\u00020\rHÆ\u0003J\t\u00104\u001a\u00020\u0014HÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010=\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001fJª\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\r2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u000fHÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u0015\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010$R\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010$R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010 \u001a\u0004\b&\u0010\u001fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010 \u001a\u0004\b'\u0010\u001fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006E"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "", "id", "", "type", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModelType;", "section", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationSection;", "name", "sortName", "iconUrl", "keyColor", "favorite", "", "iconResource", "", "keyColorAttrResource", "keyColorResource", "isUser", "stableId", "", "isNsfw", "(Ljava/lang/String;Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModelType;Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationSection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZJZ)V", "fastScrollIndicator", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator;", "getFastScrollIndicator", "()Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator;", "getFavorite", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIconResource", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIconUrl", "()Ljava/lang/String;", "getId", "()Z", "getKeyColor", "getKeyColorAttrResource", "getKeyColorResource", "getName", "getSection", "()Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationSection;", "getSortName", "getStableId", "()J", "getType", "()Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModelType;", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModelType;Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationSection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZJZ)Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "equals", "other", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunityPresentationModel.kt */
public final class CommunityPresentationModel {
    public static final Companion f20468o = new Companion();
    public final String f20469a;
    public final CommunityPresentationModelType f20470b;
    public final CommunityPresentationSection f20471c;
    public final String f20472d;
    public final String f20473e;
    public final String f20474f;
    public final String f20475g;
    public final Boolean f20476h;
    public final Integer f20477i;
    public final Integer f20478j;
    public final Integer f20479k;
    public final boolean f20480l;
    public final long f20481m;
    public final boolean f20482n;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\b\"\u00020\u0006¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel$Companion;", "", "()V", "createStableId", "", "id", "", "ids", "", "(Ljava/lang/String;[Ljava/lang/String;)J", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunityPresentationModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static long m22800a(String str, String... strArr) {
            Intrinsics.m26847b(str, "id");
            Intrinsics.m26847b(strArr, "ids");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            str = "";
            for (Object obj : (Object[]) strArr) {
                String str2 = (String) obj;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append(str);
                str = stringBuilder2.toString();
            }
            stringBuilder.append(str);
            return Util.m24024f(stringBuilder.toString());
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20467a;

        static {
            int[] iArr = new int[CommunityPresentationSection.values().length];
            f20467a = iArr;
            iArr[CommunityPresentationSection.f20492f.ordinal()] = 1;
            f20467a[CommunityPresentationSection.f20487a.ordinal()] = 2;
            f20467a[CommunityPresentationSection.f20488b.ordinal()] = 3;
            f20467a[CommunityPresentationSection.f20489c.ordinal()] = 4;
            f20467a[CommunityPresentationSection.f20490d.ordinal()] = 5;
            f20467a[CommunityPresentationSection.f20491e.ordinal()] = 6;
            f20467a[CommunityPresentationSection.f20493g.ordinal()] = 7;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CommunityPresentationModel) {
            CommunityPresentationModel communityPresentationModel = (CommunityPresentationModel) obj;
            if (Intrinsics.m26845a(this.f20469a, communityPresentationModel.f20469a) && Intrinsics.m26845a(this.f20470b, communityPresentationModel.f20470b) && Intrinsics.m26845a(this.f20471c, communityPresentationModel.f20471c) && Intrinsics.m26845a(this.f20472d, communityPresentationModel.f20472d) && Intrinsics.m26845a(this.f20473e, communityPresentationModel.f20473e) && Intrinsics.m26845a(this.f20474f, communityPresentationModel.f20474f) && Intrinsics.m26845a(this.f20475g, communityPresentationModel.f20475g) && Intrinsics.m26845a(this.f20476h, communityPresentationModel.f20476h) && Intrinsics.m26845a(this.f20477i, communityPresentationModel.f20477i) && Intrinsics.m26845a(this.f20478j, communityPresentationModel.f20478j) && Intrinsics.m26845a(this.f20479k, communityPresentationModel.f20479k)) {
                if (this.f20480l == communityPresentationModel.f20480l) {
                    if (this.f20481m == communityPresentationModel.f20481m) {
                        if (this.f20482n == communityPresentationModel.f20482n) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f20469a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        CommunityPresentationModelType communityPresentationModelType = this.f20470b;
        hashCode = (hashCode + (communityPresentationModelType != null ? communityPresentationModelType.hashCode() : 0)) * 31;
        CommunityPresentationSection communityPresentationSection = this.f20471c;
        hashCode = (hashCode + (communityPresentationSection != null ? communityPresentationSection.hashCode() : 0)) * 31;
        String str2 = this.f20472d;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f20473e;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f20474f;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f20475g;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.f20476h;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Integer num = this.f20477i;
        hashCode = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        num = this.f20478j;
        hashCode = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        num = this.f20479k;
        if (num != null) {
            i = num.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.f20480l;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        long j = this.f20481m;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        i = this.f20482n;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CommunityPresentationModel(id=");
        stringBuilder.append(this.f20469a);
        stringBuilder.append(", type=");
        stringBuilder.append(this.f20470b);
        stringBuilder.append(", section=");
        stringBuilder.append(this.f20471c);
        stringBuilder.append(", name=");
        stringBuilder.append(this.f20472d);
        stringBuilder.append(", sortName=");
        stringBuilder.append(this.f20473e);
        stringBuilder.append(", iconUrl=");
        stringBuilder.append(this.f20474f);
        stringBuilder.append(", keyColor=");
        stringBuilder.append(this.f20475g);
        stringBuilder.append(", favorite=");
        stringBuilder.append(this.f20476h);
        stringBuilder.append(", iconResource=");
        stringBuilder.append(this.f20477i);
        stringBuilder.append(", keyColorAttrResource=");
        stringBuilder.append(this.f20478j);
        stringBuilder.append(", keyColorResource=");
        stringBuilder.append(this.f20479k);
        stringBuilder.append(", isUser=");
        stringBuilder.append(this.f20480l);
        stringBuilder.append(", stableId=");
        stringBuilder.append(this.f20481m);
        stringBuilder.append(", isNsfw=");
        stringBuilder.append(this.f20482n);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private CommunityPresentationModel(String str, CommunityPresentationModelType communityPresentationModelType, CommunityPresentationSection communityPresentationSection, String str2, String str3, String str4, String str5, Boolean bool, Integer num, Integer num2, Integer num3, boolean z, long j, boolean z2) {
        String str6 = str;
        CommunityPresentationModelType communityPresentationModelType2 = communityPresentationModelType;
        CommunityPresentationSection communityPresentationSection2 = communityPresentationSection;
        Intrinsics.m26847b(str6, "id");
        Intrinsics.m26847b(communityPresentationModelType2, "type");
        Intrinsics.m26847b(communityPresentationSection2, "section");
        this.f20469a = str6;
        this.f20470b = communityPresentationModelType2;
        this.f20471c = communityPresentationSection2;
        this.f20472d = str2;
        this.f20473e = str3;
        this.f20474f = str4;
        this.f20475g = str5;
        this.f20476h = bool;
        this.f20477i = num;
        this.f20478j = num2;
        this.f20479k = num3;
        this.f20480l = z;
        this.f20481m = j;
        this.f20482n = z2;
    }

    public /* synthetic */ CommunityPresentationModel(String str, CommunityPresentationModelType communityPresentationModelType, CommunityPresentationSection communityPresentationSection, String str2, String str3, String str4, String str5, Boolean bool, Integer num, Integer num2, Integer num3, boolean z, long j, boolean z2, int i) {
        int i2 = i;
        this(str, communityPresentationModelType, communityPresentationSection, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : bool, (i2 & 256) != 0 ? null : num, (i2 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? null : num2, (i2 & 1024) != 0 ? null : num3, (i2 & MPEGConst.CODE_END) != 0 ? false : z, j, (i2 & 8192) != 0 ? false : z2);
    }

    public static /* synthetic */ CommunityPresentationModel m22801a(CommunityPresentationModel communityPresentationModel, String str, CommunityPresentationModelType communityPresentationModelType, CommunityPresentationSection communityPresentationSection, String str2, String str3, String str4, String str5, Boolean bool, Integer num, Integer num2, Integer num3, boolean z, long j, boolean z2, int i) {
        CommunityPresentationModel communityPresentationModel2 = communityPresentationModel;
        int i2 = i;
        String str6 = (i2 & 1) != 0 ? communityPresentationModel2.f20469a : str;
        CommunityPresentationModelType communityPresentationModelType2 = (i2 & 2) != 0 ? communityPresentationModel2.f20470b : communityPresentationModelType;
        CommunityPresentationSection communityPresentationSection2 = (i2 & 4) != 0 ? communityPresentationModel2.f20471c : communityPresentationSection;
        String str7 = (i2 & 8) != 0 ? communityPresentationModel2.f20472d : str2;
        String str8 = (i2 & 16) != 0 ? communityPresentationModel2.f20473e : str3;
        String str9 = (i2 & 32) != 0 ? communityPresentationModel2.f20474f : str4;
        String str10 = (i2 & 64) != 0 ? communityPresentationModel2.f20475g : str5;
        Boolean bool2 = (i2 & 128) != 0 ? communityPresentationModel2.f20476h : bool;
        Integer num4 = (i2 & 256) != 0 ? communityPresentationModel2.f20477i : num;
        Integer num5 = (i2 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? communityPresentationModel2.f20478j : num2;
        Integer num6 = (i2 & 1024) != 0 ? communityPresentationModel2.f20479k : num3;
        boolean z3 = (i2 & MPEGConst.CODE_END) != 0 ? communityPresentationModel2.f20480l : z;
        long j2 = (i2 & 4096) != 0 ? communityPresentationModel2.f20481m : j;
        boolean z4 = (i2 & 8192) != 0 ? communityPresentationModel2.f20482n : z2;
        Intrinsics.m26847b(str6, "id");
        Intrinsics.m26847b(communityPresentationModelType2, "type");
        Intrinsics.m26847b(communityPresentationSection2, "section");
        return new CommunityPresentationModel(str6, communityPresentationModelType2, communityPresentationSection2, str7, str8, str9, str10, bool2, num4, num5, num6, z3, j2, z4);
    }
}
