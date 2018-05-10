package com.reddit.datalibrary.frontpage.requests.models.v2;

import java.util.List;

public class BadgeCount {
    private static final String COMMENTS = "comments";
    private static final String MESSAGES = "messages";
    private static final String TRENDING_NOTIFICATIONS = "trending_notification";
    private BadgeData data;
    private String kind;

    public static class BadgeData {
        List<CountInfo> children;
    }

    public static class CountInfo {
        int count;
        String type;
    }

    public final int m21635a() {
        return m21634a(COMMENTS);
    }

    public final int m21636b() {
        return m21634a(MESSAGES);
    }

    private int m21634a(String str) {
        if (this.data == null) {
            return 0;
        }
        BadgeData badgeData = this.data;
        if (badgeData.children != null) {
            if (!badgeData.children.isEmpty()) {
                for (CountInfo countInfo : badgeData.children) {
                    if (countInfo.type.equals(str)) {
                        return countInfo.count;
                    }
                }
                return 0;
            }
        }
        return 0;
    }
}
