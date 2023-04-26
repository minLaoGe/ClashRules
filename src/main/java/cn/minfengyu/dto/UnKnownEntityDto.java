package cn.minfengyu.dto;

import cn.minfengyu.eneity.convert.ExternalConfig;
import cn.minfengyu.eneity.convert.Settings;
import cn.minfengyu.eneity.convert.Tribool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnKnownEntityDto {
    //不知道是干啥的，先写上
    private String url="";
    private String groupName="";
    private String uploadPath="";
    private String include="";
    private String exclude="";
    private String token="";
    private String customGroups="";
    private String customRulesets="";
    private ExternalConfig externalConfig=Settings.defaultExtConfig;
    private String deviceID=Settings.quanXDevID;
    private String filename="";
    private Integer updateInterval=Integer.valueOf(0);
    private String updateStrict="";
    private String renames="";
    private String filterScript="";


    private Boolean strict=false;
    private Boolean upload=false;
    private Boolean emoji=false;
    private Boolean addEmoji=false;
    private Boolean removeEmoji=false;
    private Boolean appendType=false;
    private Tribool tfo=Settings.TFOFlag;
    private Tribool udp= Settings.UDPFlag;
    private Boolean genNodeList=false;
    private Boolean sort=Settings.enableSort;
    private Boolean useSortScript=false;
    private Boolean genClashScript=false;
    private Boolean clashClassicalRuleset = false;
    private Boolean enableInsert=false;
    private Tribool skipCertVerify=Settings.skipCertVerify;
    private Boolean filterDeprecated=Settings.filterDeprecated;
    private Boolean clashNewFieldName=Settings.clashUseNewField;
    private Boolean expandRulesetst=false;
    private Boolean appendUserinfot=false;
    private Boolean prependInsert=false;
    private Boolean genClassicalRuleProvider=false;
    private Tribool tls13=Settings.TLS13Flag;

}
