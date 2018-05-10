package com.facebook.stetho.inspector.elements.android;

import android.app.Application;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.NodeType;

final class AndroidDocumentRoot extends AbstractChainedDescriptor<AndroidDocumentRoot> {
    private final Application mApplication;

    protected final String onGetNodeName(AndroidDocumentRoot androidDocumentRoot) {
        return "root";
    }

    public AndroidDocumentRoot(Application application) {
        this.mApplication = (Application) Util.throwIfNull(application);
    }

    protected final NodeType onGetNodeType(AndroidDocumentRoot androidDocumentRoot) {
        return NodeType.DOCUMENT_NODE;
    }

    protected final void onGetChildren(AndroidDocumentRoot androidDocumentRoot, Accumulator<Object> accumulator) {
        accumulator.store(this.mApplication);
    }
}
