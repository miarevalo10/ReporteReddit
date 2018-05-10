package com.instabug.library.logging;

import android.content.ContentValues;
import com.instabug.library.C0645b;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.analytics.AnalyticsObserver;
import com.instabug.library.analytics.model.Api.Parameter;
import com.instabug.library.internal.storage.cache.p024a.C0683a;
import com.instabug.library.internal.storage.cache.p024a.C0685c;
import com.instabug.library.user.UserEvent;
import com.instabug.library.user.UserEventParam;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InstabugUserEventLogger {
    private static final long DELAY = 1;
    private static final int USER_EVENT_COUNT_LIMIT = 10000;
    private static volatile InstabugUserEventLogger instabugUserEventLogger;
    private ScheduledExecutorService insertionExecutor;
    private List<UserEvent> userEvents = new ArrayList();
    private ConcurrentHashMap<String, Integer> userEventsCount = new ConcurrentHashMap();

    class C07341 implements Runnable {
        final /* synthetic */ InstabugUserEventLogger f9797a;

        C07341(InstabugUserEventLogger instabugUserEventLogger) {
            this.f9797a = instabugUserEventLogger;
        }

        public void run() {
            for (Entry entry : this.f9797a.userEventsCount.entrySet()) {
                this.f9797a.incrementEventLoggingCount((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
            }
            this.f9797a.userEventsCount.clear();
            this.f9797a.insertionExecutor = null;
        }
    }

    private InstabugUserEventLogger() {
    }

    public static InstabugUserEventLogger getInstance() {
        if (instabugUserEventLogger == null) {
            instabugUserEventLogger = new InstabugUserEventLogger();
        }
        return instabugUserEventLogger;
    }

    public synchronized void logUserEvent(String str, UserEventParam... userEventParamArr) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("eventIdentifier").setType(String.class), new Parameter().setName("userEventParams").setType(UserEventParam.class));
        if (C0645b.m8104a().m8113b(Feature.USER_EVENTS) == State.ENABLED) {
            UserEvent date = new UserEvent().setEventIdentifier(str).setDate(InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds());
            for (UserEventParam addParam : userEventParamArr) {
                date.addParam(addParam);
            }
            if (this.userEvents.size() >= 10000) {
                this.userEvents.remove(0);
            }
            this.userEvents.add(date);
            Integer num = (Integer) this.userEventsCount.get(str);
            if (num != null) {
                this.userEventsCount.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                this.userEventsCount.put(str, Integer.valueOf(1));
            }
        }
        runInsertionHandler();
    }

    private void runInsertionHandler() {
        if (this.insertionExecutor == null) {
            Executors.newScheduledThreadPool(1).schedule(new C07341(this), DELAY, TimeUnit.SECONDS);
        }
    }

    public int getLoggingEventCount(String str) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("userEventIdentifier").setType(String.class));
        return getEventLoggingCount(str);
    }

    public List<UserEvent> getUserEvents() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return this.userEvents;
    }

    public void clearAll() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        this.userEvents.clear();
    }

    public void clearLoggingData() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        C0683a.m8190a();
        C0683a.m8192b().m8199b("user_events_logs");
    }

    private void incrementEventLoggingCount(String str, int i) {
        int eventLoggingCount = getEventLoggingCount(str);
        int i2 = eventLoggingCount > 0 ? 1 : 0;
        C0683a.m8190a();
        C0685c b = C0683a.m8192b();
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_identifier", str);
        contentValues.put("event_logging_count", Integer.valueOf(eventLoggingCount + i));
        if (i2 != 0) {
            i = new StringBuilder("update: ");
            i.append(b.f9619a.update("user_events_logs", contentValues, "event_identifier=?", new String[]{str}));
            InstabugSDKLogger.m8356d(this, i.toString());
        } else {
            str = new StringBuilder("insert: ");
            str.append(b.m8194a("user_events_logs", contentValues));
            InstabugSDKLogger.m8356d(this, str.toString());
        }
        b.m8198b();
    }

    private int getEventLoggingCount(String str) {
        C0683a.m8190a();
        C0685c b = C0683a.m8192b();
        String[] strArr = new String[1];
        int i = 0;
        strArr[0] = str;
        str = b.m8195a("user_events_logs", new String[]{"event_logging_count"}, "event_identifier =?", strArr);
        if (str.getCount() > 0) {
            str.moveToFirst();
            i = str.getInt(str.getColumnIndex("event_logging_count"));
        }
        str.close();
        b.m8198b();
        return i;
    }
}
