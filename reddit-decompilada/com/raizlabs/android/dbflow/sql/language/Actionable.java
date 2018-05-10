package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.structure.BaseModel.Action;

public interface Actionable {
    Action getPrimaryAction();
}
