package com.raizlabs.android.dbflow.runtime;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.Model;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Error;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Success;
import java.util.ArrayList;
import java.util.Collection;

public class DBBatchSaveQueue extends Thread {
    private static final int MODEL_SAVE_SIZE = 50;
    private static final int sMODEL_SAVE_CHECK_TIME = 30000;
    private DatabaseDefinition databaseDefinition;
    private Runnable emptyTransactionListener;
    private final Error errorCallback = new C14633();
    private Error errorListener;
    private boolean isQuitting = false;
    private long modelSaveCheckTime = 30000;
    private int modelSaveSize = 50;
    private final ProcessModel modelSaver = new C14611();
    private final ArrayList<Object> models;
    private final Success successCallback = new C14622();
    private Success successListener;

    class C14611 implements ProcessModel {
        C14611() {
        }

        public void processModel(Object obj, DatabaseWrapper databaseWrapper) {
            if ((obj instanceof Model) != null) {
                ((Model) obj).save();
                return;
            }
            if (obj != null) {
                FlowManager.getModelAdapter(obj.getClass()).save(obj);
            }
        }
    }

    class C14622 implements Success {
        C14622() {
        }

        public void onSuccess(Transaction transaction) {
            if (DBBatchSaveQueue.this.successListener != null) {
                DBBatchSaveQueue.this.successListener.onSuccess(transaction);
            }
        }
    }

    class C14633 implements Error {
        C14633() {
        }

        public void onError(Transaction transaction, Throwable th) {
            if (DBBatchSaveQueue.this.errorListener != null) {
                DBBatchSaveQueue.this.errorListener.onError(transaction, th);
            }
        }
    }

    DBBatchSaveQueue(DatabaseDefinition databaseDefinition) {
        super("DBBatchSaveQueue");
        this.databaseDefinition = databaseDefinition;
        this.models = new ArrayList();
    }

    public void setModelSaveSize(int i) {
        this.modelSaveSize = i;
    }

    public void setModelSaveCheckTime(long j) {
        this.modelSaveCheckTime = j;
    }

    public void setErrorListener(Error error) {
        this.errorListener = error;
    }

    public void setSuccessListener(Success success) {
        this.successListener = success;
    }

    public void setEmptyTransactionListener(Runnable runnable) {
        this.emptyTransactionListener = runnable;
    }

    public void run() {
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
        super.run();
        android.os.Looper.prepare();
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
    L_0x000b:
        r0 = r4.models;
        monitor-enter(r0);
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0065 }
        r2 = r4.models;	 Catch:{ all -> 0x0065 }
        r1.<init>(r2);	 Catch:{ all -> 0x0065 }
        r2 = r4.models;	 Catch:{ all -> 0x0065 }
        r2.clear();	 Catch:{ all -> 0x0065 }
        monitor-exit(r0);	 Catch:{ all -> 0x0065 }
        r0 = r1.size();
        if (r0 <= 0) goto L_0x004a;
    L_0x0021:
        r0 = r4.databaseDefinition;
        r2 = new com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction$Builder;
        r3 = r4.modelSaver;
        r2.<init>(r3);
        r1 = r2.addAll(r1);
        r1 = r1.build();
        r0 = r0.beginTransactionAsync(r1);
        r1 = r4.successCallback;
        r0 = r0.success(r1);
        r1 = r4.errorCallback;
        r0 = r0.error(r1);
        r0 = r0.build();
        r0.execute();
        goto L_0x0053;
    L_0x004a:
        r0 = r4.emptyTransactionListener;
        if (r0 == 0) goto L_0x0053;
    L_0x004e:
        r0 = r4.emptyTransactionListener;
        r0.run();
    L_0x0053:
        r0 = r4.modelSaveCheckTime;	 Catch:{ InterruptedException -> 0x0059 }
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0059 }
        goto L_0x0060;
    L_0x0059:
        r0 = com.raizlabs.android.dbflow.config.FlowLog.Level.I;
        r1 = "DBRequestQueue Batch interrupted to start saving";
        com.raizlabs.android.dbflow.config.FlowLog.log(r0, r1);
    L_0x0060:
        r0 = r4.isQuitting;
        if (r0 == 0) goto L_0x000b;
    L_0x0064:
        return;
    L_0x0065:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0065 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.raizlabs.android.dbflow.runtime.DBBatchSaveQueue.run():void");
    }

    public void purgeQueue() {
        interrupt();
    }

    public void add(Object obj) {
        synchronized (this.models) {
            this.models.add(obj);
            if (this.models.size() > this.modelSaveSize) {
                interrupt();
            }
        }
    }

    public void addAll(Collection<Object> collection) {
        synchronized (this.models) {
            this.models.addAll(collection);
            if (this.models.size() > this.modelSaveSize) {
                interrupt();
            }
        }
    }

    public void addAll2(Collection<?> collection) {
        synchronized (this.models) {
            this.models.addAll(collection);
            if (this.models.size() > this.modelSaveSize) {
                interrupt();
            }
        }
    }

    public void remove(Object obj) {
        synchronized (this.models) {
            this.models.remove(obj);
        }
    }

    public void removeAll(Collection<Object> collection) {
        synchronized (this.models) {
            this.models.removeAll(collection);
        }
    }

    public void removeAll2(Collection<?> collection) {
        synchronized (this.models) {
            this.models.removeAll(collection);
        }
    }

    public void quit() {
        this.isQuitting = true;
    }
}
