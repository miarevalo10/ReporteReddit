package com.raizlabs.android.dbflow.sql.saveable;

import java.util.Collection;

public class ListModelSaver<TModel> {
    private final ModelSaver<TModel> modelSaver;

    public ListModelSaver(ModelSaver<TModel> modelSaver) {
        this.modelSaver = modelSaver;
    }

    public synchronized void saveAll(Collection<TModel> collection) {
        saveAll(collection, this.modelSaver.getWritableDatabase());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void saveAll(java.util.Collection<TModel> r5, com.raizlabs.android.dbflow.structure.database.DatabaseWrapper r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r5.isEmpty();	 Catch:{ all -> 0x0041 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r4);
        return;
    L_0x0009:
        r0 = r4.modelSaver;	 Catch:{ all -> 0x0041 }
        r0 = r0.getModelAdapter();	 Catch:{ all -> 0x0041 }
        r0 = r0.getInsertStatement(r6);	 Catch:{ all -> 0x0041 }
        r1 = r4.modelSaver;	 Catch:{ all -> 0x0041 }
        r1 = r1.getModelAdapter();	 Catch:{ all -> 0x0041 }
        r1 = r1.getUpdateStatement(r6);	 Catch:{ all -> 0x0041 }
        r5 = r5.iterator();	 Catch:{ all -> 0x0039 }
    L_0x0021:
        r2 = r5.hasNext();	 Catch:{ all -> 0x0039 }
        if (r2 == 0) goto L_0x0031;
    L_0x0027:
        r2 = r5.next();	 Catch:{ all -> 0x0039 }
        r3 = r4.modelSaver;	 Catch:{ all -> 0x0039 }
        r3.save(r2, r6, r0, r1);	 Catch:{ all -> 0x0039 }
        goto L_0x0021;
    L_0x0031:
        r0.close();	 Catch:{ all -> 0x0041 }
        r1.close();	 Catch:{ all -> 0x0041 }
        monitor-exit(r4);
        return;
    L_0x0039:
        r5 = move-exception;
        r0.close();	 Catch:{ all -> 0x0041 }
        r1.close();	 Catch:{ all -> 0x0041 }
        throw r5;	 Catch:{ all -> 0x0041 }
    L_0x0041:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.raizlabs.android.dbflow.sql.saveable.ListModelSaver.saveAll(java.util.Collection, com.raizlabs.android.dbflow.structure.database.DatabaseWrapper):void");
    }

    public synchronized void insertAll(Collection<TModel> collection) {
        insertAll(collection, this.modelSaver.getWritableDatabase());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void insertAll(java.util.Collection<TModel> r4, com.raizlabs.android.dbflow.structure.database.DatabaseWrapper r5) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r4.isEmpty();	 Catch:{ all -> 0x0031 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r3);
        return;
    L_0x0009:
        r0 = r3.modelSaver;	 Catch:{ all -> 0x0031 }
        r0 = r0.getModelAdapter();	 Catch:{ all -> 0x0031 }
        r0 = r0.getInsertStatement(r5);	 Catch:{ all -> 0x0031 }
        r4 = r4.iterator();	 Catch:{ all -> 0x002c }
    L_0x0017:
        r1 = r4.hasNext();	 Catch:{ all -> 0x002c }
        if (r1 == 0) goto L_0x0027;
    L_0x001d:
        r1 = r4.next();	 Catch:{ all -> 0x002c }
        r2 = r3.modelSaver;	 Catch:{ all -> 0x002c }
        r2.insert(r1, r0, r5);	 Catch:{ all -> 0x002c }
        goto L_0x0017;
    L_0x0027:
        r0.close();	 Catch:{ all -> 0x0031 }
        monitor-exit(r3);
        return;
    L_0x002c:
        r4 = move-exception;
        r0.close();	 Catch:{ all -> 0x0031 }
        throw r4;	 Catch:{ all -> 0x0031 }
    L_0x0031:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.raizlabs.android.dbflow.sql.saveable.ListModelSaver.insertAll(java.util.Collection, com.raizlabs.android.dbflow.structure.database.DatabaseWrapper):void");
    }

    public synchronized void updateAll(Collection<TModel> collection) {
        updateAll(collection, this.modelSaver.getWritableDatabase());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateAll(java.util.Collection<TModel> r4, com.raizlabs.android.dbflow.structure.database.DatabaseWrapper r5) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r4.isEmpty();	 Catch:{ all -> 0x0031 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r3);
        return;
    L_0x0009:
        r0 = r3.modelSaver;	 Catch:{ all -> 0x0031 }
        r0 = r0.getModelAdapter();	 Catch:{ all -> 0x0031 }
        r0 = r0.getUpdateStatement(r5);	 Catch:{ all -> 0x0031 }
        r4 = r4.iterator();	 Catch:{ all -> 0x002c }
    L_0x0017:
        r1 = r4.hasNext();	 Catch:{ all -> 0x002c }
        if (r1 == 0) goto L_0x0027;
    L_0x001d:
        r1 = r4.next();	 Catch:{ all -> 0x002c }
        r2 = r3.modelSaver;	 Catch:{ all -> 0x002c }
        r2.update(r1, r5, r0);	 Catch:{ all -> 0x002c }
        goto L_0x0017;
    L_0x0027:
        r0.close();	 Catch:{ all -> 0x0031 }
        monitor-exit(r3);
        return;
    L_0x002c:
        r4 = move-exception;
        r0.close();	 Catch:{ all -> 0x0031 }
        throw r4;	 Catch:{ all -> 0x0031 }
    L_0x0031:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.raizlabs.android.dbflow.sql.saveable.ListModelSaver.updateAll(java.util.Collection, com.raizlabs.android.dbflow.structure.database.DatabaseWrapper):void");
    }

    public synchronized void deleteAll(Collection<TModel> collection) {
        deleteAll(collection, this.modelSaver.getWritableDatabase());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void deleteAll(java.util.Collection<TModel> r4, com.raizlabs.android.dbflow.structure.database.DatabaseWrapper r5) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r4.isEmpty();	 Catch:{ all -> 0x0031 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r3);
        return;
    L_0x0009:
        r0 = r3.modelSaver;	 Catch:{ all -> 0x0031 }
        r0 = r0.getModelAdapter();	 Catch:{ all -> 0x0031 }
        r0 = r0.getDeleteStatement(r5);	 Catch:{ all -> 0x0031 }
        r4 = r4.iterator();	 Catch:{ all -> 0x002c }
    L_0x0017:
        r1 = r4.hasNext();	 Catch:{ all -> 0x002c }
        if (r1 == 0) goto L_0x0027;
    L_0x001d:
        r1 = r4.next();	 Catch:{ all -> 0x002c }
        r2 = r3.modelSaver;	 Catch:{ all -> 0x002c }
        r2.delete(r1, r0, r5);	 Catch:{ all -> 0x002c }
        goto L_0x0017;
    L_0x0027:
        r0.close();	 Catch:{ all -> 0x0031 }
        monitor-exit(r3);
        return;
    L_0x002c:
        r4 = move-exception;
        r0.close();	 Catch:{ all -> 0x0031 }
        throw r4;	 Catch:{ all -> 0x0031 }
    L_0x0031:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.raizlabs.android.dbflow.sql.saveable.ListModelSaver.deleteAll(java.util.Collection, com.raizlabs.android.dbflow.structure.database.DatabaseWrapper):void");
    }

    public ModelSaver<TModel> getModelSaver() {
        return this.modelSaver;
    }
}
