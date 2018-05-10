package de.greenrobot.event;

import android.util.Log;
import com.evernote.android.state.StateSaver;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class SubscriberMethodFinder {
    private static final Map<String, List<SubscriberMethod>> f24365a = new HashMap();
    private final Map<Class<?>, Class<?>> f24366b = new ConcurrentHashMap();

    SubscriberMethodFinder(List<Class<?>> list) {
        if (list != null) {
            for (Class cls : list) {
                this.f24366b.put(cls, cls);
            }
        }
    }

    final List<SubscriberMethod> m26021a(Class<?> cls) {
        String name = cls.getName();
        synchronized (f24365a) {
            List<SubscriberMethod> list = (List) f24365a.get(name);
        }
        if (list != null) {
            return list;
        }
        List<SubscriberMethod> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            String name2 = cls2.getName();
            if (name2.startsWith(StateSaver.JAVA_PREFIX) || name2.startsWith("javax.") || name2.startsWith(StateSaver.ANDROID_PREFIX)) {
                break;
            }
            for (Method method : cls2.getDeclaredMethods()) {
                String name3 = method.getName();
                if (name3.startsWith("onEvent")) {
                    int modifiers = method.getModifiers();
                    if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                        Class[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length == 1) {
                            ThreadMode threadMode;
                            String substring = name3.substring(7);
                            if (substring.length() == 0) {
                                threadMode = ThreadMode.PostThread;
                            } else if (substring.equals("MainThread")) {
                                threadMode = ThreadMode.MainThread;
                            } else if (substring.equals("BackgroundThread")) {
                                threadMode = ThreadMode.BackgroundThread;
                            } else if (substring.equals("Async")) {
                                threadMode = ThreadMode.Async;
                            } else if (!this.f24366b.containsKey(cls2)) {
                                StringBuilder stringBuilder2 = new StringBuilder("Illegal onEvent method, check for typos: ");
                                stringBuilder2.append(method);
                                throw new EventBusException(stringBuilder2.toString());
                            }
                            Class cls3 = parameterTypes[0];
                            stringBuilder.setLength(0);
                            stringBuilder.append(name3);
                            stringBuilder.append('>');
                            stringBuilder.append(cls3.getName());
                            if (hashSet.add(stringBuilder.toString())) {
                                arrayList.add(new SubscriberMethod(method, threadMode, cls3));
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f24366b.containsKey(cls2)) {
                        String str = EventBus.TAG;
                        StringBuilder stringBuilder3 = new StringBuilder("Skipping method (not public, static or abstract): ");
                        stringBuilder3.append(cls2);
                        stringBuilder3.append(".");
                        stringBuilder3.append(name3);
                        Log.d(str, stringBuilder3.toString());
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            StringBuilder stringBuilder4 = new StringBuilder("Subscriber ");
            stringBuilder4.append(cls);
            stringBuilder4.append(" has no public methods called onEvent");
            throw new EventBusException(stringBuilder4.toString());
        }
        synchronized (f24365a) {
            f24365a.put(name, arrayList);
        }
        return arrayList;
    }

    static void m26020a() {
        synchronized (f24365a) {
            f24365a.clear();
        }
    }
}
