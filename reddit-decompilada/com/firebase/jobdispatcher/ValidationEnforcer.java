package com.firebase.jobdispatcher;

import android.text.TextUtils;
import java.util.List;

public class ValidationEnforcer implements JobValidator {
    private final JobValidator f12744a;

    public static final class ValidationException extends RuntimeException {
        private final List<String> f3885a;

        public ValidationException(String str, List<String> list) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(TextUtils.join("\n  - ", list));
            super(stringBuilder.toString());
            this.f3885a = list;
        }
    }

    public ValidationEnforcer(JobValidator jobValidator) {
        this.f12744a = jobValidator;
    }

    public final List<String> mo1240a(JobParameters jobParameters) {
        return this.f12744a.mo1240a(jobParameters);
    }

    static void m11848a(List<String> list) {
        if (list != null) {
            throw new ValidationException("JobParameters is invalid", list);
        }
    }
}
