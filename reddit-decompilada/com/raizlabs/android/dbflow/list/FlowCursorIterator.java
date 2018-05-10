package com.raizlabs.android.dbflow.list;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;

public class FlowCursorIterator<TModel> implements AutoCloseable, ListIterator<TModel> {
    private long count;
    private final IFlowCursorIterator<TModel> cursorList;
    private long reverseIndex;
    private long startingCount;

    public FlowCursorIterator(IFlowCursorIterator<TModel> iFlowCursorIterator) {
        this(iFlowCursorIterator, 0, iFlowCursorIterator.getCount());
    }

    public FlowCursorIterator(IFlowCursorIterator<TModel> iFlowCursorIterator, int i) {
        this(iFlowCursorIterator, i, iFlowCursorIterator.getCount() - ((long) i));
    }

    public FlowCursorIterator(IFlowCursorIterator<TModel> iFlowCursorIterator, int i, long j) {
        this.cursorList = iFlowCursorIterator;
        this.count = j;
        j = iFlowCursorIterator.cursor();
        if (j != null) {
            if (this.count > ((long) (j.getCount() - i))) {
                this.count = (long) (j.getCount() - i);
            }
            j.moveToPosition(i - 1);
            this.startingCount = iFlowCursorIterator.getCount();
            this.reverseIndex = this.count;
            this.reverseIndex -= (long) i;
            if (this.reverseIndex < null) {
                this.reverseIndex = 0;
            }
        }
    }

    public void close() throws Exception {
        this.cursorList.close();
    }

    public void add(TModel tModel) {
        throw new UnsupportedOperationException("Cursor Iterator: Cannot add a model in the iterator");
    }

    public boolean hasNext() {
        checkSizes();
        return this.reverseIndex > 0;
    }

    public boolean hasPrevious() {
        checkSizes();
        return this.reverseIndex < this.count;
    }

    public TModel next() {
        checkSizes();
        TModel item = this.cursorList.getItem(this.count - this.reverseIndex);
        this.reverseIndex--;
        return item;
    }

    public int nextIndex() {
        return (int) (this.reverseIndex + 1);
    }

    public TModel previous() {
        checkSizes();
        TModel item = this.cursorList.getItem(this.count - this.reverseIndex);
        this.reverseIndex++;
        return item;
    }

    public int previousIndex() {
        return (int) this.reverseIndex;
    }

    public void remove() {
        throw new UnsupportedOperationException("Cursor Iterator: cannot remove from an active Iterator ");
    }

    public void set(TModel tModel) {
        throw new UnsupportedOperationException("Cursor Iterator: cannot set on an active Iterator ");
    }

    private void checkSizes() {
        if (this.startingCount != this.cursorList.getCount()) {
            throw new ConcurrentModificationException("Cannot change Cursor data during iteration.");
        }
    }
}
