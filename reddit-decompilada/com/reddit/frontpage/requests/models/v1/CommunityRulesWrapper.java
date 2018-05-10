package com.reddit.frontpage.requests.models.v1;

import com.reddit.datalibrary.frontpage.requests.models.v1.CommunityRule;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapper;
import java.io.Serializable;
import java.util.List;

public class CommunityRulesWrapper extends ThingWrapper<CommunityRule> implements Serializable {
    private final List<CommunityRule> rules;
    private final List<String> site_rules;

    public CommunityRulesWrapper(List<CommunityRule> list, List<String> list2) {
        this.rules = list;
        this.site_rules = list2;
    }

    public List<CommunityRule> getRules() {
        return this.rules;
    }

    public List<String> getSiteRules() {
        return this.site_rules;
    }
}
