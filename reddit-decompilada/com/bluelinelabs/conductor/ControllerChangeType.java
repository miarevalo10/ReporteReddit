package com.bluelinelabs.conductor;

public enum ControllerChangeType {
    PUSH_ENTER(true, true),
    PUSH_EXIT(true, false),
    POP_ENTER(false, true),
    POP_EXIT(false, false);
    
    public boolean f3132e;
    public boolean f3133f;

    private ControllerChangeType(boolean z, boolean z2) {
        this.f3132e = z;
        this.f3133f = z2;
    }
}
