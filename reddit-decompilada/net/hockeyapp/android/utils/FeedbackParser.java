package net.hockeyapp.android.utils;

import com.instabug.library.model.State;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.hockeyapp.android.UpdateFragment;
import net.hockeyapp.android.objects.Feedback;
import net.hockeyapp.android.objects.FeedbackAttachment;
import net.hockeyapp.android.objects.FeedbackMessage;
import net.hockeyapp.android.objects.FeedbackResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedbackParser {

    private static class FeedbackParserHolder {
        static final FeedbackParser f26602a = new FeedbackParser();
    }

    private FeedbackParser() {
    }

    public static FeedbackParser m28203a() {
        return FeedbackParserHolder.f26602a;
    }

    public static FeedbackResponse m28202a(String str) {
        JSONObject jSONObject;
        Throwable e;
        Throwable th;
        String str2 = str;
        if (str2 == null) {
            return null;
        }
        FeedbackResponse feedbackResponse;
        try {
            JSONObject jSONObject2;
            ArrayList arrayList;
            Feedback feedback;
            JSONObject jSONObject3 = new JSONObject(str2);
            JSONObject jSONObject4 = jSONObject3.getJSONObject("feedback");
            Feedback feedback2 = new Feedback();
            JSONArray jSONArray = jSONObject4.getJSONArray("messages");
            if (jSONArray.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                int i = 0;
                while (i < jSONArray.length()) {
                    String str3;
                    int i2;
                    String str4;
                    String str5;
                    String str6;
                    String str7;
                    String str8;
                    String string = jSONArray.getJSONObject(i).getString("subject");
                    String string2 = jSONArray.getJSONObject(i).getString("text");
                    String string3 = jSONArray.getJSONObject(i).getString("oem");
                    String string4 = jSONArray.getJSONObject(i).getString("model");
                    String string5 = jSONArray.getJSONObject(i).getString("os_version");
                    String string6 = jSONArray.getJSONObject(i).getString("created_at");
                    int i3 = jSONArray.getJSONObject(i).getInt("id");
                    String string7 = jSONArray.getJSONObject(i).getString("token");
                    jSONObject2 = jSONObject3;
                    int i4 = jSONArray.getJSONObject(i).getInt("via");
                    jSONObject = jSONObject4;
                    str2 = jSONArray.getJSONObject(i).getString("user_string");
                    Feedback feedback3 = feedback2;
                    String string8 = jSONArray.getJSONObject(i).getString("clean_text");
                    ArrayList arrayList3 = arrayList2;
                    String string9 = jSONArray.getJSONObject(i).getString("name");
                    int i5 = i4;
                    String string10 = jSONArray.getJSONObject(i).getString("app_id");
                    JSONArray jSONArray2 = jSONArray;
                    jSONArray = jSONArray.getJSONObject(i).optJSONArray("attachments");
                    List emptyList = Collections.emptyList();
                    if (jSONArray != null) {
                        emptyList = new ArrayList();
                        str3 = str2;
                        i2 = i;
                        i = 0;
                        while (i < jSONArray.length()) {
                            str4 = string7;
                            int i6 = jSONArray.getJSONObject(i).getInt("id");
                            str5 = string2;
                            int i7 = jSONArray.getJSONObject(i).getInt("feedback_message_id");
                            str6 = string;
                            string = jSONArray.getJSONObject(i).getString("file_name");
                            str7 = string5;
                            string2 = jSONArray.getJSONObject(i).getString(UpdateFragment.FRAGMENT_URL);
                            str8 = string3;
                            string3 = jSONArray.getJSONObject(i).getString("created_at");
                            JSONArray jSONArray3 = jSONArray;
                            String string11 = jSONArray.getJSONObject(i).getString("updated_at");
                            FeedbackAttachment feedbackAttachment = new FeedbackAttachment();
                            feedbackAttachment.setId(i6);
                            feedbackAttachment.setMessageId(i7);
                            feedbackAttachment.setFilename(string);
                            feedbackAttachment.setUrl(string2);
                            feedbackAttachment.setCreatedAt(string3);
                            feedbackAttachment.setUpdatedAt(string11);
                            emptyList.add(feedbackAttachment);
                            i++;
                            string7 = str4;
                            string2 = str5;
                            string = str6;
                            string5 = str7;
                            string3 = str8;
                            jSONArray = jSONArray3;
                        }
                        str4 = string7;
                    } else {
                        str3 = str2;
                        str4 = string7;
                        i2 = i;
                    }
                    str6 = string;
                    str5 = string2;
                    str8 = string3;
                    str7 = string5;
                    FeedbackMessage feedbackMessage = new FeedbackMessage();
                    feedbackMessage.f26558m = string10;
                    feedbackMessage.f26556k = string8;
                    feedbackMessage.f26551f = string6;
                    feedbackMessage.f26552g = i3;
                    feedbackMessage.f26549d = string4;
                    feedbackMessage.f26557l = string9;
                    feedbackMessage.f26548c = str8;
                    feedbackMessage.f26550e = str7;
                    feedbackMessage.f26546a = str6;
                    feedbackMessage.f26547b = str5;
                    feedbackMessage.f26553h = str4;
                    feedbackMessage.f26555j = str3;
                    feedbackMessage.f26554i = i5;
                    feedbackMessage.f26559n = emptyList;
                    arrayList = arrayList3;
                    arrayList.add(feedbackMessage);
                    i = i2 + 1;
                    arrayList2 = arrayList;
                    jSONObject3 = jSONObject2;
                    jSONObject4 = jSONObject;
                    feedback2 = feedback3;
                    jSONArray = jSONArray2;
                }
                jSONObject = jSONObject4;
                jSONObject2 = jSONObject3;
                arrayList = arrayList2;
                feedback = feedback2;
            } else {
                jSONObject = jSONObject4;
                jSONObject2 = jSONObject3;
                feedback = feedback2;
                arrayList = null;
            }
            feedback.f26545e = arrayList;
            try {
                jSONObject3 = jSONObject;
                try {
                    feedback.f26541a = jSONObject3.getString("name");
                } catch (JSONException e2) {
                    e = e2;
                    HockeyLog.m28206a("Failed to parse \"name\" in feedback response", e);
                    feedback.f26542b = jSONObject3.getString(State.KEY_EMAIL);
                    feedback.f26543c = jSONObject3.getInt("id");
                    feedback.f26544d = jSONObject3.getString("created_at");
                    feedbackResponse = new FeedbackResponse();
                    feedbackResponse.f26561b = feedback;
                    try {
                        jSONObject3 = jSONObject2;
                        feedbackResponse.f26560a = jSONObject3.getString("status");
                    } catch (JSONException e3) {
                        e = e3;
                        jSONObject3 = jSONObject2;
                        HockeyLog.m28206a("Failed to parse \"status\" in feedback response", e);
                        feedbackResponse.f26562c = jSONObject3.getString("token");
                        return feedbackResponse;
                    }
                    feedbackResponse.f26562c = jSONObject3.getString("token");
                    return feedbackResponse;
                }
            } catch (JSONException e4) {
                e = e4;
                jSONObject3 = jSONObject;
                HockeyLog.m28206a("Failed to parse \"name\" in feedback response", e);
                feedback.f26542b = jSONObject3.getString(State.KEY_EMAIL);
                feedback.f26543c = jSONObject3.getInt("id");
                feedback.f26544d = jSONObject3.getString("created_at");
                feedbackResponse = new FeedbackResponse();
                feedbackResponse.f26561b = feedback;
                jSONObject3 = jSONObject2;
                feedbackResponse.f26560a = jSONObject3.getString("status");
                feedbackResponse.f26562c = jSONObject3.getString("token");
                return feedbackResponse;
            }
            try {
                feedback.f26542b = jSONObject3.getString(State.KEY_EMAIL);
            } catch (Throwable e5) {
                HockeyLog.m28206a("Failed to parse \"email\" in feedback response", e5);
            }
            try {
                feedback.f26543c = jSONObject3.getInt("id");
            } catch (Throwable e52) {
                HockeyLog.m28206a("Failed to parse \"id\" in feedback response", e52);
            }
            try {
                feedback.f26544d = jSONObject3.getString("created_at");
            } catch (Throwable e522) {
                HockeyLog.m28206a("Failed to parse \"created_at\" in feedback response", e522);
            }
            feedbackResponse = new FeedbackResponse();
            try {
                feedbackResponse.f26561b = feedback;
                jSONObject3 = jSONObject2;
                try {
                    feedbackResponse.f26560a = jSONObject3.getString("status");
                } catch (JSONException e6) {
                    e522 = e6;
                    HockeyLog.m28206a("Failed to parse \"status\" in feedback response", e522);
                    feedbackResponse.f26562c = jSONObject3.getString("token");
                    return feedbackResponse;
                }
                try {
                    feedbackResponse.f26562c = jSONObject3.getString("token");
                    return feedbackResponse;
                } catch (Throwable e5222) {
                    HockeyLog.m28206a("Failed to parse \"token\" in feedback response", e5222);
                    return feedbackResponse;
                }
            } catch (Throwable e52222) {
                th = e52222;
                HockeyLog.m28206a("Failed to parse feedback response", th);
                return feedbackResponse;
            }
        } catch (Throwable e522222) {
            th = e522222;
            feedbackResponse = null;
            HockeyLog.m28206a("Failed to parse feedback response", th);
            return feedbackResponse;
        }
    }
}
