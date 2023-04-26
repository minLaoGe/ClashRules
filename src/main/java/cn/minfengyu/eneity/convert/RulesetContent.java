package cn.minfengyu.eneity.convert;

import cn.minfengyu.enums.RulesetType;

import java.util.concurrent.CompletableFuture;

public class RulesetContent {
    private String rule_group;
    private String rule_path;
    private String rule_path_typed;
    private RulesetType rule_type = RulesetType.Surge;
    private CompletableFuture<String> rule_content;
    private int update_interval = 0;

    // getters and setters for all fields (omitted for brevity)
}
