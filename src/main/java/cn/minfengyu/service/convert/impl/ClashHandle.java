package cn.minfengyu.service.convert.impl;

import cn.hutool.core.io.file.FileReader;
import cn.minfengyu.dto.ParseDTO;
import cn.minfengyu.eneity.parse.BaseProxye;
import cn.minfengyu.eneity.parse.VlessProxy;
import cn.minfengyu.eneity.parse.VmessProxy;
import cn.minfengyu.result.BaseResult;
import cn.minfengyu.service.convert.Handle;
import cn.minfengyu.utils.FreeMarkGenerater;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.minfengyu.result.BaseResult;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;

@Component
@Slf4j
public class ClashHandle implements Handle {


    @Autowired
    FreeMarkGenerater freeMarkGenerater;
    @Value("${freemarker.down-url}")
    private String downUrl;






    @Override
    public BaseResult handleLinks(ParseDTO convertDTO) {
        List<String> links = convertDTO.getLinks();
        List<BaseProxye> resultList = new ArrayList<>();
        int order=0;
        for (String link : links) {
            try {
               resultList.add( parseVlessConfig(link.trim(), order++));
            } catch (Exception e) {
                log.error("连接解析失败: {}",link);
            }
        }
        HashMap<String, Object> templateMap = new HashMap<>();

        templateMap.put("proxies",resultList);
        ClassPathResource classPathResource = new ClassPathResource("/clash/rules.text");
        FileReader fileReader = null;
        try {
            fileReader = FileReader.create(classPathResource.getFile());
        } catch (IOException e) {
            log.error("错误了",e);
            return BaseResult.getFail();
        }
        templateMap.put("content",fileReader.readString());
        String s = freeMarkGenerater.generateText(templateMap);
       return BaseResult.getResult(downUrl+s);
    }
    private String getQueryValue(String query, String key) {
        for (String keyValue : query.split("&")) {
            String[] kv = keyValue.split("=");
            if (kv.length == 2 && kv[0].equals(key)) {
                return kv[1];
            }
        }
        return "";
    }
    private BaseProxye parseVlessConfig(String link,int order) throws Exception {
        BaseProxye baseProxye = null;
        String decodedLink =null;
        if (link.startsWith("vless:")){
            link= URLDecoder.decode(link, "UTF-8");
        }else {
            decodedLink=new String(Base64.getDecoder().decode(link.substring(link.indexOf("://") + 3)));
        }
        Gson gson = new Gson();
        if (link.startsWith("vless")) {
            String[] userInfo = link.split("@")[0].split("://")[1].split(":");
            String[] hostPort = link.split("@")[1].split(":");
            String query = link.split("\\?")[1];

            VlessProxy vlessProxy = new VlessProxy();

            vlessProxy.setName(String.valueOf(order));
            vlessProxy.setType("vless");
            vlessProxy.setServer(hostPort[0]);
            vlessProxy.setPort(String.valueOf(hostPort[1].split("\\?")[0]));
            vlessProxy.setUuid(userInfo[0]);
            vlessProxy.setTls(query.contains("security=tls"));
            vlessProxy.setServername( getQueryValue(query, "sni"));
            vlessProxy.setNetwork("ws");
            BaseProxye.WsOpts wsOpts = new BaseProxye.WsOpts();
            wsOpts.setPath( getQueryValue(query, "path"));
            vlessProxy.setWsOpts(wsOpts);
            baseProxye=vlessProxy;
        } else if (link.startsWith("vmess")) {
            JsonObject json = JsonParser.parseString(decodedLink).getAsJsonObject();
            VmessProxy vmessProxy = new VmessProxy(json.get("aid").getAsInt(), "auto");
            vmessProxy.setName(String.valueOf(order));
            vmessProxy.setType("vmess");
            vmessProxy.setServer(json.get("add").getAsString());
            vmessProxy.setPort( json.get("port").getAsString());
            vmessProxy.setUuid(json.get("id").getAsString());
            vmessProxy.setTls("tls".equals(json.get("tls").getAsString()));
            vmessProxy.setNetwork(json.get("net").getAsString());
            vmessProxy.setCipher("auto");

            if ("ws".equals(json.get("net").getAsString())) {
                BaseProxye.WsOpts wsOpts = new BaseProxye.WsOpts();
                wsOpts.setPath( json.get("path").getAsString());
                BaseProxye.Headers headers1 = new BaseProxye.Headers();
                String host = StringUtils.isEmpty(json.get("host").getAsString()) ? json.get("add").getAsString() : json.get("host").getAsString();
                headers1.setHost(host);
                wsOpts.setWsHeaders(headers1);

                vmessProxy.setWsOpts(wsOpts);
            }
            baseProxye=vmessProxy;
        }
        return baseProxye;
    }



}
