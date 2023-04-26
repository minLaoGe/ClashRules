package cn.minfengyu.enums;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ProxyType {
    Unknow(0),
    Shadowsocks(1),
    ShadowsocksR(2),
    VMess(3),
    Trojan(4),
    Snell(5),
    HTTP(6),
    HTTPS(7),
    SOCKS5(8);

    int order;

    public static ProxyType getProxy(int order) {
        for (ProxyType value : ProxyType.values()) {
           if ( value.getOrder()==order){
               return value;
           }
        }
        return Unknow;
    }
}