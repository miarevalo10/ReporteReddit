package com.raizlabs.android.dbflow.runtime;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.SqlUtils;
import com.raizlabs.android.dbflow.sql.language.NameAlias.Builder;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.structure.BaseModel.Action;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class FlowContentObserver extends ContentObserver {
    private static final AtomicInteger REGISTERED_COUNT = new AtomicInteger(0);
    private static boolean forceNotify = false;
    private final String contentAuthority;
    protected boolean isInTransaction = false;
    private final Set<OnModelStateChangedListener> modelChangeListeners = new CopyOnWriteArraySet();
    private final Set<Uri> notificationUris = new HashSet();
    private boolean notifyAllUris = false;
    private final Set<OnTableChangedListener> onTableChangedListeners = new CopyOnWriteArraySet();
    private final Map<String, Class<?>> registeredTables = new HashMap();
    private final Set<Uri> tableUris = new HashSet();

    public interface OnModelStateChangedListener {
        void onModelStateChanged(Class<?> cls, Action action, SQLOperator[] sQLOperatorArr);
    }

    public interface ContentChangeListener extends OnModelStateChangedListener, OnTableChangedListener {
    }

    public static boolean shouldNotify() {
        if (!forceNotify) {
            if (REGISTERED_COUNT.get() <= 0) {
                return false;
            }
        }
        return true;
    }

    public static void clearRegisteredObserverCount() {
        REGISTERED_COUNT.set(0);
    }

    public static void setShouldForceNotify(boolean z) {
        forceNotify = z;
    }

    public FlowContentObserver(String str) {
        super(null);
        this.contentAuthority = str;
    }

    public FlowContentObserver(Handler handler, String str) {
        super(handler);
        this.contentAuthority = str;
    }

    public void setNotifyAllUris(boolean z) {
        this.notifyAllUris = z;
    }

    public void beginTransaction() {
        if (!this.isInTransaction) {
            this.isInTransaction = true;
        }
    }

    public void endTransactionAndNotify() {
        if (this.isInTransaction) {
            this.isInTransaction = false;
            if (VERSION.SDK_INT < 16) {
                onChange(true);
                return;
            }
            synchronized (this.notificationUris) {
                for (Uri onChange : this.notificationUris) {
                    onChange(true, onChange, true);
                }
                this.notificationUris.clear();
            }
            synchronized (this.tableUris) {
                for (Uri uri : this.tableUris) {
                    for (OnTableChangedListener onTableChanged : this.onTableChangedListeners) {
                        onTableChanged.onTableChanged((Class) this.registeredTables.get(uri.getAuthority()), Action.valueOf(uri.getFragment()));
                    }
                }
                this.tableUris.clear();
            }
        }
    }

    public void addModelChangeListener(OnModelStateChangedListener onModelStateChangedListener) {
        this.modelChangeListeners.add(onModelStateChangedListener);
    }

    public void removeModelChangeListener(OnModelStateChangedListener onModelStateChangedListener) {
        this.modelChangeListeners.remove(onModelStateChangedListener);
    }

    public void addOnTableChangedListener(OnTableChangedListener onTableChangedListener) {
        this.onTableChangedListeners.add(onTableChangedListener);
    }

    public void removeTableChangedListener(OnTableChangedListener onTableChangedListener) {
        this.onTableChangedListeners.remove(onTableChangedListener);
    }

    public void addContentChangeListener(ContentChangeListener contentChangeListener) {
        this.modelChangeListeners.add(contentChangeListener);
        this.onTableChangedListeners.add(contentChangeListener);
    }

    public void removeContentChangeListener(ContentChangeListener contentChangeListener) {
        this.modelChangeListeners.remove(contentChangeListener);
        this.onTableChangedListeners.remove(contentChangeListener);
    }

    public void registerForContentChanges(Context context, Class<?> cls) {
        registerForContentChanges(context.getContentResolver(), (Class) cls);
    }

    public void registerForContentChanges(ContentResolver contentResolver, Class<?> cls) {
        contentResolver.registerContentObserver(SqlUtils.getNotificationUri(this.contentAuthority, cls, null), true, this);
        REGISTERED_COUNT.incrementAndGet();
        if (this.registeredTables.containsValue(cls) == null) {
            this.registeredTables.put(FlowManager.getTableName(cls), cls);
        }
    }

    public void unregisterForContentChanges(Context context) {
        context.getContentResolver().unregisterContentObserver(this);
        REGISTERED_COUNT.decrementAndGet();
        this.registeredTables.clear();
    }

    public boolean isSubscribed() {
        return !this.registeredTables.isEmpty();
    }

    public void onChange(boolean z) {
        for (OnModelStateChangedListener onModelStateChanged : this.modelChangeListeners) {
            onModelStateChanged.onModelStateChanged(null, Action.CHANGE, new SQLOperator[0]);
        }
        for (OnTableChangedListener onTableChanged : this.onTableChangedListeners) {
            onTableChanged.onTableChanged(null, Action.CHANGE);
        }
    }

    @TargetApi(16)
    public void onChange(boolean z, Uri uri) {
        onChange(z, uri, false);
    }

    @TargetApi(16)
    private void onChange(boolean z, Uri uri, boolean z2) {
        z = uri.getFragment();
        String queryParameter = uri.getQueryParameter(SqlUtils.TABLE_QUERY_PARAM);
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        SQLOperator[] sQLOperatorArr = new SQLOperator[(queryParameterNames.size() - 1)];
        if (!queryParameterNames.isEmpty()) {
            int i = 0;
            for (String str : queryParameterNames) {
                if (!SqlUtils.TABLE_QUERY_PARAM.equals(str)) {
                    sQLOperatorArr[i] = Operator.op(new Builder(Uri.decode(str)).build()).eq(Uri.decode(uri.getQueryParameter(str)));
                    i++;
                }
            }
        }
        Class cls = (Class) this.registeredTables.get(queryParameter);
        z = Action.valueOf(z);
        if (this.isInTransaction) {
            if (!this.notifyAllUris) {
                z = Action.CHANGE;
                uri = SqlUtils.getNotificationUri(this.contentAuthority, cls, z);
            }
            synchronized (this.notificationUris) {
                this.notificationUris.add(uri);
            }
            synchronized (this.tableUris) {
                this.tableUris.add(SqlUtils.getNotificationUri(this.contentAuthority, cls, z));
            }
            return;
        }
        for (OnModelStateChangedListener onModelStateChanged : this.modelChangeListeners) {
            onModelStateChanged.onModelStateChanged(cls, z, sQLOperatorArr);
        }
        if (!z2) {
            for (OnTableChangedListener onTableChanged : this.onTableChangedListeners) {
                onTableChanged.onTableChanged(cls, z);
            }
        }
    }
}
