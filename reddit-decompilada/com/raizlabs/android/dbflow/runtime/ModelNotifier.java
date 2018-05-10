package com.raizlabs.android.dbflow.runtime;

import com.raizlabs.android.dbflow.structure.BaseModel.Action;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

public interface ModelNotifier {
    TableNotifierRegister newRegister();

    <T> void notifyModelChanged(T t, ModelAdapter<T> modelAdapter, Action action);

    <T> void notifyTableChanged(Class<T> cls, Action action);
}
