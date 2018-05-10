package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

public class CycleDetectingLockFactory {
    private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, LockGraphNode>> f8575a;
    private static final Logger f8576b = Logger.getLogger(CycleDetectingLockFactory.class.getName());
    private static final ThreadLocal<ArrayList<LockGraphNode>> f8577c = new C04521();

    static class C04521 extends ThreadLocal<ArrayList<LockGraphNode>> {
        C04521() {
        }

        protected final /* synthetic */ Object initialValue() {
            return Lists.m7160a(3);
        }
    }

    private static class ExampleStackTrace extends IllegalStateException {
        static final StackTraceElement[] f8573a = new StackTraceElement[0];
        static final ImmutableSet<String> f8574b = ImmutableSet.m14746a(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), LockGraphNode.class.getName());
    }

    private static class LockGraphNode {
    }

    public static final class PotentialDeadlockException extends ExampleStackTrace {
        private final ExampleStackTrace f14970c;

        public final String getMessage() {
            StringBuilder stringBuilder = new StringBuilder(super.getMessage());
            for (Throwable th = this.f14970c; th != null; th = th.getCause()) {
                stringBuilder.append(", ");
                stringBuilder.append(th.getMessage());
            }
            return stringBuilder.toString();
        }
    }

    static {
        ConcurrentMap a;
        MapMaker mapMaker = new MapMaker();
        Strength strength = Strength.f8463b;
        Preconditions.m6923b(mapMaker.f8444d == null, "Key strength was already set to %s", mapMaker.f8444d);
        mapMaker.f8444d = (Strength) Preconditions.m6908a((Object) strength);
        if (strength != Strength.f8462a) {
            mapMaker.f8441a = true;
        }
        if (mapMaker.f8441a) {
            a = MapMakerInternalMap.m7213a(mapMaker);
        } else {
            a = new ConcurrentHashMap(mapMaker.m7167a(), 0.75f, mapMaker.m7168b());
        }
        f8575a = a;
    }
}
