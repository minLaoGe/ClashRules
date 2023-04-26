package cn.minfengyu.eneity.convert;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExtraSettings {
    public boolean enable_rule_generator = true;
    public boolean overwrite_original_rules = true;
    public List<RegexMatchConfig> rename_array;
    public List<RegexMatchConfig> emoji_array;
    public boolean add_emoji = false;
    public boolean remove_emoji = false;
    public boolean append_proxy_type = false;
    public boolean nodelist = false;
    public boolean sort_flag = false;
    public boolean filter_deprecated = false;
    public boolean clash_new_field_name = false;
    public boolean clash_script = false;
    public String surge_ssr_path;
    public String managed_config_prefix;
    public String quanx_dev_id;
    public Tribool udp =new Tribool();
    public Tribool tfo = new Tribool();
    public Tribool skip_cert_verify =new Tribool();
    public Tribool tls13 = new Tribool();
    public boolean clash_classical_ruleset = false;
    public String sort_script = "";
    public String clash_proxies_style = "flow";
    public boolean authorized = false;



    // getters and setters for all fields (omitted for brevity)
}