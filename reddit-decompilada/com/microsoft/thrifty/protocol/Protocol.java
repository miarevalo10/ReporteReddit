package com.microsoft.thrifty.protocol;

import com.microsoft.thrifty.transport.Transport;
import java.io.Closeable;
import java.io.IOException;

public abstract class Protocol implements Closeable {
    protected final Transport f10043a;

    public abstract void mo2634a() throws IOException;

    public abstract void mo2635a(byte b, int i) throws IOException;

    public abstract void mo2636a(double d) throws IOException;

    public abstract void mo2637a(int i) throws IOException;

    public abstract void mo2638a(int i, byte b) throws IOException;

    public abstract void mo2639a(long j) throws IOException;

    public abstract void mo2640a(String str) throws IOException;

    public abstract void mo2641a(boolean z) throws IOException;

    public abstract FieldMetadata mo2642b() throws IOException;

    public abstract MapMetadata mo2643c() throws IOException;

    public abstract ListMetadata mo2644d() throws IOException;

    public abstract SetMetadata mo2645e() throws IOException;

    public abstract boolean mo2646f() throws IOException;

    public abstract byte mo2647g() throws IOException;

    public abstract short mo2648h() throws IOException;

    public abstract int mo2649i() throws IOException;

    public abstract long mo2650j() throws IOException;

    public abstract double mo2651k() throws IOException;

    public abstract String mo2652l() throws IOException;

    protected Protocol(Transport transport) {
        if (transport == null) {
            throw new NullPointerException("transport");
        }
        this.f10043a = transport;
    }

    public void close() throws IOException {
        this.f10043a.close();
    }
}
