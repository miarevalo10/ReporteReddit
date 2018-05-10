package com.twitter.sdk.android.core;

import io.fabric.sdk.android.services.events.EventsFilesManager;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreStrategy;
import io.fabric.sdk.android.services.persistence.SerializationStrategy;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class PersistedSessionManager<T extends Session> implements SessionManager<T> {
    private final PreferenceStore f30679a;
    private final SerializationStrategy<T> f30680b;
    private final ConcurrentHashMap<Long, T> f30681c;
    private final ConcurrentHashMap<Long, PreferenceStoreStrategy<T>> f30682d;
    private final PreferenceStoreStrategy<T> f30683e;
    private final AtomicReference<T> f30684f;
    private final String f30685g;
    private volatile boolean f30686h;

    public PersistedSessionManager(PreferenceStore preferenceStore, SerializationStrategy<T> serializationStrategy, String str, String str2) {
        this(preferenceStore, serializationStrategy, new ConcurrentHashMap(1), new ConcurrentHashMap(1), new PreferenceStoreStrategy(preferenceStore, serializationStrategy, str), str2);
    }

    private PersistedSessionManager(PreferenceStore preferenceStore, SerializationStrategy<T> serializationStrategy, ConcurrentHashMap<Long, T> concurrentHashMap, ConcurrentHashMap<Long, PreferenceStoreStrategy<T>> concurrentHashMap2, PreferenceStoreStrategy<T> preferenceStoreStrategy, String str) {
        this.f30686h = true;
        this.f30679a = preferenceStore;
        this.f30680b = serializationStrategy;
        this.f30681c = concurrentHashMap;
        this.f30682d = concurrentHashMap2;
        this.f30683e = preferenceStoreStrategy;
        this.f30684f = new AtomicReference();
        this.f30685g = str;
    }

    private void m31710d() {
        if (this.f30686h) {
            m31711e();
        }
    }

    private synchronized void m31711e() {
        if (this.f30686h) {
            PreferenceStoreStrategy preferenceStoreStrategy = this.f30683e;
            Session session = (Session) preferenceStoreStrategy.f24861b.mo5461a(preferenceStoreStrategy.f24860a.mo5606a().getString(preferenceStoreStrategy.f24862c, null));
            if (session != null) {
                m31709a(session.f23923b, session, false);
            }
            for (Entry entry : this.f30679a.mo5606a().getAll().entrySet()) {
                if (((String) entry.getKey()).startsWith(this.f30685g)) {
                    Session session2 = (Session) this.f30680b.mo5461a((String) entry.getValue());
                    if (session2 != null) {
                        m31709a(session2.f23923b, session2, false);
                    }
                }
            }
            this.f30686h = false;
        }
    }

    public final T mo5463a() {
        m31710d();
        return (Session) this.f30684f.get();
    }

    public final void mo5465a(T t) {
        m31710d();
        m31709a(t.f23923b, t, true);
    }

    public final T mo5464a(long j) {
        m31710d();
        return (Session) this.f30681c.get(Long.valueOf(j));
    }

    public final Map<Long, T> mo5466b() {
        m31710d();
        return Collections.unmodifiableMap(this.f30681c);
    }

    private void m31709a(long j, T t, boolean z) {
        this.f30681c.put(Long.valueOf(j), t);
        PreferenceStoreStrategy preferenceStoreStrategy = (PreferenceStoreStrategy) this.f30682d.get(Long.valueOf(j));
        if (preferenceStoreStrategy == null) {
            PreferenceStore preferenceStore = this.f30679a;
            SerializationStrategy serializationStrategy = this.f30680b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f30685g);
            stringBuilder.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
            stringBuilder.append(j);
            preferenceStoreStrategy = new PreferenceStoreStrategy(preferenceStore, serializationStrategy, stringBuilder.toString());
            this.f30682d.putIfAbsent(Long.valueOf(j), preferenceStoreStrategy);
        }
        preferenceStoreStrategy.m26431a(t);
        Session session = (Session) this.f30684f.get();
        if (!(session == null || session.f23923b == j)) {
            if (!z) {
                return;
            }
        }
        synchronized (this) {
            this.f30684f.compareAndSet(session, t);
            this.f30683e.m26431a(t);
        }
    }

    public final void mo5467c() {
        m31710d();
        if (this.f30684f.get() != null && ((Session) this.f30684f.get()).f23923b == 0) {
            synchronized (this) {
                this.f30684f.set(null);
                this.f30683e.m26430a();
            }
        }
        this.f30681c.remove(Long.valueOf(0));
        PreferenceStoreStrategy preferenceStoreStrategy = (PreferenceStoreStrategy) this.f30682d.remove(Long.valueOf(0));
        if (preferenceStoreStrategy != null) {
            preferenceStoreStrategy.m26430a();
        }
    }
}
