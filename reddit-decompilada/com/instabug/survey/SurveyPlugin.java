package com.instabug.survey;

import android.content.Context;
import android.content.Intent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Feature;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Session;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.User;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;
import com.instabug.library.core.plugin.Plugin;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.OnDiskCache;
import com.instabug.library.network.Request;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.Request.Endpoint;
import com.instabug.library.network.Request.RequestMethod;
import com.instabug.library.network.Request.RequestParameter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.cache.SurveysCacheManager;
import com.instabug.survey.network.C0800a;
import com.instabug.survey.network.C0800a.C14171;
import com.instabug.survey.network.service.C0801a;
import com.instabug.survey.network.service.C0801a.C16691;
import com.instabug.survey.network.service.InstabugSurveysSubmitterService;
import com.instabug.survey.p027a.C1413c;
import com.instabug.survey.p028b.C0789a;
import com.instabug.survey.p028b.C0790b;
import com.instabug.survey.p028b.C0791c;
import com.instabug.survey.p029c.C0796e;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class SurveyPlugin extends Plugin {
    private Subscription subscribe;

    class C14101 implements Action1<SDKCoreEvent> {
        final /* synthetic */ SurveyPlugin f15561a;

        C14101(SurveyPlugin surveyPlugin) {
            this.f15561a = surveyPlugin;
        }

        public final /* synthetic */ void m15470a(Object obj) {
            Object obj2;
            Context context;
            SDKCoreEvent sDKCoreEvent = (SDKCoreEvent) obj;
            String type = sDKCoreEvent.getType();
            int hashCode = type.hashCode();
            if (hashCode != -290659267) {
                if (hashCode != 3599307) {
                    if (hashCode == 1984987798) {
                        if (type.equals(Session.TYPE_SESSION)) {
                            obj2 = 1;
                            switch (obj2) {
                                case null:
                                    if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                                        SurveyPlugin.clearUserActivities();
                                        return;
                                    }
                                    break;
                                case 1:
                                    if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED)) {
                                        this.f15561a.startFetchingSurveys();
                                        return;
                                    } else if (!(sDKCoreEvent.getValue().equals(Session.VALUE_FINISHED) == null || this.f15561a.contextWeakReference == null)) {
                                        context = (Context) this.f15561a.contextWeakReference.get();
                                        if (context != null) {
                                            context.startService(new Intent(context, InstabugSurveysSubmitterService.class));
                                        }
                                        return;
                                    }
                                case 2:
                                    if (sDKCoreEvent.getValue().equals(Feature.VALUE_FETCHED) != null) {
                                        this.f15561a.startFetchingSurveys();
                                        break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                } else if (type.equals("user")) {
                    obj2 = null;
                    switch (obj2) {
                        case null:
                            if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                                SurveyPlugin.clearUserActivities();
                                return;
                            }
                            break;
                        case 1:
                            if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED)) {
                                this.f15561a.startFetchingSurveys();
                                return;
                            }
                            context = (Context) this.f15561a.contextWeakReference.get();
                            if (context != null) {
                                context.startService(new Intent(context, InstabugSurveysSubmitterService.class));
                            }
                            return;
                        case 2:
                            if (sDKCoreEvent.getValue().equals(Feature.VALUE_FETCHED) != null) {
                                this.f15561a.startFetchingSurveys();
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
            } else if (type.equals(Feature.TYPE_FEATURES)) {
                obj2 = 2;
                switch (obj2) {
                    case null:
                        if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                            SurveyPlugin.clearUserActivities();
                            return;
                        }
                        break;
                    case 1:
                        if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED)) {
                            this.f15561a.startFetchingSurveys();
                            return;
                        }
                        context = (Context) this.f15561a.contextWeakReference.get();
                        if (context != null) {
                            context.startService(new Intent(context, InstabugSurveysSubmitterService.class));
                        }
                        return;
                    case 2:
                        if (sDKCoreEvent.getValue().equals(Feature.VALUE_FETCHED) != null) {
                            this.f15561a.startFetchingSurveys();
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
            obj2 = -1;
            switch (obj2) {
                case null:
                    if (sDKCoreEvent.getValue().equals(User.VALUE_LOGGED_OUT) != null) {
                        SurveyPlugin.clearUserActivities();
                        return;
                    }
                    break;
                case 1:
                    if (sDKCoreEvent.getValue().equals(Session.VALUE_STARTED)) {
                        context = (Context) this.f15561a.contextWeakReference.get();
                        if (context != null) {
                            context.startService(new Intent(context, InstabugSurveysSubmitterService.class));
                        }
                        return;
                    }
                    this.f15561a.startFetchingSurveys();
                    return;
                case 2:
                    if (sDKCoreEvent.getValue().equals(Feature.VALUE_FETCHED) != null) {
                        this.f15561a.startFetchingSurveys();
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void init(Context context) {
        super.init(context);
        C0790b.m8397a(context);
        C0789a.m8394a();
        subscribeOnSDKEvents();
        prepareSurveysCache();
    }

    public void release() {
        if (this.subscribe != null) {
            this.subscribe.c();
        }
    }

    public long getLastActivityTime() {
        return C0790b.m8396a().f9961a.getLong("last_survey_time", 0);
    }

    private void subscribeOnSDKEvents() {
        this.subscribe = SDKCoreEventSubscriber.subscribe(new C14101(this));
    }

    private static void clearUserActivities() {
        C0790b.m8396a().m8398a(0);
    }

    private void prepareSurveysCache() {
        InstabugSDKLogger.m8360v(this, "Creating Surveys disk cache");
        if (this.contextWeakReference != null && this.contextWeakReference.get() != null) {
            CacheManager.getInstance().addCache(new OnDiskCache((Context) this.contextWeakReference.get(), SurveysCacheManager.SURVEYS_DISK_CACHE_KEY, SurveysCacheManager.SURVEYS_DISK_CACHE_FILE_NAME, C1413c.class));
        }
    }

    private void startFetchingSurveys() {
        if (!(!C0796e.m8412a() || this.contextWeakReference == null || this.contextWeakReference.get() == null)) {
            InstabugSDKLogger.m8360v(this, "initialize Instabug Surveys Manager");
            C1414a a = C1414a.m15478a((Context) this.contextWeakReference.get());
            if (a.f15584a.get() != null) {
                try {
                    C0800a c0800a = a.f15585b;
                    Context context = (Context) a.f15584a.get();
                    if (C0800a.m8427a() && C0796e.m8412a() && System.currentTimeMillis() - C0791c.m8406d() > 10000) {
                        C0801a a2 = C0801a.m8428a();
                        Callbacks c14171 = new C14171(c0800a);
                        InstabugSDKLogger.m8360v(a2, "fetch surveys");
                        Request buildRequest = a2.f9967a.buildRequest(context, Endpoint.GetSurveys, RequestMethod.Get);
                        buildRequest.addHeader(new RequestParameter("Accept", "application/vnd.instabug.v2"));
                        buildRequest.addHeader(new RequestParameter("version", "2"));
                        Observable.a(new C16691(a2, c14171), a2.f9967a.doRequest(buildRequest).b(Schedulers.b()));
                    }
                } catch (Throwable e) {
                    InstabugSDKLogger.m8358e(C0800a.class.getAnnotations(), e.getMessage(), e);
                }
            }
        }
    }
}
