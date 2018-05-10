package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.builtins.BuiltInsProtoBuf.BuiltIns;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;

/* compiled from: BuiltInsPackageFragment.kt */
public final class BuiltInsPackageFragment extends DeserializedPackageFragment {
    final BuiltInsClassDataFinder f40838a;
    private final BuiltIns f40839c;
    private final NameResolverImpl f40840e;

    public BuiltInsPackageFragment(kotlin.reflect.jvm.internal.impl.name.FqName r5, kotlin.reflect.jvm.internal.impl.storage.StorageManager r6, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r7, java.io.InputStream r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = "fqName";
        kotlin.jvm.internal.Intrinsics.m26847b(r5, r0);
        r0 = "storageManager";
        kotlin.jvm.internal.Intrinsics.m26847b(r6, r0);
        r0 = "module";
        kotlin.jvm.internal.Intrinsics.m26847b(r7, r0);
        r0 = "inputStream";
        kotlin.jvm.internal.Intrinsics.m26847b(r8, r0);
        r4.<init>(r5, r6, r7);
        r8 = (java.io.Closeable) r8;
        r5 = 0;
        r6 = r8;	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r6 = (java.io.InputStream) r6;	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r7 = kotlin.reflect.jvm.internal.impl.builtins.BuiltInsBinaryVersion.f32614b;	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r7 = kotlin.reflect.jvm.internal.impl.builtins.BuiltInsBinaryVersion.Companion.m26937a(r6);	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r0 = r7.m32912a();	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        if (r0 != 0) goto L_0x0061;	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
    L_0x0029:
        r6 = new java.lang.UnsupportedOperationException;	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r1 = "Kotlin built-in definition format version is not supported: ";	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r0.<init>(r1);	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r2 = "expected ";	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r1.<init>(r2);	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r2 = kotlin.reflect.jvm.internal.impl.builtins.BuiltInsBinaryVersion.f32613a;	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r1.append(r2);	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r2 = ", actual ";	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r1.append(r2);	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r1.append(r7);	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r7 = ". ";	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r1.append(r7);	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r7 = r1.toString();	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r0.append(r7);	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r7 = "Please update Kotlin";	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r0.append(r7);	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r7 = r0.toString();	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r6.<init>(r7);	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r6 = (java.lang.Throwable) r6;	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        throw r6;	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
    L_0x0061:
        r7 = kotlin.reflect.jvm.internal.impl.builtins.BuiltInSerializerProtocol.f32612b;	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r7 = r7.f26178c;	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r6 = kotlin.reflect.jvm.internal.impl.serialization.builtins.BuiltInsProtoBuf.BuiltIns.m40248a(r6, r7);	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        if (r8 == 0) goto L_0x006e;
    L_0x006b:
        r8.close();
    L_0x006e:
        r6 = (kotlin.reflect.jvm.internal.impl.serialization.builtins.BuiltInsProtoBuf.BuiltIns) r6;
        r4.f40839c = r6;
        r5 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverImpl;
        r6 = r4.f40839c;
        r6 = r6.f39870d;
        r7 = "proto.strings";
        kotlin.jvm.internal.Intrinsics.m26843a(r6, r7);
        r7 = r4.f40839c;
        r7 = r7.f39871e;
        r8 = "proto.qualifiedNames";
        kotlin.jvm.internal.Intrinsics.m26843a(r7, r8);
        r5.<init>(r6, r7);
        r4.f40840e = r5;
        r5 = new kotlin.reflect.jvm.internal.impl.builtins.BuiltInsClassDataFinder;
        r6 = r4.f40839c;
        r7 = "proto";
        kotlin.jvm.internal.Intrinsics.m26843a(r6, r7);
        r7 = r4.f40840e;
        r7 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver) r7;
        r5.<init>(r6, r7);
        r4.f40838a = r5;
        return;
    L_0x009e:
        r6 = move-exception;
        goto L_0x00b0;
    L_0x00a0:
        r5 = move-exception;
        r6 = 1;
        if (r8 == 0) goto L_0x00ad;
    L_0x00a4:
        r8.close();	 Catch:{ Exception -> 0x00ad }
        goto L_0x00ad;
    L_0x00a8:
        r5 = move-exception;
        r3 = r6;
        r6 = r5;
        r5 = r3;
        goto L_0x00b0;
    L_0x00ad:
        r5 = (java.lang.Throwable) r5;	 Catch:{ all -> 0x00a8 }
        throw r5;	 Catch:{ all -> 0x00a8 }
    L_0x00b0:
        if (r5 != 0) goto L_0x00b7;
    L_0x00b2:
        if (r8 == 0) goto L_0x00b7;
    L_0x00b4:
        r8.close();
    L_0x00b7:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment.<init>(kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, java.io.InputStream):void");
    }

    public final /* bridge */ /* synthetic */ ClassDataFinder mo7792a() {
        return this.f40838a;
    }

    public final /* synthetic */ MemberScope mo7793b() {
        PackageFragmentDescriptor packageFragmentDescriptor = this;
        Object obj = this.f40839c.f39872f;
        Intrinsics.m26843a(obj, "proto.`package`");
        NameResolver nameResolver = this.f40840e;
        DeserializationComponents deserializationComponents = this.f40808b;
        if (deserializationComponents == null) {
            Intrinsics.m26844a("components");
        }
        return new DeserializedPackageMemberScope(packageFragmentDescriptor, obj, nameResolver, null, deserializationComponents, new BuiltInsPackageFragment$computeMemberScope$1(this));
    }
}
