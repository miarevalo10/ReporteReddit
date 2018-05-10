package android.arch.lifecycle;

import android.arch.core.internal.FastSafeIterableMap;
import android.arch.core.internal.SafeIterableMap;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class LifecycleRegistry extends Lifecycle {
    private FastSafeIterableMap<Object, ObserverWithState> f10947a = new FastSafeIterableMap();
    private State f10948b;
    private final WeakReference<LifecycleOwner> f10949c;
    private int f10950d = 0;
    private boolean f10951e = false;
    private boolean f10952f = false;
    private ArrayList<State> f10953g = new ArrayList();

    static class ObserverWithState {
        State f22a;

        final void m3a(Event event) {
            event = LifecycleRegistry.m9408b(event);
            this.f22a = LifecycleRegistry.m9407a(this.f22a, event);
            this.f22a = event;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        this.f10949c = new WeakReference(lifecycleOwner);
        this.f10948b = State.INITIALIZED;
    }

    public final void m9413a(Event event) {
        m9414a(m9408b(event));
    }

    public final void m9414a(State state) {
        if (this.f10948b != state) {
            this.f10948b = state;
            if (this.f10951e == null) {
                if (this.f10950d == null) {
                    this.f10951e = true;
                    if (((LifecycleOwner) this.f10949c.get()) == null) {
                        Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
                    } else {
                        while (true) {
                            Iterator descendingIterator;
                            Entry entry;
                            ObserverWithState observerWithState;
                            State state2;
                            Event event;
                            StringBuilder stringBuilder;
                            if (this.f10947a.f19d != null) {
                                state = ((ObserverWithState) this.f10947a.f16a.getValue()).f22a;
                                State state3 = ((ObserverWithState) this.f10947a.f17b.getValue()).f22a;
                                if (state != state3 || this.f10948b != state3) {
                                    state = null;
                                    if (state != null) {
                                        this.f10952f = false;
                                        if (this.f10948b.compareTo(((ObserverWithState) this.f10947a.f16a.getValue()).f22a) < null) {
                                            state = this.f10947a;
                                            descendingIterator = new DescendingIterator(state.f17b, state.f16a);
                                            state.f18c.put(descendingIterator, Boolean.valueOf(false));
                                            while (descendingIterator.hasNext() != null && this.f10952f == null) {
                                                entry = (Entry) descendingIterator.next();
                                                observerWithState = (ObserverWithState) entry.getValue();
                                                while (observerWithState.f22a.compareTo(this.f10948b) > 0 && !this.f10952f && this.f10947a.m9404a(entry.getKey())) {
                                                    state2 = observerWithState.f22a;
                                                    switch (state2) {
                                                        case INITIALIZED:
                                                            throw new IllegalArgumentException();
                                                        case CREATED:
                                                            event = Event.ON_DESTROY;
                                                            break;
                                                        case STARTED:
                                                            event = Event.ON_STOP;
                                                            break;
                                                        case RESUMED:
                                                            event = Event.ON_PAUSE;
                                                            break;
                                                        case DESTROYED:
                                                            throw new IllegalArgumentException();
                                                        default:
                                                            stringBuilder = new StringBuilder("Unexpected state value ");
                                                            stringBuilder.append(state2);
                                                            throw new IllegalArgumentException(stringBuilder.toString());
                                                    }
                                                    m9410b(m9408b(event));
                                                    observerWithState.m3a(event);
                                                    m9409b();
                                                }
                                            }
                                        }
                                        state = this.f10947a.f17b;
                                        if (!(this.f10952f || state == null || this.f10948b.compareTo(((ObserverWithState) state.getValue()).f22a) <= null)) {
                                            m9411c();
                                        }
                                    } else {
                                        this.f10952f = false;
                                    }
                                }
                            }
                            state = 1;
                            if (state != null) {
                                this.f10952f = false;
                            } else {
                                this.f10952f = false;
                                if (this.f10948b.compareTo(((ObserverWithState) this.f10947a.f16a.getValue()).f22a) < null) {
                                    state = this.f10947a;
                                    descendingIterator = new DescendingIterator(state.f17b, state.f16a);
                                    state.f18c.put(descendingIterator, Boolean.valueOf(false));
                                    while (descendingIterator.hasNext() != null) {
                                        entry = (Entry) descendingIterator.next();
                                        observerWithState = (ObserverWithState) entry.getValue();
                                        while (observerWithState.f22a.compareTo(this.f10948b) > 0) {
                                            state2 = observerWithState.f22a;
                                            switch (state2) {
                                                case INITIALIZED:
                                                    throw new IllegalArgumentException();
                                                case CREATED:
                                                    event = Event.ON_DESTROY;
                                                    break;
                                                case STARTED:
                                                    event = Event.ON_STOP;
                                                    break;
                                                case RESUMED:
                                                    event = Event.ON_PAUSE;
                                                    break;
                                                case DESTROYED:
                                                    throw new IllegalArgumentException();
                                                default:
                                                    stringBuilder = new StringBuilder("Unexpected state value ");
                                                    stringBuilder.append(state2);
                                                    throw new IllegalArgumentException(stringBuilder.toString());
                                            }
                                            m9410b(m9408b(event));
                                            observerWithState.m3a(event);
                                            m9409b();
                                        }
                                    }
                                }
                                state = this.f10947a.f17b;
                                m9411c();
                            }
                        }
                    }
                    this.f10951e = false;
                    return;
                }
            }
            this.f10952f = true;
        }
    }

    private void m9409b() {
        this.f10953g.remove(this.f10953g.size() - 1);
    }

    private void m9410b(State state) {
        this.f10953g.add(state);
    }

    public final State mo2a() {
        return this.f10948b;
    }

    static State m9408b(Event event) {
        switch (event) {
            case ON_CREATE:
            case ON_STOP:
                return State.CREATED;
            case ON_START:
            case ON_PAUSE:
                return State.STARTED;
            case ON_RESUME:
                return State.RESUMED;
            case ON_DESTROY:
                return State.DESTROYED;
            default:
                StringBuilder stringBuilder = new StringBuilder("Unexpected event value ");
                stringBuilder.append(event);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private void m9411c() {
        SafeIterableMap safeIterableMap = this.f10947a;
        Iterator iteratorWithAdditions = new IteratorWithAdditions();
        safeIterableMap.f18c.put(iteratorWithAdditions, Boolean.valueOf(false));
        while (iteratorWithAdditions.hasNext() && !this.f10952f) {
            Entry entry = (Entry) iteratorWithAdditions.next();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.f22a.compareTo(this.f10948b) < 0 && !this.f10952f && this.f10947a.m9404a(entry.getKey())) {
                Event event;
                m9410b(observerWithState.f22a);
                State state = observerWithState.f22a;
                switch (state) {
                    case INITIALIZED:
                    case DESTROYED:
                        event = Event.ON_CREATE;
                        break;
                    case CREATED:
                        event = Event.ON_START;
                        break;
                    case STARTED:
                        event = Event.ON_RESUME;
                        break;
                    case RESUMED:
                        throw new IllegalArgumentException();
                    default:
                        StringBuilder stringBuilder = new StringBuilder("Unexpected state value ");
                        stringBuilder.append(state);
                        throw new IllegalArgumentException(stringBuilder.toString());
                }
                observerWithState.m3a(event);
                m9409b();
            }
        }
    }

    static State m9407a(State state, State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }
}
