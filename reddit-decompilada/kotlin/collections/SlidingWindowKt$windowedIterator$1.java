package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.SequenceBuilder;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "Lkotlin/coroutines/experimental/SequenceBuilder;", "", "invoke", "(Lkotlin/coroutines/experimental/SequenceBuilder;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 9})
/* compiled from: SlidingWindow.kt */
final class SlidingWindowKt$windowedIterator$1 extends CoroutineImpl implements Function2<SequenceBuilder<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    Object f39691a;
    Object f39692b;
    Object f39693c;
    Object f39694d;
    int f39695e;
    int f39696f;
    final /* synthetic */ int f39697g;
    final /* synthetic */ int f39698h;
    final /* synthetic */ Iterator f39699i;
    final /* synthetic */ boolean f39700j;
    final /* synthetic */ boolean f39701k;
    private SequenceBuilder f39702n;

    SlidingWindowKt$windowedIterator$1(int i, int i2, Iterator it, boolean z, boolean z2, Continuation continuation) {
        this.f39697g = i;
        this.f39698h = i2;
        this.f39699i = it;
        this.f39700j = z;
        this.f39701k = z2;
        super(continuation);
    }

    private Continuation<Unit> m39800a(SequenceBuilder<? super List<? extends T>> sequenceBuilder, Continuation<? super Unit> continuation) {
        Intrinsics.m26847b(sequenceBuilder, "$receiver");
        Intrinsics.m26847b(continuation, "continuation");
        Continuation slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.f39697g, this.f39698h, this.f39699i, this.f39700j, this.f39701k, continuation);
        slidingWindowKt$windowedIterator$1.f39702n = sequenceBuilder;
        return slidingWindowKt$windowedIterator$1;
    }

    public final java.lang.Object mo7253a(java.lang.Throwable r12) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r11 = this;
        r0 = kotlin.coroutines.experimental.intrinsics.IntrinsicsKt.m26814a();
        r1 = r11.f38204l;
        r2 = 1;
        switch(r1) {
            case 0: goto L_0x0051;
            case 1: goto L_0x003c;
            case 2: goto L_0x0039;
            case 3: goto L_0x0025;
            case 4: goto L_0x0015;
            case 5: goto L_0x0012;
            default: goto L_0x000a;
        };
    L_0x000a:
        r12 = new java.lang.IllegalStateException;
        r0 = "call to 'resume' before 'invoke' with coroutine";
        r12.<init>(r0);
        throw r12;
    L_0x0012:
        if (r12 == 0) goto L_0x0190;
    L_0x0014:
        throw r12;
    L_0x0015:
        r1 = r11.f39692b;
        r1 = (kotlin.collections.RingBuffer) r1;
        r3 = r11.f39695e;
        r4 = r11.f39691a;
        r4 = (kotlin.coroutines.experimental.SequenceBuilder) r4;
        if (r12 == 0) goto L_0x0022;
    L_0x0021:
        throw r12;
    L_0x0022:
        r12 = r11;
        goto L_0x0172;
    L_0x0025:
        r1 = r11.f39694d;
        r1 = (java.util.Iterator) r1;
        r3 = r11.f39692b;
        r3 = (kotlin.collections.RingBuffer) r3;
        r4 = r11.f39695e;
        r5 = r11.f39691a;
        r5 = (kotlin.coroutines.experimental.SequenceBuilder) r5;
        if (r12 == 0) goto L_0x0036;
    L_0x0035:
        throw r12;
    L_0x0036:
        r12 = r11;
        goto L_0x013b;
    L_0x0039:
        if (r12 == 0) goto L_0x0190;
    L_0x003b:
        throw r12;
    L_0x003c:
        r1 = r11.f39694d;
        r1 = (java.util.Iterator) r1;
        r3 = r11.f39692b;
        r3 = (java.util.ArrayList) r3;
        r4 = r11.f39695e;
        r5 = r11.f39691a;
        r5 = (kotlin.coroutines.experimental.SequenceBuilder) r5;
        if (r12 == 0) goto L_0x004d;
    L_0x004c:
        throw r12;
    L_0x004d:
        r12 = r11;
        r6 = r0;
        r0 = r4;
        goto L_0x009b;
    L_0x0051:
        if (r12 == 0) goto L_0x0054;
    L_0x0053:
        throw r12;
    L_0x0054:
        r12 = r11.f39702n;
        r1 = r11.f39697g;
        r3 = r11.f39698h;
        r1 = r1 - r3;
        if (r1 < 0) goto L_0x00d2;
    L_0x005d:
        r3 = new java.util.ArrayList;
        r4 = r11.f39698h;
        r3.<init>(r4);
        r4 = 0;
        r5 = r11.f39699i;
        r6 = r0;
        r0 = r1;
        r1 = r5;
        r5 = r12;
        r12 = r11;
    L_0x006c:
        r7 = r1.hasNext();
        if (r7 == 0) goto L_0x00ac;
    L_0x0072:
        r7 = r1.next();
        if (r4 <= 0) goto L_0x007b;
    L_0x0078:
        r4 = r4 + -1;
        goto L_0x006c;
    L_0x007b:
        r3.add(r7);
        r8 = r3.size();
        r9 = r12.f39698h;
        if (r8 != r9) goto L_0x006c;
    L_0x0086:
        r12.f39691a = r5;
        r12.f39695e = r0;
        r12.f39692b = r3;
        r12.f39696f = r4;
        r12.f39693c = r7;
        r12.f39694d = r1;
        r12.f38204l = r2;
        r4 = r5.mo5681a(r3, r12);
        if (r4 != r6) goto L_0x009b;
    L_0x009a:
        return r6;
    L_0x009b:
        r4 = r12.f39700j;
        if (r4 == 0) goto L_0x00a3;
    L_0x009f:
        r3.clear();
        goto L_0x00aa;
    L_0x00a3:
        r3 = new java.util.ArrayList;
        r4 = r12.f39698h;
        r3.<init>(r4);
    L_0x00aa:
        r4 = r0;
        goto L_0x006c;
    L_0x00ac:
        r1 = r3;
        r1 = (java.util.Collection) r1;
        r1 = r1.isEmpty();
        r1 = r1 ^ r2;
        if (r1 == 0) goto L_0x0190;
    L_0x00b6:
        r1 = r12.f39701k;
        if (r1 != 0) goto L_0x00c2;
    L_0x00ba:
        r1 = r3.size();
        r2 = r12.f39698h;
        if (r1 != r2) goto L_0x0190;
    L_0x00c2:
        r12.f39695e = r0;
        r12.f39691a = r3;
        r12.f39696f = r4;
        r0 = 2;
        r12.f38204l = r0;
        r12 = r5.mo5681a(r3, r12);
        if (r12 != r6) goto L_0x0190;
    L_0x00d1:
        return r6;
    L_0x00d2:
        r3 = new kotlin.collections.RingBuffer;
        r4 = r11.f39698h;
        r3.<init>(r4);
        r4 = r11.f39699i;
        r5 = r12;
        r12 = r11;
        r10 = r4;
        r4 = r1;
        r1 = r10;
    L_0x00e0:
        r6 = r1.hasNext();
        if (r6 == 0) goto L_0x0141;
    L_0x00e6:
        r6 = r1.next();
        r7 = r3.m38204b();
        if (r7 == 0) goto L_0x00fa;
    L_0x00f0:
        r12 = new java.lang.IllegalStateException;
        r0 = "ring buffer is full";
        r12.<init>(r0);
        r12 = (java.lang.Throwable) r12;
        throw r12;
    L_0x00fa:
        r7 = r3.f38198b;
        r8 = r3.f38199c;
        r9 = r3.size();
        r8 = r8 + r9;
        r9 = r3.f38201e;
        r8 = r8 % r9;
        r7[r8] = r6;
        r7 = r3.size();
        r7 = r7 + r2;
        r3.f38200d = r7;
        r7 = r3.m38204b();
        if (r7 == 0) goto L_0x00e0;
    L_0x0115:
        r7 = r12.f39700j;
        if (r7 == 0) goto L_0x011d;
    L_0x0119:
        r7 = r3;
        r7 = (java.util.List) r7;
        goto L_0x0127;
    L_0x011d:
        r7 = new java.util.ArrayList;
        r8 = r3;
        r8 = (java.util.Collection) r8;
        r7.<init>(r8);
        r7 = (java.util.List) r7;
    L_0x0127:
        r12.f39691a = r5;
        r12.f39695e = r4;
        r12.f39692b = r3;
        r12.f39693c = r6;
        r12.f39694d = r1;
        r6 = 3;
        r12.f38204l = r6;
        r6 = r5.mo5681a(r7, r12);
        if (r6 != r0) goto L_0x013b;
    L_0x013a:
        return r0;
    L_0x013b:
        r6 = r12.f39697g;
        r3.m38203a(r6);
        goto L_0x00e0;
    L_0x0141:
        r1 = r12.f39701k;
        if (r1 == 0) goto L_0x0190;
    L_0x0145:
        r1 = r3;
        r3 = r4;
        r4 = r5;
    L_0x0148:
        r5 = r1.size();
        r6 = r12.f39697g;
        if (r5 <= r6) goto L_0x0178;
    L_0x0150:
        r5 = r12.f39700j;
        if (r5 == 0) goto L_0x0158;
    L_0x0154:
        r5 = r1;
        r5 = (java.util.List) r5;
        goto L_0x0162;
    L_0x0158:
        r5 = new java.util.ArrayList;
        r6 = r1;
        r6 = (java.util.Collection) r6;
        r5.<init>(r6);
        r5 = (java.util.List) r5;
    L_0x0162:
        r12.f39691a = r4;
        r12.f39695e = r3;
        r12.f39692b = r1;
        r6 = 4;
        r12.f38204l = r6;
        r5 = r4.mo5681a(r5, r12);
        if (r5 != r0) goto L_0x0172;
    L_0x0171:
        return r0;
    L_0x0172:
        r5 = r12.f39697g;
        r1.m38203a(r5);
        goto L_0x0148;
    L_0x0178:
        r5 = r1;
        r5 = (java.util.Collection) r5;
        r5 = r5.isEmpty();
        r2 = r2 ^ r5;
        if (r2 == 0) goto L_0x0190;
    L_0x0182:
        r12.f39695e = r3;
        r12.f39691a = r1;
        r2 = 5;
        r12.f38204l = r2;
        r12 = r4.mo5681a(r1, r12);
        if (r12 != r0) goto L_0x0190;
    L_0x018f:
        return r0;
    L_0x0190:
        r12 = kotlin.Unit.f25273a;
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindowKt$windowedIterator$1.a(java.lang.Throwable):java.lang.Object");
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        SequenceBuilder sequenceBuilder = (SequenceBuilder) obj;
        Continuation continuation = (Continuation) obj2;
        Intrinsics.m26847b(sequenceBuilder, "$receiver");
        Intrinsics.m26847b(continuation, "continuation");
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = (SlidingWindowKt$windowedIterator$1) m39800a(sequenceBuilder, continuation);
        obj2 = Unit.f25273a;
        return slidingWindowKt$windowedIterator$1.mo7253a(null);
    }
}
