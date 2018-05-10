package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzeu implements IInterface {
    private final IBinder f7371a;
    private final String f7372b;

    protected zzeu(IBinder iBinder, String str) {
        this.f7371a = iBinder;
        this.f7372b = str;
    }

    protected final Parcel m5934a(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f7371a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } catch (RuntimeException e) {
            i = e;
            throw i;
        } finally {
            
/*
Method generation error in method: com.google.android.gms.internal.zzeu.a(int, android.os.Parcel):android.os.Parcel
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0018: INVOKE  (wrap: android.os.Parcel
  ?: MERGE  (r5_1 android.os.Parcel) = (r5_0 'parcel' android.os.Parcel), (r0_0 'obtain' android.os.Parcel)) android.os.Parcel.recycle():void type: VIRTUAL in method: com.google.android.gms.internal.zzeu.a(int, android.os.Parcel):android.os.Parcel
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r5_1 android.os.Parcel) = (r5_0 'parcel' android.os.Parcel), (r0_0 'obtain' android.os.Parcel) in method: com.google.android.gms.internal.zzeu.a(int, android.os.Parcel):android.os.Parcel
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:84)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:625)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:343)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 21 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:211)
	... 26 more

*/

            public IBinder asBinder() {
                return this.f7371a;
            }

            protected final void m5935b(int i, Parcel parcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    this.f7371a.transact(i, parcel, obtain, 0);
                    obtain.readException();
                } finally {
                    parcel.recycle();
                    obtain.recycle();
                }
            }

            protected final void m5936c(int i, Parcel parcel) throws RemoteException {
                try {
                    this.f7371a.transact(i, parcel, null, 1);
                } finally {
                    parcel.recycle();
                }
            }

            protected final Parcel o_() {
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(this.f7372b);
                return obtain;
            }
        }
