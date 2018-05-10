package com.raizlabs.android.dbflow.structure.provider;

import android.net.Uri;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;

public interface ModelProvider {
    Uri getDeleteUri();

    Uri getInsertUri();

    Uri getQueryUri();

    Uri getUpdateUri();

    void load();

    void load(OperatorGroup operatorGroup, String str, String... strArr);
}
