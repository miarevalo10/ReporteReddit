package com.reddit.datalibrary.frontpage.data.model;

import com.raizlabs.android.dbflow.data.Blob;
import com.raizlabs.android.dbflow.rx2.structure.BaseRXModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006$"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/EventDataModel;", "Lcom/raizlabs/android/dbflow/rx2/structure/BaseRXModel;", "id", "", "timestamp", "event", "Lcom/raizlabs/android/dbflow/data/Blob;", "dispatched", "", "(JJLcom/raizlabs/android/dbflow/data/Blob;Z)V", "getDispatched", "()Z", "setDispatched", "(Z)V", "getEvent", "()Lcom/raizlabs/android/dbflow/data/Blob;", "setEvent", "(Lcom/raizlabs/android/dbflow/data/Blob;)V", "getId", "()J", "setId", "(J)V", "getTimestamp", "setTimestamp", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: EventDataModel.kt */
public final class EventDataModel extends BaseRXModel {
    private boolean dispatched;
    private Blob event;
    private long id;
    private long timestamp;

    public EventDataModel() {
        this(0, 0, null, false, 15, null);
    }

    public static /* synthetic */ EventDataModel copy$default(EventDataModel eventDataModel, long j, long j2, Blob blob, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = eventDataModel.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = eventDataModel.timestamp;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            blob = eventDataModel.event;
        }
        Blob blob2 = blob;
        if ((i & 8) != 0) {
            z = eventDataModel.dispatched;
        }
        return eventDataModel.copy(j3, j4, blob2, z);
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final Blob component3() {
        return this.event;
    }

    public final boolean component4() {
        return this.dispatched;
    }

    public final EventDataModel copy(long j, long j2, Blob blob, boolean z) {
        Intrinsics.b(blob, "event");
        return new EventDataModel(j, j2, blob, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EventDataModel) {
            EventDataModel eventDataModel = (EventDataModel) obj;
            if (this.id == eventDataModel.id) {
                if ((this.timestamp == eventDataModel.timestamp) && Intrinsics.a(this.event, eventDataModel.event)) {
                    if (this.dispatched == eventDataModel.dispatched) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.timestamp;
        i = (i + ((int) ((j2 >>> 32) ^ j2))) * 31;
        Blob blob = this.event;
        i = (i + (blob != null ? blob.hashCode() : 0)) * 31;
        int i2 = this.dispatched;
        if (i2 != 0) {
            i2 = 1;
        }
        return i + i2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("EventDataModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append(", event=");
        stringBuilder.append(this.event);
        stringBuilder.append(", dispatched=");
        stringBuilder.append(this.dispatched);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public /* synthetic */ EventDataModel(long j, long j2, Blob blob, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != null) {
            j = 0;
        }
        long j3 = j;
        if ((i & 2) != null) {
            j2 = System.currentTimeMillis();
        }
        long j4 = j2;
        if ((i & 4) != null) {
            blob = new Blob();
        }
        Blob blob2 = blob;
        if ((i & 8) != null) {
            z = false;
        }
        this(j3, j4, blob2, z);
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final Blob getEvent() {
        return this.event;
    }

    public final void setEvent(Blob blob) {
        Intrinsics.b(blob, "<set-?>");
        this.event = blob;
    }

    public final boolean getDispatched() {
        return this.dispatched;
    }

    public final void setDispatched(boolean z) {
        this.dispatched = z;
    }

    public EventDataModel(long j, long j2, Blob blob, boolean z) {
        Intrinsics.b(blob, "event");
        this.id = j;
        this.timestamp = j2;
        this.event = blob;
        this.dispatched = z;
    }
}
