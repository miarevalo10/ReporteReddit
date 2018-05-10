package com.reddit.frontpage.commons.analytics.output;

import com.cookpad.puree.PureeFilter;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class PureeOldEventsFilter implements PureeFilter {
    public final JSONObject m28973a(JSONObject jSONObject) throws JSONException {
        return ((Long.parseLong(jSONObject.get("event_ts").toString()) > (System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7)) ? 1 : (Long.parseLong(jSONObject.get("event_ts").toString()) == (System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7)) ? 0 : -1)) < 0 ? 1 : null) != null ? null : jSONObject;
    }
}
