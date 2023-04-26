package cn.minfengyu.eneity.parse;

import cn.minfengyu.eneity.convert.SingleProxy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseProxye {
    private String name;
    private String server;
    private String port;
    private String type;
    private String uuid;
    private Boolean tls;
    private String network;
    private String cipher;


    private WsOpts wsOpts;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static  class WsOpts{
        private String path;
        private Headers wsHeaders;
    }


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Headers {
        private String Host;
        private String Edge;
    }
}
