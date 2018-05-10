package com.reddit.datalibrary.frontpage.data.common.db2;

import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import com.reddit.data.events.models.EventDataModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0015\u0010\u0003\u001a\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lcom/reddit/data/events/models/EventDataModel;", "kotlin.jvm.PlatformType", "p1", "Lcom/raizlabs/android/dbflow/structure/database/FlowCursor;", "Lkotlin/ParameterName;", "name", "p0", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: MigrateEventsTableService.kt */
final class MigrateEventsTableService$onHandleWork$1$1$2 extends FunctionReference implements Function1<FlowCursor, EventDataModel> {
    MigrateEventsTableService$onHandleWork$1$1$2(ModelAdapter modelAdapter) {
        super(1, modelAdapter);
    }

    public final KDeclarationContainer m20604a() {
        return Reflection.a(ModelAdapter.class);
    }

    public final String m20605b() {
        return "loadFromCursor";
    }

    public final String m20606c() {
        return "loadFromCursor(Lcom/raizlabs/android/dbflow/structure/database/FlowCursor;)Ljava/lang/Object;";
    }

    public final /* synthetic */ Object m20603a(Object obj) {
        FlowCursor flowCursor = (FlowCursor) obj;
        Intrinsics.b(flowCursor, "p1");
        return (EventDataModel) ((ModelAdapter) this.b).loadFromCursor(flowCursor);
    }
}
