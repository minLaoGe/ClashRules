port: 7890
socks-port: 7891
allow-lan: true
mode: Rule
log-level: info
external-controller: 127.0.0.1:9090
proxies:
<#list proxies as proxy>
  <#if proxy.type == "vless">
    - {name: "${proxy.name}", type: ${proxy.type}, server: ${proxy.server}, port: ${proxy.port}, uuid: ${proxy.uuid}, tls: ${proxy.tls?c}, servername: ${proxy.servername}, network: ${proxy.network}<#if proxy.network == 'ws'>, ws-opts: {path: ${proxy.wsOpts.path}} </#if>}
  <#elseif proxy.type == "vmess">
    - {name: "${proxy.name}", server: ${proxy.server}, port: ${proxy.port}, type: ${proxy.type}, uuid: ${proxy.uuid}, alterId: ${proxy.alterId}, cipher: ${proxy.cipher}, tls: ${proxy.tls?c}, network: ${proxy.network}<#if proxy.network == 'ws'>, ws-opts: {path: ${proxy.wsOpts.path}<#if proxy.wsOpts.wsHeaders.Host?has_content>, headers: {Host: ${proxy.wsOpts.wsHeaders.Host}}</#if>}  </#if>}
  </#if>
</#list>
proxy-groups:
  - name: 🚀 节点选择
    type: select
    proxies:
      - ♻️ 自动选择
      - DIRECT
    <#list proxies as proxy>
      - "${proxy.name}"
    </#list>
  - name: ♻️ 自动选择
    type: url-test
    url: http://www.gstatic.com/generate_204
    interval: 300
    tolerance: 50
    proxies:
    <#list proxies as proxy>
      - "${proxy.name}"
    </#list>
  - name: 🌍 国外媒体
    type: select
    proxies:
      - 🚀 节点选择
      - ♻️ 自动选择
      - 🎯 全球直连
    <#list proxies as proxy>
      - "${proxy.name}"
    </#list>
  - name: 📲 电报信息
    type: select
    proxies:
      - 🚀 节点选择
      - 🎯 全球直连
    <#list proxies as proxy>
      - "${proxy.name}"
    </#list>
  - name: Ⓜ️ 微软服务
    type: select
    proxies:
      - 🎯 全球直连
      - 🚀 节点选择
    <#list proxies as proxy>
      - "${proxy.name}"
    </#list>
  - name: 🍎 苹果服务
    type: select
    proxies:
      - 🚀 节点选择
      - 🎯 全球直连
    <#list proxies as proxy>
      - "${proxy.name}"
    </#list>
  - name: 📢 谷歌FCM
    type: select
    proxies:
      - 🚀 节点选择
      - 🎯 全球直连
      - ♻️ 自动选择
    <#list proxies as proxy>
      - "${proxy.name}"
    </#list>
  - name: 🎯 全球直连
    type: select
    proxies:
      - DIRECT
      - 🚀 节点选择
      - ♻️ 自动选择
  - name: 🛑 全球拦截
    type: select
    proxies:
      - REJECT
      - DIRECT
  - name: 🍃 应用净化
    type: select
    proxies:
      - REJECT
      - DIRECT
  - name: 🐟 漏网之鱼
    type: select
    proxies:
      - 🚀 节点选择
      - 🎯 全球直连
      - ♻️ 自动选择
    <#list proxies as proxy>
      - "${proxy.name}"
    </#list>
rules:
${content}
