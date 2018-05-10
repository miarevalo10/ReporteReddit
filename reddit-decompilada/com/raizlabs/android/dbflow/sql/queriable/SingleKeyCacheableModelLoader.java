package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public class SingleKeyCacheableModelLoader<TModel> extends CacheableModelLoader<TModel> {
    public SingleKeyCacheableModelLoader(Class<TModel> cls) {
        super(cls);
    }

    public TModel convertToData(FlowCursor flowCursor, TModel tModel, boolean z) {
        if (z) {
            if (!flowCursor.moveToFirst()) {
                return null;
            }
        }
        z = getModelAdapter().getCachingColumnValueFromCursor(flowCursor);
        TModel tModel2 = getModelCache().get(z);
        if (tModel2 == null) {
            if (tModel == null) {
                tModel = getModelAdapter().newInstance();
            }
            tModel2 = tModel;
            getModelAdapter().loadFromCursor(flowCursor, tModel2);
            getModelCache().addModel(z, tModel2);
        } else {
            getModelAdapter().reloadRelationships(tModel2, flowCursor);
        }
        return tModel2;
    }
}
