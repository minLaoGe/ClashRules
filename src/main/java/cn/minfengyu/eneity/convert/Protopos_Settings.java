package cn.minfengyu.eneity.convert;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public  class Protopos_Settings {
    // common settings
    public  String prefPath = "pref.ini";
    public  String defaultExtConfig;
    public  Map<String,String> excludeRemarks=new HashMap<>();
    public  Map<String,String> includeRemarks=new HashMap<>();
    public  List<RulesetConfig> customRulesets=new ArrayList<>();
    public  List<RegexMatchConfig> streamNodeRules=new ArrayList<>();
    public  List<RegexMatchConfig>  timeNodeRules=new ArrayList<>();
    public  List<RulesetContent> rulesetsContent=new ArrayList<>();
    public  String listenAddress = "127.0.0.1";
    public  String defaultUrls;
    public  String insertUrls;
    public  String managedConfigPrefix;
    public  int listenPort = 25500;
    public  int maxPendingConns = 10;
    public  int maxConcurThreads = 4;
    public  boolean prependInsert = true;
    public  boolean skipFailedLinks = false;
    public  boolean APIMode = true;
    public  boolean writeManagedConfig = false;
    public  boolean enableRuleGen = true;
    public  boolean updateRulesetOnRequest = false;
    public  boolean overwriteOriginalRules = true;
    public  boolean printDbgInfo = false;
    public  boolean CFWChildProcess = false;
    public  boolean appendUserinfo = true;
    public  boolean asyncFetchRuleset = false;
    public  boolean surgeResolveHostname = true;
    public  String accessToken;
    public  String basePath = "sources/base";
    public  String custom_group;
//    public  int logLevel = LOG_LEVEL_VERBOSE;
    public  long maxAllowedDownloadSize = 1048576L;
    public  Map<String,String> aliases=new HashMap<>();
    // global variables for template
    public  String templatePath = "templates";
    public  Map<String,String> templateVars=new HashMap<>();

    // generator settings
    public  boolean generatorMode = false;
    public  String generateProfiles;

    // preferences
    public  List<RegexMatchConfig> renames=new ArrayList<>();
    public  List<RegexMatchConfig> emojis=new ArrayList<>();
    public  boolean addEmoji = false;
    public  boolean removeEmoji = false;
    public  boolean appendType = false;
    public  boolean filterDeprecated = true;
    public  Tribool UDPFlag;
    public  Tribool TFOFlag;
    public  Tribool skipCertVerify;
    public  Tribool TLS13Flag;
    public  Tribool enableInsert;
    public  boolean enableSort = false;
    public  boolean updateStrict = false;
    public  boolean clashUseNewField = false;
    public  String clashProxiesStyle = "flow";
    public  String proxyConfig;
    public  String proxyRuleset;
    public  String proxySubscription;
    public  int updateInterval = 0;
    public  String sortScript;
    public  String filterScript;

    public  String clashBase;
    public  List<ProxyGroupConfig> customProxyGroups=new ArrayList<>();
    public  String surgeBase;
    public  String surfboardBase;
    public  String mellowBase;
    public  String quanBase;
    public  String quanXBase;
    public  String loonBase;
    public  String SSSubBase;
    public  String surgeSSRPath;
    public  String quanXDevID;

    // cache system
    public  boolean serveCacheOnFetchFail = false;
    public  int cacheSubscription = 60;
    public  int cacheConfig = 300;
    public  int cacheRuleset = 21600;

    private boolean authorized=false;

    // limits
    public  long maxAllowedRulesets = 64L;
    public  long maxAllowedRules = 32768L;
    public  boolean scriptCleanContext = false;

    // cron system
    public  boolean enableCron = false;
    public  List<CronTaskConfig> cronTasks=new ArrayList<>();
}