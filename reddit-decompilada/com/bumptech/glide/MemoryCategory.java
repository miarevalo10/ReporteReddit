package com.bumptech.glide;

public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);
    
    private final float f3231d;

    private MemoryCategory(float f) {
        this.f3231d = f;
    }
}
