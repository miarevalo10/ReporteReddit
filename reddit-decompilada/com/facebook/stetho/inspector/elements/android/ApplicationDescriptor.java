package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.app.Application;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.NodeType;
import com.facebook.stetho.inspector.elements.android.ActivityTracker.Listener;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

final class ApplicationDescriptor extends AbstractChainedDescriptor<Application> {
    private final ActivityTracker mActivityTracker = ActivityTracker.get();
    private final Map<Application, ElementContext> mElementToContextMap = Collections.synchronizedMap(new IdentityHashMap());

    private class ElementContext {
        private Application mElement;
        private final Listener mListener = new C11091();

        class C11091 implements Listener {
            public void onActivityAdded(Activity activity) {
            }

            public void onActivityRemoved(Activity activity) {
            }

            C11091() {
            }
        }

        public void hook(Application application) {
            this.mElement = application;
            ApplicationDescriptor.this.mActivityTracker.registerListener(this.mListener);
        }

        public void unhook() {
            ApplicationDescriptor.this.mActivityTracker.unregisterListener(this.mListener);
            this.mElement = null;
        }

        public List<WeakReference<Activity>> getActivitiesList() {
            return ApplicationDescriptor.this.mActivityTracker.getActivitiesView();
        }
    }

    ApplicationDescriptor() {
    }

    private ElementContext getContext(Application application) {
        return (ElementContext) this.mElementToContextMap.get(application);
    }

    protected final void onHook(Application application) {
        ElementContext elementContext = new ElementContext();
        elementContext.hook(application);
        this.mElementToContextMap.put(application, elementContext);
    }

    protected final void onUnhook(Application application) {
        ((ElementContext) this.mElementToContextMap.remove(application)).unhook();
    }

    protected final NodeType onGetNodeType(Application application) {
        return NodeType.ELEMENT_NODE;
    }

    protected final void onGetChildren(Application application, Accumulator<Object> accumulator) {
        application = getContext(application).getActivitiesList();
        for (int size = application.size() - 1; size >= 0; size--) {
            Activity activity = (Activity) ((WeakReference) application.get(size)).get();
            if (activity != null) {
                accumulator.store(activity);
            }
        }
    }
}
