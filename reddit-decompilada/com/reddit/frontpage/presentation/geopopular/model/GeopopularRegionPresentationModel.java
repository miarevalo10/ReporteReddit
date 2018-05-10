package com.reddit.frontpage.presentation.geopopular.model;

import com.reddit.frontpage.domain.model.Region;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/model/GeopopularRegionPresentationModel;", "", "region", "Lcom/reddit/frontpage/domain/model/Region;", "iconResourceId", "", "previouslySelectedChildRegionName", "", "previouslySelected", "", "isFiltered", "(Lcom/reddit/frontpage/domain/model/Region;ILjava/lang/String;ZZ)V", "getIconResourceId", "()I", "()Z", "getPreviouslySelected", "getPreviouslySelectedChildRegionName", "()Ljava/lang/String;", "getRegion", "()Lcom/reddit/frontpage/domain/model/Region;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularRegionPresentationModel.kt */
public final class GeopopularRegionPresentationModel {
    public static final Companion f20537f = new Companion();
    public final Region f20538a;
    public final int f20539b;
    public final String f20540c;
    public final boolean f20541d;
    public final boolean f20542e;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0002J,\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bJD\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/model/GeopopularRegionPresentationModel$Companion;", "", "()V", "getIconResourceId", "", "region", "Lcom/reddit/frontpage/domain/model/Region;", "previouslySelected", "", "previouslySelectedChildRegionName", "", "isFiltered", "toPresentationModel", "Lcom/reddit/frontpage/presentation/geopopular/model/GeopopularRegionPresentationModel;", "toPresentationModels", "", "regions", "previouslySelectedRegionId", "previouslySelectedGeoFilter", "previouslySelectedChildRegionId", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularRegionPresentationModel.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ java.util.List m22847a(java.util.List r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, boolean r13, int r14) {
            /*
            r0 = r14 & 2;
            if (r0 == 0) goto L_0x0006;
        L_0x0004:
            r10 = "";
        L_0x0006:
            r0 = r14 & 4;
            r1 = 0;
            if (r0 == 0) goto L_0x000c;
        L_0x000b:
            r11 = r1;
        L_0x000c:
            r0 = r14 & 8;
            if (r0 == 0) goto L_0x0012;
        L_0x0010:
            r12 = "";
        L_0x0012:
            r14 = r14 & 16;
            r0 = 0;
            if (r14 == 0) goto L_0x0018;
        L_0x0017:
            r13 = r0;
        L_0x0018:
            r14 = "regions";
            kotlin.jvm.internal.Intrinsics.m26847b(r9, r14);
            r14 = "previouslySelectedRegionId";
            kotlin.jvm.internal.Intrinsics.m26847b(r10, r14);
            r14 = "previouslySelectedChildRegionId";
            kotlin.jvm.internal.Intrinsics.m26847b(r12, r14);
            r9 = (java.lang.Iterable) r9;
            r14 = new java.util.ArrayList;
            r2 = kotlin.collections.CollectionsKt__IterablesKt.m32812b(r9);
            r14.<init>(r2);
            r14 = (java.util.Collection) r14;
            r9 = r9.iterator();
        L_0x0038:
            r2 = r9.hasNext();
            if (r2 == 0) goto L_0x00d4;
        L_0x003e:
            r2 = r9.next();
            r3 = r2;
            r3 = (com.reddit.frontpage.domain.model.Region) r3;
            if (r11 != 0) goto L_0x0051;
        L_0x0047:
            r2 = r3.getId();
            r2 = kotlin.jvm.internal.Intrinsics.m26845a(r2, r10);
        L_0x004f:
            r6 = r2;
            goto L_0x005a;
        L_0x0051:
            r2 = r3.getGeoFilter();
            r2 = kotlin.jvm.internal.Intrinsics.m26845a(r2, r11);
            goto L_0x004f;
        L_0x005a:
            if (r6 == 0) goto L_0x008c;
        L_0x005c:
            r2 = r3.getSubregions();
            r2 = (java.lang.Iterable) r2;
            r2 = r2.iterator();
        L_0x0066:
            r4 = r2.hasNext();
            if (r4 == 0) goto L_0x007e;
        L_0x006c:
            r4 = r2.next();
            r5 = r4;
            r5 = (com.reddit.frontpage.domain.model.Region) r5;
            r5 = r5.getId();
            r5 = kotlin.jvm.internal.Intrinsics.m26845a(r5, r12);
            if (r5 == 0) goto L_0x0066;
        L_0x007d:
            goto L_0x007f;
        L_0x007e:
            r4 = r1;
        L_0x007f:
            r4 = (com.reddit.frontpage.domain.model.Region) r4;
            if (r4 == 0) goto L_0x0089;
        L_0x0083:
            r2 = r4.getName();
            if (r2 != 0) goto L_0x008e;
        L_0x0089:
            r2 = "";
            goto L_0x008e;
        L_0x008c:
            r2 = "";
        L_0x008e:
            r5 = r2;
            r2 = com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel.f20537f;
            r2 = "region";
            kotlin.jvm.internal.Intrinsics.m26847b(r3, r2);
            r2 = "previouslySelectedChildRegionName";
            kotlin.jvm.internal.Intrinsics.m26847b(r5, r2);
            r8 = new com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel;
            r2 = r3.getSubregions();
            r2 = (java.util.Collection) r2;
            r2 = r2.isEmpty();
            r4 = 1;
            r2 = r2 ^ r4;
            r7 = 2131231201; // 0x7f0801e1 float:1.8078476E38 double:1.05296812E-314;
            if (r2 == 0) goto L_0x00b2;
        L_0x00ae:
            if (r13 != 0) goto L_0x00b2;
        L_0x00b0:
            r4 = r7;
            goto L_0x00ca;
        L_0x00b2:
            if (r6 == 0) goto L_0x00c6;
        L_0x00b4:
            r2 = r5;
            r2 = (java.lang.CharSequence) r2;
            r2 = r2.length();
            if (r2 <= 0) goto L_0x00be;
        L_0x00bd:
            goto L_0x00bf;
        L_0x00be:
            r4 = r0;
        L_0x00bf:
            if (r4 == 0) goto L_0x00c2;
        L_0x00c1:
            goto L_0x00b0;
        L_0x00c2:
            r2 = 2131231229; // 0x7f0801fd float:1.8078533E38 double:1.0529681336E-314;
            goto L_0x00c9;
        L_0x00c6:
            r2 = 2131231230; // 0x7f0801fe float:1.8078535E38 double:1.052968134E-314;
        L_0x00c9:
            r4 = r2;
        L_0x00ca:
            r2 = r8;
            r7 = r13;
            r2.<init>(r3, r4, r5, r6, r7);
            r14.add(r8);
            goto L_0x0038;
        L_0x00d4:
            r14 = (java.util.List) r14;
            return r14;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel.Companion.a(java.util.List, java.lang.String, java.lang.String, java.lang.String, boolean, int):java.util.List");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GeopopularRegionPresentationModel) {
            GeopopularRegionPresentationModel geopopularRegionPresentationModel = (GeopopularRegionPresentationModel) obj;
            if (Intrinsics.m26845a(this.f20538a, geopopularRegionPresentationModel.f20538a)) {
                if ((this.f20539b == geopopularRegionPresentationModel.f20539b) && Intrinsics.m26845a(this.f20540c, geopopularRegionPresentationModel.f20540c)) {
                    if (this.f20541d == geopopularRegionPresentationModel.f20541d) {
                        if (this.f20542e == geopopularRegionPresentationModel.f20542e) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Region region = this.f20538a;
        int i = 0;
        int hashCode = (((region != null ? region.hashCode() : 0) * 31) + this.f20539b) * 31;
        String str = this.f20540c;
        if (str != null) {
            i = str.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.f20541d;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        i = this.f20542e;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("GeopopularRegionPresentationModel(region=");
        stringBuilder.append(this.f20538a);
        stringBuilder.append(", iconResourceId=");
        stringBuilder.append(this.f20539b);
        stringBuilder.append(", previouslySelectedChildRegionName=");
        stringBuilder.append(this.f20540c);
        stringBuilder.append(", previouslySelected=");
        stringBuilder.append(this.f20541d);
        stringBuilder.append(", isFiltered=");
        stringBuilder.append(this.f20542e);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public GeopopularRegionPresentationModel(Region region, int i, String str, boolean z, boolean z2) {
        Intrinsics.m26847b(region, "region");
        Intrinsics.m26847b(str, "previouslySelectedChildRegionName");
        this.f20538a = region;
        this.f20539b = i;
        this.f20540c = str;
        this.f20541d = z;
        this.f20542e = z2;
    }
}
