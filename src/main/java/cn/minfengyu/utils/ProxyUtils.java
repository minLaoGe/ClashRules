package cn.minfengyu.utils;

import cn.minfengyu.eneity.convert.ParseSettings;
import cn.minfengyu.eneity.convert.Proxy;
import cn.minfengyu.eneity.convert.RegexMatchConfig;
import cn.minfengyu.enums.ConfType;

import cn.minfengyu.enums.ProxyType;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.*;

@Slf4j
public class ProxyUtils {


    private static  final String SS_DEFAULT_GROUP= "SSProvider";
    private static  final String SSR_DEFAULT_GROUP="SSRProvider";
    public static String parseProxy(String source) {
        String proxy = source;
        if (source.equals("SYSTEM")) {
            proxy = getSystemProxy();
        } else if (source.equals("NONE")) {
            proxy = "";
        }
        return proxy;
    }
    public static String getUrlArg(String oriStr,String targetStr){
        String[] split = oriStr.split("&");
        for (String s : split) {
            String[] split1 = s.split("=");
            if (targetStr.equals(split1[0])){
                return split1[1];
            }
        }
        return "";
    }
    public static String getProxyTypeName(int type) {

        ProxyType proxy = ProxyType.getProxy(type);
        switch(proxy) {
            case  Shadowsocks:
                return "SS";
            case ShadowsocksR:
                return "SSR";
            case VMess:
                return "VMess";
            case Trojan:
                return "Trojan";
            case Snell:
                return "Snell";
            case HTTP:
                return "HTTP";
            case HTTPS:
                return "HTTPS";
            case SOCKS5:
                return "SOCKS5";
            default:
                return "Unknown";
        }
    }
    public static int  addNodes(String link, List<Proxy> allNodes, int groupID, ParseSettings parseSet) {
        String proxy = parseSet.getProxy();
        String subInfo = parseSet.getSubInfo();
        List<String> excludeRemarks = parseSet.getExcludeRemarks();
        List<String> includeRemarks = parseSet.getIncludeRemarks();
        List<RegexMatchConfig> streamRules = parseSet.getStreamRules();
        List<RegexMatchConfig> timeRules = parseSet.getTimeRules();
        Map<String, String> requestHeaders = parseSet.getRequestHeader();
        boolean authorized = parseSet.getAuthorized();

        ConfType linkType = ConfType.UNKNOW;
        List<Proxy> nodes = new ArrayList<>();
        cn.minfengyu.eneity.convert.Proxy node = new cn.minfengyu.eneity.convert.Proxy();
        String strSub, extraHeaders, customGroup;

        // TODO: replace with startsWith if appropriate
        link = link.replace("\"", "");

        // (Rest of the script-related code has been omitted for now)

        // tag:group_name,link
        if (link.startsWith("tag:")) {
            int pos = link.indexOf(",");
            if (pos != -1) {
                customGroup = link.substring(4, pos);
                link = link.substring(pos + 1);
            }
        }

        if (link.equals("nullnode")) {
            node.GroupId = 0;
            log.info("Adding node placeholder...");
            allNodes.add(node);
            return 0;
        }

        log.info("Received Link.");
        if (link.startsWith("https://t.me/socks") || link.startsWith("tg://socks")) {
            linkType = ConfType.SOCKS;
        } else if (link.startsWith("https://t.me/http") || link.startsWith("tg://http")) {
            linkType = ConfType.HTTP;
        } else if (isLink(link) || link.startsWith("surge:///install-config")) {
            linkType = ConfType.SUB;
        } else if (link.startsWith("Netch://")) {
            linkType = ConfType.NETCH;
        } else if (fileExist(link,false)) {
            linkType = ConfType.LOCAL;
        }

        switch (linkType) {
            case SUB:
               /* log.info("Downloading subscription data...");
                if (link.startsWith("surge:///install-config")) { // surge config link
                    link = urlDecode(getUrlArg(link, "url"));
                }
                strSub = webGet(link, proxy, global.cacheSubscription, extraHeaders, requestHeaders);

                if (!strSub.isEmpty()) {
                    System.out.println("Parsing subscription data...");
                    if (explodeConfContent(strSub, nodes) == 0) {
                        System.err.println("Invalid subscription: '" + link + "'!");
                        return -1;
                    }
                    if (link.startsWith("ssd://")) {
                        getSubInfoFromSSD(strSub, subInfo);
                    } else {
                        if (!getSubInfoFromHeader(extraHeaders, subInfo)) {
                            getSubInfoFromNodes(nodes, streamRules, timeRules, subInfo);
                        }
                    }
                    filterNodes(nodes, excludeRemarks, includeRemarks, groupID);
                    for (Proxy x : nodes) {
                        x.groupId = groupID;
                        if (!customGroup.isEmpty()) {
                            x.group = customGroup;
                        }
                    }
                    allNodes.addAll(nodes);
                } else {
                    log.info("Cannot download subscription data.");
                    return -1;
                }*/
                break;
            case LOCAL:
              /*  if (!authorized) {
                    return -1;
                }
                  log.info("Parsing configuration file data...");
                if (explodeConf(link, nodes) == 0) {
                    log.error("Invalid configuration file!");
                    return -1;
                }
                if (strSub.startsWith("ssd://")) {
                    getSubInfoFromSSD(strSub, subInfo);
                } else {
                    getSubInfoFromNodes(nodes, streamRules, timeRules, subInfo);
                }
                filterNodes(nodes, excludeRemarks, includeRemarks, groupID);
                for (Proxy x : nodes) {
                    x.groupId = groupID;
                    if (!customGroup.isEmpty()) {
                        x.group = customGroup;
                    }
                }
                allNodes.addAll(nodes);*/
                break;
            default:
                /*explode(link, node);
                if (node.type == -1) {
                    System.err.println("No valid link found.");
                    return -1;
                }
                node.groupId = groupID;
                if (!customGroup.isEmpty()) {
                    node.group = customGroup;
                }*/
                allNodes.add(node);
        }
        return 0;
    }

    private static int explodeConf(String link, List<Proxy> nodes) {
        return  explodeConfContent(link, nodes);
    }
    public static int explodeConfContent(String content, List<Proxy> nodes) {
        ConfType filetype = ConfType.UNKNOW;

        if (content.contains("\"version\"")) {
            filetype = ConfType.SS;
        } else if (content.contains("\"serverSubscribes\"")) {
            filetype = ConfType.SSR;
        } else if (content.contains("\"uiItem\"") || content.contains("vnext")) {
            filetype = ConfType.V2RAY;
        } else if (content.contains("\"proxy_apps\"")) {
            filetype = ConfType.SSCONF;
        } else if (content.contains("\"idInUse\"")) {
            filetype = ConfType.SSTAP;
        } else if (content.contains("\"local_address\"") && content.contains("\"local_port\"")) {
            filetype = ConfType.SSR;
        } else if (content.contains("\"ModeFileNameType\"")) {
            filetype = ConfType.NETCH;
        }

        switch(filetype) {
            case SS:
                explodeSSConf(content, nodes);
                break;
            case SSR:
//                explodeSSRConf(content, nodes);
                break;
            case V2RAY:
//                explodeVmessConf(content, nodes);
                break;
            case SSCONF:
//                explodeSSAndroid(content, nodes);
                break;
            case SSTAP:
//                explodeSSTap(content, nodes);
                break;
            case NETCH:
//                explodeNetchConf(content, nodes);
                break;
            default:
                //try to parse as a local subscription
//                explodeSub(content, nodes);
        }

        return nodes.size() > 0 ? 1 : 0;
    }
   /* public static void explodeSSRConf(String content, List<Proxy> nodes) {
        Document json = new Document();
        String remarks, group, server, port, method, password, protocol, protoparam, obfs, obfsparam;
        int index = nodes.size();

        json.Parse(content.c_str());
        if(json.HasParseError() || !json.IsObject()) {
            return;
        }

        if(json.HasMember("local_port") && json.HasMember("local_address")) {
            // Single libev config
            Proxy node = new Proxy();
            server = getMember(json, "server");
            port = getMember(json, "server_port");
            remarks = server + ":" + port;
            method = getMember(json, "method");
            obfs = getMember(json, "obfs");
            protocol = getMember(json, "protocol");
            if(ssCiphers.contains(method) && (obfs.isEmpty() || obfs.equals("plain")) && (protocol.isEmpty() || protocol.equals("origin"))) {
                String plugin = getMember(json, "plugin");
                String pluginopts = getMember(json, "plugin_opts");
                ssConstruct(node, SS_DEFAULT_GROUP, remarks, server, port, password, method, plugin, pluginopts);
            } else {
                protoparam = getMember(json, "protocol_param");
                obfsparam = getMember(json, "obfs_param");
                ssrConstruct(node, SSR_DEFAULT_GROUP, remarks, server, port, protocol, method, obfs, password, obfsparam, protoparam);
            }
            nodes.add(node);
            return;
        }

        for (int i = 0; i < json.get("configs").size(); i++) {
            Proxy node = new Proxy();
            group = getMember(json.get("configs").get(i), "group");
            if (group.isEmpty()) {
                group = SSR_DEFAULT_GROUP;
            }
            remarks = getMember(json.get("configs").get(i), "remarks");
            server = getMember(json.get("configs").get(i), "server");
            port = getMember(json.get("configs").get(i), "server_port");
            if (port.equals("0")) {
                continue;
            }
            if (remarks.isEmpty()) {
                remarks = server + ":" + port;
            }

            password = getMember(json.get("configs").get(i), "password");
            method = getMember(json.get("configs").get(i), "method");
            protocol = getMember(json.get("configs").get(i), "protocol");
            protoparam = getMember(json.get("configs").get(i), "protocolparam");
            obfs = getMember(json.get("configs").get(i), "obfs");
            obfsparam = getMember(json.get("configs").get(i), "obfsparam");

            ssrConstruct(node, group, remarks, server, port, protocol, method, obfs, password, obfsparam, protoparam);
            node.setId(index);
            nodes.add(node);
            index++;
        }
    }*/
    private static void explodeSSConf(String content, List<Proxy> nodes) {
        JsonObject json = JsonParser.parseString(content).getAsJsonObject();
        String ps, password, method, server, port, plugin, pluginopts, group = SS_DEFAULT_GROUP;
        int index = nodes.size();

        String section = json.has("servers") ? "servers" : "configs";
        if (!json.has(section)) {
            return;
        }

        group = json.has("remarks") ? json.get("remarks").getAsString() : group;

        for (JsonElement serverConf : json.getAsJsonArray(section)) {
            Proxy node = new Proxy();
            ps = serverConf.getAsJsonObject().get("remarks").getAsString();
            port = serverConf.getAsJsonObject().get("server_port").getAsString();
            if (port.equals("0")) {
                continue;
            }
            if (ps.isEmpty()) {
                server = serverConf.getAsJsonObject().get("server").getAsString();
                ps = server + ":" + port;
            }

            password = serverConf.getAsJsonObject().get("password").getAsString();
            method = serverConf.getAsJsonObject().get("method").getAsString();
            server = serverConf.getAsJsonObject().get("server").getAsString();
            plugin = serverConf.getAsJsonObject().has("plugin") ? serverConf.getAsJsonObject().get("plugin").getAsString() : "";
            pluginopts = serverConf.getAsJsonObject().has("plugin_opts") ? serverConf.getAsJsonObject().get("plugin_opts").getAsString() : "";

            node.Id = index;
//            ssConstruct(node, group, ps, server, port, password, method, plugin, pluginopts);
            nodes.add(node);
            index++;
        }
    }


    public static   boolean isLink(String url) {
        return url.startsWith("https://") || url.startsWith("http://") || url.startsWith("data:");
    }
    public static boolean fileExist(String path, boolean scope_limit) {
        if (scope_limit && !isInScope(path))
            return false;
        File file = new File(path);
        return file.isFile();
    }
    public static boolean isInScope(String path) {
        if (path.startsWith("/") || path.contains("..")) {
            return false;
        }
        return true;
    }
    public static String getSystemProxy() {
        String proxy = "";

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
        } else {
            String[] envs = {"all_proxy", "ALL_PROXY", "http_proxy", "HTTP_PROXY", "https_proxy", "HTTPS_PROXY"};
            for (String env : envs) {
                String value = System.getenv(env);
                if (value != null) {
                    proxy = value;
                    break;
                }
            }
        }

        return proxy;
    }

}
