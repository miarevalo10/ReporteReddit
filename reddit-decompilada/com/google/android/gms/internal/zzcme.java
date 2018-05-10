package com.google.android.gms.internal;

import java.io.IOException;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;

public final class zzcme extends zzfjm<zzcme> {
    private static volatile zzcme[] f17972H;
    public zzcma[] f17973A;
    public String f17974B;
    public Integer f17975C;
    public String f17976D;
    public Long f17977E;
    public Long f17978F;
    public String f17979G;
    private Integer f17980I;
    private Integer f17981J;
    public Integer f17982a;
    public zzcmb[] f17983b;
    public zzcmg[] f17984c;
    public Long f17985d;
    public Long f17986e;
    public Long f17987f;
    public Long f17988g;
    public Long f17989h;
    public String f17990i;
    public String f17991j;
    public String f17992k;
    public String f17993l;
    public Integer f17994m;
    public String f17995n;
    public String f17996o;
    public String f17997p;
    public Long f17998q;
    public Long f17999r;
    public String f18000s;
    public Boolean f18001t;
    public String f18002u;
    public Long f18003v;
    public Integer f18004w;
    public String f18005x;
    public String f18006y;
    public Boolean f18007z;

    public zzcme() {
        this.f17982a = null;
        this.f17983b = zzcmb.m18624b();
        this.f17984c = zzcmg.m18642b();
        this.f17985d = null;
        this.f17986e = null;
        this.f17987f = null;
        this.f17988g = null;
        this.f17989h = null;
        this.f17990i = null;
        this.f17991j = null;
        this.f17992k = null;
        this.f17993l = null;
        this.f17994m = null;
        this.f17995n = null;
        this.f17996o = null;
        this.f17997p = null;
        this.f17998q = null;
        this.f17999r = null;
        this.f18000s = null;
        this.f18001t = null;
        this.f18002u = null;
        this.f18003v = null;
        this.f18004w = null;
        this.f18005x = null;
        this.f18006y = null;
        this.f18007z = null;
        this.f17973A = zzcma.m18620b();
        this.f17974B = null;
        this.f17975C = null;
        this.f17980I = null;
        this.f17981J = null;
        this.f17976D = null;
        this.f17977E = null;
        this.f17978F = null;
        this.f17979G = null;
        this.X = null;
        this.Y = -1;
    }

    public static zzcme[] m18635b() {
        if (f17972H == null) {
            synchronized (zzfjq.f7554b) {
                if (f17972H == null) {
                    f17972H = new zzcme[0];
                }
            }
        }
        return f17972H;
    }

    protected final int mo1927a() {
        int i;
        int a = super.mo1927a();
        if (this.f17982a != null) {
            a += zzfjk.m6161b(1, this.f17982a.intValue());
        }
        int i2 = 0;
        if (this.f17983b != null && this.f17983b.length > 0) {
            i = a;
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f17983b) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    i += zzfjk.m6162b(2, com_google_android_gms_internal_zzfjs);
                }
            }
            a = i;
        }
        if (this.f17984c != null && this.f17984c.length > 0) {
            i = a;
            for (zzfjs com_google_android_gms_internal_zzfjs2 : this.f17984c) {
                if (com_google_android_gms_internal_zzfjs2 != null) {
                    i += zzfjk.m6162b(3, com_google_android_gms_internal_zzfjs2);
                }
            }
            a = i;
        }
        if (this.f17985d != null) {
            a += zzfjk.m6168c(4, this.f17985d.longValue());
        }
        if (this.f17986e != null) {
            a += zzfjk.m6168c(5, this.f17986e.longValue());
        }
        if (this.f17987f != null) {
            a += zzfjk.m6168c(6, this.f17987f.longValue());
        }
        if (this.f17989h != null) {
            a += zzfjk.m6168c(7, this.f17989h.longValue());
        }
        if (this.f17990i != null) {
            a += zzfjk.m6163b(8, this.f17990i);
        }
        if (this.f17991j != null) {
            a += zzfjk.m6163b(9, this.f17991j);
        }
        if (this.f17992k != null) {
            a += zzfjk.m6163b(10, this.f17992k);
        }
        if (this.f17993l != null) {
            a += zzfjk.m6163b(11, this.f17993l);
        }
        if (this.f17994m != null) {
            a += zzfjk.m6161b(12, this.f17994m.intValue());
        }
        if (this.f17995n != null) {
            a += zzfjk.m6163b(13, this.f17995n);
        }
        if (this.f17996o != null) {
            a += zzfjk.m6163b(14, this.f17996o);
        }
        if (this.f17997p != null) {
            a += zzfjk.m6163b(16, this.f17997p);
        }
        if (this.f17998q != null) {
            a += zzfjk.m6168c(17, this.f17998q.longValue());
        }
        if (this.f17999r != null) {
            a += zzfjk.m6168c(18, this.f17999r.longValue());
        }
        if (this.f18000s != null) {
            a += zzfjk.m6163b(19, this.f18000s);
        }
        if (this.f18001t != null) {
            this.f18001t.booleanValue();
            a += zzfjk.m6160b(20) + 1;
        }
        if (this.f18002u != null) {
            a += zzfjk.m6163b(21, this.f18002u);
        }
        if (this.f18003v != null) {
            a += zzfjk.m6168c(22, this.f18003v.longValue());
        }
        if (this.f18004w != null) {
            a += zzfjk.m6161b(23, this.f18004w.intValue());
        }
        if (this.f18005x != null) {
            a += zzfjk.m6163b(24, this.f18005x);
        }
        if (this.f18006y != null) {
            a += zzfjk.m6163b(25, this.f18006y);
        }
        if (this.f17988g != null) {
            a += zzfjk.m6168c(26, this.f17988g.longValue());
        }
        if (this.f18007z != null) {
            this.f18007z.booleanValue();
            a += zzfjk.m6160b(28) + 1;
        }
        if (this.f17973A != null && this.f17973A.length > 0) {
            while (i2 < this.f17973A.length) {
                zzfjs com_google_android_gms_internal_zzfjs3 = this.f17973A[i2];
                if (com_google_android_gms_internal_zzfjs3 != null) {
                    a += zzfjk.m6162b(29, com_google_android_gms_internal_zzfjs3);
                }
                i2++;
            }
        }
        if (this.f17974B != null) {
            a += zzfjk.m6163b(30, this.f17974B);
        }
        if (this.f17975C != null) {
            a += zzfjk.m6161b(31, this.f17975C.intValue());
        }
        if (this.f17980I != null) {
            a += zzfjk.m6161b(32, this.f17980I.intValue());
        }
        if (this.f17981J != null) {
            a += zzfjk.m6161b(33, this.f17981J.intValue());
        }
        if (this.f17976D != null) {
            a += zzfjk.m6163b(34, this.f17976D);
        }
        if (this.f17977E != null) {
            a += zzfjk.m6168c(35, this.f17977E.longValue());
        }
        if (this.f17978F != null) {
            a += zzfjk.m6168c(36, this.f17978F.longValue());
        }
        return this.f17979G != null ? a + zzfjk.m6163b(37, this.f17979G) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            int length;
            Object obj;
            switch (a) {
                case 0:
                    return this;
                case 8:
                    this.f17982a = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
                    break;
                case 18:
                    a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 18);
                    length = this.f17983b == null ? 0 : this.f17983b.length;
                    obj = new zzcmb[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f17983b, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = new zzcmb();
                        com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                        com_google_android_gms_internal_zzfjj.m6134a();
                        length++;
                    }
                    obj[length] = new zzcmb();
                    com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                    this.f17983b = obj;
                    break;
                case 26:
                    a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 26);
                    length = this.f17984c == null ? 0 : this.f17984c.length;
                    obj = new zzcmg[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f17984c, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = new zzcmg();
                        com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                        com_google_android_gms_internal_zzfjj.m6134a();
                        length++;
                    }
                    obj[length] = new zzcmg();
                    com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                    this.f17984c = obj;
                    break;
                case 32:
                    this.f17985d = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
                    break;
                case 40:
                    this.f17986e = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
                    break;
                case 48:
                    this.f17987f = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
                    break;
                case 56:
                    this.f17989h = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
                    break;
                case 66:
                    this.f17990i = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 74:
                    this.f17991j = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 82:
                    this.f17992k = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 90:
                    this.f17993l = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 96:
                    this.f17994m = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
                    break;
                case 106:
                    this.f17995n = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 114:
                    this.f17996o = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 130:
                    this.f17997p = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 136:
                    this.f17998q = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
                    break;
                case 144:
                    this.f17999r = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
                    break;
                case 154:
                    this.f18000s = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 160:
                    this.f18001t = Boolean.valueOf(com_google_android_gms_internal_zzfjj.m6141c());
                    break;
                case 170:
                    this.f18002u = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 176:
                    this.f18003v = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
                    break;
                case MPEGConst.GROUP_START_CODE /*184*/:
                    this.f18004w = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
                    break;
                case JpegConst.SOF2 /*194*/:
                    this.f18005x = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 202:
                    this.f18006y = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case JpegConst.RST0 /*208*/:
                    this.f17988g = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
                    break;
                case JpegConst.APP0 /*224*/:
                    this.f18007z = Boolean.valueOf(com_google_android_gms_internal_zzfjj.m6141c());
                    break;
                case JpegConst.APPA /*234*/:
                    a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, JpegConst.APPA);
                    length = this.f17973A == null ? 0 : this.f17973A.length;
                    obj = new zzcma[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f17973A, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = new zzcma();
                        com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                        com_google_android_gms_internal_zzfjj.m6134a();
                        length++;
                    }
                    obj[length] = new zzcma();
                    com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                    this.f17973A = obj;
                    break;
                case 242:
                    this.f17974B = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 248:
                    this.f17975C = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
                    break;
                case 256:
                    this.f17980I = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
                    break;
                case 264:
                    this.f17981J = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
                    break;
                case 274:
                    this.f17976D = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 280:
                    this.f17977E = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
                    break;
                case 288:
                    this.f17978F = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
                    break;
                case 298:
                    this.f17979G = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                default:
                    if (super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                        break;
                    }
                    return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17982a != null) {
            com_google_android_gms_internal_zzfjk.m6174a(1, this.f17982a.intValue());
        }
        int i = 0;
        if (this.f17983b != null && this.f17983b.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f17983b) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    com_google_android_gms_internal_zzfjk.m6176a(2, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        if (this.f17984c != null && this.f17984c.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs2 : this.f17984c) {
                if (com_google_android_gms_internal_zzfjs2 != null) {
                    com_google_android_gms_internal_zzfjk.m6176a(3, com_google_android_gms_internal_zzfjs2);
                }
            }
        }
        if (this.f17985d != null) {
            com_google_android_gms_internal_zzfjk.m6181b(4, this.f17985d.longValue());
        }
        if (this.f17986e != null) {
            com_google_android_gms_internal_zzfjk.m6181b(5, this.f17986e.longValue());
        }
        if (this.f17987f != null) {
            com_google_android_gms_internal_zzfjk.m6181b(6, this.f17987f.longValue());
        }
        if (this.f17989h != null) {
            com_google_android_gms_internal_zzfjk.m6181b(7, this.f17989h.longValue());
        }
        if (this.f17990i != null) {
            com_google_android_gms_internal_zzfjk.m6177a(8, this.f17990i);
        }
        if (this.f17991j != null) {
            com_google_android_gms_internal_zzfjk.m6177a(9, this.f17991j);
        }
        if (this.f17992k != null) {
            com_google_android_gms_internal_zzfjk.m6177a(10, this.f17992k);
        }
        if (this.f17993l != null) {
            com_google_android_gms_internal_zzfjk.m6177a(11, this.f17993l);
        }
        if (this.f17994m != null) {
            com_google_android_gms_internal_zzfjk.m6174a(12, this.f17994m.intValue());
        }
        if (this.f17995n != null) {
            com_google_android_gms_internal_zzfjk.m6177a(13, this.f17995n);
        }
        if (this.f17996o != null) {
            com_google_android_gms_internal_zzfjk.m6177a(14, this.f17996o);
        }
        if (this.f17997p != null) {
            com_google_android_gms_internal_zzfjk.m6177a(16, this.f17997p);
        }
        if (this.f17998q != null) {
            com_google_android_gms_internal_zzfjk.m6181b(17, this.f17998q.longValue());
        }
        if (this.f17999r != null) {
            com_google_android_gms_internal_zzfjk.m6181b(18, this.f17999r.longValue());
        }
        if (this.f18000s != null) {
            com_google_android_gms_internal_zzfjk.m6177a(19, this.f18000s);
        }
        if (this.f18001t != null) {
            com_google_android_gms_internal_zzfjk.m6178a(20, this.f18001t.booleanValue());
        }
        if (this.f18002u != null) {
            com_google_android_gms_internal_zzfjk.m6177a(21, this.f18002u);
        }
        if (this.f18003v != null) {
            com_google_android_gms_internal_zzfjk.m6181b(22, this.f18003v.longValue());
        }
        if (this.f18004w != null) {
            com_google_android_gms_internal_zzfjk.m6174a(23, this.f18004w.intValue());
        }
        if (this.f18005x != null) {
            com_google_android_gms_internal_zzfjk.m6177a(24, this.f18005x);
        }
        if (this.f18006y != null) {
            com_google_android_gms_internal_zzfjk.m6177a(25, this.f18006y);
        }
        if (this.f17988g != null) {
            com_google_android_gms_internal_zzfjk.m6181b(26, this.f17988g.longValue());
        }
        if (this.f18007z != null) {
            com_google_android_gms_internal_zzfjk.m6178a(28, this.f18007z.booleanValue());
        }
        if (this.f17973A != null && this.f17973A.length > 0) {
            while (i < this.f17973A.length) {
                zzfjs com_google_android_gms_internal_zzfjs3 = this.f17973A[i];
                if (com_google_android_gms_internal_zzfjs3 != null) {
                    com_google_android_gms_internal_zzfjk.m6176a(29, com_google_android_gms_internal_zzfjs3);
                }
                i++;
            }
        }
        if (this.f17974B != null) {
            com_google_android_gms_internal_zzfjk.m6177a(30, this.f17974B);
        }
        if (this.f17975C != null) {
            com_google_android_gms_internal_zzfjk.m6174a(31, this.f17975C.intValue());
        }
        if (this.f17980I != null) {
            com_google_android_gms_internal_zzfjk.m6174a(32, this.f17980I.intValue());
        }
        if (this.f17981J != null) {
            com_google_android_gms_internal_zzfjk.m6174a(33, this.f17981J.intValue());
        }
        if (this.f17976D != null) {
            com_google_android_gms_internal_zzfjk.m6177a(34, this.f17976D);
        }
        if (this.f17977E != null) {
            com_google_android_gms_internal_zzfjk.m6181b(35, this.f17977E.longValue());
        }
        if (this.f17978F != null) {
            com_google_android_gms_internal_zzfjk.m6181b(36, this.f17978F.longValue());
        }
        if (this.f17979G != null) {
            com_google_android_gms_internal_zzfjk.m6177a(37, this.f17979G);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcme)) {
            return false;
        }
        zzcme com_google_android_gms_internal_zzcme = (zzcme) obj;
        if (this.f17982a == null) {
            if (com_google_android_gms_internal_zzcme.f17982a != null) {
                return false;
            }
        } else if (!this.f17982a.equals(com_google_android_gms_internal_zzcme.f17982a)) {
            return false;
        }
        if (!zzfjq.m6198a(this.f17983b, com_google_android_gms_internal_zzcme.f17983b) || !zzfjq.m6198a(this.f17984c, com_google_android_gms_internal_zzcme.f17984c)) {
            return false;
        }
        if (this.f17985d == null) {
            if (com_google_android_gms_internal_zzcme.f17985d != null) {
                return false;
            }
        } else if (!this.f17985d.equals(com_google_android_gms_internal_zzcme.f17985d)) {
            return false;
        }
        if (this.f17986e == null) {
            if (com_google_android_gms_internal_zzcme.f17986e != null) {
                return false;
            }
        } else if (!this.f17986e.equals(com_google_android_gms_internal_zzcme.f17986e)) {
            return false;
        }
        if (this.f17987f == null) {
            if (com_google_android_gms_internal_zzcme.f17987f != null) {
                return false;
            }
        } else if (!this.f17987f.equals(com_google_android_gms_internal_zzcme.f17987f)) {
            return false;
        }
        if (this.f17988g == null) {
            if (com_google_android_gms_internal_zzcme.f17988g != null) {
                return false;
            }
        } else if (!this.f17988g.equals(com_google_android_gms_internal_zzcme.f17988g)) {
            return false;
        }
        if (this.f17989h == null) {
            if (com_google_android_gms_internal_zzcme.f17989h != null) {
                return false;
            }
        } else if (!this.f17989h.equals(com_google_android_gms_internal_zzcme.f17989h)) {
            return false;
        }
        if (this.f17990i == null) {
            if (com_google_android_gms_internal_zzcme.f17990i != null) {
                return false;
            }
        } else if (!this.f17990i.equals(com_google_android_gms_internal_zzcme.f17990i)) {
            return false;
        }
        if (this.f17991j == null) {
            if (com_google_android_gms_internal_zzcme.f17991j != null) {
                return false;
            }
        } else if (!this.f17991j.equals(com_google_android_gms_internal_zzcme.f17991j)) {
            return false;
        }
        if (this.f17992k == null) {
            if (com_google_android_gms_internal_zzcme.f17992k != null) {
                return false;
            }
        } else if (!this.f17992k.equals(com_google_android_gms_internal_zzcme.f17992k)) {
            return false;
        }
        if (this.f17993l == null) {
            if (com_google_android_gms_internal_zzcme.f17993l != null) {
                return false;
            }
        } else if (!this.f17993l.equals(com_google_android_gms_internal_zzcme.f17993l)) {
            return false;
        }
        if (this.f17994m == null) {
            if (com_google_android_gms_internal_zzcme.f17994m != null) {
                return false;
            }
        } else if (!this.f17994m.equals(com_google_android_gms_internal_zzcme.f17994m)) {
            return false;
        }
        if (this.f17995n == null) {
            if (com_google_android_gms_internal_zzcme.f17995n != null) {
                return false;
            }
        } else if (!this.f17995n.equals(com_google_android_gms_internal_zzcme.f17995n)) {
            return false;
        }
        if (this.f17996o == null) {
            if (com_google_android_gms_internal_zzcme.f17996o != null) {
                return false;
            }
        } else if (!this.f17996o.equals(com_google_android_gms_internal_zzcme.f17996o)) {
            return false;
        }
        if (this.f17997p == null) {
            if (com_google_android_gms_internal_zzcme.f17997p != null) {
                return false;
            }
        } else if (!this.f17997p.equals(com_google_android_gms_internal_zzcme.f17997p)) {
            return false;
        }
        if (this.f17998q == null) {
            if (com_google_android_gms_internal_zzcme.f17998q != null) {
                return false;
            }
        } else if (!this.f17998q.equals(com_google_android_gms_internal_zzcme.f17998q)) {
            return false;
        }
        if (this.f17999r == null) {
            if (com_google_android_gms_internal_zzcme.f17999r != null) {
                return false;
            }
        } else if (!this.f17999r.equals(com_google_android_gms_internal_zzcme.f17999r)) {
            return false;
        }
        if (this.f18000s == null) {
            if (com_google_android_gms_internal_zzcme.f18000s != null) {
                return false;
            }
        } else if (!this.f18000s.equals(com_google_android_gms_internal_zzcme.f18000s)) {
            return false;
        }
        if (this.f18001t == null) {
            if (com_google_android_gms_internal_zzcme.f18001t != null) {
                return false;
            }
        } else if (!this.f18001t.equals(com_google_android_gms_internal_zzcme.f18001t)) {
            return false;
        }
        if (this.f18002u == null) {
            if (com_google_android_gms_internal_zzcme.f18002u != null) {
                return false;
            }
        } else if (!this.f18002u.equals(com_google_android_gms_internal_zzcme.f18002u)) {
            return false;
        }
        if (this.f18003v == null) {
            if (com_google_android_gms_internal_zzcme.f18003v != null) {
                return false;
            }
        } else if (!this.f18003v.equals(com_google_android_gms_internal_zzcme.f18003v)) {
            return false;
        }
        if (this.f18004w == null) {
            if (com_google_android_gms_internal_zzcme.f18004w != null) {
                return false;
            }
        } else if (!this.f18004w.equals(com_google_android_gms_internal_zzcme.f18004w)) {
            return false;
        }
        if (this.f18005x == null) {
            if (com_google_android_gms_internal_zzcme.f18005x != null) {
                return false;
            }
        } else if (!this.f18005x.equals(com_google_android_gms_internal_zzcme.f18005x)) {
            return false;
        }
        if (this.f18006y == null) {
            if (com_google_android_gms_internal_zzcme.f18006y != null) {
                return false;
            }
        } else if (!this.f18006y.equals(com_google_android_gms_internal_zzcme.f18006y)) {
            return false;
        }
        if (this.f18007z == null) {
            if (com_google_android_gms_internal_zzcme.f18007z != null) {
                return false;
            }
        } else if (!this.f18007z.equals(com_google_android_gms_internal_zzcme.f18007z)) {
            return false;
        }
        if (!zzfjq.m6198a(this.f17973A, com_google_android_gms_internal_zzcme.f17973A)) {
            return false;
        }
        if (this.f17974B == null) {
            if (com_google_android_gms_internal_zzcme.f17974B != null) {
                return false;
            }
        } else if (!this.f17974B.equals(com_google_android_gms_internal_zzcme.f17974B)) {
            return false;
        }
        if (this.f17975C == null) {
            if (com_google_android_gms_internal_zzcme.f17975C != null) {
                return false;
            }
        } else if (!this.f17975C.equals(com_google_android_gms_internal_zzcme.f17975C)) {
            return false;
        }
        if (this.f17980I == null) {
            if (com_google_android_gms_internal_zzcme.f17980I != null) {
                return false;
            }
        } else if (!this.f17980I.equals(com_google_android_gms_internal_zzcme.f17980I)) {
            return false;
        }
        if (this.f17981J == null) {
            if (com_google_android_gms_internal_zzcme.f17981J != null) {
                return false;
            }
        } else if (!this.f17981J.equals(com_google_android_gms_internal_zzcme.f17981J)) {
            return false;
        }
        if (this.f17976D == null) {
            if (com_google_android_gms_internal_zzcme.f17976D != null) {
                return false;
            }
        } else if (!this.f17976D.equals(com_google_android_gms_internal_zzcme.f17976D)) {
            return false;
        }
        if (this.f17977E == null) {
            if (com_google_android_gms_internal_zzcme.f17977E != null) {
                return false;
            }
        } else if (!this.f17977E.equals(com_google_android_gms_internal_zzcme.f17977E)) {
            return false;
        }
        if (this.f17978F == null) {
            if (com_google_android_gms_internal_zzcme.f17978F != null) {
                return false;
            }
        } else if (!this.f17978F.equals(com_google_android_gms_internal_zzcme.f17978F)) {
            return false;
        }
        if (this.f17979G == null) {
            if (com_google_android_gms_internal_zzcme.f17979G != null) {
                return false;
            }
        } else if (!this.f17979G.equals(com_google_android_gms_internal_zzcme.f17979G)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzcme.X);
            }
        }
        return com_google_android_gms_internal_zzcme.X == null || com_google_android_gms_internal_zzcme.X.m6188a();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((527 + getClass().getName().hashCode()) * 31) + (this.f17982a == null ? 0 : this.f17982a.hashCode())) * 31) + zzfjq.m6195a(this.f17983b)) * 31) + zzfjq.m6195a(this.f17984c)) * 31) + (this.f17985d == null ? 0 : this.f17985d.hashCode())) * 31) + (this.f17986e == null ? 0 : this.f17986e.hashCode())) * 31) + (this.f17987f == null ? 0 : this.f17987f.hashCode())) * 31) + (this.f17988g == null ? 0 : this.f17988g.hashCode())) * 31) + (this.f17989h == null ? 0 : this.f17989h.hashCode())) * 31) + (this.f17990i == null ? 0 : this.f17990i.hashCode())) * 31) + (this.f17991j == null ? 0 : this.f17991j.hashCode())) * 31) + (this.f17992k == null ? 0 : this.f17992k.hashCode())) * 31) + (this.f17993l == null ? 0 : this.f17993l.hashCode())) * 31) + (this.f17994m == null ? 0 : this.f17994m.hashCode())) * 31) + (this.f17995n == null ? 0 : this.f17995n.hashCode())) * 31) + (this.f17996o == null ? 0 : this.f17996o.hashCode())) * 31) + (this.f17997p == null ? 0 : this.f17997p.hashCode())) * 31) + (this.f17998q == null ? 0 : this.f17998q.hashCode())) * 31) + (this.f17999r == null ? 0 : this.f17999r.hashCode())) * 31) + (this.f18000s == null ? 0 : this.f18000s.hashCode())) * 31) + (this.f18001t == null ? 0 : this.f18001t.hashCode())) * 31) + (this.f18002u == null ? 0 : this.f18002u.hashCode())) * 31) + (this.f18003v == null ? 0 : this.f18003v.hashCode())) * 31) + (this.f18004w == null ? 0 : this.f18004w.hashCode())) * 31) + (this.f18005x == null ? 0 : this.f18005x.hashCode())) * 31) + (this.f18006y == null ? 0 : this.f18006y.hashCode())) * 31) + (this.f18007z == null ? 0 : this.f18007z.hashCode())) * 31) + zzfjq.m6195a(this.f17973A)) * 31) + (this.f17974B == null ? 0 : this.f17974B.hashCode())) * 31) + (this.f17975C == null ? 0 : this.f17975C.hashCode())) * 31) + (this.f17980I == null ? 0 : this.f17980I.hashCode())) * 31) + (this.f17981J == null ? 0 : this.f17981J.hashCode())) * 31) + (this.f17976D == null ? 0 : this.f17976D.hashCode())) * 31) + (this.f17977E == null ? 0 : this.f17977E.hashCode())) * 31) + (this.f17978F == null ? 0 : this.f17978F.hashCode())) * 31) + (this.f17979G == null ? 0 : this.f17979G.hashCode())) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                i = this.X.hashCode();
            }
        }
        return hashCode + i;
    }
}
