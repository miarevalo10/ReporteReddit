package de.greenrobot.event;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class EventBus {
    private static final EventBusBuilder DEFAULT_BUILDER = new EventBusBuilder();
    public static String TAG = "Event";
    static volatile EventBus defaultInstance;
    private static final Map<Class<?>, List<Class<?>>> eventTypesCache = new HashMap();
    private final AsyncPoster asyncPoster;
    private final BackgroundPoster backgroundPoster;
    private final ThreadLocal<PostingThreadState> currentPostingThreadState;
    private final boolean eventInheritance;
    private final ExecutorService executorService;
    private final boolean logNoSubscriberMessages;
    private final boolean logSubscriberExceptions;
    private final HandlerPoster mainThreadPoster;
    private final boolean sendNoSubscriberEvent;
    private final boolean sendSubscriberExceptionEvent;
    private final Map<Class<?>, Object> stickyEvents;
    private final SubscriberMethodFinder subscriberMethodFinder;
    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;
    private final boolean throwSubscriberException;
    private final Map<Object, List<Class<?>>> typesBySubscriber;

    class C20971 extends ThreadLocal<PostingThreadState> {
        final /* synthetic */ EventBus f24328a;

        C20971(EventBus eventBus) {
            this.f24328a = eventBus;
        }

        protected /* synthetic */ Object initialValue() {
            return new PostingThreadState();
        }
    }

    static final class PostingThreadState {
        final List<Object> f24330a = new ArrayList();
        boolean f24331b;
        boolean f24332c;
        Subscription f24333d;
        Object f24334e;
        boolean f24335f;

        PostingThreadState() {
        }
    }

    public static EventBus getDefault() {
        if (defaultInstance == null) {
            synchronized (EventBus.class) {
                if (defaultInstance == null) {
                    defaultInstance = new EventBus();
                }
            }
        }
        return defaultInstance;
    }

    public static EventBusBuilder builder() {
        return new EventBusBuilder();
    }

    public static void clearCaches() {
        SubscriberMethodFinder.m26020a();
        eventTypesCache.clear();
    }

    public EventBus() {
        this(DEFAULT_BUILDER);
    }

    EventBus(EventBusBuilder eventBusBuilder) {
        this.currentPostingThreadState = new C20971(this);
        this.subscriptionsByEventType = new HashMap();
        this.typesBySubscriber = new HashMap();
        this.stickyEvents = new ConcurrentHashMap();
        this.mainThreadPoster = new HandlerPoster(this, Looper.getMainLooper());
        this.backgroundPoster = new BackgroundPoster(this);
        this.asyncPoster = new AsyncPoster(this);
        this.subscriberMethodFinder = new SubscriberMethodFinder(eventBusBuilder.f24344h);
        this.logSubscriberExceptions = eventBusBuilder.f24337a;
        this.logNoSubscriberMessages = eventBusBuilder.f24338b;
        this.sendSubscriberExceptionEvent = eventBusBuilder.f24339c;
        this.sendNoSubscriberEvent = eventBusBuilder.f24340d;
        this.throwSubscriberException = eventBusBuilder.f24341e;
        this.eventInheritance = eventBusBuilder.f24342f;
        this.executorService = eventBusBuilder.f24343g;
    }

    public void register(Object obj) {
        register(obj, false, 0);
    }

    public void register(Object obj, int i) {
        register(obj, false, i);
    }

    public void registerSticky(Object obj) {
        register(obj, true, 0);
    }

    public void registerSticky(Object obj, int i) {
        register(obj, true, i);
    }

    private synchronized void register(Object obj, boolean z, int i) {
        for (SubscriberMethod subscribe : this.subscriberMethodFinder.m26021a(obj.getClass())) {
            subscribe(obj, subscribe, z, i);
        }
    }

    private void subscribe(Object obj, SubscriberMethod subscriberMethod, boolean z, int i) {
        Class cls = subscriberMethod.f24363c;
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.subscriptionsByEventType.get(cls);
        Subscription subscription = new Subscription(obj, subscriberMethod, i);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.subscriptionsByEventType.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(subscription) != null) {
            z = new StringBuilder("Subscriber ");
            z.append(obj.getClass());
            z.append(" already registered to event ");
            z.append(cls);
            throw new EventBusException(z.toString());
        }
        subscriberMethod = copyOnWriteArrayList.size();
        i = 0;
        int i2 = 0;
        while (i2 <= subscriberMethod) {
            if (i2 != subscriberMethod) {
                if (subscription.f24369c <= ((Subscription) copyOnWriteArrayList.get(i2)).f24369c) {
                    i2++;
                }
            }
            copyOnWriteArrayList.add(i2, subscription);
            break;
        }
        subscriberMethod = (List) this.typesBySubscriber.get(obj);
        if (subscriberMethod == null) {
            subscriberMethod = new ArrayList();
            this.typesBySubscriber.put(obj, subscriberMethod);
        }
        subscriberMethod.add(cls);
        if (z) {
            synchronized (this.stickyEvents) {
                subscriberMethod = this.stickyEvents.get(cls);
            }
            if (subscriberMethod != null) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    i = 1;
                }
                postToSubscription(subscription, subscriberMethod, i);
            }
        }
    }

    public synchronized boolean isRegistered(Object obj) {
        return this.typesBySubscriber.containsKey(obj);
    }

    private void unubscribeByEventType(Object obj, Class<?> cls) {
        List list = (List) this.subscriptionsByEventType.get(cls);
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                Subscription subscription = (Subscription) list.get(i);
                if (subscription.f24367a == obj) {
                    subscription.f24370d = false;
                    list.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    public synchronized void unregister(Object obj) {
        List<Class> list = (List) this.typesBySubscriber.get(obj);
        if (list != null) {
            for (Class unubscribeByEventType : list) {
                unubscribeByEventType(obj, unubscribeByEventType);
            }
            this.typesBySubscriber.remove(obj);
            return;
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("Subscriber to unregister was not registered before: ");
        stringBuilder.append(obj.getClass());
        Log.w(str, stringBuilder.toString());
    }

    public void post(Object obj) {
        PostingThreadState postingThreadState = (PostingThreadState) this.currentPostingThreadState.get();
        List list = postingThreadState.f24330a;
        list.add(obj);
        if (postingThreadState.f24331b == null) {
            postingThreadState.f24332c = Looper.getMainLooper() == Looper.myLooper() ? 1 : null;
            postingThreadState.f24331b = true;
            if (postingThreadState.f24335f != null) {
                throw new EventBusException("Internal error. Abort state was not reset");
            }
            while (list.isEmpty() == null) {
                try {
                    postSingleEvent(list.remove(0), postingThreadState);
                } finally {
                    postingThreadState.f24331b = false;
                    postingThreadState.f24332c = false;
                }
            }
        }
    }

    public void cancelEventDelivery(Object obj) {
        PostingThreadState postingThreadState = (PostingThreadState) this.currentPostingThreadState.get();
        if (!postingThreadState.f24331b) {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        } else if (obj == null) {
            throw new EventBusException("Event may not be null");
        } else if (postingThreadState.f24334e != obj) {
            throw new EventBusException("Only the currently handled event may be aborted");
        } else if (postingThreadState.f24333d.f24368b.f24362b != ThreadMode.PostThread) {
            throw new EventBusException(" event handlers may only abort the incoming event");
        } else {
            postingThreadState.f24335f = true;
        }
    }

    public void postSticky(Object obj) {
        synchronized (this.stickyEvents) {
            this.stickyEvents.put(obj.getClass(), obj);
        }
        post(obj);
    }

    public <T> T getStickyEvent(Class<T> cls) {
        synchronized (this.stickyEvents) {
            cls = cls.cast(this.stickyEvents.get(cls));
        }
        return cls;
    }

    public <T> T removeStickyEvent(Class<T> cls) {
        synchronized (this.stickyEvents) {
            cls = cls.cast(this.stickyEvents.remove(cls));
        }
        return cls;
    }

    public boolean removeStickyEvent(Object obj) {
        synchronized (this.stickyEvents) {
            Class cls = obj.getClass();
            if (obj.equals(this.stickyEvents.get(cls)) != null) {
                this.stickyEvents.remove(cls);
                return true;
            }
            return null;
        }
    }

    public void removeAllStickyEvents() {
        synchronized (this.stickyEvents) {
            this.stickyEvents.clear();
        }
    }

    public boolean hasSubscriberForEvent(Class<?> cls) {
        cls = lookupAllEventTypes(cls);
        if (cls != null) {
            int size = cls.size();
            for (int i = 0; i < size; i++) {
                CopyOnWriteArrayList copyOnWriteArrayList;
                Class cls2 = (Class) cls.get(i);
                synchronized (this) {
                    copyOnWriteArrayList = (CopyOnWriteArrayList) this.subscriptionsByEventType.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void postSingleEvent(Object obj, PostingThreadState postingThreadState) throws Error {
        int i;
        Class cls = obj.getClass();
        if (this.eventInheritance) {
            List lookupAllEventTypes = lookupAllEventTypes(cls);
            int i2 = 0;
            i = 0;
            while (i2 < lookupAllEventTypes.size()) {
                i |= postSingleEventForEventType(obj, postingThreadState, (Class) lookupAllEventTypes.get(i2));
                i2++;
            }
        } else {
            i = postSingleEventForEventType(obj, postingThreadState, cls);
        }
        if (i == 0) {
            if (this.logNoSubscriberMessages != null) {
                postingThreadState = TAG;
                StringBuilder stringBuilder = new StringBuilder("No subscribers registered for event ");
                stringBuilder.append(cls);
                Log.d(postingThreadState, stringBuilder.toString());
            }
            if (this.sendNoSubscriberEvent != null && cls != NoSubscriberEvent.class && cls != SubscriberExceptionEvent.class) {
                post(new NoSubscriberEvent(this, obj));
            }
        }
    }

    private boolean postSingleEventForEventType(Object obj, PostingThreadState postingThreadState, Class<?> cls) {
        synchronized (this) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.subscriptionsByEventType.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        cls = copyOnWriteArrayList.iterator();
        loop0:
        while (cls.hasNext()) {
            boolean z = (Subscription) cls.next();
            postingThreadState.f24334e = obj;
            postingThreadState.f24333d = z;
            try {
                postToSubscription(z, obj, postingThreadState.f24332c);
                z = postingThreadState.f24335f;
                continue;
            } finally {
                postingThreadState.f24334e = null;
                postingThreadState.f24333d = null;
                postingThreadState.f24335f = false;
            }
            if (z) {
                break loop0;
            }
        }
        return true;
    }

    private void postToSubscription(Subscription subscription, Object obj, boolean z) {
        switch (subscription.f24368b.f24362b) {
            case PostThread:
                invokeSubscriber(subscription, obj);
                return;
            case MainThread:
                if (z) {
                    invokeSubscriber(subscription, obj);
                    return;
                }
                z = this.mainThreadPoster;
                subscription = PendingPost.m26014a(subscription, obj);
                synchronized (z) {
                    z.f24345a.m26017a(subscription);
                    if (z.f24346b == null) {
                        z.f24346b = true;
                        if (z.sendMessage(z.obtainMessage()) == null) {
                            throw new EventBusException("Could not send handler message");
                        }
                    }
                }
                return;
            case BackgroundThread:
                if (z) {
                    z = this.backgroundPoster;
                    subscription = PendingPost.m26014a(subscription, obj);
                    synchronized (z) {
                        z.f24325a.m26017a(subscription);
                        if (z.f24327c == null) {
                            z.f24327c = true;
                            z.f24326b.getExecutorService().execute(z);
                        }
                    }
                    return;
                }
                invokeSubscriber(subscription, obj);
                return;
            case Async:
                z = this.asyncPoster;
                z.f24323a.m26017a(PendingPost.m26014a(subscription, obj));
                z.f24324b.getExecutorService().execute(z);
                return;
            default:
                z = new StringBuilder("Unknown thread mode: ");
                z.append(subscription.f24368b.f24362b);
                throw new IllegalStateException(z.toString());
        }
    }

    private List<Class<?>> lookupAllEventTypes(Class<?> cls) {
        List<Class<?>> list;
        synchronized (eventTypesCache) {
            list = (List) eventTypesCache.get(cls);
            if (list == null) {
                list = new ArrayList();
                for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    addInterfaces(list, cls2.getInterfaces());
                }
                eventTypesCache.put(cls, list);
            }
        }
        return list;
    }

    static void addInterfaces(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                addInterfaces(list, cls.getInterfaces());
            }
        }
    }

    void invokeSubscriber(PendingPost pendingPost) {
        Object obj = pendingPost.f24352a;
        Subscription subscription = pendingPost.f24353b;
        PendingPost.m26015a(pendingPost);
        if (subscription.f24370d != null) {
            invokeSubscriber(subscription, obj);
        }
    }

    void invokeSubscriber(Subscription subscription, Object obj) {
        try {
            subscription.f24368b.f24361a.invoke(subscription.f24367a, new Object[]{obj});
        } catch (InvocationTargetException e) {
            handleSubscriberException(subscription, obj, e.getCause());
        } catch (Subscription subscription2) {
            throw new IllegalStateException("Unexpected exception", subscription2);
        }
    }

    private void handleSubscriberException(Subscription subscription, Object obj, Throwable th) {
        String str;
        StringBuilder stringBuilder;
        if (obj instanceof SubscriberExceptionEvent) {
            if (this.logSubscriberExceptions) {
                str = TAG;
                stringBuilder = new StringBuilder("SubscriberExceptionEvent subscriber ");
                stringBuilder.append(subscription.f24367a.getClass());
                stringBuilder.append(" threw an exception");
                Log.e(str, stringBuilder.toString(), th);
                SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) obj;
                subscription = TAG;
                th = new StringBuilder("Initial event ");
                th.append(subscriberExceptionEvent.f24359c);
                th.append(" caused exception in ");
                th.append(subscriberExceptionEvent.f24360d);
                Log.e(subscription, th.toString(), subscriberExceptionEvent.f24358b);
            }
        } else if (this.throwSubscriberException) {
            throw new EventBusException("Invoking subscriber failed", th);
        } else {
            if (this.logSubscriberExceptions) {
                str = TAG;
                stringBuilder = new StringBuilder("Could not dispatch event: ");
                stringBuilder.append(obj.getClass());
                stringBuilder.append(" to subscribing class ");
                stringBuilder.append(subscription.f24367a.getClass());
                Log.e(str, stringBuilder.toString(), th);
            }
            if (this.sendSubscriberExceptionEvent) {
                post(new SubscriberExceptionEvent(this, th, obj, subscription.f24367a));
            }
        }
    }

    ExecutorService getExecutorService() {
        return this.executorService;
    }
}
