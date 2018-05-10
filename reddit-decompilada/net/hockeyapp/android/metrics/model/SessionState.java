package net.hockeyapp.android.metrics.model;

public enum SessionState {
    START(0),
    END(1);
    
    private final int value;

    private SessionState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
