package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* compiled from: predefinedEnhancementInfo.kt */
public final class PredefinedEnhancementInfoKt {
    private static final JavaTypeQualifiers f25752a = new JavaTypeQualifiers(NullabilityQualifier.f25747a, null, false);
    private static final JavaTypeQualifiers f25753b = new JavaTypeQualifiers(NullabilityQualifier.f25748b, null, false);
    private static final JavaTypeQualifiers f25754c = new JavaTypeQualifiers(NullabilityQualifier.f25748b, null, true);
    private static final Map<String, PredefinedFunctionEnhancementInfo> f25755d;

    static {
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.f25810a;
        String a = SignatureBuildingComponents.m27357a("Object");
        String c = SignatureBuildingComponents.m27364c("Predicate");
        String c2 = SignatureBuildingComponents.m27364c("Function");
        String c3 = SignatureBuildingComponents.m27364c("Consumer");
        String c4 = SignatureBuildingComponents.m27364c("BiFunction");
        String c5 = SignatureBuildingComponents.m27364c("BiConsumer");
        String c6 = SignatureBuildingComponents.m27364c("UnaryOperator");
        String b = SignatureBuildingComponents.m27362b("stream/Stream");
        SignatureEnhancementBuilder signatureEnhancementBuilder = new SignatureEnhancementBuilder();
        SignatureBuildingComponents signatureBuildingComponents2 = signatureBuildingComponents;
        String str = c3;
        String str2 = c;
        String str3 = b;
        String str4 = c;
        String str5 = c6;
        String str6 = c3;
        ClassEnhancementBuilder classEnhancementBuilder = new ClassEnhancementBuilder(signatureEnhancementBuilder, SignatureBuildingComponents.m27362b("Iterator"));
        String str7 = c5;
        SignatureBuildingComponents signatureBuildingComponents3 = signatureBuildingComponents;
        SignatureEnhancementBuilder signatureEnhancementBuilder2 = signatureEnhancementBuilder;
        String str8 = a;
        String b2 = SignatureBuildingComponents.m27362b("Optional");
        String str9 = c4;
        String str10 = c5;
        c5 = c2;
        String str11 = c4;
        c4 = b2;
        classEnhancementBuilder.m27267a("forEachRemaining", new C2955xd5dbd441(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        str = str6;
        str2 = str4;
        str7 = str10;
        str9 = str11;
        new ClassEnhancementBuilder(signatureEnhancementBuilder2, SignatureBuildingComponents.m27357a("Iterable")).m27267a("spliterator", new C2965xd5dbd442(signatureBuildingComponents3, str, str2, str3, str5, str7, str8, str9, c5, c4));
        ClassEnhancementBuilder classEnhancementBuilder2 = new ClassEnhancementBuilder(signatureEnhancementBuilder2, SignatureBuildingComponents.m27362b("Collection"));
        signatureBuildingComponents2 = signatureBuildingComponents3;
        classEnhancementBuilder2.m27267a("removeIf", new C2966xd5dbd443(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        classEnhancementBuilder2.m27267a("stream", new C2967xd5dbd444(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        classEnhancementBuilder2.m27267a("parallelStream", new C2968xd5dbd445(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        new ClassEnhancementBuilder(signatureEnhancementBuilder2, SignatureBuildingComponents.m27362b("List")).m27267a("replaceAll", new C2969xd5dbd446(signatureBuildingComponents3, str, str2, str3, str5, str7, str8, str9, c5, c4));
        classEnhancementBuilder2 = new ClassEnhancementBuilder(signatureEnhancementBuilder2, SignatureBuildingComponents.m27362b("Map"));
        signatureBuildingComponents2 = signatureBuildingComponents3;
        classEnhancementBuilder2.m27267a("forEach", new C2970xd5dbd447(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        classEnhancementBuilder2.m27267a("putIfAbsent", new C2971xd5dbd448(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        classEnhancementBuilder2.m27267a("replace", new C2972xd5dbd449(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        classEnhancementBuilder2.m27267a("replace", new C2945xe59eb40f(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        classEnhancementBuilder2.m27267a("replaceAll", new C2946xe59eb410(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        classEnhancementBuilder2.m27267a("compute", new C2947xe59eb411(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        classEnhancementBuilder2.m27267a("computeIfAbsent", new C2948xe59eb412(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        classEnhancementBuilder2.m27267a("computeIfPresent", new C2949xe59eb413(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        classEnhancementBuilder2.m27267a("merge", new C2950xe59eb414(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        c = b2;
        classEnhancementBuilder = new ClassEnhancementBuilder(signatureEnhancementBuilder2, c);
        SignatureEnhancementBuilder signatureEnhancementBuilder3 = signatureEnhancementBuilder2;
        c4 = c;
        classEnhancementBuilder.m27267a("empty", new C2951xe59eb415(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        classEnhancementBuilder.m27267a("of", new C2952xe59eb416(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        classEnhancementBuilder.m27267a("ofNullable", new C2953xe59eb417(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        classEnhancementBuilder.m27267a("get", new C2954xe59eb418(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        classEnhancementBuilder.m27267a("ifPresent", new C2956xe59eb42e(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        SignatureEnhancementBuilder signatureEnhancementBuilder4 = signatureEnhancementBuilder3;
        String str12 = c2;
        new ClassEnhancementBuilder(signatureEnhancementBuilder4, SignatureBuildingComponents.m27357a("ref/Reference")).m27267a("get", new C2957xe59eb42f(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c));
        c2 = str4;
        str2 = c2;
        c5 = str12;
        String str13 = a;
        c4 = c;
        new ClassEnhancementBuilder(signatureEnhancementBuilder4, c2).m27267a("test", new C2958xe59eb430(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        str8 = str13;
        new ClassEnhancementBuilder(signatureEnhancementBuilder4, SignatureBuildingComponents.m27364c("BiPredicate")).m27267a("test", new C2959xe59eb431(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        a = str6;
        str = a;
        String str14 = c2;
        new ClassEnhancementBuilder(signatureEnhancementBuilder4, a).m27267a("accept", new C2960xe59eb432(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c));
        c2 = str10;
        str2 = str14;
        String str15 = c2;
        new ClassEnhancementBuilder(signatureEnhancementBuilder4, c2).m27267a("accept", new C2961xe59eb433(signatureBuildingComponents2, str, str2, str3, str5, c2, str8, str9, c5, c));
        c2 = str12;
        str7 = str15;
        String str16 = c2;
        new ClassEnhancementBuilder(signatureEnhancementBuilder4, c2).m27267a("apply", new C2962xe59eb434(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c2, c));
        c2 = str11;
        str9 = c2;
        c5 = str16;
        String str17 = c2;
        c4 = c;
        new ClassEnhancementBuilder(signatureEnhancementBuilder4, c2).m27267a("apply", new C2963xe59eb435(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str9, c5, c4));
        new ClassEnhancementBuilder(signatureEnhancementBuilder4, SignatureBuildingComponents.m27364c("Supplier")).m27267a("get", new C2964xe59eb436(signatureBuildingComponents2, str, str2, str3, str5, str7, str8, str17, c5, c4));
        f25755d = signatureEnhancementBuilder4.f25767a;
    }

    public static final Map<String, PredefinedFunctionEnhancementInfo> m27259a() {
        return f25755d;
    }
}
