package com.reddit.frontpage.util;

import com.instabug.library.Instabug;
import com.instabug.library.user.UserEventParam;
import com.reddit.frontpage.commons.analytics.events.v2.ScreenviewEventBuilder;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/util/InstabugEventUtil;", "", "()V", "EVENT_SCREEN_VIEW", "", "PARAM_KEY_SCREEN", "PARAM_KEY_SCREEN_INFO", "buildScreenInfoStringFromEvent", "eventBuilder", "Lcom/reddit/frontpage/commons/analytics/events/v2/ScreenviewEventBuilder;", "logScreenView", "", "screenName", "screenInfo", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: InstabugEventUtil.kt */
public final class InstabugEventUtil {
    public static final InstabugEventUtil f21743a = new InstabugEventUtil();

    private InstabugEventUtil() {
    }

    public static final void m23731a(String str, String str2) {
        Intrinsics.m26847b(str, "screenName");
        if (InstabugUtil.m23735c()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new UserEventParam().setKey("screen").setValue(str));
            if (str2 != null) {
                arrayList.add(new UserEventParam().setKey("screen_info").setValue(str2));
            }
            str = "ScreenView";
            str2 = arrayList.toArray(new UserEventParam[null]);
            if (str2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            UserEventParam[] userEventParamArr = (UserEventParam[]) str2;
            Instabug.logUserEvent(str, (UserEventParam[]) Arrays.copyOf(userEventParamArr, userEventParamArr.length));
        }
    }

    public static final String m23730a(ScreenviewEventBuilder screenviewEventBuilder) {
        Intrinsics.m26847b(screenviewEventBuilder, "eventBuilder");
        screenviewEventBuilder = screenviewEventBuilder.m21925a().client_timestamp(Long.valueOf(0)).uuid("").build();
        Object declaredFields = screenviewEventBuilder.getClass().getDeclaredFields();
        Intrinsics.m26843a(declaredFields, "event.javaClass.declaredFields");
        Object[] objArr = (Object[]) declaredFields;
        Collection arrayList = new ArrayList();
        for (Object obj : objArr) {
            String obj2;
            Object obj3 = (Field) obj3;
            Object obj4 = obj3.get(screenviewEventBuilder);
            Object obj5 = null;
            if (obj4 != null) {
                obj2 = obj4.toString();
                if (!(obj2 == null || StringsKt__StringsJVMKt.m41943a((CharSequence) obj2))) {
                    if (obj2 != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        Intrinsics.m26843a(obj3, "field");
                        stringBuilder.append(obj3.getName());
                        stringBuilder.append(": ");
                        stringBuilder.append(obj2);
                        obj5 = stringBuilder.toString();
                    }
                    if (obj5 != null) {
                        arrayList.add(obj5);
                    }
                }
            }
            obj2 = null;
            if (obj2 != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                Intrinsics.m26843a(obj3, "field");
                stringBuilder2.append(obj3.getName());
                stringBuilder2.append(": ");
                stringBuilder2.append(obj2);
                obj5 = stringBuilder2.toString();
            }
            if (obj5 != null) {
                arrayList.add(obj5);
            }
        }
        return CollectionsKt___CollectionsKt.m41412a((Iterable) (List) arrayList, null, null, null, 0, null, null, 63);
    }
}
