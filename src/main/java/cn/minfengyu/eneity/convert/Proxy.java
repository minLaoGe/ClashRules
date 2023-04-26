package cn.minfengyu.eneity.convert;

import cn.minfengyu.enums.ProxyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Proxy {
    public int Type = ProxyType.Unknow.ordinal();
    public int Id = 0;
    public int GroupId = 0;
    public String Group;
    public String Remark;
    public String Hostname;
    public int Port = 0;

    public String Username;
    public String Password;
    public String EncryptMethod;
    public String Plugin;
    public String PluginOption;
    public String Protocol;
    public String ProtocolParam;
    public String OBFS;
    public String OBFSParam;
    public String UserId;
    public int AlterId = 0;
    public String TransferProtocol;
    public String FakeType;
    public boolean TLSSecure = false;

    public String Host;
    public String Path;
    public String Edge;

    public String QUICSecure;
    public String QUICSecret;

    public Tribool UDP;
    public Tribool TCPFastOpen;
    public Tribool AllowInsecure;
    public Tribool TLS13;

    public int SnellVersion = 0;
    public String ServerName;
}