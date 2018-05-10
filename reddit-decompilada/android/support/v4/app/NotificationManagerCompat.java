package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.support.v4.app.INotificationSideChannel.Stub;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class NotificationManagerCompat {
    private static final Object f1165c = new Object();
    private static String f1166d;
    private static Set<String> f1167e = new HashSet();
    private static final Object f1168f = new Object();
    private static SideChannelManager f1169g;
    public final Context f1170a;
    public final NotificationManager f1171b = ((NotificationManager) this.f1170a.getSystemService("notification"));

    private static class ServiceConnectedEvent {
        final ComponentName f1153a;
        final IBinder f1154b;

        ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.f1153a = componentName;
            this.f1154b = iBinder;
        }
    }

    private static class SideChannelManager implements ServiceConnection, Callback {
        final Handler f1160a;
        private final Context f1161b;
        private final HandlerThread f1162c;
        private final Map<ComponentName, ListenerRecord> f1163d = new HashMap();
        private Set<String> f1164e = new HashSet();

        private static class ListenerRecord {
            public final ComponentName f1155a;
            public boolean f1156b = false;
            public INotificationSideChannel f1157c;
            public LinkedList<Task> f1158d = new LinkedList();
            public int f1159e = 0;

            public ListenerRecord(ComponentName componentName) {
                this.f1155a = componentName;
            }
        }

        public SideChannelManager(Context context) {
            this.f1161b = context;
            this.f1162c = new HandlerThread("NotificationManagerCompat");
            this.f1162c.start();
            this.f1160a = new Handler(this.f1162c.getLooper(), this);
        }

        public boolean handleMessage(Message message) {
            ListenerRecord listenerRecord;
            switch (message.what) {
                case 0:
                    Iterator it;
                    Task task = (Task) message.obj;
                    Set b = NotificationManagerCompat.m696b(this.f1161b);
                    if (!b.equals(this.f1164e)) {
                        StringBuilder stringBuilder;
                        this.f1164e = b;
                        List<ResolveInfo> queryIntentServices = this.f1161b.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                        Set<ComponentName> hashSet = new HashSet();
                        for (ResolveInfo resolveInfo : queryIntentServices) {
                            if (b.contains(resolveInfo.serviceInfo.packageName)) {
                                ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                                if (resolveInfo.serviceInfo.permission != null) {
                                    stringBuilder = new StringBuilder("Permission present on component ");
                                    stringBuilder.append(componentName);
                                    stringBuilder.append(", not adding listener record.");
                                    Log.w("NotifManCompat", stringBuilder.toString());
                                } else {
                                    hashSet.add(componentName);
                                }
                            }
                        }
                        for (ComponentName componentName2 : hashSet) {
                            if (!this.f1163d.containsKey(componentName2)) {
                                if (Log.isLoggable("NotifManCompat", 3)) {
                                    StringBuilder stringBuilder2 = new StringBuilder("Adding listener record for ");
                                    stringBuilder2.append(componentName2);
                                    Log.d("NotifManCompat", stringBuilder2.toString());
                                }
                                this.f1163d.put(componentName2, new ListenerRecord(componentName2));
                            }
                        }
                        it = this.f1163d.entrySet().iterator();
                        while (it.hasNext()) {
                            Entry entry = (Entry) it.next();
                            if (!hashSet.contains(entry.getKey())) {
                                if (Log.isLoggable("NotifManCompat", 3)) {
                                    stringBuilder = new StringBuilder("Removing listener record for ");
                                    stringBuilder.append(entry.getKey());
                                    Log.d("NotifManCompat", stringBuilder.toString());
                                }
                                m691a((ListenerRecord) entry.getValue());
                                it.remove();
                            }
                        }
                    }
                    for (ListenerRecord listenerRecord2 : this.f1163d.values()) {
                        listenerRecord2.f1158d.add(task);
                        m693c(listenerRecord2);
                    }
                    return true;
                case 1:
                    ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                    ComponentName componentName3 = serviceConnectedEvent.f1153a;
                    message = serviceConnectedEvent.f1154b;
                    ListenerRecord listenerRecord3 = (ListenerRecord) this.f1163d.get(componentName3);
                    if (listenerRecord3 != null) {
                        listenerRecord3.f1157c = Stub.m9962a(message);
                        listenerRecord3.f1159e = 0;
                        m693c(listenerRecord3);
                    }
                    return true;
                case 2:
                    listenerRecord = (ListenerRecord) this.f1163d.get((ComponentName) message.obj);
                    if (listenerRecord != null) {
                        m691a(listenerRecord);
                    }
                    return true;
                case 3:
                    listenerRecord = (ListenerRecord) this.f1163d.get((ComponentName) message.obj);
                    if (listenerRecord != null) {
                        m693c(listenerRecord);
                    }
                    return true;
                default:
                    return false;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder stringBuilder = new StringBuilder("Connected to service ");
                stringBuilder.append(componentName);
                Log.d("NotifManCompat", stringBuilder.toString());
            }
            this.f1160a.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder stringBuilder = new StringBuilder("Disconnected from service ");
                stringBuilder.append(componentName);
                Log.d("NotifManCompat", stringBuilder.toString());
            }
            this.f1160a.obtainMessage(2, componentName).sendToTarget();
        }

        private void m691a(ListenerRecord listenerRecord) {
            if (listenerRecord.f1156b) {
                this.f1161b.unbindService(this);
                listenerRecord.f1156b = false;
            }
            listenerRecord.f1157c = null;
        }

        private void m692b(ListenerRecord listenerRecord) {
            if (!this.f1160a.hasMessages(3, listenerRecord.f1155a)) {
                listenerRecord.f1159e++;
                if (listenerRecord.f1159e > 6) {
                    StringBuilder stringBuilder = new StringBuilder("Giving up on delivering ");
                    stringBuilder.append(listenerRecord.f1158d.size());
                    stringBuilder.append(" tasks to ");
                    stringBuilder.append(listenerRecord.f1155a);
                    stringBuilder.append(" after ");
                    stringBuilder.append(listenerRecord.f1159e);
                    stringBuilder.append(" retries");
                    Log.w("NotifManCompat", stringBuilder.toString());
                    listenerRecord.f1158d.clear();
                    return;
                }
                int i = 1000 * (1 << (listenerRecord.f1159e - 1));
                if (Log.isLoggable("NotifManCompat", 3)) {
                    StringBuilder stringBuilder2 = new StringBuilder("Scheduling retry for ");
                    stringBuilder2.append(i);
                    stringBuilder2.append(" ms");
                    Log.d("NotifManCompat", stringBuilder2.toString());
                }
                this.f1160a.sendMessageDelayed(this.f1160a.obtainMessage(3, listenerRecord.f1155a), (long) i);
            }
        }

        private void m693c(android.support.v4.app.NotificationManagerCompat.SideChannelManager.ListenerRecord r6) {
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
            r5 = this;
            r0 = "NotifManCompat";
            r1 = 3;
            r0 = android.util.Log.isLoggable(r0, r1);
            if (r0 == 0) goto L_0x0031;
        L_0x0009:
            r0 = "NotifManCompat";
            r2 = new java.lang.StringBuilder;
            r3 = "Processing component ";
            r2.<init>(r3);
            r3 = r6.f1155a;
            r2.append(r3);
            r3 = ", ";
            r2.append(r3);
            r3 = r6.f1158d;
            r3 = r3.size();
            r2.append(r3);
            r3 = " queued tasks";
            r2.append(r3);
            r2 = r2.toString();
            android.util.Log.d(r0, r2);
        L_0x0031:
            r0 = r6.f1158d;
            r0 = r0.isEmpty();
            if (r0 == 0) goto L_0x003a;
        L_0x0039:
            return;
        L_0x003a:
            r0 = r6.f1156b;
            if (r0 == 0) goto L_0x0040;
        L_0x003e:
            r0 = 1;
            goto L_0x007b;
        L_0x0040:
            r0 = new android.content.Intent;
            r2 = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
            r0.<init>(r2);
            r2 = r6.f1155a;
            r0 = r0.setComponent(r2);
            r2 = r5.f1161b;
            r3 = 33;
            r0 = r2.bindService(r0, r5, r3);
            r6.f1156b = r0;
            r0 = r6.f1156b;
            if (r0 == 0) goto L_0x005f;
        L_0x005b:
            r0 = 0;
            r6.f1159e = r0;
            goto L_0x0079;
        L_0x005f:
            r0 = "NotifManCompat";
            r2 = new java.lang.StringBuilder;
            r3 = "Unable to bind to listener ";
            r2.<init>(r3);
            r3 = r6.f1155a;
            r2.append(r3);
            r2 = r2.toString();
            android.util.Log.w(r0, r2);
            r0 = r5.f1161b;
            r0.unbindService(r5);
        L_0x0079:
            r0 = r6.f1156b;
        L_0x007b:
            if (r0 == 0) goto L_0x00f2;
        L_0x007d:
            r0 = r6.f1157c;
            if (r0 != 0) goto L_0x0082;
        L_0x0081:
            goto L_0x00f2;
        L_0x0082:
            r0 = r6.f1158d;
            r0 = r0.peek();
            r0 = (android.support.v4.app.NotificationManagerCompat.Task) r0;
            if (r0 == 0) goto L_0x00e6;
        L_0x008c:
            r2 = "NotifManCompat";	 Catch:{ DeadObjectException -> 0x00c9, RemoteException -> 0x00b2 }
            r2 = android.util.Log.isLoggable(r2, r1);	 Catch:{ DeadObjectException -> 0x00c9, RemoteException -> 0x00b2 }
            if (r2 == 0) goto L_0x00a7;	 Catch:{ DeadObjectException -> 0x00c9, RemoteException -> 0x00b2 }
        L_0x0094:
            r2 = "NotifManCompat";	 Catch:{ DeadObjectException -> 0x00c9, RemoteException -> 0x00b2 }
            r3 = new java.lang.StringBuilder;	 Catch:{ DeadObjectException -> 0x00c9, RemoteException -> 0x00b2 }
            r4 = "Sending task ";	 Catch:{ DeadObjectException -> 0x00c9, RemoteException -> 0x00b2 }
            r3.<init>(r4);	 Catch:{ DeadObjectException -> 0x00c9, RemoteException -> 0x00b2 }
            r3.append(r0);	 Catch:{ DeadObjectException -> 0x00c9, RemoteException -> 0x00b2 }
            r3 = r3.toString();	 Catch:{ DeadObjectException -> 0x00c9, RemoteException -> 0x00b2 }
            android.util.Log.d(r2, r3);	 Catch:{ DeadObjectException -> 0x00c9, RemoteException -> 0x00b2 }
        L_0x00a7:
            r2 = r6.f1157c;	 Catch:{ DeadObjectException -> 0x00c9, RemoteException -> 0x00b2 }
            r0.mo257a(r2);	 Catch:{ DeadObjectException -> 0x00c9, RemoteException -> 0x00b2 }
            r0 = r6.f1158d;	 Catch:{ DeadObjectException -> 0x00c9, RemoteException -> 0x00b2 }
            r0.remove();	 Catch:{ DeadObjectException -> 0x00c9, RemoteException -> 0x00b2 }
            goto L_0x0082;
        L_0x00b2:
            r0 = move-exception;
            r1 = "NotifManCompat";
            r2 = new java.lang.StringBuilder;
            r3 = "RemoteException communicating with ";
            r2.<init>(r3);
            r3 = r6.f1155a;
            r2.append(r3);
            r2 = r2.toString();
            android.util.Log.w(r1, r2, r0);
            goto L_0x00e6;
        L_0x00c9:
            r0 = "NotifManCompat";
            r0 = android.util.Log.isLoggable(r0, r1);
            if (r0 == 0) goto L_0x00e6;
        L_0x00d1:
            r0 = "NotifManCompat";
            r1 = new java.lang.StringBuilder;
            r2 = "Remote service has died: ";
            r1.<init>(r2);
            r2 = r6.f1155a;
            r1.append(r2);
            r1 = r1.toString();
            android.util.Log.d(r0, r1);
        L_0x00e6:
            r0 = r6.f1158d;
            r0 = r0.isEmpty();
            if (r0 != 0) goto L_0x00f1;
        L_0x00ee:
            r5.m692b(r6);
        L_0x00f1:
            return;
        L_0x00f2:
            r5.m692b(r6);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.NotificationManagerCompat.SideChannelManager.c(android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord):void");
        }
    }

    private interface Task {
        void mo257a(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    private static class CancelTask implements Task {
        final String f11390a;
        final int f11391b;
        final String f11392c;
        final boolean f11393d = null;

        public CancelTask(String str, int i, String str2) {
            this.f11390a = str;
            this.f11391b = i;
            this.f11392c = str2;
        }

        public final void mo257a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            if (this.f11393d) {
                iNotificationSideChannel.mo239a(this.f11390a);
            } else {
                iNotificationSideChannel.mo240a(this.f11390a, this.f11391b, this.f11392c);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.f11390a);
            stringBuilder.append(", id:");
            stringBuilder.append(this.f11391b);
            stringBuilder.append(", tag:");
            stringBuilder.append(this.f11392c);
            stringBuilder.append(", all:");
            stringBuilder.append(this.f11393d);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private static class NotifyTask implements Task {
        final String f11394a;
        final int f11395b = null;
        final String f11396c;
        final Notification f11397d;

        NotifyTask(String str, String str2, Notification notification) {
            this.f11394a = str;
            this.f11396c = str2;
            this.f11397d = notification;
        }

        public final void mo257a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.mo241a(this.f11394a, this.f11395b, this.f11396c, this.f11397d);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.f11394a);
            stringBuilder.append(", id:");
            stringBuilder.append(this.f11395b);
            stringBuilder.append(", tag:");
            stringBuilder.append(this.f11396c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static NotificationManagerCompat m695a(Context context) {
        return new NotificationManagerCompat(context);
    }

    private NotificationManagerCompat(Context context) {
        this.f1170a = context;
    }

    public final boolean m699a() {
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
        r11 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 24;
        if (r0 < r1) goto L_0x000d;
    L_0x0006:
        r0 = r11.f1171b;
        r0 = r0.areNotificationsEnabled();
        return r0;
    L_0x000d:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 19;
        r2 = 1;
        if (r0 < r1) goto L_0x0082;
    L_0x0014:
        r0 = r11.f1170a;
        r1 = "appops";
        r0 = r0.getSystemService(r1);
        r0 = (android.app.AppOpsManager) r0;
        r1 = r11.f1170a;
        r1 = r1.getApplicationInfo();
        r3 = r11.f1170a;
        r3 = r3.getApplicationContext();
        r3 = r3.getPackageName();
        r1 = r1.uid;
        r4 = android.app.AppOpsManager.class;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r4 = r4.getName();	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r4 = java.lang.Class.forName(r4);	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r5 = "checkOpNoThrow";	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r6 = 3;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r7 = new java.lang.Class[r6];	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r8 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r9 = 0;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r7[r9] = r8;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r8 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r7[r2] = r8;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r8 = java.lang.String.class;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r10 = 2;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r7[r10] = r8;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r5 = r4.getMethod(r5, r7);	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r7 = "OP_POST_NOTIFICATION";	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r4 = r4.getDeclaredField(r7);	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r7 = java.lang.Integer.class;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r4 = r4.get(r7);	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r4 = (java.lang.Integer) r4;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r4 = r4.intValue();	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r6 = new java.lang.Object[r6];	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r6[r9] = r4;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r6[r2] = r1;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r6[r10] = r3;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r0 = r5.invoke(r0, r6);	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r0 = (java.lang.Integer) r0;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r0 = r0.intValue();	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        if (r0 != 0) goto L_0x0080;
    L_0x007f:
        return r2;
    L_0x0080:
        return r9;
    L_0x0081:
        return r2;
    L_0x0082:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.NotificationManagerCompat.a():boolean");
    }

    public static Set<String> m696b(Context context) {
        context = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f1165c) {
            if (context != null) {
                if (!context.equals(f1166d)) {
                    String[] split = context.split(":");
                    Set hashSet = new HashSet(split.length);
                    for (String unflattenFromString : split) {
                        ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                        if (unflattenFromString2 != null) {
                            hashSet.add(unflattenFromString2.getPackageName());
                        }
                    }
                    f1167e = hashSet;
                    f1166d = context;
                }
            }
        }
        return f1167e;
    }

    public final void m697a(Task task) {
        synchronized (f1168f) {
            if (f1169g == null) {
                f1169g = new SideChannelManager(this.f1170a.getApplicationContext());
            }
            f1169g.f1160a.obtainMessage(0, task).sendToTarget();
        }
    }

    public final void m698a(String str, Notification notification) {
        Bundle a = NotificationCompat.m686a(notification);
        int i = (a == null || !a.getBoolean("android.support.useSideChannel")) ? 0 : 1;
        if (i != 0) {
            m697a(new NotifyTask(this.f1170a.getPackageName(), str, notification));
            this.f1171b.cancel(str, 0);
            return;
        }
        this.f1171b.notify(str, 0, notification);
    }
}
