package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: predefinedEnhancementInfo.kt */
final class SignatureEnhancementBuilder {
    final Map<String, PredefinedFunctionEnhancementInfo> f25767a = new LinkedHashMap();

    /* compiled from: predefinedEnhancementInfo.kt */
    public final class ClassEnhancementBuilder {
        final String f25765a;
        final /* synthetic */ SignatureEnhancementBuilder f25766b;

        /* compiled from: predefinedEnhancementInfo.kt */
        public final class FunctionEnhancementBuilder {
            final List<Pair<String, TypeEnhancementInfo>> f25761a = ((List) new ArrayList());
            Pair<String, TypeEnhancementInfo> f25762b = TuplesKt.m26780a("V", null);
            final String f25763c;
            final /* synthetic */ ClassEnhancementBuilder f25764d;

            public FunctionEnhancementBuilder(ClassEnhancementBuilder classEnhancementBuilder, String str) {
                Intrinsics.m26847b(str, "functionName");
                this.f25764d = classEnhancementBuilder;
                this.f25763c = str;
            }

            public final void m27264a(java.lang.String r6, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers... r7) {
                /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:410)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.fixIterableType(LoopRegionVisitor.java:308)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkIterableForEach(LoopRegionVisitor.java:249)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:68)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r0 = "type";
                kotlin.jvm.internal.Intrinsics.m26847b(r6, r0);
                r0 = "qualifiers";
                kotlin.jvm.internal.Intrinsics.m26847b(r7, r0);
                r0 = r5.f25761a;
                r0 = (java.util.Collection) r0;
                r7 = (java.lang.Object[]) r7;
                r1 = r7.length;
                if (r1 != 0) goto L_0x0016;
            L_0x0014:
                r1 = 1;
                goto L_0x0017;
            L_0x0016:
                r1 = 0;
            L_0x0017:
                if (r1 == 0) goto L_0x001b;
            L_0x0019:
                r7 = 0;
                goto L_0x0058;
            L_0x001b:
                r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo;
                r7 = kotlin.collections.ArraysKt___ArraysKt.m36112l(r7);
                r2 = kotlin.collections.CollectionsKt__IterablesKt.m32812b(r7);
                r2 = kotlin.collections.MapsKt__MapsKt.m36115a(r2);
                r3 = 16;
                r2 = kotlin.ranges.RangesKt___RangesKt.m32855c(r2, r3);
                r3 = new java.util.LinkedHashMap;
                r3.<init>(r2);
                r3 = (java.util.Map) r3;
                r7 = r7.iterator();
            L_0x003a:
                r2 = r7.hasNext();
                if (r2 == 0) goto L_0x0054;
            L_0x0040:
                r2 = r7.next();
                r2 = (kotlin.collections.IndexedValue) r2;
                r4 = r2.f25277a;
                r4 = java.lang.Integer.valueOf(r4);
                r2 = r2.f25278b;
                r2 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r2;
                r3.put(r4, r2);
                goto L_0x003a;
            L_0x0054:
                r1.<init>(r3);
                r7 = r1;
            L_0x0058:
                r6 = kotlin.TuplesKt.m26780a(r6, r7);
                r0.add(r6);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder.a(java.lang.String, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[]):void");
            }

            public final void m27266b(java.lang.String r5, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers... r6) {
                /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:410)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.fixIterableType(LoopRegionVisitor.java:308)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkIterableForEach(LoopRegionVisitor.java:249)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:68)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r0 = "type";
                kotlin.jvm.internal.Intrinsics.m26847b(r5, r0);
                r0 = "qualifiers";
                kotlin.jvm.internal.Intrinsics.m26847b(r6, r0);
                r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo;
                r6 = (java.lang.Object[]) r6;
                r6 = kotlin.collections.ArraysKt___ArraysKt.m36112l(r6);
                r1 = kotlin.collections.CollectionsKt__IterablesKt.m32812b(r6);
                r1 = kotlin.collections.MapsKt__MapsKt.m36115a(r1);
                r2 = 16;
                r1 = kotlin.ranges.RangesKt___RangesKt.m32855c(r1, r2);
                r2 = new java.util.LinkedHashMap;
                r2.<init>(r1);
                r2 = (java.util.Map) r2;
                r6 = r6.iterator();
            L_0x002c:
                r1 = r6.hasNext();
                if (r1 == 0) goto L_0x0046;
            L_0x0032:
                r1 = r6.next();
                r1 = (kotlin.collections.IndexedValue) r1;
                r3 = r1.f25277a;
                r3 = java.lang.Integer.valueOf(r3);
                r1 = r1.f25278b;
                r1 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r1;
                r2.put(r3, r1);
                goto L_0x002c;
            L_0x0046:
                r0.<init>(r2);
                r5 = kotlin.TuplesKt.m26780a(r5, r0);
                r4.f25762b = r5;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder.b(java.lang.String, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[]):void");
            }

            public final void m27265a(JvmPrimitiveType jvmPrimitiveType) {
                Intrinsics.m26847b(jvmPrimitiveType, "type");
                this.f25762b = TuplesKt.m26780a(jvmPrimitiveType.m27757c(), null);
            }
        }

        public ClassEnhancementBuilder(SignatureEnhancementBuilder signatureEnhancementBuilder, String str) {
            Intrinsics.m26847b(str, "className");
            this.f25766b = signatureEnhancementBuilder;
            this.f25765a = str;
        }

        public final void m27267a(String str, Function1<? super FunctionEnhancementBuilder, Unit> function1) {
            Intrinsics.m26847b(str, "name");
            Intrinsics.m26847b(function1, "block");
            Map a = this.f25766b.f25767a;
            FunctionEnhancementBuilder functionEnhancementBuilder = new FunctionEnhancementBuilder(this, str);
            function1.mo6492a(functionEnhancementBuilder);
            functionEnhancementBuilder = functionEnhancementBuilder;
            str = SignatureBuildingComponents.f25810a;
            str = functionEnhancementBuilder.f25764d.f25765a;
            function1 = functionEnhancementBuilder.f25763c;
            Iterable<Pair> iterable = functionEnhancementBuilder.f25761a;
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (Pair pair : iterable) {
                arrayList.add((String) pair.f25267a);
            }
            List list = (List) arrayList;
            String str2 = (String) functionEnhancementBuilder.f25762b.f25267a;
            Intrinsics.m26847b(function1, "name");
            Intrinsics.m26847b(list, "parameters");
            Intrinsics.m26847b(str2, "ret");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(function1);
            stringBuilder.append("(");
            stringBuilder.append(CollectionsKt___CollectionsKt.m41412a((Iterable) list, (CharSequence) "", null, null, 0, null, (Function1) SignatureBuildingComponents$jvmDescriptor$1.f38780a, 30));
            stringBuilder.append(")");
            stringBuilder.append(SignatureBuildingComponents.m27366d(str2));
            str = SignatureBuildingComponents.m27358a(str, stringBuilder.toString());
            TypeEnhancementInfo typeEnhancementInfo = (TypeEnhancementInfo) functionEnhancementBuilder.f25762b.f25268b;
            Iterable<Pair> iterable2 = functionEnhancementBuilder.f25761a;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable2));
            for (Pair pair2 : iterable2) {
                arrayList.add((TypeEnhancementInfo) pair2.f25268b);
            }
            Pair a2 = TuplesKt.m26780a(str, new PredefinedFunctionEnhancementInfo(typeEnhancementInfo, (List) arrayList));
            a.put(a2.f25267a, a2.f25268b);
        }
    }
}
