package cn.minfengyu.eneity.convert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "config")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigProperties {

    private Common common;
    private SurgeExternalProxy surgeExternalProxy;
    private NodePref nodePref;
    private Userinfo userinfo;
    private ManagedConfig managedConfig;
    private Emojis emojis;
    private Rulesets rulesets;
    private ProxyGroups proxyGroups;
    private Template template;
    private Map<String, String> aliases;
    private Tasks tasks;
    private Server server;
    private Advanced advanced;

    // Getters and setters for all properties

    @Data
    public static class Common {
        private boolean apiMode;
        private String apiAccessToken;
        private List<String> defaultUrl;
        private String enableInsert;
        private List<String> insertUrl;
        private boolean prependInsertUrl;
        private List<String> excludeRemarks;
        private List<String> includeRemarks;
        private String filterScript;
        private String basePath;
        private String clashRuleBase;
        private String surgeRuleBase;
        private String surfboardRuleBase;
        private String mellowRuleBase;
        private String quanRuleBase;
        private String quanxRuleBase;
        private String loonRuleBase;
        private String defaultExternalConfig;
        private boolean appendProxyType;
        private String proxyConfig;
        private String proxyRuleset;
        private String proxySubscription;
        // Getters and setters
    }
    @Data
    public static class SurgeExternalProxy {
        private String surgeSsrPath;
        private boolean resolveHostname;

        // Getters and setters
    }

    @Data
    public static class NodePref {
        private String UDPFlag;
        private String TFOFlag;
        private String skipCertVerify;
        private String TLS13Flag;
        private boolean enableSort;
        private String sortScript;
        private boolean filterDeprecated;
        private boolean appendUserinfo;
        private boolean clashUseNewField;
        private String clashProxiesStyle;

        // Getters and setters
    }

    @Data
    public static class Userinfo {
        private String streamRule;
        private String timeRule;

        // Getters and setters
    }

    @Data
    public static class ManagedConfig {
        private boolean writeManagedConfig;
        private String managedConfigPrefix;
        private int configUpdateInterval;
        private boolean configUpdateStrict;
        private String quanxDeviceId;

        // Getters and setters
    }

    @Data
    public static class Emojis {
        private boolean addEmoji;
        private boolean removeOldEmoji;
        private String rule;

        // Getters and setters
    }

    @Data
    public static class Rulesets {
        private boolean enabled;
        private boolean overwriteOriginalRules;
        private boolean updateRulesetOnRequest;
        private List<String> ruleset;
        private List<String> surgeRuleset;

        // Getters and setters
    }

    @Data
    public static class ProxyGroups {
        private List<String> customProxyGroup;

        // Getters and setters
    }

    @Data
    public static class Template {
        private String templatePath;
        private String managedConfigPrefix;

        // Getters and setters
    }
    @Data
    public static class Tasks {
        private List<String> task;

        // Getters and setters
    }
    @Data
    public static class Server {
        private String listen;
        private int port;
        private String serveFileRoot;

        // Getters and setters
    }
    @Data
    public static class Advanced {
        private String logLevel;
        private boolean printDebugInfo;
        private int maxPendingConnections;
        private int maxConcurrentThreads;
        private int maxAllowedRulesets;
        private int maxAllowedRules;
        private int maxAllowedDownloadSize;
        private boolean enableCache;
        private int cacheSubscription;
        private int cacheConfig;
        private int cacheRuleset;
        private boolean serveCacheOnFetchFail;
        private boolean scriptCleanContext;
        private boolean asyncFetchRuleset;
        private boolean skipFailedLinks;

        // Getters and setters
    }


}
