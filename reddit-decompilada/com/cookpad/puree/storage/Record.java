package com.cookpad.puree.storage;

import android.database.Cursor;
import org.json.JSONException;
import org.json.JSONObject;

public class Record {
    int f3713a;
    public JSONObject f3714b;
    private String f3715c;

    public Record(Cursor cursor) throws JSONException {
        this(cursor.getInt(0), cursor.getString(1), new JSONObject(cursor.getString(2)));
    }

    private Record(int i, String str, JSONObject jSONObject) {
        this.f3713a = i;
        this.f3715c = str;
        this.f3714b = jSONObject;
    }
}
