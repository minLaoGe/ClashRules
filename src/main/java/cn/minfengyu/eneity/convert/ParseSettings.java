package cn.minfengyu.eneity.convert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParseSettings {
    private String proxy;
    private List<String> excludeRemarks;
    private List<String> includeRemarks;
    private List<RegexMatchConfig> streamRules;
    private List<RegexMatchConfig> timeRules;
    private String subInfo;
    private Boolean authorized;
    private Map<String, String> requestHeader;
//    private QjsRuntime jsRuntime;
//    private QjsContext jsContext;
}

