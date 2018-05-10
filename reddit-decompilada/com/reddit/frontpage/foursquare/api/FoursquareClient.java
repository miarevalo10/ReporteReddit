package com.reddit.frontpage.foursquare.api;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon.Builder;
import com.reddit.datalibrary.frontpage.requests.models.v2.DeserializationPostProcessable;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.foursquare.Config;
import com.reddit.frontpage.foursquare.model.LocationDistance;
import com.reddit.frontpage.util.Util;
import io.gsonfire.GsonFireBuilder;
import io.gsonfire.PostProcessor;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoursquareClient {
    public static final Type f20301b = new C22941().b;
    public final Cannon f20302a;
    private final Gson f20303c = new GsonFireBuilder().m26450a(DeserializationPostProcessable.class, new C22952(this)).m26449a().a(f20301b, new FoursquareVenueSearchResponseDeserializer()).a();

    static class C22941 extends TypeToken<List<String>> {
        C22941() {
        }
    }

    class C22952 implements PostProcessor<DeserializationPostProcessable> {
        final /* synthetic */ FoursquareClient f28036a;

        public final /* bridge */ /* synthetic */ void mo4762a(JsonElement jsonElement, Object obj, Gson gson) {
        }

        C22952(FoursquareClient foursquareClient) {
            this.f28036a = foursquareClient;
        }

        public final /* synthetic */ void mo4763a(Object obj) {
            ((DeserializationPostProcessable) obj).postDeserialization();
        }
    }

    private static class FoursquareVenueSearchResponseDeserializer implements JsonDeserializer<List<LocationDistance>> {
        private FoursquareVenueSearchResponseDeserializer() {
        }

        public final /* synthetic */ Object m29344a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            jsonElement = jsonElement.h().e("response").c("venues").i();
            type = new ArrayList(jsonElement.a());
            jsonElement = jsonElement.iterator();
            while (jsonElement.hasNext() != null) {
                jsonDeserializationContext = ((JsonElement) jsonElement.next()).h();
                String c = jsonDeserializationContext.c("name").c();
                jsonDeserializationContext = jsonDeserializationContext.c("location").h();
                double i = Util.m24035i(jsonDeserializationContext.b("distance") ? jsonDeserializationContext.c("distance").f() : -1);
                String a = (jsonDeserializationContext.c("city") == null || jsonDeserializationContext.c("state") == null) ? null : Util.m23960a((int) C1761R.string.city_state_location, jsonDeserializationContext.c("city").c(), jsonDeserializationContext.c("state").c());
                type.add(new LocationDistance(c, jsonDeserializationContext.b("lat") ? Double.valueOf(jsonDeserializationContext.c("lat").d()) : null, jsonDeserializationContext.b("lng") ? Double.valueOf(jsonDeserializationContext.c("lng").d()) : null, i, a));
            }
            Collections.sort(type, C1802x61d25c05.f20300a);
            return type;
        }
    }

    public FoursquareClient() {
        FrontpageApplication frontpageApplication = FrontpageApplication.f27402a;
        Builder builder = new Builder(Config.f20298a);
        builder.a = Config.f20299b;
        builder.c = this.f20303c;
        this.f20302a = builder.a();
    }
}
