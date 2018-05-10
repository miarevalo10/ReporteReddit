package com.cookpad.puree.outputs;

import com.cookpad.puree.PureeFilter;
import com.cookpad.puree.storage.PureeStorage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PureeOutput {
    protected OutputConfiguration f3701a;
    protected PureeStorage f3702b;
    protected List<PureeFilter> f3703c = new ArrayList();

    public abstract OutputConfiguration m3259a(OutputConfiguration outputConfiguration);

    public void mo1032a() {
    }

    public abstract void mo1035b(JSONObject jSONObject);

    public abstract String m3265c();

    public final void m3261a(PureeFilter pureeFilter) {
        this.f3703c.add(pureeFilter);
    }

    public void mo1033a(PureeStorage pureeStorage) {
        this.f3702b = pureeStorage;
        OutputConfiguration outputConfiguration = new OutputConfiguration();
        this.f3701a = m3259a(outputConfiguration);
        if (this.f3701a == null) {
            this.f3701a = outputConfiguration;
        }
    }

    public void mo1034a(org.json.JSONObject r1) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = this;
        r1 = r0.m3266c(r1);	 Catch:{ JSONException -> 0x000b }
        if (r1 != 0) goto L_0x0007;	 Catch:{ JSONException -> 0x000b }
    L_0x0006:
        return;	 Catch:{ JSONException -> 0x000b }
    L_0x0007:
        r0.mo1035b(r1);	 Catch:{ JSONException -> 0x000b }
        return;
    L_0x000b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cookpad.puree.outputs.PureeOutput.a(org.json.JSONObject):void");
    }

    protected final JSONObject m3266c(JSONObject jSONObject) throws JSONException {
        for (PureeFilter a : this.f3703c) {
            jSONObject = a.m3257a(jSONObject);
            if (jSONObject == null) {
                return null;
            }
        }
        return jSONObject;
    }
}
