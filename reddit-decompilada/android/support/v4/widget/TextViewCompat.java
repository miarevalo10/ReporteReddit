package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.os.BuildCompat;
import android.widget.TextView;
import java.lang.reflect.Field;

public final class TextViewCompat {
    static final TextViewCompatBaseImpl f1671a;

    static class TextViewCompatBaseImpl {
        private static Field f1667a;
        private static boolean f1668b;
        private static Field f1669c;
        private static boolean f1670d;

        TextViewCompatBaseImpl() {
        }

        public void mo3160a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }

        private static java.lang.reflect.Field m1423a(java.lang.String r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = android.widget.TextView.class;	 Catch:{ NoSuchFieldException -> 0x000b }
            r0 = r0.getDeclaredField(r4);	 Catch:{ NoSuchFieldException -> 0x000b }
            r1 = 1;
            r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x000c }
            goto L_0x0024;
        L_0x000b:
            r0 = 0;
        L_0x000c:
            r1 = "TextViewCompatBase";
            r2 = new java.lang.StringBuilder;
            r3 = "Could not retrieve ";
            r2.<init>(r3);
            r2.append(r4);
            r4 = " field.";
            r2.append(r4);
            r4 = r2.toString();
            android.util.Log.e(r1, r4);
        L_0x0024:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl.a(java.lang.String):java.lang.reflect.Field");
        }

        private static int m1422a(java.lang.reflect.Field r2, android.widget.TextView r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = r2.getInt(r3);	 Catch:{ IllegalAccessException -> 0x0005 }
            return r3;
        L_0x0005:
            r3 = "TextViewCompatBase";
            r0 = new java.lang.StringBuilder;
            r1 = "Could not retrieve value of ";
            r0.<init>(r1);
            r2 = r2.getName();
            r0.append(r2);
            r2 = " field.";
            r0.append(r2);
            r2 = r0.toString();
            android.util.Log.d(r3, r2);
            r2 = -1;
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl.a(java.lang.reflect.Field, android.widget.TextView):int");
        }

        public int mo408a(TextView textView) {
            if (!f1670d) {
                f1669c = m1423a("mMaxMode");
                f1670d = true;
            }
            if (f1669c != null && m1422a(f1669c, textView) == 1) {
                if (!f1668b) {
                    f1667a = m1423a("mMaximum");
                    f1668b = true;
                }
                if (f1667a != null) {
                    return m1422a(f1667a, textView);
                }
            }
            return -1;
        }

        public void mo4222a(TextView textView, int i) {
            textView.setTextAppearance(textView.getContext(), i);
        }

        public Drawable[] mo3161b(TextView textView) {
            return textView.getCompoundDrawables();
        }
    }

    @RequiresApi(16)
    static class TextViewCompatApi16Impl extends TextViewCompatBaseImpl {
        TextViewCompatApi16Impl() {
        }

        public final int mo408a(TextView textView) {
            return textView.getMaxLines();
        }
    }

    @RequiresApi(17)
    static class TextViewCompatApi17Impl extends TextViewCompatApi16Impl {
        TextViewCompatApi17Impl() {
        }

        public void mo3160a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            Object obj = 1;
            if (textView.getLayoutDirection() != 1) {
                obj = null;
            }
            Drawable drawable5 = obj != null ? drawable3 : drawable;
            if (obj == null) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        }

        public Drawable[] mo3161b(TextView textView) {
            int i = 1;
            if (textView.getLayoutDirection() != 1) {
                i = 0;
            }
            textView = textView.getCompoundDrawables();
            if (i != 0) {
                Object obj = textView[2];
                Object obj2 = textView[0];
                textView[0] = obj;
                textView[2] = obj2;
            }
            return textView;
        }
    }

    @RequiresApi(18)
    static class TextViewCompatApi18Impl extends TextViewCompatApi17Impl {
        TextViewCompatApi18Impl() {
        }

        public final void mo3160a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        public final Drawable[] mo3161b(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }
    }

    @RequiresApi(23)
    static class TextViewCompatApi23Impl extends TextViewCompatApi18Impl {
        TextViewCompatApi23Impl() {
        }

        public final void mo4222a(TextView textView, int i) {
            textView.setTextAppearance(i);
        }
    }

    @RequiresApi(27)
    static class TextViewCompatApi27Impl extends TextViewCompatApi23Impl {
        TextViewCompatApi27Impl() {
        }
    }

    static {
        if (BuildCompat.m971a()) {
            f1671a = new TextViewCompatApi27Impl();
        } else if (VERSION.SDK_INT >= 23) {
            f1671a = new TextViewCompatApi23Impl();
        } else if (VERSION.SDK_INT >= 18) {
            f1671a = new TextViewCompatApi18Impl();
        } else if (VERSION.SDK_INT >= 17) {
            f1671a = new TextViewCompatApi17Impl();
        } else if (VERSION.SDK_INT >= 16) {
            f1671a = new TextViewCompatApi16Impl();
        } else {
            f1671a = new TextViewCompatBaseImpl();
        }
    }

    public static void m1430a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f1671a.mo3160a(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static int m1428a(TextView textView) {
        return f1671a.mo408a(textView);
    }

    public static void m1429a(TextView textView, int i) {
        f1671a.mo4222a(textView, i);
    }

    public static Drawable[] m1431b(TextView textView) {
        return f1671a.mo3161b(textView);
    }
}
