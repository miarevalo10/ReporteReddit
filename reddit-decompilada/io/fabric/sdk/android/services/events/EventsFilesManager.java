package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class EventsFilesManager<T> {
    public static final int MAX_BYTE_SIZE_PER_FILE = 8000;
    public static final int MAX_FILES_IN_BATCH = 1;
    public static final int MAX_FILES_TO_KEEP = 100;
    public static final String ROLL_OVER_FILE_NAME_SEPARATOR = "_";
    protected final Context context;
    protected final CurrentTimeProvider currentTimeProvider;
    private final int defaultMaxFilesToKeep;
    protected final EventsStorage eventStorage;
    protected volatile long lastRollOverTime;
    protected final List<EventsStorageListener> rollOverListeners = new CopyOnWriteArrayList();
    protected final EventTransform<T> transform;

    class C21201 implements Comparator<FileWithTimestamp> {
        final /* synthetic */ EventsFilesManager f24831a;

        C21201(EventsFilesManager eventsFilesManager) {
            this.f24831a = eventsFilesManager;
        }

        public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return (int) (((FileWithTimestamp) obj).f24833b - ((FileWithTimestamp) obj2).f24833b);
        }
    }

    static class FileWithTimestamp {
        final File f24832a;
        final long f24833b;

        public FileWithTimestamp(File file, long j) {
            this.f24832a = file;
            this.f24833b = j;
        }
    }

    public abstract String generateUniqueRollOverFileName();

    public int getMaxByteSizePerFile() {
        return MAX_BYTE_SIZE_PER_FILE;
    }

    public EventsFilesManager(Context context, EventTransform<T> eventTransform, CurrentTimeProvider currentTimeProvider, EventsStorage eventsStorage, int i) throws IOException {
        this.context = context.getApplicationContext();
        this.transform = eventTransform;
        this.eventStorage = eventsStorage;
        this.currentTimeProvider = currentTimeProvider;
        this.lastRollOverTime = this.currentTimeProvider.mo5580a();
        this.defaultMaxFilesToKeep = i;
    }

    public void writeEvent(T t) throws IOException {
        byte[] toBytes = this.transform.toBytes(t);
        rollFileOverIfNeeded(toBytes.length);
        this.eventStorage.mo5593a(toBytes);
    }

    public void registerRollOverListener(EventsStorageListener eventsStorageListener) {
        if (eventsStorageListener != null) {
            this.rollOverListeners.add(eventsStorageListener);
        }
    }

    public boolean rollFileOver() throws IOException {
        String str;
        boolean z = true;
        if (this.eventStorage.mo5595b()) {
            str = null;
            z = false;
        } else {
            str = generateUniqueRollOverFileName();
            this.eventStorage.mo5591a(str);
            CommonUtils.m26305c(this.context, String.format(Locale.US, "generated new file %s", new Object[]{str}));
            this.lastRollOverTime = this.currentTimeProvider.mo5580a();
        }
        triggerRollOverOnListeners(str);
        return z;
    }

    private void rollFileOverIfNeeded(int i) throws IOException {
        if (!this.eventStorage.mo5594a(i, getMaxByteSizePerFile())) {
            CommonUtils.m26305c(this.context, String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.eventStorage.mo5590a()), Integer.valueOf(i), Integer.valueOf(getMaxByteSizePerFile())}));
            rollFileOver();
        }
    }

    public int getMaxFilesToKeep() {
        return this.defaultMaxFilesToKeep;
    }

    public long getLastRollOverTime() {
        return this.lastRollOverTime;
    }

    private void triggerRollOverOnListeners(java.lang.String r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = r3.rollOverListeners;
        r0 = r0.iterator();
    L_0x0006:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x001e;
    L_0x000c:
        r1 = r0.next();
        r1 = (io.fabric.sdk.android.services.events.EventsStorageListener) r1;
        r1.onRollOver(r4);	 Catch:{ Exception -> 0x0016 }
        goto L_0x0006;
    L_0x0016:
        r1 = r3.context;
        r2 = "One of the roll over listeners threw an exception";
        io.fabric.sdk.android.services.common.CommonUtils.m26302b(r1, r2);
        goto L_0x0006;
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.events.EventsFilesManager.triggerRollOverOnListeners(java.lang.String):void");
    }

    public List<File> getBatchOfFilesToSend() {
        return this.eventStorage.mo5596c();
    }

    public void deleteSentFiles(List<File> list) {
        this.eventStorage.mo5592a((List) list);
    }

    public void deleteAllEventsFiles() {
        this.eventStorage.mo5592a(this.eventStorage.mo5597d());
        this.eventStorage.mo5598e();
    }

    public void deleteOldestInRollOverIfOverMax() {
        List<File> d = this.eventStorage.mo5597d();
        int maxFilesToKeep = getMaxFilesToKeep();
        if (d.size() > maxFilesToKeep) {
            int size = d.size() - maxFilesToKeep;
            CommonUtils.m26292a(this.context, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(d.size()), Integer.valueOf(maxFilesToKeep), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new C21201(this));
            for (File file : d) {
                treeSet.add(new FileWithTimestamp(file, parseCreationTimestampFromFileName(file.getName())));
            }
            List d2 = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                d2.add(((FileWithTimestamp) it.next()).f24832a);
                if (d2.size() == size) {
                    break;
                }
            }
            this.eventStorage.mo5592a(d2);
        }
    }

    public long parseCreationTimestampFromFileName(java.lang.String r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = "_";
        r5 = r5.split(r0);
        r0 = 0;
        r2 = 3;
        r3 = r5.length;
        if (r3 == r2) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r2 = 2;
        r5 = r5[r2];	 Catch:{ NumberFormatException -> 0x0019 }
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ NumberFormatException -> 0x0019 }
        r2 = r5.longValue();	 Catch:{ NumberFormatException -> 0x0019 }
        return r2;
    L_0x0019:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.events.EventsFilesManager.parseCreationTimestampFromFileName(java.lang.String):long");
    }
}
