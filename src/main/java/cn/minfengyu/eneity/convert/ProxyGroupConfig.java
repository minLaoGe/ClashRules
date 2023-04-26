package cn.minfengyu.eneity.convert;

import cn.minfengyu.enums.BalanceStrategy;
import cn.minfengyu.enums.ProxyGroupType;

public class ProxyGroupConfig {
    private String Name;
    private ProxyGroupType Type;
    private StrArray Proxies;
    private StrArray UsingProvider;
    private String Url;
    private Integer Interval = 0;
    private Integer Timeout = 0;
    private Integer Tolerance = 0;
    private BalanceStrategy Strategy = BalanceStrategy.ConsistentHashing;
    private Boolean Lazy;
    private Boolean DisableUdp;
    private Boolean Persistent;
    private Boolean EvaluateBeforeUse;





    // getters and setters for all fields (omitted for brevity)
}
