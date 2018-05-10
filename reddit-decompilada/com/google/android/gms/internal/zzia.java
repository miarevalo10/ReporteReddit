package com.google.android.gms.internal;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;

@zzzv
public final class zzia {
    private final zzhq f7712a;
    private final int f7713b;
    private String f7714c;
    private String f7715d;
    private final boolean f7716e = false;
    private final int f7717f;
    private final int f7718g;

    public zzia(int i, int i2, int i3) {
        this.f7713b = i;
        if (i2 <= 64) {
            if (i2 >= 0) {
                this.f7717f = i2;
                if (i3 > 0) {
                    this.f7718g = 1;
                } else {
                    this.f7718g = i3;
                }
                this.f7712a = new zzhz(this.f7717f);
            }
        }
        this.f7717f = 64;
        if (i3 > 0) {
            this.f7718g = i3;
        } else {
            this.f7718g = 1;
        }
        this.f7712a = new zzhz(this.f7717f);
    }

    private final boolean m6309a(String str, HashSet<String> hashSet) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return true;
        }
        for (String str2 : split) {
            String str22;
            int i;
            int i2;
            if (str22.indexOf("'") != -1) {
                StringBuilder stringBuilder = new StringBuilder(str22);
                i = 1;
                boolean z = false;
                while (true) {
                    i2 = i + 2;
                    if (i2 > stringBuilder.length()) {
                        break;
                    }
                    if (stringBuilder.charAt(i) == '\'') {
                        if (stringBuilder.charAt(i - 1) != ' ') {
                            int i3 = i + 1;
                            if ((stringBuilder.charAt(i3) == 's' || stringBuilder.charAt(i3) == 'S') && (i2 == stringBuilder.length() || stringBuilder.charAt(i2) == ' ')) {
                                stringBuilder.insert(i, ' ');
                                i = i2;
                                z = true;
                            }
                        }
                        stringBuilder.setCharAt(i, ' ');
                        z = true;
                    }
                    i++;
                }
                String stringBuilder2 = z ? stringBuilder.toString() : null;
                if (stringBuilder2 != null) {
                    this.f7715d = stringBuilder2;
                    str22 = stringBuilder2;
                }
            }
            String[] a = zzhu.m6302a(str22, true);
            if (a.length >= this.f7718g) {
                for (int i4 = 0; i4 < a.length; i4++) {
                    boolean z2;
                    Object obj = "";
                    for (i = 0; i < this.f7718g; i++) {
                        i2 = i4 + i;
                        if (i2 >= a.length) {
                            z2 = false;
                            break;
                        }
                        if (i > 0) {
                            obj = String.valueOf(obj).concat(" ");
                        }
                        String valueOf = String.valueOf(obj);
                        String valueOf2 = String.valueOf(a[i2]);
                        obj = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                    }
                    z2 = true;
                    if (!z2) {
                        break;
                    }
                    hashSet.add(obj);
                    if (hashSet.size() >= this.f7713b) {
                        return false;
                    }
                }
                if (hashSet.size() >= this.f7713b) {
                    return false;
                }
            }
        }
        return true;
    }

    public final String m6310a(ArrayList<String> arrayList, ArrayList<zzhp> arrayList2) {
        Collections.sort(arrayList2, new zzib());
        HashSet hashSet = new HashSet();
        int i = 0;
        while (i < arrayList2.size() && m6309a(Normalizer.normalize((CharSequence) arrayList.get(((zzhp) arrayList2.get(i)).f7700e), Form.NFKC).toLowerCase(Locale.US), hashSet)) {
            i++;
        }
        arrayList = new zzht();
        this.f7714c = "";
        arrayList2 = hashSet.iterator();
        while (arrayList2.hasNext()) {
            try {
                arrayList.m6300a(this.f7712a.mo1953a((String) arrayList2.next()));
            } catch (ArrayList<zzhp> arrayList22) {
                zzakb.m5367b("Error while writing hash to byteStream", arrayList22);
            }
        }
        return arrayList.toString();
    }
}
