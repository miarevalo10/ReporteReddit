package com.android.volley;

import android.content.Intent;

public class AuthFailureError extends VolleyError {
    private Intent f12117c;

    public AuthFailureError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public String getMessage() {
        if (this.f12117c != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }
}
