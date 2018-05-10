package com.reddit.datalibrary.frontpage.data.feature.legacy;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.structure.Model;
import com.reddit.datalibrary.frontpage.data.feature.legacy.local.LocalLinkDataSourceLegacy;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink_Table;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.frontpage.util.Util;
import java.util.List;

public class DatabaseLinkDataSourceLegacy implements LocalLinkDataSourceLegacy {
    private static final IProperty[] f15858a = new IProperty[]{ClientLink_Table._id, ClientLink_Table.read, ClientLink_Table.readUtc};

    public final List<ClientLink> mo2931a(Listing<? extends Listable> listing) {
        if (listing != null) {
            if (!listing.isEmpty()) {
                int size = listing.size();
                long j = -1;
                int i = 0;
                while (i < size) {
                    Listable listable = (Listable) listing.get(i);
                    if (listable instanceof ClientLink) {
                        j = ((ClientLink) listable).getDatabaseId();
                        i++;
                        break;
                    }
                    i++;
                }
                long[] jArr = new long[(listing.size() - 1)];
                for (i = 
/*
Method generation error in method: com.reddit.datalibrary.frontpage.data.feature.legacy.DatabaseLinkDataSourceLegacy.a(com.reddit.datalibrary.frontpage.requests.models.v2.Listing):java.util.List<com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink>
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r4_4 'i' int) = (r4_3 'i' int), (r4_1 'i' int) binds: {(r4_3 'i' int)=B:8:0x001e, (r4_1 'i' int)=B:20:0x002a} in method: com.reddit.datalibrary.frontpage.data.feature.legacy.DatabaseLinkDataSourceLegacy.a(com.reddit.datalibrary.frontpage.requests.models.v2.Listing):java.util.List<com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink>
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 27 more

*/

                public final Link mo2930a(String str) {
                    long f = Util.f(str);
                    str = ClientLink_Table._id;
                    return (Link) SQLite.select(new IProperty[0]).from(ClientLink.class).where(str.eq(Long.valueOf(f))).querySingle();
                }

                public final Link mo2929a(Link link) {
                    ((Model) link).save();
                    return link;
                }
            }
