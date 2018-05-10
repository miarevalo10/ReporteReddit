package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public class SingleModelLoader<TModel> extends ModelLoader<TModel, TModel> {
    public SingleModelLoader(Class<TModel> cls) {
        super(cls);
    }

    public TModel convertToData(FlowCursor flowCursor, TModel tModel, boolean z) {
        if (!z || flowCursor.moveToFirst()) {
            if (tModel == null) {
                tModel = getInstanceAdapter().newInstance();
            }
            getInstanceAdapter().loadFromCursor(flowCursor, tModel);
        }
        return tModel;
    }

    public TModel convertToData(FlowCursor flowCursor, TModel tModel) {
        return convertToData(flowCursor, tModel, true);
    }
}
