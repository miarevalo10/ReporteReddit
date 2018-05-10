package com.instabug.bug.screenshot.viewhierarchy.utilities;

import com.instabug.bug.screenshot.viewhierarchy.C0484c.C0483a;
import com.instabug.library.core.eventbus.EventBus;

public class ViewHierarchyInspectorEventBus extends EventBus<C0483a> {
    private static ViewHierarchyInspectorEventBus instance;

    public static ViewHierarchyInspectorEventBus getInstance() {
        if (instance == null) {
            instance = new ViewHierarchyInspectorEventBus();
        }
        return instance;
    }
}
