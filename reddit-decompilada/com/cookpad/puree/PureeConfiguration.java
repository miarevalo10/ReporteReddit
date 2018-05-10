package com.cookpad.puree;

import android.content.Context;
import com.cookpad.puree.outputs.PureeOutput;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PureeConfiguration {
    Context f3686a;
    Gson f3687b;
    Map<Key, List<PureeOutput>> f3688c;

    public static class Builder {
        public Context f3683a;
        public Gson f3684b = new Gson();
        public Map<Key, List<PureeOutput>> f3685c = new HashMap();

        public Builder(Context context) {
            this.f3683a = context;
        }
    }

    public PureeConfiguration(Context context, Gson gson, Map<Key, List<PureeOutput>> map) {
        this.f3686a = context.getApplicationContext();
        this.f3687b = gson;
        this.f3688c = map;
    }
}
