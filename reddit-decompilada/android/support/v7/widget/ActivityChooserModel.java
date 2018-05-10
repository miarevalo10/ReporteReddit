package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ActivityChooserModel extends DataSetObservable {
    static final String f2083a = "ActivityChooserModel";
    private static final Object f2084g = new Object();
    private static final Map<String, ActivityChooserModel> f2085h = new HashMap();
    final Object f2086b;
    final List<ActivityResolveInfo> f2087c;
    final Context f2088d;
    final String f2089e;
    boolean f2090f;
    private final List<HistoricalRecord> f2091i;
    private Intent f2092j;
    private ActivitySorter f2093k;
    private int f2094l;
    private boolean f2095m;
    private boolean f2096n;
    private boolean f2097o;
    private OnChooseActivityListener f2098p;

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo f2077a;
        public float f2078b;

        public final /* synthetic */ int compareTo(Object obj) {
            return Float.floatToIntBits(((ActivityResolveInfo) obj).f2078b) - Float.floatToIntBits(this.f2078b);
        }

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.f2077a = resolveInfo;
        }

        public final int hashCode() {
            return 31 + Float.floatToIntBits(this.f2078b);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Float.floatToIntBits(this.f2078b) == Float.floatToIntBits(((ActivityResolveInfo) obj).f2078b);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:");
            stringBuilder.append(this.f2077a.toString());
            stringBuilder.append("; weight:");
            stringBuilder.append(new BigDecimal((double) this.f2078b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface ActivitySorter {
    }

    public static final class HistoricalRecord {
        public final ComponentName f2079a;
        public final long f2080b;
        public final float f2081c;

        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            this.f2079a = componentName;
            this.f2080b = j;
            this.f2081c = f;
        }

        public final int hashCode() {
            return (31 * ((((this.f2079a == null ? 0 : this.f2079a.hashCode()) + 31) * 31) + ((int) (this.f2080b ^ (this.f2080b >>> 32))))) + Float.floatToIntBits(this.f2081c);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            if (this.f2079a == null) {
                if (historicalRecord.f2079a != null) {
                    return false;
                }
            } else if (!this.f2079a.equals(historicalRecord.f2079a)) {
                return false;
            }
            return this.f2080b == historicalRecord.f2080b && Float.floatToIntBits(this.f2081c) == Float.floatToIntBits(historicalRecord.f2081c);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:");
            stringBuilder.append(this.f2079a);
            stringBuilder.append("; time:");
            stringBuilder.append(this.f2080b);
            stringBuilder.append("; weight:");
            stringBuilder.append(new BigDecimal((double) this.f2081c));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface OnChooseActivityListener {
        boolean m1763a();
    }

    private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ ActivityChooserModel f2082a;

        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return m1764a(objArr);
        }

        PersistHistoryAsyncTask(ActivityChooserModel activityChooserModel) {
            this.f2082a = activityChooserModel;
        }

        private java.lang.Void m1764a(java.lang.Object... r12) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r11 = this;
            r0 = 0;
            r1 = r12[r0];
            r1 = (java.util.List) r1;
            r2 = 1;
            r12 = r12[r2];
            r12 = (java.lang.String) r12;
            r3 = 0;
            r4 = r11.f2082a;	 Catch:{ FileNotFoundException -> 0x00df }
            r4 = r4.f2088d;	 Catch:{ FileNotFoundException -> 0x00df }
            r4 = r4.openFileOutput(r12, r0);	 Catch:{ FileNotFoundException -> 0x00df }
            r12 = android.util.Xml.newSerializer();
            r12.setOutput(r4, r3);	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r5 = "UTF-8";	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r6 = java.lang.Boolean.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r12.startDocument(r5, r6);	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r5 = "historical-records";	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r12.startTag(r3, r5);	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r5 = r1.size();	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r6 = r0;	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
        L_0x002d:
            if (r6 >= r5) goto L_0x0063;	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
        L_0x002f:
            r7 = r1.remove(r0);	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r7 = (android.support.v7.widget.ActivityChooserModel.HistoricalRecord) r7;	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r8 = "historical-record";	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r12.startTag(r3, r8);	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r8 = "activity";	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r9 = r7.f2079a;	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r9 = r9.flattenToString();	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r12.attribute(r3, r8, r9);	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r8 = "time";	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r9 = r7.f2080b;	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r9 = java.lang.String.valueOf(r9);	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r12.attribute(r3, r8, r9);	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r8 = "weight";	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r7 = r7.f2081c;	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r7 = java.lang.String.valueOf(r7);	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r12.attribute(r3, r8, r7);	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r7 = "historical-record";	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r12.endTag(r3, r7);	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r6 = r6 + 1;	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            goto L_0x002d;	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
        L_0x0063:
            r0 = "historical-records";	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r12.endTag(r3, r0);	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r12.endDocument();	 Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0096, IOException -> 0x0077 }
            r12 = r11.f2082a;
            r12.f2090f = r2;
            if (r4 == 0) goto L_0x00d4;
        L_0x0071:
            r4.close();	 Catch:{ IOException -> 0x00d4 }
            goto L_0x00d4;
        L_0x0075:
            r12 = move-exception;
            goto L_0x00d5;
        L_0x0077:
            r12 = move-exception;
            r0 = android.support.v7.widget.ActivityChooserModel.f2083a;	 Catch:{ all -> 0x0075 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
            r5 = "Error writing historical record file: ";	 Catch:{ all -> 0x0075 }
            r1.<init>(r5);	 Catch:{ all -> 0x0075 }
            r5 = r11.f2082a;	 Catch:{ all -> 0x0075 }
            r5 = r5.f2089e;	 Catch:{ all -> 0x0075 }
            r1.append(r5);	 Catch:{ all -> 0x0075 }
            r1 = r1.toString();	 Catch:{ all -> 0x0075 }
            android.util.Log.e(r0, r1, r12);	 Catch:{ all -> 0x0075 }
            r12 = r11.f2082a;
            r12.f2090f = r2;
            if (r4 == 0) goto L_0x00d4;
        L_0x0095:
            goto L_0x0071;
        L_0x0096:
            r12 = move-exception;
            r0 = android.support.v7.widget.ActivityChooserModel.f2083a;	 Catch:{ all -> 0x0075 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
            r5 = "Error writing historical record file: ";	 Catch:{ all -> 0x0075 }
            r1.<init>(r5);	 Catch:{ all -> 0x0075 }
            r5 = r11.f2082a;	 Catch:{ all -> 0x0075 }
            r5 = r5.f2089e;	 Catch:{ all -> 0x0075 }
            r1.append(r5);	 Catch:{ all -> 0x0075 }
            r1 = r1.toString();	 Catch:{ all -> 0x0075 }
            android.util.Log.e(r0, r1, r12);	 Catch:{ all -> 0x0075 }
            r12 = r11.f2082a;
            r12.f2090f = r2;
            if (r4 == 0) goto L_0x00d4;
        L_0x00b4:
            goto L_0x0071;
        L_0x00b5:
            r12 = move-exception;
            r0 = android.support.v7.widget.ActivityChooserModel.f2083a;	 Catch:{ all -> 0x0075 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
            r5 = "Error writing historical record file: ";	 Catch:{ all -> 0x0075 }
            r1.<init>(r5);	 Catch:{ all -> 0x0075 }
            r5 = r11.f2082a;	 Catch:{ all -> 0x0075 }
            r5 = r5.f2089e;	 Catch:{ all -> 0x0075 }
            r1.append(r5);	 Catch:{ all -> 0x0075 }
            r1 = r1.toString();	 Catch:{ all -> 0x0075 }
            android.util.Log.e(r0, r1, r12);	 Catch:{ all -> 0x0075 }
            r12 = r11.f2082a;
            r12.f2090f = r2;
            if (r4 == 0) goto L_0x00d4;
        L_0x00d3:
            goto L_0x0071;
        L_0x00d4:
            return r3;
        L_0x00d5:
            r0 = r11.f2082a;
            r0.f2090f = r2;
            if (r4 == 0) goto L_0x00de;
        L_0x00db:
            r4.close();	 Catch:{ IOException -> 0x00de }
        L_0x00de:
            throw r12;
        L_0x00df:
            r0 = move-exception;
            r1 = android.support.v7.widget.ActivityChooserModel.f2083a;
            r2 = new java.lang.StringBuilder;
            r4 = "Error writing historical record file: ";
            r2.<init>(r4);
            r2.append(r12);
            r12 = r2.toString();
            android.util.Log.e(r1, r12, r0);
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActivityChooserModel.PersistHistoryAsyncTask.a(java.lang.Object[]):java.lang.Void");
        }
    }

    public final int m1768a() {
        int size;
        synchronized (this.f2086b) {
            m1774c();
            size = this.f2087c.size();
        }
        return size;
    }

    public final ResolveInfo m1770a(int i) {
        synchronized (this.f2086b) {
            m1774c();
            i = ((ActivityResolveInfo) this.f2087c.get(i)).f2077a;
        }
        return i;
    }

    public final int m1769a(ResolveInfo resolveInfo) {
        synchronized (this.f2086b) {
            m1774c();
            List list = this.f2087c;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((ActivityResolveInfo) list.get(i)).f2077a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public final Intent m1772b(int i) {
        synchronized (this.f2086b) {
            if (this.f2092j == null) {
                return null;
            }
            m1774c();
            ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) this.f2087c.get(i);
            ComponentName componentName = new ComponentName(activityResolveInfo.f2077a.activityInfo.packageName, activityResolveInfo.f2077a.activityInfo.name);
            i = new Intent(this.f2092j);
            i.setComponent(componentName);
            if (this.f2098p != null) {
                Intent intent = new Intent(i);
                if (this.f2098p.m1763a()) {
                    return null;
                }
            }
            m1771a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return i;
        }
    }

    public final ResolveInfo m1773b() {
        synchronized (this.f2086b) {
            m1774c();
            if (this.f2087c.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((ActivityResolveInfo) this.f2087c.get(0)).f2077a;
            return resolveInfo;
        }
    }

    private boolean m1765d() {
        if (this.f2093k == null || this.f2092j == null || this.f2087c.isEmpty() || this.f2091i.isEmpty()) {
            return false;
        }
        Collections.unmodifiableList(this.f2091i);
        return true;
    }

    final boolean m1771a(HistoricalRecord historicalRecord) {
        historicalRecord = this.f2091i.add(historicalRecord);
        if (historicalRecord != null) {
            this.f2096n = true;
            m1766e();
            if (this.f2095m) {
                if (this.f2096n) {
                    this.f2096n = false;
                    if (!TextUtils.isEmpty(this.f2089e)) {
                        new PersistHistoryAsyncTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.f2091i), this.f2089e});
                    }
                }
                m1765d();
                notifyChanged();
            } else {
                throw new IllegalStateException("No preceding call to #readHistoricalData");
            }
        }
        return historicalRecord;
    }

    private void m1766e() {
        int size = this.f2091i.size() - this.f2094l;
        if (size > 0) {
            this.f2096n = true;
            for (int i = 0; i < size; i++) {
                this.f2091i.remove(0);
            }
        }
    }

    private void m1767f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r9 = this;
        r0 = r9.f2088d;	 Catch:{ FileNotFoundException -> 0x00c1 }
        r1 = r9.f2089e;	 Catch:{ FileNotFoundException -> 0x00c1 }
        r0 = r0.openFileInput(r1);	 Catch:{ FileNotFoundException -> 0x00c1 }
        r1 = android.util.Xml.newPullParser();	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r2 = "UTF-8";	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r1.setInput(r0, r2);	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r2 = 0;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
    L_0x0012:
        r3 = 1;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        if (r2 == r3) goto L_0x001d;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
    L_0x0015:
        r4 = 2;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        if (r2 == r4) goto L_0x001d;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
    L_0x0018:
        r2 = r1.next();	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        goto L_0x0012;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
    L_0x001d:
        r2 = "historical-records";	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r4 = r1.getName();	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r2 = r2.equals(r4);	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        if (r2 != 0) goto L_0x0031;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
    L_0x0029:
        r1 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r2 = "Share records file does not start with historical-records tag.";	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r1.<init>(r2);	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        throw r1;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
    L_0x0031:
        r2 = r9.f2091i;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r2.clear();	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
    L_0x0036:
        r4 = r1.next();	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        if (r4 == r3) goto L_0x007a;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
    L_0x003c:
        r5 = 3;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        if (r4 == r5) goto L_0x0036;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
    L_0x003f:
        r5 = 4;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        if (r4 == r5) goto L_0x0036;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
    L_0x0042:
        r4 = r1.getName();	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r5 = "historical-record";	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r4 = r5.equals(r4);	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        if (r4 != 0) goto L_0x0056;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
    L_0x004e:
        r1 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r2 = "Share records file not well-formed.";	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r1.<init>(r2);	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        throw r1;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
    L_0x0056:
        r4 = "activity";	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r5 = 0;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r4 = r1.getAttributeValue(r5, r4);	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r6 = "time";	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r6 = r1.getAttributeValue(r5, r6);	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r6 = java.lang.Long.parseLong(r6);	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r8 = "weight";	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r5 = r1.getAttributeValue(r5, r8);	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r5 = java.lang.Float.parseFloat(r5);	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r8 = new android.support.v7.widget.ActivityChooserModel$HistoricalRecord;	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r8.<init>(r4, r6, r5);	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        r2.add(r8);	 Catch:{ XmlPullParserException -> 0x009e, IOException -> 0x0082 }
        goto L_0x0036;
    L_0x007a:
        if (r0 == 0) goto L_0x00ba;
    L_0x007c:
        r0.close();	 Catch:{ IOException -> 0x007f }
    L_0x007f:
        return;
    L_0x0080:
        r1 = move-exception;
        goto L_0x00bb;
    L_0x0082:
        r1 = move-exception;
        r2 = f2083a;	 Catch:{ all -> 0x0080 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0080 }
        r4 = "Error reading historical recrod file: ";	 Catch:{ all -> 0x0080 }
        r3.<init>(r4);	 Catch:{ all -> 0x0080 }
        r4 = r9.f2089e;	 Catch:{ all -> 0x0080 }
        r3.append(r4);	 Catch:{ all -> 0x0080 }
        r3 = r3.toString();	 Catch:{ all -> 0x0080 }
        android.util.Log.e(r2, r3, r1);	 Catch:{ all -> 0x0080 }
        if (r0 == 0) goto L_0x00ba;
    L_0x009a:
        r0.close();	 Catch:{ IOException -> 0x009d }
    L_0x009d:
        return;
    L_0x009e:
        r1 = move-exception;
        r2 = f2083a;	 Catch:{ all -> 0x0080 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0080 }
        r4 = "Error reading historical recrod file: ";	 Catch:{ all -> 0x0080 }
        r3.<init>(r4);	 Catch:{ all -> 0x0080 }
        r4 = r9.f2089e;	 Catch:{ all -> 0x0080 }
        r3.append(r4);	 Catch:{ all -> 0x0080 }
        r3 = r3.toString();	 Catch:{ all -> 0x0080 }
        android.util.Log.e(r2, r3, r1);	 Catch:{ all -> 0x0080 }
        if (r0 == 0) goto L_0x00ba;
    L_0x00b6:
        r0.close();	 Catch:{ IOException -> 0x00b9 }
    L_0x00b9:
        return;
    L_0x00ba:
        return;
    L_0x00bb:
        if (r0 == 0) goto L_0x00c0;
    L_0x00bd:
        r0.close();	 Catch:{ IOException -> 0x00c0 }
    L_0x00c0:
        throw r1;
    L_0x00c1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActivityChooserModel.f():void");
    }

    final void m1774c() {
        int i;
        int i2 = 1;
        if (!this.f2097o || this.f2092j == null) {
            i = 0;
        } else {
            this.f2097o = false;
            this.f2087c.clear();
            List queryIntentActivities = this.f2088d.getPackageManager().queryIntentActivities(this.f2092j, 0);
            int size = queryIntentActivities.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f2087c.add(new ActivityResolveInfo((ResolveInfo) queryIntentActivities.get(i3)));
            }
            i = 1;
        }
        if (this.f2090f && this.f2096n && !TextUtils.isEmpty(this.f2089e)) {
            this.f2090f = false;
            this.f2095m = true;
            m1767f();
        } else {
            i2 = 0;
        }
        i |= i2;
        m1766e();
        if (i != 0) {
            m1765d();
            notifyChanged();
        }
    }
}
