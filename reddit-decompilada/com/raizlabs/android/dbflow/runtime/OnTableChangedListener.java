package com.raizlabs.android.dbflow.runtime;

import com.raizlabs.android.dbflow.structure.BaseModel.Action;

public interface OnTableChangedListener {
    void onTableChanged(Class<?> cls, Action action);
}
