package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public final class PasswordSpecification extends zzbfm implements ReflectedParcelable {
    public static final Creator<PasswordSpecification> CREATOR = new zzj();
    public static final PasswordSpecification f17216a = new zza().m4590a().m4591a("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").m4592b("abcdefghijkmnopqrstxyz").m4592b("ABCDEFGHJKLMNPQRSTXY").m4592b("3456789").m4593b();
    private static PasswordSpecification f17217b = new zza().m4590a().m4591a("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").m4592b("abcdefghijklmnopqrstuvwxyz").m4592b("ABCDEFGHIJKLMNOPQRSTUVWXYZ").m4592b("1234567890").m4593b();
    private String f17218c;
    private List<String> f17219d;
    private List<Integer> f17220e;
    private int f17221f;
    private int f17222g;
    private final int[] f17223h;
    private final Random f17224i;

    public static class zza {
        private final TreeSet<Character> f5703a = new TreeSet();
        private final List<String> f5704b = new ArrayList();
        private final List<Integer> f5705c = new ArrayList();
        private int f5706d = 12;
        private int f5707e = 16;

        private static TreeSet<Character> m4589a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                throw new zzb(String.valueOf(str2).concat(" cannot be null or empty"));
            }
            TreeSet<Character> treeSet = new TreeSet();
            for (int i : str.toCharArray()) {
                if (PasswordSpecification.m17562a(i)) {
                    throw new zzb(String.valueOf(str2).concat(" must only contain ASCII printable characters"));
                }
                treeSet.add(Character.valueOf(i));
            }
            return treeSet;
        }

        public final zza m4590a() {
            this.f5706d = 12;
            this.f5707e = 16;
            return this;
        }

        public final zza m4591a(String str) {
            this.f5703a.addAll(m4589a(str, "allowedChars"));
            return this;
        }

        public final zza m4592b(String str) {
            this.f5704b.add(PasswordSpecification.m17561a(m4589a(str, "requiredChars")));
            this.f5705c.add(Integer.valueOf(1));
            return this;
        }

        public final PasswordSpecification m4593b() {
            if (this.f5703a.isEmpty()) {
                throw new zzb("no allowed characters specified");
            }
            int i = 0;
            for (Integer intValue : this.f5705c) {
                i += intValue.intValue();
            }
            if (i > this.f5707e) {
                throw new zzb("required character count cannot be greater than the max password size");
            }
            boolean[] zArr = new boolean[95];
            for (String toCharArray : this.f5704b) {
                for (char c : toCharArray.toCharArray()) {
                    int i2 = c - 32;
                    if (zArr[i2]) {
                        StringBuilder stringBuilder = new StringBuilder(58);
                        stringBuilder.append("character ");
                        stringBuilder.append(c);
                        stringBuilder.append(" occurs in more than one required character set");
                        throw new zzb(stringBuilder.toString());
                    }
                    zArr[i2] = true;
                }
            }
            return new PasswordSpecification(PasswordSpecification.m17561a(this.f5703a), this.f5704b, this.f5705c, this.f5706d, this.f5707e);
        }
    }

    public static class zzb extends Error {
        public zzb(String str) {
            super(str);
        }
    }

    PasswordSpecification(String str, List<String> list, List<Integer> list2, int i, int i2) {
        this.f17218c = str;
        this.f17219d = Collections.unmodifiableList(list);
        this.f17220e = Collections.unmodifiableList(list2);
        this.f17221f = i;
        this.f17222g = i2;
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        i = 0;
        for (String toCharArray : this.f17219d) {
            for (char c : toCharArray.toCharArray()) {
                iArr[c - 32] = i;
            }
            i++;
        }
        this.f17223h = iArr;
        this.f17224i = new SecureRandom();
    }

    static /* synthetic */ boolean m17562a(int i) {
        if (i >= 32) {
            if (i <= 126) {
                return false;
            }
        }
        return true;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 1, this.f17218c);
        zzbfp.m5557b(parcel, 2, this.f17219d);
        zzbfp.m5546a(parcel, 3, this.f17220e);
        zzbfp.m5540a(parcel, 4, this.f17221f);
        zzbfp.m5540a(parcel, 5, this.f17222g);
        zzbfp.m5537a(parcel, i);
    }

    static /* synthetic */ String m17561a(Collection collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        for (Character charValue : collection) {
            int i2 = i + 1;
            cArr[i] = charValue.charValue();
            i = i2;
        }
        return new String(cArr);
    }
}
