package com.raizlabs.android.dbflow.runtime;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.SqlUtils;
import com.raizlabs.android.dbflow.structure.BaseModel.Action;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

public class ContentResolverNotifier implements ModelNotifier {
    private final String contentAuthority;

    public static class FlowContentTableNotifierRegister implements TableNotifierRegister {
        private final FlowContentObserver flowContentObserver;
        private final OnTableChangedListener internalContentChangeListener = new C14601();
        private OnTableChangedListener tableChangedListener;

        class C14601 implements OnTableChangedListener {
            C14601() {
            }

            public void onTableChanged(Class<?> cls, Action action) {
                if (FlowContentTableNotifierRegister.this.tableChangedListener != null) {
                    FlowContentTableNotifierRegister.this.tableChangedListener.onTableChanged(cls, action);
                }
            }
        }

        public FlowContentTableNotifierRegister(String str) {
            this.flowContentObserver = new FlowContentObserver(str);
            this.flowContentObserver.addOnTableChangedListener(this.internalContentChangeListener);
        }

        public <T> void register(Class<T> cls) {
            this.flowContentObserver.registerForContentChanges(FlowManager.getContext(), (Class) cls);
        }

        public <T> void unregister(Class<T> cls) {
            this.flowContentObserver.unregisterForContentChanges(FlowManager.getContext());
        }

        public void unregisterAll() {
            this.flowContentObserver.removeTableChangedListener(this.internalContentChangeListener);
            this.tableChangedListener = null;
        }

        public void setListener(OnTableChangedListener onTableChangedListener) {
            this.tableChangedListener = onTableChangedListener;
        }

        public boolean isSubscribed() {
            return !this.flowContentObserver.isSubscribed();
        }
    }

    public ContentResolverNotifier(String str) {
        this.contentAuthority = str;
    }

    public <T> void notifyModelChanged(T t, ModelAdapter<T> modelAdapter, Action action) {
        if (FlowContentObserver.shouldNotify()) {
            FlowManager.getContext().getContentResolver().notifyChange(SqlUtils.getNotificationUri(this.contentAuthority, modelAdapter.getModelClass(), action, modelAdapter.getPrimaryConditionClause(t).getConditions()), null, true);
        }
    }

    public <T> void notifyTableChanged(Class<T> cls, Action action) {
        if (FlowContentObserver.shouldNotify()) {
            FlowManager.getContext().getContentResolver().notifyChange(SqlUtils.getNotificationUri(this.contentAuthority, (Class) cls, action, null), null, true);
        }
    }

    public TableNotifierRegister newRegister() {
        return new FlowContentTableNotifierRegister(this.contentAuthority);
    }
}
