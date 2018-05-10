package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

public final class LocalBroadcastManager {
    private static final Object f1202f = new Object();
    private static LocalBroadcastManager f1203g;
    private final Context f1204a;
    private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> f1205b = new HashMap();
    private final HashMap<String, ArrayList<ReceiverRecord>> f1206c = new HashMap();
    private final ArrayList<BroadcastRecord> f1207d = new ArrayList();
    private final Handler f1208e;

    private static final class BroadcastRecord {
        final Intent f1196a;
        final ArrayList<ReceiverRecord> f1197b;

        BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.f1196a = intent;
            this.f1197b = arrayList;
        }
    }

    private static final class ReceiverRecord {
        final IntentFilter f1198a;
        final BroadcastReceiver f1199b;
        boolean f1200c;
        boolean f1201d;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f1198a = intentFilter;
            this.f1199b = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append("Receiver{");
            stringBuilder.append(this.f1199b);
            stringBuilder.append(" filter=");
            stringBuilder.append(this.f1198a);
            if (this.f1201d) {
                stringBuilder.append(" DEAD");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static LocalBroadcastManager m744a(Context context) {
        synchronized (f1202f) {
            if (f1203g == null) {
                f1203g = new LocalBroadcastManager(context.getApplicationContext());
            }
            context = f1203g;
        }
        return context;
    }

    private LocalBroadcastManager(Context context) {
        this.f1204a = context;
        this.f1208e = new Handler(this, context.getMainLooper()) {
            final /* synthetic */ LocalBroadcastManager f1195a;

            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.m745a(this.f1195a);
                }
            }
        };
    }

    public final void m747a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f1205b) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.f1205b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f1205b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(receiverRecord);
            for (broadcastReceiver = null; broadcastReceiver < intentFilter.countActions(); broadcastReceiver++) {
                String action = intentFilter.getAction(broadcastReceiver);
                ArrayList arrayList2 = (ArrayList) this.f1206c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.f1206c.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    public final void m746a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f1205b) {
            ArrayList arrayList = (ArrayList) this.f1205b.remove(broadcastReceiver);
            if (arrayList == null) {
                return;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ReceiverRecord receiverRecord = (ReceiverRecord) arrayList.get(size);
                receiverRecord.f1201d = true;
                for (int i = 0; i < receiverRecord.f1198a.countActions(); i++) {
                    String action = receiverRecord.f1198a.getAction(i);
                    ArrayList arrayList2 = (ArrayList) this.f1206c.get(action);
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            ReceiverRecord receiverRecord2 = (ReceiverRecord) arrayList2.get(size2);
                            if (receiverRecord2.f1199b == broadcastReceiver) {
                                receiverRecord2.f1201d = true;
                                arrayList2.remove(size2);
                            }
                        }
                        if (arrayList2.size() <= 0) {
                            this.f1206c.remove(action);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m748a(android.content.Intent r24) {
        /*
        r23 = this;
        r1 = r23;
        r2 = r24;
        r3 = r1.f1205b;
        monitor-enter(r3);
        r11 = r24.getAction();	 Catch:{ all -> 0x0164 }
        r4 = r1.f1204a;	 Catch:{ all -> 0x0164 }
        r4 = r4.getContentResolver();	 Catch:{ all -> 0x0164 }
        r12 = r2.resolveTypeIfNeeded(r4);	 Catch:{ all -> 0x0164 }
        r13 = r24.getData();	 Catch:{ all -> 0x0164 }
        r14 = r24.getScheme();	 Catch:{ all -> 0x0164 }
        r15 = r24.getCategories();	 Catch:{ all -> 0x0164 }
        r4 = r24.getFlags();	 Catch:{ all -> 0x0164 }
        r4 = r4 & 8;
        if (r4 == 0) goto L_0x002c;
    L_0x0029:
        r16 = 1;
        goto L_0x002e;
    L_0x002c:
        r16 = 0;
    L_0x002e:
        if (r16 == 0) goto L_0x0053;
    L_0x0030:
        r4 = "LocalBroadcastManager";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0164 }
        r6 = "Resolving type ";
        r5.<init>(r6);	 Catch:{ all -> 0x0164 }
        r5.append(r12);	 Catch:{ all -> 0x0164 }
        r6 = " scheme ";
        r5.append(r6);	 Catch:{ all -> 0x0164 }
        r5.append(r14);	 Catch:{ all -> 0x0164 }
        r6 = " of intent ";
        r5.append(r6);	 Catch:{ all -> 0x0164 }
        r5.append(r2);	 Catch:{ all -> 0x0164 }
        r5 = r5.toString();	 Catch:{ all -> 0x0164 }
        android.util.Log.v(r4, r5);	 Catch:{ all -> 0x0164 }
    L_0x0053:
        r4 = r1.f1206c;	 Catch:{ all -> 0x0164 }
        r5 = r24.getAction();	 Catch:{ all -> 0x0164 }
        r4 = r4.get(r5);	 Catch:{ all -> 0x0164 }
        r8 = r4;
        r8 = (java.util.ArrayList) r8;	 Catch:{ all -> 0x0164 }
        if (r8 == 0) goto L_0x0161;
    L_0x0062:
        if (r16 == 0) goto L_0x0077;
    L_0x0064:
        r4 = "LocalBroadcastManager";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0164 }
        r6 = "Action list: ";
        r5.<init>(r6);	 Catch:{ all -> 0x0164 }
        r5.append(r8);	 Catch:{ all -> 0x0164 }
        r5 = r5.toString();	 Catch:{ all -> 0x0164 }
        android.util.Log.v(r4, r5);	 Catch:{ all -> 0x0164 }
    L_0x0077:
        r4 = 0;
        r6 = r4;
        r7 = 0;
    L_0x007a:
        r4 = r8.size();	 Catch:{ all -> 0x0164 }
        if (r7 >= r4) goto L_0x0131;
    L_0x0080:
        r4 = r8.get(r7);	 Catch:{ all -> 0x0164 }
        r5 = r4;
        r5 = (android.support.v4.content.LocalBroadcastManager.ReceiverRecord) r5;	 Catch:{ all -> 0x0164 }
        if (r16 == 0) goto L_0x009e;
    L_0x0089:
        r4 = "LocalBroadcastManager";
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0164 }
        r10 = "Matching against filter ";
        r9.<init>(r10);	 Catch:{ all -> 0x0164 }
        r10 = r5.f1198a;	 Catch:{ all -> 0x0164 }
        r9.append(r10);	 Catch:{ all -> 0x0164 }
        r9 = r9.toString();	 Catch:{ all -> 0x0164 }
        android.util.Log.v(r4, r9);	 Catch:{ all -> 0x0164 }
    L_0x009e:
        r4 = r5.f1200c;	 Catch:{ all -> 0x0164 }
        if (r4 == 0) goto L_0x00b9;
    L_0x00a2:
        if (r16 == 0) goto L_0x00ab;
    L_0x00a4:
        r4 = "LocalBroadcastManager";
        r5 = "  Filter's target already added";
        android.util.Log.v(r4, r5);	 Catch:{ all -> 0x0164 }
    L_0x00ab:
        r18 = r7;
        r19 = r8;
        r17 = r11;
        r20 = r12;
        r21 = r13;
        r13 = 1;
        r11 = r6;
        goto L_0x0124;
    L_0x00b9:
        r4 = r5.f1198a;	 Catch:{ all -> 0x0164 }
        r10 = "LocalBroadcastManager";
        r9 = r5;
        r5 = r11;
        r17 = r11;
        r11 = r6;
        r6 = r12;
        r18 = r7;
        r7 = r14;
        r19 = r8;
        r8 = r13;
        r20 = r12;
        r21 = r13;
        r13 = 1;
        r12 = r9;
        r9 = r15;
        r4 = r4.match(r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x0164 }
        if (r4 < 0) goto L_0x00fe;
    L_0x00d6:
        if (r16 == 0) goto L_0x00ef;
    L_0x00d8:
        r5 = "LocalBroadcastManager";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0164 }
        r7 = "  Filter matched!  match=0x";
        r6.<init>(r7);	 Catch:{ all -> 0x0164 }
        r4 = java.lang.Integer.toHexString(r4);	 Catch:{ all -> 0x0164 }
        r6.append(r4);	 Catch:{ all -> 0x0164 }
        r4 = r6.toString();	 Catch:{ all -> 0x0164 }
        android.util.Log.v(r5, r4);	 Catch:{ all -> 0x0164 }
    L_0x00ef:
        if (r11 != 0) goto L_0x00f7;
    L_0x00f1:
        r6 = new java.util.ArrayList;	 Catch:{ all -> 0x0164 }
        r6.<init>();	 Catch:{ all -> 0x0164 }
        goto L_0x00f8;
    L_0x00f7:
        r6 = r11;
    L_0x00f8:
        r6.add(r12);	 Catch:{ all -> 0x0164 }
        r12.f1200c = r13;	 Catch:{ all -> 0x0164 }
        goto L_0x0125;
    L_0x00fe:
        if (r16 == 0) goto L_0x0124;
    L_0x0100:
        switch(r4) {
            case -4: goto L_0x010f;
            case -3: goto L_0x010c;
            case -2: goto L_0x0109;
            case -1: goto L_0x0106;
            default: goto L_0x0103;
        };	 Catch:{ all -> 0x0164 }
    L_0x0103:
        r4 = "unknown reason";
        goto L_0x0111;
    L_0x0106:
        r4 = "type";
        goto L_0x0111;
    L_0x0109:
        r4 = "data";
        goto L_0x0111;
    L_0x010c:
        r4 = "action";
        goto L_0x0111;
    L_0x010f:
        r4 = "category";
    L_0x0111:
        r5 = "LocalBroadcastManager";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0164 }
        r7 = "  Filter did not match: ";
        r6.<init>(r7);	 Catch:{ all -> 0x0164 }
        r6.append(r4);	 Catch:{ all -> 0x0164 }
        r4 = r6.toString();	 Catch:{ all -> 0x0164 }
        android.util.Log.v(r5, r4);	 Catch:{ all -> 0x0164 }
    L_0x0124:
        r6 = r11;
    L_0x0125:
        r7 = r18 + 1;
        r11 = r17;
        r8 = r19;
        r12 = r20;
        r13 = r21;
        goto L_0x007a;
    L_0x0131:
        r11 = r6;
        r13 = 1;
        if (r11 == 0) goto L_0x0161;
    L_0x0135:
        r4 = 0;
    L_0x0136:
        r5 = r11.size();	 Catch:{ all -> 0x0164 }
        if (r4 >= r5) goto L_0x0148;
    L_0x013c:
        r5 = r11.get(r4);	 Catch:{ all -> 0x0164 }
        r5 = (android.support.v4.content.LocalBroadcastManager.ReceiverRecord) r5;	 Catch:{ all -> 0x0164 }
        r6 = 0;
        r5.f1200c = r6;	 Catch:{ all -> 0x0164 }
        r4 = r4 + 1;
        goto L_0x0136;
    L_0x0148:
        r4 = r1.f1207d;	 Catch:{ all -> 0x0164 }
        r5 = new android.support.v4.content.LocalBroadcastManager$BroadcastRecord;	 Catch:{ all -> 0x0164 }
        r5.<init>(r2, r11);	 Catch:{ all -> 0x0164 }
        r4.add(r5);	 Catch:{ all -> 0x0164 }
        r2 = r1.f1208e;	 Catch:{ all -> 0x0164 }
        r2 = r2.hasMessages(r13);	 Catch:{ all -> 0x0164 }
        if (r2 != 0) goto L_0x015f;
    L_0x015a:
        r2 = r1.f1208e;	 Catch:{ all -> 0x0164 }
        r2.sendEmptyMessage(r13);	 Catch:{ all -> 0x0164 }
    L_0x015f:
        monitor-exit(r3);	 Catch:{ all -> 0x0164 }
        return r13;
    L_0x0161:
        r6 = 0;
        monitor-exit(r3);	 Catch:{ all -> 0x0164 }
        return r6;
    L_0x0164:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r3);	 Catch:{ all -> 0x0164 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.LocalBroadcastManager.a(android.content.Intent):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m745a(android.support.v4.content.LocalBroadcastManager r9) {
        /*
    L_0x0000:
        r0 = r9.f1205b;
        monitor-enter(r0);
        r1 = r9.f1207d;	 Catch:{ all -> 0x0045 }
        r1 = r1.size();	 Catch:{ all -> 0x0045 }
        if (r1 > 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r0);	 Catch:{ all -> 0x0045 }
        return;
    L_0x000d:
        r1 = new android.support.v4.content.LocalBroadcastManager.BroadcastRecord[r1];	 Catch:{ all -> 0x0045 }
        r2 = r9.f1207d;	 Catch:{ all -> 0x0045 }
        r2.toArray(r1);	 Catch:{ all -> 0x0045 }
        r2 = r9.f1207d;	 Catch:{ all -> 0x0045 }
        r2.clear();	 Catch:{ all -> 0x0045 }
        monitor-exit(r0);	 Catch:{ all -> 0x0045 }
        r0 = 0;
        r2 = r0;
    L_0x001c:
        r3 = r1.length;
        if (r2 >= r3) goto L_0x0000;
    L_0x001f:
        r3 = r1[r2];
        r4 = r3.f1197b;
        r4 = r4.size();
        r5 = r0;
    L_0x0028:
        if (r5 >= r4) goto L_0x0042;
    L_0x002a:
        r6 = r3.f1197b;
        r6 = r6.get(r5);
        r6 = (android.support.v4.content.LocalBroadcastManager.ReceiverRecord) r6;
        r7 = r6.f1201d;
        if (r7 != 0) goto L_0x003f;
    L_0x0036:
        r6 = r6.f1199b;
        r7 = r9.f1204a;
        r8 = r3.f1196a;
        r6.onReceive(r7, r8);
    L_0x003f:
        r5 = r5 + 1;
        goto L_0x0028;
    L_0x0042:
        r2 = r2 + 1;
        goto L_0x001c;
    L_0x0045:
        r9 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0045 }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.LocalBroadcastManager.a(android.support.v4.content.LocalBroadcastManager):void");
    }
}
