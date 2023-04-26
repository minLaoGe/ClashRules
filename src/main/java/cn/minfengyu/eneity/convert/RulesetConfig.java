package cn.minfengyu.eneity.convert;

import java.util.ArrayList;
import java.util.List;


public class RulesetConfig {
    private String Group;
    // private RulesetType Type = RulesetType.SurgeRuleset;
    private String Url;
    private Integer Interval = 86400;

    public boolean equals(RulesetConfig r) {
        return Group.equals(r.Group) && Url.equals(r.Url) && Interval.equals(r.Interval);
    }

    // getters and setters for all fields (omitted for brevity)
}

