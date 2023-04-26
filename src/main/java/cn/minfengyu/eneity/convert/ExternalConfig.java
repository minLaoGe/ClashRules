package cn.minfengyu.eneity.convert;

import cn.minfengyu.eneity.convert.*;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExternalConfig {

    public List<ProxyGroupConfig> custom_proxy_group;
    public List<RulesetConfig> surge_ruleset;
    public String clash_rule_base;
    public String surge_rule_base;
    public String surfboard_rule_base;
    public String mellow_rule_base;
    public String quan_rule_base;
    public String quanx_rule_base;
    public String loon_rule_base;
    public String sssub_rule_base;
    public List<RegexMatchConfig> rename;
    public List<RegexMatchConfig> emoji;
    public List<String> include;
    public List<String> exclude;
    public TemplateArgs tpl_args;
    public boolean overwrite_original_rules = false;
    public boolean enable_rule_generator = true;
    public Tribool add_emoji;
    public Tribool remove_old_emoji;
}