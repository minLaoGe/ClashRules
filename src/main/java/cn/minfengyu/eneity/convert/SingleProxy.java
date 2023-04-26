package cn.minfengyu.eneity.convert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SingleProxy {
    private String name;
    private String server;
    private int port;

    private String style;
    private String type;
    private String cipher;
    private String password;
    private String plugin;
    private PluginOpts pluginOpts;
    private String uuid;
    private int alterId;
    private boolean tls;
    private String servername;
    private String network;
    private String wsPath;
    private Headers wsHeaders;
    private String grpcOptsGrpcServiceName;
    private String protocol;
    private String obfs;
    private String protocolParam;
    private String obfsParam;
    private String username;
    private String sni;
    private boolean udp;
    private boolean skipCertVerify;
    private int version;
    private ObfsOpts obfsOpts;
    private String psk;
    private WsOpts wsOpts;

    private HttpOpts httpOpts;

    private H2Opts h2Opts;


    private GrpcOpts grpcOpts;







    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static  class H2Opts{
            private String  path;
            private String host;
    }
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static  class GrpcOpts{
            private String  grpcServiceName;

    }



    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static  class HttpOpts{
            private String method="GET";
            private String  path;

            private Headers wsHeaders;
    }


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
    public static class PluginOpts {
        private String mode;
        private String host;
        private String path;
        private boolean tls;
        private boolean mux;
        private Boolean skipCertVerify;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Headers {
        private String Host;
        private String Edge;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ObfsOpts {
        private String mode;
        private String host;
    }
}
