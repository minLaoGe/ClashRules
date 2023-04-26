package cn.minfengyu.eneity.convert;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public  class Settings {
    // common settings
    public static String prefPath = "pref.ini";
    public static ExternalConfig defaultExtConfig=new ExternalConfig();
    public static Map<String,String> excludeRemarks=new HashMap<>();
    public static Map<String,String> includeRemarks=new HashMap<>();
    public static List<RulesetConfig> customRulesets=new ArrayList<>();
    public static List<RegexMatchConfig> streamNodeRules=new ArrayList<>();
    public static List<RegexMatchConfig>  timeNodeRules=new ArrayList<>();
    public static List<RulesetContent> rulesetsContent=new ArrayList<>();
    public static String listenAddress = "127.0.0.1";
    public static String defaultUrls="";
    public static String insertUrls="";
    public static String managedConfigPrefix="";
    public static int listenPort = 25500;
    public static int maxPendingConns = 10;
    public static int maxConcurThreads = 4;
    public static boolean prependInsert = true;
    public static boolean skipFailedLinks = false;
    public static boolean APIMode = true;
    public static boolean writeManagedConfig = false;
    public static boolean enableRuleGen = true;
    public static boolean updateRulesetOnRequest = false;
    public static boolean overwriteOriginalRules = true;
    public static boolean printDbgInfo = false;
    public static boolean CFWChildProcess = false;
    public static boolean appendUserinfo = true;
    public static boolean asyncFetchRuleset = false;
    public static boolean surgeResolveHostname = true;
    public static String accessToken="";
    public static String basePath = "sources/base";
    public static String custom_group="";
//    public static int logLevel = LOG_LEVEL_VERBOSE;
    public static long maxAllowedDownloadSize = 1048576L;
    public static Map<String,String> aliases=new HashMap<>();
    // global variables for template
    public static String templatePath = "templates";
    public static Map<String,String> templateVars=new HashMap<>();

    // generator settings
    public static boolean generatorMode = false;
    public static String generateProfiles="";

    // preferences
    public static List<RegexMatchConfig> renames=new ArrayList<>();
    public static List<RegexMatchConfig> emojis=new ArrayList<>();
    public static boolean addEmoji = false;
    public static boolean removeEmoji = false;
    public static boolean appendType = false;
    public static boolean filterDeprecated = true;
    public static Tribool UDPFlag=new Tribool();
    public static Tribool TFOFlag=new Tribool();
    public static Tribool skipCertVerify=new Tribool();
    public static Tribool TLS13Flag=new Tribool();
    public static Tribool enableInsert=new Tribool();
    public static boolean enableSort = false;
    public static boolean updateStrict = false;
    public static boolean clashUseNewField = false;
    public static String clashProxiesStyle = "flow";
    public static String proxyConfig="";
    public static String proxyRuleset="";
    public static String proxySubscription="";
    public static int updateInterval = 0;
    public static String sortScript="";
    public static String filterScript="";

    public static String clashBase="";
    public static List<ProxyGroupConfig> customProxyGroups=new ArrayList<>();
    public static String surgeBase="";
    public static String surfboardBase="";
    public static String mellowBase="";
    public static String quanBase="";
    public static String quanXBase="";
    public static String loonBase="";
    public static String SSSubBase="";
    public static String surgeSSRPath="";
    public static String quanXDevID="";

    // cache system
    public static boolean serveCacheOnFetchFail = false;
    public static int cacheSubscription = 60;
    public static int cacheConfig = 300;
    public static int cacheRuleset = 21600;

    // limits
    public static long maxAllowedRulesets = 64L;
    public static long maxAllowedRules = 32768L;
    public static boolean scriptCleanContext = false;

    // cron system
    public static boolean enableCron = false;
    public static List<CronTaskConfig> cronTasks=new ArrayList<>();
}