package com.raizlabs.android.dbflow.runtime;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.BaseModel.Action;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

public class NotifyDistributor implements ModelNotifier {
    private static NotifyDistributor distributor;

    public static NotifyDistributor get() {
        if (distributor == null) {
            distributor = new NotifyDistributor();
        }
        return distributor;
    }

    public TableNotifierRegister newRegister() {
        throw new RuntimeException("Cannot create a register from the distributor class");
    }

    public <TModel> void notifyModelChanged(TModel tModel, ModelAdapter<TModel> modelAdapter, Action action) {
        FlowManager.getModelNotifierForTable(modelAdapter.getModelClass()).notifyModelChanged(tModel, modelAdapter, action);
    }

    public <TModel> void notifyTableChanged(Class<TModel> cls, Action action) {
        FlowManager.getModelNotifierForTable(cls).notifyTableChanged(cls, action);
    }
}
