package com.vincentbrison.openlibraries.android.dualcache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class DualCacheLock {
    final ReadWriteLock f24312a = new ReentrantReadWriteLock();
    private final ConcurrentMap<String, Lock> f24313b = new ConcurrentHashMap();

    DualCacheLock() {
    }

    final void m26007a(String str) {
        this.f24312a.readLock().lock();
        m26005c(str).lock();
    }

    final void m26008b(String str) {
        m26005c(str).unlock();
        this.f24312a.readLock().unlock();
    }

    final void m26006a() {
        this.f24312a.writeLock().unlock();
    }

    private Lock m26005c(String str) {
        if (!this.f24313b.containsKey(str)) {
            this.f24313b.putIfAbsent(str, new ReentrantLock());
        }
        return (Lock) this.f24313b.get(str);
    }
}
