package com.reddit.frontpage.util;

import android.util.Log;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\t\u0010\t\u001a\u00020\u0006H\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/util/Nimbledroid;", "", "()V", "NIMBLEDROID_LOG_TAG", "", "beginScenario", "", "scenarioName", "endScenario", "registerTestScenario", "Scenario", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Nimbledroid.kt */
public final class Nimbledroid {
    public static final Nimbledroid f21768a = new Nimbledroid();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/util/Nimbledroid$Scenario;", "", "(Ljava/lang/String;I)V", "begin", "", "end", "OpenSubreddit", "OpenPostDetails", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Nimbledroid.kt */
    public enum Scenario {
        ;

        public final void m23846a() {
            Nimbledroid nimbledroid = Nimbledroid.f21768a;
            Nimbledroid.m23848a(name());
        }

        public final void m23847b() {
            Nimbledroid nimbledroid = Nimbledroid.f21768a;
            Nimbledroid.m23849b(name());
        }
    }

    private Nimbledroid() {
    }

    public static final /* synthetic */ void m23848a(String str) {
        StringBuilder stringBuilder = new StringBuilder("Scenario.begin ");
        stringBuilder.append(str);
        Log.i("NimbleDroidV1", stringBuilder.toString());
    }

    public static final /* synthetic */ void m23849b(String str) {
        StringBuilder stringBuilder = new StringBuilder("Scenario.end ");
        stringBuilder.append(str);
        Log.i("NimbleDroidV1", stringBuilder.toString());
    }
}
