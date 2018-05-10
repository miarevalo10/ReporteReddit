package com.reddit.frontpage.sync;

import com.reddit.frontpage.sync.routine.SyncRoutine;
import java.util.HashMap;

public class SyncScheduleConfig {
    public final ScheduleMap f21052a;
    public final ScheduleMap f21053b;

    public static class Builder {
        public final ScheduleMap f21050a = new ScheduleMap();
        public final ScheduleMap f21051b = new ScheduleMap();

        private Builder m23261a(ScheduleMap scheduleMap, String str, SyncRoutine syncRoutine) {
            HashMap hashMap = (HashMap) scheduleMap.get(str);
            if (hashMap == null) {
                hashMap = new HashMap();
                scheduleMap.put(str, hashMap);
            }
            if (((HashMap) scheduleMap.get(str)).containsKey(Integer.valueOf(syncRoutine.f21058g)) != null) {
                StringBuilder stringBuilder = new StringBuilder("Routine ");
                stringBuilder.append(syncRoutine.f21058g);
                stringBuilder.append(" is already in the configuration for ");
                stringBuilder.append(str);
                throw new RuntimeException(stringBuilder.toString());
            }
            hashMap.put(Integer.valueOf(syncRoutine.f21058g), syncRoutine);
            return this;
        }

        public final Builder m23262a(String str, SyncRoutine syncRoutine) {
            return m23261a(this.f21050a, str, syncRoutine);
        }

        public final Builder m23263b(String str, SyncRoutine syncRoutine) {
            return m23261a(this.f21051b, str, syncRoutine);
        }
    }

    public static class ScheduleMap extends HashMap<String, HashMap<Integer, SyncRoutine>> {
    }

    private SyncScheduleConfig(ScheduleMap scheduleMap, ScheduleMap scheduleMap2) {
        this.f21052a = scheduleMap;
        this.f21053b = scheduleMap2;
    }
}
