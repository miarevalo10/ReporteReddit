package com.bluelinelabs.conductor;

import android.os.Bundle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class Backstack implements Iterable<RouterTransaction> {
    final Deque<RouterTransaction> f3082a = new ArrayDeque();

    Backstack() {
    }

    final boolean m2603a() {
        return this.f3082a.isEmpty();
    }

    public final int m2604b() {
        return this.f3082a.size();
    }

    public Iterator<RouterTransaction> iterator() {
        return this.f3082a.iterator();
    }

    final Iterator<RouterTransaction> m2605c() {
        return this.f3082a.descendingIterator();
    }

    final RouterTransaction m2606d() {
        RouterTransaction routerTransaction = (RouterTransaction) this.f3082a.pop();
        routerTransaction.f3144a.m2655b(false);
        return routerTransaction;
    }

    final RouterTransaction m2607e() {
        return (RouterTransaction) this.f3082a.peek();
    }

    final void m2602a(List<RouterTransaction> list) {
        for (RouterTransaction routerTransaction : this.f3082a) {
            boolean z;
            for (RouterTransaction routerTransaction2 : list) {
                if (routerTransaction.f3144a == routerTransaction2.f3144a) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z) {
                routerTransaction.f3144a.m2655b(false);
            }
        }
        this.f3082a.clear();
        for (RouterTransaction push : list) {
            this.f3082a.push(push);
        }
    }

    final void m2601a(Bundle bundle) {
        ArrayList arrayList = new ArrayList(this.f3082a.size());
        for (RouterTransaction routerTransaction : this.f3082a) {
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("RouterTransaction.controller.bundle", routerTransaction.f3144a.m2672r());
            if (routerTransaction.f3146c != null) {
                bundle2.putBundle("RouterTransaction.pushControllerChangeHandler", routerTransaction.f3146c.m2688d());
            }
            if (routerTransaction.f3147d != null) {
                bundle2.putBundle("RouterTransaction.popControllerChangeHandler", routerTransaction.f3147d.m2688d());
            }
            bundle2.putString("RouterTransaction.tag", routerTransaction.f3145b);
            bundle2.putInt("RouterTransaction.transactionIndex", routerTransaction.f3149f);
            bundle2.putBoolean("RouterTransaction.attachedToRouter", routerTransaction.f3148e);
            arrayList.add(bundle2);
        }
        bundle.putParcelableArrayList("Backstack.entries", arrayList);
    }
}
