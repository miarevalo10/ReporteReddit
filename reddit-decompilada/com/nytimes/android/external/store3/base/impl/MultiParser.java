package com.nytimes.android.external.store3.base.impl;

import com.nytimes.android.external.cache3.Preconditions;
import com.nytimes.android.external.store3.util.KeyParser;
import java.util.ArrayList;
import java.util.List;

public class MultiParser<Key, Raw, Parsed> implements KeyParser<Key, Raw, Parsed> {
    private final List<KeyParser> f18663a = new ArrayList();

    public MultiParser(List<KeyParser> list) {
        Preconditions.m8671a((Object) list, "Parsers can't be null.");
        Preconditions.m8673a(list.isEmpty() ^ 1, (Object) "Parsers can't be empty.");
        for (Object a : list) {
            Preconditions.m8671a(a, "Parser can't be null.");
        }
        this.f18663a.addAll(list);
    }

    public Parsed apply(Key r3, Raw r4) throws com.nytimes.android.external.store3.util.ParserException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r0 = r2.f18663a;
        r0 = r0.iterator();
    L_0x0006:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x001f;
    L_0x000c:
        r1 = r0.next();
        r1 = (com.nytimes.android.external.store3.util.KeyParser) r1;
        r4 = r1.apply(r3, r4);	 Catch:{ ClassCastException -> 0x0017 }
        goto L_0x0006;
    L_0x0017:
        r3 = new com.nytimes.android.external.store3.util.ParserException;
        r4 = "One of the provided parsers has a wrong typing. Make sure that parsers are passed in a correct order and the fromTypes match each other.";
        r3.<init>(r4);
        throw r3;
    L_0x001f:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nytimes.android.external.store3.base.impl.MultiParser.apply(java.lang.Object, java.lang.Object):Parsed");
    }
}
