package com.microsoft.thrifty.transport;

import java.io.Closeable;
import java.io.IOException;

public abstract class Transport implements Closeable {
    public abstract int mo2653a(byte[] bArr, int i, int i2) throws IOException;

    public abstract void mo2654a(byte[] bArr, int i) throws IOException;
}
