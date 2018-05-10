package com.raizlabs.android.dbflow.list;

import android.database.Cursor;
import java.io.Closeable;
import java.io.IOException;

public interface IFlowCursorIterator<TModel> extends Closeable {
    void close() throws IOException;

    Cursor cursor();

    long getCount();

    TModel getItem(long j);

    FlowCursorIterator<TModel> iterator();

    FlowCursorIterator<TModel> iterator(int i, long j);
}
