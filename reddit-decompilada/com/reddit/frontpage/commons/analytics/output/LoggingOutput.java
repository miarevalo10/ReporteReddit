package com.reddit.frontpage.commons.analytics.output;

import com.cookpad.puree.outputs.OutputConfiguration;
import com.cookpad.puree.outputs.PureeOutput;
import com.reddit.frontpage.util.BoundedLinkedList;
import org.json.JSONObject;
import timber.log.Timber;

public class LoggingOutput extends PureeOutput {
    public final BoundedLinkedList<JSONObject> f27470d = new BoundedLinkedList();

    public final OutputConfiguration m28970a(OutputConfiguration outputConfiguration) {
        return outputConfiguration;
    }

    public final String m28972c() {
        return "logger_output";
    }

    public final void m28971b(JSONObject jSONObject) {
        Timber.b(jSONObject.toString(), new Object[0]);
        BoundedLinkedList boundedLinkedList = this.f27470d;
        while (boundedLinkedList.f21704a.size() >= boundedLinkedList.f21705b) {
            boundedLinkedList.f21704a.removeLast();
        }
        boundedLinkedList.f21704a.addFirst(jSONObject);
    }
}
