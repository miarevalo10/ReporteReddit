package com.facebook.stetho.inspector.network;

import android.annotation.SuppressLint;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.ArrayList;

public class MimeMatcher<T> {
    private final ArrayList<MimeMatcherRule> mRuleMap = new ArrayList();

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private class MimeMatcherRule {
        private final boolean mHasWildcard;
        private final String mMatchPrefix;
        private final T mResultIfMatched;

        public MimeMatcherRule(String str, T t) {
            if (str.endsWith(Operation.MULTIPLY) != null) {
                this.mHasWildcard = true;
                this.mMatchPrefix = str.substring(0, str.length() - 1);
            } else {
                this.mHasWildcard = false;
                this.mMatchPrefix = str;
            }
            if (this.mMatchPrefix.contains(Operation.MULTIPLY) != null) {
                t = new StringBuilder("Multiple wildcards present in rule expression ");
                t.append(str);
                throw new IllegalArgumentException(t.toString());
            }
            this.mResultIfMatched = t;
        }

        public boolean match(String str) {
            if (!str.startsWith(this.mMatchPrefix)) {
                return false;
            }
            if (!this.mHasWildcard) {
                if (str.length() != this.mMatchPrefix.length()) {
                    return false;
                }
            }
            return true;
        }

        public T getResultIfMatched() {
            return this.mResultIfMatched;
        }
    }

    public void addRule(String str, T t) {
        this.mRuleMap.add(new MimeMatcherRule(str, t));
    }

    public void clear() {
        this.mRuleMap.clear();
    }

    public T match(String str) {
        int size = this.mRuleMap.size();
        for (int i = 0; i < size; i++) {
            MimeMatcherRule mimeMatcherRule = (MimeMatcherRule) this.mRuleMap.get(i);
            if (mimeMatcherRule.match(str)) {
                return mimeMatcherRule.getResultIfMatched();
            }
        }
        return null;
    }
}
