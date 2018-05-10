package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class DiskCacheWriteLocker {
    final Map<String, WriteLock> f3453a = new HashMap();
    final WriteLockPool f3454b = new WriteLockPool();

    private static class WriteLock {
        final Lock f3450a = new ReentrantLock();
        int f3451b;

        WriteLock() {
        }
    }

    private static class WriteLockPool {
        final Queue<WriteLock> f3452a = new ArrayDeque();

        WriteLockPool() {
        }

        final WriteLock m2968a() {
            WriteLock writeLock;
            synchronized (this.f3452a) {
                writeLock = (WriteLock) this.f3452a.poll();
            }
            return writeLock == null ? new WriteLock() : writeLock;
        }
    }

    DiskCacheWriteLocker() {
    }

    final void m2969a(String str) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = (WriteLock) Preconditions.m3217a(this.f3453a.get(str));
            if (writeLock.f3451b <= 0) {
                StringBuilder stringBuilder = new StringBuilder("Cannot release a lock that is not held, safeKey: ");
                stringBuilder.append(str);
                stringBuilder.append(", interestedThreads: ");
                stringBuilder.append(writeLock.f3451b);
                throw new IllegalStateException(stringBuilder.toString());
            }
            writeLock.f3451b--;
            if (writeLock.f3451b == 0) {
                WriteLock writeLock2 = (WriteLock) this.f3453a.remove(str);
                if (writeLock2.equals(writeLock)) {
                    str = this.f3454b;
                    synchronized (str.f3452a) {
                        if (str.f3452a.size() < 10) {
                            str.f3452a.offer(writeLock2);
                        }
                    }
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder("Removed the wrong lock, expected to remove: ");
                    stringBuilder2.append(writeLock);
                    stringBuilder2.append(", but actually removed: ");
                    stringBuilder2.append(writeLock2);
                    stringBuilder2.append(", safeKey: ");
                    stringBuilder2.append(str);
                    throw new IllegalStateException(stringBuilder2.toString());
                }
            }
        }
        writeLock.f3450a.unlock();
    }
}
